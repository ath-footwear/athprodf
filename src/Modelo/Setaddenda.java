/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.lang.NullPointerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author GATEWAY1-
 */
public class Setaddenda {

    NAddenda na;
    String archivo;
    factura f;

    /**
     *
     * @param na parametro que contiene todo lo necesario para crear la addenda
     */
    public Setaddenda(NAddenda na) {
        this.na = na;
        this.archivo = na.getArchivo();
        this.f = na.getF();
    }

    /**
     * Borra el nodo de la adenda
     */
    public void deladenda() {
        try {
            Document doc;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = dbFactory.newDocumentBuilder();
            doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();
            Node ar = doc.getElementsByTagName("cfdi:Addenda").item(0);
            doc.getDocumentElement().removeChild(ar);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(null, "Completo!: El documento ya no tiene adenda","Eliminacion de addenda",JOptionPane.CANCEL_OPTION);
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar documento");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "El documento ya no tiene adenda");
        }
    }

    /**
     * Contruye todo el nodo correspondiente a la addenda
     *
     * @return
     */
    public String Construyeaddenda() {
        try {
            Document doc;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();
//            NodeList comp1 = doc.getElementsByTagName("cfdi:Conceptos");

            Node ar = doc.getElementsByTagName("cfdi:Comprobante").item(0);
            Element ad = doc.createElement("cfdi:Addenda");
//            Nodo principal, requestpayment
            Element requestpayment = doc.createElement("requestForPayment");
            requestpayment.setAttribute("DeliveryDate", na.getArrad().get(0).getFecha());
            requestpayment.setAttribute("documentStatus", "ORIGINAL");
            requestpayment.setAttribute("documentStructureVersion", "CPLR1.0");
            requestpayment.setAttribute("contentVersion", "1.0");
            requestpayment.setAttribute("type", "SimpleInvoiceType");
            ad.appendChild(requestpayment);
            //Nodos extra dentro de requestfor payment
            requestpayment.appendChild(getRequestforpaymentidentification(doc, "FAC" + f.getFolio()));
            requestpayment.appendChild(getOrderIdentification(doc));
            requestpayment.appendChild(getSeller(doc));
            requestpayment.appendChild(getShipto(doc, na.getDc().getId_coppel() + "", na.getDc().getDestino()));
            requestpayment.appendChild(getcurrency(doc));
            requestpayment.appendChild(getTotallotes(doc, na.getCajas()));
            for (int i = 0; i < na.getArrad().size(); i++) {
                requestpayment.appendChild(getlineItem(doc, i));
            }
            requestpayment.appendChild(getTotalamouunt(doc, f.getSubtotal() - f.getDescuento()));
            requestpayment.appendChild(getTotalallowance(doc, f.getDescuento()));
            requestpayment.appendChild(getBaseamount(doc, f.getSubtotal() - f.getDescuento()));
            requestpayment.appendChild(getTax(doc, f.getImpuestos()));
            requestpayment.appendChild(getPayableamount(doc, f.getTotal()));
            requestpayment.appendChild(getCadenaO(doc, f.getCadenaorig()));
            ar.appendChild(ad);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Nodo dee request for paymentident
     *
     * @param doc objeto del xml
     * @param folio ej FAC452654
     * @return
     */
    private Element getRequestforpaymentidentification(Document doc, String folio) {
        Element r = doc.createElement("requestForPaymentIdentification");
        Element entity = doc.createElement("entityType");
        Element unique = doc.createElement("uniqueCreatorIdentification");
        unique.setTextContent(folio);
        entity.setTextContent("INVOICE");
        r.appendChild(entity);
        r.appendChild(unique);
//        r.setAttribute("entityTypr", "INVOICE");
//        r.setAttribute("uniqueCreatorIdentification", folio);
        return r;
    }

    /**
     * Solo es necesario el pedido y la fecha sin el tiempo
     *
     * @param doc
     * @return
     */
    private Element getOrderIdentification(Document doc) {
        Element r = doc.createElement("orderIdentification");
        Element ri = doc.createElement("referenceIdentification");
        Element referenced = doc.createElement("ReferenceDate");
        ri.setAttribute("type", "ON");
        ri.setTextContent(na.getArrad().get(0).getPedido());
        referenced.setTextContent(na.getArrad().get(0).getFecha());
        r.appendChild(ri);
        r.appendChild(referenced);
        return r;
    }

    /**
     * selller numero y tipo proveedor
     *
     * @param doc
     * @return
     */
    private Element getSeller(Document doc) {
        Element seller = doc.createElement("seller");
        Element alterparty = doc.createElement("alternatePartyIdentification");
        Element identipo = doc.createElement("IndentificaTipoProv");
        alterparty.setAttribute("type", "SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY");
        alterparty.setTextContent(na.getProv());
        identipo.setTextContent("2");
        seller.appendChild(alterparty);
        seller.appendChild(identipo);
        return seller;
    }

    /**
     * Nodo ShipTo que contiene nombre, direcion y numero dee bodega
     *
     * @param doc
     * @param nbodega nombre de la bodega
     * @param bodega numero de bodega
     * @return
     */
    private Element getShipto(Document doc, String nbodega, String bodega) {
        Element ship = doc.createElement("shipTo");
        Element nameAdress = doc.createElement("nameAndAddress");
        Element name = doc.createElement("name");
        Element street = doc.createElement("streetAddressOne");
        Element city = doc.createElement("city");
        Element cp = doc.createElement("postalcode");
        Element bod = doc.createElement("bodegaEnt");
        name.setTextContent(bodega);
        street.setTextContent(" ");
        city.setTextContent(" ");
        cp.setTextContent(" ");
        bod.setTextContent(nbodega);
        nameAdress.appendChild(name);
        nameAdress.appendChild(street);
        nameAdress.appendChild(city);
        nameAdress.appendChild(cp);
        nameAdress.appendChild(bod);
        ship.appendChild(nameAdress);
        return ship;
    }

    /**
     * Se obtiene lo que es la moneda
     *
     * @param doc
     * @return
     */
    private Element getcurrency(Document doc) {
        Element curr = doc.createElement("currency");
        Element curfunction = doc.createElement("currencyFunction");
        curr.setAttribute("currencyISOCode", "MXN");
        curfunction.setTextContent("BILLING_CURRENCY");
        curr.appendChild(curfunction);
        return curr;
    }

    /**
     *
     * @param doc
     * @param lotes
     * @return
     */
    private Element getTotallotes(Document doc, int lotes) {
        Element totall = doc.createElement("TotalLotes");
        Element cantidad = doc.createElement("cantidad");
        cantidad.setTextContent(lotes + "");
        totall.appendChild(cantidad);
        return totall;
    }

    /**
     * Devuelve la parte de loos renglones
     *
     * @param doc
     * @param f
     * @return
     */
    private Element getlineItem(Document doc, int ren) {
        Formateodedatos fd = new Formateodedatos();
        Element item = doc.createElement("lineItem");
        item.setAttribute("type", "SimpleInvoiceLineItemType");
        item.setAttribute("number", (ren + 1) + "");
        Element tradeitem = doc.createElement("alternateTradeItemIdentification");
        tradeitem.setAttribute("type", "BUYER_ASSIGNED");
        tradeitem.setTextContent(na.getArrcod().get(ren));
        Element invq = doc.createElement("invoicedQuantity");
        invq.setAttribute("unitOfMeasure", "PCE");
        invq.setTextContent(na.getArrad().get(ren).getCantidad() + ".00");
        Element adq = doc.createElement("aditionalQuantity");
        adq.setAttribute("QuantityType", "NUM_CONSUMER_UNITS");
        adq.setTextContent(na.getArrad().get(ren).getCantidad() + "");
//        tradeitemdescripcion
        Element tradeitemdesc = doc.createElement("tradeItemDescriptionInformation");
        Element ltext = doc.createElement("longText");
        ltext.setTextContent(na.getArrad().get(ren).getDescripcionprod());
        tradeitemdesc.appendChild(ltext);

//        Codigo talla
        Element codigotalla = doc.createElement("codigoTallaInternoCop");
        Element codigo = doc.createElement("codigo");
        codigo.setTextContent(na.getArrcod().get(ren));
        Element talla = doc.createElement("talla");
        talla.setTextContent(na.getArrad().get(ren).getPunto() + "");
        codigotalla.appendChild(codigo);
        codigotalla.appendChild(talla);
//       gross
        Element gross = doc.createElement("grossPrice");
        Element amount = doc.createElement("Amount");
        amount.setTextContent(na.getArrad().get(ren).getPrecio() + "");
        gross.appendChild(amount);
//        netPrice
        Element netprice = doc.createElement("netPrice");
        Element amountp = doc.createElement("Amount");
        amountp.setTextContent(na.getArrad().get(ren).getPrecio() + "");
        netprice.appendChild(amountp);
//        pallet informacion
        Element pallet = doc.createElement("palletInformation");
        Element desc = doc.createElement("description");
        desc.setAttribute("type", "BOX");
        desc.setTextContent("EMPAQUETADO");
        Element transport = doc.createElement("transport");
        Element metod = doc.createElement("methodOfPayment");
        metod.setTextContent("PAID_BY_BUYER");
        Element prepac = doc.createElement("prepactCant");
        prepac.setTextContent(""+na.getCantidad());
        transport.appendChild(metod);
        transport.appendChild(prepac);
        pallet.appendChild(desc);
        pallet.appendChild(transport);
//      allowance charge
        Element allowance = doc.createElement("allowanceCharge");
        allowance.setAttribute("allowanceChargeType", " ALLOWANCE_GLOBAL");
        Element specialservice = doc.createElement("specialServicesType");
        specialservice.setTextContent("PAD");
        Element monetaryamount = doc.createElement("monetaryAmountOrPercentage");
        Element percentunit = doc.createElement("percentagePerUnit");
        percentunit.setTextContent("0");
        Element rate = doc.createElement("ratePerUnit");
        Element amountrate = doc.createElement("amountPerUnit");
        amountrate.setTextContent("0");
        rate.appendChild(amountrate);
        monetaryamount.appendChild(percentunit);
        monetaryamount.appendChild(rate);
        allowance.appendChild(specialservice);
        allowance.appendChild(monetaryamount);
//        Total line
        Element totalline = doc.createElement("totalLineAmount");
        Element grossamount = doc.createElement("grossAmount");
        Element amo = doc.createElement("Amount");
        amo.setTextContent(fd.formatdecimal(na.getArrad().get(ren).getCantidad() * na.getArrad().get(ren).getPrecio()) + "");
        grossamount.appendChild(amo);
        Element netamount = doc.createElement("netAmount");
        Element amo1 = doc.createElement("Amount");
        amo1.setTextContent(fd.formatdecimal(na.getArrad().get(ren).getCantidad() * na.getArrad().get(ren).getPrecio()) + "");
        netamount.appendChild(amo1);
        totalline.appendChild(grossamount);
        totalline.appendChild(netamount);
//        añadir subnodos al nodo principal
        item.appendChild(tradeitem);
        item.appendChild(invq);
        item.appendChild(adq);
        item.appendChild(codigotalla);
        item.appendChild(tradeitemdesc);
        item.appendChild(gross);
        item.appendChild(netprice);
        item.appendChild(pallet);
        item.appendChild(allowance);
        item.appendChild(totalline);

        return item;
    }

    /**
     * Solo crea un nodo de el total de la factura
     *
     * @param doc
     * @param monto Total de la factura
     * @return
     */
    private Element getTotalamouunt(Document doc, double monto) {
        Element Totalamount = doc.createElement("totalAmount");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent(monto + "");
        Totalamount.appendChild(Amount);
        return Totalamount;
    }

    /**
     * Obtener Totalallowance
     *
     * @param doc
     * @return Elemento de total allowance
     */
    private Element getTotalallowance(Document doc, double d) {
        Element Totalallowance = doc.createElement("TotalAllowanceCharge");
        Totalallowance.setAttribute("allowanceOrChargeType", "ALLOWANCE");
        Element sp = doc.createElement("specialServicesType");
        sp.setTextContent("TD");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent(d + "");
        Totalallowance.appendChild(sp);
        Totalallowance.appendChild(Amount);
        return Totalallowance;
    }

    /**
     *
     * @param doc
     * @param monto
     * @return
     */
    private Element getBaseamount(Document doc, double monto) {
        Element baseamount = doc.createElement("baseAmount");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent(monto + "");
        baseamount.appendChild(Amount);
        return baseamount;
    }

    /**
     *
     * @param doc
     * @param f
     * @return
     */
    private Element getTax(Document doc, double impuestos) {
        Element tax = doc.createElement("tax");
        tax.setAttribute("type", "VAT");
        Element taxpercentage = doc.createElement("taxPercentage");
        taxpercentage.setTextContent("16.00");
        Element taxamount = doc.createElement("taxAmount");
        taxamount.setTextContent(impuestos + "");
        Element taxcategory = doc.createElement("taxCategory");
        taxcategory.setTextContent("TRANSFERIDO");
        tax.appendChild(taxpercentage);
        tax.appendChild(taxamount);
        tax.appendChild(taxcategory);
        return tax;
    }

    /**
     *
     * @param doc
     * @param total
     * @return
     */
    private Element getPayableamount(Document doc, double total) {
        Element payamount = doc.createElement("payableAmount");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent(total + "");
        payamount.appendChild(Amount);
        return payamount;
    }

    /**
     *
     * @param doc
     * @param cadeena
     * @return
     */
    private Element getCadenaO(Document doc, String cadenas) {
        Element cadenao = doc.createElement("cadenaOriginal");
        Element cadena = doc.createElement("Cadena");
        cadena.setTextContent(cadenas);
        cadenao.appendChild(cadena);
        return cadenao;
    }

}
