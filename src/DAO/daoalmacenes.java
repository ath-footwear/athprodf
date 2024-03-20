/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Almacen;
import Persistencia.sqlalmacenes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoalmacenes implements almacenes {

    @Override
    public ArrayList<Almacen> getalmacenes(Connection c) {
        sqlalmacenes s = new sqlalmacenes();
        return s.getAgentes(c);
    }

    @Override
    public ArrayList<Almacen> getalmacenescpt(Connection c) {
        sqlalmacenes s = new sqlalmacenes();
        return s.getAlmacenes(c);
    }

}
