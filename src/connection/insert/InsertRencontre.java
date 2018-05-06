package connection.insert;
import java.sql.*;

public class InsertRencontre {
  private MultipleQueries queries;

  static final String STMT = "Insert into Rencontre(numRencontre, nomTour, idJoueur) Values(?, ?, ?)";

  public InsertRencontre(String nomTour,int numRenconre)
  {
    ResultSet rset1 = queries.getResult("Insert into Rencontre(numRencontre, nomTour, idJoueur) Values("+", ", ));
  }
