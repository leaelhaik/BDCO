import java.sql.*;

public class VerifFou(){
  public VerifFou(int posY, int oldY, Character posX, Character oldX){
    if(Math.abs(oldX-posX)==Math.abs(oldY-posY)){
      isValid = true;
      static final String STMT = "select idPiece from piece where numRenconre={$numRencontre} and nomTour={$nomTour} and abs(oldX-{$oldX})=abs(oldY-{$oldY}) and oldX between {$oldX} and {$posX} and oldY between {$oldY} and {$posY}";
      }
    }
  }
}
