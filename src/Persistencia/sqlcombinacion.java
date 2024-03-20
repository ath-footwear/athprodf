/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Combinacion;
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
public class sqlcombinacion {

    public ArrayList<Combinacion> getcombinaciones(Connection con, int estilo, int corrida) {
        ArrayList<Combinacion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;

            st = con.prepareStatement("select distinct p.Combinacion,m.Descripcion as material,col.descripcion as color from productos p\n"
                    + "join Combinaciones c on p.Combinacion=c.Combinacion\n"
                    + "join Materiales m on c.Material1= m.Material\n"
                    + "join Colores col on c.Color1=col.Color\n"
                    + "where estilo=? and corrida =?");
            st.setInt(1, estilo);
            st.setInt(2, corrida);
            rs = st.executeQuery();
            while (rs.next()) {
                Combinacion c = new Combinacion();
                c.setCombinacion(rs.getInt("combinacion"));
                c.setMaterial(rs.getString("material"));
                c.setColor(rs.getString("color"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcombinacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
