/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.Controlinventario;
import Modelo.Detpagos;
import Modelo.Formateodedatos;
import Modelo.Tipo_pagos;
import Modelo.abono;
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
import java.util.ArrayList;
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
            st.close();
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
            st = con.prepareStatement("SELECT max(id_doctopago) as id from doctospagotpu_especial");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id");
            }
            rs.close();

//            resp = f.getFolio();
            for (Tipo_pagos arrp : f.getArrnpagos()) {
                for (Detpagos arr : arrp.getArrdetpago()) {
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
                            + uuid + "','" + idcargo + "','" + moneda + "','" + mp + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
//                System.out.println("d pagos " + sql);
                    st = con.prepareStatement(sql);
                    st.executeUpdate();
                    sql = "update cargoespecial set saldo=" + formateador.format(sald) + " where id_cargo=" + idcargo;
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
                            + "values(" + idcargo + "," + ag + ",3," + idcliente + ",'PAG " + resp + "','" + fol + "','" + fecha + "','" + fechap + "'," + turno + "," + par + "," + mo + "," + salpag + "," + salin + ",0,'" + de + " " + fol + "','" + usuario + "','1')";
//                System.out.println("abonos  " + sql);
                    st = cob.prepareStatement(sql);
                    st.executeUpdate();
                }
            }

            // Fin detallado de documento
            //Actualiza numero de folio
            sql = "update seriesfolio set ufolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            cob.commit();
            st.close();
//            cobranza.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cob.rollback();
//                cobranza.rollback();
                JOptionPane.showMessageDialog(null, "Nuevo Pagespecial -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public ArrayList<abono> getabonos_toinv(Connection cob, Controlinventario i) {
        ArrayList<abono> arra = new ArrayList<>();
        try {
            String sql = "select * from abono";
            Formateodedatos fd = new Formateodedatos();
            PreparedStatement st;
            ResultSet rs;
            st = cob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                abono a = new abono();
                a.setId_abono(rs.getInt("id_abono"));
                a.setId_cargo(rs.getInt("id_cargo"));
                Cliente c = new Cliente();
                c.setAgente(rs.getInt("id_agente"));
                c.setId_cliente(rs.getInt("id_cliente"));
                a.setC(c);
                a.setCuenta(rs.getInt("id_concepto"));
                a.setReferencia(rs.getString("referencia"));
                a.setReferenciac(rs.getString("referenciac"));
                a.setFechac(fd.ffecha(rs.getString("fecha")));
                a.setFechapago(fd.ffecha(rs.getString("fechapago")));
                a.setTurno(rs.getInt("turno"));
                a.setParcialidad(rs.getInt("parcialidad"));
                a.setTotal(rs.getDouble("importe"));
                a.setPago(rs.getDouble("pago"));
                a.setSaldo(rs.getDouble("saldo"));
                a.setComision(rs.getDouble("comision"));
                a.setObs(rs.getString("observaciones"));
                a.setUsuario(rs.getString("usuario"));
                a.setEstatus(rs.getString("estatus"));
                a.setMes_inv(i.getMes());
                a.setYear_inv(i.getYears());
                a.setTipo(i.getTipo());
                a.setSerie(i.getSerie());
                arra.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlabonos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arra;
    }

    public boolean Exec_respaldoregs_abono(Connection cob, ArrayList<abono> arr) {
        PreparedStatement st;
        try {
            cob.setAutoCommit(false);
            String sql;
            for (abono arr1 : arr) {
                sql = "insert into abonorespaldo(id_abono,id_cargo,id_agente,"
                        + "id_concepto,id_cliente,referencia, referenciac,fecha,"
                        + "fechapago,turno,parcialidad,importe,pago,saldo,comision,"
                        + "observaciones,usuario,estatus,mes,years,tipo,serie) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            System.out.println("cargos " + sql);
                st = cob.prepareStatement(sql);
                st.setInt(1, arr1.getId_abono());
                st.setInt(2, arr1.getId_cargo());
                st.setInt(3, arr1.getC().getAgente());
                st.setInt(4, arr1.getCuenta());
                st.setInt(5, arr1.getC().getId_cliente());
                st.setString(6, arr1.getReferencia());
                st.setString(7, arr1.getReferenciac());
                st.setString(8, arr1.getFechac().toString());
                st.setString(9, arr1.getFechapago());
                st.setInt(10, arr1.getTurno());
                st.setInt(11, arr1.getParcialidad());
                st.setDouble(12, arr1.getTotal());
                st.setDouble(13, arr1.getPago());
                st.setDouble(14, arr1.getSaldo());
                st.setDouble(15, arr1.getComision());
                st.setString(16, arr1.getObs());
                st.setString(17, arr1.getUsuario());
                st.setString(18, arr1.getEstatus());
                st.setInt(19, arr1.getMes_inv());
                st.setInt(20, arr1.getYear_inv());
                st.setString(21, arr1.getTipo());
                st.setString(22, arr1.getSerie());
                st.executeUpdate();
            }
            //Fin insertar cargos
            cob.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cob.rollback();
                Logger.getLogger(sqlabonos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlabonos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "insertar car resp -" + ex);
            return false;
        }
    }
}
