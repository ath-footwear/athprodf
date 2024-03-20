/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Agentes;
import Persistencia.sqlagentes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoAgentes implements agentes{

    @Override
    public ArrayList<Agentes> getAgentes(Connection c) {
        sqlagentes s = new sqlagentes();
        return s.getAgentes(c);
    }

    @Override
    public ArrayList<Agentes> getAgentestpu(Connection c) {
        sqlagentes s = new sqlagentes();
        return s.getAgentestpu(c);
    }

    
}
