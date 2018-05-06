package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

	private Connection connection;
    static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
    static final String USER = "dhouibd"; // A remplacer pour votre compte
    static final String PASSWD = "dhouibd";

    
    public Connect() {
    try{
        // Enregistrement du driver Oracle
        System.out.print("Loading Oracle driver... ");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("loaded");

        // Connection a la BD
        System.out.print("Connecting to the database... ");
        connection = DriverManager.getConnection(CONN_URL,USER,PASSWD);
        System.out.println("Connected");
        connection.setAutoCommit(false);

    } catch(SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
    }

  }

  /**
   *  Retourne la connection
   */

   public Connection getConnection() {
      return this.connection;
    }

  /**
   *  Termine la connexion.
   */

    public void closeConnection() {
        try{
            this.connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}