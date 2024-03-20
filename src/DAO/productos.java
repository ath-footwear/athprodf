/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelo.Producto;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface productos {
    public ArrayList<Producto> getProductos(Connection c, int estilo);
    public Producto getProducto(Connection c, int estilo, int corrida, int comb, int almacen, String bd);
    
    
}
