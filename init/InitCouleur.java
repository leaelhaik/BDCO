import java.sql.*;

public class InitCouleur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMT1 = "insert into Couleur Values('blanc')";
  static final String STMT2 = "insert into Couleur Values('noir')";

  public InitCouleur() {
    try {
      // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");
      conn.setAutoCommit(false);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      // Execution de la requete
      ResultSet rset1 = stmt.executeQuery(STMT1);
      ResultSet rset2 = stmt.executeQuery(STMT2);


      conn.commit();
      rset1.close();
      rset2.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

    public static void main(String args[]) {
      new InitCouleur();
    }
}
