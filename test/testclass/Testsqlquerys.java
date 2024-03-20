/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import DAO.daoDevolucion;
import Modelo.Formateodedatos;
import Modelo.Kardexrcpt;
import Modelo.cargo;
import Server.Serverprod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class Testsqlquerys {
    
    public static void main(String[] args) {
//        try {
        Testsqlquerys t = new Testsqlquerys();
//            t.verificadevs("A", 19);
//        t.modificacaostodfactura();
//        t.actualizavencimientos();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void verificadevs(String s, int id) throws ClassNotFoundException, IOException, SQLException {
        Serverprod si = new Serverprod();
        Connection c = si.getconexionTPU("Tpucpt");
        daoDevolucion d = new daoDevolucion();
        d.verificadevs(c, s, id);
        c.close();
    }

    /**
     * Actualiza y modifica los costos de dfacturas
     */
//    public void modificacaostodfactura() {
//        try {
//            Serverprod s = new Serverprod();
//            Connection concpt = s.getconexionserver8("CPT");
//            Connection conrcpt = s.getconexionserver8("RCPT");
//            sqlfactura sql = new sqlfactura();
//            ArrayList<Kardexrcpt> arr = sql.modcostodfac(conrcpt);
//            if (sql.setmodificaciondfactura(conrcpt, arr) || sql.setmodificaciondfactura(concpt, arr)) {
//                System.out.println("Completo");
//            }
////            for (Kardexrcpt arr1 : arr) {
////                System.out.println(arr1.getFactura()+" "+arr1.getId_prod()+" "+arr1.getCosto()+" "+arr1.getVenta()+"");
////            }
//            concpt.close();
//            conrcpt.close();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    /**
     * Actualiza las fechas de vencimiento ya que anterior mente no se
     * especifico esta cuestion el plazo lo lleva el agente por default de igual manera el cargo
     */
    public void actualizavencimientos() {
        Connection cob = null;
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            Formateodedatos f = new Formateodedatos();
            
            Serverprod s = new Serverprod();
//            cob = s.getconexionTPU("ACobranzaTpu");
          cob=s.getconexionserver8("ACobranzaTpu");
            cob.setAutoCommit(false);
            String sql = "select id_cargo,a.plazo,dateadd(day,convert(INT,a.plazo),fecha) as fechav\n"
                    + "from cargo c\n"
                    + "join agente a on c.id_agente=a.id_agente\n"
                    + "where isnull(fechavencimiento,'')=''";
            st = cob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                cargo c = new cargo();
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setFechav(f.ffecha(rs.getString("fechav")));
                c.setPlazo(rs.getInt("plazo"));
                arr.add(c);
            }
            rs.close();
            for (int i = 0; i < arr.size(); i++) {
                sql = "update cargo set plazo=" + arr.get(i).getPlazo() + ", fechavencimiento='" + arr.get(i).getFechav() + "' where id_cargo=" + arr.get(i).getId_cargo();
                System.out.println(sql);
                st = cob.prepareStatement(sql);
                st.executeUpdate();
            }
            cob.commit();
        } catch (Exception ex) {
            try {
                cob.rollback();
                Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }
}
