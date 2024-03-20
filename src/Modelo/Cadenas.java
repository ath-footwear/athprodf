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
public class Cadenas implements java.io.Serializable{
    private int idcadena,nsucursales;
    private String nombre, contacto, direccion, telefono;

    public int getIdcadena() {
        return idcadena;
    }

    public void setIdcadena(int idcadena) {
        this.idcadena = idcadena;
    }

    public int getNsucursales() {
        return nsucursales;
    }

    public void setNsucursales(int nsucursales) {
        this.nsucursales = nsucursales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
