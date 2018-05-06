package connection.delete;

import java.sql.*;
import connection.MultipleQueries;

public class DeleteHistorique{
  private MultipleQueries queries;

  public DeleteHistorique() {
    ResultSet rsetHistorique = queries.getResult("Delete from Historique");
  }

}
