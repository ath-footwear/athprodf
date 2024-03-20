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
public class Claveprov implements java.io.Serializable{
    private String claveprod, descripcion;

    public String getClaveprod() {
        return claveprod;
    }

    public void setClaveprod(String claveprod) {
        this.claveprod = claveprod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
