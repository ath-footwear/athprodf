/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agentes;
import Modelo.Cliente;
import java.sql.CallableStatement;
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
 * @author GATEWAY1-Michel araujo
 */
public class sqlclientes {

    public ArrayList<Cliente> getClientes(Connection con) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
//            String sql="select * from clientes \n"
//                    + "where ISNULL(nombre40,'')!=''\n"
//                    + "order by nombre40";
            String sql = "select numcliente,nombre40,c.rfc,calle,colonia,c.cp,fax,agente1,plazo,CveCanal\n"
                    + "from clientes c\n"
                    + "join Agentes a on c.Agente1=a.CveAgente\n"
                    + "where ISNULL(nombre40,'')!=''\n"
                    + "order by nombre40";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                Agentes a = new Agentes();
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setAgente(rs.getInt("agente1"));
                c.setPlazo(rs.getInt("Plazo"));
                a.setIdcanal(rs.getInt("cvecanal"));
                c.setAg(a);
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getClientestpu(Connection con) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cliente,c.nombre as cliente,rfc,cp,calle,"
                    + "usocfdi,regimen,c.id_agente as agente,a.canal,c.plazo,credito "
                    + "from cliente c\n"
                    + "join Agente a on  c.id_agente=a.id_agente\n"
                    + "where c.estatus='1'\n"
                    + "order by c.nombre";
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                Agentes ag = new Agentes();
                c.setCvecliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("cliente"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setCalle(rs.getString("calle"));
                c.setUsocfdi(rs.getString("usocfdi"));
                c.setRegimen(rs.getString("regimen"));
                ag.setIdagente(rs.getInt("agente"));
                ag.setIdcanal(rs.getInt("canal"));
                c.setPlazo(rs.getInt("plazo"));
                c.setCredito(rs.getDouble("credito"));
                c.setAg(ag);
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getClientestpuall(Connection cob, String cli) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cliente, id_agente, nombre, rfc, cp, razonsocial, "
                    + "usocfdi, calle, colonia, pais, Estado, regimen, estatus, ciudad,"
                    + "correo,cuenta,telefono,plazo,credito \n"
                    + "from cliente c\n"
                    + "where nombre like ? \n"
                    + "order by id_cliente desc";
            st = cob.prepareStatement(sql);
            st.setString(1, "%" + cli + "%");
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCvecliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setCalle(rs.getString("calle"));
                c.setUsocfdi(rs.getString("usocfdi"));
                c.setRegimen(rs.getString("regimen"));
                c.setColonia(rs.getString("colonia"));
                c.setPais(rs.getString("pais"));
                c.setEstado(rs.getString("estado"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstatus(rs.getString("estatus"));
                c.setCorreo(rs.getString("correo"));
                c.setCuenta(rs.getString("cuenta"));
                c.setTelefono(rs.getString("telefono"));
                c.setAgente(rs.getInt("id_agente"));
                c.setPlazo(rs.getInt("plazo"));
                c.setCredito(rs.getDouble("credito"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public Cliente getClientes(Connection con, int cli) {//cobranza
        Cliente c = new Cliente();
        try {
            CallableStatement st;
            st = con.prepareCall("{call spclonacliente(?)}");
            st.setInt(1, cli);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre40"));
                c.setAgente(rs.getInt("agente1"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setUsocfdi(rs.getString("paginaweb"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setRegimen(rs.getString("fax"));
                c.setNombreagente(rs.getString("nombre"));
                c.setCanal(rs.getInt("CveCanal"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public Cliente getCliente(Connection con, int idcliente) {//cobranza
        Cliente c = new Cliente();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from clientes where numcliente=?");
            st.setInt(1, idcliente);
            rs = st.executeQuery();
            while (rs.next()) {
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public boolean importacliente(Connection c, Cliente cli) {
        int ag = 0;
        try {
            c.setAutoCommit(false);
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from Agente where id_agente=" + cli.getAgente();
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ag = rs.getInt("id_agente");
            }
            if (ag == 0) {
                sql = "insert into Agente(id_agente,nombre,canal,comision,estatus) "
                        + "values(" + cli.getAgente() + ",'" + cli.getNombreagente() + "'," + cli.getCanal() + ",0,'1')";
//                System.out.println(sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            sql = "insert into Cliente(id_cliente,id_agente,nombre,rfc,cp,razonsocial,usocfdi,"
                    + "calle,colonia,pais,estado,regimen,estatus,ciudad,plazo, credito) "
                    + "values(" + cli.getCvecliente() + "," + cli.getAgente() + ",'" + cli.getNombre() + "','" + cli.getRfc() + "','"
                    + cli.getCp() + "','" + cli.getNombre() + "','" + cli.getUsocfdi() + "','" + cli.getCalle() + "','" + cli.getColonia() + "','"
                    + cli.getPais() + "','" + cli.getEstado() + "','" + cli.getRegimen() + "','1','" + cli.getCiudad() + "',30,0)";
//            System.out.println(sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean modcliente(Connection cpt, Cliente c) {
        try {
            cpt.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update cliente set nombre=?,rfc=?,cp=?,usocfdi=?,calle=?,colonia=?,pais=?,"
                    + "estado=?,regimen=?,ciudad=?,correo=?,cuenta=?,telefono=?, id_agente=?, plazo=?,"
                    + "credito=? "
                    + "where id_cliente=?";
            st = cpt.prepareStatement(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getRfc());
            st.setString(3, c.getCp());
            st.setString(4, c.getUsocfdi());
            st.setString(5, c.getCalle());
            st.setString(6, c.getColonia());
            st.setString(7, c.getPais());
            st.setString(8, c.getEstado());
            st.setString(9, c.getRegimen());
            st.setString(10, c.getCiudad());
            st.setString(11, c.getCorreo());
            st.setString(12, c.getCuenta());
            st.setString(13, c.getTelefono());
            st.setInt(14, c.getAgente());
            st.setInt(15, c.getPlazo());
            st.setDouble(16, c.getCredito());
            st.setInt(17, c.getCvecliente());
            st.executeUpdate();
//            System.out.println("mod cliente " + i);
            cpt.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public int maxcliente(Connection cob) {
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select max(id_cliente) as cliente from cliente";
            st = cob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("cliente");
            }
            resp++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public boolean nuevocliente(Connection cpt, Cliente c) {
        try {
            PreparedStatement st;
            String sql = "insert into cliente(id_cliente,id_agente,nombre,rfc,cp,razonsocial,"
                    + "usocfdi,calle,colonia,pais,estado,regimen,estatus,ciudad,"
                    + "correo,cuenta,telefono, plazo, credito) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,'1',?,?,?,?,?,?)";
            cpt.setAutoCommit(false);
            st = cpt.prepareStatement(sql);
            st.setInt(1, c.getCvecliente());
            st.setInt(2, c.getAgente());
            st.setString(3, c.getNombre());
            st.setString(4, c.getRfc());
            st.setString(5, c.getCp());
            st.setString(6, c.getNombre());
            st.setString(7, c.getUsocfdi());
            st.setString(8, c.getCalle());
            st.setString(9, c.getColonia());
            st.setString(10, c.getPais());
            st.setString(11, c.getEstado());
            st.setString(12, c.getRegimen());
            st.setString(13, c.getCiudad());
            st.setString(14, c.getCorreo());
            st.setString(15, "");
            st.setString(16, c.getTelefono());
            st.setInt(17, c.getPlazo());
            st.setDouble(18, c.getCredito());
            st.executeUpdate();
            cpt.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                JOptionPane.showMessageDialog(null, "Error al agregar cliente llama a sistemas, " + ex.getMessage());
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean exist_cliente(Connection con, Cliente c) {//cobranza
        boolean flag = false;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select id_cliente\n"
                    + "from cliente\n"
                    + "where id_cliente=?");
            st.setInt(1, c.getCvecliente());
            rs = st.executeQuery();
            while (rs.next()) {
                flag = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            flag = false;
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public Cliente getClientetpu(Connection con, int idcliente) {//cobranza
        Cliente c = new Cliente();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select nombre,rfc,cp,regimen from cliente where id_cliente=?");
            st.setInt(1, idcliente);
            rs = st.executeQuery();
            while (rs.next()) {
                c.setCvecliente(idcliente);
                c.setNombre(rs.getString("nombre"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("regimen"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public ArrayList<Cliente> getfoliotopagotpu_Clientes(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct cli.id_cliente,cli.nombre\n"
                    + "from " + bd + ".dbo.cargo c\n"
                    + "join " + bd + ".dbo.cliente cli on c.id_cliente=cli.id_cliente\n"
                    + "join Documento d on c.referencia =d.folio\n"
                    + "where cli.nombre like '%" + nombre + "%' and c.referencia NOT Like '%NCR%' "
                    + "and (saldo!=0 or saldomx!=0) and d.Serie='fac' and d.estatus='1' "
                    + "and ISNULL(foliofiscal,'') !='' and foliofiscal!= 'null' \n"
                    + "order by cli.nombre";
//            System.out.println("get clientencr " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCvecliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                arr.add(cli);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getfoliotopagotpu_Clientes_ESPECIAL(Connection con,
            String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct cli.id_cliente,cli.nombre\n"
                    + "from cargoespecial c\n"
                    + "join "+bd+".dbo.cliente cli on c.id_cliente=cli.id_cliente\n"
                    + "where cli.nombre like '%"+nombre+"%' and "
                    + "c.referencia NOT Like '%NCR%' and (saldo!=0 or saldomx!=0)\n"
                    + "order by cli.nombre";
            System.out.println("get clientepagr " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCvecliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                arr.add(cli);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getfoliotopagotpu_Clientes_REM(Connection con, String nombre) {//cargos para ncr solo cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct cli.id_cliente,cli.nombre\n"
                    + "from cargo c\n"
                    + "join cliente cli on c.id_cliente=cli.id_cliente\n"
                    + "where cli.nombre like '%" + nombre + "%' and c.referencia NOT Like '%NCR%' "
                    + "and (saldo!=0 or saldomx!=0) and c.estatus='1' \n"
                    + "order by cli.nombre";
//            System.out.println("get clientencr " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCvecliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                arr.add(cli);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
