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
public class Materiales implements java.io.Serializable{
    private String descripcion,codigo,codigosat,unidad, materialpedimento,dureza,moneda,noserie, imag1,imag2,imag3,
            marca,estatus, tipo_maquina;
    private int id_material, id_familia, id_almacen;
    private double precio, costo, cantidad;

    public String getTipo_maquina() {
        return tipo_maquina;
    }

    public void setTipo_maquina(String tipo_maquina) {
        this.tipo_maquina = tipo_maquina;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNoserie() {
        return noserie;
    }

    public void setNoserie(String noserie) {
        this.noserie = noserie;
    }

    public String getImag1() {
        return imag1;
    }

    public void setImag1(String imag1) {
        this.imag1 = imag1;
    }

    public String getImag2() {
        return imag2;
    }

    public void setImag2(String imag2) {
        this.imag2 = imag2;
    }

    public String getImag3() {
        return imag3;
    }

    public void setImag3(String imag3) {
        this.imag3 = imag3;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMaterialpedimento() {
        return materialpedimento;
    }

    public void setMaterialpedimento(String materialpedimento) {
        this.materialpedimento = materialpedimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigosat() {
        return codigosat;
    }

    public void setCodigosat(String codigosat) {
        this.codigosat = codigosat;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
}
