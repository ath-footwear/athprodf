package mx.sat.cfd40;

import Modelo.Detpagos;
import Modelo.cargo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class xmlDAO {

    private String moneda;
    private String lugarExpedidcion;
    private String metodoPago;
    private String certificado;
    private String sello;
    private Object fecha;
    private String folio;
    private String serie;
    private String version;
    private String urlSat;
    private String regimenFE;
    private String regimenFR;
    private String empresa;
    private String rfcE;
    private String rfcR;
    private String usoCfdi;
    private String domicilioReceptor;
    private String claveServ;
    private String claveUn;
    private String claveProdServ;
    private BigDecimal subT;
    private BigDecimal importe;
    private BigDecimal descuento;
    private BigDecimal descuentoG;
    private BigDecimal valorUnitario;
    private BigDecimal cantidad;
    private BigDecimal tipoC;
    private BigDecimal total;
    private BigDecimal base;
    private BigDecimal totalImpuesto;
    private BigDecimal tasaCuota;
    private BigDecimal importeImpuesto;
    private BigDecimal baseImpuesto;
    private String descripcion;
    private String impuesto;
    private String tipoF;
    private Object fechaTimbrado;
    private String uuid;
    private String rutaXML;
    private String formaP;
    private String descripcionP;
    private String tipoCombrobante;
    private String nombre;
    private String receptor;
    private String noIdenf;
    private String unidad;
    private String razonSocial;
    private String relacion;
    private int iddocumentos;
    private ArrayList<String> arruuid = new ArrayList<>();
    private ArrayList<cargo> arrcargo = new ArrayList<>();
    private ArrayList<Detpagos> arrpagos = new ArrayList<>();
    private ArrayList<Detpagos> arrpagos17 = new ArrayList<>();
    private float montopago;
    private double impiva16, baseiva16, totalpago16;
    private double impiva17, baseiva17, totalpago17;
    private int parcialidad;
    private String exportacion;
    private String folioorig;
    private String turno;
    private double monto;
    private String PEDIDO;
    private String fechapago;
    private Date fechap;

    public Date getFechap() {
        return fechap;
    }

    public void setFechap(Date fechap) {
        this.fechap = fechap;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public String getPEDIDO() {
        return PEDIDO;
    }

    public void setPEDIDO(String PEDIDO) {
        this.PEDIDO = PEDIDO;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFolioorig() {
        return folioorig;
    }

    public void setFolioorig(String folioorig) {
        this.folioorig = folioorig;
    }

    public String getExportacion() {
        return exportacion;
    }

    public void setExportacion(String exportacion) {
        this.exportacion = exportacion;
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

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
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

    public void setTotalpago16(double totalpago16) {
        this.totalpago16 = totalpago16;
    }

    public float getMontopago() {
        return montopago;
    }

    public void setMontopago(float montopago) {
        this.montopago = montopago;
    }

    public ArrayList<Detpagos> getArrpagos() {
        return arrpagos;
    }

    public void setArrpagos(ArrayList<Detpagos> arrpagos) {
        this.arrpagos = arrpagos;
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

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public int getIddocumentos() {
        return iddocumentos;
    }

    public void setIddocumentos(int iddocumentos) {
        this.iddocumentos = iddocumentos;
    }

    public xmlDAO() {
    }

    public BigDecimal getDescuentoG() {
        return descuentoG;
    }

    public void setDescuentoG(BigDecimal descuentoG) {
        this.descuentoG = descuentoG;
    }

    public BigDecimal getBaseImpuesto() {
        return baseImpuesto;
    }

    public void setBaseImpuesto(BigDecimal baseImpuesto) {
        this.baseImpuesto = baseImpuesto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public BigDecimal getImporteImpuesto() {
        return importeImpuesto;
    }

    public void setImporteImpuesto(BigDecimal importeImpuesto) {
        this.importeImpuesto = importeImpuesto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(BigDecimal iva) {
        this.totalImpuesto = iva;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getNoIdenf() {
        return noIdenf;
    }

    public void setNoIdenf(String noIdenf) {
        this.noIdenf = noIdenf;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCombrobante() {
        return tipoCombrobante;
    }

    public void setTipoCombrobante(String tipoCombrobante) {
        this.tipoCombrobante = tipoCombrobante;
    }

    public BigDecimal getTipoC() {
        return tipoC;
    }

    public void setTipoC(BigDecimal tipoC) {
        this.tipoC = tipoC;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubT() {
        return subT;
    }

    public void setSubT(BigDecimal subT) {
        this.subT = subT;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getFormaP() {
        return formaP;
    }

    public void setFormaP(String formaP) {
        this.formaP = formaP;
    }

    public String getRutaXML() {
        return rutaXML;
    }

    public void setRutaXML(String rutaXML) {
        this.rutaXML = rutaXML;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getLugarExpedidcion() {
        return lugarExpedidcion;
    }

    public void setLugarExpedidcion(String lugarExpedidcion) {
        this.lugarExpedidcion = lugarExpedidcion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrlSat() {
        return urlSat;
    }

    public void setUrlSat(String urlSat) {
        this.urlSat = urlSat;
    }

    public String getRegimenFE() {
        return regimenFE;
    }

    public void setRegimenFE(String regimenFE) {
        this.regimenFE = regimenFE;
    }

    public String getRegimenFR() {
        return regimenFR;
    }

    public void setRegimenFR(String regimenFR) {
        this.regimenFR = regimenFR;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRfcE() {
        return rfcE;
    }

    public void setRfcE(String rfcE) {
        this.rfcE = rfcE;
    }

    public String getRfcR() {
        return rfcR;
    }

    public void setRfcR(String rfcR) {
        this.rfcR = rfcR;
    }

    public String getUsoCfdi() {
        return usoCfdi;
    }

    public void setUsoCfdi(String usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    public String getDomicilioReceptor() {
        return domicilioReceptor;
    }

    public void setDomicilioReceptor(String domicilioReceptor) {
        this.domicilioReceptor = domicilioReceptor;
    }

    public String getClaveServ() {
        return claveServ;
    }

    public void setClaveServ(String claveServ) {
        this.claveServ = claveServ;
    }

    public String getClaveUn() {
        return claveUn;
    }

    public void setClaveUn(String claveUn) {
        this.claveUn = claveUn;
    }

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getTipoF() {
        return tipoF;
    }

    public void setTipoF(String tipoF) {
        this.tipoF = tipoF;
    }

    public BigDecimal getTasaCuota() {
        return tasaCuota;
    }

    public void setTasaCuota(BigDecimal tasaCuota) {
        this.tasaCuota = tasaCuota;
    }

    public Object getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(Object fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
