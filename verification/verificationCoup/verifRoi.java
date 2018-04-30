import java.sql.*;

public class VerifRoi(){
  public VerifRoi(int posY, int oldY, Character posX, Character oldX){
    if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2){
      isValid = true;
    }
  }
}
