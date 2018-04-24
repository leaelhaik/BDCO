import java.sql.*;

public class getPiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  public getPiece(String posX, int posY, int numRencontre, String nomTour) {

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
      String STMT = "select typePiece from Piece where posX = " + posX + ", posY = " + posY + ", numRencontre = " + numRencontre + ", nomTour = " + nomTour + "";
      Statement preparedStatement = conn.preparedStatement(STMT);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);
      conn.commit();

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Piece : ");

      dumpResultSet(rset);

      // Fermeture
      rset.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }
}
