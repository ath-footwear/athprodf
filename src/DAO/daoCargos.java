/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.cargo;
import Modelo.factura;
import Persistencia.sqlcargos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoCargos implements Cargos {

    private final sqlcargos S = new sqlcargos();

    /**
     * Ingresa un nuevo cargo en la bd interna como complemento de una factura
     * la referencia se especifica como "FAC_45682", que es la "serie_folio"
     *
     * @param c conexion cobranza interna
     * @param f
     * @return
     */
    @Override
    public boolean new_Notacargo(Connection c, factura f) {
        return S.new_Notacargo(f, c);
    }

    /**
     * Obtiene la fecha de vencimiento del cargo con el folio de la factura
     *
     * @param c conexion de cobranza
     * @param folio de factura
     * @return String, fecha de vencimiento
     */
    @Override
    public String get_Fechavencimiento(Connection c, int folio) {
        return S.get_Fechavencimiento(c, folio);
    }

    /**
     * Obtiene el cargo de acuerdo al pedido, se necesita el id del cargo, lo
     * demas se puede obtener del pedido pero para no moverle a la consulta del
     * pedido se obtendra el cliente, y agente ademas del importe
     *
     * @param c conexion acobranza
     * @param pedido Referencia del pedido
     * @return objeto tipo cargo
     */
    @Override
    public cargo getCargowith_pedido(Connection c, factura pedido) {
        return S.getcargowith_pedido(c, pedido);
    }

    /**
     * hace la carga de los cargos especiales, haciendo funcion del cargo con el
     * documento de la factura, por lo tanto, traera solo los cargos especiales
     * que contengan un documento fiscal valida realizado desde el sistema y no
     * cualquier cargo especial
     *
     * @param cpt conexion de cpt
     * @param cliente id del cliente
     * @param bdcob bd de cobranza a usar
     * @return Lista de cargos pendientes
     */
    @Override
    public ArrayList<cargo> getcargos_especial_CompPagos(Connection cpt, String cliente, String bdcob) {
        return S.getcargos_especial_CompPagos(cpt, cliente, bdcob);
    }

    /**
     * Busca todos los cargos pendientes del cliente de acuerdo a la conexion
     * y bd
     * @param c conexion cobranza
     * @param id_cliente id del cliente
     * @param bd puede ser cargo o cargoespecial
     * @return  suma de saldos pendientes
     */
    @Override
    public double getcargopendiente(Connection c, int id_cliente, String bd) {
        return S.get_Cargopendiente(c, id_cliente, bd);
    }

}
