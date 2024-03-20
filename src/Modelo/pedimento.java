/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class pedimento implements java.io.Serializable{
    
    private int id_pedimento,id_kardex, id_proveedor, id_almacen, id_cliente;
    private String referencia, fecha, fechapedimento, observaciones,serie,usuario,tipomov,nprov;
    private double subtotal, tcantidad,total,impuestos;
    private ArrayList<Dpedimento> arr = new ArrayList<>();
    private Dpedimento dp;

    public Dpedimento getDp() {
        return dp;
    }

    public void setDp(Dpedimento dp) {
        this.dp = dp;
    }

    public String getNprov() {
        return nprov;
    }

    public void setNprov(String nprov) {
        this.nprov = nprov;
    }

    public String getTipomov() {
        return tipomov;
    }

    public void setTipomov(String tipomov) {
        this.tipomov = tipomov;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getId_pedimento() {
        return id_pedimento;
    }

    public void setId_pedimento(int id_pedimento) {
        this.id_pedimento = id_pedimento;
    }

    public int getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(int id_kardex) {
        this.id_kardex = id_kardex;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechapedimento() {
        return fechapedimento;
    }

    public void setFechapedimento(String fechapedimento) {
        this.fechapedimento = fechapedimento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTcantidad() {
        return tcantidad;
    }

    public void setTcantidad(double tcantidad) {
        this.tcantidad = tcantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public ArrayList<Dpedimento> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dpedimento> arr) {
        this.arr = arr;
    }
    
}
