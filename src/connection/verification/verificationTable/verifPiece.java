//package connection.verification.verificationTable;

import java.sql.*;

public class verifPiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select * from Piece";

  public verifPiece(Connection conn) {
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

  public static void main(String args[]) {
    Connect co = new Connect();
    Connection conn = co.getConnection();
    new verifPiece(conn);
    co.closeConnection();
  }
}
