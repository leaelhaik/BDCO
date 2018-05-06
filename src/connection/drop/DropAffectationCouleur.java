package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropAffectationCouleur{
  private MultipleQueries queries;

  public DropAffectationCouleur() {
    ResultSet rsetDropAffectationCouleur = queries.getResult("Drop TABLE AffectationCouleur");
  }

  public static void main(String args[]) {
    new DropAffectationCouleur();
  }

}
