package connection.verification.verificationCoup;
import java.sql.*;

public class VerifRoi(){
  public VerifRoi(int posY, int oldY, Character posX, Character oldX){
    if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2){
      isValid = true;
      static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and oldX between {$oldX} and {$posX} and oldY between {$oldY} and {$posY}";
    }
  }
}
