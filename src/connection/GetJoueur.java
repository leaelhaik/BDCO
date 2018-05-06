package connection;
import java.sql.*;

public class GetJoueur {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "select prenomJoueur,nomJoueur from joueur,affectationCouleur where joueur.idJoueur=affectationCouleur.idJoueur, affectationCouleur.nomCouleur=?,affectationCouleur.numRencontre=?,affectationCouleur.nomTour=?";
public GetJoueur(String nomTour, int numRencontre, String couleur, Connection conn) {
try {
// Enregistrement du driver Oracle
  System.out.print("Loading Oracle driver... ");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  System.out.println("loaded");
  // Etablissement de la connection
  System.out.print("Connecting to the database... ");
  Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  System.out.println("connected");
  Statement stmt = conn.createStatement();

  // Creation de la requete
  PreparedStatement sel = conn.prepareStatement(STMT);
  sel.setString(1,couleur);
  sel.setInt(2,numRencontre);
  sel.setString(3,nomTour);
  sel.executeUpdate();

  ResultSet rset = stmt.executeQuery(STMT);
  // Affichage du resultat
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
private void dumpResultSet(ResultSet rset) throws SQLException {
  ResultSetMetaData rsetmd = rset.getMetaData();
  int i = rsetmd.getColumnCount();
  // for (int k=1;k<=i;k++)
  //   System.out.print(rsetmd.getColumnName(k) + "\t");
  // System.out.println();
  while (rset.next()) {
    for (int j = 1; j <= i; j++) {
      System.out.print(rset.getString(j) + "\t");
    }
    System.out.println();
  }
}
}
