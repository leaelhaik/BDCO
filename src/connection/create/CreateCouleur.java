package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class CreateCouleur{
  private MultipleQueries queries;

  public CreateCouleur() {
    ResultSet rsetCreateCouleur = queries.getResult("CREATE TABLE Couleur(nomCouleur character varying(5) check(nomCouleur in('blanc','noir')),primary key(nomCouleur))");
  }

  public static void main(String args[]) {
    new CreateCouleur();
  }

}
