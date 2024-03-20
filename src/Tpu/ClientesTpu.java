/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daoClientes;
import Dao.Dao_Agente;
import Modelo.Cliente;
import Modelo.Conexiones;
import Modelo.Formateodedatos;
import Modelo.Usuarios;
import Paneltpu.ClienteUpdate;
import Paneltpu.Clientetpu1;
import Paneltpu.Clientetpu2;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class ClientesTpu extends javax.swing.JInternalFrame {

    Clientetpu1 c1;
    Clientetpu2 c2;
    Cliente cli;
    String var = "0";
    public String name;
    Usuarios u;
    Conexiones con;
    ArrayList<Cliente> arr = new ArrayList<>();
    int clic = 0;
    int clic2 = 0;
    int clic3 = 0;
    String serie = "A";

    /**
     * Creates new form Clientes
     *
     * @param co
     * @param u
     */
    public ClientesTpu(Conexiones co, Usuarios u) {
        initComponents();
        JtBuscar.requestFocus();
        this.u = u;
        this.con = co;
        generaciontab();//Tabs de cliente

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
        JtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlCliente = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        JlSerie = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Tabbed = new javax.swing.JTabbedPane();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensauser.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JtBuscar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        JtBuscar.setBorder(null);
        JtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtBuscarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Magnifier_29783.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bordeazul.png")))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486485588-add-create-new-math-sign-cross-plus_81186.png"))); // NOI18N
        jLabel2.setToolTipText("Crear Nuevo cliente");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationsgraphicsdrawing_103768.png"))); // NOI18N
        jLabel3.setToolTipText("Editar registro");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        jLabel4.setToolTipText("Deshabilitar cliente");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cloudrefresh_icon-icons.com_54403.png"))); // NOI18N
        jLabel5.setToolTipText("Actualiza cliente de CPT a TPU");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(124, 124, 124)
                .addComponent(jLabel3)
                .addGap(124, 124, 124)
                .addComponent(jLabel4)
                .addGap(117, 117, 117)
                .addComponent(jLabel5)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JlCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JlCliente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JlCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JlCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JlCliente);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(JtBuscar)))
                    .addComponent(JlSerie))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JtBuscar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JlSerie))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Tabbed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        if (checkcampos() && checkcampos_campocliente()) {
            Cliente client = c1.getCliente();
//            client.setNombre(c1.JtNombre.getText().toUpperCase());
//            client.setRfc(c1.JtRfc.getText().toUpperCase());
//            client.setTelefono(c1.JtTelefono.getText());
//            client.setCorreo(c1.JtCorreo.getText());
//            client.setCalle(c1.JtCalle.getText().toUpperCase());
//            client.setColonia(c1.JtColonia.getText().toUpperCase());
//            client.setCp(c1.JtCp.getText());
//            client.setPais(c1.JtPais.getText().toUpperCase());
//            client.setEstado(c1.JtEstado.getText().toUpperCase());
//            client.setCiudad(c1.JtCiudad.getText().toUpperCase());
//            client.setNombreagente(c1.JtContacto.getText().toUpperCase());
//            client.setUsocfdi(c1.JtUso.getText().toUpperCase());
//            client.setRegimen(c1.JtRegimen.getText().toUpperCase());
//            client.setCuenta(c1.JtBanco.getText().toUpperCase());
//            client.setUsocfdi(c1.JtUso.getText().toUpperCase());
            daoClientes d = new daoClientes();
            if (u.getTurno().equals("6")) {
                //client.setCvecliente(d.maxcliente(con.getCobranzatpuB()));
                if (d.nuevocliente(con.getCobranzatpuB(), client)) {
                    JOptionPane.showMessageDialog(null, "Exito al ingresar nuevo cliente");
                    vaciacampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No puedo llevarse a cabo el ingreso del cliente, intentelo de nuevo o llame a sistemas");
                }
            } else {
//                Se converva por si en algun momento se desea ingresar clientes fiscales sin necesidad de importar
//                client.setCvecliente(d.maxcliente(con.getCobranzatpu()));
//                client.setCvecliente(Integer.parseInt(c1.JtCliente.getText()));
                if (d.nuevocliente(con.getCobranzatpuB(), client)) {
//                    Solo crear clientes que sean para remision
//                    d.nuevocliente(con.getCobranzatpu(), client);
                    JOptionPane.showMessageDialog(null, "Exito al ingresar nuevo cliente");
                    vaciacampos();
                    buscacliente();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Alguno de los campos esta mal o estas usando algun caracter no permitido");
            c1.JtNombre.requestFocus();
        }
        if (!checkcampos_campocliente()) {
            JOptionPane.showMessageDialog(null, "El numero de cliente es incorrecto, agregar otro");
        }

    }//GEN-LAST:event_jLabel2MousePressed

    private void JtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtBuscarActionPerformed
        buscacliente();
    }//GEN-LAST:event_JtBuscarActionPerformed

    private void llenalista() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Cliente arr1 : arr) {
            model.addElement(arr1.getCvecliente()+" - "+arr1.getNombre());
        }
        JlCliente.setModel(model);
    }

    /**
     * Verifica cada uno de los campos que sean correctos y que no tengan algun
     * caracter invalido
     *
     * @return boolean
     */
    private boolean checkcampos() {
        Formateodedatos d = new Formateodedatos();
        return (d.verificaStringsSC(c1.JtNombre.getText()) && d.verificaStringsSC(c1.JtRfc.getText())
                && d.verificaStringsSC(c1.JtTelefono.getText())
                && d.verificaStringsSC(c1.JtCalle.getText()) && d.verificaStringsSC(c1.JtColonia.getText())
                && d.verificaStringsSC(c1.JtCp.getText()) && d.verificaStringsSC(c1.JtContacto.getText())
                && d.verificaStringsSC(c1.JtUso.getText()) && d.verificaStringsSC(c1.JtRegimen.getText())
                && d.verificaint(c1.JtPlazo.getText()));
    }

    /**
     * Este metodo separado ya que verificará en solitario el id del cliente y
     * si es incorrecto hacer enfasis solo en el
     *
     * @return boolean
     */
    private boolean checkcampos_campocliente() {
        Formateodedatos d = new Formateodedatos();
        return (d.verificaStringsSC(c1.JtCliente.getText()));
    }

    private void vaciacampos() {
        c1.JtNombre.setText("");
        c1.JtRegimen.setText("");
        c1.JtRfc.setText("");
        c1.JtTelefono.setText("");
        c1.JtCorreo.setText("");
        c1.JtCalle.setText("");
        c1.JtColonia.setText("");
        c1.JtCp.setText("");
        c1.JtContacto.setText("");
        c1.JtUso.setText("");
        c1.JtPais.setText("");
        c1.JtEstado.setText("");
        c1.JtCiudad.setText("");
        c1.JtBanco.setText("");
        c1.JtCliente.setText("");
    }

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        ClienteUpdate cu = new ClienteUpdate(null, true);
        cu.cpttpu = con.getCobranzatpu();
        cu.cobB = con.getCobranzatpuB();
        cu.setVisible(true);
    }//GEN-LAST:event_jLabel5MousePressed

    private void JlClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlClienteMousePressed
        setcampos();
    }//GEN-LAST:event_JlClienteMousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        cli = c1.getCliente();
        if (!cli.getNombre().isEmpty()) {
            daoClientes dc = new daoClientes();
            if (serie.equals("A") && !u.getTurno().equals("6")) {
                if (dc.modcliente(con.getCobranzatpu(), cli)) {
                    dc.modcliente(con.getCobranzatpuB(), cli);
                    JOptionPane.showMessageDialog(null, "Actualizacion completa");
                    JtBuscar.setText("");
                    buscacliente();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes de colocar la serie B o ser un usuario con permisos");
            }
            if (serie.equals("B")) {
                if (dc.modcliente(con.getCobranzatpuB(), cli)) {
                    JOptionPane.showMessageDialog(null, "Actualizacion completa");
                    JtBuscar.setText("");
                    buscacliente();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                }
            }
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        int row = JlCliente.getSelectedIndex();
        arr.get(row).getCvecliente();
    }//GEN-LAST:event_jLabel4MousePressed

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
            System.out.println(combinacion);
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
                buscacliente();
            }
        }
    }//GEN-LAST:event_JlSerieMousePressed

    private void JlSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JlSerieKeyPressed

    }//GEN-LAST:event_JlSerieKeyPressed

    /**
     * Utilizado para el despliegue de los agentes, pero es necesario que 
     * un cliente haya sido seleccionado para su posterior seleccion.
     */
    public void setcampos() {
        //libreria para solo valores del agente
        Dao_Agente da = new Dao_Agente();
        int row = JlCliente.getSelectedIndex();
        c1.c = arr.get(row);
        c1.setcampos();
        //funcion solo setear la lista de agentes y el agente actual
        c1.setagente(arr.get(row).getAgente(), da.getagentes_all(con.getCobranzatpuB()));
    }

    /**
     * Solo se utiliza para el despliegue de los clientes sin necesidad
     * de algun actionlistener
     */
    public void setcamposinicial() {
        //libreria para solo valores del agente
        Dao_Agente da = new Dao_Agente();
        //funcion solo setear la lista de agentes y el agente actual
        c1.setagente(da.getagentes_all(con.getCobranzatpuB()));
    }

    public void buscacliente() {
        String cliente = JtBuscar.getText();
        daoClientes dc = new daoClientes();
        if (u.getTurno().equals("6") && serie.equals("A")) {
            JOptionPane.showMessageDialog(null, "No puedes realizar consultas fiscales, cambia a serie 'B' o rojo");
        } else {
            if (u.getTurno().equals("6")) {
                arr = dc.getClientestpuall(con.getCobranzatpuB(), cliente);
            } else {
                if (serie.equals("B")) {
                    arr = dc.getClientestpuall(con.getCobranzatpuB(), cliente);
                } else {
                    arr = dc.getClientestpuall(con.getCobranzatpu(), cliente);
                }

            }
        }
        llenalista();
    }

    public final void generaciontab() {
        c1 = new Clientetpu1();
        //c2 = new Clientetpu2();
        Tabbed.addTab("Datos cliente", c1);
        Tabbed.setSelectedComponent(c1);
        //Tabbed.addTab("Datos Extras", c2);
        c1.sqlcfdi = con.getLitecfdi();
        c1.ACobranza = con.getCobranzatpu();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JlCliente;
    private javax.swing.JLabel JlSerie;
    public javax.swing.JTextField JtBuscar;
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}