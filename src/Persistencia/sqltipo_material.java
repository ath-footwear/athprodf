/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fichas;
import Modelo.Tipo_material;
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
public class sqltipo_material {

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
            Logger.getLogger(sqltipo_material.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public ArrayList<Tipo_material> getallTipomat(Connection con,ArrayList<Tipo_material> arr) {
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_tipo,descripcion from Tipo_material where estatus='1' order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Tipo_material t = new Tipo_material();
                t.setId_tipo(rs.getInt("id_tipo"));
                t.setDescripcion(rs.getString("descripcion"));
                arr.add(t);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
