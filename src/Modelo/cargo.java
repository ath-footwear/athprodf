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
public class cargo {
    private int cuenta,subcuenta,plazo,cliente,cantidad,agente,renglon,id_concepto,
            id_cargo,parcialidad, id_concepto2, turno;
    private String nombre, referencia, fecha, fechav, ref, foliofiscal, sumafolios,rfc,calle,
            colonia,municipio, estado,pais,cp, regimen, descnota,metodopago, observaciones,
            serie, fechacargo, usuario;
    private String formapago;
    private double tipoc;
    //Inventario
    private int mes_inv, year_inv;
    private String tipo_inv;

    public int getMes_inv() {
        return mes_inv;
    }

    public void setMes_inv(int mes_inv) {
        this.mes_inv = mes_inv;
    }

    public int getYear_inv() {
        return year_inv;
    }

    public void setYear_inv(int year_inv) {
        this.year_inv = year_inv;
    }

    public String getTipo_inv() {
        return tipo_inv;
    }

    public void setTipo_inv(String tipo_inv) {
        this.tipo_inv = tipo_inv;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public double getTipoc() {
        return tipoc;
    }

    public void setTipoc(double tipoc) {
        this.tipoc = tipoc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getId_concepto2() {
        return id_concepto2;
    }

    public void setId_concepto2(int id_concepto2) {
        this.id_concepto2 = id_concepto2;
    }

    public String getFechacargo() {
        return fechacargo;
    }

    public void setFechacargo(String fechacargo) {
        this.fechacargo = fechacargo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public double getSaldomx() {
        return saldomx;
    }

    public void setSaldomx(double saldomx) {
        this.saldomx = saldomx;
    }

    public String getDescnota() {
        return descnota;
    }

    public void setDescnota(String descnota) {
        this.descnota = descnota;
    }

    public String getRegimen() {
        return regimen;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public int getAgente() {
        return agente;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    double importe, saldo, sim, descuento,saldomx;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getFoliofiscal() {
        return foliofiscal;
    }

    public void setFoliofiscal(String foliofiscal) {
        this.foliofiscal = foliofiscal;
    }

    public String getSumafolios() {
        return sumafolios;
    }

    public void setSumafolios(String sumafolios) {
        this.sumafolios = sumafolios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(int subcuenta) {
        this.subcuenta = subcuenta;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechav() {
        return fechav;
    }

    public void setFechav(String fechav) {
        this.fechav = fechav;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSim() {
        return sim;
    }

    public void setSim(double sim) {
        this.sim = sim;
    }
}
