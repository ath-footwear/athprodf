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
public class Departamentos_Prod implements java.io.Serializable{
    private String descripcion;
    private int id_prod,lineaprod;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getLineaprod() {
        return lineaprod;
    }

    public void setLineaprod(int lineaprod) {
        this.lineaprod = lineaprod;
    }
}
