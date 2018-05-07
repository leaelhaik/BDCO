package connection;
import java.sql.*;
import connection.MultipleQueries;

public class RejouerPartie {
  public RejouerPartie(String nomTour, int numRencontre) {
    int i=0;
    ResultSet rsetHist = Queries.queries.getResult("Select idCoup,posX,posY,oldX,oldY from Historique where numRencontre="+numRencontre+", nomTour = \'"+nomTour+"\'");
    try {
      while (rsetQuart.next()) {
        tabClassement[i] = rsetQuart.getInt(1);
        i++;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

}
