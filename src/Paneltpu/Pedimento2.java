/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import DAO.daoalmacenes;
import DAO.daodurezas;
import DAO.daokardexrcpt;
import DAO.daomateriales;
import DAO.daopedimentos;
import Modelo.Almacen;
import Modelo.Conexiones;
import Modelo.Dpedimento;
import Modelo.Dureza;
import Modelo.Formateodedatos;
import Modelo.Materiales;
import Modelo.ProveedorMPrima;
import Modelo.Usuarios;
import Modelo.pedimento;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author GATEWAY1-
 */
public class Pedimento2 extends javax.swing.JPanel implements NativeKeyListener {

    Conexiones c = new Conexiones();
    Usuarios u = new Usuarios();
    public ArrayList<ProveedorMPrima> arrprov = new ArrayList<>();
    ArrayList<Materiales> arrmat = new ArrayList<>();
    ArrayList<Materiales> arrmatseleccion = new ArrayList<>();
    ArrayList<Almacen> arralm = new ArrayList<>();
    ArrayList<Dureza> arrdur = new ArrayList<>();

    double total = 0;
    String serie = "A";
    int clic = 0;
    int clic2 = 0;
    int clic3 = 0;

    /**
     * Creates new form Pedimento1
     */
    public Pedimento2(Conexiones co, Usuarios u) {
        initComponents();
        this.c = co;
        this.u = u;
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
        JmBorrar = new javax.swing.JMenuItem();
        jLabel6 = new javax.swing.JLabel();
        JcProveedor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        JtPedimento = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtObservaciones = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JlTotal = new javax.swing.JLabel();
        JlSerie = new javax.swing.JLabel();

        JmBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JmBorrar.setText("Eliminar renglon");
        JmBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBorrarActionPerformed(evt);
            }
        });
        pop.add(JmBorrar);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Fecha Pedimento");

        JcProveedor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Proveedor");

        JtPedimento.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtPedimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtPedimento.setBorder(null);
        JtPedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtPedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtPedimentoMousePressed(evt);
            }
        });
        JtPedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtPedimentoActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Pedimento");

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
        JtDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/new.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Observaciones");

        JtObservaciones.setColumns(20);
        JtObservaciones.setRows(5);
        jScrollPane2.setViewportView(JtObservaciones);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Total:");

        JlTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JlTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JlSerie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/sticker_120054A.png"))); // NOI18N
        JlSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlSerieMousePressed(evt);
            }
        });
        JlSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JlSerieKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 1225, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JlSerie))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(10, 10, 10)
                                        .addComponent(JcProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JtPedimento)
                                            .addComponent(jSeparator2))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlSerie)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JcProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtPedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(JlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JtPedimentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtPedimentoMousePressed
        JtPedimento.setText("");
    }//GEN-LAST:event_JtPedimentoMousePressed

    private void JtPedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtPedimentoActionPerformed

    }//GEN-LAST:event_JtPedimentoActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        NuevomatPedimento n = new NuevomatPedimento(null, true);
        daomateriales am = new daomateriales();
        daoalmacenes da = new daoalmacenes();
        daodurezas dd = new daodurezas();
//        Ejecuta la consulta adecuada al turno
        if (u.getTurno().equals("5")) {
            arrmat = am.getmateriales(c.getCpttpu(), "", "5");
        } else {
            arrmat = am.getmaterialesmaq(c.getCpttpu(), "");
        }
        arralm = da.getalmacenescpt(c.getCpttpu());
        arrdur = dd.getdurezas(c.getCpttpu());
        n.u = u;
        n.arrmat = arrmat;
        n.arralm = arralm;
        n.arrdur = arrdur;
        n.setcombos();
        n.setVisible(true);
        if (!n.getmaterial().getDescripcion().equals("")) {
            arrmatseleccion.add(n.getmaterial());
            cargatabla();
        }

    }//GEN-LAST:event_jLabel1MousePressed

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        if (evt.getButton() == 3) {// activar con clic derecho
            pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed

    private void JmBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBorrarActionPerformed
//        System.out.println(JtDetalle.getSelectedRow() + " - " + arrmatseleccion);
        if (!arrmatseleccion.isEmpty()) {
            int row = JtDetalle.getSelectedRow();
            arrmatseleccion.remove(row);
            cargatabla();
        }
    }//GEN-LAST:event_JmBorrarActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        Formateodedatos fdato = new Formateodedatos();
//        Es importante hacer esta validacion y que no se nos vaya algun caracter especial y nos truene algo que no deberia
        boolean flag = fdato.verificaStringsSC(JtPedimento.getText());
        boolean flag1 = fdato.verificaStringsSC(JtObservaciones.getText());
        boolean flag2 = (JtPedimento.getText().equals("0"));
        if (!flag) {
            JtPedimento.requestFocus();
        }
        if (!flag1) {
            JtObservaciones.requestFocus();
        }
        if (flag2) {
            JOptionPane.showMessageDialog(null, "No puedes dar de alta otro pedimento 0");
            JtPedimento.requestFocus();
            JtPedimento.setText("");
        }
        if (flag && flag1 && !flag2) {
            setpedimento();
        } else {
            JOptionPane.showMessageDialog(null, "Solamente puedes escribir letras y numeros");
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void setpedimento() {
        if (arrmatseleccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Antes debes de seleccionar materiales al pedimento");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            java.util.Date date = new Date();
            pedimento p = new pedimento();
            String fpedimento = sdf.format(Fecha.getDate());
            daopedimentos dped = new daopedimentos();
            String fecha = sdf.format(date);
            daokardexrcpt dk = new daokardexrcpt();
            p.setId_kardex(dk.maxkardexsincuenta(c.getCpttpu()));
            double canttotal = 0;
            total = 0;
            ArrayList<Dpedimento> arr = new ArrayList<>();
            for (int i = 0; i < arrmatseleccion.size(); i++) {
                Dpedimento dp = new Dpedimento();
                double precio = arrmatseleccion.get(i).getPrecio();
                double costo = arrmatseleccion.get(i).getCosto();
                double cant = arrmatseleccion.get(i).getCantidad();
                double importe = costo * cant;
                String matped = arrmatseleccion.get(i).getMaterialpedimento();
                int almacen = arrmatseleccion.get(i).getId_almacen();
                total += importe;
                canttotal += cant;
                dp.setId_material(arrmatseleccion.get(i).getId_material());
                dp.setDureza(arrmatseleccion.get(i).getDureza());
                dp.setCantidad(BigDecimal.valueOf(cant).setScale(2).doubleValue());
                dp.setPrecio(BigDecimal.valueOf(precio).setScale(2).doubleValue());
                dp.setImporte(BigDecimal.valueOf(importe).setScale(2).doubleValue());
                dp.setCantrestante(BigDecimal.valueOf(cant).setScale(2).doubleValue());
                dp.setCosto(BigDecimal.valueOf(costo).setScale(2).doubleValue());
                dp.setId_almacen(almacen);
                dp.setMatped(matped);
                dp.setImpuesto(0);
                arr.add(dp);
            }
            p.setObservaciones(JtObservaciones.getText().toUpperCase());
            p.setArr(arr);
            p.setTotal(total);
            p.setSubtotal(total);
            p.setTcantidad(canttotal);
            p.setImpuestos(0);
            p.setReferencia(JtPedimento.getText().toUpperCase());
            p.setId_proveedor(arrprov.get(JcProveedor.getSelectedIndex()).getProveedor());

            p.setFecha(fecha);
            p.setFechapedimento(fpedimento);
            p.setUsuario(u.getUsuario());
            p.setSerie("A");
            if (dped.nuevopedimento(c.getCpttpu(), c.getRcpttpu(), p)) {
                JOptionPane.showMessageDialog(null, "Proceso completo");
                limpiar();
                cargatabla();
                JtPedimento.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Error al completar, intentelo de nuevo");
            }
        }
    }

    private void limpiar() {
        JtPedimento.setText("");
        JtObservaciones.setText("");
        arrmatseleccion.clear();
    }

    private void JlSerieMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSerieMousePressed
        if (evt.getButton() == 1) {
            clic++;
        }
        if (evt.getButton() == 3) {
            clic3++;
        }
        if (evt.getButton() == 2) {
            clic2++;
            String combinacion = clic + "" + clic2 + "" + clic3;
//            System.out.println(combinacion);
            if (combinacion.equals("211")) {
                if (serie.equals("A")) {
                    serie = "B";
                    JlSerie.setIcon(new ImageIcon(getClass().getResource("/Recursos/sticker_120054B.png")));// carga de logo
                } else {
                    serie = "A";
                    JlSerie.setIcon(new ImageIcon(getClass().getResource("/Recursos/sticker_120054A.png")));// carga de logo
                }
                clic = 0;
                clic2 = 0;
                clic3 = 0;
            }
        }
    }//GEN-LAST:event_JlSerieMousePressed

    private void JlSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JlSerieKeyPressed
    }//GEN-LAST:event_JlSerieKeyPressed

    private void cargatabla() {
        total = 0;
        DecimalFormat formateador = new DecimalFormat("####.##");
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Material");
        model.addColumn("Material pedimento");
        model.addColumn("Precio");
        model.addColumn("Costo");
        model.addColumn("cantidad");
        model.addColumn("Unidad");
        Formateodedatos fd = new Formateodedatos();
        model.setNumRows(arrmatseleccion.size());
        for (int i = 0; i < arrmatseleccion.size(); i++) {
            double cant = arrmatseleccion.get(i).getCantidad();
            double precio = arrmatseleccion.get(i).getPrecio();
            double costo = arrmatseleccion.get(i).getCosto();
            model.setValueAt(fd.getmatdescripcion_withturno(
                    u.getTurno(), arrmatseleccion.get(i)), i, 0);
            model.setValueAt(arrmatseleccion.get(i).getMaterialpedimento(), i, 1);
            model.setValueAt(precio, i, 2);
            model.setValueAt(costo, i, 3);
            model.setValueAt(cant, i, 4);
            model.setValueAt(arrmatseleccion.get(i).getUnidad(), i, 5);
            total += costo * cant;
        }
        JtDetalle.setModel(model);
        JlTotal.setText(formateador.format(total));
    }

    public void setcombos() {
        DefaultComboBoxModel mate = new DefaultComboBoxModel();
        for (ProveedorMPrima arrmat1 : arrprov) {
            mate.addElement(arrmat1.getNombre());
        }
        JcProveedor.setModel(mate);
    }

    private String getmatformat(String mat) {
        String resp = "";
        for (int i = 0; i < mat.length(); i++) {
            String caracter = mat.charAt(i) + "";
            if (!caracter.equals(" ")) {
                resp += caracter;
            }
        }
        return resp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JComboBox<String> JcProveedor;
    private javax.swing.JLabel JlSerie;
    private javax.swing.JLabel JlTotal;
    private javax.swing.JMenuItem JmBorrar;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JTextArea JtObservaciones;
    public javax.swing.JTextField JtPedimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        if (nke.getKeyCode() == NativeKeyEvent.VK_A) {
//            System.out.println("f12");
            String combinacion = clic + "" + clic2 + "" + clic3;

        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
