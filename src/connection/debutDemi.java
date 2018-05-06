package connection;
import java.sql.*;
import connection.MultipleQueries;

public class DebutDemi {
  public DebutDemi() {
    ResultSet rsetDemi = Queries.queries.getResult("select idJoueur from Rencontre where nomTour='quartFinale'");
  }
}
