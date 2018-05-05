import java.sql.*;
public class VerifEchec {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "select idPiece,posX,posY,couleur,typePiece from piece where couleur<>?, numRenconre=?,nomTour=?";

//si on a les pos du roi
public VerifEchec(int posY, Character posX, int numRenconre, String nomTour, String couleur) {
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
  // Statement stmt = conn.createStatement();
  // // Execution de la requete
  // ResultSet rset = stmt.executeQuery(STMT);
  PreparedStatement sel = conn.prepareStatement(STMT);
  sel.setString(1,couleur);
  sel.setInt(2,numRenconre);
  sel.setString(3,nomTour);
  sel.executeUpdate();

  ResultSet rset = stmt.executeQuery(STMT);
  switch(rset.getString(5)){
    case 'pion' : VerifPion(posY,rset.getInt(3),posX,rset.getInt(2));
    case 'reine' : VerifReine(posY,rset.getInt(3),posX,rset.getInt(2));
    case 'roi' : VerifRoi(posY,rset.getInt(3),posX,rset.getInt(2));
    case 'cavalier' : VerifCavalier(posY,rset.getInt(3),posX,rset.getInt(2));
    case 'tour' : VerifTour(posY,rset.getInt(3),posX,rset.getInt(2));
    case 'fou' : VerifFou(posY,rset.getInt(3),posX,rset.getInt(2));
  }

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

}
