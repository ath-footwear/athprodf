/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Controlinventario;
import Persistencia.sqlcontrolinventarios;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public class daoControlinventarios implements ControlInventarios{

    /**
     * Obtiene el inventario actual refiriendose al mes y año
     * @param c
     * @return 
     */
    @Override
    public Controlinventario getarrinv(Connection c) {
        sqlcontrolinventarios s = new sqlcontrolinventarios();
        return s.getinventarios(c);
    }
    
}
