/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.daofactura;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class Nocolision extends Thread {

    private Connection rcpt;
    private int folio;
    private boolean resp = true;
    private int foliofinal;

    /**
     *
     * @param c conexion rcpt
     * @param f folio
     */
    public void setConnecxiones(Connection c, int f) {
        rcpt = c;
        folio = f;
    }

    public int getfolio() {
        return foliofinal;
    }

    @Override
    public void run() {
        Random r = new Random();
        Random r1 = new Random();
        try {
            while (resp) {
                int n = r.nextInt(8);
                int na = r1.nextInt(200);
                System.out.println(na+" --- "+n);
                sleep((1000+na) * n);//1000 x 1200(segundos)
                daofactura d = new daofactura();
                if (d.getbuscafolio(rcpt, folio + "") == 0) {
                    foliofinal = folio;
//                    JOptionPane.showMessageDialog(null, "Folio asignado!");
                    resp = false;
                } else {
                    folio++;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"colision -"+ ex);
            ex.getMessage();
        }

    }
}
