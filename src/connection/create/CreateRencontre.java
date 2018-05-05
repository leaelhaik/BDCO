package connection.create;
import java.sql.*;

public class CreateRencontre {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "CREATE TABLE Rencontre(numRencontre integer not null ,nomTour varchar(20) NOT NULL,idJoueur integer NOT NULL,PRIMARY KEY(numRencontre, nomTour),FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur))";

  public CreateRencontre() {
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
        // rsetCreate.close();
        rset.close();
        stmt.close();
        conn.close();
      } catch (SQLException e) {
          System.err.println("failed");
          e.printStackTrace(System.err);
        }
  }

    public static void main(String args[]) {
      new CreateRencontre();
    }
}
