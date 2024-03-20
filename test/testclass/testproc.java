/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import DAO.daocfdi;
import Modelo.Poliza;
import Modelo.Procserie;
import Persistencia.sqlkardex;
import Server.Serverprod;
import Server.Serverylite;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author GATEWAY1-
 */
public class testproc {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//            
        Serverprod s = new Serverprod();
        
            Connection concpt = s.getconexionserver8("UptownCPT");
//            Connection concpt = s.getconexionserver8("CPT");
            Connection concob = s.getconexionserver8("ACobranzaUptown");
//            Connection concob = s.getconexionserver8("ACobranza");
//            sqlfactura sql = new sqlfactura();
//            ArrayList<Poliza> arr=sql.getpolizas(concpt, "ACobranzaUptown");
////            ArrayList<Poliza> arr=sql.getpolizas(concpt, "ACobranza");
//            sql.setpoliza(concob, arr);
//            concpt.close();
//            concob.close();
    }

    private static void kardex() {
        try {
            Connection c;
            Serverprod s = new Serverprod();
            c = s.getconexionpruebarcpt();
            sqlkardex k = new sqlkardex();
            k.insertkardex(c);
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean verificafloat(String cad) {
        boolean resp = false;
        String patt = "[0-9]+||[0-9]+.[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    private void analizacontenido() {
        try {
            File file = new File("C:\\af\\claves.xlsx");
            //archivo.setText(file.getAbsolutePath());
            FileReader fr = null;
            BufferedReader br = null;
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            FileInputStream fac = new FileInputStream(new File(file.getAbsolutePath()));
            String var;
            String token = "";
            Workbook workbook = new XSSFWorkbook(fac);
            Sheet hoja = workbook.getSheetAt(0);
            ArrayList<String> data = new ArrayList<>();
//Recorremos las filas del documento
            Iterator rows = hoja.rowIterator();
            DataFormatter formatter = new DataFormatter();
            while (rows.hasNext()) {
                Row row = (Row) rows.next();
                Iterator cells = row.cellIterator();
                System.out.println("");
                int i = 0;
                while (cells.hasNext()) {
                    Cell cell = (Cell) cells.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    data.add(contenidoCelda);
                    // System.out.print(i+"-"+contenidoCelda+" ");
                    i++;
                }
            }
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
            JOptionPane.showMessageDialog(null, "Proceso Finalizado, espere Impresiones");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
