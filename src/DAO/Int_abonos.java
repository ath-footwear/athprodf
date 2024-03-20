/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_abonos {
    
    public boolean new_Refacturacion(Connection cobranza, cargo c);
    
    public int insertabonostpu(Connection con, factura f, Connection cob);
}
