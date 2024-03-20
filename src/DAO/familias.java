/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Familia;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface familias {

    public ArrayList<Familia> getallfamilia(Connection c, String f);

    public boolean newfamilia(Connection c, Familia f);
    
    boolean updateestatus(Connection cpt, int id, String estatus);
    
    public ArrayList<String> gettipomaterial(Connection cpt);
    
}
