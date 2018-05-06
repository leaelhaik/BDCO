package connection.delete;

import java.sql.*;
import connection.MultipleQueries;

public class DeleteCouleur{
  private MultipleQueries queries;

  public DeleteCouleur() {
    ResultSet rsetDeleteCouleur = queries.getResult("Delete from Couleur");
  }

}
