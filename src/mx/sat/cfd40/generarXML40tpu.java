package mx.sat.cfd40;

import DAO.daoempresa;
import DAO.daofactura;
import Modelo.Empresas;
import Modelo.Formateo_Nempresas;
import Modelo.Formateodedatos;
import Modelo.factura;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;

public class generarXML40tpu {

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
    BigDecimal desc = BigDecimal.ZERO;
    //String RF = mConfig.getRF();

    /**
     *
     * @param encabezado
     * @param data
     * @param con
     * @param empresa
     * @throws Exception
     */
    public void crearComprobante(xmlDAO encabezado, ArrayList<xmlDAO> data, Connection con, Connection empresa) throws Exception {
        // Obtener y asignar datos dee la empresa ej, rfc y nombre etc...
        getempresa(empresa, encabezado.getEmpresa());
//        getempresa(empresa, "2");
        rela = encabezado.getRelacion();

        XMLGregorianCalendar fecha = null;
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(sdf.format(date));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(generarXML40tpu.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectFactory of = new ObjectFactory();
        Comprobante xml = of.createComprobante();
        Formateodedatos fd = new Formateodedatos();
        //Datos generales
        xml.setVersion("4.0");
        xml.setExportacion(encabezado.getExportacion());
        //Se usa la serie adecuada de acuerdo a la empresa y el turno del usuario
        xml.setSerie(fd.SerieFiscal(encabezado.getTurno()));
        xml.setFolio(encabezado.getFolio());
        xml.setFecha(fecha);
        xml.setFormaPago(encabezado.getFormaP());
        xml.setCondicionesDePago(encabezado.getDescripcionP());
        if (encabezado.getDescuento() != BigDecimal.ZERO) {
            xml.setDescuento(encabezado.getDescuento().setScale(2));
            desc = encabezado.getDescuento();
        }
        //Totales, tipo comprobante
        xml.setSubTotal(encabezado.getSubT().setScale(2));

        //Tipo de moneda y Tipo de cambio
        switch (encabezado.getMoneda()) {
            case "MXN":
                xml.setMoneda(CMoneda.MXN);
                break;
            case "USD":
                xml.setMoneda(CMoneda.USD);
                xml.setTipoCambio(encabezado.getTipoC().setScale(2, RoundingMode.HALF_UP));
                break;
        }
        xml.setTotal(encabezado.getTotal().setScale(2));
        //Identificar y asignar si es un egreso o ingreso
        if (encabezado.getSerie().equals("FAC")) {
            xml.setTipoDeComprobante(CTipoDeComprobante.I);
        } else if (encabezado.getSerie().equals("NCR")) {
            xml.setTipoDeComprobante(CTipoDeComprobante.E);
        } else {
            xml.setTipoDeComprobante(CTipoDeComprobante.P);
        }
        if (encabezado.getSerie().equals("FAC") && !encabezado.getRelacion().equals("")) {
            xml.setTipoDeComprobante(CTipoDeComprobante.I);
        }
//      Fin asignar tipo de comprobante
        switch (encabezado.getMetodoPago()) {
            case "PUE":
                xml.setMetodoPago(CMetodoPago.PUE);
                break;
            case "PPD":
                xml.setMetodoPago(CMetodoPago.PPD);
                break;
            case "PIP":
                xml.setMetodoPago(CMetodoPago.PIP);
                break;
        }

        xml.setLugarExpedicion(lugar);

        //Datos del emisor
        xml.setEmisor(createEmisor(of));

        //Datos del receptor
        xml.setReceptor(createReceptor(of, encabezado));

        //Conceptos
        xml.setConceptos(createConceptos(of, data));

        //Impuestos
        xml.setImpuestos(createImpuestos(of, encabezado));

        //Extraer archivos .cer  .key
        File cer = new File(urlCER);
        File key = new File(urlKEY);
        //relacionados se agrega solo si es requerido
        if (!encabezado.getRelacion().equals("")) {
            xml.cfdiRelacionados = createrelacionados(of, encabezado.getArruuid(), encabezado.getRelacion());
        }

        //Agregar certificado y no. de certificado al comprobante por medio del archivo .cer del contribuyente
        Formateo_Nempresas fn = new Formateo_Nempresas();
        X509Certificate x509Cer = fn.getX509Certificate(cer);// Metodo de sellado
        String certificado = fn.getCertificadoBase64(x509Cer);
        String noCertificado = fn.getNoCertificado(x509Cer);
        xml.setCertificado(certificado);//añadir al comprobante
        xml.setNoCertificado(noCertificado);

        //Despues de asignar los valores al xml, guardar el comprobante y realizar el sellado digital
        String cadenaXML = fn.jaxbObjectToXML(xml);

        String cadenaOriginal = "";
        PrivateKey llavePrivada = null;
        String selloDigital = "";

        try {
            cadenaOriginal = fn.generarCadenaOriginal(cadenaXML);
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(null, "generarxml -" + ex);
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Utilizar el archivo .key del contribuyente, ademas de la contraseña correspondiente
        llavePrivada = fn.getPrivateKey(key, password);

        //Asignar el sello digital como texto
        selloDigital = fn.generarSelloDigital(llavePrivada, cadenaOriginal);

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
        df.actualizacadenatpu(con, f);
//Fin actualizacion de datos        

        JAXBContext context = JAXBContext.newInstance(Comprobante.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DeafultNamespacePrefixMapper());
        NamespacePrefixMapper prefixMapper = new DeafultNamespacePrefixMapper();
        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd http://www.sat.gob.mx/Pagos20");

        //Compilar
        m.marshal(xml, new File(COMPROBANTE_XML));

    }

    private void getempresa(Connection c, String n) {
        daoempresa d = new daoempresa();
        System.out.println(c.toString() + " " + n);
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
//informacion gloobal

    private Comprobante.InformacionGlobal createInfoglobal(ObjectFactory of) {//Emisor
        Comprobante.InformacionGlobal al = of.createComprobanteInformacionGlobal();
        al.setMeses("asd");
        al.setAño(Short.valueOf("2022"));
        al.setPeriodicidad("mensual");

        return al;
    }
//Falta Setear correctamente el prefijo antes de cada tag
// Nodos implementados manualmente a la clase COmprobante falta por implementar

    private Comprobante.Complemento createcomplemento(ObjectFactory of, ArrayList<xmlDAO> des, XMLGregorianCalendar fecha) {//Complemento
        Comprobante.Complemento comp = of.createComprobanteComplemento();// Complemento Base
        Comprobante.Complemento.Pagos p = of.createComprobanteComplementoPago();
        Comprobante.Complemento.Pagos.Totales totales = of.createComprobanteComplementoPagosTotales();
        Comprobante.Complemento.Pagos.Pago pago = of.createComprobanteComplementoPagosPago();
        //Totales
        totales.setMontoTotalPagos(BigDecimal.ONE);
        totales.setTotalTrasladosImpuestoIVA16(BigDecimal.ONE);
        totales.setTotalTrasladosBaseIVA16(BigDecimal.ONE);
        //pago
        // usar por si no funciona la funcion de la linea 273 pago.getDoctoRelacionado().add(doc);
//        List<Comprobante.Complemento.Pagos.Pago> arr = p.getPago();
        pago.setFechaPago(fecha);
        pago.setFormaDePagoP("99");
        pago.setMonedaP(CMoneda.MXN);
        pago.setMonto(BigDecimal.ONE);
        pago.setTipoCambioP(BigDecimal.valueOf(1));
//        List<Comprobante.Complemento.Pagos.Pago.DoctoRelacionado> arrrel = pago.getDoctoRelacionado();
//  Lista de documentos relacionados Arraylist de documentos
//        for (int i = 0; i < des.size(); i++) {
        for (int i = 0; i < 1; i++) {// prueba con 1 elemento random
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado doc = of.createComprobanteComplementoPagosPagoDocs();
            doc.setFolio("1025");
            doc.setIdDocumento("65654-45645654654-5466-56854");
            doc.setMonedaDR(CMoneda.MXN);
            doc.setImpSaldoInsoluto(BigDecimal.ONE);
            doc.setImpSaldoAnt(BigDecimal.ONE);
            doc.setImpPagado(BigDecimal.ONE);
            doc.setEquivalenciaDR(BigDecimal.ONE);
            //Impuestos por documento
            //Crear ImpuestosDR, TrasladosDR y TrasladoDR
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR impdr = of.createComprobanteComplementoPagosPagoDocsImpuestoDR();
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR trasladosdr = of.createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDR();
            Comprobante.Complemento.Pagos.Pago.DoctoRelacionado.ImpuestosDR.TrasladosDR.TrasladoDR tr = of.createComprobanteComplementoPagosPagoDocsImpuestoDRTrasladosDRTrasladoDR();
            tr.setTipoFactorDR(CTipoFactor.TASA);
            tr.setTasaOCuotaDR(BigDecimal.ONE);
            tr.setImpuestoDR("002");
            tr.setImporteDR(BigDecimal.ONE);
            tr.setBaseDR(BigDecimal.ONE);
            trasladosdr.getTrasladoDR().add(tr);
            impdr.setTrasladosDR(trasladosdr);//traslado
            doc.setImpuestosDR(impdr);//Nodo con valor de ImpuestoDR
            pago.getDoctoRelacionado().add(doc);//agregar objeto al pago
        }
        //Fin de documentos relacionados e impuestos DR
        //Final del documento impuestoP
        //Crear ImpuestosP, TrasladosP y Traslado
        Comprobante.Complemento.Pagos.Pago.ImpuestosP impuestos = of.createComprobanteComplementoPagosPagoImpuestoP();
        Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP trasladosp = of.createComprobanteComplementoPagosPagoImpuestoPTrasladosP();
        Comprobante.Complemento.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP trasladop = of.createComprobanteComplementoPagosPagoImpuestoPTrasladosPTrasladoP();
        trasladop.setTipoFactorP(CTipoFactor.TASA);
        trasladop.setTasaOCuotaP(BigDecimal.ONE);
        trasladop.setImpuestoP("002");
        trasladop.setImporteP(BigDecimal.ONE);
        trasladop.setBaseP(BigDecimal.ONE);
        trasladosp.getTrasladoP().add(trasladop);
        impuestos.setTrasladosP(trasladosp);
        //Termino de impuestosP
        //setear impuestos a pago
        pago.setImpuestosP(impuestos);
        p.setVersion("2.0");
        p.setTotales(totales);// seteo de totales
        p.getPago().add(pago);
        comp.setPagos(p);

        //Cosas de prueba :v
//        mx.sat.pagos.ObjectFactory of2 = new mx.sat.pagos.ObjectFactory();
//        mx.sat.pagos.Pagos pagos = of2.createPagos();
//        pagos.setVersion("2.0");
//        mx.sat.pagos.Pagos.Pago pago = of2.createPagosPago();
//        
////        
//        mx.sat.pagos.Pagos.Pago.DoctoRelacionado rel = of2.createPagosPagoDoctoRelacionado();
//        rel.setSerie("PAG");
//        rel.setFolio("4654654-5464-1315-6548987");
//        rel.setNumParcialidad(BigInteger.valueOf(1));
//        rel.setImpSaldoAnt(BigDecimal.valueOf(1205));
//        rel.setImpPagado(BigDecimal.valueOf(1205));
//        rel.setImpSaldoInsoluto(BigDecimal.valueOf(0));
//        rel.setMonedaDR(mx.sat.pagos.CMoneda.MXN);
//        rel.setIdDocumento("4654654-5464-1315-6548987");
//        pago.getDoctoRelacionado().add(rel);
//        
//        mx.sat.pagos.Pagos.Totales t = of2.createPagosTotales();
//        t.setMontoTotalPagos(BigDecimal.ONE);
//        mx.sat.pagos.Pagos.Pago.ImpuestosP imp = of2.createPagosPagoImpuestosP();
//        mx.sat.pagos.Pagos.Pago.ImpuestosP.TrasladosP traslados = of2.createPagosPagoImpuestosPTrasladosP();
//        mx.sat.pagos.Pagos.Pago.ImpuestosP.TrasladosP.TrasladoP traslado = of2.createPagosPagoImpuestosPTrasladosPTrasladoP();
//        traslado.setBaseP(BigDecimal.ONE);
//        traslado.setImporteP(BigDecimal.ONE);
//        traslado.setImpuestoP(urlCER);
//        traslado.setTasaOCuotaP(BigDecimal.ONE);
//        traslado.setTipoFactorP(mx.sat.pagos.CTipoFactor.TASA);
//        traslados.getTrasladoP().add(traslado);
//        imp.setTrasladosP(traslados);
//        pago.setImpuestosP(imp);
//
////        
////        rel= of2.createPagosPagoDoctoRelacionado();
////        rel.setFolio("4654654-5464-1315-6548987");
////        rel.setNumParcialidad(BigInteger.valueOf(1));
////        rel.setImpSaldoAnt(BigDecimal.valueOf(1205));
////        rel.setImpPagado(BigDecimal.valueOf(1205));
////        rel.setImpSaldoInsoluto(BigDecimal.valueOf(0));
////        pago.getDoctoRelacionado().add(rel);
//
//        comp.setPagos(pagos);
////        
        return comp;
    }

    //Relaciones NCR Y FACTURAS :D
    private List<Comprobante.CfdiRelacionados> createrelacionados(ObjectFactory of, ArrayList<String> data, String relacion) {
        List<Comprobante.CfdiRelacionados> arr = new ArrayList<Comprobante.CfdiRelacionados>();
        Comprobante.CfdiRelacionados rel = of.createComprobanteCfdiRelacionados();
        //relacion uuid
        List<Comprobante.CfdiRelacionados.CfdiRelacionado> r = rel.getCfdiRelacionado();
        for (int i = 0; i < data.size(); i++) {
            Comprobante.CfdiRelacionados.CfdiRelacionado a = of.createComprobanteCfdiRelacionadosCfdiRelacionado();
            a.setUUID(data.get(i));//obtener uuid de las facturas
            r.add(a);
        }
        rel.setTipoRelacion(relacion);
        arr.add(rel);
        return arr;
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
            case "I05":
                receptor.setUsoCFDI(CUsoCFDI.I_05);
                break;
            case "I06":
                receptor.setUsoCFDI(CUsoCFDI.I_06);
                break;
            case "I07":
                receptor.setUsoCFDI(CUsoCFDI.I_07);
                break;
        }
        receptor.setRegimenFiscalReceptor(obj.getRegimenFR());
        receptor.setDomicilioFiscalReceptor(obj.getDomicilioReceptor());
        return receptor;
    }

    private Comprobante.Conceptos createConceptos(ObjectFactory of, ArrayList<xmlDAO> data) {//conceptos
        Comprobante.Conceptos cps = of.createComprobanteConceptos();
        List<Comprobante.Conceptos.Concepto> list = cps.getConcepto();

        for (int i = 0; i < data.size(); i++) {
            Comprobante.Conceptos.Concepto c = of.createComprobanteConceptosConcepto();
//            if (rela.equals("")) {
//                c.setUnidad(data.get(i).getUnidad());
//            }
            if (desc != BigDecimal.valueOf(0)) {
                c.setDescuento(data.get(i).getDescuento().setScale(2, RoundingMode.HALF_UP));
            }
            c.setObjetoImp("02");
            c.setImporte(data.get(i).getImporte().setScale(2, RoundingMode.HALF_UP));
            c.setValorUnitario(data.get(i).getValorUnitario());
            c.setDescripcion(data.get(i).getDescripcion());
            c.setClaveUnidad(data.get(i).getClaveUn());
            c.setCantidad(data.get(i).getCantidad());
            c.setNoIdentificacion(i + "");
            c.setClaveProdServ(data.get(i).getClaveProdServ());
//            c.setImpuestos(createImpuestosConcepto(of, data.get(i).getImporteImpuesto(),
//                    data.get(i).getBase(), "002", data.get(i).getTasaCuota()));
            c.setImpuestos(createImpuestosConcepto(of, data.get(i).getImporteImpuesto(),
                    data.get(i).getBaseImpuesto(), "002", data.get(i).getTasaCuota()));
            list.add(c);
        }

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
        //subtotal-descuento
        BigDecimal b = obj.getSubT().subtract(obj.getDescuento());
        //Bloque para los impuestos trasladados
        Comprobante.Impuestos.Traslados tras = of.createComprobanteImpuestosTraslados();
        List<Comprobante.Impuestos.Traslados.Traslado> list = tras.getTraslado();
        Comprobante.Impuestos.Traslados.Traslado t1 = of.createComprobanteImpuestosTrasladosTraslado();
        t1.setImporte(obj.getTotalImpuesto().setScale(2));
        t1.setBase(b.setScale(2));
        t1.setTasaOCuota(obj.getTasaCuota());
        t1.setTipoFactor(CTipoFactor.TASA);
        t1.setImpuesto(obj.getImpuesto());
        list.add(t1);
        impus.setTraslados(tras);
        return impus;
    }

    //Metodos de sellado
//    private X509Certificate getX509Certificate(final File certificateFile) throws CertificateException, IOException {
//        FileInputStream is = null;
//
//        try {
//            is = new FileInputStream(certificateFile);
//            CertificateFactory of = CertificateFactory.getInstance("X.509");
//            return (X509Certificate) of.generateCertificate(is);
//        } finally {
//            if (is != null) {
//                is.close();
//            }
//        }
//    }
//
//    private String getCertificadoBase64(final X509Certificate cert) throws CertificateEncodingException {
//        return new String(Base64.encode(cert.getEncoded()));
//    }
//
//    private String getNoCertificado(final X509Certificate cert) {
//        BigInteger serial = cert.getSerialNumber();
//        byte[] sArr = serial.toByteArray();
//        StringBuilder buffer = new StringBuilder();
//
//        for (int i = 0; i < sArr.length; i++) {
//            buffer.append((char) sArr[i]);
//        }
//
//        return buffer.toString();
//    }
//
//    private String jaxbObjectToXML(Comprobante xml) {
//        String xmlString = "";
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(Comprobante.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            StringWriter sw = new StringWriter();
//            m.marshal(xml, sw);
//            xmlString = sw.toString();
//
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
//            System.out.println(ex.getMessage());
//        }
//        return xmlString;
//    }
//
//    private String generarCadenaOriginal(final String xml) throws TransformerException {
//        StreamSource streamS = new StreamSource("C:/af/filesfac/cadenaoriginal_4_0.xslt");
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer xlsTransformer = transformerFactory.newTransformer(streamS);
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        xlsTransformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(output));
//
//        String resultado = "";
//
//        try {
//            resultado = output.toString("UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(generarXML40tpu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return resultado;
//    }
//
//    private PrivateKey getPrivateKey(final File keyFile, final String password) throws GeneralSecurityException, IOException {
//
//        FileInputStream in = new FileInputStream(keyFile);
//        org.apache.commons.ssl.PKCS8Key pkcs8 = new org.apache.commons.ssl.PKCS8Key(in, password.toCharArray());
//
//        byte[] decrypted = pkcs8.getDecryptedBytes();
//        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
//        PrivateKey pk;
//
//        if (pkcs8.isDSA()) {
//            pk = KeyFactory.getInstance("DSA").generatePrivate(spec);
//        } else if (pkcs8.isRSA()) {
//            pk = KeyFactory.getInstance("RSA").generatePrivate(spec);
//        }
//
//        pk = pkcs8.getPrivateKey();
//        return pk;
//    }
//
//    private String generarSelloDigital(final PrivateKey key, final String cadenaOriginal)
//            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
//
//        Signature sing = Signature.getInstance("SHA256withRSA");
//        sing.initSign(key, new SecureRandom());
//
//        try {
//            sing.update(cadenaOriginal.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(generarXML40tpu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        byte[] signature = sing.sign();
//        return new String(Base64.encode(signature));
//    }
}
