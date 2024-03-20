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
public class DetFichas{
    private int Detficha, ficha, id_tipom, id_pieza, id_material, id_color;
    private float consumo, total;
    private String tipomdesc,piezadesc, materialdesc, colordesc, pzaxpar, observaciones, unidad, estatus;

    public int getDetficha() {
        return Detficha;
    }

    public void setDetficha(int Detficha) {
        this.Detficha = Detficha;
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public int getId_tipom() {
        return id_tipom;
    }

    public void setId_tipom(int id_tipom) {
        this.id_tipom = id_tipom;
    }

    public int getId_pieza() {
        return id_pieza;
    }

    public void setId_pieza(int id_pieza) {
        this.id_pieza = id_pieza;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTipomdesc() {
        return tipomdesc;
    }

    public void setTipomdesc(String tipomdesc) {
        this.tipomdesc = tipomdesc;
    }

    public String getPiezadesc() {
        return piezadesc;
    }

    public void setPiezadesc(String piezadesc) {
        this.piezadesc = piezadesc;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getColordesc() {
        return colordesc;
    }

    public void setColordesc(String colordesc) {
        this.colordesc = colordesc;
    }

    public String getPzaxpar() {
        return pzaxpar;
    }

    public void setPzaxpar(String pzaxpar) {
        this.pzaxpar = pzaxpar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
