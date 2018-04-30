import java.sql.*;

public class VerifRoi(){
  public VerifRoi(int posY, int oldY, Character posX, Character oldX){
    if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2){
      isValid = true;
      static final String STMT = "select idPiece, posX as px,posY as py from piece where numRencontre={$numRencontre} and nomTour={$nomTour} and couleur<>{$couleur} and px between {$oldX} and {$posX} and py between {$oldY} and {$posY} ";
    }
  }
}
