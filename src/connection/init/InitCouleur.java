package connection.init;
import java.sql.*;
import connection.MultipleQueries;
import connection.Queries;


public class InitCouleur {

  public InitCouleur() {
    ResultSet rsetInitCouleur1 = Queries.queries.getResult("insert into Couleur Values('blanc')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Couleur Values('noir')");
  }


}
