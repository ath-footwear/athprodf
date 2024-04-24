/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daocfdi;
import Modelo.Cliente;
import Modelo.Conexiones;
import Modelo.Formadepago;
import Modelo.Usuarios;
import Modelo.metodopago;
import Modelo.usocfdi;
import Paneltpu.fac1tpu;
import Paneltpu.fac3tpu;
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
public class FacturacionTpuAth extends javax.swing.JInternalFrame {

    fac1tpu c1;
    fac3tpu c3;
    String var = "0";
    public String name, empresa, empresarcpt, empresacob;
    Connection rcpt, litecfdi, liteempresa, cobranza, cpt,cpttpu;
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
     * @param cn
     * Lista de conexiones
     * @param usu
     * datos de usuario
     */
    public FacturacionTpuAth(Conexiones cn, Usuarios usu) {
        initComponents();
//        Se utilizaran las conexiones de ath y tpu para este proceso
        cpttpu=cn.getCpttpu();
        cpt = cn.getCpt();
        rcpt = cn.getRcpt();
        cobranza = cn.getCobranza();
        empresa="Tpucpt";
        empresarcpt="Tpurcpt";
        empresacob="ACobranza";
        u=usu;
        liteusuario=cn.getLiteusuario();
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
            Logger.getLogger(FacturacionTpuAth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacturacionTpuAth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacturacionTpuAth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setarraylist() {
        daocfdi d = new daocfdi();
//        arrcliente=dc.getClientestpu(cobranza);
        arruso = d.getusocfdi(litecfdi);
        arrmetodo = d.getMetodopago(litecfdi);
        arrforma = d.getFormadepago(litecfdi);
        c3.arrcliente=arrcliente;
        c3.arrfpago = arrforma;
        c3.arrmetodo = arrmetodo;
        c3.arruso = arruso;
        //tambien conexiones y variables
        c3.ACobranza = cobranza;
        c3.rcpt = rcpt;
        c3.sqlempresa = liteempresa;
        c3.sqlcfdi = litecfdi;
        c3.cpt = cpt;
        c3.cpttpu=cpttpu;
        c3.empresa=empresa;
        c3.empresarcpt=empresarcpt;
        c3.empresacob=empresacob;
        c3.u=u;// datos del usuario
//        Por si se nececsita la visualizacion de las facturas de ath
//        c1.cpt=cpt;
//        c1.ACobranza=cobranza;
//        c1.empresa=empresa;
//        c1.empresacob=empresacob;
//        c1.arrfpago = arrforma;
//        c1.arrmetodo = arrmetodo;
//        c1.arruso = arruso;
//        c1.sqlcfdi=litecfdi;
//        c1.sqlempresa=liteempresa;
//        c1.rcpt=rcpt;
//        c1.u=u;
//        c1.JtCliente.requestFocus();
//        c1.liteusuario=liteusuario;
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
        setTitle("Facturacion TPU Athletic");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirP0.png"))); // NOI18N

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
//        c1 = new fac1tpu();
        c3 = new fac3tpu();
//        Tabbed.addTab("Listado de Facturas", c1);
//        Tabbed.setSelectedComponent(c1);
        Tabbed.addTab("Nueva Factura", c3);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
