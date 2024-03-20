/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Servidorsql;
import Persistencia.sqlresp;
import Server.Serverylite;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class daoresp implements Serverlite {

    @Override
    public Connection Getconexion() {
        Connection c=null;
        try {
            Serverylite s = new Serverylite();
            c=s.getconexionS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public Connection Getconexionlite() {
        Connection c=null;
        try {
            Serverylite s = new Serverylite();
            c=s.getconexionC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void cerrarConexion(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrarConexionlite(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoresp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Servidorsql> getserver(Connection c) {
        ArrayList<Servidorsql> arr= new ArrayList<>();
        sqlresp r= new sqlresp();
        arr=r.getbds(c);
        return arr;
    }

    @Override
    public boolean execresp(Connection c, Servidorsql s, String y, String m) {
        sqlresp r= new sqlresp();
        r.ejecutarresp(c, s, y, m);
        return true;
    }

    
}
