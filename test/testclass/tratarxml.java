/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author GATEWAY1-
 */
public class tratarxml {

    public static void main(String[] args) throws TransformerException {
        try {
            tratarxml x = new tratarxml();
            x.escribirxml();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(tratarxml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(tratarxml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(tratarxml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void escribirxml() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        File file = new File("C:\\af\\filesfac\\a.xml");
//File file = new File("C:\\af\\filesfac\\resultado.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document doc = db.newDocument();

        Element eRaiz = doc.createElement("Comprobante");
        doc.setDocumentURI("http://www.sat.gob.mx/cfd/4");
        eRaiz.setIdAttributeNS("http://www.sat.gob.mx/cfd/4", "cfdi", true);
//        doc.setPrefix("cfdi");
//        eRaiz.setPrefix("cfdi");
        Attr attr = doc.createAttribute("Version");
        attr.setValue("4.0");
        Attr attr1 = doc.createAttribute("Serie");
        attr1.setValue("NCR");
        Attr attr2 = doc.createAttribute("xmlns:xsi");
        attr2.setValue("sdop9idj0");
        eRaiz.setAttributeNode(attr);
        eRaiz.setAttributeNode(attr1);
        eRaiz.setAttributeNode(attr2);
        doc.appendChild(eRaiz);
//        doc.getDocumentElement().normalize();
//        NodeList nList = doc.getElementsByTagName("cfdi:Emisor").item(0);
//        System.out.println(nList.getLength());
//        for (int temp = 0; temp < nList.getLength(); temp++) {
//            Node nNode = nList.item(temp);
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) nNode;
//                System.out.println("a " + eElement.getAttribute("Nombre"));
//
//            }
////            
//        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("C:\\af\\filesfac\\resultado.xml"));
        Source input = new DOMSource(doc);
        transformer.transform(input, output);
    }

}
