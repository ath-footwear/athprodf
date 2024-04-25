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
import Modelo.Kardex;
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

    public int nuevafactpuATH(Connection cpt, factura f, Connection cob, Connection cpttpu, Connection rcpt);

    public int nuevafacE(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    public Conexiones nuevafacEconex(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    public int nuevafacTraslado(Connection cpt, Connection rcpt, factura f);// factura y generar xml

    public ArrayList<factura> getfacs(Connection c, String folio);//despliegue de facturas

    public factura getfac(Connection c, String folio);//despliegue de facturas

    public int getmaxfolio(Connection c);

    public int getmaxtraslado(Connection c);

    public int getmaxfolio(Connection c, String serie);

    public int getbuscafolio(Connection c, String serie);

    public int getbuscafolioncr(Connection c, String serie);

    public void actualizacadena(Connection c, factura f);

    public void actualizacadenapago(Connection c, factura f);

    public int getmaxncr(Connection c);

    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta);

    public ArrayList<ConceptosES> getalcuentastpu(Connection c, String cuenta);

    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd);

    public int nuevancr(Connection c, factura f, Connection cob, Connection rcpt);// ncr y generar xml

    public ArrayList<abono> getabonospago(Connection c, String op, String bd, int cuenta);

    public int nuevopago(Connection c, factura f, String cob);// pago y generar xml

    public int getmaxPago(Connection c);

    public ArrayList<factura> getdoc(Connection cpt, String fol, String serie, String empcobranza);

    public ArrayList<factura> getdocpagos(Connection cpt, String fol, String serie, String empcobranza);

    public ArrayList<factura> getdocxml(Connection cpt, String fol, String serie, String empcobranza);

    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id);

    public boolean Updatesellofiscalpago(Connection cpt, Sellofiscal s, int id);

    public ArrayList<Cliente> getClienteface(Connection cob, String ncliente);

    public ArrayList<cargo> getfactstoFACRel(Connection c, String r, String bd);

    public void cancelafac(Connection cpt, Connection rcpt, Connection cobranza, factura f);

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
    
    public ArrayList<factura> getfactwithserie(Connection rcpt, String ncobranza, String serie);
    
    public ArrayList<Dfactura> getfactwithseriedetallado(Connection rcpt, String factura, int año);

    public boolean updateclientefacv2(Connection con, Cliente c, int id_documento);

    public int getAbonosByFactura(Connection cobranza, String factura);

    public Object getFechaCargo(Connection cobranza, String factura);

    public ArrayList<Dfactura> getDetalleFactura(Connection cpt, String factura);

    public int getTipoFactura(Connection cpt, int factura);
    
    public boolean cancelarFacturaEspecial(Connection cpt, Connection rcpt, factura f, abono a);
    
    public boolean cancelarFacturaNormal(Connection cpt, Connection rcpt, factura f, abono a, ArrayList<Kardex> data);
    
    public boolean cancelarFacturaNormal(Connection cpt, Connection rcpt, factura f, abono a);
    
    public boolean cancelarPago(Connection cpt, int folio, String referencia,int cliente);
    
    public ArrayList<String> getOrdenPago(Connection cpt, int folio);
    
    public ArrayList<String>getClienteCargo(Connection cobranza, String factura);
}