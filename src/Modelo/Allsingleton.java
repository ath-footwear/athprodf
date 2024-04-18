/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GATEWAY1-
 */
public class Allsingleton implements java.io.Serializable {

    private static Connection c;
    private static Usuarios usuario;
    private static Fichas f;
    private static ArrayList<DetFichas> df;
    private static String serie;
    private static DetFichas dff;
    private static Allsingleton instance;

    private Allsingleton() {
    }

    /**
     * Instancia para el singleton y no crear mas de una ves
     *
     * @return
     */
    public static Allsingleton getAllsingleton() {
        if (instance == null) {
            Allsingleton.instance = new Allsingleton();
        }
        return instance;
    }

    public static DetFichas getDff() {
        return dff;
    }

    public static void setDff(DetFichas dff) {
        Allsingleton.dff = dff;
    }

    public static Usuarios getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuarios usuario) {
        Allsingleton.usuario = usuario;
    }

    public static Fichas getF() {
        return f;
    }

    public static void setF(Fichas f) {
        Allsingleton.f = f;
    }

    public static ArrayList<DetFichas> getDf() {
        return df;
    }

    public static void setDf(ArrayList<DetFichas> df) {
        Allsingleton.df = df;
    }

    public static String getSerie() {
        return serie;
    }

    public static void setSerie(String serie) {
        Allsingleton.serie = serie;
    }

    public static Connection getC() {
        return c;
    }

    public static void setC(Connection c) {
        Allsingleton.c = c;
    }

    public boolean vericacaracter(String cad) {
        boolean resp = false;
        String patt = "[a-zA-Z0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    public static boolean vericanumero(String cad) {
        boolean resp = false;
        String patt = "[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    public static boolean vericaflotante(String cad) {
        boolean resp = false;
        String patt = "[0-9]+.[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }
}
