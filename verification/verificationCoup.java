import java.sql.*;
boolean blanc = true ;

public class VerificationCoup {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  public VerificationCoup(int posY, int oldY, Character posX, Character oldX){

  }

//verification Joueur, cad que le joueur bouge bien la bonne couleur
if((blanc && couleur=="blanc") || (!blanc && couleur=="noir"){
  isValid=true;
}


//l'état echec à définir
//select les pièces de l'autre couleur

//verification Coup : Selon TypePiece et Etat dynamique



boolean isValid = false ;

boolean enEchec = false ;

if((Math.abs(oldX-posX)+Math.abs(oldY-posY))>0){

 switch(typePiece){

    case "tour" : VerifTour(posY,oldY,posX,oldX);
                  static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
                  where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py between {$oldY} and {$posY} and px between {$oldX} and {$posX}";
                  VerifTour();

    case "fou" : VerifFou(posY,oldY,posX,oldX);
                 static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
                 where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py between {$oldY} and {$posY} and px between {$oldX} and {$posX}";
                 VerifFou();

    case "roi" : VerifRoi(posY,oldY,posX,oldX);

    case "cavalier" : VerifCavalier(posY,oldY,posX,oldX);

    case "reine" : VerifReine(posY,oldY,posX,oldX);

    case "pion" : VerifPion(posY,oldY,posX,oldX);
}


//Savoir si le roi est en échec ou pas
static final String STMT= "select posX,posY from piece where numRencontre={$numRencontre} and nomTour={$nomTour} and typePiece='roi'";
//appliquer les verifs sur toutes les pièces noires en prenant posX celle du roi blanc

if(isValid){
  //Si le coup est vérifié, insertion dans l'historique + mise à jour de la position de la pièce
  static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece
  where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py ={$posY} and px={$posX}";
  //si il y a des pièces qui vont être mangées
  static final String STMT = "Delete from piece where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py ={$posY} and px={$posX};";

  static final String STMT = "Insert into historique(nomTour,numRencontre,posY,posX,oldY,oldX) VALUES();";

  static final String STMT = "update Piece SET oldX=posX, oldY=posY ;";

  blanc = !blanc;
}
