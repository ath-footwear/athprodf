/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GATEWAY1-07/06/2019
 */
public class ProveedorMPrima implements java.io.Serializable{

    public String getRazons() {
        return razons;
    }

    public void setRazons(String razons) {
        this.razons = razons;
    }

    public int getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getDiascredito() {
        return this.diascredito;
    }

    public void setDiascredito(int diascredito) {
        this.diascredito = diascredito;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return this.colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return this.telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTpo() {
        return this.tpo;
    }

    public void setTpo(String tpo) {
        this.tpo = tpo;
    }

    public String getEmbarque() {
        return this.embarque;
    }

    public void setEmbarque(String embarque) {
        this.embarque = embarque;
    }

    public String getLimitecredito() {
        return this.limitecredito;
    }

    public void setLimitecredito(String limitecredito) {
        this.limitecredito = limitecredito;
    }

    public String getFechaultima() {
        return this.fechaultima;
    }

    public void setFechaultima(String fechaultima) {
        this.fechaultima = fechaultima;
    }
    @Override
    public String toString() {
        return this.nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    private int proveedor,diascredito;
    private String nombre,calle,colonia,ciudad,estado,pais,rfc,email,telefono,telefono2,contacto,tpo,embarque,limitecredito,fechaultima,cp,estatus,razons;
}
