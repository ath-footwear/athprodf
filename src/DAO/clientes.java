/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface clientes {

    public ArrayList<Cliente> getClientes(Connection c);

    public ArrayList<Cliente> getClientestpu(Connection c);

    public ArrayList<Cliente> getClientestpuall(Connection c, String cli);

    public Cliente getCliente(Connection c, int id);

    public Cliente getClientes(Connection c, int cliente);

    public boolean importacliente(Connection c, Cliente cli);

    public boolean modcliente(Connection cpt, Cliente cli);

    public boolean nuevocliente(Connection cpt, Cliente cli);

    public int maxcliente(Connection cob);

    public boolean exist_cliente(Connection con, Cliente c);

    public Cliente getClientetpu(Connection c, int id);
    
    public ArrayList<Cliente> getfoliotopagotpu_Clientes(Connection con, String nombre, String bd);
    
    public ArrayList<Cliente> getfoliotopagotpu_Clientes_REM(Connection con, String nombre);

}
