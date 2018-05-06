import java.sql.*;
import connection.MultipleQueries;

public class DeletePiece{
  private MultipleQueries queries;

  public DeletePiece() {
    ResultSet rsetDeleteJoueur = queries.getResult("Delete from Piece");
  }

}
