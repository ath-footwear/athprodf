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
public class Motivosdev {
    private int idmotivo;
    private String descripcion,estatus,tipodev,stock;

    public String getTipodev() {
        return tipodev;
    }

    public void setTipodev(String tipodev) {
        this.tipodev = tipodev;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(int idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
