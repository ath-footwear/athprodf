/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Controlinventario;
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
public class sqlcontrolinventarios {

    public Controlinventario getinventarios(Connection c) {
        Controlinventario co = new Controlinventario();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement("select * from controlinventarios");
            rs = st.executeQuery();
            while (rs.next()) {
                co.setId(rs.getInt("id"));
                co.setMes(rs.getInt("mes"));
                co.setYears(rs.getInt("years"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlcontrolinventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return co;
    }
}
