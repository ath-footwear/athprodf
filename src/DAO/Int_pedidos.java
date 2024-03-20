/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dfactura;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_pedidos {
//    obtiene el detalle de un pedido
    public ArrayList<Dfactura> getdetpedidos(Connection c, factura f, String bd);
//    Actualiza los registros de acuerdo a un detalle de un pedido
    public boolean updatedpedidos(Connection c, Connection cob, ArrayList<Dfactura> arr);
}
