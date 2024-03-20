/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Devoluciones {

    public ArrayList<Motivosdev> arrmotivos(Connection c);
    
    public int verificadevs (Connection c, String serie, int idped);
    
    public int verificadevsped(Connection c, String serie, int idped);
    
    public ArrayList<Devolucion> arr(Connection c, String s);
    
    public ArrayList<Ddevolucion> arr(Connection c, int id_pedido, String bdname);
    
    public ArrayList<Ddevolucion> arrfac(Connection c, int folio);

    public boolean newdev(Connection c, Devolucion d, Connection cob);
    
    public ArrayList<Devolucion> getalldevswithn(Connection c,String serie);
    
    public ArrayList<Ddevolucion> getpedscancel(Connection c,int iddoc,String serie, String bdcob);
    
    public ArrayList<Ddevolucion> getpedscancelrem(Connection c,int iddoc,String serie, String bdcob);
    
    public ArrayList<Ddevolucion> getpedidocancelsindev(Connection c,int iddoc,String serie, String bdcob);
    
    public ArrayList<Ddevolucion> getpedidocancelsindevfac(Connection c,int iddoc,String serie, String bdcob);
    
    public ArrayList<Ddevolucion> getdevolucion(Connection c, int id);
    
    public boolean nuevacancelacion(Connection c, Connection cob, Devolucion d, ArrayList<Ddevolucion> arrs);
}
