/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fichas;
import Modelo.Materiales;
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
public class sqlmaterial {

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
            Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Obtener todos los materiales
     *
     * @param con conexion
     * @param arr
     * @return
     */
    public ArrayList<Materiales> getallMateriales(Connection con, ArrayList<Materiales> arr) {
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_material,descripcion from Material where estatus='1' order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Materiales m = new Materiales();
                m.setId_material(rs.getInt("id_material"));
                m.setDescripcion(rs.getString("descripcion"));
                arr.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
//TPU

    public ArrayList<Materiales> getallMaterials(Connection con, String mat, String turno) {
        ArrayList<Materiales> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from Materiales "
                    + "where descripcion like '%" + mat + "%' and estatus='1' "
                    + "order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {
                Materiales m = new Materiales();
                m.setId_material(rs.getInt("id_material"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setPrecio(rs.getDouble("precio"));
                m.setCodigo(rs.getString("codigo"));
                m.setUnidad(rs.getString("unidad"));
                m.setCodigosat(rs.getString("codigosat"));
                m.setMoneda(rs.getString("moneda"));
                if (turno.equals("7") || turno.equals("6")) {
                    m.setNoserie(rs.getString("noserie"));
                }
                arr.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean Addmaterial(Connection con, Materiales m) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String mat = m.getDescripcion();
            double precio = m.getPrecio();
            String unidad = m.getUnidad();
            String codigosat = m.getCodigosat();
            int idfam = m.getId_familia();
            String mon = m.getMoneda();
            String sql = "insert into Materiales(descripcion,precio,estatus,unidad,codigosat,id_familia,moneda) "
                    + "values('" + mat + "'," + precio + ",'1','" + unidad + "','" + codigosat + "'," + idfam + ",'" + mon + "')";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean Addmaterialmaq(Connection con, Materiales m) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String mat = m.getDescripcion();
            String tipo = m.getTipo_maquina();
            double precio = m.getPrecio();
            String unidad = m.getUnidad();
            String codigosat = m.getCodigosat();
            int idfam = m.getId_familia();
            String mon = m.getMoneda();
            String nserie = m.getNoserie();
            String i1 = m.getImag1();
            String i2 = m.getImag2();
            String i3 = m.getImag3();
            String sql = "insert into Materiales(descripcion,precio,estatus,unidad,codigosat,"
                    + "id_familia,moneda,modelo,noserie,imag1,imag2,imag3)"
                    + " values('" + tipo + "'," + precio + ",'1','" + unidad + "','"
                    + codigosat + "'," + idfam + ",'" + mon + "','" + mat + "','"
                    + nserie + "','" + i1 + "','" + i2 + "','" + i3 + "')";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public ArrayList<Materiales> getallMaterialsmaq(Connection con, String mat) {
        ArrayList<Materiales> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_material,m.descripcion as descr,precio,unidad,"
                    + "noserie,moneda,f.descripcion as marca,m.estatus, m.modelo as model\n"
                    + "from materiales m\n"
                    + "join familias f on m.id_familia=f.id_familia\n"
                    + "where m.descripcion like '%" + mat + "%' and m.estatus='1' "
                    + "order by m.descripcion";
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Materiales m = new Materiales();
                m.setId_material(rs.getInt("id_material"));
                m.setDescripcion(rs.getString("descr"));
                m.setPrecio(rs.getDouble("precio"));
                m.setUnidad(rs.getString("unidad"));
                m.setNoserie(rs.getString("noserie"));
                m.setMoneda(rs.getString("moneda"));
                m.setMarca(rs.getString("marca"));
                m.setEstatus(rs.getString("estatus"));
                m.setTipo_maquina(rs.getString("model"));
                arr.add(m);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean deletematerial(Connection c, int id) {
        PreparedStatement st;
        try {
            c.setAutoCommit(false);
            String sql = "update materiales set estatus='0' where id_material=?";
            st = c.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean check_nserie(Connection c, Materiales m) {
        boolean flag = false;
        PreparedStatement st;
        ResultSet rs;
        try {
            String sql = "select id_material\n"
                    + "from materiales\n"
                    + "where modelo=? and noserie=?";
            st = c.prepareStatement(sql);
            st.setString(1, m.getDescripcion());
            st.setString(2, m.getNoserie());
            rs = st.executeQuery();
            while (rs.next()) {
                flag = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlmaterial.class.getName()).log(Level.SEVERE, null, ex);
            flag=true;
        }
        return flag;
    }
}
