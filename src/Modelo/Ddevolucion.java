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
public class Ddevolucion implements java.io.Serializable{
    private int id_ddevolucion,id_devolucion,id_kardex,idmaterial,renglon,
            id_dpedimento,id_kardexnuevo, id_pedido,id_dpedido,id_cargo,
            id_material,id_pedimento,id_documento;
    private String dureza,descripcion,estatus,pedido,fecha,serie;
    private double precio,cantidad, importe, cantrestante, cantidadrestdev;

    public double getCantidadrestdev() {
        return cantidadrestdev;
    }

    public void setCantidadrestdev(double cantidadrestdev) {
        this.cantidadrestdev = cantidadrestdev;
    }

    public double getCantrestante() {
        return cantrestante;
    }

    public void setCantrestante(double cantrestante) {
        this.cantrestante = cantrestante;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_pedimento() {
        return id_pedimento;
    }

    public void setId_pedimento(int id_pedimento) {
        this.id_pedimento = id_pedimento;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_dpedido() {
        return id_dpedido;
    }

    public void setId_dpedido(int id_dpedido) {
        this.id_dpedido = id_dpedido;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_kardexnuevo() {
        return id_kardexnuevo;
    }

    public void setId_kardexnuevo(int id_kardexnuevo) {
        this.id_kardexnuevo = id_kardexnuevo;
    }

    public int getId_ddevolucion() {
        return id_ddevolucion;
    }

    public void setId_ddevolucion(int id_ddevolucion) {
        this.id_ddevolucion = id_ddevolucion;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(int id_kardex) {
        this.id_kardex = id_kardex;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public int getId_dpedimento() {
        return id_dpedimento;
    }

    public void setId_dpedimento(int id_pedimento) {
        this.id_dpedimento = id_pedimento;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
}
