import java.sql.*;

public class InsertJoueur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "insert into Joueur Values(0,null,null,null,null)";

  public InsertJoueur()
  // String nom, String prenom, String adresse, Date date)
  {
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
      ResultSet rset = stmt.executeQuery(STMT);

      int i=1;
      for(i=1; i<10; i++) {
        String STMT1 = "insert into Joueur Values(?,'do','Dh',null,'Chez totooo')";
        PreparedStatement statement = conn.prepareStatement(STMT1);
        statement.setInt(1,i);
        statement.executeUpdate();
      }
      // Execution de la requete
      conn.commit();
      rset.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }


    public static void main(String args[]) {
      new InsertJoueur();
    }
  }
