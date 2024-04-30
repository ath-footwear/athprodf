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
public class Tipo_pagos implements java.io.Serializable {
    //Forma de pago
    private String fp;
    //Suma de importes de facturas seleccionadas
    private double importe;
    //Tipo de cambio
    private double tipocambio;
    //Metodo de pago
    private String mp;
    //Lista de facturas seleccionadas
    private ArrayList<cargo> arrcargos = new ArrayList<>();

    public ArrayList<cargo> getArrcargos() {
        return arrcargos;
    }

    public void setArrcargos(ArrayList<cargo> arrcargos) {
        this.arrcargos = arrcargos;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }
}
