import java.sql.*;

public class verifAffectationCouleur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  public verifAffectationCouleur() {

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
      PrepareStatement stmt = conn.createStatement("select * from AffectationCouleur;");
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Données contenues dans la table AffectationCouleur : ");

      while(rset.next()) {
        int idJoueur = rset.getInt(1);
        String nomCouleur = rset.getString(2);
        int numRencontre = rset.getInt(3);
        System.out.println("| idJoueur : " + idJoueur + " | nomCouleur : " + nomCouleur
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
    new verifAffectationCouleur();
  }
}
