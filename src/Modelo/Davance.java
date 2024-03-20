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
public class Davance implements java.io.Serializable{
    private String fecha,depa;
    private int cor,precor,pes,des,oji,insp,prea,mont,mont2,pt;
    private int reportado, muestras, total, acumulado, proyeccion;

    public int getMont2() {
        return mont2;
    }

    public void setMont2(int mont2) {
        this.mont2 = mont2;
    }

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }

    public int getReportado() {
        return reportado;
    }

    public void setReportado(int reportado) {
        this.reportado = reportado;
    }

    public int getMuestras() {
        return muestras;
    }

    public void setMuestras(int muestras) {
        this.muestras = muestras;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public int getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(int proyeccion) {
        this.proyeccion = proyeccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getPrecor() {
        return precor;
    }

    public void setPrecor(int precor) {
        this.precor = precor;
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getOji() {
        return oji;
    }

    public void setOji(int oji) {
        this.oji = oji;
    }

    public int getInsp() {
        return insp;
    }

    public void setInsp(int insp) {
        this.insp = insp;
    }

    public int getPrea() {
        return prea;
    }

    public void setPrea(int prea) {
        this.prea = prea;
    }

    public int getMont() {
        return mont;
    }

    public void setMont(int mont) {
        this.mont = mont;
    }

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }
}
