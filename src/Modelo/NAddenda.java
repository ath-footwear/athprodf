/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class NAddenda implements java.io.Serializable {

    private factura f;
    private ArrayList<Addenda> arrad;
    private int cajas;
    private int cantidad;
    private ArrayList<String> arrcod;
    private Destinoscoppel dc;
    private String archivo;
    private String prov;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public factura getF() {
        return f;
    }

    public void setF(factura f) {
        this.f = f;
    }

    public ArrayList<Addenda> getArrad() {
        return arrad;
    }

    public void setArrad(ArrayList<Addenda> arrad) {
        this.arrad = arrad;
    }

    public int getCajas() {
        return cajas;
    }

    public void setCajas(int cajas) {
        this.cajas = cajas;
    }

    public ArrayList<String> getArrcod() {
        return arrcod;
    }

    public void setArrcod(ArrayList<String> arrcod) {
        this.arrcod = arrcod;
    }

    public Destinoscoppel getDc() {
        return dc;
    }

    public void setDc(Destinoscoppel dc) {
        this.dc = dc;
    }
}
