/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athprod;

import DAO.daoPrincipal;
import DAO.daoserver;
import Modelo.Allsingleton;
import Modelo.Usuarios;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 * El login hasta ahora no se usa o usado ya que se evito el uso de captura de
 * usuario y solo utilizar la contraseña
 *
 * @author GATEWAY1-
 */
public class Log extends javax.swing.JFrame {

    /**
     * Creates new form Log
     */
    public Log() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JtUsuario = new javax.swing.JTextField();
        JtContraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesion");

        JtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtUsuarioActionPerformed(evt);
            }
        });

        JtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtContraseñaActionPerformed(evt);
            }
        });

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(JtUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(JtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtUsuarioActionPerformed
        JtContraseña.requestFocus();
    }//GEN-LAST:event_JtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        entrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void entrar() {
        Allsingleton singleton = new Allsingleton();
        String usuario = JtUsuario.getText().toUpperCase();
        String pass = JtContraseña.getText();
        daoserver server = new daoserver();
        Connection con = server.Getconexion();
        //usar metodo de verificar caracter en el singleton
        if (singleton.vericacaracter(usuario) && singleton.vericacaracter(pass)) {
            Usuarios u = new Usuarios();
            daoPrincipal dp = new daoPrincipal();
            u = dp.getUsers(con, usuario, pass, "ñ");//verificar si existe el usuario y contraseña
            if (!u.getUsuario().equals("NO")) {//verificar si existe o no
                //se establecen datos clave en el singleton, como el usuario, conexion a la bd y la serie inicial
                Allsingleton.setUsuario(u);
                Allsingleton.setSerie("A");
                Allsingleton.setC(con);
                Principal p = new Principal();
                this.setVisible(false);
                p.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
                JtUsuario.setText("");
                JtContraseña.setText("");
                JtUsuario.requestFocus();
                server.cerrarConexion();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden colocar caracteres de ningun tipo");
            JtUsuario.setText("");
            JtContraseña.setText("");
            JtUsuario.requestFocus();
            server.cerrarConexion();
        }
    }

    private void JtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtContraseñaActionPerformed
        entrar();
    }//GEN-LAST:event_JtContraseñaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JtContraseña;
    private javax.swing.JTextField JtUsuario;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}