import java.sql.*;

public class InitAffectationCouleur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT1 = "Insert into AffectationCouleur Values('0','blanc','finale','1')";
  static final String STMT2 = "Insert into AffectationCouleur Values('0','noir','finale','1')";
  static final String STMT3 = "Insert into AffectationCouleur Values('0','blanc','demiFinale','1')";
  static final String STMT4 = "Insert into AffectationCouleur Values('0','noir','demiFinale','1')";
  static final String STMT5 = "Insert into AffectationCouleur Values('0','blanc','demiFinale','2')";
  static final String STMT6 = "Insert into AffectationCouleur Values('0','noir','demiFinale','2')";
  static final String STMT7 = "Insert into AffectationCouleur Values('0','blanc','quartFinale','1')";
  static final String STMT8 = "Insert into AffectationCouleur Values('0','noir','quartFinale','1')";
  static final String STMT9 = "Insert into AffectationCouleur Values('0','blanc','quartFinale','2')";
  static final String STMT10 = "Insert into AffectationCouleur Values('0','noir','quartFinale','2')";
  static final String STMT11 = "Insert into AffectationCouleur Values('0','blanc','quartFinale','3')";
  static final String STMT12 = "Insert into AffectationCouleur Values('0','noir','quartFinale','3')";
  static final String STMT13 = "Insert into AffectationCouleur Values('0','blanc','quartFinale','4')";
  static final String STMT14 = "Insert into AffectationCouleur Values('0','noir','quartFinale','4')";


  public InitAffectationCouleur()
  // String nom, String prenom, String adresse, Date date)
  {
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
      ResultSet rset1 = stmt.executeQuery(STMT1);
      ResultSet rset2 = stmt.executeQuery(STMT2);
      ResultSet rset3 = stmt.executeQuery(STMT3);
      ResultSet rset4 = stmt.executeQuery(STMT4);
      ResultSet rset5 = stmt.executeQuery(STMT5);
      ResultSet rset6 = stmt.executeQuery(STMT6);
      ResultSet rset7 = stmt.executeQuery(STMT7);
      ResultSet rset8 = stmt.executeQuery(STMT8);
      ResultSet rset9 = stmt.executeQuery(STMT9);
      ResultSet rset10 = stmt.executeQuery(STMT10);
      ResultSet rset11 = stmt.executeQuery(STMT11);
      ResultSet rset12 = stmt.executeQuery(STMT12);
      ResultSet rset13 = stmt.executeQuery(STMT13);
      ResultSet rset14 = stmt.executeQuery(STMT14);

      // Execution de la requete
      conn.commit();
      rset1.close();
      rset2.close();
      rset3.close();
      rset4.close();
      rset5.close();
      rset6.close();
      rset7.close();
      rset8.close();
      rset9.close();
      rset10.close();
      rset11.close();
      rset12.close();
      rset13.close();
      rset14.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }

    public static void main(String args[]) {
      new InitAffectationCouleur();
    }
  }
