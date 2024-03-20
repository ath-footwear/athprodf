/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Dureza;
import java.sql.CallableStatement;
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
public class sqldureza {

    /**
     * obtener todos las durezas
     *
     * @param c
     * @return
     */
    public ArrayList<Dureza> getalldurezas(Connection c) {
        ArrayList<Dureza> arr = new ArrayList<>();
        try {
            ResultSet rs;
            CallableStatement st;
            st = c.prepareCall("{call spgetalldureza}");
            rs = st.executeQuery();
            while (rs.next()) {
                Dureza d = new Dureza();
                d.setDureza(rs.getString("dureza"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setEstatus(rs.getString("estatus"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldureza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean getdureza(Connection c, String a) {
        boolean resp = false;
        try {
            ResultSet rs;
            PreparedStatement st;
            st = c.prepareStatement("select descripcion from durezas where dureza='" + a + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldureza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public ArrayList<Dureza> getalldureza(Connection c, String a) {
        ArrayList<Dureza> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            st = c.prepareStatement("select * from durezas where dureza like'%" + a + "%'");
            rs = st.executeQuery();
            while (rs.next()) {
                Dureza d = new Dureza();
                d.setDureza(rs.getString("dureza"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setEstatus(rs.getString("estatus"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldureza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean newdureza(Connection cpt, Dureza f) {
        try {
            cpt.setAutoCommit(false);
            PreparedStatement st;
            st = cpt.prepareStatement("insert into durezas(dureza,estatus) "
                    + "values ('" + f.getDureza() + "','1')");
            st.executeUpdate();
            cpt.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                Logger.getLogger(sqlfamilias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfamilias.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean updateestatus(Connection cpt, String id, String estatus) {
        try {
            PreparedStatement st;
            cpt.setAutoCommit(false);
            st = cpt.prepareStatement("update durezas set estatus='" + estatus + "' where dureza='" + id + "'");
            st.executeUpdate();
            cpt.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                Logger.getLogger(sqlproveedores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlproveedores.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
