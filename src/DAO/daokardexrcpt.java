/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Kardex;
import Modelo.KardexCmp;
import Modelo.Kardexrcpt;
import Persistencia.sqlkardex;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daokardexrcpt implements kardexrcpt {

    @Override
    public boolean nuevokardex(Connection c, Kardexrcpt k) {
        sqlkardex s = new sqlkardex();
        return s.insertkardex(c, k);
    }

    @Override
    public ArrayList<Kardexrcpt> getkardex(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Kardexrcpt> getkardex(Connection c, Kardexrcpt k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int maxkardex(Connection c) {
        sqlkardex s = new sqlkardex();
        return s.getmaxkardex(c);
    }

    @Override
    public int maxpedido(Connection c) {
        sqlkardex s = new sqlkardex();
        return s.getmaxped(c);
    }

    @Override
    public ArrayList<Kardexrcpt> getkardexfac(Connection c, String r, String cob) {
        sqlkardex s = new sqlkardex();
        return s.getkardexfac(c, r, cob);
    }

    @Override
    public ArrayList<Kardexrcpt> getkardexfacsimple(Connection c, String r, String cob) {
        sqlkardex s = new sqlkardex();
        return s.getkardexfacsimple(c, r, cob);
    }

    /**
     *
     * @param c Conexion rcpt
     * @param cob Nombre de la bd de cobranza
     * @param folios Folios a utilizar
     * @return
     */
    @Override
    public ArrayList<Kardexrcpt> getkardexfacMulti(Connection c, String cob, String folios) {
        sqlkardex s = new sqlkardex();
        return s.getkardexfacMulti(c, cob, folios);
    }

    @Override
    public int maxkardexsincuenta(Connection c) {
        sqlkardex s = new sqlkardex();
        return s.getmaxkardexsincuenta(c);
    }

    @Override
    public boolean nuevokardextpu(Connection c, ArrayList<KardexCmp> k) {
        sqlkardex s = new sqlkardex();
        return s.insertkardextpu(c, k);
    }

    /**
     *
     * @param c
     * @param serie serie del movimiento
     * @param cob valor que va a tomar para usar la bd de clientes
     * @param tipo la cuenta, si es salida o entrada
     * @param var
     * @return
     */
    @Override
    public ArrayList<KardexCmp> getkardex(Connection c, String serie, String cob, String tipo, String var) {
        sqlkardex s = new sqlkardex();
        return s.getkardex(c, serie, cob, tipo, var);
    }

    /**
     * Funcion para la cencalacion de una salida
     *
     * @param c
     * @param k
     * @param concepto
     * @param fecha
     * @return
     */
    @Override
    public boolean deleterow(Connection c, KardexCmp k) {
        sqlkardex s = new sqlkardex();
        return s.deleterow(c, k);
    }

    /**
     * Insertar kardex por cancelacion
     *
     * @param cpt
     * @param data
     * @return
     */
    public boolean insertarKardexCancelacionAbono(Connection cpt, ArrayList<Kardex> data) {
        sqlkardex s = new sqlkardex();
        return s.insertarKardexCancelacionAbono(cpt, data);
    }

    /**
     * Obtener folio de cancelacio
     *
     * @param cpt
     * @return
     */
    public int getFolioCancelacion(Connection cpt) {
        sqlkardex s = new sqlkardex();
        return s.getFolioCancelacion(cpt);
    }

}
