/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athprod;

import DAO.daocfdi;
import Modelo.Conexiones;
import Modelo.Formadepago;
import Modelo.Usuarios;
import Modelo.metodopago;
import Modelo.usocfdi;
import Paneles.fac1;
import Paneles.fac2;
import Paneltpu.cfditransportetpu;
import Paneltpu.cfditransportetpuv2;
import Server.Serverylite;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michel araujo 2022
 */
public class Facturacion extends javax.swing.JInternalFrame {

    fac1 c1;
    fac2 c2;
    cfditransportetpu c3;
    cfditransportetpuv2 c4;
    String var = "0";
    public String name, empresa, empresarcpt, empresacob;
    Connection rcpt, litecfdi, liteempresa, cobranza, cpt;
    public Connection liteusuario;
    ArrayList<usocfdi> arruso = new ArrayList<>();
    ArrayList<Formadepago> arrforma = new ArrayList<>();
    ArrayList<metodopago> arrmetodo = new ArrayList<>();
    public Conexiones conexion;
    public Usuarios u;

    /**
     * Creates new form Clientes
     *
     * @param cn Lista de conexiones
     * @param usu datos de usuario
     */
    public Facturacion(Conexiones cn, Usuarios usu) {
        initComponents();
        cpt = cn.getCpt();
        rcpt = cn.getRcpt();
        cobranza = cn.getCobranza();
        empresa = cn.getEmpresa();
        empresarcpt = cn.getEmpresarcpt();
        empresacob = cn.getEmpresacob();
        u = usu;
        liteusuario = cn.getLiteusuario();
        generaciontab();//Tabs de facturacion
        conexiones();
        setarraylist();
    }

    private void conexiones() {//Conexiones a servidor
        try {
            Serverylite l = new Serverylite();
            litecfdi = l.getconexioncfdi();
            liteempresa = l.getconexionC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setarraylist() {
        daocfdi d = new daocfdi();
        arruso = d.getusocfdi(litecfdi);
        arrmetodo = d.getMetodopago(litecfdi);
        arrforma = d.getFormadepago(litecfdi);
        if (u.getTurno().equals("5")) {
            c1.cpt = cpt;
            c1.ACobranza = cobranza;
            c1.empresa = empresa;
            c1.empresacob = empresacob;
            c1.arrfpago = arrforma;
            c1.arrmetodo = arrmetodo;
            c1.arruso = arruso;
            c1.sqlcfdi = litecfdi;
            c1.sqlempresa = liteempresa;
            c1.rcpt = rcpt;
            c1.u = u;
            c1.JtCliente.requestFocus();
            c1.liteusuario = liteusuario;
        } else {
            c2.arrfpago = arrforma;
            c2.arrmetodo = arrmetodo;
            c2.arruso = arruso;
            //tambien conexiones y variables
            c2.ACobranza = cobranza;
            c2.rcpt = rcpt;
            c2.sqlempresa = liteempresa;
            c2.sqlcfdi = litecfdi;
            c2.cpt = cpt;
            c2.empresa = empresa;
            c2.empresarcpt = empresarcpt;
            c2.empresacob = empresacob;
            c2.u = u;// datos del usuario

            c1.cpt = cpt;
            c1.ACobranza = cobranza;
            c1.empresa = empresa;
            c1.empresacob = empresacob;
            c1.arrfpago = arrforma;
            c1.arrmetodo = arrmetodo;
            c1.arruso = arruso;
            c1.sqlcfdi = litecfdi;
            c1.sqlempresa = liteempresa;
            c1.rcpt = rcpt;
            c1.u = u;
            c1.JtCliente.requestFocus();
            c1.liteusuario = liteusuario;
            
            c3.cpt = cpt;
            c3.ACobranza = cobranza;
            c3.empresa = empresa;
            c3.empresacob = empresacob;
            c3.arrfpago = arrforma;
            c3.arrmetodo = arrmetodo;
            c3.arruso = arruso;
            c3.sqlcfdi = litecfdi;
            c3.sqlempresa = liteempresa;
            c3.rcpt = rcpt;
            c3.u = u;
            c3.cargaclientes();
            
            c4.cpt = cpt;
            c4.ACobranza = cobranza;
            c4.empresa = empresa;
            c4.empresacob = empresacob;
            c4.arrfpago = arrforma;
            c4.arrmetodo = arrmetodo;
            c4.arruso = arruso;
            c4.sqlcfdi = litecfdi;
            c4.sqlempresa = liteempresa;
            c4.rcpt = rcpt;
            c4.u = u;
            c4.cargaclientes();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Tabbed = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Facturacion");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtir.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Tabbed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public final void generaciontab() {//generar tabs

        if (u.getTurno().equals("5")) {
            c1 = new fac1();
            Tabbed.addTab("Listado Facturas", c1);
        } else {
            c1 = new fac1();
            c2 = new fac2();
            c3 = new cfditransportetpu();
            c4 = new cfditransportetpuv2();
            
            Tabbed.addTab("Listado de Facturas", c1);
            Tabbed.addTab("Nueva Factura", c2);
            Tabbed.addTab("Cfdi traslado libre", c3);
            Tabbed.addTab("Cfdi traslado remision", c4);

            Tabbed.setSelectedComponent(c1);
        }
    }

    private void valoresclase() {

    }

//    private void generarfac() {// solo genera xml
//        try {
//            daoClientes dc = new daoClientes();
//            daofactura df = new daofactura();
//            factura f = df.getfac(rcpt, "47140");
//            xmlDAO x = new xmlDAO();
//            ArrayList<xmlDAO> arr = new ArrayList<>();
//            Cliente c = dc.getCliente(cobranza, f.getIdcliente());// Busca
//            String descmetodo = "";
//            if (f.getDescuento() != 0) {                                    //setear descuento si es distinto de 0
//                x.setDescuento(BigDecimal.valueOf(f.getDescuento()));
//            }
//
//            for (int i = 0; i < arrmetodo.size(); i++) {//asignar descripcion del metodo de pago
//                if (f.getMetodopago().equals(arrmetodo.get(i).getMetodopago())) {
//                    descmetodo = arrmetodo.get(i).getDescripcion();
//                    break;
//                }
//            }
//            x.setFolio(f.getFolio() + "");                              // Folio
//            x.setSerie(f.getSerie());                                   // Serie
//            x.setFormaP(f.getFormapago());                              // forma de pago
//            x.setDescripcionP(descmetodo);      // metodo descripcion
////            x.setDescuento(BigDecimal.valueOf(0));
//            x.setSubT(BigDecimal.valueOf(f.getSubtotal()));             // Subtotal
//            x.setMoneda(f.getMoneda());                                 // Moneda
//            x.setTotal(BigDecimal.valueOf(f.getTotal()));               // Total
//            x.setMetodoPago(f.getMetodopago());                         // MEtodo pago
////            x.setLugarExpedidcion("36400");                             // CP emisor
////Cliente
//            x.setReceptor(c.getNombre());                               // Razon social re
////            x.setReceptor("COPPEL");
//            x.setRfcR(c.getRfc());                                      // RFC re
//            x.setUsoCfdi(f.getUsocfdi());                               // Uso cfdi re
//            x.setRegimenFR("612");                                      // regimen re
//            x.setDomicilioReceptor(c.getCp());                          // cp re
////Fin Cliente            
//// # de Concepto
//            for (int i = 0; i < f.getArr().size(); i++) {                       //      numero de renglones
//                xmlDAO y = new xmlDAO();
//                //Obtener datos de arreglo
//                float importe = f.getArr().get(i).getImporta();
//                float base = f.getArr().get(i).getBase();
//                float unitario = f.getArr().get(i).getPrecio();
//                int cantidad = f.getArr().get(i).getCantidad();
//                float descuento = f.getArr().get(i).getDescuento();
//                String desc = f.getArr().get(i).getDescripcion();
//                String clvprov = f.getArr().get(i).getCodigo();
//                String unidad = f.getArr().get(i).getUmedida();
//                int id = f.getId();
//                //
//                if (descuento != 0) {// si el descuento es distinto de cero
//                    y.setDescuento(BigDecimal.valueOf(descuento));              //Descuento c
//                }
//                y.setImporte(BigDecimal.valueOf(base));                         //importe c
//                y.setValorUnitario(BigDecimal.valueOf(unitario));               //unitario c
//                y.setCantidad(BigDecimal.valueOf(cantidad));                    // cantidad c
//                y.setDescripcion(desc);                                         // desc prod
//                y.setClaveProdServ(clvprov);                                    // clv sat
//                y.setClaveUn(unidad);                                           // unidad
//                y.setUnidad("PARES");
//                y.setBase(BigDecimal.valueOf(base));                            // importe c
//                y.setImporteImpuesto(BigDecimal.valueOf(importe));              // iva
//                BigDecimal d = new BigDecimal("0.160000");//tomando en cuenta los 6 decimales
//                y.setTasaCuota(d);
//                y.setNoIdenf(id + "");
//                arr.add(y);
//            }
//// - Fin numero ded concepto
//
//            x.setTotalImpuesto(BigDecimal.valueOf(f.getImpuestos()));           //IMPUESTO TRASLADADO
//            x.setBaseImpuesto(BigDecimal.valueOf(f.getSubtotal()));             //BASE TRASLADO
//            x.setImpuesto("002");
//            BigDecimal d = new BigDecimal("0.160000");//tomando en cuenta los 6 decimales
//            x.setTasaCuota(d);
//            generarXML40 xml = new generarXML40();
//            xml.crearComprobante(x, arr, cpt, liteempresa);
//        } catch (Exception ex) {
//            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
