import java.sql.*;
boolean blanc = true ;

public class VerificationCoup {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  public VerificationCoup(int posY, int oldY, Character posX, Character oldX, int numRenconre, String nomTour, String couleur){

  }

//verification Joueur, cad que le joueur bouge bien la bonne couleur
// if((blanc && couleur=="blanc") || (!blanc && couleur=="noir"){
//   isValid=true;
// }
//
//
// //l'état echec à définir
// //select les pièces de l'autre couleur
//
//
//
// boolean isValid = false ;
//
// boolean enEchec = false ;
//
// if((Math.abs(oldX-posX)+Math.abs(oldY-posY))>0){
//
//  switch(typePiece){
//
//     case "tour" : VerifTour(posY,oldY,posX,oldX);
//                   static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
//                   where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py between {$oldY} and {$posY} and px between {$oldX} and {$posX}";
//                   VerifTour();
//
//     case "fou" : VerifFou(posY,oldY,posX,oldX);
//                  static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
//                  where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py between {$oldY} and {$posY} and px between {$oldX} and {$posX}";
//                  VerifFou();
//
//     case "roi" : VerifRoi(posY,oldY,posX,oldX);
//
//     case "cavalier" : VerifCavalier(posY,oldY,posX,oldX);
//
//     case "reine" : VerifReine(posY,oldY,posX,oldX);
//
//     case "pion" : VerifPion(posY,oldY,posX,oldX);
// }
//
//
// //Savoir si le roi est en échec ou pas
// static final String STMT= "select posX,posY from piece where numRencontre={$numRencontre} and nomTour={$nomTour} and typePiece='roi'";
// //appliquer les verifs sur toutes les pièces noires en prenant posX celle du roi blanc
//
// if(isValid){
//   //Si le coup est vérifié, insertion dans l'historique + mise à jour de la position de la pièce
//   static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
//   where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py ={$posY} and px={$posX}";
//   //si il y a des pièces qui vont être mangées
//   static final String STMT = "Delete from piece where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py ={$posY} and px={$posX};";
//
//   static final String STMT = "Insert into historique(nomTour,numRencontre,posY,posX,oldY,oldX) VALUES();";
//
//   static final String STMT = "update Piece SET oldX=posX, oldY=posY ;";
//
//   blanc = !blanc;






//verification si obstacle en vue : invalide
static final String STMT = "select * from piece where numRenconre=? and nomTour=? and posY between ? and ? and posX between ? and ?";

PreparedStatement hav = conn.prepareStatement(STMT);
hav.setInt(1,numRenconre);
hav.setString(2,nomTour);
hav.setInt(3,oldY);
hav.setInt(4,posY);
hav.setInt(5,oldX);
hav.setInt(6,posX);
hav.executeUpdate();
//commit
// Execution de la requete
ResultSet rset = stmt.executeQuery(STMT);  //Piece dans l'entourage puis selon type de la piece on change



//prise d'une autre pièce adverse

//ne pas être en état échec
VerifEchec();


//Si valide
  static final String STMT1 = "Delete from piece where numRenconre=? and nomTour=? and couleur<>? and posY =?and posX=?;";

  static final String STMT2 = "Insert into historique(nomTour,numRencontre,posY,posX,oldY,oldX) VALUES(?,?,?,?,?,?);";

  static final String STMT3 = "update Piece SET posX=?, posY = ?, oldX=?, oldY=? ;";

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
    PreparedStatement del = conn.prepareStatement(STMT1);
    del.setInt(1,numRenconre);
    del.setString(2,nomTour);
    del.setString(3,couleur);
    del.setInt(4,posY);
    del.setInt(5,posX);
    del.executeUpdate();
    //commit
    // Execution de la requete
    ResultSet rset = stmt.executeQuery(STMT1);

    PreparedStatement inse = conn.prepareStatement(STMT2);
    inse.setString(1,nomTour);
    inse.setInt(2,numRenconre);
    inse.setInt(3,posY);
    inse.setInt(4,posX);
    inse.setInt(5,oldY);
    inse.setInt(6,oldX);
    inse.executeUpdate();
    //commit
    // Execution de la requete
    ResultSet rset2 = stmt.executeQuery(STMT2);

    PreparedStatement nouv = conn.prepareStatement(STMT3);
    nouv.setInt(1,null);
    nouv.setInt(2,null);
    nouv.setInt(3,posX);
    nouv.setInt(4,posY);
    inse.executeUpdate();
    //commit
    // Execution de la requete
    ResultSet rset3 = stmt.executeQuery(STMT3);


    // Fermeture
    rset.close();
    stmt.close();
    conn.close();
  } catch (SQLException e) {
      System.err.println("failed");
      e.printStackTrace(System.err);
    }

}
