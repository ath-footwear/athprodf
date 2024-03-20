/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ConceptosES;
import Persistencia.sqlconceptos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoConceptos implements conceptos {

    /**
     * Obtiene una lista de conceptos en general pero solo para cpt
     *
     * @param c
     * @return
     */
    @Override
    public ArrayList<ConceptosES> getConceptos(Connection c) {
        sqlconceptos s = new sqlconceptos();
        return s.getConceptosES(c);
    }

    /**
     * Obtiene una lista de Conceptos de acuerdo a la cuenta seleccionada, solo
     * para cpt
     *
     * @param c conexion a cpt
     * @param cuenta int cuenta
     * @return Array de conceptos
     */
    @Override
    public ArrayList<ConceptosES> getConceptos(Connection c, int cuenta) {
        sqlconceptos s = new sqlconceptos();
        return s.getConceptosES(c, cuenta);
    }

    /**
     * Obtiene el conceptodel concepto de acuerdo a la cuenta y subcuenta
     * seleccionada
     *
     * @param c conexion cpt
     * @param cuenta
     * @param subcuenta
     * @return
     */
    @Override
    public ConceptosES getConceptos(Connection c, int cuenta, int subcuenta) {
        sqlconceptos s = new sqlconceptos();
        return s.getConceptosES(c, cuenta, subcuenta);
    }

    /**
     * Obtiene el id dle concepto de acuerdo a la cuenta y subcuenta de cobranza
     * No funciona para cpt
     *
     * @param c cobranza
     * @param cuenta
     * @param subcuenta
     * @return int, id concepto
     */
    @Override
    public int getConceptos_cob(Connection c, int cuenta, int subcuenta) {
        sqlconceptos s = new sqlconceptos();
        return s.getConceptosES_cob(c, cuenta, subcuenta);
    }

}
