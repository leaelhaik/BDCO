import java.sql.*;
public class CreateTour {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";

static final String STMT = "CREATE TABLE Tour(nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),PRIMARY KEY(nomTour))";



public CreateTour() {
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
    ResultSet rset = stmt.executeQuery(STMT);


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
    new CreateTour();
  }
}
