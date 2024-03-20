/*08/12/2021
 */
package athprod;

import Server.Serverprod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class Athprods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection c;
            Serverprod sp= new Serverprod();
            c=sp.getconexionS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Athprods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Athprods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Athprods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
