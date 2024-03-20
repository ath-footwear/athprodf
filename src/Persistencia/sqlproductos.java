/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Producto;
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
public class sqlproductos {

    public ArrayList<Producto> getprodxestilo(Connection con, int estilo) {//cobranza
        ArrayList<Producto> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select distinct producto,estilo, com.combinacion as comb,p.corrida,"
                    + " c.Descripcion dcorrida,c.PuntoInicial,c.PuntoFinal,m.Descripcion as mdes,col.Descripcion as coldes from productos p\n"
                    + "join corridas c on p.Corrida=c.corrida\n"
                    + "join Combinaciones com on p.Combinacion=com.Combinacion\n"
                    + "join materiales m on com.Material1=m.Material\n"
                    + "join colores col on com.Color1=col.Color\n"
                    + "where estilo=" + estilo + " and estatus='A'");
            rs = st.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setProducto(rs.getInt("producto"));
                p.setEstilo(rs.getInt("Estilo"));
                p.setCombinacion(rs.getInt("comb"));
                p.setCorrida(rs.getInt("corrida"));
                p.setCordesc(rs.getString("dcorrida"));
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

    public Producto getprod(Connection con, int estilo, int corrida, int comb, int almacen, String bd) {//productos x existencias
        Producto p = new Producto();
        ArrayList<String> arr=new ArrayList<>();
        boolean resp=true;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql="select p.producto, punto1,punto2,punto3,punto4,punto5,punto6,punto7,"
                    + "punto8,punto9,punto10,punto11,punto12,l.Marca,p.costo,l.linea from productos p \n"
                    + "join " + bd + " e on e.Producto=p.Producto\n"
                    + "join Lineas l on p.Linea=l.Linea\n"
                    + "where estilo=" + estilo + " and combinacion=" + comb + " and corrida=" + corrida + " and almacen=" + almacen;
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                p.setProducto(rs.getInt("producto"));
                arr.add(rs.getString("punto1"));
                arr.add(rs.getString("punto2"));
                arr.add(rs.getString("punto3"));
                arr.add(rs.getString("punto4"));
                arr.add(rs.getString("punto5"));
                arr.add(rs.getString("punto6"));
                arr.add(rs.getString("punto7"));
                arr.add(rs.getString("punto8"));
                arr.add(rs.getString("punto9"));
                arr.add(rs.getString("punto10"));
                arr.add(rs.getString("punto11"));
                arr.add(rs.getString("punto12"));
                p.setArr(arr);
                p.setMarca(rs.getString("marca"));
                p.setEstilo(estilo);
                p.setCorrida(corrida);
                p.setAlmacen(almacen);
                p.setCombinacion(comb);
                p.setCosto(rs.getFloat("costo"));
                p.setLinea(rs.getInt("linea"));
                resp=false;
            }
            if(resp){
                p.setProducto(0);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
