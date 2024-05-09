/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dpedimento;
import Modelo.pedimento;
import Persistencia.sqlpedimentos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daopedimentos implements pedimentos {

    /**
     * Obtiene todos los pedimentos de acuerrdo al nombre del proveedor
     * ordenados de mayor a menos
     *
     * @param c
     * @param ped
     * @return
     */
    @Override
    public ArrayList<pedimento> getallpedimento(Connection c, String ped) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getallpepds(c, ped);
    }

    /**
     * Crea un nuevo pedimento de acuerdo al valor dado en el objeto pedimento
     *
     * @param cpt Conexion de cpt
     * @param rcpt Conexion de rcpt por si se divide en B
     * @param ped Objeto pedimento
     * @return booleano
     */
    @Override
    public boolean nuevopedimento(Connection cpt, Connection rcpt, pedimento ped) {
        sqlpedimentos rs = new sqlpedimentos();
        return rs.nuevopedimento(cpt, rcpt, ped);
    }

    /**
     * Borra un pedimento de acuerdo al pedimento previamente seleccionado
     *
     * @param cpt
     * @param id
     * @return
     */
    @Override
    public boolean borrarped(Connection cpt, int id) {
        sqlpedimentos rs = new sqlpedimentos();
        return rs.delete_pedimento(cpt, id);
    }

    /**
     * Obtiene una lista de los pedimentos reducida, ya que su funcion es
     * desplegar un resumen para un proceso posterior
     *
     * @param cpt
     * @param cob no se utiliza, se penso para otro tipode funcion
     * @param cliente
     * @return
     */
    @Override
    public ArrayList<pedimento> getpedimentosimple(Connection cpt, String cob, String cliente) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentosimple(cpt, cob, cliente);
    }

    /**
     * Obtiene el detallado de pedimento usando al referencia del pedimento, con
     * esto se refiere a stock, descripcion, precio con el cual se dio de alta
     *
     * @param cpt
     * @param referencias
     * @param turno
     * @return
     */
    @Override
    public ArrayList<pedimento> getpedimentoaadv(Connection cpt, String referencias, String turno) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentoadv(cpt, referencias, turno);
    }

    /**
     * Agrega un material extra al pedimento ya dado de alta
     *
     * @param cpt
     * @param ped
     * @return
     */
    @Override
    public boolean newmatpedimento(Connection cpt, Dpedimento ped) {
        sqlpedimentos s = new sqlpedimentos();
        return s.newmatpedimento(cpt, ped);
    }

    /**
     * Datos con el detalle del pedimento para uso de inventario
     *
     * @param cpt
     * @return
     */
    @Override
    public ArrayList<pedimento> getpedimentoinv(Connection cpt) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentoinv(cpt);
    }

    /**
     * Verifica que el material y la dureza no exista
     *
     * @param cpt
     * @param mat
     * @param dur
     * @param ped
     * @return
     */
    @Override
    public boolean checkmatdureza(Connection cpt, int mat, String dur, int ped) {
        sqlpedimentos s = new sqlpedimentos();
        return s.checkmatdureza(cpt, mat, dur, ped);
    }

    /**
     * Es el mismo proposito que la original ADV, solo que esta trae 3 columnas
     * mas e ignora la dureza ya que es para las maquinas, de ahi en mas es la
     * misma consulta base.
     *
     * @param cpt
     * @param referencias
     * @return Pedimento junto su detalle
     */
    @Override
    public ArrayList<pedimento> getpedimentoaadvMAQ(Connection cpt, String referencias) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentoadvMaquina(cpt, referencias);
    }

    /**
     * Obtiene la cantidad restante de un producto mediante el kardex
     *
     * @param cpt conexion de cpt
     * @param kardex id del kardex
     * @return cantidad en stock
     */
    @Override
    public double getStockwithkardex(Connection cpt, int kardex) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getStockwithkardex(cpt, kardex);
    }

    /**
     * Obtiene el detallado del pedimento para la selección del mismo, solo
     * traerá aquellos que tengan stock mayor a cero
     *
     * @param cpt conexion cpt
     * @param Id_pedimento Id del pedimento
     * @return
     */
    @Override
    public ArrayList<Dpedimento> getMatswith_Idped(Connection cpt, int Id_pedimento) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getMatswith_idped(cpt, Id_pedimento);
    }

    /**
     * Obtiene el stock actual del pedimento de acuerdo a el id del pedimento,
     * el material y dureza
     *
     * @param c
     * @param dp
     * @return
     */
    @Override
    public double getstockactual(Connection c, Dpedimento dp) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getstockactual(c, dp);
    }

}
