/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panelmaq;

import DAO.daoPedidos;
import Modelo.Dfactura;
import Modelo.Formateo_Nempresas;
import Modelo.Formateodedatos;
import Modelo.Usuarios;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Modificaprecio_pedido extends javax.swing.JDialog {

    private Connection cpt, cobB;
    private factura f;
    private ArrayList<Dfactura> arr = new ArrayList<>();
    private double total = 0;
    private Usuarios u;

    /**
     * Creates new form Modificaprecio_pedido
     */
    public Modificaprecio_pedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Asigna el valor de la conexion a las nuevas variables para su uso
     *
     * @param cpt
     * @param cob
     * @param f
     */
    public void setconections(Connection cpt, Connection cob, factura f, Usuarios u) {
        this.cpt = cpt;
        this.cobB = cob;
        this.f = f;
        this.u = u;
        JlPedido.setText(f.getPedido());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JlPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JlTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bordeazul.png")))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Modificacion de precios sobre el pedido");

        JlPedido.setBackground(new java.awt.Color(255, 255, 255));
        JlPedido.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total");

        JlTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Refresh_36729.png"))); // NOI18N
        jLabel5.setToolTipText("Actualiza Total e importes");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(JlPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
//Verifica que los datos sean integros y no haya algun tipo de filtrado de caracter invalido
        actualizaimportes();
        if (checkcampos() && !arr.isEmpty()) {
            setupdatepedido();
        } else {
            JOptionPane.showMessageDialog(null, "Verifica tus cantidades!, no puedes "
                    + "introducir letras u otro caracter ademas que el precio sea distinto de cero", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel3MousePressed

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        actualizaimportes();
    }//GEN-LAST:event_JtDetalleMousePressed

    private void JtDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMouseClicked
        actualizaimportes();
    }//GEN-LAST:event_JtDetalleMouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        actualizaimportes();
    }//GEN-LAST:event_jLabel5MousePressed

    /**
     * Obtiene los datos de el detalle de factura con los datos que se tiene de
     * la factura y crea la tabla con esos valores
     */
    public void llenatabla() {
// Verifica que sea un usuario o si esta en modo de pruebas y asigna la ruta adecuada
// Es necesario especificar el turno ya que puede haber mas de 1 empresa
        Formateodedatos fd = new Formateodedatos();
        String tipo = fd.getB_or_Amovs(u.getTipo_usuario(), u.getTurno(), "B");
        DefaultTableModel model = new DefaultTableModel();
        daoPedidos dp = new daoPedidos();
        arr = dp.getdetpedidos(cpt, f, tipo);
        model.setNumRows(arr.size());
        model.addColumn("Material");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Importe");
        JtDetalle.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            String material = arr.get(i).getDescripcion() + " " + arr.get(i).getDureza();
            model.setValueAt(material, i, 0);
            model.setValueAt(arr.get(i).getCantidadfloat(), i, 1);
            model.setValueAt("0", i, 2);
            model.setValueAt("0", i, 3);
        }
    }

    /**
     * Actualizacion de importes por linea y el total de los importes
     */
    private void actualizaimportes() {
        Formateodedatos format = new Formateodedatos();
//        Seteamos el total a cero para volver a hacer la sumatoria
        total = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!format.verificafloat(JtDetalle.getValueAt(i, 2).toString())) {
                JOptionPane.showMessageDialog(null, "Verifica tus cantidades!, no puedes introducir letras u otro caracter", null, JOptionPane.ERROR_MESSAGE);
                JtDetalle.setValueAt("0", i, 2);
                break;
            } else {
//                Obtenemos la cantidad del array y el precio de la tabla
                double precio = Double.parseDouble(JtDetalle.getValueAt(i, 2).toString());
                double cantidad = arr.get(i).getCantidadfloat();
                double importe = format.formatdecimal(cantidad * precio);
                JtDetalle.setValueAt(importe, i, 3);
                total += importe;
                JlTotal.setText(total + "");
            }
        }
    }

    private void setupdatepedido() {
        Formateodedatos format = new Formateodedatos();
        for (int i = 0; i < arr.size(); i++) {
            Dfactura df = arr.get(i);
            double precio = Double.parseDouble(JtDetalle.getValueAt(i, 2).toString());
            double cantidad = arr.get(i).getCantidadfloat();
            double importe = format.formatdecimal(cantidad * precio);
            df.setPrecio(precio);
            df.setImporta(importe);
            df.setBase(total);
            arr.set(i, df);
        }
        daoPedidos p = new daoPedidos();
        if (p.updatedpedidos(cpt, cobB, arr)) {
            JOptionPane.showMessageDialog(null, "Proceso Completo");
            vaciarcampos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar precios, llama a sistemas");
        }

    }

    /**
     * Verifica que en los campos no haya caracteres que no sean numero y que
     * esos datos sean distinto de cero
     *
     * @return
     */
    private boolean checkcampos() {
        boolean resp = true;
        Formateodedatos format = new Formateodedatos();
        for (int i = 0; i < arr.size(); i++) {
            String precio = JtDetalle.getValueAt(i, 2).toString();
            if (!format.verificafloat(precio) || precio.equals("0")) {
                JtDetalle.setValueAt("0", i, 2);
                JtDetalle.setValueAt("0", i, 3);
                resp = false;
                break;
            }
        }
        return resp;
    }

    private void vaciarcampos() {
        arr.clear();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modificaprecio_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificaprecio_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificaprecio_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificaprecio_pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Modificaprecio_pedido dialog = new Modificaprecio_pedido(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlPedido;
    private javax.swing.JLabel JlTotal;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
