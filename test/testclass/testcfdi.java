/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import Modelo.factura;
import Server.Serverprod;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.sat.cfd40.xmlDAO;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.jdom2.Document;

/**
 *
 * @author GATEWAY1-
 */
public class testcfdi {
    static Document xml;
    
    Serverprod s = new Serverprod();
    public static void main(String [] args) throws IOException{
   
//    doc();
    testcfdi t = new testcfdi();
    t.validarcert(); 
   
    }
    
     private static void doc(){
        try {
            xmlDAO x= new xmlDAO();
            ArrayList<xmlDAO> arr= new ArrayList<>();
            x.setFolio("13");
            x.setSerie("FAC");
            x.setFormaP("99");
            x.setDescripcionP("PAGO EN PARCIALIDADES O DIFERIDO");
//            x.setDescuento(BigDecimal.valueOf(0));
            x.setSubT(BigDecimal.valueOf(10));
            x.setMoneda("MXN");
            x.setTotal(BigDecimal.valueOf(11.6));
            x.setMetodoPago("PPD");
            x.setLugarExpedidcion("36400");
            x.setReceptor("ROBERTO DE JESUS MARTINEZ GONZALEZ");
            x.setRfcR("MAGR791125IUA");
            x.setUsoCfdi("G01");
            x.setRegimenFR("612");
            x.setDomicilioReceptor("36310");
            
            double imptraslado=0;
            double basetraslado=0;
            for(int i=0;i<1;i++){
                double impuesto=10*0.16;
                double base=10;
                xmlDAO y= new xmlDAO();
                y.setImporte(BigDecimal.valueOf(10));
//                y.setDescuento(BigDecimal.valueOf(0));
                y.setValorUnitario(BigDecimal.valueOf(5));
                y.setCantidad(BigDecimal.valueOf(2));
                y.setDescripcion("Prueba");
                y.setClaveProdServ("46181612");
                y.setClaveUn("PR");
                y.setUnidad("PARES");
                y.setBase(BigDecimal.valueOf(base));
                y.setImporteImpuesto(BigDecimal.valueOf(impuesto));
                BigDecimal d= new BigDecimal("0.160000");//tomando en cuenta los 6 decimales
                y.setTasaCuota(d);
                System.out.println(d);
                y.setNoIdenf("13");
                imptraslado+=impuesto;
                basetraslado+=base;
                arr.add(y);
            }
            x.setTotalImpuesto(BigDecimal.valueOf(imptraslado));
            x.setBaseImpuesto(BigDecimal.valueOf(basetraslado));
            x.setImpuesto("002");
            BigDecimal d= new BigDecimal("0.160000");//tomando en cuenta los 6 decimales
            x.setTasaCuota(d);
//            xml.crearComprobante(x, arr);
        } catch (Exception ex) {
            Logger.getLogger(testcfdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void validarcert() throws IOException{
//                String file = "C:\\ESD\\CSD_ESCUELA_WILSON_ESQUIVEL_SA_DE_CV__EWE1709045U0_20190617_132205s.cer";
//    
//    String filekey = "C:\\ESD\\CSD_ESCUELA_WILSON_ESQUIVEL_SA_DE_CV__EWE1709045U0_20190617_132205.key";
//    
//
//    LectorCerts cert = new LectorCerts(file, filekey, "12345678a");
//    
//    System.out.println(cert.getNumeroSerie());
//    System.out.println(cert.getVigencia());
//    System.out.println("tipo cert:" + cert.isCSD());
//        System.out.println(cert.getPrivateKey());
//    System.out.println(cert.isVigente());
//    System.out.println(cert.isCorrectPassword());
//    System.out.println(cert.correspondenClaves());
//    System.out.println(cert.verificaRFC("EWE1709045U0"));
//    
//    
//        StringWriter sw;
//    
//
//    XMLSerializer serializadorXML = new XMLSerializer();
//    sw = new StringWriter();
//    OutputFormat formatoSalida = new OutputFormat();
//    formatoSalida.setEncoding("UTF-8");
//    formatoSalida.setVersion("1.0");
//    
//
//    serializadorXML.setOutputCharStream(sw);
//    serializadorXML.setOutputFormat(formatoSalida);
//    serializadorXML.serialize((org.w3c.dom.Document) xml);
//    sw.close();
//        
    }
}
