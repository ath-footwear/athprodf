/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Conexiones;
import Modelo.Dfactura;
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
public interface Facturas {

    public int nuevafac(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    /**
     * Especificamente para generar registros y xml de tpu
     *
     * @param cpt
     * @param f
     * @param cob
     * @return
     */
    public int nuevafactpu(Connection cpt, factura f, Connection cob);
    
    public int nuevafactpu_Especial(Connection cpt, factura f, Connection cob);
    
    public int nuevafactpuATH(Connection cpt, factura f, Connection cob, Connection cpttpu, Connection rcpt);

    public int nuevaremtpu(Connection cpt, factura f, Connection cob);

    /**
     *
     * @param c Conexion cpt
     * @param f Objeto de factura con lo necesario para insertar y generar xml
     * @param cob
     * @param rcpt
     * @return
     */
    public int nuevafacE(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    public Conexiones nuevafacEconex(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    public int nuevafacTraslado(Connection cpt, Connection rcpt, factura f);// factura y generar xml

    public ArrayList<factura> getfacs(Connection c, String folio);//despliegue de facturas

    public factura getfac(Connection c, String folio);//despliegue de facturas

    public int getmaxfolio(Connection c);

    /**
     * Trae el ultimo folio del traslado de la tabla de documentos solamente
     *
     * @param c Conexion de cpt
     * @return
     */
    public int getmaxtraslado(Connection c);

    /**
     *
     * @param c
     * @param serie
     * @return
     */
    public int getmaxfolio(Connection c, String serie);

    public int getbuscafolio(Connection c, String serie);

    public int getbuscafoliotpu(Connection c, String serie, String folio);

    public int getmaxfoliotpu(Connection c, String serie);

    public int getbuscafolioncr(Connection c, String serie);

    public void actualizacadena(Connection c, factura f);

    public boolean actualizacadenatpu(Connection c, factura f);

    public void actualizacadenapago(Connection c, factura f);
    
    public void actualizacadenapagotpu(Connection c, factura f);

    public int getmaxncr(Connection c);

    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta);
    
    public ArrayList<ConceptosES> getalcuentastpu(Connection c, String cuenta);

    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd);
    
    public ArrayList<cargo> getfactsoncrtpu(Connection c, String r, String bd);
    
    public ArrayList<cargo> getfactopagotpu(Connection c, String r, String bd);

    /**
     *
     * @param c
     * @param f
     * @param cob
     * @param rcpt
     * @return
     */
    public int nuevancr(Connection c, factura f, Connection cob, Connection rcpt);// ncr y generar xml
    
    public int nuevancrtpu(Connection c, factura f, Connection cob, Connection rcpt);

    public ArrayList<abono> getabonospago(Connection c, String op, String bd, int cuenta);

    public int nuevopago(Connection c, factura f, String cob);// pago y generar xml

    public int getmaxPago(Connection c);

    public ArrayList<factura> getdoc(Connection cpt, String fol, String serie, String empcobranza);

    public ArrayList<factura> getdocpagos(Connection cpt, String fol, String serie, String empcobranza);
    
    public ArrayList<factura> getdocpagostpu(Connection cpt, String fol, String serie, String bd);
    
    public ArrayList<factura> getdocxml(Connection cpt, String fol, String serie, String empcobranza);
    
    public ArrayList<factura> getdocxmltpu(Connection cpt, String fol, String serie, String bd);

    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscaltpu(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscalpago(Connection cpt, Sellofiscal s, int id);
    
        public boolean Updatesellofiscalpagotpu(Connection cpt, Sellofiscal s, int id);

    public ArrayList<Cliente> getClienteface(Connection cob, String ncliente);

    /**
     *
     * @param c conexion a cpt
     * @param r Id o nombre del cliente
     * @param bd Nombre de bd a cobranza
     * @return
     */
    public ArrayList<cargo> getfactstoFACRel(Connection c, String r, String bd);

    public ArrayList<cargo> getfactstoFACReltpu(Connection c, String r, String bd);

    /**
     *
     * @param cpt
     * @param rcpt
     * @param cobranza
     * @param f
     */
    public void cancelafac(Connection cpt, Connection rcpt, Connection cobranza, factura f);

    /**
     *
     * @param concob
     * @return
     */
    public ArrayList<Poliza> getasientoscontable(Connection concob);

    /**
     * Funcion para actualizar por rango de folios el numero de pedido
     *
     * @param rcpt Conexion de rcpt
     * @param cpt Conexion cpt
     * @param folio folio inicial
     * @param foliof Folio final
     * @param pedido
     * @return
     */
    public boolean actualizapedidos(Connection rcpt, Connection cpt, int folio, int foliof, String pedido);

    /**
     * Actualiza el paquete de acuerdo a la factura
     *
     * @param rcpt
     * @param cpt Conexiones para la bd
     * @param paquete Paquete para addenda
     * @param folio folio de la factura
     * @return
     */
    public boolean setpaquetefact(Connection rcpt, Connection cpt, int paquete, int folio);

    /**
     * 
     * @param cpt
     * @param folio
     * @param serie
     * @return 
     */
    public ArrayList<factura> getpedidos(Connection cpt, String folio, String serie);
    
    public ArrayList<factura> getdocstpu(Connection cpt, String folio, String serie, String bd);
    
    public ArrayList<factura> getdocspagosremi(Connection con, String folio);
    
    public ArrayList<factura> getdocvspago(Connection cpt, String folio);
    
    public ArrayList<factura> getdocvspagoall(Connection cpt, int id);
    
    public boolean Cancelancr(Connection cpt, Connection cob, ArrayList<factura> f, String fecha, String usuario);
    
    public int insertpagotpu(Connection cpt, Connection cob, factura f);
    
    public int insertpagotpuPUE(Connection cpt, Connection cob, factura f);
    
    public ArrayList<factura> getfactwithserie(Connection rcpt, String ncobranza, String serie);
    
    public ArrayList<Dfactura> getfactwithseriedetallado(Connection rcpt, String factura, int año);
    
    public boolean updateclientefacv2(Connection con, Cliente c, int id_documento);
    
    public ArrayList<factura> searchPagncrtofac(Connection c, int iddoc, String serie, String bd);
    
    public ArrayList<cargo> getfactrem(Connection cobB, String var, String ncob);
    
    public ArrayList<factura> getregspcancelpagotpu(Connection c, int id, String bd);
    
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
    
}
