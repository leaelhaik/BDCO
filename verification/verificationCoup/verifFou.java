import java.sql.*;

public class VerifFou(){
  public VerifFou(int posY, int oldY, Character posX, Character oldX){
    if(Math.abs(oldX-posX)==Math.abs(oldY-posY)){
      isValid = true;
    }
  }
}
