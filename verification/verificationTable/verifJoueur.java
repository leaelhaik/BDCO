import java.sql.*;

public class verifJoueur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select * from Joueur";
  // static final String STMT2 = "insert into Joueur values('2', 'duchenne', 'thomas' , '28-MAY-1996','1 rue des Clercs')";
  // static final String STMT2 = "delete from Joueur";

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
      conn.setAutoCommit(false);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      // Execution de la requete
      // ResultSet rset2 = stmt.executeQuery(STMT2);
      ResultSet rset = stmt.executeQuery(STMT);


      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Données contenues dans la table Joueur : ");

      if(!rset.next())
        System.out.println("Aucune donnée contenue dans la table Joueur.");

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
