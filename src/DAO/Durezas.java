/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dureza;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-11/04/2023
 */
public interface Durezas {

    public ArrayList<Dureza> getdurezas(Connection c);
    
    public boolean getdureza(Connection c, String a);
    
    public ArrayList<Dureza> getalldurezas(Connection c, String dur);

    public boolean nuevadureza(Connection c, Dureza d);
    
    boolean updateestatus(Connection cpt, String id, String estatus);
}
