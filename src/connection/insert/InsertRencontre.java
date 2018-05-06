package connection.insert;
import connection.MultipleQueries;

import java.sql.*;
import connection.MultipleQueries;
import connection.Queries;

public class InsertRencontre {

  static final String STMT = "Insert into Rencontre(numRencontre, nomTour, idJoueur) Values(?, ?, ?)";

  public InsertRencontre(String nomTour,int numRencontre)
  {
    ResultSet rset1 = Queries.queries.getResult("Insert into Rencontre(numRencontre, nomTour) Values(" + numRencontre + ", \'" +nomTour+ "\')");//,\'" + 0 + "\')" );
  }
}
