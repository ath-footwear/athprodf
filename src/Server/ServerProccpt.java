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
public class ServerProccpt {

    private Connection connect, connectrcpt, connectcptup, connectrcptup;
    private final String URL = "jdbc:sqlserver://192.168.6.8\\datos65:9205;databaseName=CPT";
    private final String URLRcpt = "jdbc:sqlserver://192.168.6.8\\datos65:9205;databaseName=RCPT";
    private final String URLCptup = "jdbc:sqlserver://192.168.6.8\\datos65:9205;databaseName=UptownCPT";
    private final String URLRcptup = "jdbc:sqlserver://192.168.6.8\\datos65:9205;databaseName=UptownRCPT";
    private final String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection getconexioncpt() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connect = DriverManager.getConnection(URL, "sa", "Prok2001");
        return connect;
    }
    public void cerrarcpt() throws SQLException {
        connect.close();
    }
    
    public Connection getconexionrcpt() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connectrcpt = DriverManager.getConnection(URLRcpt, "sa", "Prok2001");
        return connectrcpt;
    }
    public void cerrarrcpt() throws SQLException {
        connectrcpt.close();
    }
    
    public Connection getconexionCptup() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connectcptup = DriverManager.getConnection(URLCptup, "sa", "Prok2001");
        return connectcptup;
    }
    public void cerrarCptup() throws SQLException {
        connectcptup.close();
    }
    
    public Connection getconexionRcptup() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connectrcptup = DriverManager.getConnection(URLRcptup, "sa", "Prok2001");
        return connectrcptup;
    }
    public void cerrarRcptup() throws SQLException {
        connectrcptup.close();
    }
}
