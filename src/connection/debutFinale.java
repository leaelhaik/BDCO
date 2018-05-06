package connection;
import java.sql.*;

public class DebutQuart {
// static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
// static final String USER = "dhouibd"; // A remplacer pour votre compte
// static final String PASSWD = "dhouibd";
static final String STMT ="Select idJoueur from Rencontre where nomTour='demFinale'";
public DebutQuart(Connection conn) {
try {
  Statement stmt = conn.createStatement();
  // Execution de la requete
  ResultSet rset = stmt.executeQuery(STMT);

  // Fermeture
  rset.close();
  stmt.close();
  //conn.close();
} catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
  }
}
}
