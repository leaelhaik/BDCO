package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropHistorique{
  private MultipleQueries queries;

  public DropHistorique() {
    ResultSet rsetDropHistorique = queries.getResult("Drop TABLE Historique");
  }

  public static void main(String args[]) {
    new DropHistorique();
  }

}
