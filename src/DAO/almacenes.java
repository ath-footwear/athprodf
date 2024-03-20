/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Almacen;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface almacenes {

    public ArrayList<Almacen> getalmacenes(Connection c);

    public ArrayList<Almacen> getalmacenescpt(Connection c);
}
