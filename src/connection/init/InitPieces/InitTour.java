import java.sql.*;

public class InitTour {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  // Finale
  static final String STMT1 = "Insert into Tour Values('1','A','1','A','1','blanc','1', 'finale')";
  static final String STMT2 = "Insert into Tour Values('2','H','1','H','1','blanc','1', 'finale')";
  static final String STMT3 = "Insert into Tour Values('3','A','8','A','8','noir','1', 'finale')";
  static final String STMT4 = "Insert into Tour Values('4','H','8','H','8','noir','1', 'finale')";

  // Demies finale
  static final String STMT5 = "Insert into Tour Values('5','A','1','A','1','blanc','1', 'demiFinale')";
  static final String STMT6 = "Insert into Tour Values('6','H','1','H','1','blanc','1', 'demiFinale')";
  static final String STMT7 = "Insert into Tour Values('7','A','8','A','8','noir','1', 'demiFinale')";
  static final String STMT8 = "Insert into Tour Values('8','H','8','H','8','noir','1', 'demiFinale')";
  static final String STMT9 = "Insert into Tour Values('9','A','1','A','1','blanc','2', 'demiFinale')";
  static final String STMT10 = "Insert into Tour Values('10','H','1','H','1','blanc','2', 'demiFinale')";
  static final String STMT11 = "Insert into Tour Values('11','A','8','A','8','noir','2', 'demiFinale')";
  static final String STMT12 = "Insert into Tour Values('12','H','8','H','8','noir','2', 'demiFinale')";

  // Quarts de finale
  static final String STMT13 = "Insert into Tour Values('13','A','1','A','1','blanc','1', 'quartFinale')";
  static final String STMT14 = "Insert into Tour Values('14','H','1','H','1','blanc','1', 'quartFinale')";
  static final String STMT15 = "Insert into Tour Values('15','A','8','A','8','noir','1', 'quartFinale')";
  static final String STMT16 = "Insert into Tour Values('16','H','8','H','8','noir','1', 'quartFinale')";
  static final String STMT17 = "Insert into Tour Values('17','A','1','A','1','blanc','2', 'quartFinale')";
  static final String STMT18 = "Insert into Tour Values('18','H','1','H','1','blanc','2', 'quartFinale')";
  static final String STMT19 = "Insert into Tour Values('19','A','8','A','8','noir','2', 'quartFinale')";
  static final String STMT20 = "Insert into Tour Values('20','H','8','H','8','noir','2', 'quartFinale')";
  static final String STMT21 = "Insert into Tour Values('21','A','1','A','1','blanc','3', 'quartFinale')";
  static final String STMT22 = "Insert into Tour Values('22','H','1','H','1','blanc','3', 'quartFinale')";
  static final String STMT23 = "Insert into Tour Values('23','A','8','A','8','noir','3', 'quartFinale')";
  static final String STMT24 = "Insert into Tour Values('24','H','8','H','8','noir','3', 'quartFinale')";
  static final String STMT25 = "Insert into Tour Values('25','A','1','A','1','blanc','4', 'quartFinale')";
  static final String STMT26 = "Insert into Tour Values('26','H','1','H','1','blanc','4', 'quartFinale')";
  static final String STMT27 = "Insert into Tour Values('27','A','8','A','8','noir','4', 'quartFinale')";
  static final String STMT28 = "Insert into Tour Values('28','H','8','H','8','noir','4', 'quartFinale')";

  // Qualifications
  static final String STMTT1B = "Insert into Tour Values('?','A','1','A','1','blanc','?', 'qualifications')";
  static final String STMTT2B = "Insert into Tour Values('?','H','1','H','1','blanc','?', 'qualifications')";
  static final String STMTT1N = "Insert into Tour Values('?','A','8','A','8','noir','?', 'qualifications')";
  static final String STMTT2N = "Insert into Tour Values('?','H','8','H','8','noir','?', 'qualifications')";

  public InitTour(int nbRencontresQualif) {

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

        int i=1;
        int numRencontre=1;
        for(i=29; i<=29+nbRencontresQualif*4; i+=4) {
          PreparedStatement statementT1B = conn.prepareStatement(STMTT1B);
          statementT1B.setObject(1,i);
          statementT1B.setObject(2,numRencontre);
          statementT1B.executeUpdate();
          PreparedStatement statementT2B = conn.prepareStatement(STMTT2B);
          statementT2B.setObject(1,i+1);
          statementT2B.setObject(2,numRencontre);
          statementT2B.executeUpdate();
          PreparedStatement statementT1N = conn.prepareStatement(STMTT1N);
          statementT1N.setObject(1,i+2);
          statementT1N.setObject(2,numRencontre);
          statementT1N.executeUpdate();
          PreparedStatement statementT2N = conn.prepareStatement(STMTT2N);
          statementT2N.setObject(1,i+3);
          statementT2N.setObject(2,numRencontre);
          statementT2N.executeUpdate();
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
    new InitTour(10);
  }

}
