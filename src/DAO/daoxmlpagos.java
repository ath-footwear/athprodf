/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.factura;
import athprod.Facturacion;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.sat.cfd40.generarXML40pagos;
import mx.sat.cfd40.xmlDAO;

/**
 *
 * @author GATEWAY1-
 */
public class daoxmlpagos {
    

    
    public void generarfac(factura f, Connection con, Connection empresa) {// solo genera xml
        try {
//            daoClientes dc = new daoClientes();
//            daofactura df = new daofactura();
//            factura f = df.getfac(rcpt, "47140");
            xmlDAO x = new xmlDAO();
//            Cliente c = dc.getCliente(cobranza, f.getIdcliente());// Busca
            String descmetodo = "";
            x.setFecha(f.getFechapago());
            x.setImpiva16(f.getImpiva16());
            x.setBaseiva16(f.getBaseiva16());
            x.setTotalpago16(f.getTotalpago16());
            x.setImpiva17(f.getImpiva17());
            x.setBaseiva17(f.getBaseiva17());
            x.setTotalpago17(f.getTotalpago17());
            x.setIddocumentos(f.getId());
            x.setEmpresa(f.getEmpresa());
            x.setTurno(f.getTurno());
            x.setFolio(f.getFolio() + "");                              // Folio
            x.setSerie(f.getSerie());                                   // Serie
            x.setFormaP(f.getFormapago());                              // forma de pago
            x.setDescripcionP(descmetodo);      // metodo descripcion
//            x.setDescuento(BigDecimal.valueOf(0));
            x.setSubT(BigDecimal.valueOf(0));             // Subtotal siempre '0'
            x.setMoneda(f.getMoneda());                                 // Moneda
            x.setTotal(BigDecimal.valueOf(0));               // Total siempre '0'
            x.setMetodoPago(f.getMetodopago());                         // MEtodo pago
            x.setDescripcionP(f.getDescmetodop());
//            x.setLugarExpedidcion("36400");                             // CP emisor
//Cliente
            x.setReceptor(f.getNombre());                               // Razon social re
//            x.setReceptor("COPPEL");
            x.setRfcR(f.getRfc());                                      // RFC re
            x.setUsoCfdi(f.getUsocfdi());                               // Uso cfdi re
            x.setRegimenFR(f.getRegimen());                                      // regimen re
            x.setDomicilioReceptor(f.getCp());                          // cp re
//Fin Cliente            
// array de pagos
            x.setArrpagos(f.getArrpagos());
            x.setArrpagos17(f.getArrpagos17());
            BigDecimal d = new BigDecimal("0.160000");//tomando en cuenta los 6 decimales
            x.setTasaCuota(d);
            generarXML40pagos xml = new generarXML40pagos();
            xml.crearComprobante(x, con, empresa);
        } catch (Exception ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
