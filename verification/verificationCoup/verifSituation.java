import java.sql.*;
public class VerifSituation(){

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMTRoi = "select idPiecePion,posX,posY,couleur from roi where couleur=?, numRenconre=?,nomTour=?";

  public VerifSituation(int numRenconre, String nomTour, int idJoueur, String couleur){
    try {
    // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");

      PreparedStatement selRoi = conn.prepareStatement(STMTRoi);
      selRoi.setString(1,couleur);
      selRoi.setInt(2,numRenconre);
      selRoi.setString(3,nomTour);
      selRoi.executeUpdate();

      ResultSet rsetRoi = stmt.executeQuery(STMTRoi);

      //verification etat echec
      VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur);

      //verification etat mat : verification des déplacements possibles du roi
      //verification etat mat : verification de prise de la piece qui nous met en échec
      //verification etat mat : verification de déplacement de piece pour ne plus être en échec

      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }
}
