/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Materiales;
import Persistencia.sqlmaterial;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daomateriales implements materiales {

    @Override
    public boolean nuevomat(Connection cpt, Connection rcpt, Materiales m) {
        sqlmaterial s = new sqlmaterial();
        return s.Addmaterial(cpt, m);
    }

    @Override
    public ArrayList<Materiales> getmateriales(Connection rcpt, String mat,String turno) {
        sqlmaterial s = new sqlmaterial();
        return s.getallMaterials(rcpt, mat, turno);
    }

    @Override
    public boolean deletemat(Connection cpt, int material) {
        sqlmaterial s = new sqlmaterial();
        return s.deletematerial(cpt, material);
    }

    @Override
    public boolean modmaterial(Connection cpt, Connection rcpt, Materiales m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean nuevomatmaq(Connection cpt, Materiales m) {
        sqlmaterial s = new sqlmaterial();
        return s.Addmaterialmaq(cpt, m);
    }

    @Override
    public ArrayList<Materiales> getmaterialesmaq(Connection rcpt, String mat) {
        sqlmaterial s = new sqlmaterial();
        return s.getallMaterialsmaq(rcpt, mat);
    }

}
