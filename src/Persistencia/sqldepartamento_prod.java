/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelo.Departamentos_Prod;
import Modelo.Fichas;
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
public class sqldepartamento_prod {

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
            Logger.getLogger(sqldepartamento_prod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
//lista todos los departamentos siempre y cuando esten activos
    public ArrayList<Departamentos_Prod> getAlldepprod(Connection con, ArrayList<Departamentos_Prod> arr) {
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_departamento,descripcion from departamento_prod where estatus='1' order by lineaprod");
            rs = st.executeQuery();
            while (rs.next()) {
                Departamentos_Prod dp= new Departamentos_Prod();
                dp.setId_prod(rs.getInt("id_departamento"));
                dp.setDescripcion(rs.getString("descripcion"));
                arr.add(dp);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
