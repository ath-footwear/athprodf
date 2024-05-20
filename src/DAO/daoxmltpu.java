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
import javax.swing.JOptionPane;
import mx.sat.cfd40.generarXML40;
import mx.sat.cfd40.generarXML40tpu;
import mx.sat.cfd40.xmlDAO;

/**
 *
 * @author GATEWAY1-
 */
public class daoxmltpu {

    ArrayList<metodopago> arrmetodo = new ArrayList<>();

    public factura generarfac(factura f, Connection con, Connection empresa) {// solo genera xml

        try {
//            daoClientes dc = new daoClientes();
//            daofactura df = new daofactura();
//            factura f = df.getfac(rcpt, "47140");
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
            x.setSerie(f.getSerie());                                   // Serie
            x.setTurno(f.getTurno());
            x.setFormaP(f.getFormapago());                              // forma de pago
            x.setDescripcionP(descmetodo);      // metodo descripcion
//            x.setDescuento(BigDecimal.valueOf(0));
            x.setSubT(BigDecimal.valueOf(f.getSubtotal()).setScale(2));             // Subtotal
            x.setMoneda(f.getMoneda());                                 // Moneda
            String newt = String.valueOf(f.getTotal());
            x.setTotal(BigDecimal.valueOf(Double.parseDouble(newt)).setScale(2));               // Total
            x.setMetodoPago(f.getMetodopago());                         // MEtodo pago
            x.setDescripcionP(f.getDescmetodop());
//            x.setLugarExpedidcion(f.getLugarexpedicion());                             // CP emisor
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
            DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
            for (int i = 0; i < f.getArr().size(); i++) {                       //      numero de renglones
                xmlDAO y = new xmlDAO();
                //Obtener datos de arreglo
                double importe = f.getArr().get(i).getImporta();
                double base = f.getArr().get(i).getBase();
                double unitario = Double.parseDouble(formateador.format(f.getArr().get(i).getPrecio()));
                //Cantidad flotante
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
                y.setValorUnitario(BigDecimal.valueOf(unitario).setScale(2, RoundingMode.HALF_UP));               //unitario c
                y.setCantidad(BigDecimal.valueOf(cantidad).setScale(2, RoundingMode.HALF_UP));                    // cantidad c
                y.setDescripcion(desc);                                         // desc prod
                y.setClaveProdServ(clvprov);                                    // clv sat
                y.setClaveUn(unidad);
                y.setBase(BigDecimal.valueOf(base).setScale(2));                            // importe c
                y.setImporteImpuesto(BigDecimal.valueOf(importe).setScale(2));              // iva
                BigDecimal d = new BigDecimal("0." + tas + "0000");//tomando en cuenta los 6 decimales
                y.setTasaCuota(d);
                y.setNoIdenf(id + "");
//                System.out.println("desc "+descuento+"- base "+base+"- baseimp "+(base-descuento));
                y.setBaseImpuesto(BigDecimal.valueOf(base - descuento).setScale(2, RoundingMode.HALF_UP));
                arr.add(y);
            }
// - Fin numero ded concepto

            x.setTotalImpuesto(BigDecimal.valueOf((f.getImpuestos())).setScale(2));           //IMPUESTO TRASLADADO
            x.setBaseImpuesto(BigDecimal.valueOf(f.getSubtotal()).setScale(2));             //BASE TRASLADO
            x.setImpuesto("002");

            BigDecimal d = new BigDecimal("0." + tas + "0000");//tomando en cuenta los 6 decimales
            x.setTasaCuota(d);
            generarXML40tpu xml = new generarXML40tpu();
            xml.crearComprobante(x, arr, con, empresa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "daoxml -" + ex);
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
}
