/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Documentoscpt;
import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Documentos {
    public ArrayList<Documentoscpt> getdocs(Connection c);
    public Documentoscpt getdocs(Connection c,int var);
    public boolean modcaja(Connection c, Documentoscpt d);
    public boolean modtotales(Connection c, Documentoscpt d);
}
