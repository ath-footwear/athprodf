/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DetFichas;
import Modelo.Fichas;
import java.io.IOException;
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
public class sqlficha {

    public boolean Addficha(Connection con, Fichas f) {
        PreparedStatement st = null;
        try {
            String estilo = f.getEstilo();
            String code = f.getCode();
            String nombre = f.getNombre();
            String nombre1 = f.getNombre1();
            String tcalzado = f.getTipo_calzado();
            String fecharea = f.getFecharea();
            String fecharev = f.getFecharev();
            String vobo = f.getReviso_bobo();
            String imagen1 = f.getImagen1();
            String imagen2 = f.getImagen2();
            String imagen3 = f.getImagen3();
            String nimagen1 = f.getNombreimagen1();
            String nimagen2 = f.getNombreimagen2();
            String nimagen3 = f.getNombreimagen3();
            String cons = f.getConstruccion();
            String obs = f.getObservaciones();
            int corrida = f.getId_corrida();
            String estatusok = f.getEstatus_ok();
            String fechaok = f.getFechaaprobado();
            String respok = f.getReviso_bobo();
            int usuario = f.getId_usuario();
            int linea = f.getId_linea();
            int horma = f.getId_horma();
            int colorf = f.getId_color();
            con.setAutoCommit(false);
            String sql = "insert into Ficha_tecnica(estilo,code,nombre,nombre1,"
                    + "tipo_calzado,fecha_rea,reviso_vobo,imagen1,imagen2,"
                    + "imagen3,nombreimagen1,nombreimagen2,nombreimagen3,construccion,observaciones,"
                    + "id_corrida,estatus_aprobado,responsable_aprobado,"
                    + "id_usuario,id_linea,id_horma,id_color,estatus) values('" + estilo + "','" + code + "','"
                    + nombre + "','" + nombre1 + "','" + tcalzado + "','" + fecharea + "','"
                    + vobo + "','" + imagen1 + "','" + imagen2 + "','" + imagen3 + "','" + nimagen1 + "','"
                    + nimagen2 + "','" + nimagen3 + "','" + cons + "','" + obs + "'," + corrida + ",'"
                    + estatusok + "','" + respok + "'," + usuario + "," + linea + "," + horma + "," + colorf + ",'1')";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //consulta de la ultima ficha
            int idficha = 0;
            ResultSet rs;
            st = con.prepareStatement("select top(1) ficha from ficha_tecnica where estatus=1 \n"
                    + "order by ficha desc");
            rs = st.executeQuery();
            while (rs.next()) {
                idficha = rs.getInt("ficha");
            }
            rs.close();
            st.close();
            for (int i = 0; i < f.getArr().size(); i++) {
                int tipo = f.getArr().get(i).getId_tipom();
                int pieza = f.getArr().get(i).getId_pieza();
                int mat = f.getArr().get(i).getId_material();
                int color = f.getArr().get(i).getId_color();
                String pzs = f.getArr().get(i).getPzaxpar();
                float consumo = f.getArr().get(i).getConsumo();
                String observacion = f.getArr().get(i).getObservaciones();
                float total = f.getArr().get(i).getTotal();
                String unidad = f.getArr().get(i).getUnidad();
                sql = "insert into Detficha_Tecnica(ficha,id_tipo,id_pieza,id_material,"
                        + "id_color,pzxpar,consumo,observaciones,total,unidad,estatus)"
                        + " values(" + idficha + "," + tipo + "," + pieza + "," + mat + "," + color + ",'" + pzs + "'," + consumo + ",'" + observacion + "'," + total + ",'" + unidad + "','1')";
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean updateficha(Connection con, Fichas f) {
        PreparedStatement st = null;
        try {

            con.setAutoCommit(false);
            String sql = "update ficha_tecnica set estatus_aprobado='1',fecha_aprobado='"
                    + f.getFechaaprobado() + "',responsable_aprobado='" + f.getDescusuario() + "' where ficha=" + f.getFicha();
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean getficha(Connection con) {
        boolean resp = false;
        try {
            PreparedStatement st;
            ResultSet rs;

            st = con.prepareStatement("select nombre from usuarios where contraseña=''");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public boolean checkficha(Connection con, Fichas f) {
        boolean resp = false;
        try {
            PreparedStatement st;
            ResultSet rs;
            String estilo = f.getEstilo();
            int corrida = f.getId_corrida();
            int linea = f.getId_linea();
            int horma = f.getId_horma();
            int color = f.getId_color();
            st = con.prepareStatement("select estilo,id_corrida,id_linea,id_horma,id_color\n"
                    + "from ficha_tecnica\n"
                    + "where estilo='" + estilo + "' and id_corrida=" + corrida + " and id_linea=" + linea
                    + " and id_horma=" + horma + " and id_color=" + color + "");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public ArrayList<Fichas> getbuscaficha(Connection con, String s) {
        ArrayList<Fichas> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            PreparedStatement st1 = null;
            ResultSet rs1 = null;
            String sql = "select ficha,estilo,c.descripcion as color,l.descripcion as linea, cor.descripcion as corrida, h.descripcion as horma,\n"
                    + "ft.id_color as idcolor, ft.id_linea as idlinea,ft.id_corrida as idcorrida,code,tipo_calzado,fecha_rea,fecha_rev,reviso_vobo,\n"
                    + "imagen1,imagen2,imagen3,construccion,observaciones,estatus_aprobado,fecha_aprobado,responsable_aprobado,ft.id_horma as idhorma\n"
                    + " from ficha_tecnica ft\n"
                    + "join color c on ft.id_color=c.id_color\n"
                    + "join linea l on ft.id_linea=l.id_linea\n"
                    + "join corrida cor on ft.id_corrida=cor.id_corrida\n"
                    + "join Horma h on ft.id_horma=h.id_horma\n"
                    + "where estilo like '%" + s + "%' or c.descripcion like '%" + s + "%' or l.descripcion like '%" + s + "%' or h.descripcion like '%" + s + "%'\n"
                    + "order by l.descripcion";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Fichas f = new Fichas();
                f.setEstilo(rs.getString("estilo"));
                f.setCode(rs.getString("code"));
                f.setFicha(rs.getInt("ficha"));
                f.setDesccolor(rs.getString("color"));
                f.setDesclinea(rs.getString("linea"));
                f.setDescorrida(rs.getString("corrida"));
                f.setDeschorma(rs.getString("horma"));
                f.setId_color(rs.getInt("idcolor"));
                f.setId_linea(rs.getInt("idlinea"));
                f.setId_corrida(rs.getInt("idcorrida"));
                f.setTipo_calzado(rs.getString("tipo_calzado"));
                f.setFecharea(rs.getString("fecha_rea"));
                f.setFecharev(rs.getString("fecha_rev"));
                f.setReviso_bobo(rs.getString("reviso_vobo"));
                f.setImagen1(rs.getString("imagen1"));
                f.setImagen2(rs.getString("imagen2"));
                f.setImagen3(rs.getString("imagen3"));
                f.setConstruccion(rs.getString("construccion"));
                f.setObservaciones(rs.getString("observaciones"));
                f.setEstatus_ok(rs.getString("estatus_aprobado"));
                f.setFechaaprobado(rs.getString("fecha_aprobado"));
                f.setReviso_bobo(rs.getString("responsable_aprobado"));
                f.setId_horma(rs.getInt("idhorma"));

                sql = "select detficha,df.ficha,tp.descripcion as tipo,p.descripcion as pieza,m.descripcion as material,"
                        + "c.descripcion as color, df.id_tipo,df.id_pieza, df.id_material, df.id_color, pzxpar, consumo,"
                        + "observaciones,total,unidad\n"
                        + "from DetFicha_tecnica df join Tipo_material tp on df.id_tipo=tp.id_tipo\n"
                        + "join Piezas p on df.id_pieza=p.id_pieza\n"
                        + "join Material m on df.id_material=m.id_material\n"
                        + "join Color c on df.id_color=c.id_color\n"
                        + "where df.ficha=" + f.getFicha();
                st1 = con.prepareStatement(sql);
                rs1 = st1.executeQuery();
                ArrayList<DetFichas> arrdet = new ArrayList<>();
                while (rs1.next()) {
                    DetFichas df = new DetFichas();
                    df.setDetficha(rs1.getInt("detficha"));
                    df.setFicha(rs1.getInt("ficha"));
                    df.setId_tipom(rs1.getInt("id_tipo"));
                    df.setId_pieza(rs1.getInt("id_pieza"));
                    df.setId_material(rs1.getInt("id_material"));
                    df.setId_color(rs1.getInt("id_color"));
                    df.setPzaxpar(rs1.getString("pzxpar"));
                    df.setConsumo(rs1.getFloat("consumo"));
                    df.setObservaciones(rs1.getString("observaciones"));
                    df.setTotal(rs1.getFloat("total"));
                    df.setUnidad(rs1.getString("unidad"));
                    df.setTipomdesc(rs1.getString("tipo"));
                    df.setPiezadesc(rs1.getString("pieza"));
                    df.setMaterialdesc(rs1.getString("material"));
                    df.setColordesc(rs1.getString("color"));
                    arrdet.add(df);
                }
                f.setArr(arrdet);
                arr.add(f);
            }
            rs.close();
            st.close();
            rs1.close();
            st1.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
