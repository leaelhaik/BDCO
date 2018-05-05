import java.sql.*;
public class Abandon {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT0 = "select posX,posY from Historique where idCoup=max(idCoup),nomTour=?,numRenconre=?";
static final String STMT3 = "select couleur from piece where numRencontre=?,nomTour=?,posX=?,posY=?";
static final String STMT = "select idJoueur from affectationCouleur where numRencontre=?,nomTour=?,idJoueur<>?";
static final String STMT2 = "update Rencontre set idJoueur=? where numRenconre=?,nomTour=?";
public Abandon(String nomTour, int numRencontre, int idJoueur) {
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
  PreparedStatement aban = conn.prepareStatement(STMT);
  aban.setInt(1,numRencontre);
  aban.setString(2,nomTour);
  aban.setInt(3,idJoueur);
  aban.executeUpdate();
  // Execution de la requete
  ResultSet rset = aban.executeQuery(STMT);
  int n = rset.getInt(1);

  PreparedStatement inser = conn.prepareStatement(STMT2);
  inser.setInt(1,n);
  inser.setInt(2,numRenconre);

  inser.executeUpdate();

  // Affichage du resultat

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
