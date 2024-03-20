/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Documentoscpt;
import Persistencia.sqldoccpt;
import Persistencia.sqlfactura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoDocscpt implements Documentos{

    @Override
    public ArrayList<Documentoscpt> getdocs(Connection c) {
        ArrayList<Documentoscpt> arr;
        sqldoccpt s = new sqldoccpt();
        arr=s.getDoccpt(c);
        return arr;
    }

    @Override
    public boolean modcaja(Connection c, Documentoscpt d) {
        sqldoccpt s = new sqldoccpt();
        return s.Moddoccpt(c, d);
    }

    @Override
    public boolean modtotales(Connection c, Documentoscpt d) {
        sqldoccpt s = new sqldoccpt();
        return s.Moddocimporte(c, d);
    }

    @Override
    public Documentoscpt getdocs(Connection c, int var) {
        sqldoccpt s = new sqldoccpt();
        return s.getDocimporte(c, var);
    }



    


    
}
