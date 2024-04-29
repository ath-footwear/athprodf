/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.toedter.calendar.JDateChooser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GATEWAY1-
 */
public class Formateodedatos {

    /**
     * Obtiene el codigo postal de expedicion
     *
     * @return
     */
    public String Lugarexp() {
        return "36350";
    }

    /**
     * Formateo de fechas al tomarla de la bd
     *
     * @param fecha
     * @return
     */
    public String ffecha(String fecha) {
        String resp = "";
        for (int i = 0; i < fecha.length() - 2; i++) {
            if (fecha.charAt(i) == ' ') {
                resp += "T";
            } else {
                resp += fecha.charAt(i) + "";
            }
        }
        return resp;
    }

    /**
     * formateo de cadena del cliente para poliza
     *
     * @param cliente
     * @return
     */
    public String convertcliente(String cliente) {
        String resp = cliente;
        for (int i = 0; i < 14 - cliente.length(); i++) {
            resp += "0";
        }
//        System.out.println(resp);
        return resp;
    }

    /**
     * formateo de cadena de agente
     *
     * @param agente
     * @return
     */
    public String convierteagente(String agente) {
        String resp;
        if (agente.length() == 2) {
            resp = agente;
        } else {
            resp = "0" + agente;
        }

        return resp;
    }

    /**
     * Totales para poliza
     *
     * @param cant
     * @return
     */
    public String ftotal(String cant) {
        String resp = "";
        String respfinal = "";
        int a = 0;
        int cont = 0;
        boolean band = false;
        String decimal = "";
        String entero = "";
        for (int i = 0; i < cant.length(); i++) {
            if (cant.charAt(i) == '.' || band) {
                band = true;
                decimal += cant.charAt(i);
                if (a == 2) {
                    resp = cant;
                    break;
                }
                a++;
            } else {
                entero += cant.charAt(i);
                cont++;
            }

        }
        if (decimal.length() == 2) {
            decimal = decimal + "0";
        }
//        System.out.println(entero+decimal);
        int ncaracter = entero.length() + decimal.length();
        if (band == false) {
            resp = cant + ".00";
        }
        for (int i = 0; i < 16 - ncaracter; i++) {
            respfinal += "0";
        }
        return respfinal + "" + entero + "" + decimal;
    }

    /**
     * Formatea las cantidades a 2 digitos y revisa si se redondea o se trunca.
     * * por revisar mas a fondo
     *
     * @param cant
     * @return
     */
    public double formatdecimal(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(cant);
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato <= 5)) {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    /**
     * Formatea las cantidades a 2 digitos y revisa si se redondea o se trunca.
     * * por revisar mas a fondo, una variante de la primer funcion, lo
     * cambiante es que al inicio de la funcion se redondea a 3 digitos y de ahi
     * se procede a verificar sus decimales
     *
     * @param cant
     * @return
     */
    public double formatdecimalv2(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(cant);
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato < 5)) {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    /**
     * Utilizado para manejo de cantidades en inventarios o movimientos de
     * almacen
     *
     * @param cant
     * @return
     */
    public double formatdecimaltruncado(double cant) {
        double resp;
        String c = String.valueOf(BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR));
        resp = BigDecimal.valueOf(Double.parseDouble(c)).setScale(2, RoundingMode.FLOOR).doubleValue();
        return resp;
    }

    public String formatclientedigito(String cliente) {
        String resp = "";
        if (cliente.length() != 4) {
            for (int i = cliente.length(); i < 4; i++) {
                resp += "0";
            }
        }
        resp = resp + cliente;
        System.out.println(resp);
        return resp;
    }

    /**
     * Verifica que en la variable solo haya numero enteros del 0 al 9
     *
     * @param cad
     * @return
     */
    public boolean verificaint(String cad) {
        boolean resp = false;
        String patt = "[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    /**
     * Verifica la variable que sea un numero decimal
     *
     * @param cad
     * @return
     */
    public boolean verificafloat(String cad) {
        boolean resp = false;
        String patt = "[0-9]+||[0-9]+.[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    /**
     * Verifica que el objeto de seleccion de fechas sea nulo
     *
     * @param jt
     * @return
     */
    public boolean verficafechanula(JDateChooser jt) {
        return (jt.getDate() == null);
    }

    public String formateamesrespaldo(int m) {
        String mes = "";
        switch (m) {
            case 1:
                mes = "Ene";
                break;
            case 2:
                mes = "Feb";
                break;
            case 3:
                mes = "Mar";
                break;
            case 4:
                mes = "Abr";
                break;
            case 5:
                mes = "May";
                break;
            case 6:
                mes = "Jun";
                break;
            case 7:
                mes = "Jul";
                break;
            case 8:
                mes = "Ago";
                break;
            case 9:
                mes = "Sep";
                break;
            case 10:
                mes = "Oct";
                break;
            case 11:
                mes = "Nov";
                break;
            case 12:
                mes = "Dic";
                break;
            default:
                break;
        }
        return mes;
    }

    public String formateayearrespaldo(String year) {
        String y = "";
        for (int i = 2; i < 4; i++) {
            y += year.charAt(i);
        }
        return y;
    }

    /**
     * Verifica el string sin tienen solo puro alfanumerico y sin ningun
     * caracter
     *
     * @param cad
     * @return
     */
    public boolean verificaStringsSC(String cad) {
        boolean resp = false;
        String patt = "[\\s\\w@#.,ñÑ-]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    /**
     * Obtiene el nombre de la imagen para el reporte de acuerdo al usuario por
     * ahora solo aplica para tpu y maquinaria
     *
     * @param u
     * @return
     */
    public String getimagenreporte(Usuarios u) {
        return "C:\\af\\prod\\images\\" + u.getImag();
    }

    /**
     * Obtiene el formateo del folio de la remision de acuerdo al turno
     *
     * @param turno
     * @param mes
     * @param folio
     * @return Remision TPU,MAQ, TMAQ + folio
     */
    public String folioremision(String turno, int mes, int folio) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "TPU " + mes + "-" + folio;
                break;
            case "6":
                resp = "MAQ " + mes + "-" + folio;
                break;
            case "7":
                resp = "TMAQ " + mes + "-" + folio;
                break;
        }
        return resp;
    }

    /**
     * +
     * Obtiene la bd de la base de datos del servidor interno reservado para
     * remisiones o serie B, la cual verifica que turno es y le asigna la base
     * de datos indicada
     *
     * @param turno
     * @return [192.168.90.1\\datos620].RACObranza....
     */
    public String getBDcob_REMinterna(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "[192.168.90.1\\DATOS620].RACobranzaTpu.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
                break;
            case "6":
                resp = "[192.168.90.1\\DATOS620].RACobranzamaq.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
                break;
            case "7":
                resp = "[192.168.90.1\\DATOS620].RACobranzamaq2.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
                break;
        }
        return resp;
    }

    /**
     * Verifica y obtiene el tipo de base de datos de cobranza a usar, y utiliza
     * el tipo de usuario para diferenciar entre el usuario normal y pruebas,
     * dentro de eso el turno, ya que de ahi deriva la base de datos de cada
     * nueva empresa.
     *
     * @param tipo
     * @param turno
     * @param serie
     * @return 192.168.90.1\\DATOS620].RACob... O RACobranza, Acobranza
     */
    public String getB_or_Amovs(String tipo, String turno, String serie) {
        String cob = "";
//        Primero de verifica el tipo de usuario
        if (tipo.equals("2")) {
//            Des pues el turno para saber que bd a usar
            switch (turno) {
//                Variable para uso en modo de pruebas
                case "5":
                    cob = (serie.equals("B")) ? "RACobranzaTpu" : "ACobranzaTpu";
                    break;
                case "6":
                    cob = (serie.equals("B")) ? "RACobranzamaq" : "ACobranzamaq";
                    break;
                case "7":
                    cob = (serie.equals("B")) ? "RACobranzamaq2" : "ACobranzamaq2";
                    break;
            }
        } else {
//            Variable para produccion
            switch (turno) {
                case "5":
                    cob = (serie.equals("B")) ? "[192.168.90.1\\DATOS620].RACobranzaTpu" : "ACobranzaTpu";
                    break;
                case "6":
                    cob = (serie.equals("B")) ? "[192.168.90.1\\DATOS620].RACobranzamaq" : "ACobranzamaq";
                    break;
                case "7":
                    cob = (serie.equals("B")) ? "[192.168.90.1\\DATOS620].RACobranzamaq2" : "ACobranzamaq2";
                    break;
            }
        }
        return cob;
    }

    /**
     * De acuerdo al turno asigna la serie al tipo de documento
     *
     * @param turno
     * @return FAC o MFAC, n FAC de acuerdo a configuraciones
     */
    public String SerieFiscal(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "FACTPU";
                break;
            case "7":
                resp = "FACMAQ";
                break;
        }
        return resp;
    }

    /**
     * Parecido al de facturacion solo que para ncr
     *
     * @param turno
     * @return NCR.....
     */
    public String SerieFiscal_NCR(String turno) {
        String resp = "";
        switch (turno) {
            case "0":
                resp = "NCR";
                break;
            case "5":
                resp = "NCRTPU";
                break;
            case "7":
                resp = "NCRMAQ";
                break;
        }
        return resp;
    }

    /**
     * Parecido al de facturacion solo que para ncr
     *
     * @param turno
     * @return PAG.....
     */
    public String SerieFiscal_PAG(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "PAGTPU";
                break;
            case "7":
                resp = "PAGMAQ";
                break;
        }
        return resp;
    }

    /**
     * Obtiene el nombre de la base de datos de cobranza para hacer join con
     * cargos, para esto es necesario el turno del usuario ya que pueden ser
     * varias empresas las que esten implicadas o un posible futuro.
     *
     * @param turno
     * @return ACobranza...;
     */
    public String getbd_tocargo(String turno) {
        String resp = "";
        switch (turno) {
            case "0":
                resp = "ACobranza";
                break;
            case "5":
                resp = "ACobranzaTpu";
                break;
            case "7":
                resp = "ACobranzaMaq2";
                break;
        }
        return resp;
    }

    /**
     * Bd para cobranza interna mediante el turno del usuario
     *
     * @param turno
     * @return bd cobranza interna "192.168.90.1\\RACObranza....."
     */
    public String getbd_tocargo_REM(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "[192.168.90.1\\DATOS620].RACobranzaTpu";
                break;
            case "6":
                resp = "[192.168.90.1\\DATOS620].RACobranzamaq";
                break;
            case "7":
                resp = "[192.168.90.1\\DATOS620].RACobranzamaq2";
                break;
        }
        return resp;
    }

    /**
     * Bd para cobranza interna mediante el turno del usuario solo admin y
     * usuario de prueba
     *
     * @param turno
     * @return bd cobranza interna "RACObranza....."
     */
    public String getbd_tocargo_REM_adm(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "RACobranzaTpu";
                break;
            case "6":
                resp = "RACobranzamaq";
                break;
            case "7":
                resp = "RACobranzamaq2";
                break;
        }
        return resp;
    }

    /**
     * Obtiene la ruta y nombre del reporte de inventario
     *
     * @param turno
     * @return Ruta reporte
     */
    public String getReporte_inv(String turno) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = "/Reportestpu/Invsiscap_1";
                break;
            case "6":
                resp = "RACobranzamaq";
                break;
            case "7":
                resp = "/ReportesMaq/Invsiscap_M";
                break;
        }
        return resp;
    }

    /**
     * Obtiene la descripcion del material de acuerdo al dpedimento y turno
     *
     * @param turno
     * @param dp
     * @return Nombre dle material
     */
    public String getnuevoinv(String turno, Dpedimento dp) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = dp.getMatped() + " " + dp.getDureza();
                break;
            case "6":
                resp = dp.getMatped();
                break;
            case "7":
                resp = dp.getMatped();
                break;
        }
        return resp;
    }

    /**
     * Obtiene el nombre integro de la bd con respecto al turno, solo de CPT
     * Tambien utilizado por si en B es necesario usar el 6.8 para consulta de
     * datos
     *
     * @param turno
     * @param serie
     * @return
     */
    public String getbdto_respinv_orig(String turno, String serie) {
        String resp = "";
        String svr="[192.168.6.8\\Datos65]";
        switch (turno) {
            case "5":
                resp = (serie.equals("A")) ? "Tpucpt" : svr+".Tpucpt";
                break;
            case "6":
                resp = (serie.equals("A")) ? "Maqcpt" : svr+".Maqcpt";
                break;
            case "7":
                resp = (serie.equals("A")) ? "CPTMaquinaria2" : svr+".CPTMaquinaria2";
                break;
        }
        return resp;
    }

    /**
     * Obtiene la conexion de cobranza de acuerdo al turno
     *
     * @param turno
     * @param con
     * @param serie
     * @return
     */
    public Connection Getconnection_toturno_cob(String turno, Conexiones con, String serie) {
        Connection c = null;
        switch (turno) {
            case "5":
            case "7":
                c = (serie.equals("A"))
                        ? con.getCobranzatpu() : con.getCobranzatpuB();
                break;
            case "6":
                c = con.getCobranzatpuB();
                break;
        }
        return c;
    }

    /**
     * Obtiene la descripcion de acuerdo al turno
     *
     * @param turno
     * @param m Objeto tipo materiales
     * @return String
     */
    public String getmatdescripcion_withturno(String turno, Materiales m) {
        String resp = "";
        switch (turno) {
            case "5":
                resp = m.getDescripcion();
                break;
            case "6":
            case "7":
                resp =m.getTipo_maquina();
                break;
        }
        return resp;
    }
}
