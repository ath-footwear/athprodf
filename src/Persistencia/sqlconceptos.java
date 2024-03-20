/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ConceptosES;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-Michel araujo
 */
public class sqlconceptos {

    public ArrayList<ConceptosES> getConceptosES(Connection con) {//cobranza
        ArrayList<ConceptosES> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select cuenta,subcuenta,descripcion,tipooperacion from ConceptosES order by cuenta");
            rs = st.executeQuery();
            while (rs.next()) {
                ConceptosES c = new ConceptosES();
                c.setCuenta(rs.getString("cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("descripcion"));
                c.setTipo(rs.getString("tipooperacion"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Conceptos de tpu
     *
     * @param con
     * @param cuenta
     * @return
     */
    public ArrayList<ConceptosES> getConceptosES(Connection con, int cuenta) {//cobranza
        ArrayList<ConceptosES> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String cuentas;
            if (cuenta == 60) {
                cuentas = "cuenta=60";
            } else {
                cuentas = "cuenta=1  or cuenta=10";
            }
//            st = con.prepareStatement("select id_concepto,cuenta,subcuenta,descripcion from Conceptos where cuenta=" + cuenta + " order by cuenta");
            String sql = "select id_concepto,cuenta,subcuenta,descripcion, tipooperacion"
                    + " from Conceptos where " + cuentas + " order by cuenta";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ConceptosES c = new ConceptosES();
                c.setId_concepto(rs.getInt("id_concepto"));
                c.setCuenta(rs.getString("cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("descripcion"));
                c.setTipo(rs.getString("tipooperacion"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ConceptosES getConceptosES(Connection con, int cuenta, int subcuenta) {//cobranza
        ConceptosES c = new ConceptosES();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_concepto,cuenta,subcuenta,descripcion "
                    + "from Conceptos "
                    + "where cuenta=? and subcuenta=? order by cuenta");
            st.setInt(1, cuenta);
            st.setInt(2, subcuenta);
            rs = st.executeQuery();
            while (rs.next()) {
                c.setId_concepto(rs.getInt("id_concepto"));
                c.setCuenta(rs.getString("cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("descripcion"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
        public int getConceptosES_cob(Connection con, int cuenta, int subcuenta) {//cobranza
        int resp=0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_concepto "
                    + "from catcuenta "
                    + "where cuenta=? and subcuenta=? order by cuenta");
            st.setInt(1, cuenta);
            st.setInt(2, subcuenta);
            rs = st.executeQuery();
            while (rs.next()) {
               resp=rs.getInt("id_concepto");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
