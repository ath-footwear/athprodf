/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Empresas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sqlempresa {

    public boolean AddEmpresa(Connection con, Empresas e) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into empresa(nombre,ip,dirimagenes,dirvideos,rfc,rsocial) "
                    + "values('" + e.getNombre() + "','" + e.getIp() + "','" + e.getDirimag() + "','"
                    + e.getDirvideo() + "','" + e.getRfc() + "','" + e.getRsocial() + "')";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Empresas getEmpresa(Connection con) {
        Empresas e = null;
        try {
            PreparedStatement st;
            ResultSet rs;

            st = con.prepareStatement("select nombre,ip,dirimagenes,dirvideos,rfc,rsocial from empresa");
            rs = st.executeQuery();
            while (rs.next()) {
                e = new Empresas();
                e.setNombre(rs.getString("nombre"));
                e.setIp(rs.getString("ip"));
                e.setDirimag(rs.getString("dirimagenes"));
                e.setDirvideo(rs.getString("dirvideos"));
                e.setRfc(rs.getString("rfc"));
                e.setRsocial(rs.getString("rsocial"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public Empresas getEmpresarfc(Connection con, String n) {
        Empresas e = null;
        try {
            PreparedStatement st;
            ResultSet rs;

            String sql ="select * from Empresasrfc where id=" + n;
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                e = new Empresas();
                e.setNombre(rs.getString("nombre"));
                e.setRfc(rs.getString("rfc"));
                e.setRegimen(rs.getString("regimen"));
                e.setCp(rs.getString("cp"));
                e.setCertificado(rs.getString("certificado"));
                e.setKey(rs.getString("key"));
                e.setPass(rs.getString("pass"));
                e.setXml(rs.getString("salidaxml"));
                e.setNumcertificado(rs.getString("numcertificado"));
                e.setUsuariopac(rs.getString("usuariopac"));
                e.setPasspac(rs.getString("passpac"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public ArrayList<Empresas> getallempresas(Connection c) {
        ArrayList<Empresas> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;

            st = c.prepareStatement("select * from Empresasrfc");
            rs = st.executeQuery();
            while (rs.next()) {
                Empresas e = new Empresas();
                e.setIp(rs.getString("id"));
                e.setNombre(rs.getString("nombre"));
                e.setRfc(rs.getString("rfc"));
                e.setRegimen(rs.getString("regimen"));
                e.setCp(rs.getString("cp"));
                e.setCertificado(rs.getString("certificado"));
                e.setKey(rs.getString("key"));
                e.setPass(rs.getString("pass"));
                e.setXml(rs.getString("salidaxml"));
                arr.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean actualizaempresas(Connection con, String columna, String dato, int id) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            sql = "update empresasrfc set "+columna+"='"+dato+"' where id="+id;
//            System.out.println("actualiza empresa" + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
}
