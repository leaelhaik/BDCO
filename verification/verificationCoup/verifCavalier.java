import java.sql.*;

public class VerifCavalier(){
  public VerifCavalier(int posY, int oldY, Character posX, Character oldX){
    if((Math.abs(oldX-posX)==2 && Math.abs(oldY-posY)==1)||(Math.abs(oldX-posX)==1 && Math.abs(oldY-posY)==2)){
      isValid = true;
      if(Math.abs(oldY-posY)==1)
        static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and px between {$oldX} and {$posX} and py={$oldY}";
      else
        static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where nr={$numRencontre} and nt={$nomTour} and coul<>{$couleur} and py between {$oldY} and {$posY} and px={$oldX} ";
    }
  }
}
