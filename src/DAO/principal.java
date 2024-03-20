/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuarios;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface principal {
    public Usuarios getUsers(Connection c,String u, String pass, String columna);
    public Usuarios getUserlite(Connection c, String pass, String usuario);
}
