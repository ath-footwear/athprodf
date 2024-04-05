/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agentes;
import Modelo.AntiguedadNota;
import Modelo.Cliente;
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
public class sqlantiguedadnotas {

//    c1=10, c2=15c c3 =20, c4=25, c5=30
    public ArrayList<AntiguedadNota> getregs(Connection c, AntiguedadNota n, String tipof) {
        ArrayList<AntiguedadNota> arr = new ArrayList<>();
        try {
            int c1 = n.getC1();
            int c2 = n.getC2();
            int c3 = n.getC3();
            int c4 = n.getC4();
            int c5 = n.getC5();
            PreparedStatement st;
            ResultSet rs;
            String sql = "select cat.cuenta,cat.subcuenta,cat.Descripcion,c.id_cliente,cli.Nombre, a.id_Agente,a.Nombre as agente, referencia,saldo,\n"
                    + "convert(date,fecha) as fecha,convert(date,FechaVencimiento) as fechav,DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "') as dias,importe,\n"
                    + "a1=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')<=" + c1 + "  then saldo else 0 end,\n"
                    + "a2=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')>" + c1 + " and DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')<=" + c2 + "  then saldo else 0 end,\n"
                    + "a3=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')>" + c2 + " and DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')<=" + c3 + "  then saldo else 0 end,\n"
                    + "a4=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')>" + c3 + " and DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')<=" + c4 + "  then saldo else 0 end,\n"
                    + "a5=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')>" + c4 + " and DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')<=" + c5 + "  then saldo else 0 end,\n"
                    + "a6=case when DATEDIFF(day,convert(date," + tipof + "),'" + n.getF2() + "')>" + c5 + " then saldo else 0 end\n"
                    + "from cargo c\n"
                    + "join cliente cli on c.id_Cliente=cli.id_Cliente\n"
                    + "join Agente a on c.id_Agente=a.id_Agente\n"
                    + "join catcuenta cat on c.id_concepto=cat.id_concepto\n"
                    + "where convert(date,Fecha) between '" + n.getF1() + "' and '" + n.getF2() + "' and (saldo !=0 and saldomx!=0) and "
                    + "c.id_agente like '%" + n.getAgente() + "%' and c.id_cliente like '%" + n.getCliente() + "%' \n"
                    + "order by a.id_agente";

//                        String sql = "select c.cuenta,c.subcuenta,cat.Descripcion,c.numcliente,cli.Nombre, a.CveAgente,a.Nombre as agente, referencia,saldo,\n"
//                    + "convert(date,fecha) as fecha,convert(date,FechaVencimiento) as fechav,DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "') as dias,importe,\n"
//                    + "a1=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')<=" + c1 + "  then saldo else 0 end,\n"
//                    + "a2=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')>" + c1 + " and DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')<=" + c2 + "  then saldo else 0 end,\n"
//                    + "a3=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')>" + c2 + " and DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')<=" + c3 + "  then saldo else 0 end,\n"
//                    + "a4=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')>" + c3 + " and DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')<=" + c4 + "  then saldo else 0 end,\n"
//                    + "a5=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')>" + c4 + " and DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')<=" + c5 + "  then saldo else 0 end,\n"
//                    + "a6=case when DATEDIFF(day,convert(date,FechaVencimiento),'" + n.getF2() + "')>" + c5 + " then saldo else 0 end\n"
//                    + "from cargos c\n"
//                    + "join clientes cli on c.NumCliente=cli.NumCliente\n"
//                    + "join Agentes a on c.CveAgente=a.CveAgente\n"
//                    + "join catcuentas cat on c.Cuenta=cat.Cuenta and c.SubCuenta=cat.SubCuenta\n"
//                    + "where convert(date,Fecha) between '" + n.getF1() + "' and '" + n.getF2() + "' and saldo !=0 and c.cveagente like '" + n.getAgente() + "'\n"
//                    + "order by a.cveagente";
//            System.out.println("get regs " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                AntiguedadNota a = new AntiguedadNota();
                a.setCuenta(rs.getInt("cuenta"));
                a.setSubcuenta(rs.getInt("subcuenta"));
                a.setDesc_cuenta(rs.getString("descripcion"));
                a.setNumcliete(rs.getInt("id_cliente"));
                a.setCliente(rs.getString("nombre"));
                a.setNumagente(rs.getInt("id_agente"));
                a.setAgente(rs.getString("agente"));
                a.setReferencia(rs.getString("referencia"));
                a.setFecha(rs.getString("fecha"));
                a.setFechav(rs.getString("fechav"));
                a.setDias(rs.getInt("dias"));
                a.setA1(rs.getDouble("a1"));
                a.setA2(rs.getDouble("a2"));
                a.setA3(rs.getDouble("a3"));
                a.setA4(rs.getDouble("a4"));
                a.setA5(rs.getDouble("a5"));
                a.setA6(rs.getDouble("a6"));
                a.setImporte(rs.getDouble("importe"));
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean setrows(Connection c, ArrayList<AntiguedadNota> arr) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            for (AntiguedadNota arr1 : arr) {
                int cuenta = arr1.getCuenta();
                int sub = arr1.getSubcuenta();
                String desc = arr1.getDesc_cuenta();
                int ncli = arr1.getNumcliete();
                String cli = arr1.getCliente();
                int nag = arr1.getNumagente();
                String ag = arr1.getAgente();
                String ref = arr1.getReferencia();
                String f = arr1.getFecha();
                String fv = arr1.getFechav();
                int dia = arr1.getDias();
                double a1 = arr1.getA1();
                double a2 = arr1.getA2();
                double a3 = arr1.getA3();
                double a4 = arr1.getA4();
                double a5 = arr1.getA5();
                double a6 = arr1.getA6();
                double imp = arr1.getImporte();
                String sql = "insert into antiguedad_notas(cuenta,subcuenta,desc_cuenta,numcliente,"
                        + "cliente,numagente,agente,referencia,fecha,fechav,dias,a1,a2,a3,a4,a5,a6,importe) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                System.out.println(sql);
                st = c.prepareStatement(sql);
                st.setInt(1, cuenta);
                st.setInt(2, sub);
                st.setString(3, desc);
                st.setInt(4, ncli);
                st.setString(5, cli);
                st.setInt(6, nag);
                st.setString(7, ag);
                st.setString(8, ref);
                st.setString(9, f);
                st.setString(10, fv);
                st.setInt(11, dia);
                st.setDouble(12, a1);
                st.setDouble(13, a2);
                st.setDouble(14, a3);
                st.setDouble(15, a4);
                st.setDouble(16, a5);
                st.setDouble(17, a6);
                st.setDouble(18, imp);
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<Agentes> getagentes(Connection c) {
        ArrayList<Agentes> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select nombre,id_agente from agente\n"
                    + "order by nombre";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Agentes a = new Agentes();
                a.setIdagente(rs.getInt("id_agente"));
                a.setNombre(rs.getString("nombre"));
                arr.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getclientes(Connection c, String agente) {
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cliente,nombre from cliente "
                    + "where id_agente like '%"+agente+"%' and estatus='1'\n"
                    + "order by nombre";
//            System.out.println(sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                arr.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void vaciatabla(Connection c) {
        try {
            PreparedStatement st;
            String sql = "delete from antiguedad_notas";
//            System.out.println(sql);
            c.setAutoCommit(false);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlantiguedadnotas.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }
}
