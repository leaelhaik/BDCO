package connection.create;
import java.sql.*;
import connection.MultipleQueries;

public class CreateCouleur{
  private MultipleQueries queries;

  public CreateCouleur() {
	queries = new MultipleQueries();
    ResultSet rsetCreateCouleur = queries.getResult("CREATE TABLE Couleur(nomCouleur character varying(5) check(nomCouleur in('blanc','noir')),primary key(nomCouleur))");
  }


}
