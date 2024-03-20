/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class factura implements java.io.Serializable{
    private int id, folio, naprobacion, estatus, retenciones, idcliente, totalcajas, cantidadxcaja
            , addenda,enviado, cvecliente, cveagente, parcialidad, parcialidad2,foliokardex,agente,plazo, totalpares,conceptos,
            id_pedido,id_kardex,foliopago,idcargo,idabono,year;
    private String nombrecliente, ncliente, nombreagente, claveusuario, serie, fecha, fechacancel
            , motivodex, pedido, fechasolicitado, condicion, fechaentrega, nombre, rfc
            , calle, nexterior, ninterior,colonia, localidad, referencia, municipio, estado
            , pais, cp, Dnombre, Datencion, Dcalle, Dexterior, Dinterior, Dcolonia, Dlocalidad
            , Dreferencia, Dmunicipio, Destado, Dpais, Dcp, Observaciones, cadenaorig, sello
            , Tiposerie, Moneda, Fechaenvio, Formapago, Metodopago, Lugarexpedicion,Numctapago
            , foliofiscalorig, seriefoliofiscalorig, fechafoliofiscalorig, regimen, foliofiscal
            , nodeseriecert, fechacert, sellosat, sellocfdi, usocfdi, tiporelacion, descmetodop, empresa, certificado,marca,
            cuentaabono,subabono, desccuenta,refncredito,rfcctaemisora,ctaemisora,rfcctareceptor,
            ctareceptora,bancoemisor,bancoreceptor,ordenpago, seriecpt, turno,fechapago;
    private String codigo, descripcion, umedida,impuestodet,tipofac, exportacion;
    private double monto, impiva16, baseiva16,totalpago16,total, subtotal, impuestos, Descuento,
            baseimpuesto,cantidadfloat, preciodetalle,basedetalle,descuentodetalle,importedetalle,
            iva, is, montoiva, montoisr, tipocambio, montofoliofiscalorig,impiva17, baseiva17,totalpago17,
            saldo,saldomx,pago,importe;
    private float  montopago;
    private Cliente c;
    private ArrayList<Dfactura> arr = new ArrayList<>();
    private ArrayList<String> arruuid = new ArrayList<>();
    private ArrayList<cargo> arrcargo = new ArrayList<>();
    private ArrayList<Detpagos> arrpagos = new ArrayList<>();
    private ArrayList<Detpagos> arrpagos17 = new ArrayList<>();
    private ArrayList<Poliza> arrpolizas = new ArrayList<>();

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldomx() {
        return saldomx;
    }

    public void setSaldomx(double saldomx) {
        this.saldomx = saldomx;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public int getFoliopago() {
        return foliopago;
    }

    public void setFoliopago(int foliopago) {
        this.foliopago = foliopago;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public int getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(int id_kardex) {
        this.id_kardex = id_kardex;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getConceptos() {
        return conceptos;
    }

    public void setConceptos(int conceptos) {
        this.conceptos = conceptos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getExportacion() {
        return exportacion;
    }

    public void setExportacion(String exportacion) {
        this.exportacion = exportacion;
    }

    public ArrayList<Poliza> getArrpolizas() {
        return arrpolizas;
    }

    public void setArrpolizas(ArrayList<Poliza> arrpolizas) {
        this.arrpolizas = arrpolizas;
    }

    public double getImpiva17() {
        return impiva17;
    }

    public void setImpiva17(double impiva17) {
        this.impiva17 = impiva17;
    }

    public double getBaseiva17() {
        return baseiva17;
    }

    public void setBaseiva17(double baseiva17) {
        this.baseiva17 = baseiva17;
    }

    public double getTotalpago17() {
        return totalpago17;
    }

    public void setTotalpago17(double totalpago17) {
        this.totalpago17 = totalpago17;
    }

    public ArrayList<Detpagos> getArrpagos17() {
        return arrpagos17;
    }

    public void setArrpagos17(ArrayList<Detpagos> arrpagos17) {
        this.arrpagos17 = arrpagos17;
    }

    public double getCantidadfloat() {
        return cantidadfloat;
    }

    public void setCantidadfloat(double cantidadfloat) {
        this.cantidadfloat = cantidadfloat;
    }

    public double getPreciodetalle() {
        return preciodetalle;
    }

    public void setPreciodetalle(double preciodetalle) {
        this.preciodetalle = preciodetalle;
    }

    public double getBasedetalle() {
        return basedetalle;
    }

    public void setBasedetalle(double basedetalle) {
        this.basedetalle = basedetalle;
    }

    public double getDescuentodetalle() {
        return descuentodetalle;
    }

    public void setDescuentodetalle(double descuentodetalle) {
        this.descuentodetalle = descuentodetalle;
    }

    public double getImportedetalle() {
        return importedetalle;
    }

    public void setImportedetalle(double importedetalle) {
        this.importedetalle = importedetalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public String getImpuestodet() {
        return impuestodet;
    }

    public void setImpuestodet(String impuestodet) {
        this.impuestodet = impuestodet;
    }

    public String getTipofac() {
        return tipofac;
    }

    public void setTipofac(String tipofac) {
        this.tipofac = tipofac;
    }

    public int getTotalpares() {
        return totalpares;
    }

    public void setTotalpares(int totalpares) {
        this.totalpares = totalpares;
    }

    public String getSeriecpt() {
        return seriecpt;
    }

    public void setSeriecpt(String seriecpt) {
        this.seriecpt = seriecpt;
    }

    public float getMontopago() {
        return montopago;
    }

    public void setMontopago(float montopago) {
        this.montopago = montopago;
    }

    public double getImpiva16() {
        return impiva16;
    }

    public void setImpiva16(double impiva16) {
        this.impiva16 = impiva16;
    }

    public double getBaseiva16() {
        return baseiva16;
    }

    public void setBaseiva16(double baseiva16) {
        this.baseiva16 = baseiva16;
    }

    public double getTotalpago16() {
        return totalpago16;
    }

    public void setTotalpago16(double totalpago) {
        this.totalpago16 = totalpago;
    }

    public ArrayList<Detpagos> getArrpagos() {
        return arrpagos;
    }

    public void setArrpagos(ArrayList<Detpagos> arrpagos) {
        this.arrpagos = arrpagos;
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

    public String getRfcctareceptor() {
        return rfcctareceptor;
    }

    public void setRfcctareceptor(String rfcctareceptor) {
        this.rfcctareceptor = rfcctareceptor;
    }

    public String getCtareceptora() {
        return ctareceptora;
    }

    public void setCtareceptora(String ctareceptora) {
        this.ctareceptora = ctareceptora;
    }

    public String getBancoemisor() {
        return bancoemisor;
    }

    public void setBancoemisor(String bancoemisor) {
        this.bancoemisor = bancoemisor;
    }

    public String getBancoreceptor() {
        return bancoreceptor;
    }

    public void setBancoreceptor(String bancoreceptor) {
        this.bancoreceptor = bancoreceptor;
    }

    public String getOrdenpago() {
        return ordenpago;
    }

    public void setOrdenpago(String ordenpago) {
        this.ordenpago = ordenpago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getRefncredito() {
        return refncredito;
    }

    public void setRefncredito(String refncredito) {
        this.refncredito = refncredito;
    }

    public String getDesccuenta() {
        return desccuenta;
    }

    public void setDesccuenta(String desccuenta) {
        this.desccuenta = desccuenta;
    }

    public String getCuentaabono() {
        return cuentaabono;
    }

    public void setCuentaabono(String cuentaabono) {
        this.cuentaabono = cuentaabono;
    }

    public String getSubabono() {
        return subabono;
    }

    public void setSubabono(String subabono) {
        this.subabono = subabono;
    }

    public ArrayList<cargo> getArrcargo() {
        return arrcargo;
    }

    public void setArrcargo(ArrayList<cargo> arrcargo) {
        this.arrcargo = arrcargo;
    }
    

    public ArrayList<String> getArruuid() {
        return arruuid;
    }

    public void setArruuid(ArrayList<String> arruuid) {
        this.arruuid = arruuid;
    }

    public int getAgente() {
        return agente;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getFoliokardex() {
        return foliokardex;
    }

    public void setFoliokardex(int foliokardex) {
        this.foliokardex = foliokardex;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public double getBaseimpuesto() {
        return baseimpuesto;
    }

    public void setBaseimpuesto(double baseimpuesto) {
        this.baseimpuesto = baseimpuesto;
    }

    public String getDescmetodop() {
        return descmetodop;
    }

    public void setDescmetodop(String descmetodop) {
        this.descmetodop = descmetodop;
    }

    public ArrayList<Dfactura> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dfactura> arr) {
        this.arr = arr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getNaprobacion() {
        return naprobacion;
    }

    public void setNaprobacion(int naprobacion) {
        this.naprobacion = naprobacion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(int retenciones) {
        this.retenciones = retenciones;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getTotalcajas() {
        return totalcajas;
    }

    public void setTotalcajas(int totalcajas) {
        this.totalcajas = totalcajas;
    }

    public int getCantidadxcaja() {
        return cantidadxcaja;
    }

    public void setCantidadxcaja(int cantidadxcaja) {
        this.cantidadxcaja = cantidadxcaja;
    }

    public int getAddenda() {
        return addenda;
    }

    public void setAddenda(int addenda) {
        this.addenda = addenda;
    }

    public int getEnviado() {
        return enviado;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }

    public int getCvecliente() {
        return cvecliente;
    }

    public void setCvecliente(int cvecliente) {
        this.cvecliente = cvecliente;
    }

    public int getCveagente() {
        return cveagente;
    }

    public void setCveagente(int cveagente) {
        this.cveagente = cveagente;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public int getParcialidad2() {
        return parcialidad2;
    }

    public void setParcialidad2(int parcialidad2) {
        this.parcialidad2 = parcialidad2;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNcliente() {
        return ncliente;
    }

    public void setNcliente(String ncliente) {
        this.ncliente = ncliente;
    }

    public String getNombreagente() {
        return nombreagente;
    }

    public void setNombreagente(String nombreagente) {
        this.nombreagente = nombreagente;
    }

    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechacancel() {
        return fechacancel;
    }

    public void setFechacancel(String fechacancel) {
        this.fechacancel = fechacancel;
    }

    public String getMotivodex() {
        return motivodex;
    }

    public void setMotivodex(String motivodex) {
        this.motivodex = motivodex;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getFechasolicitado() {
        return fechasolicitado;
    }

    public void setFechasolicitado(String fechasolicitado) {
        this.fechasolicitado = fechasolicitado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNexterior() {
        return nexterior;
    }

    public void setNexterior(String nexterior) {
        this.nexterior = nexterior;
    }

    public String getNinterior() {
        return ninterior;
    }

    public void setNinterior(String ninterior) {
        this.ninterior = ninterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public String getDnombre() {
        return Dnombre;
    }

    public void setDnombre(String Dnombre) {
        this.Dnombre = Dnombre;
    }

    public String getDatencion() {
        return Datencion;
    }

    public void setDatencion(String Datencion) {
        this.Datencion = Datencion;
    }

    public String getDcalle() {
        return Dcalle;
    }

    public void setDcalle(String Dcalle) {
        this.Dcalle = Dcalle;
    }

    public String getDexterior() {
        return Dexterior;
    }

    public void setDexterior(String Dexterior) {
        this.Dexterior = Dexterior;
    }

    public String getDinterior() {
        return Dinterior;
    }

    public void setDinterior(String Dinterior) {
        this.Dinterior = Dinterior;
    }

    public String getDcolonia() {
        return Dcolonia;
    }

    public void setDcolonia(String Dcolonia) {
        this.Dcolonia = Dcolonia;
    }

    public String getDlocalidad() {
        return Dlocalidad;
    }

    public void setDlocalidad(String Dlocalidad) {
        this.Dlocalidad = Dlocalidad;
    }

    public String getDreferencia() {
        return Dreferencia;
    }

    public void setDreferencia(String Dreferencia) {
        this.Dreferencia = Dreferencia;
    }

    public String getDmunicipio() {
        return Dmunicipio;
    }

    public void setDmunicipio(String Dmunicipio) {
        this.Dmunicipio = Dmunicipio;
    }

    public String getDestado() {
        return Destado;
    }

    public void setDestado(String Destado) {
        this.Destado = Destado;
    }

    public String getDpais() {
        return Dpais;
    }

    public void setDpais(String Dpais) {
        this.Dpais = Dpais;
    }

    public String getDcp() {
        return Dcp;
    }

    public void setDcp(String Dcp) {
        this.Dcp = Dcp;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getCadenaorig() {
        return cadenaorig;
    }

    public void setCadenaorig(String cadenaorig) {
        this.cadenaorig = cadenaorig;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getTiposerie() {
        return Tiposerie;
    }

    public void setTiposerie(String Tiposerie) {
        this.Tiposerie = Tiposerie;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public String getFechaenvio() {
        return Fechaenvio;
    }

    public void setFechaenvio(String Fechaenvio) {
        this.Fechaenvio = Fechaenvio;
    }

    public String getFormapago() {
        return Formapago;
    }

    public void setFormapago(String Formapago) {
        this.Formapago = Formapago;
    }

    public String getMetodopago() {
        return Metodopago;
    }

    public void setMetodopago(String Metodopago) {
        this.Metodopago = Metodopago;
    }

    public String getLugarexpedicion() {
        return Lugarexpedicion;
    }

    public void setLugarexpedicion(String Lugarexpedicion) {
        this.Lugarexpedicion = Lugarexpedicion;
    }

    public String getNumctapago() {
        return Numctapago;
    }

    public void setNumctapago(String Numctapago) {
        this.Numctapago = Numctapago;
    }

    public String getFoliofiscalorig() {
        return foliofiscalorig;
    }

    public void setFoliofiscalorig(String foliofiscalorig) {
        this.foliofiscalorig = foliofiscalorig;
    }

    public String getSeriefoliofiscalorig() {
        return seriefoliofiscalorig;
    }

    public void setSeriefoliofiscalorig(String seriefoliofiscalorig) {
        this.seriefoliofiscalorig = seriefoliofiscalorig;
    }

    public String getFechafoliofiscalorig() {
        return fechafoliofiscalorig;
    }

    public void setFechafoliofiscalorig(String fechafoliofiscalorig) {
        this.fechafoliofiscalorig = fechafoliofiscalorig;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getFoliofiscal() {
        return foliofiscal;
    }

    public void setFoliofiscal(String foliofiscal) {
        this.foliofiscal = foliofiscal;
    }

    public String getNodeseriecert() {
        return nodeseriecert;
    }

    public void setNodeseriecert(String nodeseriecert) {
        this.nodeseriecert = nodeseriecert;
    }

    public String getFechacert() {
        return fechacert;
    }

    public void setFechacert(String fechacert) {
        this.fechacert = fechacert;
    }

    public String getSellosat() {
        return sellosat;
    }

    public void setSellosat(String sellosat) {
        this.sellosat = sellosat;
    }

    public String getSellocfdi() {
        return sellocfdi;
    }

    public void setSellocfdi(String sellocfdi) {
        this.sellocfdi = sellocfdi;
    }

    public String getUsocfdi() {
        return usocfdi;
    }

    public void setUsocfdi(String usocfdi) {
        this.usocfdi = usocfdi;
    }

    public String getTiporelacion() {
        return tiporelacion;
    }

    public void setTiporelacion(String tiporelacion) {
        this.tiporelacion = tiporelacion;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getIs() {
        return is;
    }

    public void setIs(double is) {
        this.is = is;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getMontoiva() {
        return montoiva;
    }

    public void setMontoiva(double montoiva) {
        this.montoiva = montoiva;
    }

    public double getMontoisr() {
        return montoisr;
    }

    public void setMontoisr(double montoisr) {
        this.montoisr = montoisr;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public double getMontofoliofiscalorig() {
        return montofoliofiscalorig;
    }

    public void setMontofoliofiscalorig(double montofoliofiscalorig) {
        this.montofoliofiscalorig = montofoliofiscalorig;
    }
    
    
}
