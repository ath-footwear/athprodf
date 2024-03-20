/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Persistencia.Procesoserie;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GATEWAY1-
 */
public class Procserie extends Thread {

    private Connection cpt, rcpt, cptup, rcptup;

    public void setConnecxiones(ArrayList<Connection> arrc) {
        cpt = arrc.get(0);
        rcpt = arrc.get(1);
        cptup = arrc.get(2);
        rcptup = arrc.get(3);
    }

    @Override
    public void run() {
        while (true) {
            Date hoy = new Date();
            DateFormat dm = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sm = new SimpleDateFormat("HH:mm:ss");
            try {

                Procesoserie p = new Procesoserie();
                //kardex y pedidos
                ArrayList<Seriecpt> arr = p.getfolioped(cpt);//lista de folios y pedidos CPT
                p.updatepedidos(rcpt, arr);// actualizar serie de rcpt con los folios de cpt
                ArrayList<Seriecpt> arrup = p.getfolioped(cptup);//lista de folios y pedidos CPTup
                p.updatepedidos(rcptup, arrup);// actualizar serie de rcpt con los folios de cptup
                //facturas
                arr = p.getfacs(cpt);//facturas de cpt
                p.updatefacs(rcpt, arr);// facs de rcpt
                arrup = p.getfacs(cptup);//facs dee rcptup
                p.updatefacs(rcptup, arrup);//facs de rcptup
                //Solo pedidos
                arr=p.getpedidos(cpt);
                p.updatesolopedidos(rcpt, arr);
                arr=p.getpedidos(cptup);
                p.updatesolopedidos(rcptup, arr);
                System.out.println("completo");
                sleep(1000 * 60);//1000 x 1200(segundos)
                System.out.println(hoy + "\n\n");
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }
}
