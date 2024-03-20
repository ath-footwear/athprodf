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
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface fichas {
    public boolean nuevaficha(Connection c,Fichas f);
    public ArrayList<Colores> getcolores(Connection c);
    public ArrayList<Linea> getLineas(Connection c);
    public ArrayList<Hormas> gethormas(Connection c);
    public ArrayList<Corridas> getcorridas(Connection c);
    public ArrayList<Departamentos_Prod> detdepprods(Connection c);
    public Fichas getficha(Connection c);
    public ArrayList<DetFichas> arrdetfichas(Connection c);
    public ArrayList<Fichas> arrfichas(Connection c, String s);
    public boolean chekficha(Connection c, Fichas f);
    public void statusupdate(Connection c, Fichas f);
}
