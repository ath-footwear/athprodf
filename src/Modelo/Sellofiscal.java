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
public class Sellofiscal implements java.io.Serializable{
 
    private String sellosat,noceertificado,sellocfd,pac,fechacer,uuid, estado, estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSellosat() {
        return sellosat;
    }

    public void setSellosat(String sellosat) {
        this.sellosat = sellosat;
    }

    public String getNoceertificado() {
        return noceertificado;
    }

    public void setNoceertificado(String noceertificado) {
        this.noceertificado = noceertificado;
    }

    public String getSellocfd() {
        return sellocfd;
    }

    public void setSellocfd(String sellocfd) {
        this.sellocfd = sellocfd;
    }

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }

    public String getFechacer() {
        return fechacer;
    }

    public void setFechacer(String fechacer) {
        this.fechacer = fechacer;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
