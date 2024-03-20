/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Familia;
import Persistencia.sqlfamilias;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daofamilias implements familias {

    @Override
    public ArrayList<Familia> getallfamilia(Connection c, String f) {
        sqlfamilias s = new sqlfamilias();
        return s.getallfamilias(c, f);
    }

    @Override
    public boolean newfamilia(Connection c, Familia f) {
        sqlfamilias s = new sqlfamilias();
        return s.newfamilia(c, f);
    }

    @Override
    public boolean updateestatus(Connection cpt, int id, String estatus) {
        sqlfamilias s = new sqlfamilias();
        return s.updateestatus(cpt, id, estatus);
    }

    /**
     * Funcion solo para obtener el nombre para el tipo de maquina
     *
     * @param cpt
     * @return
     */
    @Override
    public ArrayList<String> gettipomaterial(Connection cpt) {
        sqlfamilias s = new sqlfamilias();
        return s.gettipom(cpt);
    }

}
