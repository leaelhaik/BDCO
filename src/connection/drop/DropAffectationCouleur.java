package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropPiece{
  private MultipleQueries queries;

  public DropPiece() {
    ResultSet rsetDropAffectationCouleur = queries.getResult("Drop TABLE AffectationCouleur");
  }

  public static void main(String args[]) {
    new DropAffectationCouleur();
  }

}
