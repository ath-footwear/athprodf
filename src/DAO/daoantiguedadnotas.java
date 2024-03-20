/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Agentes;
import Modelo.AntiguedadNota;
import Modelo.Cliente;
import Persistencia.sqlantiguedadnotas;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * En este dao se utilizara solo esta clase ya que se desconoce si habrá
 * integracion con la principal, entonces, para ahorrar tiempo se ah creado solo
 * una y de ahi acceden las clases de agentes, clientes y la de antiguedad
 *
 * @author GATEWAY1-
 */
public class daoantiguedadnotas implements AntiguedadNotas {

    /**
     * Obtiene todas las notas relacionadas a los agentes y depende de la
     * conexion, ya sea interno o fiscal
     *
     * @param c
     * @param n
     * @param Tipofecha
     * @return
     */
    @Override
    public ArrayList<AntiguedadNota> getantiguedad(Connection c, AntiguedadNota n, String Tipofecha) {
        sqlantiguedadnotas s = new sqlantiguedadnotas();
        return s.getregs(c, n, Tipofecha);
    }

    /**
     * inserta cada uno de los registros en la bd de sqlite
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean newregistros(Connection c, ArrayList<AntiguedadNota> arr) {
        sqlantiguedadnotas s = new sqlantiguedadnotas();
        return s.setrows(c, arr);
    }

    /**
     * Obtiene todos los agentes sin filtro alguno
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<Agentes> getagentes(Connection c) {
        sqlantiguedadnotas s = new sqlantiguedadnotas();
        return s.getagentes(c);
    }

    /**
     * Funcion para vaciar la tabla de sqlite despues del despliegue
     *
     * @param c
     */
    @Override
    public void vaciartabla(Connection c) {
        sqlantiguedadnotas s = new sqlantiguedadnotas();
        s.vaciatabla(c);
    }

    /**
     * Obtiene todos los clientes de acuerdo al agente seleccionado
     *
     * @param c
     * @param agente
     * @return
     */
    @Override
    public ArrayList<Cliente> getclientes(Connection c, String agente) {
        sqlantiguedadnotas s = new sqlantiguedadnotas();
        return s.getclientes(c, agente);
    }

}
