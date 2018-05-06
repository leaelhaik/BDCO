package connection;
import java.sql.*;

public class FinRencontre {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";

static final String STMT0 = "select posX,posY from Historique where idCoup=max(idCoup),nomTour=?,numRencontre=?";
static final String STMT3 = "select couleur from piece where numRencontre=?,nomTour=?,posX=?,posY=?";
static final String STMT = "select idJoueur from AffectationCouleur where numRencontre=?,nomTour=?,couleur=?";
static final String STMT2 = "update Rencontre set idJoueur=? where numRencontre=?,nomTour=?";

public FinRencontre(int numRencontre, String nomTour) {
try {
// Enregistrement du driver Oracle
  System.out.print("Loading Oracle driver... ");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  System.out.println("loaded");
  // Etablissement de la connection
  System.out.print("Connecting to the database... ");
  Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  System.out.println("connected");

  PreparedStatement selPos = conn.prepareStatement(STMT0);
  selPos.setString(1,nomTour);
  selPos.setInt(2,numRencontre);
  selPos.executeUpdate();

  ResultSet rsetPos = stmt.executeQuery(STMT0);

  PreparedStatement selCol = conn.prepareStatement(STMT3);
  selCol.setString(1,nomTour);
  selCol.setInt(2,numRencontre);
  selCol.setInt(4,rsetPos.getInt(2));
  selCol.setString(3,rsetPos.getString(3));
  selCol.executeUpdate();

  ResultSet rsetCol = stmt.executeQuery(STMT3);

  PreparedStatement selJou = conn.prepareStatement(STMT);
  selJou.setString(2,nomTour);
  selJou.setInt(1,numRencontre);
  selJou.setString(3,rsetCol.getString(1));
  selJou.executeUpdate();

  ResultSet rsetJou = stmt.executeQuery(STMT);

  PreparedStatement selUp = conn.prepareStatement(STMT2);
  selUp.setString(3,nomTour);
  selUp.setInt(2,numRencontre);
  selUp.setString(1,rsetJou.getInt(1));
  selUp.executeUpdate();

  ResultSet rsetUp = stmt.executeQuery(STMT2);

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
