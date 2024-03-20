/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Addenda;
import Modelo.Corridaaddenda;
import Modelo.Destinoscoppel;
import Modelo.factura;
import Persistencia.sqladdenda;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoAddenda implements adendas {

    /**
     *
     * @param rcpt
     * @return
     */
    @Override
    public ArrayList<Destinoscoppel> getDestinos(Connection rcpt) {
        sqladdenda s = new sqladdenda();
        return s.getDestinos(rcpt);
    }

    @Override
    public boolean setAddenda(Connection rctp, ArrayList<Addenda> arr, String cajas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Obtiene datos de la bd del lite ya que son datos fijos de acuerdo a una
     * tabla
     *
     * @param lite Conexion a la base de datos donde esta la estructura de la
     * tabla
     * @return
     */
    @Override
    public ArrayList<Corridaaddenda> getCoraddenda(Connection lite) {
        sqladdenda s = new sqladdenda();
        return s.getCoraddenda(lite);
    }

    /**
     *
     * @param rcpt
     * @param f
     * @param adenda
     * @return
     */
    @Override
    public ArrayList<Addenda> getAddenda(Connection rcpt, factura f, ArrayList<Corridaaddenda> adenda) {
        sqladdenda s = new sqladdenda();
        return s.getAddenda(rcpt, f, adenda);
    }

}
