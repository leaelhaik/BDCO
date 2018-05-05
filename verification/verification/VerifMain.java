package verification;
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

  public VerifMain() {

  }

  public static void afficheTables(Statement stmt) throws SQLException {
    System.out.println("Table Piece");
    ResultSet rsetSelectPiece = stmt.executeQuery(STMTSelectPiece);
    dumpResultSet(rsetSelectPiece);
    System.out.println("");

    System.out.println("Table Tour");
    ResultSet rsetSelectTour = stmt.executeQuery(STMTSelectTour);
    dumpResultSet(rsetSelectTour);
    System.out.println("");

    System.out.println("Table Affectation Couleur");
    ResultSet rsetSelectAffectationCouleur = stmt.executeQuery(STMTSelectAffectationCouleur);
    dumpResultSet(rsetSelectAffectationCouleur);
    System.out.println("");

    System.out.println("Table Couleur");
    ResultSet rsetSelectCouleur = stmt.executeQuery(STMTSelectCouleur);
    dumpResultSet(rsetSelectCouleur);
    System.out.println("");

    System.out.println("Table Historique");
    ResultSet rsetSelectHistorique = stmt.executeQuery(STMTSelectHistorique);
    dumpResultSet(rsetSelectHistorique);
    System.out.println("");

    System.out.println("Table Joueur");
    ResultSet rsetSelectJoueur = stmt.executeQuery(STMTSelectJoueur);
    dumpResultSet(rsetSelectJoueur);
    System.out.println("");

    System.out.println("Table Rencontre");
    ResultSet rsetSelectRencontre = stmt.executeQuery(STMTSelectRencontre);
    dumpResultSet(rsetSelectRencontre);
    System.out.println("");

    rsetSelectTour.close();
    rsetSelectRencontre.close();
    rsetSelectJoueur.close();
    rsetSelectHistorique.close();
    rsetSelectCouleur.close();
    rsetSelectAffectationCouleur.close();
    rsetSelectPiece.close();

  }

  private static void dumpResultSet(ResultSet rset) throws SQLException {
    ResultSetMetaData rsetmd = rset.getMetaData();
    int i = rsetmd.getColumnCount();
    for (int k=1;k<=i;k++)
      System.out.print(rsetmd.getColumnName(k) + "\t");
    System.out.println();
    while (rset.next()) {
      for (int j = 1; j <= i; j++) {
        System.out.print(rset.getString(j) + "\t");
      }
      System.out.println();
    }
  }

  public static void main(String args []) {
    VerifMain toto = new VerifMain();

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

      // PreparedStatement pS = conn.prepareStatement(STMTSelectDodo);
      // System.out.println("Dodo");
      // pS.setString(1,dodo);
      // pS.executeUpdate();
      // ResultSet rsetSelectDodo = pS.executeQuery();
      // dumpResultSet(rsetSelectDodo);

      afficheTables(stmt);
      // Fermeture
      stmt.close();
      conn.close();

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }
}
