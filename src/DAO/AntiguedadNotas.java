/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Agentes;
import Modelo.AntiguedadNota;
import Modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface AntiguedadNotas {

    public ArrayList<AntiguedadNota> getantiguedad(Connection c, AntiguedadNota n, String Tipofecha);

    public boolean newregistros(Connection c, ArrayList<AntiguedadNota> arr);

    public ArrayList<Agentes> getagentes(Connection c);
    
    public void  vaciartabla(Connection c);
    
    public ArrayList<Cliente> getclientes(Connection c, String agente);

}
