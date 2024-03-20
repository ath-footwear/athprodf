/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Controlinventario;
import Persistencia.sqlcontrolinventarios;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoControlinventarios implements ControlInventarios{

    @Override
    public Controlinventario getarrinv(Connection c) {
        sqlcontrolinventarios s = new sqlcontrolinventarios();
        return s.getinventarios(c);
    }
    
}
