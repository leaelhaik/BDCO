package connection.delete;

import java.sql.*;
import connection.MultipleQueries;

public class DeleteAffectationCouleur{
  private MultipleQueries queries;

  public DeleteAffectationCouleur() {
    ResultSet rsetDeleteAffectationCouleur = queries.getResult("Delete from AffectationCouleur");
  }

}
