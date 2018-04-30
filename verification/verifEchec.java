import java.sql.*;
public class VerifEchec {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMTPion = "select idPiecePion,posX,posY,couleur from pion where couleur<>?, numRenconre=?,nomTour=?";
static final String STMTFou = "select idPiecePion,posX,posY,couleur from fou where couleur<>?, numRenconre=?,nomTour=?";
static final String STMTCavalier = "select idPiecePion,posX,posY,couleur from cavalier where couleur<>?, numRenconre=?,nomTour=?";
static final String STMTReine = "select idPiecePion,posX,posY,couleur from reine where couleur<>?, numRenconre=?,nomTour=?";
static final String STMTRoi = "select idPiecePion,posX,posY,couleur from roi where couleur<>?, numRenconre=?,nomTour=?";
static final String STMTTour = "select idPiecePion,posX,posY,couleur from tour where couleur<>?, numRenconre=?,nomTour=?";

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
  PreparedStatement selPion = conn.prepareStatement(STMTPion);
  selPion.setString(1,couleur);
  selPion.setInt(2,numRenconre);
  selPion.setString(3,nomTour);
  selPion.executeUpdate();

  ResultSet rsetPion = stmt.executeQuery(STMTPion);

  VerifPion(posY,rsetPion.getInt(3),posX,rsetPion.getInt(2));

  PreparedStatement selCavalier = conn.prepareStatement(STMTCavalier);
  selCavalier.setString(1,couleur);
  selCavalier.setInt(2,numRenconre);
  selCavalier.setString(3,nomTour);
  selCavalier.executeUpdate();

  ResultSet rsetCavalier = stmt.executeQuery(STMTCavalier);
  VerifCavalier(posY,rsetCavalier.getInt(3),posX,rsetCavalier.getInt(2));

  PreparedStatement selTour = conn.prepareStatement(STMTTour);
  selTour.setString(1,couleur);
  selTour.setInt(2,numRenconre);
  selTour.setString(3,nomTour);
  selTour.executeUpdate();

  ResultSet rsetTour = stmt.executeQuery(STMTTour);
  VerifTour(posY,rsetTour.getInt(3),posX,rsetTour.getInt(2));

  PreparedStatement selFou = conn.prepareStatement(STMTFou);
  selFou.setString(1,couleur);
  selFou.setInt(2,numRenconre);
  selFou.setString(3,nomTour);
  selFou.executeUpdate();

  ResultSet rsetFou = stmt.executeQuery(STMTFou);
  VerifFou(posY,rsetFou.getInt(3),posX,rsetFou.getInt(2));

  PreparedStatement selRoi = conn.prepareStatement(STMTRoi);
  selRoi.setString(1,couleur);
  selRoi.setInt(2,numRenconre);
  selRoi.setString(3,nomTour);
  selRoi.executeUpdate();

  ResultSet rsetRoi = stmt.executeQuery(STMTRoi);
  VerifRoi(posY,rsetRoi.getInt(3),posX,rsetRoi.getInt(2));

  PreparedStatement selReine = conn.prepareStatement(STMTReine);
  selReine.setString(1,couleur);
  selReine.setInt(2,numRenconre);
  selReine.setString(3,nomTour);
  selReine.executeUpdate();

  ResultSet rsetReine = stmt.executeQuery(STMTReine);
  VerifReine(posY,rsetReine.getInt(3),posX,rsetReine.getInt(2));
  // Fermeture
  rsetPion.close();
  rsetFou.close();
  rsetTour.close();
  rsetRoi.close();
  rsetReine.close();
  rsetCavalier.close();
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
