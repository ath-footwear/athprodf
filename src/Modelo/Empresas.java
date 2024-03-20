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
public class Empresas implements java.io.Serializable{
    private String nombre, rfc, rsocial, ip, dirimag, dirvideo, regimen, cp, certificado, key, pass, xml, numcertificado,usuariopac, passpac;

    public String getUsuariopac() {
        return usuariopac;
    }

    public void setUsuariopac(String usuariopac) {
        this.usuariopac = usuariopac;
    }

    public String getPasspac() {
        return passpac;
    }

    public void setPasspac(String passpac) {
        this.passpac = passpac;
    }

    public String getNumcertificado() {
        return numcertificado;
    }

    public void setNumcertificado(String numcertificado) {
        this.numcertificado = numcertificado;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDirimag() {
        return dirimag;
    }

    public void setDirimag(String dirimag) {
        this.dirimag = dirimag;
    }

    public String getDirvideo() {
        return dirvideo;
    }

    public void setDirvideo(String dirvideo) {
        this.dirvideo = dirvideo;
    }
    
}
