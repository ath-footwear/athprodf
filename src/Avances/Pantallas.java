/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avances;

import DAO.daoAvances;
import Modelo.pantalla;
import Server.Serverprod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Pantallas extends javax.swing.JInternalFrame {

    Connection c;
    ArrayList<pantalla> arr = new ArrayList<>();
    public int cantidaddehoras=0;

    /**
     * Creates new form Respaldos
     */
    public Pantallas() {
        try {
            initComponents();
            Serverprod s = new Serverprod();
//            c = s.getconexionTPU("Avances");
            c = s.getconexionserver8("Avances");
            setempresas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pantallas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pantallas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pantallas.class.getName()).log(Level.SEVERE, null, ex);
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

        Menu = new javax.swing.JPopupMenu();
        JmHr = new javax.swing.JMenuItem();
        JmDia = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtEmpresa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        JmHr.setText("Actualiza cantidad x hora");
        JmHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmHrActionPerformed(evt);
            }
        });
        Menu.add(JmHr);

        JmDia.setText("Actualiza cant. x dia");
        JmDia.setEnabled(false);
        JmDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDiaActionPerformed(evt);
            }
        });
        Menu.add(JmDia);

        setClosable(true);
        setIconifiable(true);
        setTitle("Configuracion de pantallas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/mac_icon-icons.com_54610.png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        try {
//            System.out.println("cerrar avances");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pantallas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void JtEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtEmpresaMousePressed
        if (evt.getButton() == 3) {
            Menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtEmpresaMousePressed

    private void JmHrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmHrActionPerformed

    }//GEN-LAST:event_JmHrActionPerformed

    private void JmDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDiaActionPerformed
//        String hrs = JOptionPane.showInputDialog(null, "Ingresar nueva cantidad x dia para el departamento");
//        String nombre = arr.get(JtEmpresa.getSelectedRow()).getNombre();
//        if (updatecantidad(Integer.parseInt(hrs), "cantxdia", nombre)) {
//            JOptionPane.showMessageDialog(null, "Exito al modificar");
//            setempresas();
//        }
    }//GEN-LAST:event_JmDiaActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        Nuevapantalla p = new Nuevapantalla(null,true);
        p.c=c;
        p.setVisible(true);
        setempresas();
    }//GEN-LAST:event_jLabel1MousePressed


    private void setempresas() {
//        Iniciar modelo de la tabla para asignacion de datos
        DefaultTableModel model = new DefaultTableModel();
        daoAvances da = new daoAvances();
//        Obtener registros de las pantallas
        arr=da.getpantallas(c);
        model.addColumn("Pantalla");
        model.addColumn("Nombre");
        model.addColumn("Corte");
        model.addColumn("Precorte");
        model.addColumn("Pespunte");
        model.addColumn("Deshebrado");
        model.addColumn("Ojillado");
        model.addColumn("Preacabado");
        model.addColumn("Inspeccion");
        model.addColumn("Montado");
        model.addColumn("Montado2");
        model.addColumn("Montado3");
        model.addColumn("PT");
//        Asignar el numero de renglos de acuerdo al tamaño del array
        model.setNumRows(arr.size());
        JtEmpresa.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            JtEmpresa.setValueAt(arr.get(i).getPantalla(), i, 0);
            JtEmpresa.setValueAt(arr.get(i).getNombre(), i, 1);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getCorte()), i, 2);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getPrecorte()), i, 3);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getPespunte()), i, 4);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getDeshebrado()), i, 5);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getOjillado()), i, 6);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getPreacabado()), i, 7);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getInspeccion()), i, 8);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getMontado()), i, 9);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getMontado2()), i, 10);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getMontado3()), i, 11);
            JtEmpresa.setValueAt(formatdep(arr.get(i).getPt()), i, 12);
        }
    }

    private String formatdep(String dep){
        return (!dep.equals("0"))?"*":"";
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmDia;
    private javax.swing.JMenuItem JmHr;
    private javax.swing.JTable JtEmpresa;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
