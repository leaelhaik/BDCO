import java.sql.*;

public class InitReine {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  // Finale
  static final String STMT1 = "Insert into Reine Values('1','C','1','C','1','blanc','1', 'finale')";
  static final String STMT2 = "Insert into Reine Values('2','E','8','E','8','noir','1', 'finale')";

  // Demies finale
  static final String STMT3 = "Insert into Reine Values('3','C','1','C','1','blanc','1', 'demiFinale')";
  static final String STMT4 = "Insert into Reine Values('4','E','8','E','8','noir','1', 'demiFinale')";
  static final String STMT5 = "Insert into Reine Values('5','C','1','C','1','blanc','2', 'demiFinale')";
  static final String STMT6 = "Insert into Reine Values('6','E','8','E','8','noir','2', 'demiFinale')";

  // Quarts de finale
  static final String STMT7 = "Insert into Reine Values('7','C','1','C','1','blanc','1', 'quartFinale')";
  static final String STMT8 = "Insert into Reine Values('8','E','8','E','8','noir','1', 'quartFinale')";
  static final String STMT9 = "Insert into Reine Values('9','C','1','C','1','blanc','2', 'quartFinale')";
  static final String STMT10 = "Insert into Reine Values('10','E','8','E','8','noir','2', 'quartFinale')";
  static final String STMT11 = "Insert into Reine Values('11','C','1','C','1','blanc','3', 'quartFinale')";
  static final String STMT12 = "Insert into Reine Values('12','E','8','E','8','noir','3', 'quartFinale')";
  static final String STMT13 = "Insert into Reine Values('13','C','1','C','1','blanc','4', 'quartFinale')";
  static final String STMT14 = "Insert into Reine Values('14','E','8','E','8','noir','4', 'quartFinale')";

  // Qualifications
  static final String STMTRB = "Insert into Reine Values('?','C','1','C','1','blanc','?', 'qualifications')";
  static final String STMTRN = "Insert into Reine Values('?','E','8','E','8','noir','?', 'qualifications')";

  public InitReine(int nbRencontresQualif) {

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
        // ResultSet rsetDrop = stmt.executeQuery(STMTDrop);
        // ResultSet rsetCreate = stmt.executeQuery(STMTCreate);

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

        int i=1;
        int numRencontre=1;
        for(i=15; i<=15+nbRencontresQualif*2; i+=2) {
          PreparedStatement statementRB = conn.prepareStatement(STMTRB);
          statementRB.setObject(1,i);
          statementRB.setObject(2,numRencontre);
          statementRB.executeUpdate();
          PreparedStatement statementRN = conn.prepareStatement(STMTRN);
          statementRN.setObject(1,i+1);
          statementRN.setObject(2,numRencontre);
          statementRN.executeUpdate();
          numRencontre++;
        }

        // Fermeture
        conn.commit();
        // rsetDrop.close();
        // rsetCreate.close();
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
    new InitReine(10);
  }

}
