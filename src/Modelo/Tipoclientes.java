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
public class Tipoclientes implements java.io.Serializable{
    private int idtipocliente;
    private String Descripcion;

    public int getIdtipocliente() {
        return idtipocliente;
    }

    public void setIdtipocliente(int idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
