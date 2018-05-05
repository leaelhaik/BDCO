package connection.verification.verificationCoup;
import java.sql.*;
public class VerifSituation(){

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMTRoi = "select idPiece,posX,posY,couleur from piece where typePiece='roi', couleur=?, numRenconre=?,nomTour=?";
  static final String STMT= "update piece set posX=posX+1 where idPiece=?";

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
      for(int i=-1;i<2;i++){
        for(int j=-1;j<2;j++){
          if(!(i==0 && j==0)){
              if(VerifEchec(rsetRoi.getInt(3)+i,rsetRoi.getInt(2)+j,numRenconre,nomTour,couleur))
                break;
          }

        }
      }

      //verification etat mat : verification de prise de la piece qui nous met en échec

      // on selectionne la piece qui nous met en échec(son id et sa position)
      String STMTPic = "select idPiece,posX,posY from historique where idCoup=max(idCoup), numRenconre=?,nomTour=?";
      PreparedStatement selPic = conn.prepareStatement(STMTPic);
      selPic.setInt(1,numRenconre);
      selPic.setString(2,nomTour);
      selPic.executeUpdate();

      ResultSet rsetPic = stmt.executeQuery(STMTPic);

      //on selectionne toutes les pièces de la couleur qu'on veut qui puissent prendre la piece
      String STMTP = "select idPiece,posX,posY,typePiece from piece where couleur=?, numRenconre=?,nomTour=?";
      PreparedStatement sele = conn.prepareStatement(STMTP);
      sele.setString(1,couleur);
      sele.setInt(2,numRenconre);
      sele.setString(3,nomTour);
      sele.executeUpdate();

      ResultSet rset2 = stmt.executeQuery(STMTP);

      boolean isVerified = false;

      while(rset.next()){
        switch(rset2.getString(4)){

           //verification Tour :
           case "tour" : if(VerifTour(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                            isVerified=true;
                         }
                         break;
           //verification Fou:
           case "fou" : if(VerifFou(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                           isVerified=true;
                        }
                        break;
           //verification Roi:
           case "roi" : if(VerifRoi(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                           isVerified=true;
                        }
                        break;
           //verification cavalier:
           case "cavalier" :  if(VerifCavalier(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                                isVerified=true;
                              }
                        break;
           //verification reine:
           case "reine" : if(VerifReine(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                            isVerified=true;
                          }
                        break;
           //verification pion
           case "pion" :  if(VerifPion(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2))){
                            isVerified=true;
                          }
                        break;
         }
         if(isVerified){
           startTransact();
           setFunction(rset2.getInt(1),rsetPic.getInt(2),rsetPic.getInt(3));
           if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
             rollFunction();
             rset.next();
           }
           else{
             break;
           }
         }
         else{
           rset.next(); // essayer toutes les positions possibles
         }

      }

      // Faire un rollFunction()

      //verification etat mat : verification de déplacement de piece pour ne plus être en échec
      Boolean isEchec = true;
      // for(rset.)
      rset = stmt.executeQuery(STMTP);

      while(rset.next()){

        switch(rset.getString(4)){
           //verification Tour :
           case "tour" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifTour(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;

           //verification Fou:
           case "fou" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifFou(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;
           //verification Roi:
           case "roi" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifRoi(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;
           //verification cavalier:
           case "cavalier" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifCavalier(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;
           //verification reine:
           case "reine" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifReine(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;
           //verification pion
           case "pion" : for(int i=1;i<9;i++){
                            for(char j='A';j<'I';j++){
                              if(VerifPion(i,rset.getInt(3),j,rset.getString(2))){
                                startTransact(conn);
                                setFunction(rset.getInt(1),j,i,conn);
                                if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRenconre,nomTour,couleur)){
                                  rollFunction(conn);
                                }
                                else{
                                  break;
                                }
                              }
                            }
                         }
                         break;
         }
         rset.next(); // essayer toutes les positions possibles
      }

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public void startTransact(Connection conn){
      String Trans = "Start Transaction;" ;
      Statement stmt = conn.createStatement();
      ResultSet rset = stmt.executeQuery(Trans);
  }

  public ResultatSet setFunction(int idPiece,int posX, int posY, Connection conn){
    String setSTMT= "update piece set posX=?,posY=? where idPiece=?";
    PreparedStatement sel = conn.prepareStatement(setSTMT);
    sel.setString(1,posX);
    sel.setInt(2,posY);
    sel.setString(3,idPiece);
    sel.executeUpdate();

    ResultSet rsetRoi = stmt.executeQuery(setSTMT);
  }

  public void rollFunction(Connection conn){
    String Roll = "Rollback;" ;
    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery(Roll);
  }
}
