package connection.insert;
import java.sql.*;
import connection.MultipleQueries;

public class InsertRencontre {

  static final String STMT = "Insert into Rencontre(numRencontre, nomTour, idJoueur) Values(?, ?, ?)";

  public InsertRencontre(String nomTour,int numRenconre)
  {
    ResultSet rset1 = queries.getResult("Insert into Rencontre(numRencontre, nomTour, idJoueur) Values(" +numRencontre+ ", \'" +nomTour+ "\',\'"+0+"");
  }
}
