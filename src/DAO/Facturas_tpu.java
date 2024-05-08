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
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Facturas_tpu {

    public int nuevafactpu(Connection cpt, factura f, Connection cob);

    public int nuevafactpu_Especial(Connection cpt, factura f, Connection cob);

    public int nuevafactpuATH(Connection cpt, factura f, Connection cob, Connection cpttpu, Connection rcpt);

    public int nuevaremtpu(Connection cpt, factura f, Connection cob);

    /**
     * Obtiene el folio siguiente para el tipo de documento
     *
     * @param c
     * @param serie
     * @return
     */
    public int getmaxfolio(Connection c, String serie);

    public int getbuscafoliotpu(Connection c, String serie, String folio);

    public int getmaxfoliotpu(Connection c, String serie);

    public boolean actualizacadenatpu(Connection c, factura f);

    public void actualizacadenapagotpu(Connection c, factura f);

    public void actualizacadenapagotpu_E(Connection c, factura f);

    public ArrayList<ConceptosES> getalcuentastpu(Connection c, String cuenta);

    public ArrayList<cargo> getfactsoncrtpu(Connection c, String r, String bd);

    public ArrayList<cargo> getfactopagotpu(Connection c, String r, String bd);

    public int nuevancrtpu(Connection c, factura f, Connection cob, Connection rcpt);

    public ArrayList<factura> getdocpagostpu(Connection cpt, String fol, String serie, String bd);

    public ArrayList<factura> getdocxmltpu(Connection cpt, String fol, String serie, String bd);
    
    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscaltpu(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscalpagotpu(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscalpagotpu_E(Connection cpt, Sellofiscal s, int id);

    public ArrayList<cargo> getfactstoFACReltpu(Connection c, String r, String bd);
    
    public ArrayList<cargo> getfactstoFACReltpu_E(Connection c, String r, String bd);

    public ArrayList<Poliza> getasientoscontable(Connection concob);

    public ArrayList<factura> getpedidos(Connection cpt, String folio, String serie);

    public ArrayList<factura> getdocstpu(Connection cpt, String folio, String serie, String bd);

    public ArrayList<factura> getdocspagosremi(Connection con, String folio);

    public ArrayList<factura> getdocvspago(Connection cpt, String folio);

    public ArrayList<factura> getdocvspagoall(Connection cpt, int id);

    public boolean Cancelancr(Connection cpt, Connection cob, ArrayList<factura> f, String fecha, String usuario);

    public int insertpagotpu(Connection cpt, Connection cob, factura f);

    public int insertpagotpuPUE(Connection cpt, Connection cob, factura f);

    public boolean updateclientefacv2_TPU(Connection con, Cliente c, int id_documento);

    public ArrayList<factura> searchPagncrtofac(Connection c, int iddoc, String serie, String bd);

    public ArrayList<factura> searchPagncrtofac_Especial(Connection c, int iddoc, String serie, String bd);

    public ArrayList<cargo> getfactrem(Connection cobB, String var, String ncob);

    public ArrayList<factura> getregspcancelpagotpu(Connection c, int id, String bd, String serie);

    public boolean execcancelacionPago(Connection c, Connection cob, ArrayList<factura> arr);

    public boolean nuevocargoespecial(Connection cob, factura f);

    public ArrayList<cargo> getcargosespecial(Connection cob, String var);

    public ArrayList<cargo> getcargos_especialwithcliente(Connection cob, String cliente);

    public int insertpagotpu_especial(Connection cpt, Connection cob, factura f);

    public ArrayList<factura> getpagostpu_especial(Connection cpt, String cliente);

    public ArrayList<abono> getpagos_especial_tocancel(Connection con, int pago, String bd);

    public boolean Cancela_pagoespecial(Connection cpt, Connection cob, ArrayList<abono> arr);

    public boolean checkcargoespecial_tocancel(Connection cob, int cargo);

    public boolean Cancela_cargoespecial(Connection cob, int cargo);

    public boolean Cancelafactura_Especial(Connection cpt, Connection cob, factura f);
}