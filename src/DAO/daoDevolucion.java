/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import Persistencia.sqldevolucion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoDevolucion implements Devoluciones {

    @Override
    public ArrayList<Devolucion> arr(Connection c, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Motivosdev> arrmotivos(Connection c) {
        sqldevolucion s = new sqldevolucion();
        return s.getallmomtivos(c);
    }

    @Override
    public ArrayList<Ddevolucion> arr(Connection c, int id_pedido, String bdname) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidowithpedido(c, id_pedido, bdname);
    }

    @Override
    public boolean newdev(Connection c, Devolucion d, Connection cob) {
        sqldevolucion s = new sqldevolucion();
        return s.newdevolucion(c, d, cob);
    }

    @Override
    public ArrayList<Ddevolucion> arrfac(Connection c, int folio) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidowithpedidofac(c, folio);
    }

    @Override
    public ArrayList<Devolucion> getalldevswithn(Connection c, String serie) {
        sqldevolucion s = new sqldevolucion();
        return s.getalldevs(c, serie);
    }

    @Override
    public ArrayList<Ddevolucion> getpedscancel(Connection c, int iddoc, String serie, String bdcob) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidocancel(c, iddoc, serie, bdcob);
    }

    @Override
    public ArrayList<Ddevolucion> getdevolucion(Connection c, int id) {
        sqldevolucion s = new sqldevolucion();
        return s.getdevolucion(c, id);
    }

    @Override
    public boolean nuevacancelacion(Connection c, Connection cob, Devolucion d, ArrayList<Ddevolucion> arrs) {
        sqldevolucion s = new sqldevolucion();
        return s.newcancelacion(c, cob, d, arrs);
    }

    @Override
    public int verificadevs(Connection c, String serie, int idped) {
        sqldevolucion s = new sqldevolucion();
        return s.verificadevs(c, serie, idped);
    }

    @Override
    public ArrayList<Ddevolucion> getpedscancelrem(Connection c, int iddoc, String serie, String bdcob) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidocancelrem(c, iddoc, serie, bdcob);
    }

    @Override
    public int verificadevsped(Connection c, String serie, int idped) {
        sqldevolucion s = new sqldevolucion();
        return s.verificadevsped(c, serie, idped);
    }

    @Override
    public ArrayList<Ddevolucion> getpedidocancelsindev(Connection c, int iddoc, String serie, String bdcob) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidocancelsindev(c, iddoc, serie, bdcob);
    }

    @Override
    public ArrayList<Ddevolucion> getpedidocancelsindevfac(Connection c, int iddoc, String serie, String bdcob) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidocancelsindevfac(c, iddoc, serie, bdcob);
    }

}
