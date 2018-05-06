package connection;
import java.sql.*;

public class DebutQuart {
  private int[] tabClassement = new int[8];
// static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
// static final String USER = "dhouibd"; // A remplacer pour votre compte
// static final String PASSWD = "dhouibd";
static final String STMT ="Select idJoueur,count(nomTour) from Rencontre where nomTour='qualifications' group by(idJoueur) LIMIT 0,8 ORDER by count(nomTour) ASC";
public DebutQuart(Connection conn) {
try {
// Enregistrement du driver Oracle
  // System.out.print("Loading Oracle driver... ");
  // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  // System.out.println("loaded");
  // // Etablissement de la connection
  // System.out.print("Connecting to the database... ");
  // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  // System.out.println("connected");
  // Creation de la requete
  Statement stmt = conn.createStatement();
  // Execution de la requete
  ResultSet rset = stmt.executeQuery(STMT);

  int i = 0;

  while(rset.next()){
    tabClassement[i]=rset.getInt(1);
    i++;
  }
  // Fermeture
  rset.close();
  stmt.close();
  //conn.close();
} catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
  }
}

  public int[8] getClassement(){
    return this.tabClassement ;
  }

}
