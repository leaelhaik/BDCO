import java.sql.*;

public class CreateAffectationCouleur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "CREATE TABLE AffectationCouleur(idJoueur integer NOT NULL,nomCouleur character varying(5),nomTour varchar(20) NOT NULL,numRencontre integer not null,primary key(idJoueur,nomTour,numRencontre,nomCouleur),foreign key(nomCouleur) REFERENCES Couleur(nomCouleur),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour),foreign key(idJoueur) REFERENCES Joueur(idJoueur))";

  public CreateAffectationCouleur()
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
      new CreateAffectationCouleur();
    }
  }
