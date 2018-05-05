package connection.drop;
import java.sql.*;

public class DropMain{

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTDropTour = "Drop TABLE Tour";
  static final String STMTDropAffectationCouleur = "Drop TABLE AffectationCouleur";
  static final String STMTDropCouleur = "Drop TABLE Couleur";
  static final String STMTDropHistorique = "Drop TABLE Historique";
  static final String STMTDropJoueur = "Drop TABLE Joueur";
  static final String STMTDropPiece = "Drop TABLE Piece";
  static final String STMTDropRencontre = "Drop TABLE Rencontre";


  public DropMain() {

    try {
      // Enregistrement du driver
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
        ResultSet rsetDropHistorique = stmt.executeQuery(STMTDropHistorique);
        ResultSet rsetDropPiece = stmt.executeQuery(STMTDropPiece);
        ResultSet rsetDropAffectationCouleur = stmt.executeQuery(STMTDropAffectationCouleur);
        ResultSet rsetDropRencontre = stmt.executeQuery(STMTDropRencontre);
        ResultSet rsetDropTour = stmt.executeQuery(STMTDropTour);
        ResultSet rsetDropJoueur = stmt.executeQuery(STMTDropJoueur);
        ResultSet rsetDropCouleur = stmt.executeQuery(STMTDropCouleur);

        // Fermeture

        conn.commit();
        // rsetDropHistorique.close();
        // rsetDropCavalier.close();
        // rsetDropFou.close();
        // rsetDropPion.close();
        // rsetDropReine.close();
        // rsetDropRoi.close();
        // rsetDropTour.close();
        // rsetDropPiece.close();
        // rsetDropAffectationCouleur.close();
        // rsetDropRencontre.close();
        // rsetDropTour.close();
        // rsetDropJoueur.close();
        // rsetDropCouleur.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public static void main(String args[]) {
    new DropMain();
  }

}
