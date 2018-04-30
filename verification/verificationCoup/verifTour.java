import java.sql.*;

public class VerifTour(){
  public VerifTour(int posY, int oldY, Character posX, Character oldX){
    if((posX==oldX)!=(posY==oldY)){
      isValid = true;
      // static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and (px between oldX and posX or py between oldY and posY) ";
    }
  }
}
