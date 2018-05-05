package connection.verification.verificationTable;
import java.sql.*;
public class SelectionPiece {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "select idPiece, Piece.couleur from Piece where Piece.nomTour=?, Piece.numRencontre=?";
public SelectionPiece(int numRencontre, String nomTour) {
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
  PreparedStatement stmt = conn.createStatement(STMT);

  stmt.setObject(1,nomTour,Types.VARCHAR);
  stmt.setObject(2,numRencontre,Types.INTEGER);
  stmt.executeUpdate();
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
