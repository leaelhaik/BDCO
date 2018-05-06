package connection.verification.verificationTable;
import connection.Connect;
import connection.SimpleQuery;

import java.sql.*;

public class verifJoueur {

  static final String STMT = "select * from Joueur";

  public verifJoueur(Connection conn) {

    try {
      SimpleQuery req = new SimpleQuery(STMT, conn);
      ResultSet rset = req.getResult();
      dumpResultSet(rset);
      rset.close();
    } catch(SQLException e) {
            System.err.println("failed");
            e.printStackTrace();
      }
  }

  private void dumpResultSet(ResultSet rset) throws SQLException {
    ResultSetMetaData rsetmd = rset.getMetaData();
    int i = rsetmd.getColumnCount();
    for (int k=1;k<=i;k++)
      System.out.print(rsetmd.getColumnName(k) + "\t");
    System.out.println();
    while (rset.next()) {
      for (int j = 1; j <= i; j++) {
        System.out.print(rset.getString(j) + "\t");
      }
      System.out.println();
    }
  }

  public static ResultSet tousLesJoueurs(Connection conn) throws SQLException{
    //try {
      SimpleQuery req = new SimpleQuery(STMT, conn);
      ResultSet rset = req.getResult();
      return rset;
      //rset.close();
    /*
    } catch(SQLException e) {
      System.err.println("failed");
      e.printStackTrace();
    }*/
  }

  public static void main(String args[]) {
    Connect co = new Connect();
    Connection conn = co.getConnection();
    new verifJoueur(conn);
    co.closeConnection();
  }
}
