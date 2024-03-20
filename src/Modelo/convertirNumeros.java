package Modelo;

import java.util.regex.Pattern;

public class convertirNumeros {

    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};

    public String Convertir(String numero, boolean mayusculas, String moneda) {
        String literal = "";
        String parte_decimal;
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if (numero.indexOf(",") == -1) {
            numero = numero + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");
            //de da formato al numero decimal
            parte_decimal = Num[1] + "/100 M.N.";
            //se convierte el numero a literal
            if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                literal = getUnidades(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (moneda.equals("MXN")) {
                if (mayusculas) {
                    return (literal + "PESOS " + parte_decimal).toUpperCase();
                } else {
                    return (literal + "PESOS " + parte_decimal);
                }
            } else {
                if (mayusculas) {
                    return (literal + "DOLARES " + parte_decimal).toUpperCase();
                } else {
                    return (literal + "DOLARES " + parte_decimal);
                }
            }

        } else {//error, no se puede convertir
            return literal = null;
        }
    }

    private String getUnidades(String numero) {
        //Si tuviera un 0 antes se lo quita ->09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String numero) {
        int n = Integer.parseInt(numero);
        if (n < 10) {
            return getUnidades(numero);
        } else if (n > 19) {
            String u = getUnidades(numero);
            if (u.equals("")) {
                return DECENAS[Integer.parseInt(numero.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(numero.substring(0, 1)) + 8] + "y " + u;
            }
        } else {
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String numero) {
        if (Integer.parseInt(numero) > 99) {
            if (Integer.parseInt(numero) == 100) {
                return "cien";
            } else {
                return CENTENAS[Integer.parseInt(numero.substring(0, 1))] + getDecenas(numero.substring(1));
            }
        } else {
            return getDecenas(Integer.parseInt(numero) + "");
        }
    }

    private String getMiles(String numero) {
        String c = numero.substring(numero.length() - 3);
        String m = numero.substring(0, numero.length() - 3);
        String n = "";

        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }
    }

    private String getMillones(String numero) {
        String miles = numero.substring(numero.length() - 6);
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
//        System.out.println(millon);
        if (Integer.parseInt(millon) > 1) {
            n = getCentenas(millon) + "millones ";
        } else {
            n = getUnidades(millon) + "millon ";
        }

        return n + getMiles(miles);
    }

}
