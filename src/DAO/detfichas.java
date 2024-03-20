/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelo.Colores;
import Modelo.DetFichas;
import Modelo.Fichas;
import Modelo.Materiales;
import Modelo.Piezas;
import Modelo.Tipo_material;
import Modelo.Unidades;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface detfichas {
    public boolean nuevaficha(Connection c,Fichas f);
    public ArrayList<Tipo_material> gettipomaterial(Connection c);
    public ArrayList<Piezas> getpiezas(Connection c);
    public ArrayList<Materiales> getmateriales(Connection c);
    public ArrayList<Unidades> getunidades(Connection c);
    public ArrayList<DetFichas> arrdetfichas(Connection c);
    public ArrayList<Colores> arrcolores(Connection c);
}
