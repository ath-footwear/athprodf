/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ConceptosES;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface conceptos {

    public ArrayList<ConceptosES> getConceptos(Connection c);

    public ArrayList<ConceptosES> getConceptos(Connection c, int cuenta);

    public ConceptosES getConceptos(Connection c, int cuenta, int subcuenta);
    
    public int getConceptos_cob(Connection c, int cuenta, int subcuenta);
}
