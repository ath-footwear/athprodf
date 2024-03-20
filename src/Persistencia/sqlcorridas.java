/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Corridas;
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
public class sqlcorridas {

    public ArrayList<Corridas> getcorridaxestilo(Connection con, int estilo) {//rcpt
        ArrayList<Corridas> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select distinct estilo,p.corrida,c.Descripcion,PuntoInicial,PuntoFinal from productos p\n"
                    + "join corridas c on p.Corrida=c.Corrida\n"
                    + "where estilo=? and p.estatus='A'");
            st.setInt(1, estilo);
            rs = st.executeQuery();
            while (rs.next()) {
                Corridas p = new Corridas();
                p.setCorrida(rs.getInt("corrida"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPi(rs.getInt("puntoinicial"));
                p.setPf(rs.getInt("puntofinal"));
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
