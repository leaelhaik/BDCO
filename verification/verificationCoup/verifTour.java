import java.sql.*;

public class VerifTour(){
  public VerifTour(int posY, int oldY, Character posX, Character oldX){
    if((posX==oldX)!=(posY==oldY)){
      isValid = true;
      static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and (oldX-{$oldX})<>(oldY-{$oldY}) and oldX between {$oldX} and {$posX} and oldY between {$oldY} and {$posY}";
    }
  }
}
