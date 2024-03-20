/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ProveedorMPrima;
import Persistencia.sqlproveedores;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoProveedores implements proveedor {

    @Override
    public boolean nuevoprov(Connection rcpt, Connection cpt, ProveedorMPrima p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteprov(Connection rcpt, Connection cpt, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateprov(Connection rcpt, Connection cpt, ProveedorMPrima p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProveedorMPrima> getallprov(Connection c, String p) {
        sqlproveedores s = new sqlproveedores();
        return s.getallprovs(c, p);
    }

    @Override
    public boolean nuevoprovtpu(Connection cpt, ProveedorMPrima p) {
        sqlproveedores s = new sqlproveedores();
        return s.nuevoprovtpu(cpt, p);
    }

    @Override
    public boolean updateestatus(Connection cpt, int id, String estatus) {
        sqlproveedores s = new sqlproveedores();
        return s.updateestatus(cpt, id, estatus);
    }



}
