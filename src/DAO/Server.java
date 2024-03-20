/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface Server {
    public Connection Getconexion();
    public void cerrarConexion();
}
