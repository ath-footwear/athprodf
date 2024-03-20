/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Almacen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * mich
 * 
 * @author GATEWAY1-Michel araujo
 */
public class sqlalmacenes {

    public ArrayList<Almacen> getAgentes(Connection con) {//cobranza
        ArrayList<Almacen> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select almacen,descripcion,grupo from almacenes where estatus='A' order by almacen");
            rs = st.executeQuery();
            while (rs.next()) {
                Almacen a = new Almacen();
                a.setAlmacen(rs.getInt("Almacen"));
                a.setNombre(rs.getString("descripcion"));
                a.setTipoalmacen(rs.getString("grupo"));
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
        public ArrayList<Almacen> getAlmacenes(Connection con) {//cobranza
        ArrayList<Almacen> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from almacenes where estatus='1' order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Almacen a = new Almacen();
                a.setAlmacen(rs.getInt("id_almacen"));
                a.setNombre(rs.getString("descripcion"));
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
