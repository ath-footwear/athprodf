/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Controlinventario;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Cargos {
    
    public boolean new_Notacargo(Connection c, factura f);
    
    public String get_Fechavencimiento(Connection c, int folio);
    
    public cargo getCargowith_pedido(Connection c, factura pedido);
    
    public ArrayList<cargo> getcargos_especial_CompPagos(Connection cpt, String cliente, String bdcob);
    
    public double getcargopendiente(Connection c, int id_cliente, String bd);
    
    public ArrayList<cargo> getcargos_toinventario(Connection cob, Controlinventario i);
    
    public boolean Exec_respaldoregs(Connection cob, ArrayList<cargo> arr);
}
