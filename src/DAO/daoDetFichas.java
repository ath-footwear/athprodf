/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Colores;
import Modelo.Departamentos_Prod;
import Modelo.DetFichas;
import Modelo.Fichas;
import Modelo.Materiales;
import Modelo.Piezas;
import Modelo.Tipo_material;
import Modelo.Unidades;
import Persistencia.sqlcolor;
import Persistencia.sqldepartamento_prod;
import Persistencia.sqlmaterial;
import Persistencia.sqlpieza;
import Persistencia.sqltipo_material;
import Persistencia.unidad;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoDetFichas implements detfichas {

    @Override
    public boolean nuevaficha(Connection c, Fichas f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tipo_material> gettipomaterial(Connection c) {
        ArrayList<Tipo_material> arr = new ArrayList<>();
        sqltipo_material tipo = new sqltipo_material();
        arr = tipo.getallTipomat(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Piezas> getpiezas(Connection c) {
        ArrayList<Piezas> arr = new ArrayList<>();
        sqlpieza p = new sqlpieza();
        arr = p.getallPiezas(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Materiales> getmateriales(Connection c) {
        ArrayList<Materiales> arr = new ArrayList<>();
        sqlmaterial m = new sqlmaterial();
        arr = m.getallMateriales(c, arr);
        return arr;
    }

    @Override
    public ArrayList<Unidades> getunidades(Connection c) {
    ArrayList<Unidades> arr = new ArrayList<>();
        unidad m = new unidad();
        arr = m.getallUnidades(c, arr);
        return arr;
    }
    
    @Override
    public ArrayList<Colores> arrcolores(Connection c) {
        ArrayList<Colores> arr = new ArrayList<>();
        sqlcolor color = new sqlcolor();
        arr = color.getallcolors(c, arr);
        return arr;
    }
    
    @Override
    public ArrayList<DetFichas> arrdetfichas(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
