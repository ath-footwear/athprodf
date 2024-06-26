/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Conexiones;
import Modelo.Detpagos;
import Modelo.Dfactura;
import Modelo.Formateodedatos;
import Modelo.Kardex;
import Modelo.Kardexrcpt;
import Modelo.Poliza;
import Modelo.Sellofiscal;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-Michel araujo
 */
public class sqlfactura {

    /**
     * Funcion que formatea el nombre del cliente por si tiene comillas simples
     * que puedan detener el proceso
     *
     * @param n
     * @return
     */
    private String formatnombre(String n) {
        String resp = "";
        for (int i = 0; i < n.length(); i++) {
            String aux = n.charAt(i) + "";
            if (!aux.equals("'")) {
                resp += aux;
            }
        }
        return resp;
    }

    public String formateafecha(String f) {
        //Solo da formato para que pueda entrar a la bd
        String nuevafecha = "";
        for (int i = 0; i < f.length() - 2; i++) {
            if (f.charAt(i) == ' ') {
                nuevafecha += "T";
            } else {
                nuevafecha += f.charAt(i);
            }
        }
        return nuevafecha;
    }

    public int buscafolio(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        int f = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select folio from documentos where folio=" + folio + " and serie='fac'";
////            System.out.println("busca folio " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                f = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    /**
     * Solo aplica cuando el costo de dfactura esta mal, solo ejecucion MANUAL
     * no esta ligado con alguna funcion
     *
     * @param con
     * @return
     */
    public ArrayList<Kardexrcpt> modcostodfac(Connection con) {//obtiene datos de la factura recien ingresada
        ArrayList<Kardexrcpt> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct k.folio,k.pcosto,k.pventa,k.fmovimiento,factura,producto\n"
                    + "from kardex k\n"
                    + "where serie='A' and FMovimiento between '01/02/2023' and '28/02/2023' and StatusSalida!='C' and isnull(factura,'')!=''\n"
                    + "order by fmovimiento";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Kardexrcpt k = new Kardexrcpt();
                k.setFactura(rs.getString("factura"));
                k.setCosto(rs.getFloat("pcosto"));
                k.setVenta(rs.getFloat("pventa"));
                k.setId_prod(rs.getInt("producto"));
                arr.add(k);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Lleva a cabo las modificaciones con la informacion del costo del kardex
     * previamente obtenidas
     *
     * @param c
     * @param arr
     * @return
     */
    public boolean setmodificaciondfactura(Connection c, ArrayList<Kardexrcpt> arr) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            for (Kardexrcpt arr1 : arr) {
                float costo = arr1.getCosto();
                int p = arr1.getId_prod();
                String f = arr1.getFactura();
                String sql = "update dfacturas set costo=" + costo + " where producto=" + p + " and factura='" + f + "'";
////                System.out.println("dfacturas "+sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    /**
     *
     * @param con
     * @param folio
     * @return
     */
    public int buscafolioncr(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        int f = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select folio from documentos where folio=" + folio + " and serie='NCR'";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                f = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public factura getfactura(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        factura f = new factura();
        ArrayList<Dfactura> arr = new ArrayList<>();
        try {
            PreparedStatement st, st1;
            ResultSet rs, rs1;
            String sql = "select * from documentos where estatus =1 and folio=" + folio;
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                double descuento = rs.getDouble("descuento");
                f.setDescuento(descuento);
                f.setId(rs.getInt("id"));
                f.setSerie(rs.getString("serie"));
                f.setFolio(rs.getInt("folio"));
                f.setFormapago(rs.getString("formadepago"));
                f.setDescmetodop(rs.getString("Metododepago"));//descripcion metodo pago
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setMoneda(rs.getString("Moneda"));
                f.setTotal(rs.getDouble("Total"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setIdcliente(rs.getInt("idcliente"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setBaseimpuesto(rs.getDouble("subtotal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                String sql1 = "select * from documentosdetalle where iddocumento=" + f.getId(); /// Detalle de factura o conceptos
                st1 = con.prepareStatement(sql1);
                rs1 = st1.executeQuery();
                while (rs1.next()) {// setear detalle de conceptos o detallado de factura
                    Dfactura df = new Dfactura();
                    df.setDescuento(rs1.getDouble("descuento"));
                    df.setImporta(rs1.getDouble("Importe"));//iva
                    df.setPrecio(rs1.getDouble("precio"));//valor unitario
                    df.setCantidad(rs1.getInt("cantidad"));//cantidad
                    df.setDescripcion(rs1.getString("descripcion"));
                    df.setCodigo(rs1.getString("codigo"));
                    df.setUmedida(rs1.getString("umedida"));
                    //impuestosx concepto
                    df.setBase(rs1.getDouble("base"));
                    df.setImpuesto(rs1.getString("impuesto"));
                    df.setTipofactor(rs1.getString("tipofactor"));
                    df.setTasaocuota(rs1.getString("tasaocuota") + "0000");
                    df.setId(rs.getInt("id"));
                    arr.add(df);
                }
                f.setArr(arr);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    /**
     *
     * @param con
     * @param folio
     * @param serie
     * @param cob
     * @return
     */
    public ArrayList<factura> getdocs(Connection con, String folio, String serie, String cob) {//obtiene datos de la factura recien ingresada

        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(500) id,folio,subtotal,impuestos,total,"
                    + "convert(date,fecha) as fecha,d.nombre,formadepago,metododepago,"
                    + " d.estatus, ISNULL(foliofiscal,'') as foliofiscal, d.usocfdi,"
                    + "fax, d.moneda,cadenaoriginal,c.numcliente as cli,d.descuento\n"
                    + "from documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.idcliente=c.NumCliente\n"
                    + "where (d.idcliente like '%" + folio + "%' or "
                    + "d.nombre like '%" + folio + "%') and serie='" + serie + "'\n"
                    + "order by id desc";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                factura f = new factura();
                f.setId(rs.getInt("id"));
                f.setFolio(rs.getInt("folio"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setTotal(rs.getDouble("Total"));
                f.setFecha(rs.getString("fecha"));
                f.setNombre(rs.getString("nombre"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setFormapago(rs.getString("formadepago"));
                f.setEstatus(rs.getInt("estatus"));
                f.setFoliofiscal(rs.getString("foliofiscal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                f.setRegimen(rs.getString("fax"));
                f.setMoneda(rs.getString("moneda"));
                f.setCadenaorig(rs.getString("cadenaoriginal"));
                f.setIdcliente(rs.getInt("cli"));
                f.setDescuento(rs.getDouble("descuento"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Obtener los registros de acuerdo a lo que encuentre del cliente
     *
     * @param con
     * @param folio
     * @param serie
     * @param cob
     * @return
     */
    public ArrayList<factura> getdocspagos(Connection con, String folio, String serie, String cob) {
        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(200) id,folio,subtotal,impuestos,total,convert(date,fecha) as fecha,d.nombre,\n"
                    + "formadepago,metododepago, d.estatus, ISNULL(foliofiscal,'') as foliofiscal, d.usocfdi,d.regimen, d.moneda,cadenaoriginal,numcliente, ordenpago\n"
                    + "from Doctospago d\n"
                    + "join " + cob + ".dbo.Clientes c on d.idcliente=c.numcliente\n"
                    + "where (d.idcliente like '%" + folio + "%' or d.nombre like '%" + folio + "%') and serie='PAG'\n"
                    + "order by id desc";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                factura f = new factura();
                f.setId(rs.getInt("id"));
                f.setOrdenpago(rs.getString("ordenpago"));
                f.setFolio(rs.getInt("folio"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setTotal(rs.getDouble("Total"));
                f.setFecha(rs.getString("fecha"));
                f.setNombre(rs.getString("nombre"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setFormapago(rs.getString("formadepago"));
                f.setEstatus(rs.getInt("estatus"));
                f.setFoliofiscal(rs.getString("foliofiscal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                f.setRegimen(rs.getString("regimen"));
                f.setMoneda(rs.getString("moneda"));
                f.setCadenaorig(rs.getString("cadenaoriginal"));
                f.setIdcliente(rs.getInt("numcliente"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<factura> getdocsxml(Connection con, String folio, String serie, String cob) {//obtiene datos de la factura recien ingresada
        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select d.id,folio,d.descuento,subtotal,impuestos,total,convert(date,fecha) as fecha,d.nombre,d.rfc,formadepago,metododepago,\n"
                    + " d.estatus, ISNULL(foliofiscal,'') as foliofiscal, d.usocfdi,fax,d.cp,serie,d.Observaciones,moneda,iva,tipocambio,\n"
                    + " dd.cantidad,dd.codigo,descripcion, umedida,dd.precio,dd.base,dd.impuesto,dd.descuento as descu,Tipofactor,dd.importe,tiporelacion, foliofiscalorig\n"
                    + "from documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.idcliente=c.NumCliente\n"
                    + "join documentosdetalle dd on dd.IdDocumento=d.Id\n"
                    + "where d.id=" + folio + " and serie='" + serie + "'\n"
                    + "order by d.id desc";
//            System.out.println("xml " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                factura f = new factura();
                f.setId(rs.getInt("id"));
                f.setFolio(rs.getInt("folio"));
                f.setDescuento(rs.getDouble("descuento"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setTotal(rs.getDouble("Total"));
                f.setFecha(rs.getString("fecha"));
                f.setNombre(rs.getString("nombre"));
                f.setRfc(rs.getString("rfc"));
                f.setRegimen(rs.getString("fax"));
                f.setCp(rs.getString("cp"));
                f.setObservaciones(rs.getString("observaciones"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setFormapago(rs.getString("formadepago"));
                f.setEstatus(rs.getInt("estatus"));
                f.setFoliofiscal(rs.getString("foliofiscal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                f.setSerie(rs.getString("serie"));
                f.setObservaciones(rs.getString("observaciones"));
                f.setMoneda(rs.getString("moneda"));
                f.setIva(rs.getDouble("iva"));
                f.setTipocambio(rs.getInt("tipocambio"));
                f.setCantidadfloat(rs.getDouble("cantidad"));
                f.setCodigo(rs.getString("codigo"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setUmedida(rs.getString("umedida"));
                f.setPreciodetalle(rs.getDouble("precio"));
                f.setBasedetalle(rs.getDouble("base"));
                f.setImpuestodet(rs.getString("impuesto"));
                f.setDescuentodetalle(rs.getDouble("descu"));
                f.setTipofac(rs.getString("tipofactor"));
                f.setImportedetalle(rs.getDouble("importe"));
                f.setTiporelacion(rs.getString("tiporelacion"));
                f.setFoliofiscalorig(rs.getString("Foliofiscalorig"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int insertfactura(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String turno = f.getTurno();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
            int totalparesf = f.getTotalpares();
            String relacion = f.getTiporelacion();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",?,'" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
//            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
//            System.out.println("rcpt documentos " + sql + "\n");
//            Insercio a tabla facturas
            sql = "insert into facturas(factura,fecha,pedido,salida,numcliente,plazo,totalpares,descuento,subtotal,IDesc,"
                    + "iva,total,cveagente,fechaembarque,estatus,observaciones,NOentrega,serie,Marca,usuario,registro) "
                    + "values ('" + fol + "','" + fecha + "','" + ped + "','" + turno + "'," + idcliente + "," + plazo + "," + totalparesf + ",0,"
                    + subtotal + ", " + desc + "," + imp + "," + total + "," + agente + ",'" + fecha + "','F','" + obs + "',1,'A',' " + f.getMarca() + "','" + usuario + "','" + fecha + "')";
//            System.out.println("facturas " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //RCPT
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            System.out.println("facturas rcpt " + sql + " \n");
//            Fin tabla facturas

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0," + turno + "," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
//            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
//            Inserta en detallado de documentos y Dfacturas
            int i = 1;
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double costo = arr.getCosto();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();
                int almacen = arr.getAlmacen();
                int cor = arr.getCorrida();
                int lin = arr.getLinea();
                String stoc = arr.getStock();
                int comb = arr.getCombinacion();
                int est = arr.getEstilo();
                int c1 = arr.getC1();
                int c2 = arr.getC2();
                int c3 = arr.getC3();
                int c4 = arr.getC4();
                int c5 = arr.getC5();
                int c6 = arr.getC6();
                int c7 = arr.getC7();
                int c8 = arr.getC8();
                int c9 = arr.getC9();
                int c10 = arr.getC10();
                int c11 = arr.getC11();
                int c12 = arr.getC12();
                int c13 = arr.getC13();
                int c14 = arr.getC14();

                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
//                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
//                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();

                sql = "insert into dfacturas values('" + fol + "','" + fecha + "'," + i + "," + prod + "," + est + "," + cor + "," + comb + "," + lin + ","
                        + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + "," + c13 + "," + c14 + ","
                        + c + "," + precio + "," + costo + "," + almacen + ",'" + stoc + "',0,'')";
//                System.out.println("dfacturas " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
//                System.out.println("rcpt dfacturas " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
                i++;
            }
//             Fin detallado de documento
//              Status de kardex y dpedidos
            for (Dfactura arr : f.getArr()) {
                double precio = arr.getPrecio();
                sql = "update Kardex set statusimpresion='I', factura='" + fol + "', pventa=" + precio + " where folio=" + arr.getFoliokardex() + " and cuenta>49 and renglon=" + arr.getRenglon();
//                System.out.println("kardex " + sql + " \n");
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
//                System.out.println("rcpt kardex " + sql);
            }
            //Actualizar status del detallado de pedido
            for (Dfactura arr : f.getArr()) {
                double precio = arr.getPrecio();
                sql = "update dpedidos set estatus='30' , precioventa=" + precio + " where pedido='" + f.getPedido() + "' and renglon=" + arr.getRenglon();
//                System.out.println("dpedidos " + sql + " \n");
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // Solo rcpt
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
//                System.out.println("rcpt dpedidos " + sql);

                sql = "update pedidos set cveagente=" + agente + " where pedido='" + f.getPedido() + "'";
//                System.out.println("pedidos " + sql + " \n");
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // Solo rcpt
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
//                System.out.println("rcpt pedidos " + sql);
            }
//            Fin detallado documento
//          Insercion de polizas
            for (int x = 0; x < f.getArrpolizas().size(); x++) {
                int cuenta = f.getArrpolizas().get(x).getCuenta();
                int sub = f.getArrpolizas().get(x).getSub();
                String fechas = f.getArrpolizas().get(x).getFecha();
                int cliente = f.getArrpolizas().get(x).getIdcliente();
                String ident = f.getArrpolizas().get(x).getIdentificacion();
                String cuental = f.getArrpolizas().get(x).getCuentalarga();
                int t = f.getArrpolizas().get(x).getCa();
                String imps = f.getArrpolizas().get(x).getImporte();
                String concep = f.getArrpolizas().get(x).getConcepto();
                String Acum = f.getArrpolizas().get(x).getAcumulativo();
                String ref = f.getArrpolizas().get(x).getReferencia();
                String fo = f.getArrpolizas().get(x).getFolio();
                String mext = f.getArrpolizas().get(x).getMext();
                int ord = f.getArrpolizas().get(x).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
//                System.out.println(sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("rcpt sfolios " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            if (!relacion.equals("")) {
                sql = "update documentos set tiporelacion='" + relacion + "', foliofiscalorig='" + f.getSeriefoliofiscalorig() + "'  where id=" + resp + "";
//                System.out.println("rcpt sfolios " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cobranza.rollback();
                rcpt.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "inertar -" + ex1);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public int insertfacturatpuATH(Connection con, factura f, Connection cobranza, Connection cpttpu, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int pedido = 0;
        int docu = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            cpttpu.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            int fkardex = f.getFoliokardex();
            int concepto = f.getConceptos();
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String cond = f.getCondicion();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            //fin cliente
            String obs = f.getObservaciones();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String descmpago = f.getDescmetodop();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " O";
            int agente = f.getAgente();
            String relacion = f.getTiporelacion();
            String turno = f.getTurno();
            int resp = 0;
            sql = "insert into pedido(pedido,id_cliente,id_kardex,fecha,total,subtotal,impuestos,descuento,iva,serie,estatus,nombre,observaciones) "
                    + "values('" + fol + "'," + idcliente + "," + fkardex + ",'" + fecha + "'," + total + "," + subtotal + "," + imp + "," + desc + "," + iva + ",'A','2','" + nombre + "','" + obs + " FAC" + fol + "')";
//            System.out.println("pedido " + sql);
            st = cpttpu.prepareStatement(sql);
            st.executeUpdate();
            sql = "select max(id_pedido) as pedido from pedido";
            st = cpttpu.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pedido = rs.getInt("pedido");
            }
//Primero de inserta en los documentos y cargos de ath para hacer referencia hacia el en la parte del pedido que es el id del pedido
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','TPU " + pedido + "','" + fecha + "','" + cond + "','" + fecha + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','','','',''"
                    + ",'','','','','','" + cp + "','" + obs + "',0,0,'FACTURA','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
//            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            System.out.println("rcpt documentos " + sql + "\n");

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
//          Insertar a cargos de ath
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0," + turno + "," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
//            System.out.println("cargos " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
//          Fin insertar cargos
//            Posterior se realiza el pedido y kardex en el apartado de TPU
            for (int i = 0; i < f.getArr().size(); i++) {
                int mat = f.getArr().get(i).getProducto();
                int iped = f.getArr().get(i).getId_pedimento();
                double prec = f.getArr().get(i).getPrecio();
                double cant = f.getArr().get(i).getCantidadfloat();
                String dur = f.getArr().get(i).getDureza();
                sql = "insert into kardex(id_kardex,id_concepto,id_cliente,id_material,id_prov,id_almacen,id_pedimento,"
                        + "usuario,fecha,costo,precio,cantidad,renglon,serie,estatus,estatusprod,dureza,referencia) "
                        + "values(" + fkardex + "," + concepto + "," + idcliente + "," + mat + ",0,1," + iped + ",'" + usuario + "','" + fecha + "',"
                        + prec + "," + prec + "," + cant + "," + (i + 1) + ",'A','1','1','" + dur + "','" + fol + "')";
//                System.out.println("kardex " + sql);
                st = cpttpu.prepareStatement(sql);
                st.executeUpdate();
            }
            //Fin obtener ultimo documento
            //Insertar en cargos
//            Inserta en detallado de documentos
            int i = 1;
            for (Dfactura arr : f.getArr()) {//
                int prod = arr.getProducto();
                double c = arr.getCantidadfloat();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();
                String dur = arr.getDureza();
                int id_dped = arr.getId_dpedimento();
//              Detallado documentos ATH
                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + resp + ",0," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'002',0.16,'Tasa'," + impo + "," + descu + ")";
//                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
//                DPedidos de TPU
                sql = "insert into Dpedido(id_pedido,id_material,dureza,cantidad,precio,costo,importe,impuestos,descuento,estatus,id_dpedimento) "
                        + "values(" + pedido + "," + prod + ",'" + dur + "'," + c + "," + precio + "," + precio + "," + b + "," + impo + "," + desc + ",'1'," + id_dped + ")";
//                System.out.println("dpeds " + sql);
                st = cpttpu.prepareStatement(sql);
                st.executeUpdate();
//                Actualizar stock de pedimentos en TPU
                sql = "update dpedimentos set cantidadrestante=cantidadrestante-" + c + " where id_dpedimento=" + id_dped;
//                System.out.println("actualiza pedimento " + sql);
                st = cpttpu.prepareStatement(sql);
                st.executeUpdate();
            }
//             Fin detallado de documento
//              Status de kardex y dpedidos
//            Fin detallado documento
//          Insercion de polizas
            for (int x = 0; x < f.getArrpolizas().size(); x++) {
                int cuenta = f.getArrpolizas().get(x).getCuenta();
                int sub = f.getArrpolizas().get(x).getSub();
                String fechas = f.getArrpolizas().get(x).getFecha();
                int cliente = f.getArrpolizas().get(x).getIdcliente();
                String ident = f.getArrpolizas().get(x).getIdentificacion();
                String cuental = f.getArrpolizas().get(x).getCuentalarga();
                int t = f.getArrpolizas().get(x).getCa();
                String imps = f.getArrpolizas().get(x).getImporte();
                String concep = f.getArrpolizas().get(x).getConcepto();
                String Acum = f.getArrpolizas().get(x).getAcumulativo();
                String ref = f.getArrpolizas().get(x).getReferencia();
                String fo = f.getArrpolizas().get(x).getFolio();
                String mext = f.getArrpolizas().get(x).getMext();
                int ord = f.getArrpolizas().get(x).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
//                System.out.println("polizas " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            if (!relacion.equals("")) {
                sql = "update documento set tiporelacion='" + relacion + "', uuidorig='" + f.getSeriefoliofiscalorig() + "'  where id_documento=" + docu + "";
//                System.out.println("cpt relacion " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            rcpt.commit();
            cobranza.commit();
            cpttpu.commit();
            docu = resp;
        } catch (Exception ex) {
            try {
                docu = 0;
                con.rollback();
                rcpt.rollback();
                cobranza.rollback();
                cpttpu.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "insertar -" + ex1);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return docu;
    }

    /**
     * Inserta factura pero solo a las tablas de documentos y su detalle
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public int insertfacturatraslado(Connection con, Connection rcpt, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = 0;
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = 0;
            double total = 0;
            double iva = 0;
            double imp = 0;
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            String relacion = f.getTiporelacion();
            String folioorig = f.getFoliofiscalorig();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,foliofiscalorig,regimen,usocfdi,tiporelacion) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2023,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",?,'" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + folioorig + "'"
                    + ",'" + regimen + "','" + uso + "','" + relacion + "')";
//            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
//            System.out.println("rcpt documentos " + sql + "\n");
            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id from documentos where serie='TR'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id");
            }
            rs.close();
            //Fin obtener ultimo documento
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = 0;
                double b = 0;
                String impu = "000";
                String tas = "0.00";
                String tf = "Tasa";
                double impo = 0;
                double descu = 0;
                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
//                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
//                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
            }
//             Fin detallado de documento
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();

            con.commit();
            rcpt.commit();
//            con.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                rcpt.rollback();
                JOptionPane.showMessageDialog(null, "insertar traslado-" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "insertar traslado-" + ex1);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public int insertfacturaE(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String turno = f.getTurno();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
            int totalparesf = f.getTotalpares();
            String relacion = f.getTiporelacion();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",?,'" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
//            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.setString(1, nombre);
            st.executeUpdate();
//            System.out.println("rcpt documentos " + sql + "\n");

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0," + turno + "," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
//            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
//            Inserta en detallado de documentos
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                double c = arr.getCantidadfloat();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();

                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
//                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
//                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
            }
//            Fin detallado documento
//          
            for (int i = 0; i < f.getArrpolizas().size(); i++) {
                int cuenta = f.getArrpolizas().get(i).getCuenta();
                int sub = f.getArrpolizas().get(i).getSub();
                String fechas = f.getArrpolizas().get(i).getFecha();
                int cliente = f.getArrpolizas().get(i).getIdcliente();
                String ident = f.getArrpolizas().get(i).getIdentificacion();
                String cuental = f.getArrpolizas().get(i).getCuentalarga();
                int t = f.getArrpolizas().get(i).getCa();
                String imps = f.getArrpolizas().get(i).getImporte();
                String concep = f.getArrpolizas().get(i).getConcepto();
                String Acum = f.getArrpolizas().get(i).getAcumulativo();
                String ref = f.getArrpolizas().get(i).getReferencia();
                String fo = f.getArrpolizas().get(i).getFolio();
                String mext = f.getArrpolizas().get(i).getMext();
                int ord = f.getArrpolizas().get(i).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
//                System.out.println(sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
////            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
////            System.out.println("rcpt sfolios " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            actualizar relacion y series etq
            if (!relacion.equals("")) {
                sql = "update documentos set tiporelacion='" + relacion + "', foliofiscalorig='" + f.getSeriefoliofiscalorig() + "'  where id=" + resp + "";
//                System.out.println("rcpt sfolios " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cobranza.rollback();
                rcpt.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "insertar " + ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, "insertar " + ex1);
            }
        }
        return resp;
    }

    /**
     * Prueba: regresa las conexiones con las inserciones completadas
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public Conexiones insertfacturaEcon(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        Conexiones conex = new Conexiones();
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String turno = f.getTurno();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
            int totalparesf = f.getTotalpares();
            String relacion = f.getTiporelacion();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
//            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            System.out.println("rcpt documentos " + sql + "\n");

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0," + turno + "," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
//            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
//            Inserta en detallado de documentos
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                double c = arr.getCantidadfloat();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();

                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
//                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
//                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
            }
//            Fin detallado documento
//          
            for (int i = 0; i < f.getArrpolizas().size(); i++) {
                int cuenta = f.getArrpolizas().get(i).getCuenta();
                int sub = f.getArrpolizas().get(i).getSub();
                String fechas = f.getArrpolizas().get(i).getFecha();
                int cliente = f.getArrpolizas().get(i).getIdcliente();
                String ident = f.getArrpolizas().get(i).getIdentificacion();
                String cuental = f.getArrpolizas().get(i).getCuentalarga();
                int t = f.getArrpolizas().get(i).getCa();
                String imps = f.getArrpolizas().get(i).getImporte();
                String concep = f.getArrpolizas().get(i).getConcepto();
                String Acum = f.getArrpolizas().get(i).getAcumulativo();
                String ref = f.getArrpolizas().get(i).getReferencia();
                String fo = f.getArrpolizas().get(i).getFolio();
                String mext = f.getArrpolizas().get(i).getMext();
                int ord = f.getArrpolizas().get(i).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
//                System.out.println(sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
////            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
////            System.out.println("rcpt sfolios " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            actualizar relacion y series etq
            if (!relacion.equals("")) {
                sql = "update documentos set tiporelacion='" + relacion + "', foliofiscalorig='" + f.getSeriefoliofiscalorig() + "'  where id=" + resp + "";
//                System.out.println("rcpt sfolios " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cobranza.rollback();
                rcpt.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "insertar " + ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, "insertar " + ex1);
            }
        }
        conex.setRcpt(rcpt);
        conex.setCpt(con);
        conex.setCobranza(cobranza);
        conex.setResp(resp);
        return conex;
    }

    /**
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public int insertncr(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String cuentaa = f.getCuentaabono();
            String subc = f.getSubabono();
            String dcuenta = f.getDesccuenta();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = "NCR " + fol;
            int agente = f.getAgente();
            String relacion = f.getTiporelacion();
            String folioorig = f.getFoliofiscalorig();
            String referenciasfac = f.getRefncredito();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,foliofiscalorig,regimen,usocfdi,Tiporelacion) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + folioorig + "','" + regimen + "','" + uso + "','" + relacion + "')";
//            System.out.println("factura " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
//            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
//                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
//                    + "permiso,nuevoagente,fecharegistro) "
//                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
//                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
////            System.out.println("cargos" + sql);
//            st = cobranza.prepareStatement(sql);
//            st.executeUpdate();
            //Fin insertar cargos
            for (Dfactura arr : f.getArr()) {//Inserta en detallado de documentos
                int doc = resp;
                int prod = arr.getProducto();
                double c = arr.getCantidadfloat();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();
                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
//                System.out.println("d factura " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            // Fin detallado de documento
            // actualiza saldo de cargos
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                double descuento = f.getArrcargo().get(i).getDescuento();
                int cuenta = f.getArrcargo().get(i).getCuenta();
                int sub = f.getArrcargo().get(i).getSubcuenta();
                String referencia = f.getArrcargo().get(i).getReferencia();
                int cliente = f.getArrcargo().get(i).getCliente();
                sql = "update cargos set saldo=saldo-" + descuento + " where "
                        + "referencia='" + referencia + "' and cuenta=" + cuenta + " and subcuenta=" + sub + " and numcliente=" + cliente;
//                System.out.println("Actualizar cargos" + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }
            //fin actualiza cargos
            //Nuevos abonos
            int sub = 0;
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                double descuento = f.getArrcargo().get(i).getDescuento();
                int cuenta = f.getArrcargo().get(i).getCuenta();
                sub = f.getArrcargo().get(i).getSubcuenta();
                String referencia = f.getArrcargo().get(i).getReferencia();
                int cliente = f.getArrcargo().get(i).getCliente();
                String fechac = f.getArrcargo().get(i).getFecha();
                String fechan = formateafecha(fechac);
                sql = "insert into Abonos(cuenta,subcuenta,referencia,tiempo,fecha,fechapago,fdepdxc,turno,cveagente,cvebanco,"
                        + "totalpago,pago,descuento,comision,saldo,observaciones,cuentac,subcuentac,referenciac,"
                        + "numclientec,fechac,notadecredito,nuevacomision,usuario,permiso,fecharegistro) "
                        + "values (" + cuentaa + "," + subc + ",'" + m + "',NEWID(),'" + fecha + "','" + fecha + "','" + fecha + "',0," + agente + ",0,"
                        + total + "," + descuento + ",0,0,0,'" + dcuenta + "'," + cuenta + "," + sub + ",'" + referencia + "'," + cliente + ",'"
                        + fechan + "','" + m + "',0,'" + usuario + "',1,'" + fecha + "')";
//                System.out.println("Nuevo Abono " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }
            //Fin nuevos abonos
            //Nueva nota en bd
            sql = "insert into NotasCredito values ('" + m + "'," + idcliente + "," + subc + ",'" + fecha + "','" + referenciasfac + "','" + obs + "',0,"
                    + subtotal + "," + imp + "," + total + ",'A','" + usuario + "',1,'" + fecha + "',NULL)";
//            System.out.println("Nueva nota enca " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            for (int i = 0; i < f.getArr().size(); i++) {
                double descuento = f.getArr().get(i).getPrecioant();
                int cant = f.getArr().get(i).getCantidad();
                String descnota = f.getArr().get(i).getDescripcion();
                String deschar = "";
//                Funcion solo para acortar el numero de carateres ya que en la bd es mas corto que en las demas
                if (descnota.length() > 99) {
                    for (int x = 0; x < 99; x++) {
                        deschar += descnota.charAt(x);
                    }
                } else {
                    deschar = descnota;
                }
                sql = "insert into DNCredito values ('" + m + "'," + cant + ",'" + deschar + "'," + descuento + ")";
//                System.out.println("Nueva nota detallado " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }
            sql = "update seriesfolios set ultimofolio=ultimofolio+1 where serie='NCR'";
//            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();

            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                cobranza.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public int insertpagos(Connection con, factura f, String cob) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
//            cobranza.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String fechap = f.getFechapago();
            //pagos
            String rfcctaemi = f.getRfcctaemisora();
            String ctaemi = f.getCtaemisora();
            String bcoemi = f.getBancoemisor();
            String rfcctarep = f.getRfcctareceptor();
            String ctarep = f.getCtareceptora();
            String bcorep = f.getBancoreceptor();
            String op = f.getOrdenpago();
            double monto = f.getMonto();
//            System.out.println("monto " + monto);
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = formatnombre(f.getNombre());
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            String relacion = f.getTiporelacion();
            String folioorig = f.getFoliofiscalorig();
            sql = "insert into Doctospago(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,foliofiscalorig,regimen,usocfdi,Tiporelacion"
                    + ",Monto,Rfcctaemisora,ctaemisora,rfcctareceptora,ctareceptora,bancoemisor,bancoreceptor,ordenpago) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fechap + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "'"
                    + ",'" + folioorig + "','" + regimen + "','" + uso + "','" + relacion + "'"
                    + "," + monto + ",'" + rfcctaemi + "','" + ctaemi + "','" + rfcctarep + "','" + ctarep + "','" + bcoemi + "','" + bcorep + "','" + op + "')";
//            System.out.println("Pago " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();

            st = con.prepareStatement("select top(1)max(id) as id from doctospago group by fecha order by id desc");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id");
            }
            rs.close();
//            resp = f.getFolio();
            for (Detpagos arr : f.getArrpagos()) {
                //Inserta en detallado de detallado pago
                int doc = resp;
                double cant = arr.getCantidad();
                String de = arr.getDescripcion();
                String co = arr.getCodigo();
                String umed = arr.getUmedida();
                double precio = arr.getPrecio();
                String fp = arr.getFormadedpago();
                String moneda = arr.getMoneda();
                double mo = arr.getMonto();
                String rfcce = arr.getRfcctaemisora();
                String rfccr = arr.getRfcctareceptora();
                String ctae = arr.getCtaemisora();
                String ctar = arr.getCtareceptora();
                String uuid = arr.getUuid();
                String fo = arr.getRef();
                String mp = arr.getMetodopago();
                int par = arr.getParcialidad();
                double salant = arr.getImportesaldoant();
                double salpag = arr.getImportepagado();
                double salin = arr.getImpsaldoinsoluto();
                sql = "insert into doctospagodetalle(IdDocumento, Cantidad, Descripcion, Codigo, UMedida,"
                        + " Precio, FormadePago, MonedaPagoP, Monto, RFCCtaEmisora, CtaEmisora, RFCCtaReceptora,"
                        + " CtaReceptora, UUID, folio, Moneda, MetodoPago, \n"
                        + " NoParcialidad, ImporteSdoAnt, ImportePagado, ImpSaldoInsoluto) "
                        + "values(" + doc + "," + cant + ",'" + de + "','" + co + "','" + umed + "'," + precio + ",'" + fp + "','" + moneda + "',"
                        + mo + ",'" + rfcce + "','" + ctae + "','" + rfccr + "','" + ctar + "','" + uuid + "','" + fo + "','" + moneda + "','" + mp + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
//                System.out.println("d pagos " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            for (Detpagos arr : f.getArrpagos17()) {
                //Inserta en detallado de detallado pago
                int doc = resp;
                double cant = arr.getCantidad();
                String de = arr.getDescripcion();
                String co = arr.getCodigo();
                String umed = arr.getUmedida();
                double precio = arr.getPrecio();
                String fp = arr.getFormadedpago();
                String moneda = arr.getMoneda();
                double mo = arr.getMonto();
                String rfcce = arr.getRfcctaemisora();
                String rfccr = arr.getRfcctareceptora();
                String ctae = arr.getCtaemisora();
                String ctar = arr.getCtareceptora();
                String uuid = arr.getUuid();
                String fo = arr.getRef();
                String mp = arr.getMetodopago();
                int par = arr.getParcialidad();
                double salant = arr.getImportesaldoant();
                double salpag = arr.getImportepagado();
                double salin = arr.getImpsaldoinsoluto();
                sql = "insert into doctospagodetalle(IdDocumento, Cantidad, Descripcion, Codigo, UMedida,"
                        + " Precio, FormadePago, MonedaPagoP, Monto, RFCCtaEmisora, CtaEmisora, RFCCtaReceptora,"
                        + " CtaReceptora, UUID, folio, Moneda, MetodoPago, \n"
                        + "                         NoParcialidad, ImporteSdoAnt, ImportePagado, ImpSaldoInsoluto) "
                        + "values(" + doc + "," + cant + ",'" + de + "','" + co + "','" + umed + "'," + precio + ",'" + fp + "','" + moneda + "',"
                        + mo + ",'" + rfcce + "','" + ctae + "','" + rfccr + "','" + ctar + "','" + uuid + "','" + fo + "','" + moneda + "','" + mp + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
//                System.out.println("d pagos17 " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            // Fin detallado de documento

            sql = "update seriesfolios set ultimofolio=ultimofolio+1 where serie='PAG'";
//            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            cobranza.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
//                cobranza.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public boolean actualizafactura(Connection con, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            String cert = f.getCertificado();
            String sello = f.getSello();
            String cadena = f.getCadenaorig();
            sql = "update documentos set nodeseriecertificado=?, sello=?, cadenaoriginal=? where id=?";
//            System.out.println("actualizar sello " + sql);
            st = con.prepareStatement(sql);
            st.setString(1, cert);
            st.setString(2, sello);
            st.setString(3, cadena);
            st.setInt(4, f.getId());

            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean actualizafacturaconex(Connection con, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            String cert = f.getCertificado();
            String sello = f.getSello();
            String cadena = f.getCadenaorig();
            sql = "update documentos set nodeseriecertificado='" + cert + "', sello='" + sello + "', cadenaoriginal='" + cadena + "' where id=" + f.getId();
//            System.out.println("actualizar sello " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     *
     * @param con
     * @param f
     * @return
     */
    public boolean actualizapago(Connection con, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            String cert = f.getCertificado();
            String sello = f.getSello();
            String cadena = f.getCadenaorig();
            sql = "update doctospago set nodeseriecertificado='" + cert + "', sello='" + sello + "', cadenaoriginal='" + cadena + "' where id=" + f.getId();
//            System.out.println("actualizar pago sello " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     *
     * @param con: conexion a cpt o rcpt
     * @param s Clase sellofiscal
     * @param id
     * @return
     * @see Actualiza los datos faltantes de la factura que son los datos
     * fiscales de la factura
     */
    public boolean actualizasellos(Connection con, Sellofiscal s, int id) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update documentos set sellosat='" + s.getSellosat() + "',nodeseriecertificado='"
                    + s.getNoceertificado() + "', sellocfdi='" + s.getSellocfd() + "', fechacertificacion='"
                    + s.getFechacer() + "', foliofiscal='" + s.getUuid() + "' where id=" + id;
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     *
     * @param con
     * @param s
     * @param id
     * @return
     */
    public boolean actualizasellospago(Connection con, Sellofiscal s, int id) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update doctospago set sellosat='" + s.getSellosat() + "',nodeseriecertificado='"
                    + s.getNoceertificado() + "', sellocfdi='" + s.getSellocfd() + "', fechacertificacion='"
                    + s.getFechacer() + "', foliofiscal='" + s.getUuid() + "' where id=" + id;
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public int getmaxkardex(Connection con) {//ult kardex folio
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("SELECT  max(folio)as folio FROM Kardex WHERE Cuenta BETWEEN '50' AND '99'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxped(Connection con) {//ult pedido folio
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("SELECT MAX(Convert(INT, left(pedido,len(Pedido)-2))) as pedido FROM Pedidos Where Convert(INT, left(pedido,len(Pedido)-2)) < 5000000");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("pedido");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxfac(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select max(folio) as folio from documentos where serie='fac'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param serie
     * @return folio de seriesfolios
     */
    public int getmaxfac(Connection con, String serie) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select ultimofolio from seriesfolios where serie='" + serie + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("ultimofolio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxncr(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select max(folio) as folio from documentos where serie='ncr'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxpago(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+20 ),0,20) as fechav from doctospago group by fecha order by id desc");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     * Trae el ultimo folio de los traslados sin sumarle 1 unidad
     *
     * @param con Cpt
     * @return
     */
    public int getmaxtraslado(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select max(folio) as folio from documentos where serie='TR'";
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     * Filtra las facturas de acuerdo a la serie y solo trae el encabezado
     *
     * @param con conexion a rcpt
     * @param cob Nombre de la bd de cobranza
     * @param serie Serie a filtrar
     * @return
     */
    public ArrayList<factura> getfactwithserie(Connection con, String cob, String serie) {//max folio de documentos
        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(150) factura,fecha,year(fecha) as years,pedido,totalpares,c.nombre from facturas f\n"
                    + "join " + cob + ".dbo.Clientes c on f.numcliente=c.NumCliente\n"
                    + "where serie='" + serie + "' and estatus='F' \n"
                    + "order by fecha desc";
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                factura f = new factura();
                f.setReferencia(rs.getString("factura"));
                f.setYear(rs.getInt("years"));
                f.setNombrecliente(rs.getString("nombre"));
                f.setTotalpares(rs.getInt("totalpares"));
                f.setFechasolicitado(rs.getString("fecha"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Dfactura> getfactwithseriedetallado(Connection con, String fac, int year) {//max folio de documentos
        ArrayList<Dfactura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select factura, fecha,p.producto as prod,TotalPares, m.Descripcion+' '+col.Descripcion+' '+cor.Descripcion as comb,ClaveProdServ\n"
                    + "from dfacturas df\n"
                    + "join Productos p on df.Producto=p.Producto\n"
                    + "join corridas cor on p.Corrida=cor.Corrida\n"
                    + "join ClavesProductos cp on p.Codigo=cp.ClaveProdServ\n"
                    + "join combinaciones c on p.Combinacion=c.Combinacion\n"
                    + "join materiales m on c.Material1=m.material\n"
                    + "join colores col on c.Color1=col.Color\n"
                    + "where " + fac + " and year(fecha)=" + year;
//                    +"where factura='"+fac+"' and year(fecha)="+year;
            st = con.prepareStatement(sql);
//            System.out.println("detalle " + sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Dfactura d = new Dfactura();
                d.setFactura(rs.getString("factura"));
                d.setFecha(rs.getString("fecha"));
                d.setCantidad(rs.getInt("totalpares"));
                d.setDescripcion(rs.getString("comb"));
                d.setCodigo(rs.getString("ClaveProdServ"));
                d.setUmedida("PR");
                arr.add(d);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<ConceptosES> getcuentas(Connection con, String cuenta) {//max folio de documentos
        ArrayList<ConceptosES> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from catcuentas where cuenta=" + cuenta);
            rs = st.executeQuery();
            while (rs.next()) {
                ConceptosES c = new ConceptosES();
                c.setCuenta(rs.getString("Cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("Descripcion"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<ConceptosES> getcuentastpu(Connection con, String cuenta) {//max folio de documentos
        ArrayList<ConceptosES> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from catcuenta where cuenta=" + cuenta + " order by cuenta");
            rs = st.executeQuery();
            while (rs.next()) {
                ConceptosES c = new ConceptosES();
                c.setId_concepto(rs.getInt("id_concepto"));
                c.setCuenta(rs.getString("Cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("Descripcion"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<cargo> getfoliotoNCR(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct cuenta, subcuenta,c.referencia,c.fecha,importe,\n"
                    + "saldo,cli.nombre40,convert(date,fechavencimiento) as fechav,sim,c.plazo, c.numcliente,\n"
                    + " SUBSTRING(c.referencia,0,len(c.referencia)-1) as ref, d.FolioFiscal,c.cveagente,d.RFC,d.calle,d.Colonia,\n"
                    + "d.Municipio,d.Estado,d.Pais,cli.cp,cli.fax from cargos c\n"
                    + "join clientes cli on c.numcliente=cli.numcliente\n"
                    + "join " + bd + ".dbo.Documentos d on SUBSTRING(c.referencia,0,len(c.referencia)-1) =d.folio\n"
                    //                    + "where (c.numcliente like '%" + nombre + "%' or cli.nombre like '%" + nombre + "%') and c.referencia NOT Like '%NCR%'"
                    + "where (c.numcliente = '" + nombre + "' ) and c.referencia NOT Like '%NCR%'"
                    + " and saldo!=0 and d.Serie='fac' and estatus='1' and ISNULL(foliofiscal,'') !='' and foliofiscal!= 'null' order by c.fecha";
            st = con.prepareStatement(sql);
//            System.out.println("sql cargos" + sql);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                cargo c = new cargo();
                c.setCuenta(rs.getInt("cuenta"));
                c.setSubcuenta(rs.getInt("subcuenta"));
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(rs.getString("fecha"));
                c.setImporte(rs.getDouble("importe"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setSim(rs.getDouble("sim"));
                c.setNombre(rs.getString("nombre40"));
                c.setCliente(rs.getInt("numcliente"));
                c.setFechav(rs.getString("fechav"));
                c.setPlazo(rs.getInt("plazo"));
                c.setRef(rs.getString("ref"));
                c.setFoliofiscal(rs.getString("foliofiscal"));
                c.setAgente(rs.getInt("cveagente"));
                c.setRfc(rs.getString("rfc"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setMunicipio(rs.getString("municipio"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setRenglon(i);
                arr.add(c);
                i++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con conexion cpt
     * @param nombre Nombre o id del cliente
     * @param bd Nombre de la bd a cobranza
     * @return Arraylist de la clase cargo
     */
    public ArrayList<cargo> getfoliotoFACRel(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct d.folio,c.referencia,convert(date,d.fecha) as fecha,d.nombre, saldo, d.total, isnull(d.foliofiscal,'') as foliofiscal\n"
                    + " from documentos d\n"
                    + "join " + bd + ".dbo.Cargos c on SUBSTRING(c.Referencia,0,LEN(c.Referencia)-1)=convert(varchar,d.folio)\n"
                    + "where idcliente=" + nombre + " and d.serie='fac' and d.estatus='1' and isnull(d.foliofiscal,'')!=''\n"
                    + "order by d.fecha desc";
            st = con.prepareStatement(sql);
//            System.out.println("sql cargos fac " + sql);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                cargo c = new cargo();
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(rs.getString("fecha"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setNombre(rs.getString("nombre"));
                c.setFoliofiscal(rs.getString("foliofiscal"));
                c.setImporte(rs.getDouble("total"));
                c.setRenglon(i);
                arr.add(c);
                i++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<abono> getOrdenesp(Connection con, String nombre, String bd, int cuenta) {//cargos para ncr solo cobranza
        ArrayList<abono> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct a.referencia as op,a.totalpago,referenciac,c.numcliente,c.Nombre40, \n"
                    + "SUBSTRING(referenciac,0,len(a.referenciac)-1) as ref, d.FolioFiscal, \n"
                    + "c.rfc,c.CP,c.fax,c.calle,c.colonia,ci.Descripcion as ciudad, \n"
                    + "e.descripcion as estado,p.Descripcion as pais, car.Saldo, \n"
                    + " a.Pago, car.Saldo+a.Pago as anterior, a.cuenta,a.subcuenta,a.parcialidad,a.fechapago\n"
                    + "from " + bd + ".dbo.abonos a\n"
                    + "join " + bd + ".dbo.clientes c on a.NumClienteC=c.NumCliente\n"
                    + "join " + bd + ".dbo.Ciudades ci on c.CveCiudad=ci.CveCiudad\n"
                    + "join " + bd + ".dbo.Estados e on ci.CveEstado=e.CveEstado\n"
                    + "join " + bd + ".dbo.Paises p on e.CvePais=p.CvePais\n"
                    + "join Documentos d on SUBSTRING(referenciac,0,len(a.referenciac)-1)=d.folio \n"
                    + "join " + bd + ".dbo.Cargos car on a.referenciac=car.referencia\n"
                    + "where a.referencia like '" + nombre + "' and d.serie='FAC' and a.subcuenta=" + cuenta + "\n"
                    + "order by a.referencia";
//            System.out.println("sql get abonos" + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                abono a = new abono();
                Cliente c = new Cliente();
                double ar = rs.getDouble("saldo") + rs.getDouble("pago");
                a.setOrdenpago(rs.getString("op"));
                a.setReferencia(rs.getString("referenciac"));
                a.setRef(rs.getString("ref"));
                a.setFolio(rs.getString("foliofiscal"));
                a.setTotalpago(rs.getDouble("totalpago"));
                a.setTotal(rs.getDouble("totalpago"));
                a.setSaldo(rs.getDouble("saldo"));
                a.setPago(rs.getDouble("Pago"));
                a.setAnterior(ar);
                a.setCuenta(rs.getInt("cuenta"));
                a.setSubcuenta(rs.getInt("subcuenta"));
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                a.setParcialidad(rs.getInt("parcialidad"));
                a.setFechapago(rs.getString("fechapago"));
                a.setC(c);
                arr.add(a);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con
     * @param ncliente
     * @return
     */
    public ArrayList<Cliente> getClientesfacs(Connection con, String ncliente) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(15) isnull(Nombre40,'') as nombre, numcliente,c.RFC,c.CP,c.fax,"
                    + "c.calle,c.colonia,ci.Descripcion as ciudad,e.descripcion as estado,"
                    + "p.Descripcion as pais,ISNULL(c.CveMetodoPago,'') as mpago,ISNULL(paginaweb,'') as uso, plazo, agente1, ag.CveCanal\n"
                    + "from Clientes c\n"
                    + "join Ciudades ci on c.CveCiudad=ci.CveCiudad\n"
                    + "join Estados e on ci.CveEstado=e.CveEstado \n"
                    + "join Paises p on e.CvePais=p.CvePais\n"
                    + "join agentes ag on c.Agente1=ag.CveAgente\n"
                    + "where (numcliente like '%" + ncliente + "%' or Nombre40 like '%" + ncliente + "%') and isnull(nombre40,'')!=''\n"
                    + "group by nombre40,numcliente, c.RFC,c.CP,c.fax,c.calle,c.colonia,ci.Descripcion,e.descripcion,p.Descripcion,c.CveMetodoPago,paginaweb,plazo,agente1,ag.CveCanal\n"
                    + "order by nombre40 desc";
//            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                c.setAgente(rs.getInt("agente1"));
                c.setPlazo(rs.getInt("plazo"));
                c.setFormapago(rs.getString("mpago"));
                c.setUsocfdi(rs.getString("uso"));
                c.setClave(rs.getString("CveCanal"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean cancelafac(Connection cpt, Connection rcpt, Connection cob, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            cpt.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            cob.setAutoCommit(false);
            String sql = "update documentos set estatus='0', fechacancel='" + f.getFechacancel() + "' where folio=" + f.getFolio();
//            System.out.println("cancela doc " + sql);
            st = cpt.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            sql = "update cargos set saldo=0 where SUBSTRING(referencia,0,len(referencia)-1)='" + f.getFolio() + "'";
//            System.out.println("cancela cargo " + sql);
            st = cob.prepareStatement(sql);
            st.executeUpdate();
            cpt.commit();
            rcpt.commit();
            cob.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                cpt.rollback();
                rcpt.rollback();
                cob.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    // solo por que al principio no se especifico esta parte
    public ArrayList<Poliza> getpolizas(Connection con, String cob) {//ult kardex folio
        ArrayList<Poliza> arr = new ArrayList<>();
        Formateodedatos fd = new Formateodedatos();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct '1' as cuentamov,'5' as subctamov,d.fecha,CONVERT(varchar,folio)+' O' folio,IdCliente,'M' m,"
                    + "(subtotal-d.descuento) as subtotal,Impuestos,total,asi.Cuenta,"
                    + " asi.SubCuenta, asi.Concepto, asi.Orden, asi.Acumulativa, ag.CveCanal,ca,c.Agente1\n"
                    + "from Documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.IdCliente=c.NumCliente\n"
                    + "join " + cob + ".dbo.Agentes ag on ag.CveAgente=c.Agente1\n"
                    + "join " + cob + ".dbo.AsientosContables asi on asi.Asiento='1'\n"
                    + "join " + cob + ".dbo.cargos a on SUBSTRING(a.referencia,0,len(a.referencia)-1)=convert(varchar,d.Folio)\n"
                    + "where d.estatus=1 and year(d.fecha)=2023 and month(d.fecha)>4 and d.serie='fac'\n"
                    + "order by d.folio desc";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int conta = 0;
            while (rs.next()) {
                String c = rs.getString("Cuenta");
                String cuenta = fd.convertcliente(c + fd.formatclientedigito(rs.getString("idcliente")));
                Poliza p = new Poliza();
                p.setCuenta(1);
                p.setSub(5);
                p.setFecha(fd.ffecha(rs.getString("fecha")));
                p.setFolio(rs.getString("folio"));
                p.setIdcliente(rs.getInt("idcliente"));
                p.setIdentificacion("M");
                p.setCuentalarga(cuenta);
                p.setCa(rs.getInt("ca"));
                p.setOrden(rs.getInt("orden"));
                p.setDiario("000");
                p.setMext("0.00");
                p.setAcumulativo(rs.getString("acumulativa"));
                p.setConcepto(rs.getString("concepto") + " " + rs.getString("folio"));
                if (rs.getString("cuenta").equals("4005")) {
                    p.setReferencia(rs.getString("cvecanal") + "1" + fd.convierteagente(rs.getString("agente1")) + " 4.001");
                } else {
                    p.setReferencia("4.001");
                }
                switch (conta) {
                    case 0:
                        p.setImporte(fd.ftotal(rs.getString("total")));
                        conta++;
                        break;
                    case 1:
                        p.setImporte(fd.ftotal(rs.getString("impuestos")));
                        conta++;
                        break;
                    case 2:
                        p.setImporte(fd.ftotal(rs.getString("subtotal")));
                        conta = 0;
                        break;
                }
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void setpoliza(Connection cob, ArrayList<Poliza> arr) {
        try {
            PreparedStatement st = null;
            cob.setAutoCommit(false);
            for (int i = 0; i < arr.size(); i++) {
                int cuenta = arr.get(i).getCuenta();
                int sub = arr.get(i).getSub();
                String fecha = arr.get(i).getFecha();
                int cliente = arr.get(i).getIdcliente();
                String ident = arr.get(i).getIdentificacion();
                String cuental = arr.get(i).getCuentalarga();
                int t = arr.get(i).getCa();
                String imp = arr.get(i).getImporte();
                String concep = arr.get(i).getConcepto();
                String Acum = arr.get(i).getAcumulativo();
                String ref = arr.get(i).getReferencia();
                String fol = arr.get(i).getFolio();
                String mext = arr.get(i).getMext();
                int ord = arr.get(i).getOrden();
                String sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" 
                        + fecha + "','" + fol + "',"+ cliente + ",'" + ident + "','" 
                        + cuental + "','" + ref + "','" + t + "','" + imp + "','" 
                        + arr.get(i).getDiario() + "','" + mext + "','" + concep + "'," 
                        + ord + ",'" + Acum + "')";
//                System.out.println(sql);
                st = cob.prepareStatement(sql);
                st.executeUpdate();
            }
            cob.commit();
        } catch (SQLException ex) {
            try {
                cob.rollback();
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Obtener los asientos contables
     *
     * @param concob Conexion de cobranza
     * @return La lista de los asientos contalbles
     */
    public ArrayList<Poliza> getAsientoscontables(Connection concob) {
        ArrayList<Poliza> arr = new ArrayList<>();
        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            String sql = "select * from asientoscontables";
//            System.out.println("asientos " + sql);
            st = concob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Poliza p = new Poliza();
                p.setCuentalarga(rs.getString("cuenta"));
//                p.setSub(rs.getInt("subcuenta"));
                p.setConcepto(rs.getString("concepto"));
                p.setCa(rs.getInt("ca"));
                p.setImporte(rs.getString("importe"));
                p.setOrden(rs.getInt("Orden"));
                p.setAcumulativo(rs.getString("Acumulativa"));
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Modificacion de pedido por un rango de factura
     *
     * @param rcpt
     * @param cpt
     * @param f1
     * @param f2
     * @param pedido
     * @return
     */
    public boolean modpedido(Connection rcpt, Connection cpt, int f1, int f2, String pedido) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            rcpt.setAutoCommit(false);
            cpt.setAutoCommit(false);
            String sql = "update documentos set numpedido='" + pedido + "' "
                    + "where serie='FAC' and folio between '" + f1 + "' and '" + f2 + "'";
//            System.out.println("ped doc " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            st = cpt.prepareStatement(sql);
            st.executeUpdate();
            sql = "update facturas set pedido='" + pedido + "' where factura between '" + f1 + "' and '" + f2 + "'";
//            System.out.println("ped fac " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            st = cpt.prepareStatement(sql);
            st.executeUpdate();
            rcpt.commit();
            cpt.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                rcpt.rollback();
                cpt.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean modcajas(Connection rcpt, Connection cpt, int cajas, int folio) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            rcpt.setAutoCommit(false);
            cpt.setAutoCommit(false);
            String sql = "update documentos set totalcajas=" + cajas + " where serie='FAC' and folio=" + folio;
//            System.out.println("cajas doc " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            st = cpt.prepareStatement(sql);
            st.executeUpdate();
            rcpt.commit();
            cpt.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                rcpt.rollback();
                cpt.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean updateclientedoc(Connection c, Cliente cl, int id) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String n = cl.getNombre();
            String rfc = cl.getRfc();
            String cp = cl.getCp();
            //String sql = "update documentos set nombre='" + n + "', rfc='" + rfc + "',cp='" + cp + "'  where id=" + id;
            String sql = "update documentos set nombre=?, rfc=?, cp=?  where id=?";
//            System.out.println("update cliente " + sql);
            st = c.prepareStatement(sql);
            st.setString(1, n);
            st.setString(2, rfc);
            st.setString(3, cp);
            st.setInt(4, id);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, ex1);
            }
            return false;
        }
    }

    //Metodos para cancelar
    /**
     * Valida si la factura tiene algun pago
     *
     * @param cob
     * @param factura
     * @return
     */
    public int getAbonosByFactura(Connection cob, String factura) {
        int count = 0;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = cob.prepareCall("{call stp_getAbonosByFactura(?)}");
            st.setString(1, factura);
            rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt("datos");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return count;
    }

    /**
     * Obtiene la fecha del cargo
     *
     * @param cob
     * @param factura
     * @return
     */
    public Object getFechaCargo(Connection cob, String factura) {
        Object fecha = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = cob.prepareCall("{call stp_getFechaCargo(?)}");
            st.setString(1, factura);
            rs = st.executeQuery();

            while (rs.next()) {
                fecha = rs.getObject("fecha");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return fecha;
    }

    public ArrayList<Dfactura> getDetalleFactura(Connection cpt, String factura) {
        ArrayList<Dfactura> lista = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = cpt.prepareCall("{call stp_getDetalleFactura(?)}");
            st.setString(1, factura);
            rs = st.executeQuery();

            while (rs.next()) {
                Dfactura obj = new Dfactura();
                obj.setAlmacen(rs.getInt("Almacen"));
                obj.setProducto(rs.getInt("Producto"));
                obj.setRenglon(rs.getInt("Renglon"));
                obj.setCantidad(rs.getInt("TotalPares"));
                obj.setPrecio(rs.getDouble("Precio"));
                obj.setCosto(rs.getDouble("Costo"));
                obj.setC1(rs.getInt("Cant1"));
                obj.setC2(rs.getInt("Cant2"));
                obj.setC3(rs.getInt("Cant3"));
                obj.setC4(rs.getInt("Cant4"));
                obj.setC5(rs.getInt("Cant5"));
                obj.setC6(rs.getInt("Cant6"));
                obj.setC7(rs.getInt("Cant7"));
                obj.setC8(rs.getInt("Cant8"));
                obj.setC9(rs.getInt("Cant9"));
                obj.setC10(rs.getInt("Cant10"));
                obj.setC11(rs.getInt("Cant11"));
                obj.setC12(rs.getInt("Cant12"));
                obj.setC13(rs.getInt("Cant13"));
                obj.setC14(rs.getInt("Cant14"));
                obj.setStock(rs.getString("StockPedidos"));
                obj.setFactura(rs.getString("Factura"));
                obj.setPedido(rs.getString("Pedido"));
                obj.setSerie(rs.getString("Serie"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }

    /**
     * Verificar si es factura especial
     *
     * @param cpt
     * @param factura
     * @return
     */
    public int getTipoFactura(Connection cpt, int factura) {
        int folio = 0;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = cpt.prepareCall("{call stp_getTipoFactura(?)}");
            st.setInt(1, factura);
            rs = st.executeQuery();

            while (rs.next()) {
                folio = rs.getInt("Factura");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return folio;
    }

    /**
     * Cancela una factura especial
     *
     * @param cpt
     * @param rcpt
     * @param f
     * @param a
     * @return
     */
    public boolean cancelarFacturaEspecial(Connection cpt, Connection rcpt, factura f, abono a) {
        PreparedStatement st = null;
        try {
            cpt.setAutoCommit(false);
            rcpt.setAutoCommit(false);

            st = cpt.prepareCall("{call stp_cancelarFacturaEspecial(?,?,?,?,?,?,?,?,?)}");
            st.setString(1, String.valueOf(f.getFolio()));
            st.setObject(2, f.getFechacancel());
            st.setObject(3, a.getFechap());
            st.setString(4, a.getReferencia());
            st.setDouble(5, a.getTotalpago());
            st.setDouble(6, a.getPago());
            st.setString(7, a.getReferenciac());
            st.setInt(8, a.getCliente());
            st.setObject(9, a.getFechac());
            st.executeUpdate();

            /*st = rcpt.prepareCall("{call stp_cancelarFacturaEspecial(?,?)}");
            st.setString(1, String.valueOf(f.getFolio()));
            st.setObject(2, f.getFechacancel());
            st.executeUpdate();*/
            cpt.commit();
            rcpt.commit();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            try {
                cpt.rollback();
                rcpt.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     * Cancela una factura normal
     *
     * @param cpt
     * @param rcpt
     * @param f
     * @param a
     * @return
     */
    public boolean cancelarFacturaNormal(Connection cpt, Connection rcpt, factura f, abono a) {
        PreparedStatement st = null;
        Connection[] datos = {cpt, rcpt};
        try {
            cpt.setAutoCommit(false);
            rcpt.setAutoCommit(false);

            for (Connection dato : datos) {
                st = dato.prepareCall("{call stp_cancelarFacturaNormal(?,?,?,?,?,?,?,?,?)}");
                st.setString(1, String.valueOf(f.getFolio()));
                st.setObject(2, f.getFechacancel());
                st.setObject(3, a.getFechap());
                st.setString(4, a.getReferencia());
                st.setDouble(5, a.getTotalpago());
                st.setDouble(6, a.getPago());
                st.setString(7, a.getReferenciac());
                st.setInt(8, a.getCliente());
                st.setObject(9, a.getFechac());
                st.executeUpdate();
            }
            cpt.commit();
            rcpt.commit();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            try {
                cpt.rollback();
                rcpt.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     * Cancela una factura normal
     *
     * @param cpt
     * @param rcpt
     * @param f
     * @param a
     * @param data
     * @return
     */
    public boolean cancelarFacturaNormal(Connection cpt, Connection rcpt, factura f, abono a, ArrayList<Kardex> data) {
        PreparedStatement st = null;
        int row = 0;
        try {
            cpt.setAutoCommit(false);
            rcpt.setAutoCommit(false);

            st = cpt.prepareCall("{call stp_cancelarFacturaNormal(?,?,?,?,?,?,?,?,?)}");
            st.setString(1, String.valueOf(f.getFolio()));
            st.setObject(2, f.getFechacancel());
            st.setObject(3, a.getFechap());
            st.setString(4, a.getReferencia());
            st.setDouble(5, a.getTotalpago());
            st.setDouble(6, a.getPago());
            st.setString(7, a.getReferenciac());
            st.setInt(8, a.getCliente());
            st.setObject(9, a.getFechac());
            st.executeUpdate();

            st = rcpt.prepareCall("{call stp_cancelarFacturaNormal(?,?)}");
            st.setString(1, String.valueOf(f.getFolio()));
            st.setObject(2, f.getFechacancel());
            st.executeUpdate();

            for (Kardex dt : data) {
                row++;
                st = cpt.prepareCall("{call stp_insertarKardexCancelacionAbono(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                st.setInt(1, dt.getAlmacen());
                st.setInt(2, dt.getProducto());
                st.setInt(3, dt.getFolio());
                st.setInt(4, row);
                st.setInt(5, dt.getCl_prv());
                st.setString(6, dt.getCuenta());
                st.setString(7, dt.getSubCuenta());
                st.setInt(8, dt.getTotalpares());
                st.setDouble(9, dt.getPcosto());
                st.setDouble(10, dt.getPventa());
                st.setDouble(11, dt.getImporte_costo());
                st.setInt(12, dt.getC1());
                st.setInt(13, dt.getC2());
                st.setInt(14, dt.getC3());
                st.setInt(15, dt.getC4());
                st.setInt(16, dt.getC5());
                st.setInt(17, dt.getC6());
                st.setInt(18, dt.getC7());
                st.setInt(19, dt.getC8());
                st.setInt(20, dt.getC9());
                st.setInt(21, dt.getC10());
                st.setInt(22, dt.getC11());
                st.setInt(23, dt.getC12());
                st.setInt(24, dt.getC13());
                st.setInt(25, dt.getC14());
                st.setString(26, dt.getStock_pedidos());
                st.setString(27, dt.getPedido());
                st.setInt(28, dt.getRenglon_p());
                st.setString(29, dt.getFactura());
                st.setString(30, dt.getSerie());
                st.setString(31, dt.getUsuario());
                st.execute();
            }
            cpt.commit();
            rcpt.commit();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            try {
                cpt.rollback();
                rcpt.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     * Obtiene la orden de pago
     *
     * @param cpt
     * @param folio
     * @return
     */
    public ArrayList<String> getOrdenPago(Connection cpt, int folio) {
        ArrayList<String> orden = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = cpt.prepareCall("{call stp_getOrdenPago(?)}");
            st.setInt(1, folio);
            rs = st.executeQuery();

            while (rs.next()) {
                orden.add(rs.getString("OrdenPago"));
                orden.add(rs.getString("IdCliente"));
                orden.add(rs.getString("FolioFiscal"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return orden;
    }

    public boolean cancelarPago(Connection cpt, int folio, String referencia, int cliente) {
        PreparedStatement st = null;
        try {
            cpt.setAutoCommit(false);
            st = cpt.prepareCall("{call stp_cancelar_pago(?,?,?)}");
            st.setInt(1, folio);
            st.setString(2, referencia);
            st.setInt(3, cliente);
            st.executeUpdate();
            cpt.commit();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            try {
                cpt.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     * Obtiene la fecha del cargo
     *
     * @param cob
     * @param factura
     * @return
     */
    public ArrayList<String> getClienteCargo(Connection cob, String factura) {
        ArrayList<String> lista = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = cob.prepareCall("{call stp_getClienteC(?)}");
            st.setString(1, factura);
            rs = st.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("fecha"));
                lista.add(rs.getString("NumCliente"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
    //metodos externos
}