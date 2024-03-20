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
public class Devolucion implements java.io.Serializable{
    private int id_dev,id_cliente,id_concepto,id_kardex,id_kardexnuevo,id_motivo,id_cargoenc,id_pedido,cuenta1,cuenta2;
    private String nombre,fecha,desc,serie,estatus,usuario,npedido,nmotivo,foliofac,stock;
    private double total;
    private ArrayList<Ddevolucion>arr = new ArrayList<>();

    public int getCuenta1() {
        return cuenta1;
    }

    public void setCuenta1(int cuenta1) {
        this.cuenta1 = cuenta1;
    }

    public int getCuenta2() {
        return cuenta2;
    }

    public void setCuenta2(int cuenta2) {
        this.cuenta2 = cuenta2;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFoliofac() {
        return foliofac;
    }

    public void setFoliofac(String foliofac) {
        this.foliofac = foliofac;
    }

    public String getNmotivo() {
        return nmotivo;
    }

    public void setNmotivo(String nmotivo) {
        this.nmotivo = nmotivo;
    }

    public String getNpedido() {
        return npedido;
    }

    public void setNpedido(String npedido) {
        this.npedido = npedido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_kardexnuevo() {
        return id_kardexnuevo;
    }

    public void setId_kardexnuevo(int id_kardexnuevo) {
        this.id_kardexnuevo = id_kardexnuevo;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cargoenc() {
        return id_cargoenc;
    }

    public void setId_cargoenc(int id_cargoenc) {
        this.id_cargoenc = id_cargoenc;
    }

    public int getId_dev() {
        return id_dev;
    }

    public void setId_dev(int id_dev) {
        this.id_dev = id_dev;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public int getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(int id_kardex) {
        this.id_kardex = id_kardex;
    }

    public int getId_motivo() {
        return id_motivo;
    }

    public void setId_motivo(int id_motivo) {
        this.id_motivo = id_motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Ddevolucion> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Ddevolucion> arr) {
        this.arr = arr;
    }
    
}
