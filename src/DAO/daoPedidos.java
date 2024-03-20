/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dfactura;
import Modelo.factura;
import Persistencia.sqlpedidos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoPedidos implements Int_pedidos {

    /**
     * Obtiene el detalle del pedido y el cargo
     *
     * @param c
     * @param f
     * @param bd
     * @return
     */
    @Override
    public ArrayList<Dfactura> getdetpedidos(Connection c, factura f, String bd) {
        sqlpedidos s = new sqlpedidos();
        return s.getdpedido(c, f, bd);
    }

    /**
     * Actualiza el detalle del pedido, su detalle y el cargo de acuerdo al
     * precio capturado
     *
     * @param c
     * @param cob
     * @param arr
     * @return
     */
    @Override
    public boolean updatedpedidos(Connection c, Connection cob, ArrayList<Dfactura> arr) {
        sqlpedidos s = new sqlpedidos();
        return s.actualizadpedido(c, cob, arr);
    }

}
