/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import Modelo.Formateodedatos;
import Modelo.cargo;
import Modelo.convertirNumeros;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class Testformatos {

    public static void main(String[] args) {
        Testformatos t = new Testformatos();
        //t.formatfecha("2018-10-06 17:44:24.000");
        //t.formatnombre("COMERCIAL D'PORTENIS");
        //Formateodedatos fort= new Formateodedatos();
//        t.folios();
//        t.fechasinT("2024-01-15T13:12:05");
//        convertirNumeros n = new convertirNumeros();
//        System.out.println(n.Convertir("8800000", true, "MXN"));
        

    }

    private String formatfecha(String fe) {
        String nfecha = "";
        for (int i = 0; i < fe.length() - 4; i++) {

            nfecha += (fe.charAt(i) == ' ') ? "T" : fe.charAt(i) + "";
        }
        System.out.println(nfecha);
        return nfecha;
    }

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

    private void folios() {
        ArrayList<cargo> arr = new ArrayList<>();
        cargo c = new cargo();
        c.setReferencia("45665");
        cargo c1 = new cargo();
        c1.setReferencia("45");
        arr.add(c);
        arr.add(c1);
        String ref = "";
        for (int i = 0; i < arr.size(); i++) {
            String arrref = arr.get(i).getReferencia();
            if (arr.size() == 1) {
                ref = "referencia='" + arrref + "'";
            } else {
                if (i == 0) {
                    ref = "referencia='" + arrref + "' or ";
                } else {
                    ref += "referencia='" + arrref + "'";
                }
            }
        }
        System.out.println(ref);
    }

    private String fechasinT(String fecha) {
        String resp = "";
        for (int i = 0; i < fecha.length(); i++) {
            if (fecha.charAt(i) == 'T') {
                resp += ' ';
            } else {
                resp += fecha.charAt(i) + "";
            }
        }
        System.out.println(resp);
        return resp;
    }

}
