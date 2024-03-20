/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fichas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sqlsublinea {

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
            Logger.getLogger(sqlsublinea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean getficha(Connection con) {
        boolean resp = false;
        try {
            PreparedStatement st;
            ResultSet rs;

            st = con.prepareStatement("select nombre from usuarios where contraseña=''");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlsublinea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
