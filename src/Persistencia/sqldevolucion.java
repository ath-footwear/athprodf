/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqldevolucion {

    public ArrayList<Motivosdev> getallmomtivos(Connection c) {
        ArrayList<Motivosdev> arr = new ArrayList<>();
        try {

            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement("select * from motivodev where estatus='1' order by descripcion desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Motivosdev m = new Motivosdev();
                m.setIdmotivo(rs.getInt("id_motivo"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setTipodev(rs.getString("tipodev"));
                m.setStock(rs.getString("afectastock"));
                arr.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Verifica si la factura ya tiene devolucion
     *
     * @param c
     * @param serie
     * @param idped
     * @return
     */
    public int verificadevs(Connection c, String serie, int idped) {
        int rows = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select p.nombre \n"
                    + "from pedido p\n"
                    + "join Devoluciones d on d.id_pedido=p.id_pedido join \n"
                    + "documento doc on p.id_pedido=doc.pedidos\n"
                    + "where p.serie=? and d.estatus='1' and id_documento=?";
            st = c.prepareStatement(sql);
            st.setString(1, serie);
            st.setInt(2, idped);
            rs = st.executeQuery();
            while (rs.next()) {
                rows++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    public int verificadevsped(Connection c, String serie, int idped) {
        int rows = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select p.nombre \n"
                    + "from pedido p\n"
                    + "join Devoluciones d on d.id_pedido=p.id_pedido\n"
                    + "where p.serie=? and d.estatus='1' and p.id_pedido=?";
            st = c.prepareStatement(sql);
            st.setString(1, serie);
            st.setInt(2, idped);
            rs = st.executeQuery();
            while (rs.next()) {
                rows++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    /**
     * Obtener registros para la devolucion
     *
     * @param c
     * @param id
     * @return
     */
    public ArrayList<Ddevolucion> getpedidowithpedido(Connection c, int id, String bdname) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select p.id_pedido,id_dpedido,pedido,p.fecha,id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    //                    + "join [192.168.90.1\\DATOS620].RACobranzaTpu.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS\n"
                    //                    + "join RACobranzaTpu.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS\n"
                    + "" + bdname + "\n"
                    + "where serie='B' and p.id_pedido=" + id;
//            System.out.println("dev ped " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Obtiene los datos de un detalleado de devolucion, usado para cancelar una
     * devolucion
     *
     * @param c
     * @param id
     * @return
     */
    public ArrayList<Ddevolucion> getdevolucion(Connection c, int id) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select d.id_devolucion,k.id_material,k.dureza,k.renglon,k.cantidad,k.precio,k.id_kardex,id_pedimento,k.serie\n"
                    + "from devoluciones d\n"
                    + "join kardex k on k.id_kardex=d.id_kardex\n"
                    + "where d.id_devolucion=? and d.estatus='1'";
//            System.out.println("dev id " + sql);
            st = c.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_devolucion(id);
                d.setRenglon(rs.getInt("renglon"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setPrecio(rs.getDouble("precio"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setSerie(rs.getString("serie"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Devolucion> getalldevs(Connection c, String serie) {
        ArrayList<Devolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(100) id_devolucion,d.nombre,d.fecha,d.serie,p.total,pedido,d.estatus,p.estatus,d.id_kardex,"
                    + "m.descripcion as motivo,d.descripcion as descu,ISNULL(doc.folio,'') as fac\n"
                    + "from devoluciones d\n"
                    + "join pedido p on p.id_pedido=d.id_pedido\n"
                    + "join motivodev m on d.id_motivo=m.id_motivo\n"
                    + "left join documento doc on doc.pedidos=p.id_pedido\n"
                    + "where d.serie=? \n"
                    + "order by id_devolucion desc";
//            System.out.println("devs " + sql);
            st = c.prepareStatement(sql);
            st.setString(1, serie);
            rs = st.executeQuery();
            while (rs.next()) {
                Devolucion d = new Devolucion();
                d.setId_dev(rs.getInt("id_devolucion"));
                d.setNombre(rs.getString("nombre"));
                d.setFecha(rs.getString("fecha"));
                d.setSerie(rs.getString("serie"));
                d.setTotal(rs.getDouble("total"));
                d.setNpedido(rs.getString("pedido"));
                d.setEstatus(rs.getString("estatus"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setNmotivo(rs.getString("motivo"));
                d.setDesc(rs.getString("descu"));
                d.setFoliofac(rs.getString("fac"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidowithpedidofac(Connection c, int id) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct p.id_pedido,id_dpedido,p.pedido,p.fecha,id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,\n"
                    + "dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento,d.id_documento\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join Documento d on d.pedidos=p.id_pedido\n"
                    + "join ACobranzatpu.dbo.Cargo c on d.folio=c.referencia\n"
                    + "where p.serie='A' and d.serie='FAC' and id_documento=?";
//            System.out.println("dev ped " + sql);
            st = c.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setId_documento(rs.getInt("id_documento"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidocancel(Connection c, int id, String serie, String bdcob) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct p.id_pedido,dp.id_dpedido,p.pedido,p.fecha,p.id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,\n"
                    + "dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento,d.id_documento,id_devolucion\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join Documento d on d.pedidos=p.id_pedido\n"
                    + "join ACobranzatpu.dbo.Cargo c on d.folio=c.referencia\n"
                    + "join devoluciones dev on p.id_pedido=dev.id_pedido \n"
                    + "where p.serie=? and d.serie='FAC' and dev.estatus='1' and id_documento=?";
//            System.out.println("dev ped " + sql);
            st = c.prepareStatement(sql);
            st.setString(1, serie);
            st.setInt(2, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setId_documento(rs.getInt("id_documento"));
                d.setId_devolucion(rs.getInt("id_devolucion"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidocancelrem(Connection c, int id, String serie, String bdcob) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct p.id_pedido,dp.id_dpedido,p.pedido,p.fecha,p.id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,\n"
                    + "dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento,dev.id_devolucion\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join " + bdcob + "\n"
                    + "join devoluciones dev on p.id_pedido=dev.id_pedido\n"
                    + "where p.serie=? and dev.estatus='1' and p.id_pedido=?";
//            System.out.println("dev ped " + sql);
            st = c.prepareStatement(sql);
            st.setString(1, serie);
            st.setInt(2, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setId_devolucion(rs.getInt("id_devolucion"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidocancelsindev(Connection c, int id, String serie, String bdcob) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct p.id_pedido,dp.id_dpedido,p.pedido,p.fecha,p.id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,\n"
                    + "dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento, dpp.cantidadrestante\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join " + bdcob + "\n"
                    + "where p.serie='" + serie + "' and p.id_pedido=" + id;
            System.out.println("sin dev ped " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setCantrestante(rs.getDouble("cantidadrestante"));
                d.setId_devolucion(0);
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidocancelsindevfac(Connection c, int id, String serie, String bdcob) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct p.id_pedido,dp.id_dpedido,p.pedido,p.fecha,p.id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,\n"
                    + "dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento,doc.id_documento\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join documento doc on doc.pedidos=p.id_pedido\n"
                    + "join " + bdcob + "\n"
                    + "where p.serie='" + serie + "' and doc.id_documento=" + id;
//            System.out.println("sin dev ped " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                d.setId_devolucion(0);
                d.setId_documento(id);
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean newdevolucion(Connection c, Devolucion d, Connection cob) {
        String sql;
        try {
            c.setAutoCommit(false);
            cob.setAutoCommit(false);
            PreparedStatement st;
            ResultSet rs;
            int respd = 0;
            int cliente = d.getId_cliente();
            int idped = d.getId_pedido();
            int cuenta = d.getId_concepto();
            int kardex = d.getId_kardex();
            int kardexnuevo = d.getId_kardexnuevo();
            int motivo = d.getId_motivo();
            int cargo = d.getId_cargoenc();
            String nombre = d.getNombre();
            String fecha = d.getFecha();
            String obs = d.getDesc();
            String serie = d.getSerie();
            String usuario = d.getUsuario();
            String stock = d.getStock();
            sql = "insert into devoluciones(id_cliente,id_pedido,id_concepto,id_kardex,id_motivo,nombre,total,fecha,descripcion,serie,estatus) "
                    + "values(" + cliente + "," + idped + "," + cuenta + "," + kardexnuevo + "," + motivo + ",'" + nombre + "',0,'" + fecha + "','" + obs + "','" + serie + "','1')";
//            System.out.println("dev " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
//            sql = "update pedido set estatus='0' where id_pedido=" + idped;
////            System.out.println("ped dev " + sql);
//            st = c.prepareStatement(sql);
//            st.executeUpdate();
//            sql = "update cargo set saldo=0, saldomx=0,estatus='0' where id_cargo=" + cargo;
////            System.out.println("cargo dev " + sql);
//            st = cob.prepareStatement(sql);
//            st.executeUpdate();
            sql = "select max(id_devolucion) as id from devoluciones";
//            System.out.println("ddevolucion " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                respd = rs.getInt("id");
            }
            for (int i = 0; i < d.getArr().size(); i++) {
                String dur = d.getArr().get(i).getDureza();
                String desc = d.getArr().get(i).getDescripcion();
                int idmat = d.getArr().get(i).getIdmaterial();
                int ren = d.getArr().get(i).getRenglon();
                double precio = d.getArr().get(i).getPrecio();
                double cant = d.getArr().get(i).getCantidad();
                double imp = d.getArr().get(i).getImporte();
                int dped = d.getArr().get(i).getId_dpedimento();
                int idpedimento = d.getArr().get(i).getId_pedimento();

                sql = "insert into ddevoluciones(id_devolucion,id_material,dureza,renglon,precio,cantidad,importe,descripcion,estatus) "
                        + "values(" + respd + "," + idmat + ",'" + dur + "'," + ren + "," + precio + "," + cant + "," + imp + ",'" + desc + "','1')";
//                System.out.println("d dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();

                if (stock.equals("1")) {
                    sql = "update dpedimentos set cantidadrestante=cantidadrestante+" + cant + " where id_dpedimento=" + dped;
//                    System.out.println("d dev " + sql);
                    st = c.prepareStatement(sql);
                    st.executeUpdate();
                }

                sql = "insert into kardex "
                        + "values(" + kardexnuevo + "," + cuenta + "," + cliente + "," + idmat + ",0,1," + idpedimento + ",'" + usuario + "','"
                        + fecha + "'," + precio + "," + precio + "," + cant + "," + ren + ",'" + serie + "','1','1','" + dur + "','')";
//                System.out.println("kar dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            cob.commit();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cob.commit();
                c.rollback();
                JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    /**
     * Para la cancelacion es nececsario contar con las cantidades del pedido
     * original y las cantidades de la devolucion
     *
     * @param c
     * @param cob
     * @param d Conjunto de datos con el pedido original
     * @param arrd Datos con la descricpion y valores de la devolucion
     * @return
     */
    public boolean newcancelacion(Connection c, Connection cob, Devolucion d, ArrayList<Ddevolucion> arrd) {
        try {
            c.setAutoCommit(false);
            cob.setAutoCommit(false);
            PreparedStatement st;
            int iddev = d.getId_dev();
            int idped = d.getId_pedido();
            int iddoc = d.getArr().get(0).getId_documento();
            int idcargo = d.getId_cargoenc();
            String usuario = d.getUsuario();
            int c1 = d.getCuenta1();
            int c2 = d.getCuenta2();
            int cliente = d.getId_cliente();
            String fecha = d.getFecha();
            int k1 = d.getId_kardex();
            int k2 = d.getId_kardexnuevo();
            String serie = d.getSerie();

            String sql = "update cargo set estatus='0',saldo=0,saldomx=0 where id_cargo=" + idcargo;
//            System.out.println("cancel cargo" + sql);
            st = cob.prepareStatement(sql);
            st.executeUpdate();
            sql = "update pedido set estatus='0' where id_pedido=" + idped;
//            System.out.println("cancel dped" + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            if (!arrd.isEmpty()) {
                sql = "update devoluciones set estatus='0' where id_devolucion=" + iddev;
//                System.out.println("cancel dev" + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            if (serie.equals("A")) {
                sql = "update documento set estatus='0' where id_documento=" + iddoc;
//                System.out.println("cancel doc" + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
//          Saca del pedimento la cancelacion de la devolucion
            int ren = 1;
            for (Ddevolucion arr : arrd) {
                String dur = arr.getDureza();
                int idmat = arr.getIdmaterial();
//                int ren = arr.getRenglon();
                double precio = arr.getPrecio();
                double cant = arr.getCantidad();
                double cantrdev = arr.getCantidadrestdev();
                int idpedimento = arr.getId_pedimento();
                sql = "insert into kardex "
                        + "values(" + k1 + "," + c1 + "," + cliente + "," + idmat + ",0,1," + idpedimento + ",'" + usuario + "','"
                        + fecha + "'," + precio + "," + precio + "," + cant + "," + ren + ",'" + serie + "','1','1','" + dur + "','DEV " + iddev + "')";
//                System.out.println("kar dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                sql = "update dpedimentos set cantidadrestante=" + cantrdev
                        + "where id_pedimento=" + idpedimento + " and id_material=" + idmat + " and dureza='" + dur + "'";
//                System.out.println("dped dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                ren++;
            }
            ren = 1;
//          Regresa todo el pedido completo al stock
            for (Ddevolucion arr : d.getArr()) {
                String dur = arr.getDureza();
                int idmat = arr.getIdmaterial();
//                int ren = arr.getRenglon();
                double precio = arr.getPrecio();
                double cant = arr.getCantidad();
                int dped = arr.getId_dpedimento();
                double cantr = arr.getCantrestante();
                int idpedimento = arr.getId_pedimento();
                String pedido = arr.getPedido();
                sql = "insert into kardex "
                        + "values(" + k2 + "," + c2 + "," + cliente + "," + idmat + ",0,1," + idpedimento + ",'" + usuario + "','"
                        + fecha + "'," + precio + "," + precio + "," + cant + "," + ren + ",'" + serie + "','1','1','" + dur + "','PED " + pedido + "')";
//                System.out.println("kar dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                sql = "update dpedimentos set cantidadrestante=" + cantr
                        + "where id_dpedimento=" + dped;
//                System.out.println("dped dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
                ren++;
            }
            cob.commit();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cob.rollback();
                c.rollback();
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
