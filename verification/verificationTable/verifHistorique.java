import java.sql.*;

public class verifHistorique {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select * from Historique";

  public verifHistorique() {

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
      System.out.println("Données contenues dans la table Historique : ");

      if(!rset.next())
        System.out.println("Aucune donnée contenue dans la table Historique.");

      while(rset.next()) {
        int idCoup = rset.getInt(1);
        String nomTour = rset.getString(2);
        int numRencontre = rset.getInt(3);
        System.out.println("| idCoup : " + idCoup + " | nomTour : " + nomTour
        + " | numRencontre : " + numRencontre + " |");
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
    new verifHistorique();
  }
}
