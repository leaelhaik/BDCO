package connection.insert;
import connection.MultipleQueries;

import java.sql.*;
import connection.MultipleQueries;
import connection.Queries;

public class InsertRencontre {

  public InsertRencontre(String nomTour,int numRencontre)
  {
    ResultSet rset1 = Queries.queries.getResult("Insert into Rencontre(numRencontre, nomTour) Values(" + numRencontre + ", \'" +nomTour+ "\')");//,\'" + 0 + "\')" );
  }
}
