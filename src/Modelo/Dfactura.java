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
public class Dfactura implements java.io.Serializable{
    private int id, idoc, producto,talla,cantidad,renglon,id_dpedimento,id_pedimento, years;
    private int c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14, almacen,linea,corrida,estilo,combinacion, foliokardex;
    private String factura,descripcion, codigo, umedida, descripcionprov,impuesto, tasaocuota,tipofactor,uuid, stock, descumedida,dureza,fecha;
    private double base,  importa, descuento,precio,  cantidadfloat, precioant,costo, cantrestante;
    private int kardex, cargo;
    private String pedido;
    ArrayList<String> arruuid = new ArrayList<>();

    public double getCantrestante() {
        return cantrestante;
    }

    public void setCantrestante(double cantrestante) {
        this.cantrestante = cantrestante;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setKardex(int kardex) {
        this.kardex = kardex;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getKardex() {
        return kardex;
    }

    public String getPedido() {
        return pedido;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
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

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public double getPrecioant() {
        return precioant;
    }

    public void setPrecioant(double precioant) {
        this.precioant = precioant;
    }

    public int getFoliokardex() {
        return foliokardex;
    }

    public void setFoliokardex(int foliokardex) {
        this.foliokardex = foliokardex;
    }

    public double getCantidadfloat() {
        return cantidadfloat;
    }

    public void setCantidadfloat(double cantidadfloat) {
        this.cantidadfloat = cantidadfloat;
    }

    public String getDescumedida() {
        return descumedida;
    }

    public void setDescumedida(String descumedida) {
        this.descumedida = descumedida;
    }

    public int getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(int combinacion) {
        this.combinacion = combinacion;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getCorrida() {
        return corrida;
    }

    public void setCorrida(int corrida) {
        this.corrida = corrida;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC4() {
        return c4;
    }

    public void setC4(int c4) {
        this.c4 = c4;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public int getC6() {
        return c6;
    }

    public void setC6(int c6) {
        this.c6 = c6;
    }

    public int getC7() {
        return c7;
    }

    public void setC7(int c7) {
        this.c7 = c7;
    }

    public int getC8() {
        return c8;
    }

    public void setC8(int c8) {
        this.c8 = c8;
    }

    public int getC9() {
        return c9;
    }

    public void setC9(int c9) {
        this.c9 = c9;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public int getC11() {
        return c11;
    }

    public void setC11(int c11) {
        this.c11 = c11;
    }

    public int getC12() {
        return c12;
    }

    public void setC12(int c12) {
        this.c12 = c12;
    }

    public int getC13() {
        return c13;
    }

    public void setC13(int c13) {
        this.c13 = c13;
    }

    public int getC14() {
        return c14;
    }

    public void setC14(int c14) {
        this.c14 = c14;
    }

    public ArrayList<String> getArruuid() {
        return arruuid;
    }

    public void setArruuid(ArrayList<String> arruuid) {
        this.arruuid = arruuid;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdoc() {
        return idoc;
    }

    public void setIdoc(int idoc) {
        this.idoc = idoc;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public String getDescripcionprov() {
        return descripcionprov;
    }

    public void setDescripcionprov(String descripcionprov) {
        this.descripcionprov = descripcionprov;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getTipofactor() {
        return tipofactor;
    }

    public void setTipofactor(String tipofactor) {
        this.tipofactor = tipofactor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public String getTasaocuota() {
        return tasaocuota;
    }

    public void setTasaocuota(String tasaocuota) {
        this.tasaocuota = tasaocuota;
    }

    public double getImporta() {
        return importa;
    }

    public void setImporta(double importa) {
        this.importa = importa;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
