/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Controlinventario;
import Modelo.Formateodedatos;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqlcargos {

    public boolean new_Notacargo(factura f, Connection cobranza) {//Rcpt y cpt
        PreparedStatement st;
        try {
            cobranza.setAutoCommit(false);
            String sql;
            String fol = f.getReferencia();
            String fecha = f.getFecha();
            double total = f.getTotal();
            //cliente
            int idcliente = f.getIdcliente();
            //fin cliente
            int plazo = f.getPlazo();
            int agente = f.getAgente();
            String turno = f.getTurno();
            //Esta variable se utilizará para insertar la fecha de vencimiento
            //Por lo tanto en la consulta o asignacion será la misma
            String fechav = f.getFechasolicitado();
            int cuenta = f.getConceptos();
            //Insertar en cargos
            sql = "insert into cargo(id_agente,id_concepto,id_cliente,referencia,fecha,importe,"
                    + "saldo,SIM,saldomx,turno,comision,plazo,parcialidad,estatus,fechavencimiento) "
                    + "values(" + agente + "," + cuenta + "," + idcliente + ",'" + fol + "','"
                    + fecha + "'," + total + "," + total + "," + total + "," + total + "," + turno + ",0," + plazo + ",0,'1','" + fechav + "')";
//            System.out.println("cargos " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
            cobranza.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cobranza.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "inertar -" + ex1);
                Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public String get_Fechavencimiento(Connection c, int folio) {
        String fecha = "";
        try {
            String sql = "select fechavencimiento \n"
                    + "from cargo\n"
                    + "where referencia='" + folio + "'";
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                fecha = rs.getString("fechavencimiento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }

    public cargo getcargowith_pedido(Connection cob, factura p) {
        cargo c = new cargo();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cargo,id_agente,id_cliente,importe\n"
                    + "from cargo\n"
                    + "where referencia=? and estatus ='1'";
            st = cob.prepareStatement(sql);
            st.setString(1, p.getPedido());
            rs = st.executeQuery();
            while (rs.next()) {
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setAgente(rs.getInt("id_agente"));
                c.setCliente(rs.getInt("id_cliente"));
                c.setImporte(rs.getDouble("importe"));
                //referencia completa
                c.setReferencia(p.getPedido());
                //numero de pedido
                c.setRef(p.getReferencia());
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public ArrayList<cargo> getcargos_especial_CompPagos(Connection cpt, String cliente, String bdcob) {//cargos para complemento a pago especial
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct id_cargo,id_concepto,c.referencia,c.fecha,importe,\n"
                    + "saldo,cli.nombre,sim,c.plazo, c.id_cliente,\n"
                    + " c.referencia as ref, d.FolioFiscal,c.id_agente,d.RFC,cli.cp,cli.regimen,saldomx,metodopago,\n"
                    + " (select count(1)\n"
                    + "from ddoctospagotpu_especial dd\n"
                    + "join doctospagotpu_especial d on dd.id_doctopago=d.id_doctopago\n"
                    + "where foliorel=c.id_cargo and d.estatus='1') as parcialidad\n"
                    + "from " + bdcob + ".dbo.cargoespecial c\n"
                    + "join " + bdcob + ".dbo.cliente cli on c.id_cliente=cli.id_cliente\n"
                    + "join Documento d on case when SUBSTRING(referencia,0,5)='FAC_' then "
                    + "SUBSTRING(c.referencia,5,LEN(c.referencia)) else 0 end =d.folio\n"
                    + "where (c.id_cliente = " + cliente + " ) and c.referencia NOT Like '%NCR%' "
                    + "and saldo!=0 and d.Serie='fac' and d.estatus='1' and "
                    + "ISNULL(foliofiscal,'') !='' and foliofiscal!= 'null' "
                    + "order by c.fecha";
            System.out.println("get clientencr " + sql);
            st = cpt.prepareStatement(sql);
            rs = st.executeQuery();
            int ren = 0;
            while (rs.next()) {
                cargo c = new cargo();
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setCuenta(rs.getInt("id_concepto"));
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(rs.getString("fecha"));
                c.setImporte(rs.getDouble("importe"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setSim(rs.getDouble("sim"));
                c.setNombre(rs.getString("nombre"));
                c.setCliente(rs.getInt("id_cliente"));
                c.setPlazo(rs.getInt("plazo"));
                c.setRef(rs.getString("ref"));
                c.setFoliofiscal(rs.getString("foliofiscal"));
                c.setAgente(rs.getInt("id_agente"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("regimen"));
                c.setSaldomx(rs.getDouble("saldomx"));
                c.setRenglon(ren);
                c.setMetodopago(rs.getString("metodopago"));
                c.setParcialidad(rs.getInt("parcialidad") + 1);
                arr.add(c);
                ren++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public double get_Cargopendiente(Connection c, int cliente, String bd) {
        double saldo = 0;
        try {
            String sql = "select isnull(sum(c.saldomx),0) as saldo,\n"
                    + "isnull((select sum(saldomx) as saldoint \n"
                    + "from " + bd + ".dbo.cargo where (saldo!=0 or saldomx!=0) and "
                    + "estatus='1' and id_cliente=" + cliente + ") ,0)as saldoint\n"
                    + "from cargo c\n"
                    + "where (c.saldo!=0 or c.saldomx!=0) and c.estatus='1' and c.id_cliente=" + cliente;
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                saldo = rs.getDouble("saldo") + rs.getDouble("saldoint");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saldo;
    }

    public ArrayList<cargo> getcargos_toinv(Connection cob, Controlinventario i) {
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            String sql = "select * from cargo";
            PreparedStatement st;
            ResultSet rs;
            Formateodedatos fd = new Formateodedatos();
            st = cob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                cargo c = new cargo();
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setAgente(rs.getInt("id_agente"));
                c.setId_concepto(rs.getInt("id_concepto"));
                c.setCliente(rs.getInt("id_cliente"));
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(fd.ffecha(rs.getString("fecha")));
                c.setImporte(rs.getDouble("importe"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setSaldomx(rs.getDouble("saldomx"));
                c.setTurno(rs.getInt("turno"));
                c.setPlazo(rs.getInt("plazo"));
                c.setParcialidad(rs.getInt("parcialidad"));
                c.setEstado(rs.getString("estatus"));
                c.setFechav(fd.ffecha(rs.getString("fechavencimiento")));
                c.setMes_inv(i.getMes());
                c.setYear_inv(i.getYears());
                c.setTipo_inv(i.getTipo());
                c.setSerie(i.getSerie());
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean Exec_respaldoregs(Connection cob, ArrayList<cargo> arr) {//Rcpt y cpt
        PreparedStatement st;
        String sql="";
        try {
            cob.setAutoCommit(false);
            for (cargo arr1 : arr) {
                sql = "insert into cargorespaldo(id_cargo,id_agente,id_concepto,"
                        + "id_cliente,referencia,fecha,importe,saldo,saldomx,"
                        + "turno,plazo,parcialidad,estatus,fechavencimiento,mes,years,tipo,serie) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                System.out.println("cargos " + sql);
                st = cob.prepareStatement(sql);
                st.setInt(1, arr1.getId_cargo());
                st.setInt(2, arr1.getAgente());
                st.setInt(3, arr1.getId_concepto());
                st.setInt(4, arr1.getCliente());
                st.setString(5, arr1.getReferencia());
                st.setString(6, arr1.getFecha());
                st.setDouble(7, arr1.getImporte());
                st.setDouble(8, arr1.getSaldo());
                st.setDouble(9, arr1.getSaldomx());
                st.setInt(10, arr1.getTurno());
                st.setInt(11, arr1.getPlazo());
                st.setInt(12, arr1.getParcialidad());
                st.setString(13, arr1.getEstado());
                st.setString(14, arr1.getFechav());
                st.setInt(15, arr1.getMes_inv());
                st.setInt(16, arr1.getYear_inv());
                st.setString(17, arr1.getTipo_inv());
                st.setString(18, arr1.getSerie());
                st.executeUpdate();
            }
            //Fin insertar cargos
            cob.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cob.rollback();
                Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "insertar car resp -" + ex + " " + sql);
            return false;
        }
    }
}
