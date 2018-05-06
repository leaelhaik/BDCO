package connection.verification.verificationTable;
<<<<<<< HEAD
=======
import connection.Connect;
>>>>>>> 82f01d46889ee6da6928e138b553d8387718af25
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
