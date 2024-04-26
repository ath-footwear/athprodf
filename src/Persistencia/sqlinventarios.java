/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Formateodedatos;
import Modelo.Inventario;
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
public class sqlinventarios {

    /**
     * Obtiene inventarios de sqlite agrupados por id_pedimento
     *
     * @param c
     * @return
     */
    public ArrayList<Inventario> getallinventarios(Connection c) {
        ArrayList<Inventario> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement("select id_pedimento from inventariado group by id_pedimento");
            rs = st.executeQuery();
            while (rs.next()) {
                Inventario i = new Inventario();
                i.setId_pedimento(rs.getInt("id_pedimento"));
//                i.setId_dpedimento(rs.getInt("id_dpedimento"));
//                i.setId_material(rs.getInt("id_material"));
//                i.setDureza(rs.getString("dureza"));
//                i.setNombre(rs.getString("nombremat"));
//                i.setCantidad(rs.getDouble("cantidadrestante"));
                arr.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean nuevoregistroinv(Connection c, ArrayList<Inventario> arr) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            for (Inventario arr1 : arr) {
                int ped = arr1.getId_pedimento();
                int dped = arr1.getId_dpedimento();
                int m = arr1.getId_material();
                String d = arr1.getDureza();
                String n = arr1.getNombre();
                double cant = arr1.getCantidad();
                String sql = "insert into inventariado(id_pedimento,id_dpedimento,id_material,dureza,nombremat,cantidadrestante)"
                        + "values (" + ped + "," + dped + "," + m + ",'" + d + "','" + n + "'," + cant + ")";
//                System.out.println(" " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }

            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<Inventario> getallinventariostocheck(Connection c) {
        ArrayList<Inventario> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement("select * from inventariado order by id_pedimento");
            rs = st.executeQuery();
            while (rs.next()) {
                Inventario i = new Inventario();
                i.setId_pedimento(rs.getInt("id_pedimento"));
                i.setId_dpedimento(rs.getInt("id_dpedimento"));
                i.setId_material(rs.getInt("id_material"));
                i.setDureza(rs.getString("dureza"));
                i.setNombre(rs.getString("nombremat"));
                i.setCantidad(rs.getDouble("cantidadrestante"));
                arr.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean deletepedimento(Connection c, int id) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            st = c.prepareStatement("delete from inventariado where id_pedimento=" + id);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean nuevocierre(Connection c, Connection lite, ArrayList<Inventario> arr, int mes, int year) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            lite.setAutoCommit(false);
            String sql;
            int nuevomes;
            int nuevoyear;
            for (Inventario arr1 : arr) {
                int ped = arr1.getId_pedimento();
                int dped = arr1.getId_dpedimento();
                int mat = arr1.getId_material();
                String nombre = arr1.getNombre();
                String dureza = arr1.getDureza();
                double cant = arr1.getCantidad();
//                inserta registros en la bd de sqlserver para mantener un historial
                sql = "insert into inventariado(id_pedimento,id_dpedimento,id_material,dureza,nombremat,cantidadrestante,mes,years) "
                        + "values(" + ped + "," + dped + "," + mat + ",'" + dureza + "','" + nombre + "'," + cant + "," + mes + "," + year + ")";
//                System.out.println("inserta r inv " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
//                Actualiza el stock de inventarios por renglon de pedimento
                sql = "update dpedimentos set cantinv=" + cant + " where id_dpedimento=" + dped;
//                System.out.println("actializa inv x reg " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            if (mes == 12) {
                nuevomes = 1;
                nuevoyear = year + 1;
            } else {
                nuevomes = mes + 1;
                nuevoyear = year;
            }
//            Actualiza el mes y año  de la base de datos
            sql = "update controlinventarios set mes=" + nuevomes + ", years=" + nuevoyear;
//            System.out.println("controlinv " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
//Borra todos los registros de la bd de sqlite que es donde se almacena temporalmente el inventario
            sql = "delete from inventariado";
//            System.out.println("deelete inv usuario " + sql);
            st = lite.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            lite.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                lite.rollback();
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean ejecutarespcierre(Connection c, int mes, int year, String turno) {
        try {
//            Respaldo de Bd
            String sql;
            PreparedStatement st;
            c.setAutoCommit(false);
            Formateodedatos f = new Formateodedatos();
//            Se formatean los datos de el mes y el año para el guardado del archivo
            String mres = f.formateamesrespaldo(mes);
            String yres = f.formateayearrespaldo(String.valueOf(year));
            //Se trae el nombre integro de la bd con respecto al turno y
            //El nombre que tendra el archivo
            String bd=f.getbdto_respinv_orig(turno,"A");
            sql = "BACKUP DATABASE ["+bd+"]\n"
                    + "TO  DISK = N'C:\\red\\sistemas\\Respaldos\\res"+bd+"" + mres + "" + yres + ".bak'\n"
                    + "WITH CHECKSUM;";
//            System.out.println("respaldo " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<Inventario> getInventarioPasado(Connection c, int mes, int year) {
        ArrayList<Inventario> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select mes,years\n"
                    + "from inventariado\n"
                    + "group by mes,years";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Inventario i = new Inventario();
                i.setMes(rs.getInt("mes"));
                i.setYears(rs.getInt("years"));
                arr.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public void updatecantin_inv(Connection c, Inventario inv){
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            double cant=inv.getCantidadpedimento();
            double dif=inv.getDiferencias();
            int ped=inv.getId_dpedimento();
            String ref= inv.getReferencia();
            String sql="update inventariado set cantidadsistema="+cant+",diferencia="+dif+", referencia='"+ref+"' where id_dpedimento="+ped;
////            System.out.println(sql);
            st=c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlinventarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
