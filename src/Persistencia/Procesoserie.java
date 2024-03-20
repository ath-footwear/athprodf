/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Seriecpt;
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
public class Procesoserie {

    public ArrayList<Seriecpt> getfolioped(Connection con) {//cpt, uptown cpt
        PreparedStatement st = null;
        ArrayList<Seriecpt> arr = new ArrayList<>();
        try {
            con.setAutoCommit(false);
            //consulta de la ultima ficha
            ResultSet rs;
            st = con.prepareStatement("select folio,npedido\n"
                    + "from kardex\n"
                    + "WHERE (Serie = ' ') \n"
                    + "group by folio,npedido,fmovimiento\n"
                    + "ORDER BY FMovimiento DESC");
            rs = st.executeQuery();
            while (rs.next()) {
                Seriecpt s = new Seriecpt();
                int folio = rs.getInt("folio");
                String pedido = rs.getString("npedido");
                //actualizacion del kardex en cpt
                String sql = "update kardex set serie='A' where folio=" + folio;
//                System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                //actualiazcion de pedidos de cpt
                sql = "update pedidos set serie='A' where serie=' ' and pedido='" + pedido + "'";
//                System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                s.setFolio(folio);
                s.setNpedido(pedido);
                arr.add(s);// añade objeto al array
            }
            rs.close();
            st.close();
            con.commit();
//            con.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return arr;
    }

    public boolean updatepedidos(Connection con, ArrayList<Seriecpt> arr) {//Rcpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            for (int i = 0; i < arr.size(); i++) {
                sql = "update kardex set serie='A' where folio=" + arr.get(i).getFolio();
//                System.out.println("rcpt "+sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                sql = "update pedidos set serie='A' where serie=' ' and pedido='" + arr.get(i).getNpedido() + "'";
//                System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
//            sql = "update pedidos set serie='B' where serie=' ' ";
//            System.out.println(sql);
//            st = con.prepareStatement(sql);
//            st.executeUpdate();
//            sql = "update kardex set serie='B' where serie=' ' ";
//            System.out.println(sql);
//            st = con.prepareStatement(sql);
//            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public ArrayList<Seriecpt> getfacs(Connection con) {//cpt, uptown cpt facs
        PreparedStatement st = null;
        ArrayList<Seriecpt> arr = new ArrayList<>();
        try {
            con.setAutoCommit(false);
            //consulta de la ultima ficha
            ResultSet rs;
            st = con.prepareStatement("select factura \n"
                    + "from facturas \n"
                    + "where serie=' '\n"
                    + "ORDER BY Fecha DESC");
            rs = st.executeQuery();
            while (rs.next()) {
                Seriecpt s = new Seriecpt();
                String factura = rs.getString("factura");
                //actualizacion del kardex en cpt
                String sql = "update facturas set serie='A' where factura='" + factura + "'";
//                System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                s.setNpedido(factura);
                arr.add(s);// añade objeto al array
            }
            rs.close();
            st.close();
            con.commit();
//            con.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return arr;
    }

    public boolean updatefacs(Connection con, ArrayList<Seriecpt> arr) {//Rcpt facs
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            for (int i = 0; i < arr.size(); i++) {
                sql = "update facturas set serie='A' where factura='" + arr.get(i).getNpedido() + "'";
//                System.out.println("rcptfac "+sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
// SOlo pedidos sin uso del kardex
    public ArrayList<Seriecpt> getpedidos(Connection con) {//cpt, uptown cpt
        PreparedStatement st = null;
        ArrayList<Seriecpt> arr = new ArrayList<>();
        try {
            con.setAutoCommit(false);
            //consulta de la ultima ficha
            ResultSet rs;
            st = con.prepareStatement("select pedido from pedidos where serie=' '\n"
                    + "group by pedido,fechapedido\n"
                    + "order by FechaPedido desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Seriecpt s = new Seriecpt();
                String pedido = rs.getString("pedido");
                //actualiazcion de pedidos de cpt
                String sql = "update pedidos set serie='A' where serie=' ' and pedido='" + pedido + "'";
//                System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                s.setNpedido(pedido);
                arr.add(s);// añade objeto al array
            }
            rs.close();
            st.close();
            con.commit();
//            con.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return arr;
    }
    
    public boolean updatesolopedidos(Connection con, ArrayList<Seriecpt> arr) {//Rcpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            for (int i = 0; i < arr.size(); i++) {
                
                sql = "update pedidos set serie='A' where serie=' ' and pedido='" + arr.get(i).getNpedido() + "'";
//              System.out.println(sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
//            sql = "update pedidos set serie='B' where serie=' ' ";
//            System.out.println(sql);
//            st = con.prepareStatement(sql);
//            st.executeUpdate();
//            sql = "update kardex set serie='B' where serie=' ' ";
//            System.out.println(sql);
//            st = con.prepareStatement(sql);
//            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }    
/////////Solo pedidos sin uso de kardex
}
