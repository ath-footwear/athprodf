/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Materiales;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface materiales {

    public boolean nuevomat(Connection cpt, Connection rcpt, Materiales m);
    
    public boolean nuevomatmaq(Connection cpt, Materiales m);

    public ArrayList<Materiales> getmateriales(Connection rcpt, String mat,String turno);
    
    public ArrayList<Materiales> getmaterialesmaq(Connection rcpt, String mat);

    public boolean deletemat(Connection cpt, int material);

    public boolean modmaterial(Connection cpt, Connection rcpt, Materiales m);
    
    public boolean check_nserie(Connection cpt, Materiales m);
}
