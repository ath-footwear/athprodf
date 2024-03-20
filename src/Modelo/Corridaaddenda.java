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
public class Corridaaddenda implements java.io.Serializable{

    private int corrida, indexi, indexf, cinicial, cfinal;

    public int getCorrida() {
        return corrida;
    }

    public void setCorrida(int corrida) {
        this.corrida = corrida;
    }

    public int getIndexi() {
        return indexi;
    }

    public void setIndexi(int indexi) {
        this.indexi = indexi;
    }

    public int getIndexf() {
        return indexf;
    }

    public void setIndexf(int indexf) {
        this.indexf = indexf;
    }

    public int getCinicial() {
        return cinicial;
    }

    public void setCinicial(int cinicial) {
        this.cinicial = cinicial;
    }

    public int getCfinal() {
        return cfinal;
    }

    public void setCfinal(int cfinal) {
        this.cfinal = cfinal;
    }
}
