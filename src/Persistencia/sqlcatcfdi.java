/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Ciudades;
import Modelo.Claveprov;
import Modelo.Embarques;
import Modelo.Estados;
import Modelo.Formadepago;
import Modelo.Paises;
import Modelo.Tipoclientes;
import Modelo.Unidades;
import Modelo.Zonas;
import Modelo.metodopago;
import Modelo.relacion;
import Modelo.usocfdi;
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
public class sqlcatcfdi {

    public ArrayList<Formadepago> getFormadepago(Connection con) {//sqllite
        ArrayList<Formadepago> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from formadepago");
            rs = st.executeQuery();
            while (rs.next()) {
                Formadepago f = new Formadepago();
                f.setFormapago(rs.getString("forma"));
                f.setConcepto(rs.getString("concepto"));
                f.setDescripcion(rs.getString("descripcion"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<metodopago> getmetodopago(Connection con) {//sqllite
        ArrayList<metodopago> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from metodopago");
            rs = st.executeQuery();
            while (rs.next()) {
                metodopago m = new metodopago();
                m.setMetodopago(rs.getString("metodopago"));
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

    public ArrayList<usocfdi> getusocfdi(Connection con) {//sqllite
        ArrayList<usocfdi> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from usocfdi");
            rs = st.executeQuery();
            while (rs.next()) {
                usocfdi u = new usocfdi();
                u.setusocfdi(rs.getString("usocfdi"));
                u.setDescripcion(rs.getString("descripcion"));
                arr.add(u);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<relacion> getrelacion(Connection con) {//sqllite
        ArrayList<relacion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from Relacioncfdi order by tiporelacion");
            rs = st.executeQuery();
            while (rs.next()) {
                relacion r = new relacion();
                r.setRelacion(rs.getString("tiporelacion"));
                r.setConcepto(rs.getString("concepto"));
                arr.add(r);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
//-------------------------------------- fin sqlite

    public ArrayList<Paises> getPaises(Connection con) {//sqlserver
        ArrayList<Paises> arr = new ArrayList<>();
        ArrayList<Estados> arre;
        ArrayList<Ciudades> arrc;
        try {
            PreparedStatement st, st1, st2;
            ResultSet rs, rs1, rs2;
            st = con.prepareStatement("select * from Paises\n"
                    + "order by descripcion");
            rs = st.executeQuery();
            while (rs.next()) {// Paises
                Paises p = new Paises();
                p.setId_pais(rs.getInt("cvepais"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setDescorta(rs.getString("descorta"));
                //estados
                st1 = con.prepareStatement("select * from Estados where cvepais=" + p.getId_pais() + " \n"
                        + "order by descripcion");
                rs1 = st1.executeQuery();
                arre = new ArrayList<>();
                while (rs1.next()) {// Estados
                    Estados e = new Estados();
                    e.setId_estado(rs1.getInt("cveEstado"));
                    e.setDescripcion(rs1.getString("descripcion"));
                    e.setId_pais(rs1.getInt("cvepais"));
                    // ciudades
                    st2 = con.prepareStatement("select * from Ciudades where cveestado=" + e.getId_estado() + " \n"
                            + "order by descripcion");
                    rs2 = st2.executeQuery();
                    arrc = new ArrayList<>();
                    while (rs2.next()) {// Ciudades
                        Ciudades ci = new Ciudades();
                        ci.setId_ciudad(rs2.getInt("cveciudad"));
                        ci.setDescripcion(rs2.getString("descripcion"));
                        ci.setId_estado(rs2.getInt("cveestado"));
                        arrc.add(ci);
                    }
                    e.setArrciudades(arrc);
                    arre.add(e);
                }
                p.setArrestados(arre);
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Zonas> getZonas(Connection con) {//zonas
        ArrayList<Zonas> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from zonas order by CveZona");
            rs = st.executeQuery();
            while (rs.next()) {
                Zonas z = new Zonas();
                z.setZona(rs.getInt("cvezona"));
                z.setDescripcion(rs.getString("descripcion"));
                z.setDescorta(rs.getString("descorta"));
                arr.add(z);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Embarques> getEmbarques(Connection con) {//zonas
        ArrayList<Embarques> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from embarque order by Cveembarque");
            rs = st.executeQuery();
            while (rs.next()) {
                Embarques e = new Embarques();
                e.setIdzona(rs.getInt("cveEmbarque"));
                e.setDescripcion(rs.getString("Descripcion"));
                e.setDescorta(rs.getString("DesCorta"));
                arr.add(e);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Tipoclientes> getTipoclientes(Connection con) {//zonas
        ArrayList<Tipoclientes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from tipocliente order by CveTipoCliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Tipoclientes t = new Tipoclientes();
                t.setIdtipocliente(rs.getInt("cvetipocliente"));
                t.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Tipoclientes> getAgentes(Connection con) {//zonas
        ArrayList<Tipoclientes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from tipocliente order by CveTipoCliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Tipoclientes t = new Tipoclientes();
                t.setIdtipocliente(rs.getInt("cvetipocliente"));
                t.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Tipoclientes> getMarcas(Connection con) {//zonas
        ArrayList<Tipoclientes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from tipocliente order by CveTipoCliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Tipoclientes t = new Tipoclientes();
                t.setIdtipocliente(rs.getInt("cvetipocliente"));
                t.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con Conexion sqlite de cfdi
     * @param clave Clave de clave de producto del sat
     * @return
     */
    public boolean getClaves(Connection con, String clave) {//sqllite
        boolean resp = false;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from Claveprods where clave='" + clave + "'";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
//                System.out.println(rs.getString("descripcion"));
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            resp = false;
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con Conexion sqlite de cfdi
     * @param clave Clave de unidad del sat
     * @return
     */
    public boolean getunidades(Connection con, String clave) {//sqllite
        boolean resp = false;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from Unidad where claveunidad='" + clave + "'";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
//                System.out.println(rs.getString("unidad"));
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            resp = false;
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con sqlite conexion
     * @param clave Unidad a buscar
     * @return Descripcion de la unidad
     */
    public String getDescunidad(Connection con, String clave) {//sqllite
        String resp = "";
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from Unidad where claveunidad='" + clave + "'";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
////                System.out.println(rs.getString("unidad"));
                resp = rs.getString("unidad");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param regimen
     * @param uso
     * @return
     */
    public String getregimenxuso(Connection con, String regimen, String uso) {//sqllite
        String resp = "";
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select usocfdi from regimenxuso\n"
                    + "where usocfdi='" + uso + "' and regimen like '%" + regimen + "%'";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getString("usocfdi");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con
     * @return
     */
    public ArrayList<Unidades> getunidades(Connection con) {//sqllite
        ArrayList<Unidades> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from Unidad order by unidad";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Unidades u = new Unidades();
                u.setClave(rs.getString("claveunidad"));
                u.setDescripcion(rs.getString("unidad"));
                arr.add(u);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con
     * @return
     */
    public ArrayList<Claveprov> getclavesprods(Connection con) {//sqllite
        ArrayList<Claveprov> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from Claveprods order by clave";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Claveprov u = new Claveprov();
                u.setClaveprod(rs.getString("clave"));
                u.setDescripcion(rs.getString("descripcion"));
                arr.add(u);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * 
     * @param con
     * @param n palabra a buscar en la bd, se utiliza like
     * @return 
     */
    public ArrayList<Claveprov> getclavesprods(Connection con, String n) {//sqllite
        ArrayList<Claveprov> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select clave,descripcion from Claveprods\n"
                    + "where clave like '%" + n + "%' or descripcion like '%" + n + "%'\n"
                    + "order by clave ";
////            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Claveprov u = new Claveprov();
                u.setClaveprod(rs.getString("clave"));
                u.setDescripcion(rs.getString("descripcion"));
                arr.add(u);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
