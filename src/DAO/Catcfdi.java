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
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Catcfdi {

    public ArrayList<Formadepago> getFormadepago(Connection c);

    public ArrayList<Paises> getPaises(Connection c);

    public ArrayList<Zonas> getZonas(Connection c);

    public ArrayList<Embarques> getEmbarques(Connection c);

    public ArrayList<Tipoclientes> gettclientes(Connection c);

    public ArrayList<Agentes> getAgentes(Connection c);

    public ArrayList<Marcas> getMarcas(Connection c);

    public ArrayList<metodopago> getMetodopago(Connection c);

    public ArrayList<usocfdi> getusocfdi(Connection c);

    public ArrayList<relacion> getrelacion(Connection c);

    public boolean getclave(Connection c, String clave);

    public boolean getunidad(Connection c, String clave);

    public String getdescunidad(Connection c, String clave);

    public String getRegimenxuso(Connection c, String regimen, String uso);
    
    public ArrayList<Unidades> getunidades(Connection c);
    
    public ArrayList<Claveprov> getclaveprod(Connection c);
    
    public ArrayList<Claveprov> getclaveprod(Connection c,String n);

}
