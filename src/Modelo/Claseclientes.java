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
public class Claseclientes implements java.io.Serializable{
    private int idclasecliente;
    private String Descripcion;

    public int getIdclasecliente() {
        return idclasecliente;
    }

    public void setIdclasecliente(int idclasecliente) {
        this.idclasecliente = idclasecliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
