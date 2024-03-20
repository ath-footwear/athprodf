/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresas;
import Persistencia.sqlempresa;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoempresa implements Empresa {

//    public Empresas getempresa(Connection c) {
    @Override
    public String getdirimag(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresas getempresa(Connection c) {
        sqlempresa em = new sqlempresa();
        Empresas e = new Empresas();
        e = em.getEmpresa(c);
        return e;
    }

    @Override
    public Empresas getempresarfc(Connection c, String n) {
        sqlempresa em = new sqlempresa();
        Empresas e = new Empresas();
        e = em.getEmpresarfc(c, n);
        return e;
    }

    @Override
    public ArrayList<Empresas> getallempresa(Connection c) {
        sqlempresa em= new sqlempresa();
        return em.getallempresas(c);
    }

    @Override
    public boolean actualizadir(Connection c, String col, String dato, int id) {
        sqlempresa em = new sqlempresa();
        return em.actualizaempresas(c, col, dato, id);
    }

}
