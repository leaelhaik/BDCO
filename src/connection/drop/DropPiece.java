package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropPiece{
  private MultipleQueries queries;

  public DropPiece() {
    ResultSet rsetDropRencontre = queries.getResult("Drop TABLE Piece");
  }

  public static void main(String args[]) {
    new DropPiece();
  }

}
