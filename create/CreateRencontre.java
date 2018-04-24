import java.sql.*;

public class CreateRencontre {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  //static final String STMTCreate = "CREATE TABLE Rencontre(numRencontre integer not null check(numRencontre>0),nomTour varchar(20) NOT NULL,idJoueur integer NOT NULL,PRIMARY KEY(numRencontre),FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur))";
  static final String STMT1 = "insert into Rencontre(numRencontre, nomTour) Values('1', 'finale')";
  // static final String STMT2 = "insert into Rencontre(nomTour,numRencontre) Values('demiFinale',1)";
  // static final String STMT3 = "insert into Rencontre(nomTour,numRencontre) Values('demiFinale',2)";
  // static final String STMT4 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',1)";
  // static final String STMT5 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',2)";
  // static final String STMT6 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',3)";
  // static final String STMT7 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',4)";
  // static final String STMT8 = "insert into Rencontre(nomTour,numRencontre) Values('qualifications',1)";
  // static final String STMT9 = "select count(idJoueur) from Joueur";

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
        //ResultSet rsetDrop1 = stmt.executeQuery(STMTDrop1);
        //ResultSet rsetCreate = stmt.executeQuery(STMTCreate);

        ResultSet rset1 = stmt.executeQuery(STMT1);
        // ResultSet rset2 = stmt.executeQuery(STMT2);
        // ResultSet rset3 = stmt.executeQuery(STMT3);
        // ResultSet rset4 = stmt.executeQuery(STMT4);
        // ResultSet n = stmt.executeQuery(STMT9); //le nombre de joueurs, faire une boucle pour les qualifs

        conn.commit();
        // rsetCreate.close();
        rset1.close();
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
