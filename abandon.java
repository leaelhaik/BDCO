import java.sql.*;
public class Abandon {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "select idJoueur from affectationCouleur where numRencontre=?,nomTour=?,idJoueur<>?";
static final String STMT2 = "update Rencontre set idJoueur=?";
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
  ResultSet rset = stmt.executeQuery(STMT);
  int n = rset.getInt(1);

  PreparedStatement inser = conn.prepareStatement(STMT2);
  inser.setInt(1,n);
  inser.executeUpdate();

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
private void dumpResultSet(ResultSet rset) throws SQLException {
  ResultSetMetaData rsetmd = rset.getMetaData();
  int i = rsetmd.getColumnCount();
  for (int k=1;k<=i;k++)
    System.out.print(rsetmd.getColumnName(k) + "\t");
  System.out.println();
  while (rset.next()) {
    for (int j = 1; j <= i; j++) {
      System.out.print(rset.getString(j) + "\t");
    }
    System.out.println();
  }
}
  public static void main(String args[]) {
    new SimpleQuery();
  }
}
