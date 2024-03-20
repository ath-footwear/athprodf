/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.dao_comisiones;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import mx.sat.cfd40.Comprobante;
import mx.sat.cfd40.generarXML40;
import org.apache.xerces.impl.dv.util.Base64;

/**
 *
 * @author GATEWAY1-
 */
public class Formateo_Nempresas {

    //Lugar de expedicion
    private final String LUGAR_EXP = "36350";

    /**
     * Obtiene el lugar de expedicion
     *
     * @return
     */
    public String getLugar_exp() {
        return LUGAR_EXP;
    }

    /**
     * Empresa para seleccionar los datos fiscales en el documento, ej, su
     * certificado llave y contraseña
     *
     * @param turno turno del usuario
     * @param cpt nombre de la bd de Athletic, cpt o uptown, Este solo aplica
     * para athletic o uptown, no aplica para tpu o maquinarias
     * @return
     */
    public String getEmpresa(String turno, String cpt) {
        String resp = "";
        switch (turno) {
            case "0":
            case "1":
                resp = (cpt.equals("UptownCPT")) ? "2" : "1";
                break;
            case "5": //TPU
                //Temporalmente 1 en lo que se implementa la otra razon social
                resp = "1";
                break;
            case "7": // Maquinaria2
                //Temporalmente 1 en lo que se implementa la otra razon social
                resp = "1";
                break;
            default:
                resp = "1";
        }
        return resp;
    }

    /**
     * Funcion que busca la comision generada en su momento si es que termino de
     * pagar y la cancela, con esto se refiere a que no se podra ver ni tomar su
     * valor en cuanta
     *
     * @param dev
     */
    public void cancelacomision(Connection cpt, Devolucion dev) {
        dao_comisiones dc = new dao_comisiones();
        Comision com = new Comision();
        ArrayList<Comision> arrcomi = new ArrayList<>();
        com.setId_cargo(dev.getId_cargoenc());
        com.setSerie(dev.getSerie());
        arrcomi.add(com);
        dc.cancelacomision(cpt, arrcomi);

    }

    //Metodos de sellado
    public X509Certificate getX509Certificate(final File certificateFile) throws CertificateException, IOException {
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

    public String getCertificadoBase64(final X509Certificate cert) throws CertificateEncodingException {
        return new String(Base64.encode(cert.getEncoded()));
    }

    public String getNoCertificado(final X509Certificate cert) {
        BigInteger serial = cert.getSerialNumber();
        byte[] sArr = serial.toByteArray();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            buffer.append((char) sArr[i]);
        }
        return buffer.toString();
    }

    /**
     * Despues de asignar los valores al xml, guardar el comprobante y realizar
     * el sellado digital
     *
     * @param xml
     * @return
     */
    public String jaxbObjectToXML(Comprobante xml) {
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

    public String generarCadenaOriginal(final String xml) throws TransformerException {
        StreamSource streamS = new StreamSource("C:/af/filesfac/cadenaoriginal_4_0.xslt");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer xlsTransformer = transformerFactory.newTransformer(streamS);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        xlsTransformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(output));
        String resultado = "";
        try {
            resultado = output.toString("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    /**
     * Utilizar el archivo .key del contribuyente, ademas de la contraseña
     * correspondiente
     *
     * @param keyFile
     * @param password
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public PrivateKey getPrivateKey(final File keyFile, final String password) throws GeneralSecurityException, IOException {

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

    public String generarSelloDigital(final PrivateKey key, final String cadenaOriginal)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {

        Signature sing = Signature.getInstance("SHA256withRSA");
        sing.initSign(key, new SecureRandom());
        try {
            sing.update(cadenaOriginal.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] signature = sing.sign();
        return new String(Base64.encode(signature));
    }
}
