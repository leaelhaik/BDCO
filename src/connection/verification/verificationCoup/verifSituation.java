package connection.verification.verificationCoup;
import java.sql.*;
public class VerifSituation(){

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMTRoi = "select idPiece,posX,posY,couleur from piece where typePiece='roi', couleur=?, numRenconre=?,nomTour=?";
  static final String STMTRoi = "update piece set posX=posX+1 where idPiece=?";

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
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
          if(VerifEchec()){

          }
        }
      }

      //verification etat mat : verification de prise de la piece qui nous met en échec
      //la piece qui nous met en échec
      static final String STMTPic = "select idPiece,posX,posY from historique where idCoup=max(idCoup), numRenconre=?,nomTour=?";
      PreparedStatement selPic = conn.prepareStatement(STMTPic);
      selPic.setInt(1,numRenconre);
      selPic.setString(2,nomTour);
      selPic.executeUpdate();

      ResultSet rsetPic = stmt.executeQuery(STMTPic);

      VerifRoi(rsetPic.getInt(3),rsetRoi.getInt(3),rsetPic.getInt(2),rsetRoi.getInt(2));
      VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur);


      //verification etat mat : verification de déplacement de piece pour ne plus être en échec
      static final String STMTPic = "select idPiece,posX,posY,typePiece from piece where couleur=?, numRenconre=?,nomTour=?";
      PreparedStatement selPic = conn.prepareStatement(STMTPic);
      selPic.setString(1,couleur);
      selPic.setInt(2,numRenconre);
      selPic.setString(3,nomTour);
      selPic.executeUpdate();

      ResultSet rsetPic = stmt.executeQuery(STMTPic);
      // for(rset.)
      while(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
        switch(typePiece){
           //verification Tour :
           case "tour" : VerifTour();
           //verification Fou:
           case "fou" : VerifFou();
           //verification Roi:
           case "roi" : VerifRoi();
           //verification cavalier:
           case "cavalier" : VerifCavalier();
           //verification reine:
           case "reine" : VerifReine();
           //verification pion
           case "pion" : VerifPion();
         }
         rset.next(); // essayer toutes les positions possibles
      }



      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }
}
