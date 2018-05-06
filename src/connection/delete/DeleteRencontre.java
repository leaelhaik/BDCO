import java.sql.*;
import connection.MultipleQueries;

public class DeleteRencontre{
  private MultipleQueries queries;

  public DeleteRencontre() {
    ResultSet rsetDeleteJoueur = queries.getResult("Delete from Rencontre");
  }

}
