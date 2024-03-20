/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Servidorsql;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Serverlite {
    public Connection Getconexion();
    public void cerrarConexion(Connection c);
    public Connection Getconexionlite();
    public void cerrarConexionlite(Connection c);
    public ArrayList<Servidorsql> getserver(Connection c);
    public boolean execresp(Connection c, Servidorsql s, String y, String m);
    
}
