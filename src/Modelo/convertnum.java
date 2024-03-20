/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DecimalFormat;

/**
 *
 * @author GATEWAY1-
 */
public class convertnum {

    //static int num = 1523;
    private static final String uni[] = {"", "Un ", "Dos ", "Tres ", "Cuatro ", "Cinco ", "Seis ", "Siete ", "Ocho ", "Nueve "};
    private static final String dec[] = {"", "Dieci", "Veinti", "Treinta ", "Cuarenta ", "Cincuenta ", "Sesenta ", "Setenta ", "Ochenta ", "Noventa "};
    private static final String cen[] = {"", "Ciento ", "Doscientos ", "Trescientos ", "Cuatrocientos ", "Quinientos ", "Seiscientos ", "Setecientos ", "Ochocientos ", "Novecientos "};

    private String centenar(int num) {
        String letra = "";
        int unidad = num % 10;
        int decena = (num % 100) / 10;
        int centena = num / 100;
        if (num == 100) {
            letra = "cien";
        } else if (num > 99) {
            String auxcent = String.valueOf(centena);
            String numero = String.valueOf(auxcent.charAt(0));
            letra = cen[Integer.parseInt(numero)];
        }
        boolean flag = true;
        int numnumero = Integer.parseInt("" + decena + unidad);
        if (decena > 9 && decena < 16 || (numnumero > 9 && numnumero < 16) || numnumero == 20) {
            switch (decena) {
                case 10:
                    letra += "Diez ";
                    break;
                case 11:
                    letra += "Once ";
                    break;
                case 12:
                    letra += "Doce";
                    break;
                case 13:
                    letra += "Trece ";
                    break;
                case 14:
                    letra += "Catorce ";
                    break;
                case 15:
                    letra += "Quince ";
                    break;
                case 20:
                    letra += "Veinte ";
                    break;
            }
            switch (numnumero) {
                case 10:
                    letra += "Diez ";
                    break;
                case 11:
                    letra += "Once ";
                    break;
                case 12:
                    letra += "Doce";
                    break;
                case 13:
                    letra += "Trece ";
                    break;
                case 14:
                    letra += "Catorce ";
                    break;
                case 15:
                    letra += "Quince ";
                    break;
                case 20:
                    letra += "Veinte ";
                    break;
            }

            flag = false;
        } else if (num > 9) {
            String auxdec = String.valueOf(decena);
            String numero = String.valueOf(auxdec.charAt(0));
            letra += (Integer.parseInt(numero) > 2) ? dec[Integer.parseInt(numero)] + "Y " : dec[Integer.parseInt(numero)];
        }
        if (num == 0) {
            letra += "";
        } else {
            if (flag) {
                letra += uni[unidad];
            }

        }
        return letra;
    }

    public String controlconversion(double num) {
        int numint = (int) num;//numero sin decimal
        String letra = "";
        boolean flag = false;
        String letraaux = "";
        if (num >= 1000 && num < 1000000) {
            int mnum = (int) (num / 1000);//solo millares
            int unidad = mnum % 10;
            int decena = (mnum % 100) / 10;
            int centena = mnum / 100;
            letra += centenar(mnum) + "Mil ";
//            System.out.println(letra + " "+mnum);
            flag = true;
            String conversion = String.valueOf(num);
            int celda = (mnum < 10) ? 0 : (mnum > 9 && mnum < 100) ? 1 : 2;
            for (int i = celda + 1; i < conversion.length(); i++) {
                letraaux += conversion.charAt(i);
            }
        }

        letra += (flag) ? centenar((int) Double.parseDouble(letraaux)) : centenar(numint);
        if (num < 1000) {
            letra += centenar(numint);
        }
        boolean flagaux = false;
        DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
        String numcadena = String.valueOf(formateador.format(num));
        String decimal = "";
        for (int i = 0; i < numcadena.length(); i++) {
            String stringdato = String.valueOf(numcadena.charAt(i));
            if (flagaux) {
                decimal += stringdato;
            }
            if (stringdato.equals(".") || flagaux) {
                flagaux = true;
            }

        }
        return letra + "Pesos " + decimal + "/100.".toUpperCase();
    }

}
