//package verification;
import java.sql.*;

public class VerifMain {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTSelectPiece = "select * from Piece";
  static final String STMTSelectAffectationCouleur = "select * from AffectationCouleur";
  static final String STMTSelectCouleur = "select * from Couleur";
  static final String STMTSelectHistorique = "select * from Historique";
  static final String STMTSelectJoueur = "select * from Joueur";
  static final String STMTSelectRencontre = "select * from Rencontre";
  static final String STMTSelectTour = "select * from Tour";
  // private String dodo = "Dounia";
  // static final String STMTSelectDodo = "select * from Joueur where prenomJoueur= ?";

  public VerifMain(Connection conn) {
    new verifPiece(conn);
    new verifAffectationCouleur(conn);
    new verifCouleur(conn);
    new verifHistorique(conn);
    new verifJoueur(conn);
    new verifRencontre(conn);
    new verifTour(conn);
  }


  public static void main(String args []) {
    Connect co = new Connect();
    Connection conn = co.getConnection();
    new VerifMain(conn);
    co.closeConnection();
  }
}
