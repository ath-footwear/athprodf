/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Dfactura;
import Modelo.factura;
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
public class sqlpedidos {
    
    public ArrayList<Dfactura> getdpedido(Connection c, factura f, String bd) {
        ArrayList<Dfactura> arr = new ArrayList<>();
        try {
            PreparedStatement s;
            ResultSet rs;
            String sql = "select dp.id_material,dp.cantidad,dp.dureza,m.descripcion,pedido,id_dpedido,id_kardex,id_cargo\n"
                    + "from Dpedido dp\n"
                    + "join pedido p on dp.id_pedido=p.id_pedido\n"
                    + "join materiales m on dp.id_material=m.id_material\n"
                    + "join " + bd + ".dbo.cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS\n"
                    + "where p.id_pedido=?";
            s = c.prepareStatement(sql);
            s.setInt(1, f.getId_pedido());
            rs = s.executeQuery();
            while (rs.next()) {
                Dfactura df = new Dfactura();
                df.setProducto(rs.getInt("id_material"));
                df.setCantidadfloat(rs.getDouble("cantidad"));
                df.setDureza(rs.getString("dureza"));
                df.setDescripcion(rs.getString("descripcion"));
                df.setPedido(rs.getString("pedido"));
                df.setId(rs.getInt("id_dpedido"));
                df.setKardex(f.getId_kardex());
                df.setIdoc(f.getId_pedido());
                df.setCargo(rs.getInt("id_cargo"));
                arr.add(df);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlpedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean actualizadpedido(Connection c, Connection cob, ArrayList<Dfactura> arr) {
        try {
            c.setAutoCommit(false);
            cob.setAutoCommit(false);
            PreparedStatement st;
            String sql;
            int id_ped = arr.get(0).getIdoc();
            int cargo = arr.get(0).getCargo();
//            La base es la sumatoria de los importes
            double total = arr.get(0).getBase();
            for (Dfactura arr1 : arr) {
                int dped = arr1.getId();
                int k = arr1.getKardex();
//                Importe multiplicando la cantidad por el precio
                double imp = arr1.getImporta();
                double precio = arr1.getPrecio();
                sql = "update dpedido set precio=?, costo=?, importe=? where id_dpedido=?";
                st = c.prepareStatement(sql);
                st.setDouble(1, precio);
                st.setDouble(2, precio);
                st.setDouble(3, imp);
                st.setInt(4, dped);
                st.executeUpdate();
                
                sql = "update kardex set precio=?, costo=? where id_kardex=?";
                st = c.prepareStatement(sql);
                st.setDouble(1, precio);
                st.setDouble(2, precio);
                st.setInt(3, k);
                st.executeUpdate();
            }
            sql = "update pedido set total=?, subtotal=? where id_pedido=?";
            st = c.prepareStatement(sql);
            st.setDouble(1, total);
            st.setDouble(2, total);
            st.setInt(3, id_ped);
            st.executeUpdate();
            
            sql = "update cargo set importe=?, saldo=?, SIM=?, saldomx=? where id_cargo=?";
            st = cob.prepareStatement(sql);
            st.setDouble(1, total);
            st.setDouble(2, total);
            st.setDouble(3, total);
            st.setDouble(4, total);
            st.setInt(5, cargo);
            st.executeUpdate();
            cob.commit();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                cob.rollback();
                Logger.getLogger(sqlpedidos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlpedidos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
