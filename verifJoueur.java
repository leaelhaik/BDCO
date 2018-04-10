import java.sql.*;

public class verifJoueur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  public verifJoueur() {

    try {
      // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");
      // Creation de la requete
      PrepareStatement stmt = conn.createStatement("select * from Joueur;");
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Données contenues dans la table Joueur : ");

      while(rset.next()) {
        int idJoueur = rset.getInt(1);
        String nomJoueur = rset.getString(2);
        String prenomJoueur = rset.getString(3);
        java.sql.Date date = rset.getDate(4);
        String adresseJoueur = rset.getString(5);
        System.out.println("| idJoueur : " + idJoueur + " | nomJoueur : " + nomJoueur
        + " | prenomJoueur : " + prenomJoueur + " | date : " + date + " | adresseJoueur : "
        + adresseJoueur + " |");
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
    new verifJoueur();
  }
}
