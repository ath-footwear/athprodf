/*
 * Michel araujo
Ten cuidado ya que aqui es donde se gestionan las conexiones y despliegue de menus para cada tipo de usuario
 */
package athprod;

import Avances.Avancesprod;
import Avances.Pantallas;
import DAO.daoClientes;
import DAO.daoPrincipal;
import DAO.daopedimentos;
import Maq.Materialesmaq;
import Maq.PagostpuCargos;
import Maq.Tipomaquina;
import Modelo.Conexiones;
import Modelo.Formateodedatos;
import Modelo.Procserie;
import Modelo.Usuarios;
import Paneles.pago1;
import Panelmaq.Rep_Cargosespeciales;
import Panelmaq.Rep_ventaxproducto;
import Panelmaq.ReporteInventario;
import Paneltpu.Impresion_etiquetas;
import Paneltpu.Kardexprod;
import Paneltpu.RepFacturas;
import Paneltpu.RepSaldosV;
import Paneltpu.Rep_Comisiones;
import Paneltpu.Repauxcliente;
import Paneltpu.Repedocuenta;
import Paneltpu.Ventasserie;
import Tpu.Materialestpu;
import Server.ServerProccpt;
import Server.Serverprod;
import Server.Serverylite;
import Tpu.Agentestpu;
import Tpu.Antiguedad;
import Tpu.Cargos_especiales;
import Tpu.ClientesTpu;
import Tpu.Comisiones;
import Tpu.Devolucionestpu;
import Tpu.Durezastpu;
import Tpu.EntradasSalidas;
import Tpu.FacturacionTpu;
import Tpu.FacturacionTpuAth;
import Tpu.Familiastpu;
import Tpu.Inventarios;
import Tpu.Notascrtpu;
import Tpu.Pagostpu;
import Tpu.Pagostpurem;
import Tpu.Pantavance;
import Tpu.Pedimento;
import Tpu.Proveedorestpu;
import Tpu.Remisiontpu;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * Esta clase a pasado por varios cambios, entonces si es necesario que cada
 * cambio en cuanto a cualquier tipo de proceso, sea cambio de nombre de
 * variable, nueva variable, Nuevo, modificacion o eliminacion de cualquier
 * objeto o variable, es necesario hacer commit o hacer un respaldo.
 *
 * @author GATEWAY1-
 */
public final class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    ArrayList<Connection> arr = new ArrayList<>();
    private TrayIcon Ticon;
    private SystemTray ttray;
    MenuItem mi = new MenuItem();
    MenuItem mi2 = new MenuItem();
    MenuItem mi3 = new MenuItem();
    Connection cpt, rcpt, ACobranza;
    Connection concpt, conupcpt, conrcpt, conrcptup, concob, concobup;
    Connection liteusuario;
    Connection litecfdi, liteempresa;
    Connection tpu, tpucob, tpucobB;
    Connection maq, maqcob, maqcobB;
    Connection maq2, maqcob2, maqcobB2;
    Conexiones conexion = new Conexiones();
    JPasswordField jp = new JPasswordField();
    String empresa;
    int cont = 0;
    int logint = 0;
    String admin = "0";
    String prod = "1";
//    Variable para cerrar las conexiones a la bd por si se activa ell modo administracion
    boolean adminmod = true;
    Usuarios u = new Usuarios();
    //Panel de conexiones independientes
    Anucios anuncios;
    Fallasprod fallas;
    Hrsavances hravance;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/programacion.png"));
        setIconImage(icon);
//        Cuando llegue el momento de usar siingleton
//        Allsingleton singleton = new Allsingleton();
//        Jlnombre.setText(Allsingleton.getUsuario().getNombre());
//        JlSerie.setText(Allsingleton.getSerie());
//IMPORTANTE, AQUI AÑADE TODOS LOS MENUS AL POPUP
        PopMenu.add(JmSesion);
        PopMenu.add(JmOut);
        PopMenu.add(JmConf);
        PopMenu.add(jSeparator1);
        PopMenu.add(JmProd);
        PopMenu.add(JmCobranza);
//        PopMenu.add(JmRespaldos);
        PopMenu.add(JmVentas);
        PopMenu.add(JmTpu);
        PopMenu.add(JmMaq);
        PopMenu.add(JmMaq2);
//        Menu para el despliegue una ves que se ha cerrado la aplicacion
        popup();
//        Todos los menus y botones se ocultan para su despues proceso
        setinicio();
        grupo.add(JrEmpresa);
        grupo.add(JrEmpresa1);
//        Conexion a la bd de Sqlite
        conexiones();
//        Conexiones solo para el modo de pruebas
        setconexionprueba();
        //setconexiones();
        u.setAth("");
        u.setUsuario("");
        if (prod.equals("0")) {
            logint = 1;
            JlUsuario.setText("Michel Admin");
            u.setUsuario("Michel");
            u.setGrado("2");
            u.setTurno("0");
            u.setProduccion("1");
            u.setTipo_usuario("2");
            modoadmin();
            JmSesion.setEnabled(false);
            jLabel1.requestFocus();
        }
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-6"));//Para el cambio de horario
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JmSesion = new javax.swing.JMenuItem();
        JmOut = new javax.swing.JMenuItem();
        JmConf = new javax.swing.JMenu();
        JmRespaldos = new javax.swing.JMenuItem();
        JmCES = new javax.swing.JMenuItem();
        JmEmpresas = new javax.swing.JMenuItem();
        JmRespaldos1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        JmProd = new javax.swing.JMenu();
        JmCatalogoprod = new javax.swing.JMenuItem();
        JmFicha = new javax.swing.JMenuItem();
        JmAnuncios = new javax.swing.JMenuItem();
        JmFallas = new javax.swing.JMenuItem();
        JmAvances = new javax.swing.JMenu();
        JmPantallahrs = new javax.swing.JMenuItem();
        JmPantallahrs1 = new javax.swing.JMenuItem();
        JmReportes = new javax.swing.JMenu();
        JmAvancesPt = new javax.swing.JMenuItem();
        JmAvancesprod = new javax.swing.JMenuItem();
        PopMenu = new javax.swing.JPopupMenu();
        JmCobranza = new javax.swing.JMenu();
        JmClientes = new javax.swing.JMenuItem();
        JmNotascr = new javax.swing.JMenuItem();
        JmPagos = new javax.swing.JMenuItem();
        JmVentas = new javax.swing.JMenu();
        JmVerfacts = new javax.swing.JMenuItem();
        JmModcaja = new javax.swing.JMenuItem();
        JmSalidas = new javax.swing.JMenuItem();
        JmFacturacion = new javax.swing.JMenuItem();
        JmFacturacionE = new javax.swing.JMenuItem();
        JmCerrar = new javax.swing.JMenuItem();
        Jmabrir = new javax.swing.JMenuItem();
        JpClose = new java.awt.PopupMenu();
        grupo = new javax.swing.ButtonGroup();
        JmTpu = new javax.swing.JMenu();
        Catalogos = new javax.swing.JMenu();
        JmMaterial = new javax.swing.JMenuItem();
        JmProveedor = new javax.swing.JMenuItem();
        JmCliente = new javax.swing.JMenuItem();
        JmDureza = new javax.swing.JMenuItem();
        JmFamilia = new javax.swing.JMenuItem();
        JmAgente = new javax.swing.JMenuItem();
        Jmreportes = new javax.swing.JMenu();
        JmRepcob = new javax.swing.JMenu();
        JmEdocuenta = new javax.swing.JMenuItem();
        JmAuxcliente = new javax.swing.JMenuItem();
        JmSaldosvencidos = new javax.swing.JMenuItem();
        JmAntiguedad = new javax.swing.JMenuItem();
        JmKardexprod = new javax.swing.JMenuItem();
        JmVentaserie = new javax.swing.JMenuItem();
        JmEtiquetas = new javax.swing.JMenuItem();
        JmComisiones1 = new javax.swing.JMenuItem();
        JmCobranzatpu = new javax.swing.JMenu();
        JmNotascrtpu = new javax.swing.JMenuItem();
        JmPagostpu = new javax.swing.JMenuItem();
        JmPagostpu2 = new javax.swing.JMenuItem();
        JmVentastpu = new javax.swing.JMenu();
        JtFacturaciontpu = new javax.swing.JMenuItem();
        JtFacturaciontpu1 = new javax.swing.JMenuItem();
        JmRemision = new javax.swing.JMenuItem();
        JmInventarios = new javax.swing.JMenuItem();
        JmPedimento = new javax.swing.JMenuItem();
        JmEntradasS = new javax.swing.JMenuItem();
        JmDevoluciones = new javax.swing.JMenuItem();
        JmComisionesadm = new javax.swing.JMenuItem();
        JmMaq = new javax.swing.JMenu();
        Catalogos1 = new javax.swing.JMenu();
        JmMaterial1 = new javax.swing.JMenuItem();
        JmProveedor1 = new javax.swing.JMenuItem();
        JmCliente1 = new javax.swing.JMenuItem();
        JmFamilia1 = new javax.swing.JMenuItem();
        Jmreportes1 = new javax.swing.JMenu();
        JmRepcob1 = new javax.swing.JMenu();
        JmEdocuenta1 = new javax.swing.JMenuItem();
        JmAuxcliente1 = new javax.swing.JMenuItem();
        JmSaldosvencidos1 = new javax.swing.JMenuItem();
        JmVentaserie2 = new javax.swing.JMenuItem();
        JmKardexprod1 = new javax.swing.JMenuItem();
        JmVentaserie1 = new javax.swing.JMenuItem();
        JmCobranzatpu1 = new javax.swing.JMenu();
        JmNotascrtpu1 = new javax.swing.JMenuItem();
        JmPagostpu1 = new javax.swing.JMenuItem();
        JmPagostpu3 = new javax.swing.JMenuItem();
        JmRemision1 = new javax.swing.JMenuItem();
        JmPedimento1 = new javax.swing.JMenuItem();
        JmEntradasS1 = new javax.swing.JMenuItem();
        JmDevoluciones1 = new javax.swing.JMenuItem();
        JmDescmaquinas1 = new javax.swing.JMenuItem();
        JmMaq2 = new javax.swing.JMenu();
        Catalogos2 = new javax.swing.JMenu();
        JmMaterial2 = new javax.swing.JMenuItem();
        JmProveedor2 = new javax.swing.JMenuItem();
        JmCliente2 = new javax.swing.JMenuItem();
        JmFamilia2 = new javax.swing.JMenuItem();
        JmAgente1 = new javax.swing.JMenuItem();
        JmDescmaquinas = new javax.swing.JMenuItem();
        Jmreportes2 = new javax.swing.JMenu();
        JmRepcob2 = new javax.swing.JMenu();
        JmEdocuenta2 = new javax.swing.JMenuItem();
        JmAuxcliente2 = new javax.swing.JMenuItem();
        JmSaldosvencidos2 = new javax.swing.JMenuItem();
        JmCargosEspeciales = new javax.swing.JMenuItem();
        JmVentaserie3 = new javax.swing.JMenuItem();
        JmKardexprod2 = new javax.swing.JMenuItem();
        JmVentaserie4 = new javax.swing.JMenuItem();
        JmVentaserie5 = new javax.swing.JMenuItem();
        JmVentaxprod = new javax.swing.JMenuItem();
        JmComisiones = new javax.swing.JMenuItem();
        JmCobranzatpu2 = new javax.swing.JMenu();
        JmNotascrtpu2 = new javax.swing.JMenuItem();
        JmPagostpu4 = new javax.swing.JMenuItem();
        JmPagostpu5 = new javax.swing.JMenuItem();
        JmCargos = new javax.swing.JMenuItem();
        JmPagoespecial = new javax.swing.JMenuItem();
        JmVentastpu1 = new javax.swing.JMenu();
        JtFacturaciontpu2 = new javax.swing.JMenuItem();
        JtFacturaciontpu3 = new javax.swing.JMenuItem();
        JmRemision2 = new javax.swing.JMenuItem();
        JmInventarios1 = new javax.swing.JMenuItem();
        JmPedimento2 = new javax.swing.JMenuItem();
        JmEntradasS2 = new javax.swing.JMenuItem();
        JmDevoluciones2 = new javax.swing.JMenuItem();
        JmComisionesadm1 = new javax.swing.JMenuItem();
        JmCmp = new javax.swing.JMenu();
        JmCatalogoscmp = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JlSerie = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JrEmpresa = new javax.swing.JRadioButton();
        JrEmpresa1 = new javax.swing.JRadioButton();
        JlUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JlEmpresa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JdPanel = new javax.swing.JDesktopPane();

        JmSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/key_keys_10804.png"))); // NOI18N
        JmSesion.setText("Iniciar sesion");
        JmSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSesionActionPerformed(evt);
            }
        });

        JmOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exit_closethesession_close_6317.png"))); // NOI18N
        JmOut.setText("Cerrar sesion");
        JmOut.setToolTipText("Cierra el programa");
        JmOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmOutActionPerformed(evt);
            }
        });

        JmConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564402-settings_81520.png"))); // NOI18N
        JmConf.setText("Configuraciones");

        JmRespaldos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Data_settings_theapplication_3364.png"))); // NOI18N
        JmRespaldos.setText("Respaldos BD");
        JmRespaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRespaldosActionPerformed(evt);
            }
        });
        JmConf.add(JmRespaldos);

        JmCES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/construction_project_plan_building_architect_design_develop-61_icon-icons.com_60253.png"))); // NOI18N
        JmCES.setText("CES");
        JmCES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCESActionPerformed(evt);
            }
        });
        JmConf.add(JmCES);

        JmEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1492616984-13-setting-configure-repair-support-optimization-google_83419.png"))); // NOI18N
        JmEmpresas.setText("Empresas");
        JmEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEmpresasActionPerformed(evt);
            }
        });
        JmConf.add(JmEmpresas);

        JmRespaldos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Data_settings_theapplication_3364.png"))); // NOI18N
        JmRespaldos1.setText("Respaldos BD");
        JmRespaldos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRespaldos1ActionPerformed(evt);
            }
        });
        JmConf.add(JmRespaldos1);

        JmProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/42498factory_99134.png"))); // NOI18N
        JmProd.setText("Produccion");

        JmCatalogoprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Documents_43884.png"))); // NOI18N
        JmCatalogoprod.setText("Catalogos");
        JmCatalogoprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCatalogoprodActionPerformed(evt);
            }
        });
        JmProd.add(JmCatalogoprod);

        JmFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1562683-branding-card-pencil-profile_107062.png"))); // NOI18N
        JmFicha.setText("Ficha Tecnica");
        JmFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFichaActionPerformed(evt);
            }
        });
        JmProd.add(JmFicha);

        JmAnuncios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564410-chat_81504.png"))); // NOI18N
        JmAnuncios.setText("Anuncios pantallas");
        JmAnuncios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAnunciosActionPerformed(evt);
            }
        });
        JmProd.add(JmAnuncios);

        JmFallas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/propagation_calculator_calc_6110.png"))); // NOI18N
        JmFallas.setText("Fallas de produccion");
        JmFallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFallasActionPerformed(evt);
            }
        });
        JmProd.add(JmFallas);

        JmAvances.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/organizer_calendar_pen_note_6134.png"))); // NOI18N
        JmAvances.setText("Avances");

        JmPantallahrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/safety_reader_card_10784.png"))); // NOI18N
        JmPantallahrs.setText("Configuracion de hrs para pantallas");
        JmPantallahrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPantallahrsActionPerformed(evt);
            }
        });
        JmAvances.add(JmPantallahrs);

        JmPantallahrs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/mac_icon-icons.com_54610.png"))); // NOI18N
        JmPantallahrs1.setText("Configuracion de Pantallas");
        JmPantallahrs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPantallahrs1ActionPerformed(evt);
            }
        });
        JmAvances.add(JmPantallahrs1);

        JmReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        JmReportes.setText("Reportes");

        JmAvancesPt.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JmAvancesPt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/documenttextregular_106258.png"))); // NOI18N
        JmAvancesPt.setText("Reporte avances pt");
        JmAvancesPt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAvancesPtActionPerformed(evt);
            }
        });
        JmReportes.add(JmAvancesPt);

        JmAvancesprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564180-finance-financial-report_81493.png"))); // NOI18N
        JmAvancesprod.setText("Reporte de avances de produccion");
        JmAvancesprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAvancesprodActionPerformed(evt);
            }
        });
        JmReportes.add(JmAvancesprod);

        JmAvances.add(JmReportes);

        JmProd.add(JmAvances);

        JmCobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmCobranza.setText("Cobranza");

        JmClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        JmClientes.setText("Clientes");
        JmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmClientesActionPerformed(evt);
            }
        });
        JmCobranza.add(JmClientes);

        JmNotascr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmNotascr.setText("Notas de credito");
        JmNotascr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmNotascrActionPerformed(evt);
            }
        });
        JmCobranza.add(JmNotascr);

        JmPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332.png"))); // NOI18N
        JmPagos.setText("Pagos");
        JmPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagosActionPerformed(evt);
            }
        });
        JmCobranza.add(JmPagos);

        JmVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Ordering_25406.png"))); // NOI18N
        JmVentas.setText("Ventas");

        JmVerfacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationvnd_103607.png"))); // NOI18N
        JmVerfacts.setText("Generar pdf fac");
        JmVerfacts.setEnabled(false);
        JmVerfacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVerfactsActionPerformed(evt);
            }
        });
        JmVentas.add(JmVerfacts);

        JmModcaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Documents_43884.png"))); // NOI18N
        JmModcaja.setText("Modificacion de facturas");
        JmModcaja.setToolTipText("Modifica algunos valores de las facturas, solo las autorizadas");
        JmModcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmModcajaActionPerformed(evt);
            }
        });
        JmVentas.add(JmModcaja);

        JmSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/move_23058.png"))); // NOI18N
        JmSalidas.setText("Salidas");
        JmSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSalidasActionPerformed(evt);
            }
        });
        JmVentas.add(JmSalidas);

        JmFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtir.png"))); // NOI18N
        JmFacturacion.setText("Facturación");
        JmFacturacion.setToolTipText("Facturacion");
        JmFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFacturacionActionPerformed(evt);
            }
        });
        JmVentas.add(JmFacturacion);

        JmFacturacionE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirE.png"))); // NOI18N
        JmFacturacionE.setText("Facturación  Especial");
        JmFacturacionE.setToolTipText("Facturacion  Especial");
        JmFacturacionE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFacturacionEActionPerformed(evt);
            }
        });
        JmVentas.add(JmFacturacionE);

        JmCerrar.setText("jMenuItem3");

        Jmabrir.setText("jMenuItem2");

        JpClose.setLabel("popupMenu1");

        JmTpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/factory_robot_manufacturing_industry_robotics_machine_robotic_arm_automation_industrial_production_icon_231898.png"))); // NOI18N
        JmTpu.setText("Tpu");
        JmTpu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                JmTpuMenuSelected(evt);
            }
        });
        JmTpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmTpuActionPerformed(evt);
            }
        });

        Catalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/courses_letters_blackboard_board_staff_book_1475.png"))); // NOI18N
        Catalogos.setText("Catalogos");

        JmMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/material_colors_macos_bigsur_icon_189995.png"))); // NOI18N
        JmMaterial.setText("Materiales");
        JmMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterialActionPerformed(evt);
            }
        });
        Catalogos.add(JmMaterial);

        JmProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        JmProveedor.setText("Proveedores");
        JmProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProveedorActionPerformed(evt);
            }
        });
        Catalogos.add(JmProveedor);

        JmCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensauser.png"))); // NOI18N
        JmCliente.setText("Clientes");
        JmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmClienteActionPerformed(evt);
            }
        });
        Catalogos.add(JmCliente);

        JmDureza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Data_Meter4_37237.png"))); // NOI18N
        JmDureza.setText("Durezas");
        JmDureza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDurezaActionPerformed(evt);
            }
        });
        Catalogos.add(JmDureza);

        JmFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/family_pedestrian_icon_216646.png"))); // NOI18N
        JmFamilia.setText("Familias");
        JmFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFamiliaActionPerformed(evt);
            }
        });
        Catalogos.add(JmFamilia);

        JmAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/person_3_icon-icons.com_68899.png"))); // NOI18N
        JmAgente.setText("Agentes");
        JmAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAgenteActionPerformed(evt);
            }
        });
        Catalogos.add(JmAgente);

        JmTpu.add(Catalogos);

        Jmreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/books_21813.png"))); // NOI18N
        Jmreportes.setText("Reportes");

        JmRepcob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmRepcob.setText("Reportes Cobranza");

        JmEdocuenta.setText("Reporte Estado de cuenta");
        JmEdocuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEdocuentaActionPerformed(evt);
            }
        });
        JmRepcob.add(JmEdocuenta);

        JmAuxcliente.setText("Reporte Auxiliar de clientes");
        JmAuxcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAuxclienteActionPerformed(evt);
            }
        });
        JmRepcob.add(JmAuxcliente);

        JmSaldosvencidos.setText("Reporte Saldos Vencidos x Vencer");
        JmSaldosvencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSaldosvencidosActionPerformed(evt);
            }
        });
        JmRepcob.add(JmSaldosvencidos);

        JmAntiguedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/antique.png"))); // NOI18N
        JmAntiguedad.setText("Reporte de antiguedad");
        JmAntiguedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAntiguedadActionPerformed(evt);
            }
        });
        JmRepcob.add(JmAntiguedad);

        Jmreportes.add(JmRepcob);

        JmKardexprod.setText("Kardex x producto");
        JmKardexprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmKardexprodActionPerformed(evt);
            }
        });
        Jmreportes.add(JmKardexprod);

        JmVentaserie.setText("Reporte de ventas");
        JmVentaserie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserieActionPerformed(evt);
            }
        });
        Jmreportes.add(JmVentaserie);

        JmEtiquetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/labelprint.png"))); // NOI18N
        JmEtiquetas.setText("Impresion de etiquetas");
        JmEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEtiquetasActionPerformed(evt);
            }
        });
        Jmreportes.add(JmEtiquetas);

        JmComisiones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/propagation_calculator_calc_6110.png"))); // NOI18N
        JmComisiones1.setText("Reporte de comisiones");
        JmComisiones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmComisiones1ActionPerformed(evt);
            }
        });
        Jmreportes.add(JmComisiones1);

        JmTpu.add(Jmreportes);

        JmCobranzatpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmCobranzatpu.setText("Cobranza");

        JmNotascrtpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmNotascrtpu.setText("Notas de credito");
        JmNotascrtpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmNotascrtpuActionPerformed(evt);
            }
        });
        JmCobranzatpu.add(JmNotascrtpu);

        JmPagostpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332.png"))); // NOI18N
        JmPagostpu.setText("Pagos");
        JmPagostpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpuActionPerformed(evt);
            }
        });
        JmCobranzatpu.add(JmPagostpu);

        JmPagostpu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332B.png"))); // NOI18N
        JmPagostpu2.setText("Pagos Remision");
        JmPagostpu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpu2ActionPerformed(evt);
            }
        });
        JmCobranzatpu.add(JmPagostpu2);

        JmTpu.add(JmCobranzatpu);

        JmVentastpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmVentastpu.setText("Ventas");

        JtFacturaciontpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtir.png"))); // NOI18N
        JtFacturaciontpu.setText("Facturacion");
        JtFacturaciontpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtFacturaciontpuActionPerformed(evt);
            }
        });
        JmVentastpu.add(JtFacturaciontpu);

        JtFacturaciontpu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirP0.png"))); // NOI18N
        JtFacturaciontpu1.setText("Facturacion pedimento 0");
        JtFacturaciontpu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtFacturaciontpu1ActionPerformed(evt);
            }
        });
        JmVentastpu.add(JtFacturaciontpu1);

        JmRemision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirR.png"))); // NOI18N
        JmRemision.setText("Pedidos");
        JmRemision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRemisionActionPerformed(evt);
            }
        });
        JmVentastpu.add(JmRemision);

        JmTpu.add(JmVentastpu);

        JmInventarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_inventory_maintenance_product_box_boxes_2326.png"))); // NOI18N
        JmInventarios.setText("Inventarios");
        JmInventarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmInventariosActionPerformed(evt);
            }
        });
        JmTpu.add(JmInventarios);

        JmPedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/construction_project_plan_building_architect_design_develop-61_icon-icons.com_60253.png"))); // NOI18N
        JmPedimento.setText("Pedimento");
        JmPedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedimentoActionPerformed(evt);
            }
        });
        JmTpu.add(JmPedimento);

        JmEntradasS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/move_23058.png"))); // NOI18N
        JmEntradasS.setText("Entradas/Salidas");
        JmEntradasS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEntradasSActionPerformed(evt);
            }
        });
        JmTpu.add(JmEntradasS);

        JmDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Return_icon-icons.com_54801.png"))); // NOI18N
        JmDevoluciones.setText("Devoluciones");
        JmDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDevolucionesActionPerformed(evt);
            }
        });
        JmTpu.add(JmDevoluciones);

        JmComisionesadm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cash_40532.png"))); // NOI18N
        JmComisionesadm.setText("Comisiones");
        JmComisionesadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmComisionesadmActionPerformed(evt);
            }
        });
        JmTpu.add(JmComisionesadm);

        JmMaq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/industry_package_box_storage_factory_icon_188937.png"))); // NOI18N
        JmMaq.setText("Maquinaria");
        JmMaq.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                JmMaqMenuSelected(evt);
            }
        });
        JmMaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaqActionPerformed(evt);
            }
        });

        Catalogos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/courses_letters_blackboard_board_staff_book_1475.png"))); // NOI18N
        Catalogos1.setText("Catalogos");

        JmMaterial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/material_colors_macos_bigsur_icon_189995.png"))); // NOI18N
        JmMaterial1.setText("Maquinas");
        JmMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterial1ActionPerformed(evt);
            }
        });
        Catalogos1.add(JmMaterial1);

        JmProveedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        JmProveedor1.setText("Proveedores");
        JmProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProveedor1ActionPerformed(evt);
            }
        });
        Catalogos1.add(JmProveedor1);

        JmCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensauser.png"))); // NOI18N
        JmCliente1.setText("Clientes");
        JmCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCliente1ActionPerformed(evt);
            }
        });
        Catalogos1.add(JmCliente1);

        JmFamilia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/family_pedestrian_icon_216646.png"))); // NOI18N
        JmFamilia1.setText("Familias");
        JmFamilia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFamilia1ActionPerformed(evt);
            }
        });
        Catalogos1.add(JmFamilia1);

        JmMaq.add(Catalogos1);

        Jmreportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/books_21813.png"))); // NOI18N
        Jmreportes1.setText("Reportes");

        JmRepcob1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmRepcob1.setText("Reportes Cobranza");

        JmEdocuenta1.setText("Reporte Estado de cuenta");
        JmEdocuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEdocuenta1ActionPerformed(evt);
            }
        });
        JmRepcob1.add(JmEdocuenta1);

        JmAuxcliente1.setText("Reporte Auxiliar de clientes");
        JmAuxcliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAuxcliente1ActionPerformed(evt);
            }
        });
        JmRepcob1.add(JmAuxcliente1);

        JmSaldosvencidos1.setText("Reporte Saldos Vencidos x Vencer");
        JmSaldosvencidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSaldosvencidos1ActionPerformed(evt);
            }
        });
        JmRepcob1.add(JmSaldosvencidos1);

        Jmreportes1.add(JmRepcob1);

        JmVentaserie2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Documents_43884.png"))); // NOI18N
        JmVentaserie2.setText("Reporte de inventario");
        JmVentaserie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserie2ActionPerformed(evt);
            }
        });
        Jmreportes1.add(JmVentaserie2);

        JmKardexprod1.setText("Kardex x producto");
        JmKardexprod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmKardexprod1ActionPerformed(evt);
            }
        });
        Jmreportes1.add(JmKardexprod1);

        JmVentaserie1.setText("Reporte de ventas");
        JmVentaserie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserie1ActionPerformed(evt);
            }
        });
        Jmreportes1.add(JmVentaserie1);

        JmMaq.add(Jmreportes1);

        JmCobranzatpu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmCobranzatpu1.setText("Cobranza");

        JmNotascrtpu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmNotascrtpu1.setText("Notas de credito");
        JmNotascrtpu1.setEnabled(false);
        JmNotascrtpu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmNotascrtpu1ActionPerformed(evt);
            }
        });
        JmCobranzatpu1.add(JmNotascrtpu1);

        JmPagostpu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332.png"))); // NOI18N
        JmPagostpu1.setText("Pagos");
        JmPagostpu1.setEnabled(false);
        JmPagostpu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpu1ActionPerformed(evt);
            }
        });
        JmCobranzatpu1.add(JmPagostpu1);

        JmPagostpu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332B.png"))); // NOI18N
        JmPagostpu3.setText("Pagos Remision");
        JmPagostpu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpu3ActionPerformed(evt);
            }
        });
        JmCobranzatpu1.add(JmPagostpu3);

        JmMaq.add(JmCobranzatpu1);

        JmRemision1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirR.png"))); // NOI18N
        JmRemision1.setText("Pedidos");
        JmRemision1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRemision1ActionPerformed(evt);
            }
        });
        JmMaq.add(JmRemision1);

        JmPedimento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/construction_project_plan_building_architect_design_develop-61_icon-icons.com_60253.png"))); // NOI18N
        JmPedimento1.setText("Pedimento");
        JmPedimento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedimento1ActionPerformed(evt);
            }
        });
        JmMaq.add(JmPedimento1);

        JmEntradasS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/move_23058.png"))); // NOI18N
        JmEntradasS1.setText("Entradas/Salidas");
        JmEntradasS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEntradasS1ActionPerformed(evt);
            }
        });
        JmMaq.add(JmEntradasS1);

        JmDevoluciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Return_icon-icons.com_54801.png"))); // NOI18N
        JmDevoluciones1.setText("Devoluciones");
        JmDevoluciones1.setEnabled(false);
        JmDevoluciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDevoluciones1ActionPerformed(evt);
            }
        });
        JmMaq.add(JmDevoluciones1);

        JmDescmaquinas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensa.png"))); // NOI18N
        JmDescmaquinas1.setText("Descripcion de maquinas");
        JmDescmaquinas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDescmaquinas1ActionPerformed(evt);
            }
        });
        JmMaq.add(JmDescmaquinas1);

        JmMaq2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/industry_package_box_storage_factory_icon_188937.png"))); // NOI18N
        JmMaq2.setText("Top Maquinaria");
        JmMaq2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                JmMaq2MenuSelected(evt);
            }
        });
        JmMaq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaq2ActionPerformed(evt);
            }
        });

        Catalogos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/courses_letters_blackboard_board_staff_book_1475.png"))); // NOI18N
        Catalogos2.setText("Catalogos");

        JmMaterial2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/material_colors_macos_bigsur_icon_189995.png"))); // NOI18N
        JmMaterial2.setText("Maquinas");
        JmMaterial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterial2ActionPerformed(evt);
            }
        });
        Catalogos2.add(JmMaterial2);

        JmProveedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_Group-80_icon-icons.com_57247.png"))); // NOI18N
        JmProveedor2.setText("Proveedores");
        JmProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmProveedor2ActionPerformed(evt);
            }
        });
        Catalogos2.add(JmProveedor2);

        JmCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensauser.png"))); // NOI18N
        JmCliente2.setText("Clientes");
        JmCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCliente2ActionPerformed(evt);
            }
        });
        Catalogos2.add(JmCliente2);

        JmFamilia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/family_pedestrian_icon_216646.png"))); // NOI18N
        JmFamilia2.setText("Familias");
        JmFamilia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmFamilia2ActionPerformed(evt);
            }
        });
        Catalogos2.add(JmFamilia2);

        JmAgente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/person_3_icon-icons.com_68899.png"))); // NOI18N
        JmAgente1.setText("Agentes");
        JmAgente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAgente1ActionPerformed(evt);
            }
        });
        Catalogos2.add(JmAgente1);

        JmDescmaquinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/prensa.png"))); // NOI18N
        JmDescmaquinas.setText("Descripcion de maquinas");
        JmDescmaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDescmaquinasActionPerformed(evt);
            }
        });
        Catalogos2.add(JmDescmaquinas);

        JmMaq2.add(Catalogos2);

        Jmreportes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/books_21813.png"))); // NOI18N
        Jmreportes2.setText("Reportes");

        JmRepcob2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmRepcob2.setText("Reportes Cobranza");

        JmEdocuenta2.setText("Reporte Estado de cuenta");
        JmEdocuenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEdocuenta2ActionPerformed(evt);
            }
        });
        JmRepcob2.add(JmEdocuenta2);

        JmAuxcliente2.setText("Reporte Auxiliar de clientes");
        JmAuxcliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAuxcliente2ActionPerformed(evt);
            }
        });
        JmRepcob2.add(JmAuxcliente2);

        JmSaldosvencidos2.setText("Reporte Saldos Vencidos x Vencer");
        JmSaldosvencidos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSaldosvencidos2ActionPerformed(evt);
            }
        });
        JmRepcob2.add(JmSaldosvencidos2);

        JmCargosEspeciales.setText("Reporte de cargos especiales");
        JmCargosEspeciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCargosEspecialesActionPerformed(evt);
            }
        });
        JmRepcob2.add(JmCargosEspeciales);

        Jmreportes2.add(JmRepcob2);

        JmVentaserie3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Documents_43884.png"))); // NOI18N
        JmVentaserie3.setText("Reporte de inventario");
        JmVentaserie3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserie3ActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmVentaserie3);

        JmKardexprod2.setText("Kardex x producto");
        JmKardexprod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmKardexprod2ActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmKardexprod2);

        JmVentaserie4.setText("Reporte de ventas");
        JmVentaserie4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserie4ActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmVentaserie4);

        JmVentaserie5.setText("Reporte de facturas");
        JmVentaserie5.setToolTipText("");
        JmVentaserie5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaserie5ActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmVentaserie5);

        JmVentaxprod.setText("Reporte de ventas x producto");
        JmVentaxprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmVentaxprodActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmVentaxprod);

        JmComisiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/propagation_calculator_calc_6110.png"))); // NOI18N
        JmComisiones.setText("Reporte de comisiones");
        JmComisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmComisionesActionPerformed(evt);
            }
        });
        Jmreportes2.add(JmComisiones);

        JmMaq2.add(Jmreportes2);

        JmCobranzatpu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exchange-dollar_icon-icons.com_53141.png"))); // NOI18N
        JmCobranzatpu2.setText("Cobranza");

        JmNotascrtpu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmNotascrtpu2.setText("Notas de credito");
        JmNotascrtpu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmNotascrtpu2ActionPerformed(evt);
            }
        });
        JmCobranzatpu2.add(JmNotascrtpu2);

        JmPagostpu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332.png"))); // NOI18N
        JmPagostpu4.setText("Pagos");
        JmPagostpu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpu4ActionPerformed(evt);
            }
        });
        JmCobranzatpu2.add(JmPagostpu4);

        JmPagostpu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332B.png"))); // NOI18N
        JmPagostpu5.setText("Pagos Remision");
        JmPagostpu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagostpu5ActionPerformed(evt);
            }
        });
        JmCobranzatpu2.add(JmPagostpu5);

        JmCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cutomer.png"))); // NOI18N
        JmCargos.setText("Cargos especiales");
        JmCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCargosActionPerformed(evt);
            }
        });
        JmCobranzatpu2.add(JmCargos);

        JmPagoespecial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/labelprint.png"))); // NOI18N
        JmPagoespecial.setText("Pagos Cargo especial");
        JmPagoespecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPagoespecialActionPerformed(evt);
            }
        });
        JmCobranzatpu2.add(JmPagoespecial);

        JmMaq2.add(JmCobranzatpu2);

        JmVentastpu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486564168-finance-bank-check_81495.png"))); // NOI18N
        JmVentastpu1.setText("Ventas Maquinaria");

        JtFacturaciontpu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtir.png"))); // NOI18N
        JtFacturaciontpu2.setText("Facturacion");
        JtFacturaciontpu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtFacturaciontpu2ActionPerformed(evt);
            }
        });
        JmVentastpu1.add(JtFacturaciontpu2);

        JtFacturaciontpu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirP0.png"))); // NOI18N
        JtFacturaciontpu3.setText("Facturacion pedimento 0");
        JtFacturaciontpu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtFacturaciontpu3ActionPerformed(evt);
            }
        });
        JmVentastpu1.add(JtFacturaciontpu3);

        JmRemision2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/surtirR.png"))); // NOI18N
        JmRemision2.setText("Pedidos");
        JmRemision2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRemision2ActionPerformed(evt);
            }
        });
        JmVentastpu1.add(JmRemision2);

        JmMaq2.add(JmVentastpu1);

        JmInventarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_inventory_maintenance_product_box_boxes_2326.png"))); // NOI18N
        JmInventarios1.setText("Inventarios");
        JmInventarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmInventarios1ActionPerformed(evt);
            }
        });
        JmMaq2.add(JmInventarios1);

        JmPedimento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/construction_project_plan_building_architect_design_develop-61_icon-icons.com_60253.png"))); // NOI18N
        JmPedimento2.setText("Pedimento");
        JmPedimento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedimento2ActionPerformed(evt);
            }
        });
        JmMaq2.add(JmPedimento2);

        JmEntradasS2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/move_23058.png"))); // NOI18N
        JmEntradasS2.setText("Entradas/Salidas");
        JmEntradasS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmEntradasS2ActionPerformed(evt);
            }
        });
        JmMaq2.add(JmEntradasS2);

        JmDevoluciones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Return_icon-icons.com_54801.png"))); // NOI18N
        JmDevoluciones2.setText("Devoluciones");
        JmDevoluciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmDevoluciones2ActionPerformed(evt);
            }
        });
        JmMaq2.add(JmDevoluciones2);

        JmComisionesadm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cash_40532.png"))); // NOI18N
        JmComisionesadm1.setText("Comisiones");
        JmComisionesadm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmComisionesadm1ActionPerformed(evt);
            }
        });
        JmMaq2.add(JmComisionesadm1);

        JmCmp.setText("jMenu1");

        JmCatalogoscmp.setText("Catalogos");
        JmCmp.add(JmCatalogoscmp);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produccion ATH ");
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.Color.white);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(82, 82, 229));
        jPanel1.setForeground(new java.awt.Color(120, 152, 237));

        JlSerie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JlSerie.setForeground(new java.awt.Color(255, 0, 51));
        JlSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlSerieMousePressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        JrEmpresa.setBackground(new java.awt.Color(82, 82, 229));
        JrEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JrEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        JrEmpresa.setText("Athletic");
        JrEmpresa.setToolTipText("Emisor a facturar");
        JrEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JrEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrEmpresaActionPerformed(evt);
            }
        });

        JrEmpresa1.setBackground(new java.awt.Color(82, 82, 229));
        JrEmpresa1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JrEmpresa1.setForeground(new java.awt.Color(255, 255, 255));
        JrEmpresa1.setText("Uptown");
        JrEmpresa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JrEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrEmpresa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(JrEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JrEmpresa1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(JrEmpresa)
                .addComponent(JrEmpresa1))
        );

        JlUsuario.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        JlUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JlUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlUsuarioMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/seleccionblanco.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        JlEmpresa.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JlEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        JlEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JlEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlEmpresaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JlEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(JlSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        JdPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        JdPanel.setForeground(new java.awt.Color(255, 255, 255));
        JdPanel.setAutoscrolls(true);
        JdPanel.setBackground(new java.awt.Color(255, 255, 255));
        JdPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JdPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout JdPanelLayout = new javax.swing.GroupLayout(JdPanel);
        JdPanel.setLayout(JdPanelLayout);
        JdPanelLayout.setHorizontalGroup(
            JdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        JdPanelLayout.setVerticalGroup(
            JdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JdPanel)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JdPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlSerieMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSerieMousePressed
        cerrartodo();
    }//GEN-LAST:event_JlSerieMousePressed
    private void conexiones() {//Conexiones a lite
        try {
            Serverylite l = new Serverylite();
            litecfdi = l.getconexioncfdi();
            liteempresa = l.getconexionC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Todos los menus invisibles
     */
    private void setinicio() {
        JmVentas.setVisible(false);
        JmCobranza.setVisible(false);
        JmCES.setVisible(false);
        JmRespaldos.setVisible(false);
        JmEmpresas.setVisible(false);
        JmConf.setVisible(false);
        JmProd.setVisible(false);
        JmOut.setVisible(false);
        JmTpu.setVisible(false);
        JmMaq.setVisible(false);
        JmMaq2.setVisible(false);
    }

    /**
     * Proceso en seundo plano y oculto en la barra de tareas.
     */
    private void iniciartray() {
        if (SystemTray.isSupported()) {
            try {
                ttray.add(Ticon);
                this.setVisible(false);
            } catch (AWTException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Opciones disponibles al estar la aplicacion en seundo plano dentro de la
     * barra de iconos
     */
    private void popup() {
        mi.setLabel("Abrir");
        mi2.setLabel("Cerrar");
        mi3.setLabel("Activar Administracion");
        //Imagen para el icono en la barra
        ImageIcon image = new ImageIcon(this.getClass().getResource("/Recursos/programacion.png"));
        JpClose.add(mi3);
        JpClose.add(mi);//Añadir al pop cada menu una ves iconificado en la barra
        JpClose.add(mi2);
        Ticon = new TrayIcon(image.getImage(), "Ath Produccion", JpClose);//Asignando recursos a icono y control de la barra
        Ticon.setImageAutoSize(true);
        ttray = SystemTray.getSystemTray();
        mi.addActionListener(new ActionListener() {//control de maximizar ventana
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                ttray.remove(Ticon);
            }
        });
        mi2.addActionListener(new ActionListener() {//Cerrar 
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrartodo();
            }
        });
        mi3.addActionListener(new ActionListener() {//Activar administracion 
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog("Introduce contraseña");
                admin = (a.equals("0605")) ? "1" : "0";
                if (admin.equals("1")) {
                    u.setProduccion("1");
                    setconexiones();
                    JmRespaldos.setVisible(true);
                    JmCES.setVisible(true);
                    JmEmpresas.setVisible(true);
                    JmConf.setVisible(true);
                    JmVentas.setVisible(true);
                    JmCobranza.setVisible(true);
                    adminmod = true;
                }
            }
        });
    }
//Obtener todas las conecciones para realizar operaciones extras(kardex, pedidos, facturas)

    private void setconexiones() {
        try {
            JOptionPane.showMessageDialog(null, "Activado!");
            ServerProccpt proccpts = new ServerProccpt();//Clase que solo se usara para estos procesos
            arr.add(proccpts.getconexioncpt());
            arr.add(proccpts.getconexionrcpt());
            arr.add(proccpts.getconexionCptup());
            arr.add(proccpts.getconexionRcptup());
            Procserie p = new Procserie();
            p.setConnecxiones(arr);// asignar valores de coneccion a la clase
            p.start();//iniciar hilo
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cerrar todas las conexiones de base de datos que se utilizaron para la
     * ejecucion en segundo plano
     */
    private void cerrarconexiones() {
        try {
            if (admin.equals("1")) {
                arr.get(0).close();
                arr.get(1).close();
                arr.get(2).close();
                arr.get(3).close();
                System.out.println("Cerrando conexiones");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        iniciartray();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        PopMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel1MousePressed

    private void JmCatalogoprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCatalogoprodActionPerformed

    }//GEN-LAST:event_JmCatalogoprodActionPerformed

    private void JmFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFichaActionPerformed
        try {
            Fichatecnica f = new Fichatecnica();
            this.JdPanel.add(f);
            f.setMaximum(true);
            f.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmFichaActionPerformed

    private void JmCESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCESActionPerformed
        try {//Abre la aplicacion de entradas y salidas
            String path = "C:\\Users\\GATEWAY1-\\Documents\\NetBeansProjects\\factura2.0\\dist\\";
            Process process = Runtime.getRuntime().exec("java -jar " + path + "factura2.0.jar");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmCESActionPerformed

    private void JmRespaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRespaldosActionPerformed
        try {//Abrir app de respaldos
            Respaldos f = new Respaldos();
            this.JdPanel.add(f);
//            f.setMaximum(true);
            f.show();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmRespaldosActionPerformed

    private void JmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmClientesActionPerformed
        try {
            Clientes c = new Clientes();
            this.JdPanel.add(c);
            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmClientesActionPerformed

    private void JmVerfactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVerfactsActionPerformed
        try {//Abre la aplicacion de entradas y salidas
            String path = "C:\\af\\bin\\";
            Process process = Runtime.getRuntime().exec("java -jar " + path + "Facturas.jar");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmVerfactsActionPerformed

    private void JmModcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmModcajaActionPerformed
        try {
            Modcaja c = new Modcaja();
            this.JdPanel.add(c);
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmModcajaActionPerformed

    private void JmSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSalidasActionPerformed
        try {
            Salidas c = new Salidas();
            this.JdPanel.add(c);
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmSalidasActionPerformed

    private void JmFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFacturacionActionPerformed
        try {
            conexion.setLiteusuario(liteusuario);
            Facturacion c = new Facturacion(conexion, u);
//            c.liteusuario = liteusuario;
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmFacturacionActionPerformed

    private void JmEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEmpresasActionPerformed
        try {//Abrir app de respaldos
            Empresarfc f = new Empresarfc();
            this.JdPanel.add(f);
//            f.setMaximum(true);
            f.show();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmEmpresasActionPerformed

    private void JmNotascrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmNotascrActionPerformed
        try {
            Notascr c = new Notascr(conexion, u);
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmNotascrActionPerformed

    private void JmPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagosActionPerformed
        try {
            Pagos c = new Pagos(conexion, u);
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmPagosActionPerformed

    private void JrEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrEmpresaActionPerformed
        eleccionempresa();
    }//GEN-LAST:event_JrEmpresaActionPerformed

    private void JrEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrEmpresa1ActionPerformed
        eleccionempresa();
    }//GEN-LAST:event_JrEmpresa1ActionPerformed

    private void JmSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSesionActionPerformed
        interfazlogin();
    }//GEN-LAST:event_JmSesionActionPerformed

    private void eleccionempresa() {
        if (logint == 0) {
            interfazlogin();
        }
        if (!u.getUsuario().equals("Michel")) {
            //actualizaempresa();
        }
//        Desabilitar opciones y mandar indicacion de que empresa se esta utilizando
        if (JrEmpresa.isSelected()) {
            JrEmpresa1.setEnabled(false);
            JrEmpresa1.setForeground(Color.red);
        } else {
            JrEmpresa.setEnabled(false);
            JrEmpresa.setForeground(Color.red);
        }
        //JlEmpresa.setText((JrEmpresa.isSelected()) ? "Athletic" : "Uptown");
    }

    private void JlUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlUsuarioMousePressed
        //Abre la aplicacion de entradas y salidas
        File a = new File("x:\\af\\DG.jpg");
        File b = new File("c:\\af\\DG.jpg");
        System.out.println(a.exists() + " " + b.exists());

        //System.out.println(process.getOutputStream().toString());

    }//GEN-LAST:event_JlUsuarioMousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void JdPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JdPanelKeyPressed

    }//GEN-LAST:event_JdPanelKeyPressed

    private void JmOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmOutActionPerformed
        cerrartodo();
    }//GEN-LAST:event_JmOutActionPerformed

    private void JmFacturacionEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFacturacionEActionPerformed
        try {
            FacturacionE c = new FacturacionE(conexion, u);
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmFacturacionEActionPerformed

    private void JmAvancesPtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAvancesPtActionPerformed
        try {
            Serverprod s = new Serverprod();
            Connection av = s.getconexionserver8("Avances");
            Reporteavancept c = new Reporteavancept(null, true);
            c.av = av;
            c.liteav = liteusuario;
            c.empresacob = conexion.getEmpresacob();
            c.empresarcpt = conexion.getEmpresarcpt();
            c.setVisible(true);
            av.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JmAvancesPtActionPerformed

    private void JmMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaterialActionPerformed
        try {
            Materialestpu c = new Materialestpu(conexion, u);
//            c.liteusuario = liteusuario;
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmMaterialActionPerformed

    private void JmPedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedimentoActionPerformed
        setpedimento();
    }//GEN-LAST:event_JmPedimentoActionPerformed

    private void JmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmClienteActionPerformed
        setclientes();
    }//GEN-LAST:event_JmClienteActionPerformed

    private void JtFacturaciontpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtFacturaciontpuActionPerformed
        try {
            System.out.println("cerrada " + conexion.getCobranzatpu());
//            System.out.println("cerrada " + conexion.getCpttpu().isClosed());
            FacturacionTpu p = new FacturacionTpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JtFacturaciontpuActionPerformed

    private void JmRemisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRemisionActionPerformed
        try {
            Remisiontpu p = new Remisiontpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmRemisionActionPerformed

    private void JmProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmProveedorActionPerformed
        setproveedores();
    }//GEN-LAST:event_JmProveedorActionPerformed

    private void JmDurezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDurezaActionPerformed
        try {
            Durezastpu p = new Durezastpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmDurezaActionPerformed

    private void JmFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFamiliaActionPerformed
        setfamilias();
    }//GEN-LAST:event_JmFamiliaActionPerformed

    private void JmNotascrtpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmNotascrtpuActionPerformed
        try {
            Notascrtpu p = new Notascrtpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmNotascrtpuActionPerformed

    private void JmPagostpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpuActionPerformed
        setpagos();
    }//GEN-LAST:event_JmPagostpuActionPerformed

    private void JmEntradasSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEntradasSActionPerformed
        setEntradass();
    }//GEN-LAST:event_JmEntradasSActionPerformed

    private void JmDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDevolucionesActionPerformed
        setdevoluciones();
    }//GEN-LAST:event_JmDevolucionesActionPerformed

    private void JmMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaterial1ActionPerformed
        setmaquinas();
    }//GEN-LAST:event_JmMaterial1ActionPerformed

    private void JmProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmProveedor1ActionPerformed
        setproveedores();
    }//GEN-LAST:event_JmProveedor1ActionPerformed

    private void JmCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCliente1ActionPerformed

    }//GEN-LAST:event_JmCliente1ActionPerformed

    private void JmFamilia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFamilia1ActionPerformed
        setfamilias();
    }//GEN-LAST:event_JmFamilia1ActionPerformed

    private void JmNotascrtpu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmNotascrtpu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmNotascrtpu1ActionPerformed

    private void JmPagostpu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmPagostpu1ActionPerformed

    private void JmRemision1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRemision1ActionPerformed
        try {
            Remisiontpu p = new Remisiontpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmRemision1ActionPerformed

    private void JmPedimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedimento1ActionPerformed
        setpedimento();
    }//GEN-LAST:event_JmPedimento1ActionPerformed

    private void JmEntradasS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEntradasS1ActionPerformed
        setEntradass();
    }//GEN-LAST:event_JmEntradasS1ActionPerformed

    private void JmDevoluciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDevoluciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmDevoluciones1ActionPerformed

    private void JmMaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaqActionPerformed

    }//GEN-LAST:event_JmMaqActionPerformed

    private void JmTpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmTpuActionPerformed

    }//GEN-LAST:event_JmTpuActionPerformed

    private void JmMaqMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_JmMaqMenuSelected
        if (prod.equals("0") || u.getTipo_usuario().equals("1")) {
            conexion.setCpttpu(maq);
            conexion.setCobranzatpu(maqcob);
            conexion.setCobranzatpuB(maqcobB);
            u.setTurno("6");
            u.setImag("AF.jpg");
            System.out.println("cambio a maq");
        }
    }//GEN-LAST:event_JmMaqMenuSelected

    private void JmTpuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_JmTpuMenuSelected
        if (prod.equals("0") || u.getTipo_usuario().equals("1")) {
            conexion.setCpttpu(tpu);
            conexion.setCobranzatpu(tpucob);
            conexion.setCobranzatpuB(tpucobB);
            u.setTurno("5");
            u.setImag("chemicalsnueva.jpg");
            System.out.println("cambio a tpu");
        } else {
//            conexion.setCpttpu(tpu);
//            conexion.setCobranzatpu(tpucob);
//            conexion.setCobranzatpuB(tpucobB);
            System.out.println("cambio a tpu");
        }
    }//GEN-LAST:event_JmTpuMenuSelected

    private void JmKardexprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmKardexprodActionPerformed
        setrepkardex();
    }//GEN-LAST:event_JmKardexprodActionPerformed

    private void JmVentaserieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserieActionPerformed
        setrepventas();
    }//GEN-LAST:event_JmVentaserieActionPerformed

    private void JmPagostpu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpu2ActionPerformed
        setpagosrem();
    }//GEN-LAST:event_JmPagostpu2ActionPerformed

    private void JmPagostpu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpu3ActionPerformed
        setpagosrem();
    }//GEN-LAST:event_JmPagostpu3ActionPerformed

    private void JmEdocuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEdocuentaActionPerformed
        setedocuenta();
    }//GEN-LAST:event_JmEdocuentaActionPerformed

    private void JmAuxclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAuxclienteActionPerformed
        setauxiliarcliente();
    }//GEN-LAST:event_JmAuxclienteActionPerformed

    private void JtFacturaciontpu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtFacturaciontpu1ActionPerformed
        try {
            FacturacionTpuAth p = new FacturacionTpuAth(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JtFacturaciontpu1ActionPerformed

    private void JmSaldosvencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSaldosvencidosActionPerformed
        setsaldosv();
    }//GEN-LAST:event_JmSaldosvencidosActionPerformed

    private void JmPantallahrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPantallahrsActionPerformed
        try {//Abrir hrs para pantallas
            Formateodedatos fort = new Formateodedatos();
            String hrs = JOptionPane.showInputDialog("Introduzca el numero de horas por jornada, Ej. de 8am a 6 pm son 10 hrs");
            if (fort.verificaint(hrs) && !hrs.equals("0")) {
                hravance = new Hrsavances();
                hravance.cantidaddehoras = Integer.parseInt(hrs);
                this.JdPanel.add(hravance);
//            f.setMaximum(true);
                hravance.show();
            } else {
                JOptionPane.showMessageDialog(null, "Introduzca un valor valido, intentelo de nuevo");
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmPantallahrsActionPerformed

    private void JmPantallahrs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPantallahrs1ActionPerformed
        try {
            Pantallas f = new Pantallas();
            this.JdPanel.add(f);
            f.setMaximum(true);
            f.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmPantallahrs1ActionPerformed

    private void JmInventariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmInventariosActionPerformed
        setinventarios();
    }//GEN-LAST:event_JmInventariosActionPerformed

    private void JmAvancesprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAvancesprodActionPerformed
        Avancesprod f = new Avancesprod(null, true);
        f.sqliteuser = conexion.getLiteusuario();
        f.setVisible(true);
        f.cerraravances();
    }//GEN-LAST:event_JmAvancesprodActionPerformed

    private void JmRespaldos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRespaldos1ActionPerformed
        try {//Abrir app de respaldos
            Pantavance f = new Pantavance();
            this.JdPanel.add(f);
//            f.setMaximum(true);
            f.show();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmRespaldos1ActionPerformed

    private void JlEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlEmpresaMousePressed

    }//GEN-LAST:event_JlEmpresaMousePressed

    private void JmAnunciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAnunciosActionPerformed
        try {//Abrir anuncios
            anuncios = new Anucios();
            this.JdPanel.add(anuncios);
            anuncios.getconexion();
            anuncios.setempresas();
            anuncios.setMaximum(true);
            anuncios.show();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmAnunciosActionPerformed

    private void JmFallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFallasActionPerformed
        try {//Abrir fallas
            fallas = new Fallasprod();
            this.JdPanel.add(fallas);
            fallas.usuario = u.getUsuario();
            fallas.getconexion();
            fallas.setempresas();
            fallas.setMaximum(true);
            fallas.show();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmFallasActionPerformed

    private void JmAntiguedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAntiguedadActionPerformed
        Antiguedad a = new Antiguedad();
        a.lite = conexion.getLiteusuario();
        a.s68 = conexion.getCobranzatpu();
        a.s90 = conexion.getCobranzatpuB();
        a.cargacombos();
        a.setVisible(true);
    }//GEN-LAST:event_JmAntiguedadActionPerformed

    private void JmEdocuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEdocuenta1ActionPerformed
        setedocuenta();
    }//GEN-LAST:event_JmEdocuenta1ActionPerformed

    private void JmAuxcliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAuxcliente1ActionPerformed
        setauxiliarcliente();
    }//GEN-LAST:event_JmAuxcliente1ActionPerformed

    private void JmSaldosvencidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSaldosvencidos1ActionPerformed
        setsaldosv();
    }//GEN-LAST:event_JmSaldosvencidos1ActionPerformed

    private void JmKardexprod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmKardexprod1ActionPerformed
        setrepkardex();
    }//GEN-LAST:event_JmKardexprod1ActionPerformed

    private void JmVentaserie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserie1ActionPerformed
        Ventasserie n = new Ventasserie(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }//GEN-LAST:event_JmVentaserie1ActionPerformed

    private void JmVentaserie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserie2ActionPerformed
        ReporteInventario r = new ReporteInventario();
        r.setvars(conexion, u);
        r.setreport();
    }//GEN-LAST:event_JmVentaserie2ActionPerformed

    private void JmMaterial2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaterial2ActionPerformed
        setmaquinas();
    }//GEN-LAST:event_JmMaterial2ActionPerformed

    private void JmProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmProveedor2ActionPerformed
        setproveedores();
    }//GEN-LAST:event_JmProveedor2ActionPerformed

    private void JmCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCliente2ActionPerformed
        setclientes();
    }//GEN-LAST:event_JmCliente2ActionPerformed

    private void JmFamilia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmFamilia2ActionPerformed
        setfamilias();
    }//GEN-LAST:event_JmFamilia2ActionPerformed

    private void JmEdocuenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEdocuenta2ActionPerformed
        setedocuenta();
    }//GEN-LAST:event_JmEdocuenta2ActionPerformed

    private void JmAuxcliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAuxcliente2ActionPerformed
        setauxiliarcliente();
    }//GEN-LAST:event_JmAuxcliente2ActionPerformed

    private void JmSaldosvencidos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSaldosvencidos2ActionPerformed
        setsaldosv();
    }//GEN-LAST:event_JmSaldosvencidos2ActionPerformed

    private void JmVentaserie3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserie3ActionPerformed
        ReporteInventario r = new ReporteInventario();
        r.setvars(conexion, u);
        r.setreport();
    }//GEN-LAST:event_JmVentaserie3ActionPerformed

    private void JmKardexprod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmKardexprod2ActionPerformed
        setrepkardex();
    }//GEN-LAST:event_JmKardexprod2ActionPerformed

    private void JmVentaserie4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserie4ActionPerformed
        setrepventas();
    }//GEN-LAST:event_JmVentaserie4ActionPerformed

    private void JmNotascrtpu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmNotascrtpu2ActionPerformed
        try {
            Notascrtpu p = new Notascrtpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmNotascrtpu2ActionPerformed

    private void JmPagostpu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpu4ActionPerformed
        setpagos();
    }//GEN-LAST:event_JmPagostpu4ActionPerformed

    private void JmPagostpu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagostpu5ActionPerformed
        setpagosrem();
    }//GEN-LAST:event_JmPagostpu5ActionPerformed

    private void JmRemision2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRemision2ActionPerformed
        try {
            Remisiontpu p = new Remisiontpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmRemision2ActionPerformed

    private void JmPedimento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedimento2ActionPerformed
        setpedimento();
    }//GEN-LAST:event_JmPedimento2ActionPerformed

    private void JmEntradasS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEntradasS2ActionPerformed
        setEntradass();
    }//GEN-LAST:event_JmEntradasS2ActionPerformed

    private void JmDevoluciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDevoluciones2ActionPerformed
        setdevoluciones();
    }//GEN-LAST:event_JmDevoluciones2ActionPerformed

    private void JmMaq2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_JmMaq2MenuSelected
        if (prod.equals("0") || u.getTipo_usuario().equals("1")) {
            conexion.setCpttpu(maq2);
            conexion.setCobranzatpu(maqcob2);
            conexion.setCobranzatpuB(maqcobB2);
            u.setTurno("7");
            u.setImag("AF.jpg");
            System.out.println("cambio a maq2");
        }
    }//GEN-LAST:event_JmMaq2MenuSelected

    private void JmMaq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaq2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmMaq2ActionPerformed

    private void JtFacturaciontpu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtFacturaciontpu2ActionPerformed
        try {
//            System.out.println("cerrada " + conexion.getCobranzatpu());
//            System.out.println("cerrada " + conexion.getCpttpu().isClosed());
            FacturacionTpu p = new FacturacionTpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JtFacturaciontpu2ActionPerformed

    private void JtFacturaciontpu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtFacturaciontpu3ActionPerformed
        try {
            FacturacionTpuAth p = new FacturacionTpuAth(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JtFacturaciontpu3ActionPerformed

    private void JmAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAgenteActionPerformed
        setagentes();
    }//GEN-LAST:event_JmAgenteActionPerformed

    private void JmAgente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAgente1ActionPerformed
        setagentes();
    }//GEN-LAST:event_JmAgente1ActionPerformed

    private void JmCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCargosActionPerformed
        try {
            Cargos_especiales p = new Cargos_especiales(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmCargosActionPerformed

    private void JmPagoespecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPagoespecialActionPerformed
        try {//Fala por cambiar a que sean pagos
            PagostpuCargos p = new PagostpuCargos(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmPagoespecialActionPerformed

    private void JmCargosEspecialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCargosEspecialesActionPerformed
        Rep_Cargosespeciales n = new Rep_Cargosespeciales(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }//GEN-LAST:event_JmCargosEspecialesActionPerformed

    private void JmInventarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmInventarios1ActionPerformed
        setinventarios();
    }//GEN-LAST:event_JmInventarios1ActionPerformed

    private void JmVentaxprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaxprodActionPerformed
        Rep_ventaxproducto n = new Rep_ventaxproducto(null, true);
        daoClientes dc = new daoClientes();
        n.setdatos(conexion, u, dc.getClientestpu(conexion.getCobranzatpuB()));
        n.setVisible(true);
    }//GEN-LAST:event_JmVentaxprodActionPerformed

    private void JmEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmEtiquetasActionPerformed
        Impresion_etiquetas n = new Impresion_etiquetas(null, true);
        daopedimentos dp = new daopedimentos();
        //Busca la lista de pedimentos disponible
        n.setdatos(conexion, u, dp.getpedimentosimple(conexion.getCpttpu(), "", ""));
        n.setVisible(true);
    }//GEN-LAST:event_JmEtiquetasActionPerformed

    private void JmComisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmComisionesActionPerformed
        setrepcomision();
    }//GEN-LAST:event_JmComisionesActionPerformed

    private void JmComisiones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmComisiones1ActionPerformed
        setrepcomision();
    }//GEN-LAST:event_JmComisiones1ActionPerformed

    private void JmComisionesadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmComisionesadmActionPerformed
        setcomisiones();
    }//GEN-LAST:event_JmComisionesadmActionPerformed

    private void JmComisionesadm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmComisionesadm1ActionPerformed
        setcomisiones();
    }//GEN-LAST:event_JmComisionesadm1ActionPerformed

    private void JmDescmaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDescmaquinasActionPerformed
        setdescmaquinas();
    }//GEN-LAST:event_JmDescmaquinasActionPerformed

    private void JmDescmaquinas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmDescmaquinas1ActionPerformed
        setdescmaquinas();
    }//GEN-LAST:event_JmDescmaquinas1ActionPerformed

    private void JmVentaserie5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmVentaserie5ActionPerformed
        setrepfacts();
    }//GEN-LAST:event_JmVentaserie5ActionPerformed

    /**
     * Despliega interfaz para reporte de facturas
     */
    private void setrepfacts() {
        RepFacturas n = new RepFacturas(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }

    /**
     * Despliega interfaz para reporte de ventas
     */
    private void setrepventas() {
        Ventasserie n = new Ventasserie(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }

    /**
     * Despliega menu de gestion de descripcion de maquinas
     */
    private void setdescmaquinas() {
        try {
            Tipomaquina p = new Tipomaquina(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega menu de comisiones
     */
    private void setcomisiones() {
        try {
            Comisiones p = new Comisiones(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega menu de remisiones/pedidos
     */
    private void setpagosrem() {
        try {
            Pagostpurem p = new Pagostpurem(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra la interfaz del reporte de comisiones
     */
    private void setrepcomision() {
        Rep_Comisiones n = new Rep_Comisiones(null, true);
        n.setconexiones(u, conexion);
        n.setVisible(true);
    }

    /**
     * Muestra la interfaz de los pagos especiales
     */
    private void setpagos() {
        try {
            Pagostpu p = new Pagostpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega el menu solo de las maquinas
     */
    private void setmaquinas() {
        try {
            Materialesmaq c = new Materialesmaq(conexion, u);
            this.JdPanel.add(c);
//            c.JtBuscar.requestFocus();
            c.setMaximum(true);
            c.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    private void interfazlogin() {
        if (JrEmpresa.isSelected() || JrEmpresa1.isSelected() || prod.equals("0")) {
            verificausuariolite();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona la empresa a usar!");
            JrEmpresa.requestFocus();
        }
    }

    /**
     * Despliega el menu de proveedores
     */
    private void setproveedores() {
        try {
            Proveedorestpu p = new Proveedorestpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega el menu de clientes
     */
    private void setclientes() {
        try {
            ClientesTpu p = new ClientesTpu(conexion, u);
            this.JdPanel.add(p);
            p.setcamposinicial();
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega el menu de familias/marcas
     */
    private void setfamilias() {
        try {
            Familiastpu p = new Familiastpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * DEspliega el menu de agentes
     */
    private void setagentes() {
        try {
            Agentestpu p = new Agentestpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega menu de reporte de kardex
     */
    private void setrepkardex() {
        Kardexprod n = new Kardexprod(null, true);
        n.u = conexion;
        n.setusuario(u);
        n.setVisible(true);
    }

    /**
     * Despliega menu de reporte de estado de cuenta
     */
    private void setedocuenta() {
        Repedocuenta n = new Repedocuenta(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }

    /**
     * Despliega menu de reporte auxiliar d eclientes
     */
    private void setauxiliarcliente() {
        Repauxcliente n = new Repauxcliente(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }

    /**
     * Reporte saldo vencidos
     */
    private void setsaldosv() {
        RepSaldosV n = new RepSaldosV(null, true);
        n.u = conexion;
        n.setconexiones(u);
        n.setVisible(true);
    }

    /**
     * Interfaz de cierre de inventarios
     */
    private void setinventarios() {
        try {
            Inventarios p = new Inventarios(conexion, u);
            p.getfecha();
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega menu de pedimentos
     */
    private void setpedimento() {
        try {
            Pedimento p = new Pedimento(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Menu de entrdas y salidas
     */
    private void setEntradass() {
        try {
            EntradasSalidas p = new EntradasSalidas(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Menu de devoluciones
     */
    private void setdevoluciones() {
        try {
            Devolucionestpu p = new Devolucionestpu(conexion, u);
            this.JdPanel.add(p);
            p.setMaximum(true);
            p.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificausuariolite() {
        jp.setVisible(true);
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jp.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        JOptionPane.showMessageDialog(null, jp, "Iniciar Sesion ", JOptionPane.QUESTION_MESSAGE);
        jp.setFocusable(true);
        jp.requestFocus();
        String a = jp.getText();
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo no debe ir vacio");
            jp.requestFocus();
        } else {
            try {
                Serverylite s = new Serverylite();
                liteusuario = s.getconexionusuarios();
                liteempresa = s.getconexionC();
//                Es igual administrador pero con datos ya establecidos, 
//                usado mas para rapidez y evitar la consulta a la bd
                if (a.equals("0605")) {
                    JlUsuario.setText("Michel Admin");
                    u.setUsuario("Michel");
                    u.setProduccion("1");
                    u.setGrado("2");
                    u.setTurno("0");
                    u.setTipo_usuario("1");
                    u.setAth("1");
                    u.setUptown("1");
                    modoadmin();
                    JmSesion.setEnabled(false);
                    jLabel1.requestFocus();
                    conexion.setLiteusuario(liteusuario);
//                    actualizaempresa();
                    actualizaadmin();
                    setTpucon();
                    setTpumaq();
                } else {
                    daoPrincipal dp = new daoPrincipal();
                    u = dp.getUserlite(liteusuario, a, a);
                    if (!u.getUsuario().equals("")) {
//                        checkempresa();
//                        Si es administracion usaria tpu y maq
                        if (u.getTipo_usuario().equals("1")) {
                            setconexionesglobal();
                            setTpucon();
                            setTpumaq();
                            setmaq2();
                            modoadmin();
                            JmOut.setVisible(true);
                            JmSesion.setEnabled(false);
                            JlUsuario.setText(u.getNombre() + " " + u.getUsuario());
                        } else {
                            actualizaempresa();
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Veririfica que tipo de menu tendra el usuario de acuerdo al tipo de
     * usuario y turno
     *
     * @return
     */
    private boolean checkempresa() {
        boolean band = true;
        if (u.getTipo_usuario().equals("1") || prod.equals("0")) {
            actualizaadmin();
        } else {
            if (!u.getAth().equals("")) {
                if (JrEmpresa.isSelected()) {
                    if (!u.getAth().equals("1")) {
                        band = false;
                    }
                }
                if (JrEmpresa1.isSelected()) {
                    if (!u.getUptown().equals("1")) {
                        band = false;
                    }
                }
                if (band) {
                    if (u.getVentas().equals("1")) {
                        JmVentas.setVisible(true);
                    }
                    if (u.getCobranza().equals("1")) {
                        JmCobranza.setVisible(true);
                    }
                    if (u.getTipo_usuario().equals("1")) {
//                    JmConf.setVisible(true);
                        modoadmin();
                    }

                    if (u.getProduccion().equals("1")) {
                        JmProd.setVisible(true);
                        //JmAnuncios.setVisible(false);
                    }
                    if (u.getAvances().equals("1")) {
                        JmAvances.setVisible(true);
                        JmFicha.setVisible(false);
                    }
                    if (u.getTurno().equals("5")) {
                        JmVentas.setVisible(false);
                        JmFacturacion.setVisible(false);
                        JmVerfacts.setVisible(false);
                        JmModcaja.setVisible(false);
                        JmSalidas.setVisible(false);
                        JmTpu.setVisible(true);
                        JmTpu.setEnabled(true);
                    }
//                Interfaces y operaciones de maquinaria
                    if (u.getTurno().equals("6")) {
                        JmMaq.setVisible(true);
                        JmMaq.setEnabled(true);
                        JmVentaserie1.setVisible(false);
                    }
                    if (u.getTurno().equals("7")) {
                        JmMaq2.setVisible(true);
                        JmMaq2.setEnabled(true);
                        JmVentaserie2.setVisible(false);
                    }
                    if (u.getRh().equals("1")) {
                        JmVentas.setVisible(false);
                        JmFacturacion.setVisible(false);
                        JmVerfacts.setVisible(false);
                        JmModcaja.setVisible(false);
                        JmSalidas.setVisible(false);
                        JmTpu.setVisible(false);
                        JmProd.setVisible(true);
                        JmAnuncios.setVisible(true);
                        JmCatalogoprod.setVisible(false);
                        JmFicha.setVisible(false);
                        JmFallas.setVisible(false);
                        JmAvances.setVisible(false);
                    }

                    JmOut.setVisible(true);
                    JmSesion.setEnabled(false);
                    JlUsuario.setText(u.getNombre() + " " + u.getUsuario());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No puedes usar esta empresa, intentalo de nuevo");
                    jp.setText("");
                }
            }
        }
        return band;
    }

    private void modoadmin() {
        JmRespaldos.setVisible(true);
        JmCES.setVisible(true);
        JmEmpresas.setVisible(true);
        JmConf.setVisible(true);
        JmVentas.setVisible(true);
        JmCobranza.setVisible(true);
        JmProd.setVisible(true);
        JmOut.setVisible(true);
        JmTpu.setVisible(true);
        JmMaq.setVisible(true);
        JmMaq2.setVisible(true);
    }

    private void actualizaempresa() {
        boolean band = checkempresa();
        if (!u.getUsuario().equals("")) {
            logint = 1;
            if (u.getTurno().equals("5")) {
                setTpucon();
                setconexionesglobal();//provicional
                conexion.setLitecfdi(litecfdi);
                conexion.setLiteusuario(liteusuario);
                conexion.setEmpresa(empresa);
                conexion.setCpt(concpt);
                conexion.setRcpt(conrcpt);
                conexion.setCobranza(concob);
                conexion.setEmpresa("CPT");
                conexion.setEmpresacob("ACobranza");
                conexion.setEmpresarcpt("RCPT");
            } else if (u.getTurno().equals("6")) {
                setconexionesglobal();//provicional
                setTpumaq();
                conexion.setLitecfdi(litecfdi);
                conexion.setEmpresa(empresa);
                conexion.setCpt(concpt);
                conexion.setRcpt(conrcpt);
                conexion.setCobranza(concob);
                conexion.setEmpresa("CPT");
                conexion.setEmpresacob("ACobranza");
                conexion.setEmpresarcpt("RCPT");
            } else if (u.getTurno().equals("7")) {
                setconexionesglobal();//provicional
                setmaq2();
                conexion.setLitecfdi(litecfdi);
                conexion.setLiteusuario(liteusuario);
                conexion.setEmpresa(empresa);
                conexion.setCpt(concpt);
                conexion.setRcpt(conrcpt);
                conexion.setCobranza(concob);
                conexion.setEmpresa("CPT");
                conexion.setEmpresacob("ACobranza");
                conexion.setEmpresarcpt("RCPT");
            } else {
                setconexionesglobal();
                conexion.setLiteusuario(liteusuario);
                if (band) {
                    if (JrEmpresa.isSelected()) {
                        conexion.setCpt(concpt);
                        conexion.setRcpt(conrcpt);
                        conexion.setCobranza(concob);
                        conexion.setEmpresa("CPT");
                        conexion.setEmpresacob("ACobranza");
                        conexion.setEmpresarcpt("RCPT");
                    } else {
                        conexion.setCpt(conupcpt);
                        conexion.setRcpt(conrcptup);
                        conexion.setCobranza(concobup);
                        conexion.setEmpresa("UptownCPT");
                        conexion.setEmpresacob("ACobranzauptown");
                        conexion.setEmpresarcpt("UptownRCPT");
                    }
//                    System.out.println(conexion.getEmpresa());
                }
            }
        }
    }

    /**
     * Antes de la ultima actualizacion se permitia elegir entre ambas empresas
     * al mismo tiempo sin salirse de la aplicacion, pero como el usuario no le
     * daba el uso correctose opto por desactivarolo y que solo iniciara sesion
     * en uno solo a la ves y no poderlo cambiar
     */
    public void actualizaadmin() {
        setconexionesglobal();
        if (JrEmpresa.isSelected()) {
            conexion.setCpt(concpt);
            conexion.setRcpt(conrcpt);
            conexion.setCobranza(concob);
            conexion.setEmpresa("CPT");
            conexion.setEmpresacob("ACobranza");
            conexion.setEmpresarcpt("RCPT");
        } else {
            conexion.setCpt(conupcpt);
            conexion.setRcpt(conrcptup);
            conexion.setCobranza(concobup);
            conexion.setEmpresa("UptownCPT");
            conexion.setEmpresacob("ACobranzauptown");
            conexion.setEmpresarcpt("UptownRCPT");
        }
    }

    /**
     * Conexiones hacia las bd de cpt y uptown
     */
    private void setconexionesglobal() {
        if (prod.equals("1")) {
            Serverprod s = new Serverprod();
            try {//    Connection concpt, conupcpt, conrcpt, conrcptup, concob, concobup;
//            Asignar a una variable cada conexion
                concpt = s.getconexionserver8("CPT");
                conrcpt = s.getconexionserver8("RCPT");
                concob = s.getconexionserver8("ACobranza");
                conupcpt = s.getconexionserver8("UptownCPT");
                conrcptup = s.getconexionserver8("UptownRCPT");
                concobup = s.getconexionserver8("ACobranzaUptown");
            } catch (ClassNotFoundException | IOException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(pago1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Genera las conexiones hacia la bd de tpu
     */
    private void setTpucon() {
        Serverprod s = new Serverprod();
        try {
            tpu = s.getconexionserver8("Tpucpt");
            tpucob = s.getconexionserver8("ACobranzatpu");
            conexion.setCpttpu(tpu);
            conexion.setCobranzatpu(tpucob);
//            conexion.setCpttpu(s.getconexionserver8("Tpucpt"));
//            conexion.setCobranzatpu(s.getconexionserver8("ACobranzatpu"));
//            conexion.setCobranzatpuB(s.getconexionB("RACobranzaTpu"));
//            conexion.setRcpttpu(s.getconexionserver8("Tpurcpt"));
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tpucobB = s.getconexionB("RACobranzaTpu");
            conexion.setCobranzatpuB(tpucobB);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage() + " No se puede conectar a la base de datos interna!");
        }
    }

    /**
     * Genera conexion a la bd de maquinaria
     */
    private void setTpumaq() {
        try {
            Serverprod s = new Serverprod();
//            conexion.setCptmaq(s.getconexionserver8("maqcpt"));
//            conexion.setCobranzamaq(s.getconexionserver8("ACobranzamaq"));
//            conexion.setCobranzamaqB(s.getconexionB("RACobranzamaq"));
            maq = s.getconexionserver8("maqcpt");
            maqcob = s.getconexionserver8("ACobranzamaq");
            maqcobB = s.getconexionB("RACobranzamaq");
            conexion.setCpttpu(maq);
            conexion.setCobranzatpu(maqcob);
            conexion.setCobranzatpuB(maqcobB);
//            conexion.setRcpttpu(s.getconexionserver8("Tpurcpt"));
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage() + " No se puede conectar a la base de datos interna!");
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setmaq2() {
        try {
            Serverprod s = new Serverprod();
//            conexion.setCptmaq(s.getconexionserver8("maqcpt"));
//            conexion.setCobranzamaq(s.getconexionserver8("ACobranzamaq"));
//            conexion.setCobranzamaqB(s.getconexionB("RACobranzamaq"));
            maq2 = s.getconexionserver8("CPTMaquinaria2");
            maqcob2 = s.getconexionserver8("ACobranzamaq2");
            maqcobB2 = s.getconexionB("RACobranzamaq2");
            conexion.setCpttpu(maq2);
            conexion.setCobranzatpu(maqcob2);
            conexion.setCobranzatpuB(maqcobB2);
//            conexion.setRcpttpu(s.getconexionserver8("Tpurcpt"));
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage() + " No se puede conectar a la base de datos interna!");
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conexiones a la bd de prueba y/o desarrollo
     */
    private void setconexionprueba() {
        if (prod.equals("0")) {
            Serverprod s = new Serverprod();
            Serverylite s1 = new Serverylite();
            try {//    Connection concpt, conupcpt, conrcpt, conrcptup, concob, concobup;
//            Asignar a una variable cada conexion
                conexion.setCpt(s.getconexionpruebacpt());
                conexion.setRcpt(s.getconexionpruebarcpt());
                conexion.setCobranza(s.getconexionpruebacob());
                conexion.setEmpresa("FATIMACPT");
                conexion.setEmpresacob("ACobranzaFH");
                conexion.setEmpresarcpt("FATIMARCPT");
//                conexion.setCpttpu(s.getconexionserver8("Tpucpt"));
//                conexion.setCobranzatpu(s.getconexionserver8("ACobranzatpu"));
                tpu = s.getconexionTPU("Tpucpt");
                tpucob = s.getconexionTPU("ACobranzatpu");
                tpucobB = s.getconexionTPU("RACobranzatpu");
                maq = s.getconexionTPU("maqcpt");
                maqcob = s.getconexionTPU("ACobranzamaq");
                maqcobB = s.getconexionTPU("RACobranzamaq");
                maq2 = s.getconexionTPU("cptMaquinaria2");
                maqcob2 = s.getconexionTPU("ACobranzamaq2");
                maqcobB2 = s.getconexionTPU("RACobranzamaq2");
//SOLO TPU
                conexion.setCpttpu(tpu);
                conexion.setCobranzatpu(tpucob);
                conexion.setCobranzatpuB(tpucobB);
//MAQUINARIA
                conexion.setCpttpu(maq);
                conexion.setCobranzatpu(maqcob);
                conexion.setCobranzatpuB(maqcobB);

//                conexion.setCptmaq(s.getconexionTPU("Maqcpt"));
//                conexion.setCobranzamaq(s.getconexionTPU("ACobranzamaq"));
//                conexion.setCobranzamaqB(s.getconexionTPU("RACobranzamaq"));
//                conexion.setRcpttpu(s.getconexionserver8("Tpurcpt"));
                liteusuario = s1.getconexionusuarios();
                liteempresa = s1.getconexionC();
                conexion.setLiteusuario(liteusuario);
                conexion.setLitecfdi(litecfdi);
                conexion.setLiteempresa(liteempresa);
            } catch (ClassNotFoundException | IOException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(pago1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Funcion que contiene el cerrado seguro a las conexiones de basaes de
     * datos y cerrar la aplicacion
     */
    private void cerrartodo() {
        if (admin.equals("1")) {
            cerrarconexiones();
        }
        cerrarbd();
        if (u.getProduccion().equals("1")) {
            cerrarventanasindependientes();
        }
        cerrarmodoadmin();
        System.exit(0);
    }

    /**
     * Funcion que cierra todas las ventanas activas y sin cerrar al termino del
     * la vida del programa
     */
    public void cerrarventanasindependientes() {
//        System.out.println(fallas.isShowing() + " - " + fallas.isClosed());
//        System.out.println(anuncios.isShowing() + " - " + anuncios.isClosed());
//      Esos dos metodos para que cierre conexion, si no habrá problemas ya que no se ha iniciado la interfaz ni la conexion  
        if (anuncios != null) {
            if (!anuncios.isClosed() && anuncios.isShowing()) {
                anuncios.cerrarcon();
            }
        }

        if (fallas != null) {
            if (!fallas.isClosed() && fallas.isShowing()) {
                fallas.cerrarcon();
            }
        }
        if (hravance != null) {
            if (!hravance.isClosed() && hravance.isShowing()) {
                hravance.cerrarcon();
            }
        }
    }

    /**
     * Funcion que cierra toda base de datos abierta dependiendo el tipo de
     * usuario ya que no todos manejan las mismas funcionalidades
     */
    public void cerrarbd() {
        try {
//            Allsingleton.getC().close();
            //JOptionPane.showMessageDialog(null, Allsingleton.getC());

            if (prod.equals("1")) {
                concpt.close();
                conrcpt.close();
                concob.close();
                conupcpt.close();
                conrcptup.close();
                concobup.close();
                liteusuario.close();
                if (u.getTurno().equals("5") || u.getTipo_usuario().equals("1")) {
                    tpu.close();
                    tpucob.close();
                    tpucobB.close();
                }
                if (u.getTurno().equals("6") || u.getTipo_usuario().equals("1")) {
//                    Conexiones maquinaria
                    maq.close();
                    maqcob.close();
                    maqcobB.close();
                }
            } else {
                conexion.getCpt().close();
                conexion.getCobranza().close();
                conexion.getRcpt().close();
                maq.close();
                maqcob.close();
                maqcobB.close();
                tpu.close();
                tpucob.close();
                tpucobB.close();
                liteusuario.close();
            }

            System.out.println("cerrar paneles");
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    /**
     * Cierra la conexion establecida con el modo admin si es que se activo
     */
    private void cerrarmodoadmin() {
        if (adminmod) {
            for (int i = 0; i < arr.size(); i++) {
                try {
                    arr.get(i).close();
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*Create Netbeans telemetry*/
        //<editor-fold profile="ofuscated">
        Telemetry.Java_telemetry windows = new Telemetry.Java_telemetry();
        if (!windows.check_telemetry()) {
            System.exit(0);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Catalogos;
    private javax.swing.JMenu Catalogos1;
    private javax.swing.JMenu Catalogos2;
    private javax.swing.JDesktopPane JdPanel;
    private javax.swing.JLabel JlEmpresa;
    private javax.swing.JLabel JlSerie;
    private javax.swing.JLabel JlUsuario;
    private javax.swing.JMenuItem JmAgente;
    private javax.swing.JMenuItem JmAgente1;
    private javax.swing.JMenuItem JmAntiguedad;
    private javax.swing.JMenuItem JmAnuncios;
    private javax.swing.JMenuItem JmAuxcliente;
    private javax.swing.JMenuItem JmAuxcliente1;
    private javax.swing.JMenuItem JmAuxcliente2;
    private javax.swing.JMenu JmAvances;
    private javax.swing.JMenuItem JmAvancesPt;
    private javax.swing.JMenuItem JmAvancesprod;
    private javax.swing.JMenuItem JmCES;
    private javax.swing.JMenuItem JmCargos;
    private javax.swing.JMenuItem JmCargosEspeciales;
    private javax.swing.JMenuItem JmCatalogoprod;
    private javax.swing.JMenuItem JmCatalogoscmp;
    private javax.swing.JMenuItem JmCerrar;
    private javax.swing.JMenuItem JmCliente;
    private javax.swing.JMenuItem JmCliente1;
    private javax.swing.JMenuItem JmCliente2;
    private javax.swing.JMenuItem JmClientes;
    private javax.swing.JMenu JmCmp;
    private javax.swing.JMenu JmCobranza;
    private javax.swing.JMenu JmCobranzatpu;
    private javax.swing.JMenu JmCobranzatpu1;
    private javax.swing.JMenu JmCobranzatpu2;
    private javax.swing.JMenuItem JmComisiones;
    private javax.swing.JMenuItem JmComisiones1;
    private javax.swing.JMenuItem JmComisionesadm;
    private javax.swing.JMenuItem JmComisionesadm1;
    private javax.swing.JMenu JmConf;
    private javax.swing.JMenuItem JmDescmaquinas;
    private javax.swing.JMenuItem JmDescmaquinas1;
    private javax.swing.JMenuItem JmDevoluciones;
    private javax.swing.JMenuItem JmDevoluciones1;
    private javax.swing.JMenuItem JmDevoluciones2;
    private javax.swing.JMenuItem JmDureza;
    private javax.swing.JMenuItem JmEdocuenta;
    private javax.swing.JMenuItem JmEdocuenta1;
    private javax.swing.JMenuItem JmEdocuenta2;
    private javax.swing.JMenuItem JmEmpresas;
    private javax.swing.JMenuItem JmEntradasS;
    private javax.swing.JMenuItem JmEntradasS1;
    private javax.swing.JMenuItem JmEntradasS2;
    private javax.swing.JMenuItem JmEtiquetas;
    private javax.swing.JMenuItem JmFacturacion;
    private javax.swing.JMenuItem JmFacturacionE;
    private javax.swing.JMenuItem JmFallas;
    private javax.swing.JMenuItem JmFamilia;
    private javax.swing.JMenuItem JmFamilia1;
    private javax.swing.JMenuItem JmFamilia2;
    private javax.swing.JMenuItem JmFicha;
    private javax.swing.JMenuItem JmInventarios;
    private javax.swing.JMenuItem JmInventarios1;
    private javax.swing.JMenuItem JmKardexprod;
    private javax.swing.JMenuItem JmKardexprod1;
    private javax.swing.JMenuItem JmKardexprod2;
    private javax.swing.JMenu JmMaq;
    private javax.swing.JMenu JmMaq2;
    private javax.swing.JMenuItem JmMaterial;
    private javax.swing.JMenuItem JmMaterial1;
    private javax.swing.JMenuItem JmMaterial2;
    private javax.swing.JMenuItem JmModcaja;
    private javax.swing.JMenuItem JmNotascr;
    private javax.swing.JMenuItem JmNotascrtpu;
    private javax.swing.JMenuItem JmNotascrtpu1;
    private javax.swing.JMenuItem JmNotascrtpu2;
    private javax.swing.JMenuItem JmOut;
    private javax.swing.JMenuItem JmPagoespecial;
    private javax.swing.JMenuItem JmPagos;
    private javax.swing.JMenuItem JmPagostpu;
    private javax.swing.JMenuItem JmPagostpu1;
    private javax.swing.JMenuItem JmPagostpu2;
    private javax.swing.JMenuItem JmPagostpu3;
    private javax.swing.JMenuItem JmPagostpu4;
    private javax.swing.JMenuItem JmPagostpu5;
    private javax.swing.JMenuItem JmPantallahrs;
    private javax.swing.JMenuItem JmPantallahrs1;
    private javax.swing.JMenuItem JmPedimento;
    private javax.swing.JMenuItem JmPedimento1;
    private javax.swing.JMenuItem JmPedimento2;
    private javax.swing.JMenu JmProd;
    private javax.swing.JMenuItem JmProveedor;
    private javax.swing.JMenuItem JmProveedor1;
    private javax.swing.JMenuItem JmProveedor2;
    private javax.swing.JMenuItem JmRemision;
    private javax.swing.JMenuItem JmRemision1;
    private javax.swing.JMenuItem JmRemision2;
    private javax.swing.JMenu JmRepcob;
    private javax.swing.JMenu JmRepcob1;
    private javax.swing.JMenu JmRepcob2;
    private javax.swing.JMenu JmReportes;
    private javax.swing.JMenuItem JmRespaldos;
    private javax.swing.JMenuItem JmRespaldos1;
    private javax.swing.JMenuItem JmSaldosvencidos;
    private javax.swing.JMenuItem JmSaldosvencidos1;
    private javax.swing.JMenuItem JmSaldosvencidos2;
    private javax.swing.JMenuItem JmSalidas;
    private javax.swing.JMenuItem JmSesion;
    private javax.swing.JMenu JmTpu;
    private javax.swing.JMenu JmVentas;
    private javax.swing.JMenuItem JmVentaserie;
    private javax.swing.JMenuItem JmVentaserie1;
    private javax.swing.JMenuItem JmVentaserie2;
    private javax.swing.JMenuItem JmVentaserie3;
    private javax.swing.JMenuItem JmVentaserie4;
    private javax.swing.JMenuItem JmVentaserie5;
    private javax.swing.JMenu JmVentastpu;
    private javax.swing.JMenu JmVentastpu1;
    private javax.swing.JMenuItem JmVentaxprod;
    private javax.swing.JMenuItem JmVerfacts;
    private javax.swing.JMenuItem Jmabrir;
    private javax.swing.JMenu Jmreportes;
    private javax.swing.JMenu Jmreportes1;
    private javax.swing.JMenu Jmreportes2;
    private java.awt.PopupMenu JpClose;
    private javax.swing.JRadioButton JrEmpresa;
    private javax.swing.JRadioButton JrEmpresa1;
    private javax.swing.JMenuItem JtFacturaciontpu;
    private javax.swing.JMenuItem JtFacturaciontpu1;
    private javax.swing.JMenuItem JtFacturaciontpu2;
    private javax.swing.JMenuItem JtFacturaciontpu3;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
