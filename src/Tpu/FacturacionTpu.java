/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daoClientes;
import DAO.daocfdi;
import Modelo.Cliente;
import Modelo.Conexiones;
import Modelo.Formadepago;
import Modelo.Usuarios;
import Modelo.metodopago;
import Modelo.usocfdi;
import Paneltpu.fac1tpu;
import Paneltpu.fac2tpu;
import Paneltpu.facEtpu;
import Server.Serverylite;
import java.beans.PropertyVetoException;
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
public class FacturacionTpu extends javax.swing.JInternalFrame {

    fac1tpu c1;
    fac2tpu c2;
    facEtpu c3;
    String var = "0";
    public String name, empresa, empresarcpt, empresacob;
    Connection rcpt, litecfdi, liteempresa, cobranza, cpt, cobB;
    public Connection liteusuario;
    ArrayList<usocfdi> arruso = new ArrayList<>();
    ArrayList<Formadepago> arrforma = new ArrayList<>();
    ArrayList<metodopago> arrmetodo = new ArrayList<>();
    ArrayList<Cliente> arrcliente = new ArrayList<>();
    public Conexiones conexion;
    public Usuarios u;

    /**
     * Creates new form Clientes
     *
     * @param cn Lista de conexiones
     * @param usu datos de usuario
     */
    public FacturacionTpu(Conexiones cn, Usuarios usu) {
        initComponents();
        cpt = cn.getCpttpu();
        rcpt = cn.getRcpttpu();
        cobranza = cn.getCobranzatpu();
        cobB = cn.getCobranzatpuB();
        empresa = "Tpucpt";
        empresarcpt = "Tpurcpt";
        empresacob = "ACobranzaTpu";
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
//            System.out.println("cerrada "+cobranza.isClosed());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturacionTpu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacturacionTpu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacturacionTpu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setarraylist() {
        daocfdi d = new daocfdi();
        daoClientes dc = new daoClientes();
        arrcliente = dc.getClientestpu(cobranza);
        arruso = d.getusocfdi(litecfdi);
        arrmetodo = d.getMetodopago(litecfdi);
        arrforma = d.getFormadepago(litecfdi);
        //Facturacion normal
        c2.arrcliente = arrcliente;
        c2.arrfpago = arrforma;
        c2.arrmetodo = arrmetodo;
        c2.arruso = arruso;
        //tambien conexiones y variables
        c2.ACobranza = cobranza;
        c2.cobB = cobB;
        c2.rcpt = rcpt;
        c2.sqlempresa = liteempresa;
        c2.sqlcfdi = litecfdi;
        c2.cpt = cpt;
        c2.empresa = empresa;
        c2.empresarcpt = empresarcpt;
        c2.empresacob = empresacob;
        c2.u = u;// datos del usuario
        c2.ncargo();

        //Vista de documentos
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
        if (u.getTurno().equals("7")) {
            //Facturacion especial
            c3.arrcliente = arrcliente;
            c3.arrfpago = arrforma;
            c3.arrmetodo = arrmetodo;
            c3.arruso = arruso;
            //tambien conexiones y variables
            c3.ACobranza = cobranza;
            c3.cobB = cobB;
            c3.rcpt = rcpt;
            c3.sqlempresa = liteempresa;
            c3.sqlcfdi = litecfdi;
            c3.cpt = cpt;
            c3.empresa = empresa;
            c3.empresarcpt = empresarcpt;
            c3.empresacob = empresacob;
            c3.u = u;// datos del usuario
            c3.cargacombos();
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
        setMaximizable(true);
        setTitle("Facturacion");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtir.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

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

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
     
    }//GEN-LAST:event_formInternalFrameClosed
    public final void generaciontab() {//generar tabs
        c1 = new fac1tpu();
        c2 = new fac2tpu();
        c3 = new facEtpu();
        Tabbed.addTab("Listado de Facturas", c1);
        Tabbed.setSelectedComponent(c1);
        Tabbed.addTab("Nueva Factura", c2);
        //Por ahora solo aplica para
        if (u.getTurno().equals("7")) {
            Tabbed.addTab("Facturacion Especial", c3);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
