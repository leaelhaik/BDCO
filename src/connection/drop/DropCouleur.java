package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropCouleur{
  private MultipleQueries queries;

  public DropCouleur() {
    ResultSet rsetDropCouleur = queries.getResult("Drop TABLE Couleur");
  }

  public static void main(String args[]) {
    new DropCouleur();
  }

}
