import java.sql.*;

public class VerifPion(){

  public VerifPion(int posY, int oldY, Character posX, Character oldX){

    // Sélectionne la case en diagonale du pion pour savoir s'il peut la manger ou non
    static final String STMT = "select idPiece,couleur as couleur1,posX as posX1,posY as posY1,
    nomTour as nT1, numRencontre as nR1 from Piece where couleur1<>couleur ,(posY1=oldY + 1)
    ,((posX1=oldX+1)or(posX1=oldX-1)),numRencontre=nR1,nomTour=nT1;";

    Statement stmt = conn.createStatement();
    // Execution de la requete
    ResultSet rset = stmt.executeQuery(STMT);

    if(rset.getInt(1)<>null &&(posY1=rset.getInt(4))&&(posX==rset.getInt(3))){
      isValid = true;
    }
    else if(rset.wasNull()&&(posY-oldY==1)&&(posX==oldX)){
      isValid = true;
    }

  }
}
