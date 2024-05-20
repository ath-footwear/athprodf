/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Inventario;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Inventarios {

    /**
     * Obtiene todos los registros sin where
     *
     * @param c
     * @return
     */
    public ArrayList<Inventario> getinventarios(Connection c);

    public ArrayList<Inventario> getinventarios(Connection c, int mes, int year);

    public boolean nuevoregistroinv(Connection c, ArrayList<Inventario> arr);

    public ArrayList<Inventario> getinventariostocheck(Connection c);

    public boolean deletepedimento(Connection c, int id);

    public boolean nuevoinventario(Connection c, Connection lite, ArrayList<Inventario> arr, int mes, int year);

    public boolean ejecutarespcierre(Connection c, int mes, int year, String turno);
    
    public boolean ejecutarespcierre_cob(Connection c, int mes, int year, String turno);

    public void updatecantin_inv(Connection c, Inventario inv);

}
