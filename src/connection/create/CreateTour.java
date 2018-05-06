import java.sql.*;
import connection.MultipleQueries;

public class CreateTour{
  private MultipleQueries queries;

  public CreateTour() {
    ResultSet rsetCreateTour = queries.getResult("CREATE TABLE Tour(nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),PRIMARY KEY(nomTour))");
  }

  public static void main(String args[]) {
    new CreateTour();
  }

}
