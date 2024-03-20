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
import Persistencia.sqlavances;
import Persistencia.sqlpantallas;
import Server.Serverylite;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoAvances implements Avances {

    /**
     * Crea una linea de avance sobre el objeto de avance
     *
     * @param a La conexion para prueba es en lite
     * @param av
     * @return
     */
    @Override
    public boolean NuevoAvance(Connection a, Avance av) {
        sqlavances s = new sqlavances();
        return s.nuevoavancept(a, av);
    }

    @Override
    public ArrayList<Avance> getavances(Connection a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Para pruebas usar la bd de lite y no la de produccion(6.8)
     *
     * @return
     */
    @Override
    public Connection getconAvance() {
        return null;
    }

    @Override
    public Connection getconAvance8() {
        return null;
    }

    /**
     *
     * @param av conexion a server avcances
     * @param liteav conexion a serverlite para reporte
     * @param rcpt nombre bd rcpt
     * @param cob nombre bd cobranza
     * @param f1 fecha inicial
     * @param f2 fecha final
     * @return
     */
    @Override
    public boolean setrowsav(Connection av, Connection liteav, String rcpt, String cob, String f1, String f2) {
        sqlavances s = new sqlavances();
        return s.setRowsav(av, liteav, rcpt, cob, f1, f2);
    }

    /**
     * Vacia la tabla de los avances en sqlite
     *
     * @param av
     */
    @Override
    public void vaciabd(Connection av) {
        sqlavances s = new sqlavances();
        s.Vaciabd(av);
    }

    @Override
    public ArrayList<metadep> arrdepp(Connection c) {
        sqlavances sa = new sqlavances();
        return sa.getallavance(c);
    }

    /**
     * Cambios en col, de ahora en adelante se utilizara para mandar la
     * multiplicacion de hrs x los par
     *
     * @param c
     * @param hrs
     * @param columna
     * @param nombre
     * @return
     */
    @Override
    public boolean actualizahrs(Connection c, int hrs, String columna, String nombre) {
        sqlavances sa = new sqlavances();
        return sa.updateprshr(c, hrs, columna, nombre);
    }

    @Override
    public ArrayList<pantalla> getpantallas(Connection c) {
        sqlavances a = new sqlavances();
        return a.getpantalals(c);
    }

    @Override
    public boolean nuevaspantallas(Connection c, pantalla p) {
        sqlavances a = new sqlavances();
        return a.nuevaspantallas(c, p);
    }

    @Override
    public int getmaxpantalla(Connection c) {
        sqlavances a = new sqlavances();
        return a.getmaxpantalla(c);
    }

    /**
     * Obtienes los registros de los parametros de la tabla de acuerdo al
     * departamento de tabla Avances del 6.8
     *
     * @param c
     * @param f1
     * @param f2
     * @return
     */
    @Override
    public ArrayList<Colsdepartamentos> getcolsdepa(Connection c, String f1, String f2) {
        sqlavances a = new sqlavances();
        return a.getColsdepas(c, f1, f2);
    }

    /**
     * Inserta registro en la bd de SQLITE para de ahi proceder con el reporte
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean insertaregistrosAvances_sem(Connection c, ArrayList<Colsdepartamentos> arr) {
        sqlavances a = new sqlavances();
        return a.insertaregsinavansemana(c, arr);
    }

    /**
     * Obtiene y organiza los registros para el reporte de avances de produccion
     * por mes
     *
     * @param c
     * @param f1
     * @param f2
     * @param nfecha
     * @param nmaq
     * @param dep
     * @param depa Importante para identificar mas de una banda en montado sino no es necesario
     * @return
     */
    @Override
    public ArrayList<Colsdepartamentos> getarrmes(Connection c, String f1, String f2, String nfecha, String nmaq, String dep, int depa) {
        sqlavances a = new sqlavances();
        return a.getarrayavancemes(c, f1, f2, nfecha, nmaq, dep, depa);
    }

    /**
     * Insertar registros en bd SQLITE para su posterior d3espliegue
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean inserttarregsmes(Connection c, ArrayList<Davance> arr) {
        sqlavances a = new sqlavances();
        return a.insertarregsMes(c, arr);
    }

    /**
     * Eliminacion de registros de la misma bd SQLITE con seleccion de tabla
     * como parametro
     *
     * @param c
     * @param col
     * @return
     */
    @Override
    public boolean deleteregmes(Connection c, String col) {
        sqlavances a = new sqlavances();
        return a.deleteregsMes(c, col);
    }

    /**
     * Obtiene los registros por departamento x dia desde avances del 6.8
     *
     * @param c
     * @param f2
     * @param nmaq
     * @param nfecha
     * @param dep
     * @return
     */
    @Override
    public Davance getregsDia(Connection c, String f2, String nmaq, String nfecha, String dep) {
        sqlavances a = new sqlavances();
        return a.getregsDia(c, f2, nmaq, nfecha, dep);
    }

    /**
     * Inserta registros en la bd de sqlite respecto a avances x dia
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean insertarregsDia(Connection c, ArrayList<Davance> arr) {
        sqlavances a = new sqlavances();
        return a.insertarregsDia(c, arr);
    }

    /**
     * Obtiene el nombre de las columnas de los avances usando conexion del 6.8
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<Colsdepartamentos> getcoldepartamentos(Connection c) {
        sqlavances a = new sqlavances();
        return a.getColsdepartamentos(c);
    }

    @Override
    public boolean newanuncio(Connection c, Anuncio a) {
        sqlpantallas s = new sqlpantallas();
        return s.nuevoanuncio(c, a);
    }

    @Override
    public ArrayList<Anuncio> getAnuncios(Connection c) {
        sqlpantallas s = new sqlpantallas();
        return s.getanuncios(c);
    }

    @Override
    public boolean newfalla(Connection c, Falla f) {
        sqlpantallas s = new sqlpantallas();
        return s.nuevafalla(c, f);
    }

    @Override
    public ArrayList<Falla> getFallas(Connection c) {
        sqlpantallas s = new sqlpantallas();
        return s.getfallas(c);
    }

    @Override
    public void setborrado(Connection c, int id, String tipo, String tabla) {
        sqlpantallas s = new sqlpantallas();
        s.setborrado(c, id, tipo, tabla);
    }

    /**
     * Actualiza a auna fecha acual y poderla utilizar al instante
     *
     * @param c
     * @param id
     * @param tabla
     * @param fecha
     */
    @Override
    public void setactualizar(Connection c, int id, String tabla, String fecha) {
        sqlpantallas s = new sqlpantallas();
        s.setactualizar(c, id, tabla, fecha);
    }

}
