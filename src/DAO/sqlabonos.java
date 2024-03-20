/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Detpagos;
import Modelo.cargo;
import Modelo.factura;
import Persistencia.Procesoserie;
import Persistencia.sqlfactura;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqlabonos {

    private double getcant(double a) {
        double cant = BigDecimal.valueOf(a).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return cant;
    }

    public boolean new_Refacturacion(Connection cobranza, cargo c) {
        PreparedStatement st;
        try {
            cobranza.setAutoCommit(false);
            String sql;
            int cargo = c.getId_cargo();
            int agente = c.getAgente();
            int cliente = c.getCliente();
            int cuenta1 = c.getId_concepto();
            int cuenta2 = c.getId_concepto2();
            String referencia = c.getReferencia();
            String ref = c.getRef();
            String fecha = c.getFecha();
            int turno = c.getTurno();
            double importe = c.getImporte();
            String usuario = c.getUsuario();
            String obs = "Nota de cargo " + referencia;
            String obs2 = "Nota de credito " + referencia;
            //Nota de cargo
            sql = "insert into abono(id_cargo,id_agente,id_concepto,id_cliente,referencia,"
                    + "referenciac,fecha,fechapago,turno,parcialidad,importe,pago,saldo,"
                    + "observaciones,usuario,estatus) "
                    + "values(?,?,?,?,?,?,?,?,?,1,?,?,?,?,?,'1')";
            st = cobranza.prepareStatement(sql);
            st.setInt(1, cargo);
            st.setInt(2, agente);
            st.setInt(3, cuenta1);
            st.setInt(4, cliente);
            st.setString(5, referencia);
            st.setString(6, ref);
            st.setString(7, fecha);
            st.setString(8, fecha);
            st.setInt(9, turno);
            st.setDouble(10, importe);
            st.setDouble(11, importe);
            st.setDouble(12, importe);
            st.setString(13, obs);
            st.setString(14, usuario);
            st.executeUpdate();
            //Nota de credito para regresar el saldo a cero
            sql = "insert into abono(id_cargo,id_agente,id_concepto,id_cliente,referencia,"
                    + "referenciac,fecha,fechapago,turno,parcialidad,importe,pago,saldo,"
                    + "observaciones,usuario,estatus) "
                    + "values(?,?,?,?,?,?,?,?,?,1,?,?,?,?,?,'1')";
            st = cobranza.prepareStatement(sql);
            st.setInt(1, cargo);
            st.setInt(2, agente);
            st.setInt(3, cuenta2);
            st.setInt(4, cliente);
            st.setString(5, referencia);
            st.setString(6, ref);
            st.setString(7, fecha);
            st.setString(8, fecha);
            st.setInt(9, turno);
            st.setDouble(10, importe);
            st.setDouble(11, importe);
            st.setDouble(12, 0);
            st.setString(13, obs2);
            st.setString(14, usuario);
            st.executeUpdate();
            sql = "update cargo set saldo=?,saldomx=? where id_cargo=?";
            st = cobranza.prepareStatement(sql);
            st.setDouble(1, 0);
            st.setDouble(2, 0);
            st.setInt(3, cargo);
            st.executeUpdate();
            cobranza.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cobranza.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "inertar -" + ex1);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public int insertabonostpu(Connection con, factura f, Connection cob) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            DecimalFormat formateador = new DecimalFormat("####.##");
            con.setAutoCommit(false);
            cob.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            String fechap = f.getFechapago();
            String turno = f.getTurno();
            double Total = Double.parseDouble(formateador.format(getcant(f.getTotal())));
            //pagos
//            String rfcctaemi = f.getRfcctaemisora();
//            String ctaemi = f.getCtaemisora();
//            String bcoemi = f.getBancoemisor();
//            String rfcctarep = f.getRfcctareceptor();
//            String ctarep = f.getCtareceptora();
//            String bcorep = f.getBancoreceptor();
            String metodo = f.getMetodopago();
            String formap = f.getFormapago();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            int ag = f.getAgente();
            //fin cliente
            String obs = f.getObservaciones();
//            int cajas = f.getTotalcajas();
//            int cxcaja = f.getCantidadxcaja();
//            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            sql = "insert into Doctospagotpu_especial(id_cliente,id_agente,usuario,folio,serie,fecha,fechapago,condicion,"
                    + "tipodoc,descuento,subtotal,impuestos,total,nombre,rfc,cp,regimen,metodopago,formapago,lugarexp,observaciones,moneda,tipocambio,usocfdi,estatus) "
                    + "values(" + idcliente + "," + ag + ",'" + usuario + "'," + fol + ",'" + serie + "','" + fecha + "','" + fechap + "','contado','PAGOS',0,0,0," + Total + ",'"
                    + nombre + "','" + rfc + "','" + cp + "','" + regimen + "','" + metodo + "','" + formap + "','" + Lugar + "','" + obs + "','" + mon + "'," + tipoc + ",'" + uso + "','1')";
//            System.out.println("EncPago " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();

//            st = con.prepareStatement("select top(1)max(id) as id from doctospagotpu group by fecha order by id desc");
//          Obtiene el ultimo registro insertado
            st = con.prepareStatement("SELECT max(id_doctopago) as id from doctospagotpuespecial");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id");
            }
            rs.close();

//            resp = f.getFolio();
            for (Detpagos arr : f.getArrpagos()) {

                //Inserta en detallado de detallado pago
                double cant = arr.getCantidad();
                String de = arr.getDescripcion();
                String co = arr.getCodigo();
                String umed = arr.getUmedida();
                double precio = arr.getPrecio();
                String fp = arr.getFormadedpago();
                String moneda = arr.getMoneda();
                double mo = getcant(arr.getMonto());
                String rfcce = arr.getRfcctaemisora();
                String rfccr = arr.getRfcctareceptora();
                String ctae = arr.getCtaemisora();
                String ctar = arr.getCtareceptora();
                String uuid = arr.getUuid();
                String fo = arr.getFolio();
                double sald = arr.getSaldo();
                String mp = arr.getMetodopago();
                int par = arr.getParcialidad();
                double salant = getcant(arr.getImportesaldoant());
                double salpag = getcant(arr.getImportepagado());
                double salin = getcant(arr.getImpsaldoinsoluto());
                int idcargo = arr.getIdcargo();
                sql = "insert into Ddoctospagotpu_especial(id_doctopago,cantidad,descripcion,codigosat,unidad,precio,formapagop,monedap,"
                        + "monto,rfcctaemisora,ctaemisora,rfcctareceptora,ctareceptora,uuid,foliorel,moneda,metodopago,"
                        + "noparcialidad,importesdoant,importepagado,impsaldoinsoluto) "
                        + "values(" + resp + "," + cant + ",'" + de + " " + fo + "','" + co + "','" + umed + "',0,'" + fp + "','" + mon + "'," + mo + ",'','','','','"
                        + uuid + "','" + fo + "','" + moneda + "','" + metodo + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
//                System.out.println("d pagos " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                String saldo;
                if (mon.equals("MXN")) {
                    sql = "update cargoespecial set saldomx=" + formateador.format(sald) + " where id_cargo=" + idcargo;
                    saldo = "saldo";
                } else {
                    sql = "update cargoespecial set saldo=" + formateador.format(sald) + " where id_cargo=" + idcargo;
                    saldo = "saldomx";
                }
//                System.out.println("cargos " + sql);
                st = cob.prepareStatement(sql);
                st.executeUpdate();

//                if (salant == mo) {
                if (sald == 0) {
                    sql = "update cargoespecial set saldo=0, saldomx=0  where id_cargo=" + idcargo;
//                    System.out.println("cargos0 " + sql);
                    st = cob.prepareStatement(sql);
                    st.executeUpdate();
                }

                sql = "insert into abonoespecial(id_cargo,id_agente,id_concepto,id_cliente,referencia,referenciac,fecha,"
                        + "fechapago,turno,parcialidad,importe,pago,saldo,comision,observaciones,usuario,estatus) "
                        + "values(" + idcargo + "," + ag + ",3," + idcliente + ",'PAG " + fol + "','" + fol + "','" + fecha + "','" + fechap + "'," + turno + "," + par + "," + mo + "," + salpag + "," + salin + ",0,'" + de + " " + fol + "','" + usuario + "','1')";
//                System.out.println("abonos  " + sql);
                st = cob.prepareStatement(sql);
                st.executeUpdate();

            }
            // Fin detallado de documento

            sql = "update seriesfolio set ufolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            cob.commit();
//            cobranza.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cob.rollback();
//                cobranza.rollback();
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }
}
