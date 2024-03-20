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
public class Servidorsql implements java.io.Serializable {
    private int id, selecccion;
    private String nombre,ip,nombre_estancia,rutarespaldo,estatus,bd,mes,year;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }
    ArrayList<DetServidorsql> arr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSelecccion() {
        return selecccion;
    }

    public void setSelecccion(int selecccion) {
        this.selecccion = selecccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre_estancia() {
        return nombre_estancia;
    }

    public void setNombre_estancia(String nombre_estancia) {
        this.nombre_estancia = nombre_estancia;
    }

    public String getRutarespaldo() {
        return rutarespaldo;
    }

    public void setRutarespaldo(String rutarespaldo) {
        this.rutarespaldo = rutarespaldo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public ArrayList<DetServidorsql> getArr() {
        return arr;
    }

    public void setArr(ArrayList<DetServidorsql> arr) {
        this.arr = arr;
    }
}
