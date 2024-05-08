/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Poliza;
import Modelo.Sellofiscal;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import Persistencia.sqlfactura;
import Persistencia.sqlfactura_tpu;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daofactura_tpu implements Facturas_tpu {

    /**
     *
     * @param c
     * @param serie
     * @return folios de series folios
     */
    @Override
    public int getmaxfolio(Connection c, String serie) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getmaxfac(c, serie);
    }

    @Override
    public ArrayList<Poliza> getasientoscontable(Connection concob) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getAsientoscontables(concob);
    }

    /**
     * Obtiene el maximmo folio de acuerdo a la serie
     *
     * @param c
     * @param serie
     * @return
     */
    @Override
    public int getmaxfoliotpu(Connection c, String serie) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getmaxfactpu(c, serie);
    }

    @Override
    public int getbuscafoliotpu(Connection c, String serie, String folio) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.buscafoliotpu(c, serie, folio);
    }

    @Override
    public int nuevafactpu(Connection cpt, factura f, Connection cob) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertfacturatpu(cpt, f, cob);
    }

    @Override
    public boolean actualizacadenatpu(Connection c, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.actualizafacturatpu(c, f);
    }

    /**
     *
     * @param cpt La conexion a cpt para actualizacion, no usar como principal
     * rcpt
     * @param s S es la clase de modelo/Sello ofiscal
     * @param id Es el id del encabezado para actualizar los campos del timbrado
     * @return Regresa Un booleano
     * @see Se utiliza para actualizar los campos faltantes
     */
    @Override
    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id) {
        sqlfactura f = new sqlfactura();
        return f.actualizasellos(cpt, s, id);
    }

    @Override
    public boolean Updatesellofiscaltpu(Connection cpt, Sellofiscal s, int id) {
        sqlfactura_tpu f = new sqlfactura_tpu();
        return f.actualizasellostpu(cpt, s, id);
    }

    @Override
    public ArrayList<cargo> getfactstoFACReltpu(Connection c, String r, String bd) {
        sqlfactura_tpu f = new sqlfactura_tpu();
        return f.getfoliotoFACReltpu(c, r, bd);
    }

    @Override
    public int nuevaremtpu(Connection cpt, factura f, Connection cob) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertremtpu(cpt, f, cob);
    }

    @Override
    public ArrayList<factura> getpedidos(Connection cpt, String folio, String serie) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getpedidos(cpt, folio, serie);
    }

    @Override
    public ArrayList<factura> getdocstpu(Connection cpt, String folio, String serie, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getdocstpu(cpt, folio, serie, bd);
    }

    @Override
    public ArrayList<cargo> getfactsoncrtpu(Connection c, String r, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getfoliotoNCRtpu(c, r, bd);
    }

    @Override
    public ArrayList<ConceptosES> getalcuentastpu(Connection c, String cuenta) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getcuentastpu(c, cuenta);
    }

    @Override
    public int nuevancrtpu(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertncrtpu(c, f, cob, rcpt);
    }

    @Override
    public ArrayList<factura> getdocvspago(Connection cpt, String folio) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getfoliovspago(cpt, Integer.parseInt(folio));
    }

    @Override
    public ArrayList<factura> getdocvspagoall(Connection cpt, int id) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getfoliovspagoall(cpt, id);
    }

    @Override
    public boolean Cancelancr(Connection cpt, Connection cob, ArrayList<factura> f, String fecha, String usuario) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.deletencr(cpt, cob, f, fecha, usuario);
    }

    @Override
    public int insertpagotpu(Connection cpt, Connection cob, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertpagostpu(cpt, f, cob);
    }

    @Override
    public void actualizacadenapagotpu(Connection c, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        s.actualizapagotpu(c, f);
    }

    @Override
    public boolean Updatesellofiscalpagotpu(Connection cpt, Sellofiscal s, int id) {
        sqlfactura_tpu sw = new sqlfactura_tpu();
        return sw.actualizasellotpupago(cpt, s, id);
    }

    @Override
    public ArrayList<factura> getdocpagostpu(Connection cpt, String fol, String serie, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getdocspagostpu(cpt, fol, serie, bd);
    }

    /**
     * Busca una nota de credito o pago de acuerdo al id de la factura
     *
     * @param c
     * @param iddoc
     * @param serie
     * @param bd
     * @return
     */
    @Override
    public ArrayList<factura> searchPagncrtofac(Connection c, int iddoc, String serie, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.searchPagncrtofac(c, iddoc, serie, bd);
    }

    @Override
    public ArrayList<cargo> getfactrem(Connection cobB, String var, String ncob) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getcargosrem(cobB, var, ncob);
    }

    @Override
    public ArrayList<factura> getdocspagosremi(Connection con, String folio) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getdocspagosremi(con, folio);
    }

    @Override
    public int nuevafactpuATH(Connection cpt, factura f, Connection cob, Connection cpttpu, Connection rcpt) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertfacturatpuATH(cpt, f, cob, cpttpu, rcpt);
    }

    @Override
    public ArrayList<factura> getdocxmltpu(Connection cpt, String fol, String serie, String bd) {
        sqlfactura_tpu f = new sqlfactura_tpu();
        return f.getdocsxmltpu(cpt, fol, serie, bd);
    }

    @Override
    public ArrayList<cargo> getfactopagotpu(Connection c, String r, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getfoliotopagotpu(c, r, bd);
    }

    @Override
    public int insertpagotpuPUE(Connection cpt, Connection cob, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertpagostpu(cpt, f, cob);
    }

    /**
     * Obtiene registros del pago de acuerdo al id del documento de pago
     *
     * @param c
     * @param id
     * @param bd
     * @return
     */
    @Override
    public ArrayList<factura> getregspcancelpagotpu(Connection c, int id, String bd, String serie) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getcancelapago(c, id, bd, serie);
    }

    /**
     * Ejecuta modificacion de registros para cancelacion de un pago en tpu
     *
     * @param c
     * @param cob
     * @param arr
     * @return
     */
    @Override
    public boolean execcancelacionPago(Connection c, Connection cob, ArrayList<factura> arr) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.execcancelPago(c, cob, arr);
    }

    /**
     * Ingresa un nuevo cargo especial a la bd
     *
     * @param cob conexion de cobranza fiscal
     * @param f objeto de factura con sus datos necesarios
     * @return boolean
     */
    @Override
    public boolean nuevocargoespecial(Connection cob, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.new_Cargoespecial(cob, f);
    }

    /**
     * Obtiene todos los cargos especiales mediante la conexion de cobranza
     * fiscal y una vaariable que es la del nombre del cliente
     *
     * @param cob conexion cobranza
     * @param var nombre del cliente
     * @return lista de cargo
     */
    @Override
    public ArrayList<cargo> getcargosespecial(Connection cob, String var) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getcargosespecial(cob, var);
    }

    /**
     * Trae los cargos especiales de acuerdo al cliente
     *
     * @param cob conexion a cobranza
     * @param cliente id del cliente
     * @return Lista de cargos
     */
    @Override
    public ArrayList<cargo> getcargos_especialwithcliente(Connection cob, String cliente) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getcargos_especialwithcliente(cob, cliente);
    }

    /**
     * Agrega un nuevo pago a la bd, esto inserta campos en doctospago, abonos y
     * afecto el saldo del cargo
     *
     * @param cpt conexion hacia cpt ya que necesita hacer consultos a doctos
     * @param cob conexion a cobranza
     * @param f El pago
     * @return int
     */
    @Override
    public int insertpagotpu_especial(Connection cpt, Connection cob, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertpagostpu_especial(cpt, f, cob);
    }

    /**
     * Busca los pagos realizados de acuerdo al nombre del cliente
     *
     * @param cpt conexion a cpt
     * @param cliente nombre del cliente
     * @return Lista de pagos realizados
     */
    @Override
    public ArrayList<factura> getpagostpu_especial(Connection cpt, String cliente) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getpagos_especial(cpt, cliente);
    }

    /**
     * Obtiene los registros del cargo y abono para poder darlos de baja y
     * ademas regresar el saldo del pago a cada cargo
     *
     * @param con conexion de cpt
     * @param pago id del documento de pago
     * @param bd String de la bd de cobranza
     * @return lista de abonos
     */
    @Override
    public ArrayList<abono> getpagos_especial_tocancel(Connection con, int pago, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.getpagos_especial_tocancel(con, pago, bd);
    }

    /**
     * Cancela el documento y abonos ademas de regresar los saldos pertinentes
     * tras la cancelacion de dicho movimiento
     *
     * @param cpt Conexion de cpt
     * @param cob COnexion de cobranza
     * @param arr Lista de abonos con cargos y saldos
     * @return booleano
     */
    @Override
    public boolean Cancela_pagoespecial(Connection cpt, Connection cob, ArrayList<abono> arr) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.Cancela_pagoespecial(cpt, cob, arr);
    }

    /**
     * Verifica que el cargo no tenga abonos realizados
     *
     * @param cob conexion de cobranza
     * @param cargo id del cargo
     * @return booelano
     */
    @Override
    public boolean checkcargoespecial_tocancel(Connection cob, int cargo) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.checkcargoespecial_tocancel(cob, cargo);
    }

    /**
     * Cancela el cargo especial seleccionado
     *
     * @param cob conexion de cobranza
     * @param cargo id del cargo
     * @return booelano
     */
    @Override
    public boolean Cancela_cargoespecial(Connection cob, int cargo) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.Cancela_cargoespecial(cob, cargo);
    }

    /**
     * Ingresa al sistema una nueva factura pero especial, significa que no
     * afecta a stock pero si genera un cargo en cargoespecial, por lo tanto su
     * pago seria en abonos especiales
     *
     * @param cpt conexion de cpt
     * @param f factura
     * @param cob conexion de cobranza
     * @return Id del documento
     */
    @Override
    public int nuevafactpu_Especial(Connection cpt, factura f, Connection cob) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.insertfacturatpu_Especial(cpt, f, cob);
    }

    /**
     * Actualiza la cadena original, el sello y certificado
     *
     * @param c
     * @param f
     */
    @Override
    public void actualizacadenapagotpu_E(Connection c, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        s.actualizapagotpuE(c, f);
    }

    /**
     * Actualiza datos del pago de los datos recibidos del timbrado
     *
     * @param cpt conexion cpt
     * @param s Objeto Sellofiscal
     * @param id id del pago
     * @return
     */
    @Override
    public boolean Updatesellofiscalpagotpu_E(Connection cpt, Sellofiscal s, int id) {
        sqlfactura_tpu sw = new sqlfactura_tpu();
        return sw.actualizasellotpupago_E(cpt, s, id);
    }

    /**
     * Valida que no haya Documentos dependientes de la factura, solo aplica en
     * la cancelacio especial
     *
     * @param c
     * @param iddoc
     * @param serie
     * @param bd
     * @return
     */
    @Override
    public ArrayList<factura> searchPagncrtofac_Especial(Connection c, int iddoc, String serie, String bd) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.searchPagncrtofac_Especial(c, iddoc, serie, bd);
    }

    /**
     * Realiza la cancelacion de los registros sobre la factura, solo aplica en
     * la cancelacion especial
     *
     * @param cpt
     * @param cob
     * @param f
     * @return
     */
    @Override
    public boolean Cancelafactura_Especial(Connection cpt, Connection cob, factura f) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.Cancelafactura_Especial(cpt, cob, f);
    }

    /**
     * Actualiza los datos de la tabla de documento por si el cliente durante el
     * proceso de facturacion o desconocimiento sufrio algun cambio fiscal
     *
     * @param con
     * @param c
     * @param id_documento
     * @return
     */
    @Override
    public boolean updateclientefacv2_TPU(Connection con, Cliente c, int id_documento) {
        sqlfactura_tpu s = new sqlfactura_tpu();
        return s.updateclientedoc_TPU(con, c, id_documento);
    }

    /**
     * Obtiene cargos especiales solo para la relacion de factura
     * @param c
     * @param r
     * @param bd
     * @return 
     */
    @Override
    public ArrayList<cargo> getfactstoFACReltpu_E(Connection c, String r, String bd) {
        sqlfactura_tpu f = new sqlfactura_tpu();
        return f.getfoliotoFACReltpu_E(c, r, bd);
    }
}
