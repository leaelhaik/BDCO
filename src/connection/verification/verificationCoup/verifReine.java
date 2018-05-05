package connection.verification.verificationCoup;
import java.sql.*;

public class VerifReine(){
  public VerifReine(int posY, int oldY, Character posX, Character oldX){
    if((Math.abs(oldX-posX)==Math.abs(oldY-posY))!=((posX==oldX)||(posY==oldY))){
      isValid = true;
      if((posX==oldX)||(posY==oldY))
        static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and abs(oldX-{$oldX})=abs(oldY-{$oldY}) and oldX between {$oldX} and {$posX} and oldY between {$oldY} and {$posY}";
      else
        static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and (oldX-{$oldX})<>(oldY-{$oldY}) and oldX between {$oldX} and {$posX} and oldY between {$oldY} and {$posY}";
    }
  }
}
