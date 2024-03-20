/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Addenda;
import Modelo.Corridaaddenda;
import Modelo.Destinoscoppel;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface adendas {

    public ArrayList<Addenda> getAddenda(Connection rcpt, factura f, ArrayList<Corridaaddenda> adenda);

    public ArrayList<Destinoscoppel> getDestinos(Connection rcpt);

    public boolean setAddenda(Connection rctp, ArrayList<Addenda> arr, String cajas);
    
    public ArrayList<Corridaaddenda> getCoraddenda(Connection lite);

}
