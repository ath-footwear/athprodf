/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import DAO.dao_comisiones;
import DAO.daoempresa;
import DAO.daofactura_tpu;
import Modelo.Comision;
import Modelo.Empresas;
import Modelo.Formateo_Nempresas;
import Modelo.Formateodedatos;
import Modelo.Usuarios;
import Modelo.convertnum;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GATEWAY1-
 */
public class pagotpurem1 extends javax.swing.JPanel {

    public String empresa, empresacob;
    public Connection sqlcfdi, sqlempresa;
    public Connection cpt, ACobranza;
    public Usuarios u;
    ArrayList<factura> arrfactura = new ArrayList<>();
    int estado = 0;
    int ciudad = 0;
    int pais = 0;

    /**
     * Creates new form Cliente1
     */
    public pagotpurem1() {
        initComponents();
        JtCliente.requestFocus();
//        iniciarconexiones();
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
        JtCancelar = new javax.swing.JMenuItem();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        JtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JtCancelar.setText("Cancelar Pago");
        JtCancelar.setToolTipText("");
        JtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCancelarActionPerformed(evt);
            }
        });
        pop.add(JtCancelar);

        setBackground(new java.awt.Color(255, 255, 255));

        JtCliente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        JtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCliente.setBorder(null);
        JtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("# Cliente");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtClienteActionPerformed
        Buscanotas();
    }//GEN-LAST:event_JtClienteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int row = JtDetalle.getSelectedRow();
        int folio = arrfactura.get(row).getId();
        double total = arrfactura.get(row).getTotal();
        setreport(folio, "MXN", total);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed

    }//GEN-LAST:event_jLabel6MousePressed

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        if (evt.getButton() == 3) {// activar con clic derecho
            pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed


    private void JtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCancelarActionPerformed
        int input = JOptionPane.showConfirmDialog(null,
                "Estas seguro que quieres cancelar?", "Advertencia",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
//            Obtiene los registros por si las facturas relacionadas tienen algun pago
            int row = JtDetalle.getSelectedRow();
            int folio = arrfactura.get(row).getId();
//            System.out.println("folio "+folio);
            Formateodedatos fd = new Formateodedatos();
            daofactura_tpu df = new daofactura_tpu();
            ArrayList<factura> arr
                    = df.getregspcancelpagotpu(cpt, folio,
                            fd.getB_or_Amovs(u.getTipo_usuario(), u.getTurno(), "B"), "RPAG");
            if (!arr.isEmpty()) {
                if (df.execcancelacionPago(cpt, ACobranza, arr)) {
                    JOptionPane.showMessageDialog(null, "Proceso terminado \n ");
                    cancelacomision(cpt, arr);
                    Buscanotas();
                }
            }
        }
    }//GEN-LAST:event_JtCancelarActionPerformed

    /**
     * DEspliega el reporte del pago
     *
     * @param folio
     * @param moneda
     * @param total
     */
    private void setreport(int folio, String moneda, double total) {
        try {
            String conformidad = (!moneda.equals("MXN")) ? "De conformidad con el Art. 20 del C.F.F., informamos que "
                    + "para convertir moneda extranjera a su equivalente en moneda nacional, el tipo de cambio a "
                    + "utilizar para efectos de pagos será el que publique el Banco de México en el Diario Oficial "
                    + "de la Federación el día habil anterior al día de pago. Para su consulta: www.banxico.org.mx "
                    + "(sección: Mercado cambiario/Tipos de cambio para solventar obligaciones denominadas en dólares de los Ee.Uu:A., pagaderas en la República Mexicana)" : " ";
            daoempresa d = new daoempresa();
//            Identificar si es de ath o uptown
            Formateo_Nempresas fn = new Formateo_Nempresas();
            Formateodedatos fd = new Formateodedatos();
            String n = fn.getEmpresa(u.getTurno(), "");
            String logo = fd.getimagenreporte(u);
            Empresas e = d.getempresarfc(sqlempresa, n);
//             fin identificar empresa
            Map parametros = new HashMap();
//            Clase que contiene el numero convertido a caracter
            convertnum conv = new convertnum();
//            Agregar parametros al reporte
            parametros.put("folio", folio);
            parametros.put("totalletra", conv.controlconversion(total).toUpperCase());
            parametros.put("nombre", e.getNombre());
            parametros.put("rfc", e.getRfc());
            parametros.put("regimen", "");
            parametros.put("lugar", e.getCp());
            parametros.put("comprobante", e.getNumcertificado());
            parametros.put("logo", logo);// direcion predefinida, posible cambiar en un futuro
            parametros.put("serie", "RPAG");
            parametros.put("regimencliente", "");
            parametros.put("confo", conformidad);
            parametros.put("bd", "");

            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportestpu/index_ptpu_REM.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("RPAG " + folio);
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pagotpurem1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Obtiene todas las notas de acuerdo a lo que se introduzca en el campo
    private void Buscanotas() {
        generatabla();
    }

    /**
     * Genera y da valor a cada una de las lineas y columnas de la tabla
     */
    private void generatabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Pago");
        model.addColumn("Cliente");
        model.addColumn("Total pago");
        model.addColumn("fecha");
        model.addColumn("fecha pago");
        model.addColumn("observaciones");
        model.addColumn("Estado sat");
        daofactura_tpu d = new daofactura_tpu();
        arrfactura = d.getdocspagosremi(cpt, JtCliente.getText());
        int tamaño = arrfactura.size();
        model.setRowCount(tamaño);
        for (int i = 0; i < arrfactura.size(); i++) {
            String a = (arrfactura.get(i).getEstatus() == 1) ? "Activo" : "Inactivo";
            model.setValueAt(arrfactura.get(i).getFolio(), i, 0);
            model.setValueAt(arrfactura.get(i).getNombre(), i, 1);
            model.setValueAt(arrfactura.get(i).getTotal(), i, 2);
            model.setValueAt(arrfactura.get(i).getFecha(), i, 3);
            model.setValueAt(arrfactura.get(i).getFechapago(), i, 4);
            model.setValueAt(arrfactura.get(i).getObservaciones(), i, 5);
            model.setValueAt(a, i, 6);
        }
        JtDetalle.setModel(model);
    }

    /**
     * Funcion que busca la comision generada en su momento si es que termino de
     * pagar y la cancela, con esto se refiere a que no se podra ver ni tomar su
     * valor en cuanta
     *
     * @param cpt
     * @param arr
     */
    public void cancelacomision(Connection cpt, ArrayList<factura> arr) {
        dao_comisiones dc = new dao_comisiones();
        ArrayList<Comision> arrcomi = new ArrayList<>();
        for (factura arr1 : arr) {
            Comision com = new Comision();
            com.setId_cargo(arr1.getIdcargo());
            com.setSerie("B");
            com.setReferencia(arr1.getReferenciafac());
            arrcomi.add(com);
        }
        dc.cancelacomision_pagos(cpt, arrcomi);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JtCancelar;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}
