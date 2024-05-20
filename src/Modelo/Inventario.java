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
public class Inventario implements java.io.Serializable {

    private int id_pedimento, id_dpedimento, id_material, mes, years,
            InOut_C, renglon, folio, almacen;
    private String dureza, nombre, referencia, exec_movs, fecha, usuario;
    private double cantidad, cantidadpedimento, diferencias, costo, precio;

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getInOut_C() {
        return InOut_C;
    }

    public void setInOut_C(int InOut_C) {
        this.InOut_C = InOut_C;
    }

    public String getExec_movs() {
        return exec_movs;
    }

    public void setExec_movs(String exec_movs) {
        this.exec_movs = exec_movs;
    }

    public double getDiferencias() {
        return diferencias;
    }

    public void setDiferencias(double diferencias) {
        this.diferencias = diferencias;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getCantidadpedimento() {
        return cantidadpedimento;
    }

    public void setCantidadpedimento(double cantidadpedimento) {
        this.cantidadpedimento = cantidadpedimento;
    }

    public int getId_pedimento() {
        return id_pedimento;
    }

    public void setId_pedimento(int id_pedimento) {
        this.id_pedimento = id_pedimento;
    }

    public int getId_dpedimento() {
        return id_dpedimento;
    }

    public void setId_dpedimento(int id_dpedimento) {
        this.id_dpedimento = id_dpedimento;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
