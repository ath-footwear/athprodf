/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dureza;
import Persistencia.sqldureza;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daodurezas implements Durezas {

    @Override
    public ArrayList<Dureza> getdurezas(Connection c) {
        sqldureza s = new sqldureza();
        return s.getalldurezas(c);
    }

    @Override
    public boolean nuevadureza(Connection c, Dureza d) {
        sqldureza s = new sqldureza();
        return s.newdureza(c, d);
    }

    @Override
    public boolean getdureza(Connection c, String a) {
        sqldureza s = new sqldureza();
        return s.getdureza(c, a);
    }

    @Override
    public boolean updateestatus(Connection cpt, String id, String estatus) {
        sqldureza s = new sqldureza();
        return s.updateestatus(cpt, id, estatus);
    }

    @Override
    public ArrayList<Dureza> getalldurezas(Connection c, String dur) {
        sqldureza a = new sqldureza();
        return a.getalldureza(c, dur);
    }

}
