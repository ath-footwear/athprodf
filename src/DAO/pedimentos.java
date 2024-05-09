/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dpedimento;
import Modelo.pedimento;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface pedimentos {

    public ArrayList<pedimento> getallpedimento(Connection c, String ped);

    public boolean nuevopedimento(Connection cpt, Connection rcpt, pedimento ped);

    public boolean borrarped(Connection cpt, int id);
    
    public boolean newmatpedimento(Connection cpt, Dpedimento ped);
    
    public ArrayList<pedimento> getpedimentosimple(Connection cpt, String cob, String cliente);
    
    public ArrayList<pedimento> getpedimentoaadv(Connection cpt, String referencias, String turno);
    
    public ArrayList<pedimento> getpedimentoaadvMAQ(Connection cpt, String referencias);
    
    public ArrayList<pedimento> getpedimentoinv(Connection cpt);
    
    public boolean checkmatdureza(Connection cpt, int mat, String dur, int ped);
    
    public double getStockwithkardex(Connection cpt, int kardex);
    
    public ArrayList<Dpedimento> getMatswith_Idped(Connection cpt, int Id_pedimento);
    
    public double getstockactual(Connection c, Dpedimento dp);
}
