package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropTour{
  private MultipleQueries queries;

  public DropTour() {
    ResultSet rsetDropTour = queries.getResult("Drop TABLE Tour");
  }

  public static void main(String args[]) {
    new DropTour();
  }

}
