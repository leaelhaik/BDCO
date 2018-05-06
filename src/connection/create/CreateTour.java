package connection.create;

import java.sql.*;
import connection.MultipleQueries;

public class CreateTour{
  private MultipleQueries queries;

  public CreateTour() {
	  queries = new MultipleQueries();
    ResultSet rsetCreateTour = queries.getResult("CREATE TABLE Tour(nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),PRIMARY KEY(nomTour))");
  }

}
