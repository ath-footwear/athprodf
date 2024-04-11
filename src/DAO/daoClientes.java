/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Persistencia.sqlclientes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoClientes implements clientes {

    /**
     * Obtiene el listado de clientes, solo con ATH/UPTOWN, no aplica en TPU
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<Cliente> getClientes(Connection c) {
        sqlclientes s = new sqlclientes();
        return s.getClientes(c);
    }

    /**
     * Obtiene los datos del cliente, de acuerdo a su numero de cliente, no
     * aplica en TPU
     *
     * @param c Conexion cobranza
     * @param id id del cliente
     * @return
     */
    @Override
    public Cliente getCliente(Connection c, int id) {
        sqlclientes s = new sqlclientes();
        return s.getCliente(c, id);
    }

    /**
     * Funcion para obtener el cliente e importarlo a tpu o maq no aplica para
     * RCPT's
     *
     * @param c
     * @param cliente
     * @return
     */
    @Override
    public Cliente getClientes(Connection c, int cliente) {
        sqlclientes s = new sqlclientes();
        return s.getClientes(c, cliente);
    }

    /**
     * Funcion para importar a la bd el cliente de cobranza, claramente ya debe
     * de estar validado y que los datos del cliente sean correctos
     *
     * @param c
     * @param cli
     * @return
     */
    @Override
    public boolean importacliente(Connection c, Cliente cli) {
        sqlclientes s = new sqlclientes();
        return s.importacliente(c, cli);
    }

    /**
     * Obtiene todos los clientes de tpu, claro, para que se puedan obtener es
     * necesario que esten activos, si no,no entraran en la lista
     *
     * @param c conexion de A o B, depende el tipo de cliente que se requiera
     * @return
     */
    @Override
    public ArrayList<Cliente> getClientestpu(Connection c) {
        sqlclientes s = new sqlclientes();
        return s.getClientestpu(c);
    }

    /**
     * Obtiene el lista de clientes, de los cuales sean parecidos o contengan
     * algo similar de la variable "cli"
     *
     * @param c
     * @param cli
     * @return
     */
    @Override
    public ArrayList<Cliente> getClientestpuall(Connection c, String cli) {
        sqlclientes s = new sqlclientes();
        return s.getClientestpuall(c, cli);
    }

    /**
     * Actualizacion de datos del cliente
     *
     * @param cpt
     * @param cli
     * @return
     */
    @Override
    public boolean modcliente(Connection cpt, Cliente cli) {
        sqlclientes s = new sqlclientes();
        return s.modcliente(cpt, cli);
    }

    /**
     * Inserta un nuevo cliente en la bd ya sea interno o fiscal
     *
     * @param cpt
     * @param cli
     * @return
     */
    @Override
    public boolean nuevocliente(Connection cpt, Cliente cli) {
        sqlclientes s = new sqlclientes();
        return s.nuevocliente(cpt, cli);
    }

    /**
     * Obtiene el id maximo de la tabla de clientes
     *
     * @param cob
     * @return
     */
    @Override
    public int maxcliente(Connection cob) {
        sqlclientes s = new sqlclientes();
        return s.maxcliente(cob);
    }

    /**
     * Busca si existe el clente y regresa un boleana validando si existe o no
     *
     * @param con conexion cobranza
     * @param c objeto cliente
     * @return
     */
    @Override
    public boolean exist_cliente(Connection con, Cliente c) {
        sqlclientes s = new sqlclientes();
        return s.exist_cliente(con, c);
    }

    /**
     * Obtiene los datos del cliente pero de tpu,maq etc, lo que no este ligado
     * con rcpt o athletic/uptown, funcion generalmente utilizada para obtener
     * los datos discales, mas sin embargo si es necesario mas campos solo
     * añadirlos
     *
     * @param c
     * @param id
     * @return
     */
    @Override
    public Cliente getClientetpu(Connection c, int id) {
        sqlclientes s = new sqlclientes();
        return s.getClientetpu(c, id);
    }

}
