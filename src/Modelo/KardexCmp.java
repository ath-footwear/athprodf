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
public class KardexCmp implements java.io.Serializable{
    private String fechamov, fechadoc, serie,tipo, nombrecuenta,nombreproveedor,nombrealmacen,
            docref,nombrematerial,nombreusuario,status,operacion,Ordenc,dureza,pedido;

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public double getCantkardex() {
        return cantkardex;
    }

    public void setCantkardex(double cantkardex) {
        this.cantkardex = cantkardex;
    }

    public int getId_dpedimento() {
        return id_dpedimento;
    }

    public void setId_dpedimento(int id_dpedimento) {
        this.id_dpedimento = id_dpedimento;
    }

    public double getCantrestante() {
        return cantrestante;
    }

    public void setCantrestante(double cantrestante) {
        this.cantrestante = cantrestante;
    }

    public int getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(int id_kardex) {
        this.id_kardex = id_kardex;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public int getId_pedimento() {
        return id_pedimento;
    }

    public void setId_pedimento(int id_pedimento) {
        this.id_pedimento = id_pedimento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getOrdenc() {
        return Ordenc;
    }

    public void setOrdenc(String Ordenc) {
        this.Ordenc = Ordenc;
    }
    private ArrayList<Movs_materiales> mat;

    public ArrayList<Movs_materiales> getMat() {
        return mat;
    }

    public void setMat(ArrayList<Movs_materiales> mat) {
        this.mat = mat;
    }

    
    public String getOperacion() {
        return operacion;
    }

    public int getOrdenfolio() {
        return Ordenfolio;
    }

    public void setOrdenfolio(int Ordenfolio) {
        this.Ordenfolio = Ordenfolio;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    private int cuenta,subcuenta,folio,proveedor,almacen,renglon,usuario,Ordenfolio,
            id_material,id_cliente,id_prov,id_pedimento,id_kardex,id_dpedimento, id_concepto;

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    private double costo,importe,cantidad,impuesto,total,cantrestante,cantkardex;

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechamov() {
        return fechamov;
    }

    public void setFechamov(String fechamov) {
        this.fechamov = fechamov;
    }

    public String getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(String fechadoc) {
        this.fechadoc = fechadoc;
    }

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

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getNombrealmacen() {
        return nombrealmacen;
    }

    public void setNombrealmacen(String nombrealmacen) {
        this.nombrealmacen = nombrealmacen;
    }

    public String getDocref() {
        return docref;
    }

    public void setDocref(String docref) {
        this.docref = docref;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
