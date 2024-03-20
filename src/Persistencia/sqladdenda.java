/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Addenda;
import Modelo.Corridaaddenda;
import Modelo.Destinoscoppel;
import Modelo.Fichas;
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
public class sqladdenda {

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
            Logger.getLogger(sqladdenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Trae todos los destinos de las bodegas de coppel
     *
     * @param rcpt conexion a rcpt
     * @return
     */
    public ArrayList<Destinoscoppel> getDestinos(Connection rcpt) {
        ArrayList<Destinoscoppel> arr = new ArrayList<>();
        ResultSet rs;
        PreparedStatement st;
        try {
            rcpt.setAutoCommit(false);
            String sql = "select * from destinoscoppel";
            st = rcpt.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Destinoscoppel d = new Destinoscoppel();
                d.setId_coppel(rs.getInt("cvedestino"));
                d.setDestino(rs.getString("destino"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqladdenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param lite conexion a base de datos lite para addenda
     * @return arreglo de addenda para formateo de datos
     */
    public ArrayList<Corridaaddenda> getCoraddenda(Connection lite) {
        ArrayList<Corridaaddenda> arr = new ArrayList<>();
        ResultSet rs;
        PreparedStatement st;
        try {
            String sql = "select * from addenda";
            st = lite.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Corridaaddenda cor = new Corridaaddenda();
                cor.setCorrida(rs.getInt("corrida"));
                cor.setIndexi(rs.getInt("indexi"));
                cor.setIndexf(rs.getInt("indexf"));
                cor.setCinicial(rs.getInt("cinicial"));
                cor.setCfinal(rs.getInt("cfinal"));
                arr.add(cor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqladdenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Obtiene los datos ya formateados acerca de la addenda
     *
     * @param rcpt conexion de bd
     * @param f factura a usar
     * @param adenda arreglo de datos para formateo de datos dee la adenda
     * @return
     */
    public ArrayList<Addenda> getAddenda(Connection rcpt, factura f, ArrayList<Corridaaddenda> adenda) {
        ArrayList<Addenda> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String fac = f.getFolio()+"";
            String sql = "select f.factura, numcliente,SUBSTRING(f.pedido,0,LEN(f.pedido)-1) as pedido,dp.corrida, convert(date,f.fecha) as fecha,dp.estilo,"
                    + "dp.precio,c.puntoinicial,c.puntofinal,cp.descripcion as sat,m.descripcion as material,col.descripcion as color,p.producto,\n"
                    + "c15 = case when dp.Corrida =90 THEN SUM(cant1) else '' END,\n"
                    + "c16 = case when dp.Corrida =90 THEN SUM(cant2) else '' END,\n"
                    + "c17 = case when dp.Corrida =90 THEN SUM(cant3) else '' END,\n"
                    + "c18 = case when dp.Corrida =90 THEN SUM(cant4) else '' END,\n"
                    + "c19 = case when dp.corrida=90 then sum(cant5) when dp.corrida=97 then SUM(cant1) else '' END,\n"
                    + "c20 = case when dp.corrida=90 then sum(cant6) when dp.corrida=97 then SUM(cant2) else '' END,\n"
                    + "c21 = case when dp.corrida=91 then sum(cant1) when dp.corrida=97 then SUM(cant3) else '' END,\n"
                    + "c22 = case when dp.corrida=91 then sum(cant2) when dp.corrida=97 then SUM(cant4) else '' END,\n"
                    + "c23 = case when dp.corrida=91 then sum(cant3) when dp.corrida=97 then SUM(cant5) else '' END,\n"
                    + "c24 = case when dp.corrida=91 then sum(cant4) when dp.corrida=97 then SUM(cant6) else '' END,\n"
                    + "c25 = case when dp.corrida=91 then sum(cant5) when dp.corrida=97 then SUM(cant7) else '' END,\n"
                    + "c26 = case when dp.corrida=91 then sum(cant6) when dp.corrida=97 then SUM(cant8) else '' END,\n"
                    + "c27 = case when dp.corrida=91 then sum(cant7) when dp.corrida=97 then SUM(cant9) when dp.corrida=95 then SUM(cant1) else '' END,\n"
                    + "c28 = case when dp.corrida=91 then sum(cant8) when dp.corrida=97 then SUM(cant10) when dp.corrida=95 then SUM(cant2) else '' END,\n"
                    + "c29 = case when dp.corrida=92 then sum(cant1) when dp.corrida=93 then SUM(cant1) when dp.corrida=95 then SUM(cant3) else '' END,\n"
                    + "c30 = case when dp.corrida=92 then sum(cant2) when dp.corrida=93 then SUM(cant2) when dp.corrida=95 then SUM(cant4) else '' END,\n"
                    + "c31 = case when dp.corrida=92 then sum(cant3) when dp.corrida=93 then SUM(cant3) when dp.corrida=95 then SUM(cant5) when dp.corrida=98 then SUM(cant1) else '' END,\n"
                    + "c32 = case when dp.corrida=92 then sum(cant4) when dp.corrida=93 then SUM(cant4) when dp.corrida=95 then SUM(cant6) when dp.corrida=98 then SUM(cant2) else '' END,\n"
                    + "c33 = case when dp.corrida=92 then sum(cant5) when dp.corrida=93 then SUM(cant5) when dp.corrida=95 then SUM(cant7) when dp.corrida=98 then SUM(cant3) else '' END,\n"
                    + "c34 = case when dp.corrida=92 then sum(cant6) when dp.corrida=93 then SUM(cant6) when dp.corrida=95 then SUM(cant8) when dp.corrida=98 then SUM(cant4) else '' END,\n"
                    + "c35 = case when dp.corrida=93 then SUM(cant7) when dp.corrida=95 then SUM(cant9) when dp.corrida=98 then SUM(cant5) when dp.corrida=94 then SUM(cant1) else '' END,\n"
                    + "c36 = case when dp.corrida=93 then SUM(cant8) when dp.corrida=95 then SUM(cant10) when dp.corrida=98 then SUM(cant6) when dp.corrida=94 then SUM(cant2) else '' END,\n"
                    + "c37 = case when dp.corrida=93 then SUM(cant9) when dp.corrida=94 then SUM(cant3) when dp.corrida=98 then SUM(cant7)else '' END,\n"
                    + "c38 = case when dp.corrida=93 then SUM(cant10) when dp.corrida=94 then SUM(cant4) when dp.corrida=98 then SUM(cant8)else '' END,\n"
                    + "c39 = case when dp.corrida=94 then SUM(cant5) when dp.corrida=98 then SUM(cant9) else '' END,\n"
                    + "c40 = case when dp.corrida=94 then SUM(cant6) when dp.corrida=98 then SUM(cant10) else '' END,\n"
                    + "c41 = case when dp.corrida=94 then SUM(cant7) else '' END,\n"
                    + "c42 = case when dp.corrida=94 then SUM(cant8) else '' END,\n"
                    + "c43 = case when dp.corrida=94 then SUM(cant9) else '' END,\n"
                    + "c44 = case when dp.corrida=94 then SUM(cant10) else '' END,\n"
                    + "c45 = case when dp.corrida=94 then SUM(cant11) when dp.corrida=96 then SUM(cant1) else '' END,\n"
                    + "c46 = case when dp.corrida=94 then SUM(cant12) when dp.corrida=96 then SUM(cant2) else '' END,\n"
                    + "c47 = case when dp.corrida=96 then SUM(cant3) else '' END,\n"
                    + "c48 = case when dp.corrida=96 then SUM(cant4) else '' END,\n"
                    + "c49 = case when dp.corrida=96 then SUM(cant5) else '' END,\n"
                    + "c50 = case when dp.corrida=96 then SUM(cant6) else '' END,\n"
                    + "c51 = case when dp.corrida=96 then SUM(cant7) else '' END,\n"
                    + "c52 = case when dp.corrida=96 then SUM(cant8) else '' END\n"
                    + "from facturas f\n"
                    + "join dfacturas dp on f.Factura=dp.Factura\n"
                    + "join corridas c on dp.Corrida=c.Corrida\n"
                    + "join Productos p on dp.Producto=p.Producto\n"
                    + "join ClavesProductos cp on p.Codigo=cp.ClaveProdServ\n"
                    + "join Combinaciones com on p.Combinacion=com.Combinacion\n"
                    + "join materiales m on com.Material1=m.Material\n"
                    + "join colores col on com.Color1=col.Color\n"
                    + "where f.estatus='F' and f.factura=? \n"
                    + "group by f.factura, numcliente,f.pedido,dp.corrida,f.fecha,dp.estilo,dp.precio,c.puntoinicial,c.puntofinal,"
                    + "cp.descripcion,m.descripcion ,col.descripcion,p.producto";
//            System.out.println(sql);
            st = rcpt.prepareStatement(sql);
            st.setString(1, fac);
            rs = st.executeQuery();
            int band = 0;
            int index = 0;
            int col = 0;
            int punto = 0;

            while (rs.next()) {
//                indices de acuerdo a la corrida ej corrida 94, iinicial =20, ifinal=31
                if (band == 0) {
                    for (int i = 0; i < adenda.size(); i++) {
                        int corrida = rs.getInt("corrida");
//                        Busca la corrida y guarda el indice y el punto inicial multiplicado por 10 para tener 3 digitos
                        if (corrida == adenda.get(i).getCorrida()) {
                            index = i;
                            break;
                        }
                    }
                    col = adenda.get(index).getCinicial();
                    punto = rs.getInt("puntoinicial") * 10;
                    band++;
                }
//                Como ej corrida 94, se esta diciendo que i=20 y el limite es 31 que son los indicees de posicion
//                Ademas de que col contiene la el indice de la columna inicial
                for (int i = adenda.get(index).getIndexi(); i < adenda.get(index).getIndexf(); i++) {
                    int columna = rs.getInt("c" + col);
                    if (columna != 0) {
                        Addenda a = new Addenda();
                        String sat = rs.getString("sat");
                        String est = rs.getString("estilo");
                        String mat = rs.getString("material");
                        String co = rs.getString("color");
                        int pi = rs.getInt("puntoinicial");
                        int pf = rs.getInt("puntofinal");
                        a.setPrecio(rs.getDouble("precio"));
                        a.setPunto(punto);
                        a.setCantidad(columna);
                        a.setEstilo(est);
                        a.setFecha(rs.getString("fecha"));
                        a.setPedido(rs.getString("pedido"));
                        a.setDescripcionprod(sat + " " + est + " " + " " + pi + "/" + pf + " " + mat + "-" + co);
                        arr.add(a);
                    }
                    col++;
//                    Al punto se le ira sumando 5 ya que hay puntos medios entre el limite inferior y superior
                    punto += 5;
                }
                band = 0;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqladdenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
