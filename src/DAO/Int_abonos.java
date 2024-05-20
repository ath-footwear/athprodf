/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Controlinventario;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_abonos {

    public boolean new_Refacturacion(Connection cobranza, cargo c);

    public int insertabonostpu(Connection con, factura f, Connection cob);

    public ArrayList<abono> getabonos_toinventario(Connection cob, Controlinventario i);
    
    public boolean Exec_respaldoregs_abono(Connection cob, ArrayList<abono> arr);
}
