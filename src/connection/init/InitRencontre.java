package connection.init;
import java.sql.*;

public class InitRencontre {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMT1 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1', 'finale', '0')";
  static final String STMT2 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1','demiFinale', '0')";
  static final String STMT3 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('2','demiFinale', '0')";
  static final String STMT4 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1','quartFinale', '0')";
  static final String STMT5 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('2','quartFinale', '0')";
  static final String STMT6 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('3','quartFinale', '0')";
  static final String STMT7 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values('4','quartFinale', '0')";

  public InitRencontre() {
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
        ResultSet rset2 = stmt.executeQuery(STMT2);
        ResultSet rset3 = stmt.executeQuery(STMT3);
        ResultSet rset4 = stmt.executeQuery(STMT4);
        ResultSet rset5 = stmt.executeQuery(STMT5);
        ResultSet rset6 = stmt.executeQuery(STMT6);
        ResultSet rset7 = stmt.executeQuery(STMT7);

        conn.commit();
        // rsetCreate.close();
        //rset1.close();
        rset2.close();
        rset3.close();
        rset4.close();
        rset5.close();
        rset6.close();
        rset7.close();
        stmt.close();
        conn.close();
      } catch (SQLException e) {
          System.err.println("failed");
          e.printStackTrace(System.err);
        }
  }

    public static void main(String args[]) {
      new InitRencontre();
    }
}
