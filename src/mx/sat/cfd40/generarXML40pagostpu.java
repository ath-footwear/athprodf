package mx.sat.cfd40;

import DAO.daoempresa;
import DAO.daofactura;
import Modelo.Detpagos;
import Modelo.Empresas;
import Modelo.Formateodedatos;
import Modelo.factura;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.xerces.impl.dv.util.Base64;

public class generarXML40pagostpu {

    //String urlCER = mConfig.getCer();
    //String urlKEY = mConfig.getKey();
    String password = "";

    //String RFC = mConfig.getRFC();
    //String RZ = mConfig.getRZ();
    String RZ = "ATHLETIC FOOTWEAR";
    String RFC = "AFO901221IC2";
    String RF = "601";
    String lugar = "36400";
    String cert = "";
    String keyt = "";
    String salidaxml = "";
    String urlCER = "";
    String urlKEY = "";
    String rela = "";
    //String RF = mConfig.getRF();

    public void crearComprobante(xmlDAO encabezado, Connection con, Connection empresa) throws Exception {
        // Obtener y asignar datos dee la empresa ej, rfc y nombre etc...
        getempresa(empresa, encabezado.getEmpresa());

        XMLGregorianCalendar fecha = null;
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(sdf.format(date));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(generarXML40pagostpu.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectFactory of = new ObjectFactory();
        Comprobante xml = of.createComprobante();
        Formateodedatos fd = new Formateodedatos();

        //Datos generales
        xml.setVersion("4.0");
        xml.setExportacion("01");
        xml.setSerie(fd.SerieFiscal_PAG(encabezado.getTurno()));
        xml.setFolio(encabezado.getFolio());
        xml.setFecha(fecha);
        //Totales, tipo comprobante
        xml.setSubTotal(encabezado.getSubT().setScale(0, RoundingMode.HALF_UP));
        //xml.setDescuento(encabezado.getDescuento().setScale(2, RoundingMode.HALF_UP));
        xml.setMoneda(CMoneda.XXX);
        // xml.setTipoCambio(objDAO.getTipoC());
        xml.setTotal(encabezado.getTotal().setScale(0, RoundingMode.HALF_UP));
        //Identificar y asignar si es un egreso o ingreso
        xml.setTipoDeComprobante(CTipoDeComprobante.P);

//        switch (encabezado.getMetodoPago()) {
//            case "PUE":
//                xml.setMetodoPago(CMetodoPago.PUE);
//                break;
//            case "PPD":
//                xml.setMetodoPago(CMetodoPago.PPD);
//                break;
//            case "PIP":
//                xml.setMetodoPago(CMetodoPago.PIP);
//                break;
//        }
        xml.setLugarExpedicion(lugar);

        //Datos del emisor
        xml.setEmisor(createEmisor(of));

        //Datos del receptor
        xml.setReceptor(createReceptor(of, encabezado));

        //Conceptos
        xml.setConceptos(createConceptos(of));

        //Impuestos en pagos no aplica ya en el complemento tienen sus propios impuestos
        //xml.setImpuestos(createImpuestos(of, encabezado));
        //Extraer archivos .cer  .key
        File cer = new File(urlCER);
        File key = new File(urlKEY);

        //Datos del Complemento
        xml.setComplemento(createcomplemento(of, encabezado, fecha));

        //Agregar certificado y no. de certificado al comprobante por medio del archivo .cer del contribuyente
        X509Certificate x509Cer = getX509Certificate(cer);// Metodo de sellado
        String certificado = getCertificadoBase64(x509Cer);
        String noCertificado = getNoCertificado(x509Cer);
        xml.setCertificado(certificado);//añadir al comprobante
        xml.setNoCertificado(noCertificado);

        //Despues de asignar los valores al xml, guardar el comprobante y realizar el sellado digital
        String cadenaXML = jaxbObjectToXML(xml);

        String cadenaOriginal = "";
        PrivateKey llavePrivada = null;
        String selloDigital = "";

        try {
            cadenaOriginal = generarCadenaOriginal(cadenaXML);
        } catch (TransformerException ex) {
            Logger.getLogger(generarXML40pagostpu.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Utilizar el archivo .key del contribuyente, ademas de la contraseña correspondiente
        llavePrivada = getPrivateKey(key, password);

        //Asignar el sello digital como texto
        selloDigital = generarSelloDigital(llavePrivada, cadenaOriginal);

        //Agregar el sello digital al xml
        xml.setSello(selloDigital);

        String COMPROBANTE_XML = salidaxml + "\\" + encabezado.getSerie() + "_" + encabezado.getFolio() + ".xml";

//Actualizar datos en la Base de datos para despliegue de factura
        daofactura df = new daofactura();
        factura f = new factura();
        f.setCertificado(noCertificado);
        f.setSello(selloDigital);
        f.setCadenaorig(cadenaOriginal);
        f.setId(encabezado.getIddocumentos());
        df.actualizacadenapagotpu(con, f);
//Fin actualizacion de datos        

        JAXBContext context = JAXBContext.newInstance(Comprobante.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DeafultNamespacePrefixMapper());
        NamespacePrefixMapper prefixMapper = new DeafultNamespacePrefixMapper();
        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd http://www.sat.gob.mx/Pagos20 http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos20.xsd");

        //Compilar
        m.marshal(xml, new File(COMPROBANTE_XML));

    }

    private void getempresa(Connection c, String n) {
        daoempresa d = new daoempresa();
        Empresas e = d.getempresarfc(c, n);
        password = e.getPass();
        RZ = e.getNombre();
        RFC = e.getRfc();
        RF = e.getRegimen();
        lugar = e.getCp();
        urlCER = e.getCertificado();
        urlKEY = e.getKey();
        salidaxml = e.getXml();
    }

    //Metodos
    private Comprobante.Emisor createEmisor(ObjectFactory of) {//Emisor
        Comprobante.Emisor emisor = of.createComprobanteEmisor();
        emisor.setRegimenFiscal(RF);
        emisor.setNombre(RZ);
        emisor.setRfc(RFC);
        return emisor;
    }
//Falta Setear correctamente el prefijo antes de cada tag
// Nodos implementados manualmente a la clase COmprobante

    private Comprobante.Complemento createcomplemento(ObjectFactory of, xmlDAO f, XMLGregorianCalendar fecha) {//Complemento
        Comprobante.Complemento comp = of.createComprobanteComplemento();// Complemento Base
        Comprobante.Complemento.Pagos p = of.createComprobanteComplementoPago();
        Comprobante.Complemento.Pagos.Totales totales = of.createComprobanteComplementoPagosTotales();
        Comprobante.Complemento.Pagos.Pago pago = of.createComprobanteComplementoPagosPago();
        //Totales con formato 0.00
//        Cambio a la parte de la condicional ya que si es USD no se utilizan varios valores para los totales generales

//        totales.setMontoTotalPagos(BigDecimal.valueOf(f.getTotalpago16() + f.getTotalpago17()).setScale(2, RoundingMode.FLOOR));
//        totales.setTotalTrasladosImpuestoIVA16(BigDecimal.valueOf(f.getImpiva16() + f.getImpiva17()).setScale(2, RoundingMode.FLOOR));
//        totales.setTotalTrasladosBaseIVA16(BigDecimal.valueOf(f.getBaseiva16() + f.getBaseiva17()).setScale(2, RoundingMode.FLOOR));
        //pago
        // usar por si no funciona la funcion de la linea 273 pago.getDoctoRelacionado().add(doc);
//        List<Comprobante.Complemento.Pagos.Pago> arr = p.getPago();
        pago.setFechaPago(fecha);
        pago.setFormaDePagoP(f.getFormaP());
        if (f.getMoneda().equals("MXN")) {
            totales.setMontoTotalPagos(BigDecimal.valueOf(f.getTotalpago16()).setScale(2));
            totales.setTotalTrasladosImpuestoIVA16(BigDecimal.valueOf(f.getImpiva16()).setScale(2));
            totales.setTotalTrasladosBaseIVA16(BigDecimal.valueOf(f.getBaseiva16()).setScale(2));
            pago.setMonedaP(CMoneda.MXN);
            pago.setTipoCambioP(BigDecimal.valueOf(1));
        } else {
//            totales.setMontoTotalPagos(BigDecimal.valueOf(f.getTotalpago16() * f.getTipoC().doubleValue()).setScale(2));
//            totales.setTotalTrasladosBaseIVA0((BigDecimal.valueOf(f.getBaseiva16() * f.getTipoC().doubleValue()).setScale(2)));
//            totales.setTotalTrasladosImpuestoIVA0(BigDecimal.valueOf(0.16).setScale(2));
//            pago.setMonedaP(CMoneda.USD);
//            pago.setTipoCambioP(f.getTipoC());
            totales.setMontoTotalPagos(BigDecimal.valueOf(f.getTotalpago16()).setScale(2, RoundingMode.HALF_UP));
            totales.setTotalTrasladosBaseIVA16((BigDecimal.valueOf(f.getBaseiva16()).setScale(2, RoundingMode.HALF_UP)));
            totales.setTotalTrasladosImpuestoIVA16(BigDecimal.valueOf(f.getImpiva16()).setScale(2, RoundingMode.HALF_UP));
            pago.setMonedaP(CMoneda.USD);
            pago.setTipoCambioP(f.getTipoC());
        }

        pago.setMonto(BigDecimal.valueOf(f.getMonto()).setScale(2));
//        pago.setMonto(BigDecimal.valueOf(f.getTotalpago16()).setScale(2, RoundingMode.FLOOR));

        pago.setNumOperacion(f.getFolio());
//        List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado> arrrel = pago.getDoctoRelacionado();
//  Lista de documentos relacionados Arraylist de documentos
//        for (int i = 0; i < des.size(); i++) {
        BigDecimal importedrp = BigDecimal.ZERO;
        BigDecimal basep = BigDecimal.ZERO;
        for (int i = 0; i < f.getArrpagos().size(); i++) {// prueba con 1 elemento random
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado doc = of.createComprobanteComplementoPagosPagoDocs();
            doc.setFolio(f.getArrpagos().get(i).getRef());
            doc.setSerie("FACTPU");
            doc.setIdDocumento(f.getArrpagos().get(i).getUuid());
            doc.setObjetoImpDR("02");
            doc.setEquivalenciaDR(BigDecimal.ONE);
            if (f.getMoneda().equals("MXN")) {
                doc.setMonedaDR(CMoneda.MXN);
            } else {
                doc.setMonedaDR(CMoneda.USD);
            }
            doc.setImpSaldoInsoluto(BigDecimal.valueOf(f.getArrpagos().get(i).getImpsaldoinsoluto()).setScale(2));
            doc.setImpSaldoAnt(BigDecimal.valueOf(f.getArrpagos().get(i).getImportesaldoant()).setScale(2));
            doc.setImpPagado(BigDecimal.valueOf(f.getArrpagos().get(i).getImportepagado()).setScale(2));
//            doc.setImpSaldoInsoluto(BigDecimal.valueOf(f.getArrpagos().get(i).getImpsaldoinsoluto()).setScale(2, RoundingMode.FLOOR));
//            doc.setImpSaldoAnt(BigDecimal.valueOf(f.getArrpagos().get(i).getImportesaldoant()).setScale(2, RoundingMode.FLOOR));
//            doc.setImpPagado(BigDecimal.valueOf(f.getArrpagos().get(i).getImportepagado()).setScale(2, RoundingMode.FLOOR));
//            doc.setEquivalenciaDR(BigDecimal.ONE);
            doc.setNumParcialidad(BigInteger.valueOf(f.getArrpagos().get(i).getParcialidad()));
            //Impuestos por documento
            //Crear ImpuestosDR, TrasladosDR y TrasladoDR
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR impdr = of.createComprobanteComplementoPagosPagoDocsImpuestoDR();
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR trasladosdr = of.createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDR();
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR tr = of.createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDRTrasladoDR();
            tr.setTipoFactorDR(CTipoFactor.TASA);
            tr.setImpuestoDR("002");
            tr.setBaseDR(BigDecimal.valueOf(f.getArrpagos().get(i).getImportepagado() / 1.16).setScale(6, RoundingMode.HALF_UP));
            if (f.getMoneda().equals("MXN")) {
                tr.setTasaOCuotaDR(f.getTasaCuota());
                tr.setImporteDR(BigDecimal.valueOf((f.getArrpagos().get(i).getImportepagado() / 1.16) * 0.16).setScale(2, RoundingMode.HALF_UP));
            } else {
//                tr.setTasaOCuotaDR(BigDecimal.valueOf(0.000000).setScale(6, RoundingMode.HALF_UP));
//                tr.setImporteDR(BigDecimal.valueOf(0.00).setScale(2));
                tr.setTasaOCuotaDR(f.getTasaCuota());
                tr.setImporteDR(BigDecimal.valueOf((f.getArrpagos().get(i).getImportepagado() / 1.16) * 0.16).setScale(2, RoundingMode.HALF_UP));
            }
            //sumar cada una de los importas y bases
            importedrp = importedrp.add(tr.getImporteDR());
            basep = basep.add(tr.getBaseDR());
//            tr.setImporteDR(BigDecimal.valueOf((f.getArrpagos().get(i).getImportepagado() / 1.16) * 0.16).setScale(6, RoundingMode.FLOOR));
//            tr.setBaseDR(BigDecimal.valueOf(f.getArrpagos().get(i).getImportepagado() / 1.16).setScale(6, RoundingMode.HALF_UP));
            trasladosdr.getTrasladoDR().add(tr);
            impdr.setTrasladosDR(trasladosdr);//traslado
            doc.setImpuestosDR(impdr);//Nodo con valor de ImpuestoDR
            pago.getDoctoRelacionado().add(doc);//agregar objeto al pago
        }
        //Fin de documentos relacionados e impuestos DR
        //Final del documento impuestoP
        //                                                  Crear ImpuestosP, TrasladosP y Traslado
        Comprobante.Complemento.Pagos.Pago.ImpuestosP impuestos = of.createComprobanteComplementoPagosPagoImpuestoP();
        Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP trasladosp = of.createComprobanteComplementoPagosPagoImpuestoPTrasladosP();
        Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP trasladop = of.createComprobanteComplementoPagosPagoImpuestoPTrasladosPTrasladoP();
        trasladop.setTipoFactorP(CTipoFactor.TASA);

        trasladop.setImpuestoP("002");

        if (f.getMoneda().equals("MXN")) {
            trasladop.setTasaOCuotaP(f.getTasaCuota());
            trasladop.setImporteP(BigDecimal.valueOf(f.getImpiva16()).setScale(6, RoundingMode.HALF_UP));
            trasladop.setBaseP(BigDecimal.valueOf(f.getBaseiva16()).setScale(2, RoundingMode.HALF_UP));
        } else {
//            trasladop.setTasaOCuotaP(BigDecimal.valueOf(0.000000));
//            trasladop.setImporteP(BigDecimal.valueOf(0.00).setScale(6));
            trasladop.setTasaOCuotaP(f.getTasaCuota());
            trasladop.setImporteP(importedrp.setScale(6, RoundingMode.HALF_UP));
            trasladop.setBaseP(basep.setScale(2, RoundingMode.HALF_UP));
        }
//        trasladop.setImporteP(BigDecimal.valueOf(f.getImpiva16()).setScale(2, RoundingMode.FLOOR));
//        trasladop.setBaseP(BigDecimal.valueOf(f.getBaseiva16()).setScale(2, RoundingMode.HALF_UP));
        trasladosp.getTrasladoP().add(trasladop);
        impuestos.setTrasladosP(trasladosp);
        //Termino de impuestosP
        //setear impuestos a pago
        pago.setImpuestosP(impuestos);
        p.setVersion("2.0");
        p.setTotales(totales);// seteo de totales
        p.getPago().add(pago);
//        p.getPago().add(pago17);
        comp.setPagos(p);

        return comp;
    }

    /**
     * Formatea datos dee acuerdo al numero de decimales que en est caso es 6
     *
     * @param cant
     * @return
     */
    private double formatdecimal(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(BigDecimal.valueOf(cant).setScale(3, RoundingMode.HALF_UP));
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 7) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato < 5)) {
            resp = BigDecimal.valueOf(cant).setScale(6, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(6, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    private double formatdecimal2(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(cant);
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato <= 5)) {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    private Comprobante.Receptor createReceptor(ObjectFactory of, xmlDAO obj) {//Receptor
        Comprobante.Receptor receptor = of.createComprobanteReceptor();
        receptor.setNombre(obj.getReceptor());
        receptor.setRfc(obj.getRfcR());

        switch (obj.getUsoCfdi()) {
            case "G01":
                receptor.setUsoCFDI(CUsoCFDI.G_01);
                break;
            case "G03":
                receptor.setUsoCFDI(CUsoCFDI.G_03);
                break;
            case "P01":
                receptor.setUsoCFDI(CUsoCFDI.P_01);
                break;
            case "G02":
                receptor.setUsoCFDI(CUsoCFDI.G_02);
                break;
            case "D01":
                receptor.setUsoCFDI(CUsoCFDI.D_01);
                break;
            case "S01":
                receptor.setUsoCFDI(CUsoCFDI.S_01);
                break;
            case "CP01":
                receptor.setUsoCFDI(CUsoCFDI.CP_01);
                break;
            case "I08":
                receptor.setUsoCFDI(CUsoCFDI.I_08);
                break;
            case "I04":
                receptor.setUsoCFDI(CUsoCFDI.I_04);
                break;
            case "D04":
                receptor.setUsoCFDI(CUsoCFDI.D_04);
                break;

        }
        receptor.setRegimenFiscalReceptor(obj.getRegimenFR());
        receptor.setDomicilioFiscalReceptor(obj.getDomicilioReceptor());
        return receptor;
    }

    private Comprobante.Conceptos createConceptos(ObjectFactory of) {//conceptos
        Comprobante.Conceptos cps = of.createComprobanteConceptos();
        List<Comprobante.Conceptos.Concepto> list = cps.getConcepto();
//Esta parte es toda fija y quizas no cambia hasta mas al futuro
        Comprobante.Conceptos.Concepto c = of.createComprobanteConceptosConcepto();

        c.setObjetoImp("01");
        c.setImporte(BigDecimal.valueOf(0));
        c.setValorUnitario(BigDecimal.valueOf(0));
        c.setDescripcion("Pago");
        c.setClaveUnidad("ACT");
        c.setCantidad(BigDecimal.valueOf(1));
        c.setClaveProdServ("84111506");
        list.add(c);
        return cps;
    }

    private Comprobante.Conceptos.Concepto.Impuestos createImpuestosConcepto(ObjectFactory of, BigDecimal importe, BigDecimal base, String imp, BigDecimal TasaC) {

        Comprobante.Conceptos.Concepto.Impuestos imps = of.createComprobanteConceptosConceptoImpuestos();

        //Bloque para impuestos trasladados
        Comprobante.Conceptos.Concepto.Impuestos.Traslados trs = of.createComprobanteConceptosConceptoImpuestosTraslados();
        List<Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado> list = trs.getTraslado();
        Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado t1 = of.createComprobanteConceptosConceptoImpuestosTrasladosTraslado();
        t1.setImporte(importe.setScale(2, RoundingMode.HALF_UP));//Impuesto del renglon
        t1.setBase(base.setScale(2, RoundingMode.HALF_UP));//Total del renglon
        t1.setImpuesto(imp);
        t1.setTipoFactor(CTipoFactor.TASA);
        t1.setTasaOCuota(TasaC);

        list.add(t1);

        imps.setTraslados(trs);

        return imps;
    }

    private Comprobante.Impuestos createImpuestos(ObjectFactory of, xmlDAO obj) {// impuestos trasladados
        Comprobante.Impuestos impus = of.createComprobanteImpuestos();
        impus.setTotalImpuestosTrasladados(obj.getTotalImpuesto());

        //Bloque para los impuestos trasladados
        Comprobante.Impuestos.Traslados tras = of.createComprobanteImpuestosTraslados();
        List<Comprobante.Impuestos.Traslados.Traslado> list = tras.getTraslado();
        Comprobante.Impuestos.Traslados.Traslado t1 = of.createComprobanteImpuestosTrasladosTraslado();
        t1.setImporte(obj.getTotalImpuesto().setScale(2, RoundingMode.HALF_UP));
        t1.setBase(obj.getBaseImpuesto().setScale(2, RoundingMode.HALF_UP));
        t1.setTasaOCuota(obj.getTasaCuota());
        t1.setTipoFactor(CTipoFactor.TASA);
        t1.setImpuesto(obj.getImpuesto());
        list.add(t1);
        impus.setTraslados(tras);
        return impus;
    }

    //Metodos de sellado
    private X509Certificate getX509Certificate(final File certificateFile) throws CertificateException, IOException {
        FileInputStream is = null;

        try {
            is = new FileInputStream(certificateFile);
            CertificateFactory of = CertificateFactory.getInstance("X.509");
            return (X509Certificate) of.generateCertificate(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private String getCertificadoBase64(final X509Certificate cert) throws CertificateEncodingException {
        return new String(Base64.encode(cert.getEncoded()));
    }

    private String getNoCertificado(final X509Certificate cert) {
        BigInteger serial = cert.getSerialNumber();
        byte[] sArr = serial.toByteArray();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < sArr.length; i++) {
            buffer.append((char) sArr[i]);
        }

        return buffer.toString();
    }

    private String jaxbObjectToXML(Comprobante xml) {
        String xmlString = "";

        try {
            JAXBContext context = JAXBContext.newInstance(Comprobante.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(xml, sw);
            xmlString = sw.toString();

        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return xmlString;
    }

    private String generarCadenaOriginal(final String xml) throws TransformerException {
        StreamSource streamS = new StreamSource("C:/af/filesfac/cadenaoriginal_4_0.xslt");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer xlsTransformer = transformerFactory.newTransformer(streamS);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        xlsTransformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(output));

        String resultado = "";

        try {
            resultado = output.toString("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40pagostpu.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    private PrivateKey getPrivateKey(final File keyFile, final String password) throws GeneralSecurityException, IOException {

        FileInputStream in = new FileInputStream(keyFile);
        org.apache.commons.ssl.PKCS8Key pkcs8 = new org.apache.commons.ssl.PKCS8Key(in, password.toCharArray());

        byte[] decrypted = pkcs8.getDecryptedBytes();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
        PrivateKey pk;

        if (pkcs8.isDSA()) {
            pk = KeyFactory.getInstance("DSA").generatePrivate(spec);
        } else if (pkcs8.isRSA()) {
            pk = KeyFactory.getInstance("RSA").generatePrivate(spec);
        }

        pk = pkcs8.getPrivateKey();
        return pk;
    }

    private String generarSelloDigital(final PrivateKey key, final String cadenaOriginal)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {

        Signature sing = Signature.getInstance("SHA256withRSA");
        sing.initSign(key, new SecureRandom());

        try {
            sing.update(cadenaOriginal.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40pagostpu.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] signature = sing.sign();
        return new String(Base64.encode(signature));
    }

    private double getnewcantidades6(double a, String tipo) {
        double cant = 0;
        switch (tipo) {
            case "importe":
                cant = BigDecimal.valueOf(a).setScale(6, RoundingMode.HALF_UP).doubleValue() / 1.16;
                break;
            case "iva":
                cant = (BigDecimal.valueOf(a).setScale(6, RoundingMode.HALF_UP).doubleValue() / 1.16) * 0.16;
                break;
        }
        return cant;
    }

    private double getnewcantidades(double a, String tipo) {
        double cant = 0;
        switch (tipo) {
            case "importe":
                cant = BigDecimal.valueOf(a).setScale(6, RoundingMode.HALF_UP).doubleValue() / 1.16;
                break;
            case "iva":
                cant = (BigDecimal.valueOf(a).setScale(6, RoundingMode.HALF_UP).doubleValue() / 1.16) * 0.16;
                break;
        }
        cant = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return cant;
    }

    private double getcant16(double a) {
        double cant = BigDecimal.valueOf(a).setScale(6, RoundingMode.HALF_UP).doubleValue();
        return cant;
    }

    private double getcant(double a) {
        double cant = BigDecimal.valueOf(a).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return cant;
    }
}
