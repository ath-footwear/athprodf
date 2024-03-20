/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Agentes;
import Modelo.Ciudades;
import Modelo.Claveprov;
import Modelo.Embarques;
import Modelo.Estados;
import Modelo.Formadepago;
import Modelo.Marcas;
import Modelo.Paises;
import Modelo.Tipoclientes;
import Modelo.Unidades;
import Modelo.Zonas;
import Modelo.metodopago;
import Modelo.relacion;
import Modelo.usocfdi;
import Persistencia.sqlcatcfdi;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daocfdi implements Catcfdi {

//    @Override
    public ArrayList<Formadepago> getFormadepago(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        ArrayList<Formadepago> arr = s.getFormadepago(c);
        return arr;
    }

    @Override
    public ArrayList<Paises> getPaises(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        ArrayList<Paises> arr = s.getPaises(c);
        return arr;
    }

    @Override
    public ArrayList<Zonas> getZonas(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getZonas(c);
    }

    @Override
    public ArrayList<Embarques> getEmbarques(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getEmbarques(c);
    }

    @Override
    public ArrayList<Tipoclientes> gettclientes(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getTipoclientes(c);
    }

    @Override
    public ArrayList<Agentes> getAgentes(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Marcas> getMarcas(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<metodopago> getMetodopago(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        ArrayList<metodopago> arr = s.getmetodopago(c);
        return arr;
    }

    @Override
    public ArrayList<usocfdi> getusocfdi(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        ArrayList<usocfdi> arr = s.getusocfdi(c);
        return arr;
    }

    @Override
    public ArrayList<relacion> getrelacion(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getrelacion(c);
    }

    /**
     * 
     * @param c
     * sql cfdi lite
     * @param clave
     * clave proveedor
     * @return 
     */
    @Override
    public boolean getclave(Connection c, String clave) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getClaves(c, clave);
    }

    /**
     * 
     * @param c
     * sql cfdi lite
     * @param clave
     * unidad
     * @return 
     */
    @Override
    public boolean getunidad(Connection c, String clave) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getunidades(c, clave);
    }

    /**
     * 
     * @param c
     * @param clave
     * @return 
     */
    @Override
    public String getdescunidad(Connection c, String clave) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getDescunidad(c, clave);
    }

    /**
     * 
     * @param c
     * @param regimen
     * @param uso
     * @return 
     */
    @Override
    public String getRegimenxuso(Connection c, String regimen, String uso) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getregimenxuso(c, regimen, uso);
    }

    @Override
    public ArrayList<Unidades> getunidades(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getunidades(c);
    }

    @Override
    public ArrayList<Claveprov> getclaveprod(Connection c) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getclavesprods(c);
    }

    @Override
    public ArrayList<Claveprov> getclaveprod(Connection c, String n) {
        sqlcatcfdi s = new sqlcatcfdi();
        return s.getclavesprods(c,n);
    }






}
