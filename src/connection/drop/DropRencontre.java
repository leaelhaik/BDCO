package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropRencontre{
  private MultipleQueries queries;

  public DropRencontre() {
    ResultSet rsetDropRencontre = queries.getResult("Drop TABLE Rencontre");
  }

  public static void main(String args[]) {
    new DropRencontre();
  }

}
