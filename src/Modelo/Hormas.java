/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GATEWAY1-
 */
public class Hormas implements java.io.Serializable {
    private String descripcion;
    private int horma;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHorma() {
        return horma;
    }

    public void setHorma(int horma) {
        this.horma = horma;
    }
}
