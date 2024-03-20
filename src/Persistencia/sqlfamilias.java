/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Familia;
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
public class sqlfamilias {

    /**
     * Obtiene todas las familias
     *
     * @param c
     * @param fam
     * @return
     */
    public ArrayList<Familia> getallfamilias(Connection c, String fam) {
        ArrayList<Familia> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from familias order by descripcion";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Familia f = new Familia();
                f.setId_familia(rs.getInt("id_familia"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setEstatus(rs.getString("estatus"));
                arr.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlfamilias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Ingresa una nueva familia a la bd
     *
     * @param cpt de tpu
     * @param f
     * @return
     */
    public boolean newfamilia(Connection cpt, Familia f) {
        try {
            cpt.setAutoCommit(false);
            PreparedStatement st;
            st = cpt.prepareStatement("insert into familias(descripcion,estatus) "
                    + "values ('" + f.getDescripcion() + "','1')");
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

    /**
     * Actualiza estatus para la tabla de familias
     * @param cpt
     * @param id
     * @param estatus
     * @return 
     */
    public boolean updateestatus(Connection cpt, int id, String estatus) {
        try {
            PreparedStatement st;
            cpt.setAutoCommit(false);
            st = cpt.prepareStatement("update familias set estatus='" + estatus + "' where id_familia=" + id);
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
    
        public ArrayList<String> gettipom(Connection c) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select nombre_maquina from tipo_maquina where estatus='1' order by nombre_maquina";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString("nombre_maquina"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlfamilias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
