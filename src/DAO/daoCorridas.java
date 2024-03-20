/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Corridas;
import Persistencia.sqlcorridas;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoCorridas implements corridas{

    @Override
    public ArrayList<Corridas> getCorridas(Connection c, int estilo) {
        sqlcorridas s = new sqlcorridas();
        return s.getcorridaxestilo(c, estilo);
    }
    
}
