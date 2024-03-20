/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athprod;

import DAO.daoAvances;
import Modelo.Falla;
import Panelavances.Nuevafalla;
import Panelavances.Nuevoanuncio;
import Server.Serverprod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Fallasprod extends javax.swing.JInternalFrame {

    Connection c;
    public String usuario;
    ArrayList<Falla> arr = new ArrayList<>();

    /**
     * Creates new form Respaldos
     */
    public Fallasprod() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        JmActivar = new javax.swing.JMenuItem();
        JmBorrar = new javax.swing.JMenuItem();
        JmActualizar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtEmpresa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        JmActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tickflat_105962.png"))); // NOI18N
        JmActivar.setText("Activar anuncio");
        JmActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmActivarActionPerformed(evt);
            }
        });
        Menu.add(JmActivar);

        JmBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/crosscircleregular_106260.png"))); // NOI18N
        JmBorrar.setText("Eliminar anuncio");
        JmBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBorrarActionPerformed(evt);
            }
        });
        Menu.add(JmBorrar);

        JmActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Refresh_36729.png"))); // NOI18N
        JmActualizar.setText("Actualizar a fecha actual");
        JmActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmActualizarActionPerformed(evt);
            }
        });
        Menu.add(JmActualizar);

        setClosable(true);
        setIconifiable(true);
        setTitle("Configuracion de Fallas de produccion");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/propagation_calculator_calc_6110.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        JtEmpresa.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        JtEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtEmpresa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtEmpresaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtEmpresa);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/new.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        try {
//            System.out.println("cerrar avances");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Fallasprod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void JtEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtEmpresaMousePressed
        if (arr.get(JtEmpresa.getSelectedRow()).getEstatus().equals("1")) {
            JmBorrar.setVisible(true);
            JmActivar.setVisible(false);
        } else {
            JmBorrar.setVisible(false);
            JmActivar.setVisible(true);
        }
        if (evt.getButton() == 3) {
            Menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtEmpresaMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        Nuevafalla n = new Nuevafalla(null, true);
        n.avances = c;
        n.usuario = usuario;
        n.llenacombo();
        n.setVisible(true);
        setempresas();
    }//GEN-LAST:event_jLabel1MousePressed

    private void JmActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmActivarActionPerformed
        accionborrado("1");
    }//GEN-LAST:event_JmActivarActionPerformed

    private void JmBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBorrarActionPerformed
        accionborrado("0");
    }//GEN-LAST:event_JmBorrarActionPerformed

    private void JmActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmActualizarActionPerformed
        accionactualizar();
    }//GEN-LAST:event_JmActualizarActionPerformed

    public void setempresas() {
        DefaultTableModel model = new DefaultTableModel();
        daoAvances da = new daoAvances();
        arr = da.getFallas(c);
        model.addColumn("Pantalla");
        model.addColumn("Observaciones");
        model.addColumn("Fecha");
        model.addColumn("Usuario");
        model.addColumn("Imagen1");
        model.addColumn("Imagen2");
        model.addColumn("Imagen3");
        model.addColumn("Imagen4");
        model.addColumn("Imagen5");
        model.addColumn("Imagen6");
        model.addColumn("Estado");
        model.setNumRows(arr.size());
        JtEmpresa.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            String estatus = (arr.get(i).getEstatus().equals("1")) ? "ACTIVO" : "INACTIVO";
            JtEmpresa.setValueAt(arr.get(i).getNombrepant(), i, 0);
            JtEmpresa.setValueAt(arr.get(i).getObservaciones(), i, 1);
            JtEmpresa.setValueAt(arr.get(i).getFecha(), i, 2);
            JtEmpresa.setValueAt(arr.get(i).getUsuario(), i, 3);
            JtEmpresa.setValueAt(arr.get(i).getDescimag1(), i, 4);
            JtEmpresa.setValueAt(arr.get(i).getDescimag2(), i, 5);
            JtEmpresa.setValueAt(arr.get(i).getDescimag3(), i, 6);
            JtEmpresa.setValueAt(arr.get(i).getDescimag4(), i, 7);
            JtEmpresa.setValueAt(arr.get(i).getDescimag5(), i, 8);
            JtEmpresa.setValueAt(arr.get(i).getDescimag6(), i, 9);
            JtEmpresa.setValueAt(estatus, i, 10);
        }
    }

    private void accionborrado(String tipoaccion) {
        daoAvances da = new daoAvances();
        da.setborrado(c, arr.get(JtEmpresa.getSelectedRow()).getFalla(), tipoaccion, "falla");
        setempresas();
    }

    private void accionactualizar() {
        daoAvances da = new daoAvances();
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        da.setactualizar(c, arr.get(JtEmpresa.getSelectedRow()).getFalla(), "falla", sdf.format(date));
        setempresas();
    }

    public void getconexion() {
        try {
            Serverprod s = new Serverprod();
//            c = s.getconexionTPU("Avances");
            c = s.getconexionserver8("Avances");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nuevoanuncio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Nuevoanuncio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Nuevoanuncio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarcon() {
        try {
            c.close();
            System.out.println("cerrar conexion avance");
        } catch (SQLException ex) {
            Logger.getLogger(Fallasprod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmActivar;
    private javax.swing.JMenuItem JmActualizar;
    private javax.swing.JMenuItem JmBorrar;
    private javax.swing.JTable JtEmpresa;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}