/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fichas;
import Modelo.Unidades;
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
public class unidad {

    public boolean Addficha(Connection con, Fichas f) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into servidor() values()";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(unidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

   public ArrayList<Unidades> getallUnidades(Connection con,ArrayList<Unidades> arr) {
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_unidad,descripcion from Unidad where estatus='1' order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Unidades u = new Unidades();
                u.setId_unidad(rs.getInt("id_unidad"));
                u.setDescripcion(rs.getString("descripcion"));
                arr.add(u);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
