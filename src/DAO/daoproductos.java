/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Producto;
import Persistencia.sqlproductos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoproductos implements productos{

    @Override
    public ArrayList<Producto> getProductos(Connection c, int estilo) {
        sqlproductos s = new sqlproductos();
        return s.getprodxestilo(c, estilo);
    }

    @Override
    public Producto getProducto(Connection c, int estilo, int corrida, int comb, int almacen, String bd) {
        sqlproductos s = new sqlproductos();
        return s.getprod(c, estilo, corrida, comb, almacen,bd);
    }


    
}
