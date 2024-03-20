/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import Modelo.Formateodedatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class Usobd {
    

    private static Connection c;
    private static Connection concfdi;
    
    public void setcon() {
        String url = "jdbc:sqlserver://192.168.6.8:9205;database=Avances";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(url, "sa", "Prok2001");
            System.out.println(c);
        } catch (SQLException ex) {
            Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getcon(){
        return c;
    }

    public void cerrarconexion() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setconcfdi(){
        try {
            String urlitecfdi = "C:\\af\\prod\\cfdi.db";
            Class.forName("org.sqlite.JDBC");
            concfdi=DriverManager.getConnection("jdbc:sqlite:"+urlitecfdi);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getconcfdi(){
        return concfdi;
    }
    
    public void getavances() {
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(10) lote from programa";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("Programa " + rs.getString("lote"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void nuevoavances() {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            String sql = "insert into log_lote(lote) values (?)";
            System.out.println(sql);
            st = c.prepareStatement(sql);
            st.setString(1, "prueba");
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Usobd.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public static void main(String[] args) {
        Usobd b = new Usobd();
//        b.getcon();
//        b.getavances();
////        b.nuevoavances();
//        b.cerrarconexion();
Formateodedatos f = new Formateodedatos();
f.formatclientedigito("9");
    }
    
}
