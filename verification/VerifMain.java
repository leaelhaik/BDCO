import java.sql.*;

public class VerifMain {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTSelectCavalier = "select * from Cavalier";
  static final String STMTSelectFou = "select * from Fou";
  static final String STMTSelectPion = "select * from Pion";
  static final String STMTSelectReine = "select * from Reine";
  static final String STMTSelectReine = "select * from Reine";
  static final String STMTSelectRoi = "select * from Roi";
  static final String STMTSelectAffectationCouleur = "select * from AffectationCouleur";
  static final String STMTSelectCouleur = "select * from Couleur";
  static final String STMTSelectHistorique = "select * from Historique";
  static final String STMTSelectJoueur = "select * from Joueur";
  static final String STMTSelectRencontre = "select * from Rencontre";
  static final String STMTSelectTour = "select * from Tour";
  // private String dodo = "Dounia";
  // static final String STMTSelectDodo = "select * from Joueur where prenomJoueur= ?";

  public VerifMain() {

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

      System.out.println("Table Cavalier");
      ResultSet rsetSelectCavalier = stmt.executeQuery(STMTSelectCavalier);
      dumpResultSet(rsetSelectCavalier);
      System.out.println("");

      System.out.println("Table Fou");
      ResultSet rsetSelectFou = stmt.executeQuery(STMTSelectFou);
      dumpResultSet(rsetSelectFou);
      System.out.println("");

      System.out.println("Table Pion");
      ResultSet rsetSelectPion = stmt.executeQuery(STMTSelectPion);
      dumpResultSet(rsetSelectPion);
      System.out.println("");

      System.out.println("Table Reine");
      ResultSet rsetSelectReine = stmt.executeQuery(STMTSelectReine);
      dumpResultSet(rsetSelectReine);
      System.out.println("");

      System.out.println("Table Roi");
      ResultSet rsetSelectRoi = stmt.executeQuery(STMTSelectRoi);
      dumpResultSet(rsetSelectRoi);
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

      System.out.println("Table Tour");
      ResultSet rsetSelectTour = stmt.executeQuery(STMTSelectTour);
      dumpResultSet(rsetSelectTour);
      System.out.println("");

      // PreparedStatement pS = conn.prepareStatement(STMTSelectDodo);
      // System.out.println("Dodo");
      // pS.setString(1,dodo);
      // pS.executeUpdate();
      // ResultSet rsetSelectDodo = pS.executeQuery();
      // dumpResultSet(rsetSelectDodo);

      // Fermeture
      rsetSelectTour.close();
      rsetSelectRencontre.close();
      rsetSelectJoueur.close();
      rsetSelectHistorique.close();
      rsetSelectCouleur.close();
      rsetSelectAffectationCouleur.close();
      rsetSelectCavalier.close();
      rsetSelectFou.close();
      rsetSelectPion.close();
      rsetSelectReine.close();
      rsetSelectRoi.close();
      rsetSelectTour.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  private void dumpResultSet(ResultSet rset) throws SQLException {
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
    new VerifMain();
  }
}
