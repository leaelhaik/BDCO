package connection.init;
import java.sql.*;
import connection.MultipleQueries;
import connection.Queries;

public class InitTour {


  public InitTour() {
    ResultSet rsetInitTour1= Queries.queries.getResult("insert into Tour Values('finale')");
    ResultSet rsetInitTour2 = Queries.queries.getResult("insert into Tour Values('demiFinale')");
    ResultSet rsetInitTour3 = Queries.queries.getResult("insert into Tour Values('quartFinale')");
    ResultSet rsetInitTour4 = Queries.queries.getResult("insert into Tour Values('qualifications')");
  }
}
