/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.dao_comisiones;
import Modelo.Comision;
import Modelo.Conexiones;
import Modelo.Formateodedatos;
import Modelo.Usuarios;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Comisiones extends javax.swing.JInternalFrame {

    Connection cpt, rcpt, cobranza, cobb;
    Connection litecfdi;
    private Usuarios u;
    private ArrayList<Comision> arra = new ArrayList<>();
    private double total;

    /**
     * Creates new form Materiales
     *
     * @param c
     * @param u
     */
    public Comisiones(Conexiones c, Usuarios u) {
        initComponents();
        cpt = c.getCpttpu();
        cobb = c.getCobranzatpuB();
        this.u = u;
        JlTotal.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop = new javax.swing.JPopupMenu();
        JmSingle = new javax.swing.JMenuItem();
        JmMultiple = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        JtNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        JlTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        JmSingle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Options_36736.png"))); // NOI18N
        JmSingle.setText("Todos");
        JmSingle.setToolTipText("Genera el pago de todos los registros encontrados");
        JmSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSingleActionPerformed(evt);
            }
        });
        pop.add(JmSingle);

        JmMultiple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Options_36737.png"))); // NOI18N
        JmMultiple.setText("Seleccion");
        JmMultiple.setToolTipText("Genera el pago de acuerdo a los registros seleccionados en la tabla");
        JmMultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMultipleActionPerformed(evt);
            }
        });
        pop.add(JmMultiple);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Comisiones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cash_40532.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        JtNombre.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtNombre.setBorder(null);
        JtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtNombreMousePressed(evt);
            }
        });
        JtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtNombreActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JlTotal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("TOTAL");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        jLabel7.setToolTipText("Ejecutar reporte");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtNombreMousePressed
        JtNombre.setText("");
    }//GEN-LAST:event_JtNombreMousePressed

    private void JtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtNombreActionPerformed
        setrows();
    }//GEN-LAST:event_JtNombreActionPerformed

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        checkseleccion();
    }//GEN-LAST:event_JtDetalleMousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        pop.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel7MousePressed

    private void JmSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSingleActionPerformed
        generapagocomision();
    }//GEN-LAST:event_JmSingleActionPerformed

    private void JmMultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMultipleActionPerformed
        validaseleccion();
        generapagocomision();
    }//GEN-LAST:event_JmMultipleActionPerformed

    /**
     * Funcion para realizar el pago de las comisiones a los agentes
     */
    private void generapagocomision() {
        int input = JOptionPane.showConfirmDialog(null,
                "Estas seguro/a que quieres realizar el pago al agente?, "
                + "\n ", "Selecciona una opcion",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            dao_comisiones dc = new dao_comisiones();
            if (dc.Comisionpagada(cpt, arra)) {
                JOptionPane.showMessageDialog(null, "Pago realizado con Exito");
                setrows();
            } else {
                JOptionPane.showMessageDialog(null, "Error",
                        "Pago realizado con Exito", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Hace la busqueda de registros de acuerdo al turno
     */
    private void setrows() {
        Formateodedatos fd = new Formateodedatos();
        dao_comisiones dc = new dao_comisiones();
        arra = dc.getcomisiones_toadm(cpt, JtNombre.getText(), fd.getbd_tocargo(u.getTurno()));
        settable();
    }

    /**
     * Despliega la tabla de acuerdo a los registros obtenidos previamente
     */
    private void settable() {
        total = 0;
        double pretotal = 0;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agente");
        model.addColumn("Referencia");
        model.addColumn("Importe");
        model.addColumn("Fecha");
        model.addColumn("Dias");
        model.addColumn("Porcentaje");
        model.addColumn("Comision");
        model.addColumn("Estatus");
        model.addColumn("Seleccion");
        model.setNumRows(arra.size());
        JtDetalle.setModel(model);
        for (int i = 0; i < arra.size(); i++) {
            String estado = (arra.get(i).getEstatus().equals("1")) ? "Pendiente" : "Pagado";
            model.setValueAt(arra.get(i).getNagente(), i, 0);
            model.setValueAt(arra.get(i).getReferencia(), i, 1);
            model.setValueAt(arra.get(i).getImporte(), i, 2);
            model.setValueAt(arra.get(i).getFecha(), i, 3);
            model.setValueAt(arra.get(i).getDias(), i, 4);
            model.setValueAt(arra.get(i).getPorcentaje(), i, 5);
            model.setValueAt(arra.get(i).getComision(), i, 6);
            model.setValueAt(estado, i, 7);
            model.setValueAt("", i, 8);
            pretotal += arra.get(i).getComision();
        }
        Formateodedatos fd = new Formateodedatos();
        JlTotal.setText(fd.formatdecimalv2(pretotal) + "");
    }

    /**
     * Actualiza la tabla y el total de comision a pagar
     */
    private void checkseleccion() {
        int row = JtDetalle.getSelectedRow();
        Formateodedatos fd = new Formateodedatos();
        String sel = JtDetalle.getValueAt(row, 8).toString();
        total = 0;
        int pretotal = 0;
        //Si encunetra el caracter lo marcará como vacio
        if (sel.equals("*")) {
            JtDetalle.setValueAt("", row, 8);
        } else {
        //Si encuentra como vacio lo marcará como "*"    
            JtDetalle.setValueAt("*", row, 8);
        }
        for (int i = 0; i < arra.size(); i++) {
            sel = JtDetalle.getValueAt(i, 8).toString();
            if (sel.equals("*")) {
                pretotal += arra.get(i).getComision();
            }
        }
        //Formatear total y no salga con decimales extra
        total = fd.formatdecimalv2(pretotal);
        JlTotal.setText(total + "");
    }
    
    /**
     * Elimina registros del array y solo tomar los seleccionados
     */
    private void validaseleccion(){
        for (int i = arra.size()-1; i >= 0; i--) {
            String sel = JtDetalle.getValueAt(i, 8).toString();
            if (!sel.equals("*")) {
                arra.remove(i);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlTotal;
    private javax.swing.JMenuItem JmMultiple;
    private javax.swing.JMenuItem JmSingle;
    private javax.swing.JTable JtDetalle;
    public javax.swing.JTextField JtNombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}
