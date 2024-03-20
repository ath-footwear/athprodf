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
public class Colsdepartamentos implements java.io.Serializable{
    private int dia, pares;
    private String nombredep, nombre, departamento,nfecha,nmaq, ndia, fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNdia() {
        return ndia;
    }

    public void setNdia(String ndia) {
        this.ndia = ndia;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPares() {
        return pares;
    }

    public void setPares(int pares) {
        this.pares = pares;
    }

    public String getNombredep() {
        return nombredep;
    }

    public void setNombredep(String nombredep) {
        this.nombredep = nombredep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNfecha() {
        return nfecha;
    }

    public void setNfecha(String nfecha) {
        this.nfecha = nfecha;
    }

    public String getNmaq() {
        return nmaq;
    }

    public void setNmaq(String nmaq) {
        this.nmaq = nmaq;
    }
}
