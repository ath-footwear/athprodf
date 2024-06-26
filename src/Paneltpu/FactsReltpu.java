/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import Modelo.Almacen;
import Modelo.Combinacion;
import Modelo.Corridas;
import Modelo.cargo;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1- Michel araujo
 */
public class FactsReltpu extends javax.swing.JDialog {

    ArrayList<Almacen> arralma = new ArrayList<>();
    ArrayList<Corridas> arrcorrida = new ArrayList<>();
    ArrayList<Combinacion> arrcomb = new ArrayList<>();
    ArrayList<cargo> arrcargo = new ArrayList<>();
    ArrayList<cargo> arrcargoE = new ArrayList<>();
    ArrayList<cargo> arrcargoseleccion = new ArrayList<>();//cargos seleccionados

    /**
     * 
     */
    public FactsReltpu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/edit-validated_40458.png"));
        setIconImage(icon);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        desplieguecargos();

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
        JlIniciar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtCargo = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 153, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bordeazul16x16.png")))); // NOI18N
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        JlIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        JlIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JlIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlIniciarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlIniciarMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        JtCargo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        JtCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Referencia", "fecha", "Importe", "Descuento", "Plazo", "Saldo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JtCargo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCargoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtCargo);
        if (JtCargo.getColumnModel().getColumnCount() > 0) {
            JtCargo.getColumnModel().getColumn(0).setPreferredWidth(70);
            JtCargo.getColumnModel().getColumn(1).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(2).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(3).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(4).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(5).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(6).setPreferredWidth(10);
            JtCargo.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Refresh_36729.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(JlIniciar)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlIniciar)
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void JlIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlIniciarMouseClicked

    }//GEN-LAST:event_JlIniciarMouseClicked

    private void JlIniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlIniciarMousePressed
        try {
            setearfacs();
        } catch (ParseException ex) {
            Logger.getLogger(FactsReltpu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JlIniciarMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        if (!arrcargoseleccion.isEmpty()) {
            arrcargoseleccion.clear();
        }
        this.dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        desplieguecargos();
    }//GEN-LAST:event_jLabel3MousePressed

    private void JtCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCargoMousePressed
        String active = JtCargo.getValueAt(JtCargo.getSelectedRow(), 7).toString();
        int row = JtCargo.getSelectedRow();
        if (active.equals("")) {
            JtCargo.setValueAt("*", row, 7);// Coloca un asterisco a la tabla
            arrcargoseleccion.add(arrcargo.get(row));// asigna el objeto al arraylist
        } else {
            JtCargo.setValueAt("", JtCargo.getSelectedRow(), 7);
            for (int i = 0; i < arrcargoseleccion.size(); i++) {// busca el elemento deacuerdo a la seleccion
                String ref = arrcargo.get(row).getReferencia();
                if (arrcargoseleccion.get(i).getReferencia().equals(ref)) {
                    arrcargoseleccion.remove(i);// Remueve el elemento de la lista
                    i = arrcargoseleccion.size();
                }
            }
        }
//        System.out.println("---------");
        for (cargo arrcargoseleccion1 : arrcargoseleccion) {
//            System.out.println(arrcargoseleccion1.getReferencia());
        }
//        System.out.println("---------");
    }//GEN-LAST:event_JtCargoMousePressed

    private void desplieguecargos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Referencia");
        model.addColumn("Fecha");
        model.addColumn("Total");
        model.addColumn("Saldo");
        model.addColumn("Folio fiscal");
        model.addColumn("Importe");
        model.addColumn("");
        model.setNumRows(arrcargo.size());
        //Carga las facturas registyradas en cargos
        for (int i = 0; i < arrcargo.size(); i++) {
            model.setValueAt(arrcargo.get(i).getNombre(), i, 0);
            model.setValueAt(arrcargo.get(i).getReferencia(), i, 1);
            model.setValueAt(arrcargo.get(i).getFecha(), i, 2);
            model.setValueAt(arrcargo.get(i).getImporte(), i, 3);
            model.setValueAt(arrcargo.get(i).getSaldo(), i, 4);
            model.setValueAt(arrcargo.get(i).getFoliofiscal(), i, 5);
            model.setValueAt("0", i, 6);
            model.setValueAt("", i, 7);
        }
        JtCargo.setModel(model);
    }

    private void setearfacs() throws ParseException {
        boolean reset = true;
        if (!arrcargoseleccion.isEmpty()) {
            //Verificar renglon por renglon el dato del descuento y asignarselo al arreglo
            for (int i = 0; i < arrcargoseleccion.size(); i++) {
                int renglon=arrcargoseleccion.get(i).getRenglon();
                String desc = JtCargo.getValueAt(renglon, 6).toString();
                if (verificaciones(desc)) {
                    if (Float.parseFloat(desc) >= arrcargoseleccion.get(i).getImporte()) {
                        JOptionPane.showMessageDialog(null, "Introduzca correctamente un numero valido");
                        reset = false;
                        break;
                    } else {
                        cargo car = arrcargoseleccion.get(i);// almacena el cargo en un objeto para modificar valores
                        car.setDescuento(Float.parseFloat(desc));
                        arrcargoseleccion.set(i, car);// asigna de nuevo el cargo ya modificado
//                        System.out.println("descuento " + desc);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Alguno de los valores que introdujo no es valido");
                    reset = false;
                    break;
                }
            }
            if (reset) {
                this.dispose();
            }

        }
    }

    private boolean verificaciones(String r) {
        boolean resp = false;
//        System.out.println("valida "+r);
        if (!r.equals("") && (verificafloat(r) || verificaint(r))) {
            resp = true;
        }
        return resp;
    }

    private boolean verificafloat(String cad) {
        boolean resp = false;
        String patt = "[0-9]+||[0-9]+.[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    private boolean verificaint(String cad) {
        boolean resp = false;
        String patt = "[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    private boolean verificastring(String cad) {
        boolean resp = false;
        String patt = "[azAZ ]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    private boolean verificap(String cad) {
        boolean resp = false;
        String patt = "[p]||[s]";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
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
            java.util.logging.Logger.getLogger(FactsReltpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FactsReltpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FactsReltpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FactsReltpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FactsReltpu dialog = new FactsReltpu(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JlIniciar;
    private javax.swing.JTable JtCargo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
