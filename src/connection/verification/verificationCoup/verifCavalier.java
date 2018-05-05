package connection.verification.verificationCoup;
import java.sql.*;

public class VerifCavalier(){
  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select idPiece,posX,posY,couleur,typePiece from piece where couleur<>?, numRenconre=?,nomTour=?";
  public VerifCavalier(int posY, int oldY, Character posX, Character oldX){
    if((Math.abs(oldX-posX)==2 && Math.abs(oldY-posY)==1)||(Math.abs(oldX-posX)==1 && Math.abs(oldY-posY)==2)){
      isValid = true;
      if(Math.abs(oldY-posY)==1)
        static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and posX between {$oldX} and {$posX} and posY={$oldY}";
        //si c'est pas nul c'est invalid
      else
        static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and posY between {$oldY} and {$posY} and posX={$oldX} ";
    }
  }
}
