/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelo.Combinacion;
import Modelo.Corridas;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface combinaciones {
    public ArrayList<Combinacion> getCombinaciones(Connection c, int estilo, int corrida);
    
    
}
