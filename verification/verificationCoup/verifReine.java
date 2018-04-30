import java.sql.*;

public class VerifReine(){
  public VerifReine(int posY, int oldY, Character posX, Character oldX){
    if((Math.abs(oldX-posX)==Math.abs(oldY-posY))!=((posX==oldX)||(posY==oldY))){
      isValid = true;
      //verifFou();
      // if((posX==oldX)||(posY==oldY))
      //   static final String STMT = "select idPiece, posX as px,posY as py from piece where numRencontre={$numRencontre} and nomTour={$nomTour} and couleur<>{$couleur} and px between {$oldX} and {$posX} and py between {$oldY} and {$posY} ";
      // else
      //   static final String STMT = "select idPiece, posX as px,posY as py from piece where numRencontre={$numRencontre} and nomTour={$nomTour} and couleur<>{$couleur} and px between {$oldX} and {$posX} and py between {$oldY} and {$posY}";
      //
    }
  }
}
