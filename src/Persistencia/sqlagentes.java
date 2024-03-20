/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agentes;
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
public class sqlagentes {

    /**
     *Obtiene toda la lista de agentes
     * @param con
     * @return
     */
    public ArrayList<Agentes> getAgentes(Connection con) {//cobranza
        ArrayList<Agentes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select cveagente,nombre from agentes order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                Agentes c = new Agentes();
                c.setIdagente(rs.getInt("cveagente"));
                c.setNombre(rs.getString("nombre"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
        public ArrayList<Agentes> getAgentestpu(Connection con) {//cobranza
        ArrayList<Agentes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_agente,nombre from agente order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                Agentes c = new Agentes();
                c.setIdagente(rs.getInt("id_agente"));
                c.setNombre(rs.getString("nombre"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
