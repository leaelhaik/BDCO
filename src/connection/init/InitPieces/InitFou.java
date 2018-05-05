package connection.init.InitPieces;
import java.sql.*;

public class InitFou {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  // Finale
  static final String STMT1 = "Insert into Fou Values('1','C','1','C','1','blanc','1', 'finale')";
  static final String STMT2 = "Insert into Fou Values('2','F','1','F','1','blanc','1', 'finale')";
  static final String STMT3 = "Insert into Fou Values('3','C','8','C','8','noir','1', 'finale')";
  static final String STMT4 = "Insert into Fou Values('4','F','8','F','8','noir','1', 'finale')";

  // Demies finale
  static final String STMT5 = "Insert into Fou Values('5','C','1','C','1','blanc','1', 'demiFinale')";
  static final String STMT6 = "Insert into Fou Values('6','F','1','F','1','blanc','1', 'demiFinale')";
  static final String STMT7 = "Insert into Fou Values('7','C','8','C','8','noir','1', 'demiFinale')";
  static final String STMT8 = "Insert into Fou Values('8','F','8','F','8','noir','1', 'demiFinale')";
  static final String STMT9 = "Insert into Fou Values('9','C','1','C','1','blanc','2', 'demiFinale')";
  static final String STMT10 = "Insert into Fou Values('10','F','1','F','1','blanc','2', 'demiFinale')";
  static final String STMT11 = "Insert into Fou Values('11','C','8','C','8','noir','2', 'demiFinale')";
  static final String STMT12 = "Insert into Fou Values('12','F','8','F','8','noir','2', 'demiFinale')";

  // Quarts de finale
  static final String STMT13 = "Insert into Fou Values('13','C','1','C','1','blanc','1', 'quartFinale')";
  static final String STMT14 = "Insert into Fou Values('14','F','1','F','1','blanc','1', 'quartFinale')";
  static final String STMT15 = "Insert into Fou Values('15','C','8','C','8','noir','1', 'quartFinale')";
  static final String STMT16 = "Insert into Fou Values('16','F','8','F','8','noir','1', 'quartFinale')";
  static final String STMT17 = "Insert into Fou Values('17','C','1','C','1','blanc','2', 'quartFinale')";
  static final String STMT18 = "Insert into Fou Values('18','F','1','F','1','blanc','2', 'quartFinale')";
  static final String STMT19 = "Insert into Fou Values('19','C','8','C','8','noir','2', 'quartFinale')";
  static final String STMT20 = "Insert into Fou Values('20','F','8','F','8','noir','2', 'quartFinale')";
  static final String STMT21 = "Insert into Fou Values('21','C','1','C','1','blanc','3', 'quartFinale')";
  static final String STMT22 = "Insert into Fou Values('22','F','1','F','1','blanc','3', 'quartFinale')";
  static final String STMT23 = "Insert into Fou Values('23','C','8','C','8','noir','3', 'quartFinale')";
  static final String STMT24 = "Insert into Fou Values('24','F','8','F','8','noir','3', 'quartFinale')";
  static final String STMT25 = "Insert into Fou Values('25','C','1','C','1','blanc','4', 'quartFinale')";
  static final String STMT26 = "Insert into Fou Values('26','F','1','F','1','blanc','4', 'quartFinale')";
  static final String STMT27 = "Insert into Fou Values('27','C','8','C','8','noir','4', 'quartFinale')";
  static final String STMT28 = "Insert into Fou Values('28','F','8','F','8','noir','4', 'quartFinale')";

  // Qualifications
  static final String STMTF1B = "Insert into Fou Values('?','C','1','C','1','blanc','?', 'qualifications')";
  static final String STMTF2B = "Insert into Fou Values('?','F','1','F','1','blanc','?', 'qualifications')";
  static final String STMTF1N = "Insert into Fou Values('?','C','8','C','8','noir','?', 'qualifications')";
  static final String STMTF2N = "Insert into Fou Values('?','F','8','F','8','noir','?', 'qualifications')";

  public InitFou(int nbRencontresQualif) {

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
        ResultSet rset15 = stmt.executeQuery(STMT15);
        ResultSet rset16 = stmt.executeQuery(STMT16);
        ResultSet rset17 = stmt.executeQuery(STMT17);
        ResultSet rset18 = stmt.executeQuery(STMT18);
        ResultSet rset19 = stmt.executeQuery(STMT19);
        ResultSet rset20 = stmt.executeQuery(STMT20);
        ResultSet rset21 = stmt.executeQuery(STMT21);
        ResultSet rset22 = stmt.executeQuery(STMT22);
        ResultSet rset23 = stmt.executeQuery(STMT23);
        ResultSet rset24 = stmt.executeQuery(STMT24);
        ResultSet rset25 = stmt.executeQuery(STMT25);
        ResultSet rset26 = stmt.executeQuery(STMT26);
        ResultSet rset27 = stmt.executeQuery(STMT27);
        ResultSet rset28 = stmt.executeQuery(STMT28);

        int i=29;
        int numRencontre = 1;

        for(i=29; i<=29+nbRencontresQualif*4; i+=4) {
          PreparedStatement statementF1B = conn.prepareStatement(STMTF1B);
          statementF1B.setObject(1,i);
          statementF1B.setObject(2,numRencontre);
          statementF1B.executeUpdate();
          PreparedStatement statementF2B = conn.prepareStatement(STMTF2B);
          statementF2B.setObject(1,i+1);
          statementF2B.setObject(2,numRencontre);
          statementF2B.executeUpdate();
          PreparedStatement statementF1N = conn.prepareStatement(STMTF1N);
          statementF1N.setObject(1,i+2);
          statementF1N.setObject(2,numRencontre);
          statementF1N.executeUpdate();
          PreparedStatement statementF2N = conn.prepareStatement(STMTF2N);
          statementF2N.setObject(1,i+3);
          statementF2N.setObject(2,numRencontre);
          statementF2N.executeUpdate();
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
        rset15.close();
        rset16.close();
        rset17.close();
        rset18.close();
        rset19.close();
        rset20.close();
        rset21.close();
        rset22.close();
        rset23.close();
        rset24.close();
        rset25.close();
        rset26.close();
        rset27.close();
        rset28.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public static void main(String args[]) {
    new InitFou(10);
  }

}
