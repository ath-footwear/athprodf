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
public class Fichas implements java.io.Serializable{

    private String Estilo, code, nombre, nombre1, tipo_calzado, reviso_bobo, imagen1,
            imagen2, imagen3, construccion, observaciones, estatus_ok, estatus, fecharea,
            fecharev, fechaaprobado, descorrida, descusuario, desclinea, deschorma,
            nombreimagen1,nombreimagen2,nombreimagen3,desccolor,url1,url2,url3;

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
    private ArrayList<DetFichas> arr;

    public ArrayList<DetFichas> getArr() {
        return arr;
    }

    public void setArr(ArrayList<DetFichas> arr) {
        this.arr = arr;
    }
    
    public String getNombreimagen1() {
        return nombreimagen1;
    }

    public void setNombreimagen1(String nombreimagen1) {
        if(nombreimagen1!=null){
        this.nombreimagen1 = nombreimagen1;
        }else
            this.nombreimagen1="";
        
    }

    public String getNombreimagen2() {
        return nombreimagen2;
    }

    public void setNombreimagen2(String nombreimagen2) {
        if(nombreimagen2!=null){
        this.nombreimagen2 = nombreimagen2;
        }else
            this.nombreimagen2="";
    }

    public String getNombreimagen3() {
        return nombreimagen3;
    }

    public void setNombreimagen3(String nombreimagen3) {
        if(nombreimagen3!=null){
        this.nombreimagen3 = nombreimagen3;
        }else
            this.nombreimagen3="";
    }
    private int Ficha, id_corrida, id_usuario, id_linea, id_horma, id_color;

    public String getDesccolor() {
        return desccolor;
    }

    public void setDesccolor(String desccolor) {
        this.desccolor = desccolor;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getTipo_calzado() {
        return tipo_calzado;
    }

    public void setTipo_calzado(String tipo_calzado) {
        this.tipo_calzado = tipo_calzado;
    }

    public String getReviso_bobo() {
        return reviso_bobo;
    }

    public void setReviso_bobo(String reviso_bobo) {
        this.reviso_bobo = reviso_bobo;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getConstruccion() {
        return construccion;
    }

    public void setConstruccion(String construccion) {
        this.construccion = construccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstatus_ok() {
        return estatus_ok;
    }

    public void setEstatus_ok(String estatus_ok) {
        this.estatus_ok = estatus_ok;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFecharea() {
        return fecharea;
    }

    public void setFecharea(String fecharea) {
        this.fecharea = fecharea;
    }

    public String getFecharev() {
        return fecharev;
    }

    public void setFecharev(String fecharev) {
        this.fecharev = fecharev;
    }

    public String getFechaaprobado() {
        return fechaaprobado;
    }

    public void setFechaaprobado(String fechaaprobado) {
        this.fechaaprobado = fechaaprobado;
    }

    public String getDescorrida() {
        return descorrida;
    }

    public void setDescorrida(String descorrida) {
        this.descorrida = descorrida;
    }

    public String getDescusuario() {
        return descusuario;
    }

    public void setDescusuario(String descusuario) {
        this.descusuario = descusuario;
    }

    public String getDesclinea() {
        return desclinea;
    }

    public void setDesclinea(String desclinea) {
        this.desclinea = desclinea;
    }

    public String getDeschorma() {
        return deschorma;
    }

    public void setDeschorma(String deschorma) {
        this.deschorma = deschorma;
    }

    public int getFicha() {
        return Ficha;
    }

    public void setFicha(int Ficha) {
        this.Ficha = Ficha;
    }

    public int getId_corrida() {
        return id_corrida;
    }

    public void setId_corrida(int id_corrida) {
        this.id_corrida = id_corrida;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getId_horma() {
        return id_horma;
    }

    public void setId_horma(int id_horma) {
        this.id_horma = id_horma;
    }
}
