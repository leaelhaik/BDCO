import java.sql.*;
import connection.MultipleQueries;

public class DeleteTour{
  private MultipleQueries queries;

  public DeleteTour() {
    ResultSet rsetDeleteJoueur = queries.getResult("Delete from Tour");
  }

}
