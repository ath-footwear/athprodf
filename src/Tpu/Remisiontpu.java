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
import Paneltpu.fac1tpurem;
import Paneltpu.fac2tpu1rem;
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
public class Remisiontpu extends javax.swing.JInternalFrame {

    fac1tpurem c1;
    fac2tpu1rem c2;
    String var = "0";
    public String name, empresa, empresarcpt, empresacob;
    Connection rcpt, litecfdi, liteempresa, cobranza, cpt,cobB;
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
    public Remisiontpu(Conexiones cn, Usuarios usu) {
        initComponents();
        cpt = cn.getCpttpu();
        rcpt = cn.getRcpttpu();
        cobranza = cn.getCobranzatpu();
        empresa="Tpucpt";
        empresarcpt="Tpurcpt";
        empresacob="ACobranzaTpu";
        cobB=cn.getCobranzatpuB();
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
            Logger.getLogger(Remisiontpu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Remisiontpu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Remisiontpu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setarraylist() {
        daocfdi d = new daocfdi();
        daoClientes dc= new daoClientes();
        arrcliente=dc.getClientestpu(cobB);
        arruso = d.getusocfdi(litecfdi);
        arrmetodo = d.getMetodopago(litecfdi);
        arrforma = d.getFormadepago(litecfdi);
        c2.arrcliente=arrcliente;
        c2.arrfpago = arrforma;
        c2.arrmetodo = arrmetodo;
        c2.arruso = arruso;
        //tambien conexiones y variables
        c2.ACobranza = cobranza;
        c2.rcpt = rcpt;
        c2.sqlempresa = liteempresa;
        c2.sqlcfdi = litecfdi;
        c2.cpt = cpt;
        c2.empresa=empresa;
        c2.empresarcpt=empresarcpt;
        c2.empresacob=empresacob;
        c2.u=u;// datos del usuario
        c2.cobB=cobB;
        
        c1.cpt=cpt;
        c1.ACobranza=cobranza;
        c1.empresa=empresa;
        c1.empresacob=empresacob;
        c1.arrfpago = arrforma;
        c1.arrmetodo = arrmetodo;
        c1.arruso = arruso;
        c1.sqlcfdi=litecfdi;
        c1.sqlempresa=liteempresa;
        c1.rcpt=rcpt;
        c1.u=u;
        c1.JtCliente.requestFocus();
        c1.liteusuario=liteusuario;
        c1.cobB=cobB;
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
        setTitle("Pedidos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirR.png"))); // NOI18N

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
        c1 = new fac1tpurem();
        c2 = new fac2tpu1rem();
        Tabbed.addTab("Listado de Pedidos", c1);
        Tabbed.setSelectedComponent(c1);
        Tabbed.addTab("Nueva Pedido", c2);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
