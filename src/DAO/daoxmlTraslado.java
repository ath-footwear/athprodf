/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.factura;
import Modelo.metodopago;
import athprod.Facturacion;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.sat.cfd40.generarXML40traslado;
import mx.sat.cfd40.xmlDAO;

/**
 *
 * @author GATEWAY1-
 */
public class daoxmlTraslado {

    ArrayList<metodopago> arrmetodo = new ArrayList<>();

    public void generarfac(factura f, Connection con, Connection empresa) {// solo genera xml
        try {
//            daoClientes dc = new daoClientes();
//            daofactura df = new daofactura();
//            factura f = df.getfac(rcpt, "47140");
            xmlDAO x = new xmlDAO();
            ArrayList<xmlDAO> arr = new ArrayList<>();
            x.setExportacion(f.getExportacion());
            x.setRelacion(f.getTiporelacion());
            x.setFolioorig(f.getFoliofiscalorig());
            x.setIddocumentos(f.getId());
            x.setTurno(f.getTurno());
            x.setEmpresa(f.getEmpresa());
            x.setFolio(f.getFolio() + "");                              // Folio
            x.setSerie("TR");       // metodo descripcion
            x.setSubT(BigDecimal.ZERO);             // Subtotal
            x.setMoneda("XXX");                                 // Moneda
            x.setTotal(BigDecimal.ZERO);                            // CP emisor
//Cliente
            x.setReceptor(f.getNombre());                               // Razon social re
//            x.setReceptor("COPPEL");
            x.setRfcR(f.getRfc());                                      // RFC re
            x.setUsoCfdi(f.getUsocfdi());                               // Uso cfdi re
            x.setRegimenFR(f.getRegimen());                                      // regimen re
            x.setDomicilioReceptor(f.getCp());                          // cp re
//Fin Cliente            
// # de Concepto
            for (int i = 0; i < f.getArr().size(); i++) {                       //      numero de renglones
                xmlDAO y = new xmlDAO();
                //Obtener datos de arreglo
                int cantidad = f.getArr().get(i).getCantidad();
                String desc = f.getArr().get(i).getDescripcion();
                String clvprov = f.getArr().get(i).getCodigo();
                String unidad = f.getArr().get(i).getUmedida();
                int id = f.getId();                      //importe c
                y.setValorUnitario(BigDecimal.ZERO);               //unitario c
                y.setCantidad(BigDecimal.valueOf(cantidad));                    // cantidad c
                y.setDescripcion(desc);                                         // desc prod
                y.setClaveProdServ(clvprov);                                    // clv sat
                y.setClaveUn(unidad);
                y.setNoIdenf(id + "");
                arr.add(y);
            }
// - Fin numero ded concepto

            generarXML40traslado xml = new generarXML40traslado();
            xml.crearComprobante(x, arr, con, empresa);
        } catch (Exception ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
