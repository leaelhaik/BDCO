import java.sql.*;

public class verifPiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select * from Piece";

  public verifPiece() {

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
      System.out.println("Données contenues dans la table Piece : ");

      if(!rset.next())
        System.out.println("Aucune donnée contenue dans la table Piece.");

      while(rset.next()) {
        int idPiece = rset.getInt(1);
        String typePiece = rset.getString(2);
        int posX = rset.getInt(3);
        int posY = rset.getInt(4);
        int oldX = rset.getInt(5);
        int oldY = rset.getInt(6);
        String couleur = rset.getString(7);
        int numRencontre = rset.getInt(8);
        String nomTour = rset.getString(9);
        System.out.println("| idPiece : " + idPiece + " | typePiece : " + typePiece
        + " | posX : " + posX + " | posY : " + posY + " | oldX : " + oldX + " | oldY : " +
        oldY + " | couleur : " + couleur + " | numRencontre : " + numRencontre +
        " | nomTour : " + nomTour + " |");
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
    new verifPiece();
  }
}
