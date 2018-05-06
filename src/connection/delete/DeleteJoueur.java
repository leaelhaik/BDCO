import java.sql.*;
import connection.MultipleQueries;

public class DeleteJoueur{
  private MultipleQueries queries;

  public DeleteJoueur() {
    ResultSet rsetDeleteJoueur = queries.getResult("Delete from Joueur");
  }

}
