import java.sql.*;

public class VerifReine(){
  public VerifReine(int posY, int oldY, Character posX, Character oldX){
    if((Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2)!=(posX==oldX)||(posY==oldY)){
      isValid = true;
      static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and px between oldX and posX and py between oldY and posY ";
    }
  }
}
