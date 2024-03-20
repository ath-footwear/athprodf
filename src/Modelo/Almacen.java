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
public class Almacen {
    private String nombre,tipoalmacen,estaus;
    private int almacen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoalmacen() {
        return tipoalmacen;
    }

    public void setTipoalmacen(String tipoalmacen) {
        this.tipoalmacen = tipoalmacen;
    }

    public String getEstaus() {
        return estaus;
    }

    public void setEstaus(String estaus) {
        this.estaus = estaus;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }
}
