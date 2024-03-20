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
public class Paises implements java.io.Serializable{
    private int id_pais;
    private String descripcion, descorta;
    private ArrayList<Estados> arrestados = new ArrayList<>();


    public ArrayList<Estados> getArrestados() {
        return arrestados;
    }

    public void setArrestados(ArrayList<Estados> arrestados) {
        this.arrestados = arrestados;
    }


    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescorta() {
        return descorta;
    }

    public void setDescorta(String descorta) {
        this.descorta = descorta;
    }
    
}
