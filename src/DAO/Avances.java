/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Anuncio;
import Modelo.Avance;
import Modelo.Colsdepartamentos;
import Modelo.Davance;
import Modelo.Falla;
import Modelo.metadep;
import Modelo.pantalla;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public interface Avances {

    public Connection getconAvance();

    public boolean NuevoAvance(Connection a, Avance av);

    public ArrayList<Avance> getavances(Connection a);

    public Connection getconAvance8();

    public boolean setrowsav(Connection av, Connection liteav, String rcpt, String cob, String f1, String f2);

    public void vaciabd(Connection av);

    public ArrayList<metadep> arrdepp(Connection c);

    /**
     * Actualiza las hrs de acuerdo a la columna ingresada
     *
     * @param c
     * @param hrs
     * @param columna
     * @param nombre
     * @return
     */
    public boolean actualizahrs(Connection c, int hrs, String columna, String nombre);

    public ArrayList<pantalla> getpantallas(Connection c);

    public boolean nuevaspantallas(Connection c, pantalla p);

    public int getmaxpantalla(Connection c);

    public ArrayList<Colsdepartamentos> getcolsdepa(Connection c, String f1, String f2);

    public boolean insertaregistrosAvances_sem(Connection c, ArrayList<Colsdepartamentos> arr);

    public ArrayList<Colsdepartamentos> getarrmes(Connection c, String f1, String f2, String nfecha, String nmaq, String dep, int depa);

    public boolean inserttarregsmes(Connection c, ArrayList<Davance> arr);

    public boolean deleteregmes(Connection c, String col);
    
    public Davance getregsDia(Connection c, String f2, String nmaq, String nfecha, String dep);
    
    public boolean insertarregsDia(Connection c, ArrayList<Davance> arr);
    
    public ArrayList<Colsdepartamentos> getcoldepartamentos(Connection c); 
    
    public boolean newanuncio(Connection c, Anuncio a);
    
    public ArrayList<Anuncio> getAnuncios(Connection c);
    
    public boolean newfalla(Connection c, Falla f);
    
    public ArrayList<Falla> getFallas(Connection c);
    
    public void setborrado(Connection c, int id, String tipo, String tabla);
    
    public void setactualizar(Connection c, int id, String tabla, String fecha);

}
