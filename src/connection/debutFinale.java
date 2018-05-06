package connection;
import java.sql.*;
import connection.MultipleQueries;

public class DebutQuart {
  static final String STMT ="Select idJoueur from Rencontre where nomTour='demFinale'";
  public DebutQuart(Connection conn) {
    Queries.queries.getResult("Select idJoueur from Rencontre where nomTour='demFinale'");
  }
}
