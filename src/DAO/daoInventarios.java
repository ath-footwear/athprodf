/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Inventario;
import Persistencia.sqlinventarios;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoInventarios implements Inventarios {

    /**
     * Array utlizado para eliminar registros dee los pedimentos y no repetirlos
     * en la captura
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<Inventario> getinventarios(Connection c) {
        sqlinventarios s = new sqlinventarios();
        return s.getallinventarios(c);
    }

    /**
     * Obtiene los registros y despliega reporte de inventarios anteriores
     *
     * @param c
     * @param mes
     * @param year
     * @return
     */
    @Override
    public ArrayList<Inventario> getinventarios(Connection c, int mes, int year) {
        sqlinventarios s = new sqlinventarios();
        return s.getInventarioPasado(c, mes, year);
    }

    /**
     * Insertar en la tabla de inventarios de Sqlite
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean nuevoregistroinv(Connection c, ArrayList<Inventario> arr) {
        sqlinventarios s = new sqlinventarios();
        return s.nuevoregistroinv(c, arr);
    }

    /**
     * Obtiene todos los registros del inventario capturado
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<Inventario> getinventariostocheck(Connection c) {
        sqlinventarios s = new sqlinventarios();
        return s.getallinventariostocheck(c);
    }

    /**
     * Elimina de la bd de sqlite el pedimento completo y no por renglones
     *
     * @param c
     * @param id
     * @return
     */
    @Override
    public boolean deletepedimento(Connection c, int id) {
        sqlinventarios s = new sqlinventarios();
        return s.deletepedimento(c, id);
    }

    /**
     * Reliza el procedimiento para hacer cierre de mes
     *
     * @param c
     * @param lite
     * @param arr
     * @param mes
     * @param year
     * @return
     */
    @Override
    public boolean nuevoinventario(Connection c, Connection lite, ArrayList<Inventario> arr, int mes, int year) {
        sqlinventarios s = new sqlinventarios();
        return s.nuevocierre(c, lite, arr, mes, year);
    }

    /**
     * Ejecuta el respaldo de la bd de tpu, maquinaria y quizas tambien de su cbranza
     *
     * @param c
     * @param mes
     * @param year
     * @param turno
     * @return
     */
    @Override
    public boolean ejecutarespcierre(Connection c, int mes, int year, String turno) {
        sqlinventarios s = new sqlinventarios();
        return s.ejecutarespcierre(c, mes, year, turno);
    }

    /**
     * Actualiza las cantidades de stock de sistema en la tabla de inventariado
     * de sqlite
     * @param c
     * @param inv 
     */
    @Override
    public void updatecantin_inv(Connection c, Inventario inv) {
        sqlinventarios s = new sqlinventarios();
        s.updatecantin_inv(c, inv);
    }

    /**
     * Lo mismo que el inventarios solo que ahora solo es el de cobranza
     * @param c
     * @param mes
     * @param year
     * @param turno
     * @return 
     */
    @Override
    public boolean ejecutarespcierre_cob(Connection c, int mes, int year, String turno) {
        sqlinventarios s = new sqlinventarios();
        return s.ejecutarespcierre_cob(c, mes, year, turno);
    }

}
