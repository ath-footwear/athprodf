/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Controlinventario;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoAbonos implements Int_abonos {

    private final sqlabonos s = new sqlabonos();

    /**
     * Inserta en la bd una nota de cargo "abonando" el importe al saldo y la
     * nota de credito para restarle ese saldo y quede nuevamente en ceros. Se
     * simplifico y todo el proceso se hizo de una.
     *
     * @param cobranza conexion a cobranza
     * @param c Objeti tipo cargo
     * @return boolean para saber si se lelvo a cabo o no
     */
    @Override
    public boolean new_Refacturacion(Connection cobranza, cargo c) {
        return s.new_Refacturacion(cobranza, c);
    }

    /**
     * Inserta en la bd el abono (pago) de una factura, que afecta doctospago,
     * abonos y cargos
     *
     * @param con conexion a cpt
     * @param f factura
     * @param cob conexion de cobranza
     * @return int
     */
    @Override
    public int insertabonostpu(Connection con, factura f, Connection cob) {
        return s.insertabonostpu(con, f, cob);
    }

    /**
     * Obtiene todos los abosnos los abonos
     *
     * @param cob
     * @param i
     *
     * @return
     */
    @Override
    public ArrayList<abono> getabonos_toinventario(Connection cob, Controlinventario i) {
        return s.getabonos_toinv(cob, i);
    }

    /**
     * Inserta en la bd los registros del abono previamente obtenidos
     *
     * @param cob
     * @param arr
     * @return
     */
    @Override
    public boolean Exec_respaldoregs_abono(Connection cob, ArrayList<abono> arr) {
        return s.Exec_respaldoregs_abono(cob, arr);
    }

}
