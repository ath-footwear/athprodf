/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ProveedorMPrima;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface proveedor {

    ArrayList<ProveedorMPrima> getallprov(Connection c, String p);

    boolean nuevoprov(Connection rcpt, Connection cpt, ProveedorMPrima p);
    
    boolean nuevoprovtpu(Connection cpt, ProveedorMPrima p);

    boolean deleteprov(Connection rcpt, Connection cpt, int id);

    boolean updateprov(Connection rcpt, Connection cpt, ProveedorMPrima p);
    
    boolean updateestatus(Connection cpt, int id, String estatus);
}
