/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Colores;
import Modelo.Corridas;
import Modelo.Departamentos_Prod;
import Modelo.DetFichas;
import Modelo.Fichas;
import Modelo.Hormas;
import Modelo.Linea;
import Persistencia.sqlHormas;
import Persistencia.sqlcolor;
import Persistencia.sqlcorrida;
import Persistencia.sqldepartamento_prod;
import Persistencia.sqlficha;
import Persistencia.sqllineas;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoFichas implements fichas {

    @Override
    public boolean nuevaficha(Connection c, Fichas f) {
        sqlficha sf = new sqlficha();
        return sf.Addficha(c, f);
    }

    @Override
    public ArrayList<Colores> getcolores(Connection c) {
        ArrayList<Colores> arr = new ArrayList<>();
        sqlcolor color = new sqlcolor();
        arr = color.getallcolors(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Linea> getLineas(Connection c) {
        ArrayList<Linea> arr = new ArrayList<>();
        sqllineas linea = new sqllineas();
        linea.getAlllinea(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Hormas> gethormas(Connection c) {
        ArrayList<Hormas> arr = new ArrayList<>();
        sqlHormas h = new sqlHormas();
        h.getAllhormas(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Corridas> getcorridas(Connection c) {
        ArrayList<Corridas> arr = new ArrayList<>();
        sqlcorrida cor = new sqlcorrida();
        cor.getAllCorrida(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Departamentos_Prod> detdepprods(Connection c) {
        ArrayList<Departamentos_Prod> arr = new ArrayList<>();
        sqldepartamento_prod dp = new sqldepartamento_prod();
        dp.getAlldepprod(c, arr);
        return arr;
    }

    @Override
    public Fichas getficha(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetFichas> arrdetfichas(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fichas> arrfichas(Connection c, String s) {
        ArrayList<Fichas> arr = new ArrayList<>();
        sqlficha sf= new sqlficha();
        arr=sf.getbuscaficha(c, s);
        return arr;
    }

    @Override
    public boolean chekficha(Connection c, Fichas f) {
    sqlficha sf= new sqlficha();
    return sf.checkficha(c, f);
    }

    @Override
    public void statusupdate(Connection c, Fichas f) {
    sqlficha sf= new sqlficha();
    sf.updateficha(c, f);
    }


}
