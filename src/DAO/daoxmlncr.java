/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.factura;
import Modelo.metodopago;
import athprod.Facturacion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.sat.cfd40.generarXML40ncr;
import mx.sat.cfd40.xmlDAO;

/**
 *
 * @author GATEWAY1-
 */
public class daoxmlncr {

    ArrayList<metodopago> arrmetodo = new ArrayList<>();

    public void generarfac(factura f, Connection con, Connection empresa) {// solo genera xml
        try {
            xmlDAO x = new xmlDAO();
            ArrayList<xmlDAO> arr = new ArrayList<>();
//            Cliente c = dc.getCliente(cobranza, f.getIdcliente());// Busca
            String descmetodo = "";
            String tas = "00";
            if (f.getDescuento() != 0) {                                    //setear descuento si es distinto de 0
                x.setDescuento(BigDecimal.valueOf(f.getDescuento()).setScale(2));
            } else {
                x.setDescuento(BigDecimal.ZERO);
            }
            if (f.getImpuestos() != 0) {
                tas = "16";
            }
            for (int i = 0; i < arrmetodo.size(); i++) {//asignar descripcion del metodo de pago
                if (f.getMetodopago().equals(arrmetodo.get(i).getMetodopago())) {
                    descmetodo = arrmetodo.get(i).getDescripcion();
                    break;
                }
            }
            x.setExportacion(f.getExportacion());
            x.setArruuid(f.getArruuid());
            x.setRelacion(f.getTiporelacion());
            x.setIddocumentos(f.getId());
            x.setEmpresa(f.getEmpresa());
            x.setFolio(f.getFolio() + "");                              // Folio
            x.setTurno(f.getTurno());
            x.setSerie(f.getSerie());                                   // Serie
            x.setFormaP(f.getFormapago());                              // forma de pago
            x.setDescripcionP(descmetodo);      // metodo descripcion
//            x.setDescuento(BigDecimal.valueOf(0));
            x.setSubT(BigDecimal.valueOf(f.getSubtotal()).setScale(2));             // Subtotal
            x.setMoneda(f.getMoneda());                                 // Moneda
            String newt = String.valueOf(f.getTotal());
            x.setTotal(BigDecimal.valueOf(Double.parseDouble(newt)).setScale(2));               // Total
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
            //USD
            x.setTipoC(BigDecimal.valueOf(f.getTipocambio()));
//Fin Cliente            
// # de Concepto
            for (int i = 0; i < f.getArr().size(); i++) {                       //      numero de renglones
                xmlDAO y = new xmlDAO();
                //Obtener datos de arreglo
                double importe = f.getArr().get(i).getImporta();
                double base = f.getArr().get(i).getBase();
                double unitario = f.getArr().get(i).getPrecio();
                double cantidad = f.getArr().get(i).getCantidadfloat();
                double descuento = f.getArr().get(i).getDescuento();
                String desc = f.getArr().get(i).getDescripcion();
                String clvprov = f.getArr().get(i).getCodigo();
                String unidad = f.getArr().get(i).getUmedida();
                int id = f.getId();
                if (descuento != 0) {// si el descuento es distinto de cero
                    y.setDescuento(BigDecimal.valueOf(descuento));              //Descuento c   
                }

                if (f.getTiporelacion().equals("")) {//asignara solo si no tiene una relacion
                    // unidad
                    y.setUnidad(f.getArr().get(i).getDescumedida());
                }
                y.setImporte(BigDecimal.valueOf(base));                         //importe c
                y.setValorUnitario(BigDecimal.valueOf(unitario).setScale(2));               //unitario c
                y.setCantidad(BigDecimal.valueOf(cantidad));                    // cantidad c
                y.setDescripcion(desc);                                         // desc prod
                y.setClaveProdServ(clvprov);                                    // clv sat
                y.setClaveUn(unidad);
                y.setBase(BigDecimal.valueOf(base).setScale(2));                            // importe c
                y.setImporteImpuesto(BigDecimal.valueOf(importe).setScale(2));              // iva
                BigDecimal d = new BigDecimal("0." + tas + "0000");//tomando en cuenta los 6 decimales
                y.setTasaCuota(d);
                y.setBaseImpuesto(BigDecimal.valueOf(base-descuento).setScale(2));
                y.setNoIdenf(id + "");
                arr.add(y);
            }
// - Fin numero ded concepto

            x.setTotalImpuesto(BigDecimal.valueOf((f.getImpuestos())).setScale(2));           //IMPUESTO TRASLADADO
            x.setBaseImpuesto(BigDecimal.valueOf(f.getSubtotal()).setScale(2));             //BASE TRASLADO
            x.setImpuesto("002");

            BigDecimal d = new BigDecimal("0." + tas + "0000");//tomando en cuenta los 6 decimales
            x.setTasaCuota(d);
            generarXML40ncr xml = new generarXML40ncr();
            xml.crearComprobante(x, arr, con, empresa);
        } catch (Exception ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
