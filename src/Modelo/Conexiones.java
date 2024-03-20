/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;

/**
 *
 * @author Michel Araujo 2022
 */
public class Conexiones implements java.io.Serializable{
    Connection cpt, rcpt, cobranza;
    String empresa, empresacob, empresarcpt;
    Connection liteusuario, litecfdi, liteempresa;
    Connection cpttpu, rcpttpu, cobranzatpu,cobranzatpuB;
    Connection cptmaq, cobranzamaq, cobranzamaqB;
    int resp;

    public Connection getCobranzatpuB() {
        return cobranzatpuB;
    }

    public Connection getCptmaq() {
        return cptmaq;
    }

    public void setCptmaq(Connection cptmaq) {
        this.cptmaq = cptmaq;
    }

    public Connection getCobranzamaq() {
        return cobranzamaq;
    }

    public void setCobranzamaq(Connection cobranzamaq) {
        this.cobranzamaq = cobranzamaq;
    }

    public Connection getCobranzamaqB() {
        return cobranzamaqB;
    }

    public void setCobranzamaqB(Connection cobranzamaqB) {
        this.cobranzamaqB = cobranzamaqB;
    }

    public void setCobranzatpuB(Connection cobranzatpuB) {
        this.cobranzatpuB = cobranzatpuB;
    }

    public Connection getLitecfdi() {
        return litecfdi;
    }

    public void setLitecfdi(Connection litecfdi) {
        this.litecfdi = litecfdi;
    }

    public Connection getLiteempresa() {
        return liteempresa;
    }

    public void setLiteempresa(Connection liteempresa) {
        this.liteempresa = liteempresa;
    }

    public Connection getCpttpu() {
        return cpttpu;
    }

    public void setCpttpu(Connection cpttpu) {
        this.cpttpu = cpttpu;
    }

    public Connection getRcpttpu() {
        return rcpttpu;
    }

    public void setRcpttpu(Connection rcpttpu) {
        this.rcpttpu = rcpttpu;
    }

    public Connection getCobranzatpu() {
        return cobranzatpu;
    }

    public void setCobranzatpu(Connection cobranzatpu) {
        this.cobranzatpu = cobranzatpu;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public Connection getLiteusuario() {
        return liteusuario;
    }

    public void setLiteusuario(Connection liteusuario) {
        this.liteusuario = liteusuario;
    }

    public String getEmpresarcpt() {
        return empresarcpt;
    }

    public void setEmpresarcpt(String empresarcpt) {
        this.empresarcpt = empresarcpt;
    }

    public String getEmpresacob() {
        return empresacob;
    }

    public void setEmpresacob(String empresacob) {
        this.empresacob = empresacob;
    }

    public Connection getCpt() {
        return cpt;
    }

    public void setCpt(Connection cpt) {
        this.cpt = cpt;
    }

    public Connection getRcpt() {
        return rcpt;
    }

    public void setRcpt(Connection rcpt) {
        this.rcpt = rcpt;
    }

    public Connection getCobranza() {
        return cobranza;
    }

    public void setCobranza(Connection cobranza) {
        this.cobranza = cobranza;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
