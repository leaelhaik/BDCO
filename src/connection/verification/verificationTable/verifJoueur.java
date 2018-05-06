package connection.verification.verificationTable;
import connection.Queries;
import connection.SimpleQuery;

import java.sql.*;

public class verifJoueur {


  public verifJoueur() {

    try {
      ResultSet rset = Queries.queries.getResult("select * from Joueur");
      rset.close();
    } catch(SQLException e) {
            System.err.println("failed");
            e.printStackTrace();
      }
  }

  

  public static ResultSet tousLesJoueurs() {
      ResultSet rset = Queries.queries.getResult("select * from Joueur");
      return rset;
 
  }

}
