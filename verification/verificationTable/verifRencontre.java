import java.sql.*;

public class verifRencontre {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select * from Rencontre";

  public verifRencontre() {

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

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Données contenues dans la table Rencontre : ");

      if(!rset.next())
        System.out.println("Aucune donnée contenue dans la table Rencontre.");

      while(rset.next()) {
        int numRencontre = rset.getInt(1);
        String nomTour = rset.getString(2);
        int idJoueur = rset.getInt(3);
        System.out.println("| numRencontre : " + numRencontre + " | nomTour : " + nomTour
        + " | idJoueur : " + idJoueur + " |");
      }

      // Fermeture
      rset.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public static void main(String args[]) {
    new verifRencontre();
  }
}
