/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Colores;
import Modelo.Documentoscpt;
import Modelo.Fichas;
import Modelo.Linea;
import java.io.IOException;
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
public class sqldoccpt {

    public boolean Moddoccpt(Connection con, Documentoscpt d) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update Documentos set totalcajas=" + d.getCajas() + " where serie='FAC' and folio=" + d.getFolio();
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(sqldoccpt.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(sqldoccpt.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return true;
    }
    
        public boolean Moddocimporte(Connection con, Documentoscpt d) {// Solo modifica cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update Documentos set impuestos="+d.getImpuestos()+", total="+d.getTotal()+" where serie='FAC' and folio=" + d.getFolio();
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(sqldoccpt.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(sqldoccpt.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return true;
    }
    

    public ArrayList<Documentoscpt> getDoccpt(Connection con) {
        ArrayList<Documentoscpt> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select folio,subtotal,impuestos,total,serie,convert(date,fecha) as fecha,totalcajas,estatus,nombre\n"
                    + "from documentos where serie='FAC' \n"
                    + "order by folio desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Documentoscpt d = new Documentoscpt();
                d.setFolio(rs.getInt("folio"));
                d.setSubtotal(rs.getFloat("subtotal"));
                d.setImpuestos(rs.getFloat("impuestos"));
                d.setTotal(rs.getFloat("total"));
                d.setCajas(rs.getInt("totalcajas"));
                d.setSerie(rs.getString("serie"));
                d.setFecha(rs.getString("fecha"));
                d.setEstatus(rs.getInt("estatus"));
                d.setNombre(rs.getString("nombre"));
                arr.add(d);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    public Documentoscpt getDocimporte(Connection con, int folio) {// cpt y rcpt
        Documentoscpt d = new Documentoscpt();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql="select folio,subtotal,impuestos,total from documentos where serie='FAC' and folio="+folio;
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                d.setFolio(rs.getInt("folio"));
                d.setSubtotal(rs.getFloat("subtotal"));
                d.setImpuestos(rs.getFloat("impuestos"));
                d.setTotal(rs.getFloat("total"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

}
