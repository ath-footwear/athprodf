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
public class Detpagos implements java.io.Serializable{

    int id, iddocumento, parcialidad, idcargo;
    String Descripcion, codigo, umedida, formadedpago, monedapago, rfcctaemisora, ctaemisora,
            rfcctareceptora, ctareceptora, uuid, folio, moneda, metodopago,ref;
    double monto,cantidad, precio,  importesaldoant, importepagado, impsaldoinsoluto,saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }
    
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(int iddocumento) {
        this.iddocumento = iddocumento;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getImportesaldoant() {
        return importesaldoant;
    }

    public void setImportesaldoant(double importesaldoant) {
        this.importesaldoant = importesaldoant;
    }

    public double getImportepagado() {
        return importepagado;
    }

    public void setImportepagado(double importepagado) {
        this.importepagado = importepagado;
    }

    public double getImpsaldoinsoluto() {
        return impsaldoinsoluto;
    }

    public void setImpsaldoinsoluto(double impsaldoinsoluto) {
        this.impsaldoinsoluto = impsaldoinsoluto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public String getFormadedpago() {
        return formadedpago;
    }

    public void setFormadedpago(String formadedpago) {
        this.formadedpago = formadedpago;
    }

    public String getMonedapago() {
        return monedapago;
    }

    public void setMonedapago(String monedapago) {
        this.monedapago = monedapago;
    }

    public String getRfcctaemisora() {
        return rfcctaemisora;
    }

    public void setRfcctaemisora(String rfcctaemisora) {
        this.rfcctaemisora = rfcctaemisora;
    }

    public String getCtaemisora() {
        return ctaemisora;
    }

    public void setCtaemisora(String ctaemisora) {
        this.ctaemisora = ctaemisora;
    }

    public String getRfcctareceptora() {
        return rfcctareceptora;
    }

    public void setRfcctareceptora(String rfcctareceptora) {
        this.rfcctareceptora = rfcctareceptora;
    }

    public String getCtareceptora() {
        return ctareceptora;
    }

    public void setCtareceptora(String ctareceptora) {
        this.ctareceptora = ctareceptora;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFolio() {
        return folio;
    }

    /*
        Referencia a la factura de cargos
    
    * @return possible object is {@link String }
    
    */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }
}
