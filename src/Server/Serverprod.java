/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GATEWAY1-
 */
public class Serverprod {

    private Connection connect, pruebacpt, pruebarcpt, pruebacob;

    private final String URL = "jdbc:sqlserver://192.168.6.75\\SQLEXPRESS:9205;databaseName=Produccionath";
    private final String URL8 = "jdbc:sqlserver://192.168.6.8\\SQLEXPRESS:9205;databaseName=";
    private final String URLpruebacpt = "jdbc:sqlserver://192.168.6.8\\SQLEXPRESS:9205;databaseName=FATIMACPT";
    private final String URLpruebarcpt = "jdbc:sqlserver://192.168.6.8\\SQLEXPRESS:9205;databaseName=FATIMARCPT";
    private final String URLpruebacob = "jdbc:sqlserver://192.168.6.8\\SQLEXPRESS:9205;databaseName=ACobranzafh";
    private final String URLP = "jdbc:sqlserver://192.168.6.75\\SQLEXPRESS:9205;databaseName=";
    private final String urlB = "jdbc:sqlserver://192.168.90.1\\datos620:1433;database=";

    private final String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection getconexionB(String bd) throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        Connection conB;
        conB = DriverManager.getConnection(urlB+bd, "sa", "Admin1305");
        System.out.println("Conectado a server B");
        return conB;
    }

    public Connection getconexionS() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connect = DriverManager.getConnection(URL, "mich", "mich");
        System.out.println("Conectado a server");
        return connect;
    }

    public void cerrar() throws SQLException {
        connect.close();
        System.out.println("Cerrar server");
    }

    public Connection getconexionserver8(String bd) throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        Connection connect8=null;
        connect8 = DriverManager.getConnection(URL8 + bd, "sa", "Prok2001");
        System.out.println("Conectado a server 8" + bd);
        return connect8;
    }

    public Connection getconexionTPU(String bd) throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        Connection connectm;
        connectm = DriverManager.getConnection(URLP + bd, "mich", "mich");
        System.out.println("Conectado a server mio prueba" + bd);
        return connectm;
    }

    public void cerrarserver8() throws SQLException {
        connect.close();
        System.out.println("Cerrar server");
    }

    //bd de prueba
    public Connection getconexionpruebacpt() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        pruebacpt = DriverManager.getConnection(URLpruebacpt, "sa", "Prok2001");
        System.out.println("Conectado a Prueba cpt fh");
        return pruebacpt;
    }

    public void cerraprueba() throws SQLException {
        pruebacpt.close();
        System.out.println("cerrar prueba");
    }

    public Connection getconexionpruebarcpt() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        pruebarcpt = DriverManager.getConnection(URLpruebarcpt, "sa", "Prok2001");
        System.out.println("Conectado a Prueba rcpt fh");
        return pruebarcpt;
    }

    public void cerrapruebarcpt() throws SQLException {
        pruebarcpt.close();
        System.out.println("cerrar prueba");
    }

    public Connection getconexionpruebacob() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        pruebacob = DriverManager.getConnection(URLpruebacob, "sa", "Prok2001");
        System.out.println("Conectado a Prueba cob fh");
        return pruebacob;
    }

    public void cerrapruebacob() throws SQLException {
        pruebacob.close();
        System.out.println("cerrar prueba");
    }
}
