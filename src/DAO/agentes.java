/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Agentes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface agentes {

    public ArrayList<Agentes> getAgentes(Connection c);

    public ArrayList<Agentes> getAgentestpu(Connection c);

}
