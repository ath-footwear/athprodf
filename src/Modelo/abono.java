/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author GATEWAY1-
 */
public class abono {
    private String ref, referencia,ordenpago, nombre, folio,fechapago, Referenciac,
            obs, usuario, estatus, tipo, serie;
    Timestamp fechac;
    private Object Fechap, Fechac;
    private int cliente, cuenta, subcuenta, parcialidad, id_cargo, id_abono,
            id_docto, turno;
    private double total,totalpago, pago, saldo, anterior, comision;
    private Cliente c;
    //Inventarios
    private int mes_inv, year_inv;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getMes_inv() {
        return mes_inv;
    }

    public void setMes_inv(int mes_inv) {
        this.mes_inv = mes_inv;
    }

    public int getYear_inv() {
        return year_inv;
    }

    public void setYear_inv(int year_inv) {
        this.year_inv = year_inv;
    }

    public Object getFechap() {
        return Fechap;
    }

    public void setFechap(Object Fechap) {
        this.Fechap = Fechap;
    }

    public Object getFechac() {
        return Fechac;
    }

    public void setFechac(Object Fechac) {
        this.Fechac = Fechac;
    }

    public String getReferenciac() {
        return Referenciac;
    }

    public void setReferenciac(String Referenciac) {
        this.Referenciac = Referenciac;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_docto() {
        return id_docto;
    }

    public void setId_docto(int id_docto) {
        this.id_docto = id_docto;
    }

    public int getId_abono() {
        return id_abono;
    }

    public void setId_abono(int id_abono) {
        this.id_abono = id_abono;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(int subcuenta) {
        this.subcuenta = subcuenta;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getAnterior() {
        return anterior;
    }

    public void setAnterior(double anterior) {
        this.anterior = anterior;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getOrdenpago() {
        return ordenpago;
    }

    public void setOrdenpago(String ordenpago) {
        this.ordenpago = ordenpago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(double totalpago) {
        this.totalpago = totalpago;
    }
}
