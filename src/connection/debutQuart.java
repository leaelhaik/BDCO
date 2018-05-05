package connection;
import java.sql.*;

public class DebutQuart {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT ="Select idJoueur,nomTour,count(numRencontre) from Rencontre group by(idJoueur) LIMIT 0,8 ORDER by count(numRencontre) ASC";
public DebutQuart() {
try {
// Enregistrement du driver Oracle
  System.out.print("Loading Oracle driver... ");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  System.out.println("loaded");
  // Etablissement de la connection
  System.out.print("Connecting to the database... ");
  Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  System.out.println("connected");
  // Creation de la requete
  Statement stmt = conn.createStatement();
  // Execution de la requete
  ResultSet rset = stmt.executeQuery(STMT);
  // Affichage du resultat
  System.out.println("Results:");
  dumpResultSet(rset);
  System.out.println();
  // Fermeture
  rset.close();
  stmt.close();
  conn.close();
} catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
  }
}
}
