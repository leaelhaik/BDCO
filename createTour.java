import java.sql.*;
public class SimpleQuery {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "insert into Tour Values('finale')";
static final String STMT = "insert into Tour Values('demiFinale')";
static final String STMT = "insert into Tour Values('quartFinale')";
static final String STMT = "insert into Tour Values('qualifications')";
public SimpleQuery() {
try {
// Enregistrement du driver Oracle
  System.out.print("Loading Oracle driver... ");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  System.out.println("loaded");
  // Etablissement de la connection
  System.out.print("Connecting to the database... ");
  Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  System.out.println("connected");
  // Creation de la requete
  Statement stmt = conn.createStatement();
  // Execution de la requete
  ResultSet rset1 = stmt.executeQuery(STMT1);
  ResultSet rset2 = stmt.executeQuery(STMT2);
  ResultSet rset3 = stmt.executeQuery(STMT3);
  ResultSet rset4 = stmt.executeQuery(STMT4);

  stmt.close();
  conn.close();
} catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
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
    new SimpleQuery();
  }
}
