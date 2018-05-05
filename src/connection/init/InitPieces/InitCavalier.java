import java.sql.*;

public class InitCavalier {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  // static final String STMTDrop = "Drop TABLE Piece";
  // static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL ,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))";


  // Finale
  static final String STMT1 = "Insert into Cavalier Values('1','B','1','B','1','blanc','1', 'finale')";
  static final String STMT2 = "Insert into Cavalier Values('2','G','1','G','1','blanc','1', 'finale')";
  static final String STMT3 = "Insert into Cavalier Values('3','B','8','B','8','noir','1', 'finale')";
  static final String STMT4 = "Insert into Cavalier Values('4','G','8','G','8','noir','1', 'finale')";

  // Demies finale
  static final String STMT5 = "Insert into Cavalier Values('5','B','1','B','1','blanc','1', 'demiFinale')";
  static final String STMT6 = "Insert into Cavalier Values('6','G','1','G','1','blanc','1', 'demiFinale')";
  static final String STMT7 = "Insert into Cavalier Values('7','B','8','B','8','noir','1', 'demiFinale')";
  static final String STMT8 = "Insert into Cavalier Values('8','G','8','G','8','noir','1', 'demiFinale')";
  static final String STMT9 = "Insert into Cavalier Values('9','B','1','B','1','blanc','2', 'demiFinale')";
  static final String STMT10 = "Insert into Cavalier Values('10','G','1','G','1','blanc','2', 'demiFinale')";
  static final String STMT11 = "Insert into Cavalier Values('11','B','8','B','8','noir','2', 'demiFinale')";
  static final String STMT12 = "Insert into Cavalier Values('12','G','8','G','8','noir','2', 'demiFinale')";

  // Quarts de finale
  static final String STMT13 = "Insert into Cavalier Values('13','B','1','B','1','blanc','1', 'quartFinale')";
  static final String STMT14 = "Insert into Cavalier Values('14','G','1','G','1','blanc','1', 'quartFinale')";
  static final String STMT15 = "Insert into Cavalier Values('15','B','8','B','8','noir','1', 'quartFinale')";
  static final String STMT16 = "Insert into Cavalier Values('16','G','8','G','8','noir','1', 'quartFinale')";
  static final String STMT17 = "Insert into Cavalier Values('17','B','1','B','1','blanc','2', 'quartFinale')";
  static final String STMT18 = "Insert into Cavalier Values('18','G','1','G','1','blanc','2', 'quartFinale')";
  static final String STMT19 = "Insert into Cavalier Values('19','B','8','B','8','noir','2', 'quartFinale')";
  static final String STMT20 = "Insert into Cavalier Values('20','G','8','G','8','noir','2', 'quartFinale')";
  static final String STMT21 = "Insert into Cavalier Values('21','B','1','B','1','blanc','3', 'quartFinale')";
  static final String STMT22 = "Insert into Cavalier Values('22','G','1','G','1','blanc','3', 'quartFinale')";
  static final String STMT23 = "Insert into Cavalier Values('23','B','8','B','8','noir','3', 'quartFinale')";
  static final String STMT24 = "Insert into Cavalier Values('24','G','8','G','8','noir','3', 'quartFinale')";
  static final String STMT25 = "Insert into Cavalier Values('25','B','1','B','1','blanc','4', 'quartFinale')";
  static final String STMT26 = "Insert into Cavalier Values('26','G','1','G','1','blanc','4', 'quartFinale')";
  static final String STMT27 = "Insert into Cavalier Values('27','B','8','B','8','noir','4', 'quartFinale')";
  static final String STMT28 = "Insert into Cavalier Values('28','G','8','G','8','noir','4', 'quartFinale')";

  // Qualifications
  static final String STMTC1B = "Insert into Cavalier Values('?','B','1','B','1','blanc','?', 'qualifications')";
  static final String STMTC2B = "Insert into Cavalier Values('?','G','1','G','1','blanc','?', 'qualifications')";
  static final String STMTC1N = "Insert into Cavalier Values('?','B','8','B','8','noir','?', 'qualifications')";
  static final String STMTC2N = "Insert into Cavalier Values('?','G','8','G','8','noir','?', 'qualifications')";

  public InitCavalier(int nbRencontresQualif) {

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
        int numRencontre = 29;
        for(i=29; i<=29+nbRencontresQualif*4; i+=4) {
          PreparedStatement statementC1B = conn.prepareStatement(STMTC1B);
          statementC1B.setObject(1,i);
          statementC1B.setObject(2,numRencontre);
          statementC1B.executeUpdate();
          PreparedStatement statementC2B = conn.prepareStatement(STMTC2B);
          statementC2B.setObject(1,i+1);
          statementC2B.setObject(2,numRencontre);
          statementC2B.executeUpdate();
          PreparedStatement statementC1N = conn.prepareStatement(STMTC1N);
          statementC1N.setObject(1,i+2);
          statementC1N.setObject(2,numRencontre);
          statementC1N.executeUpdate();
          PreparedStatement statementC2N = conn.prepareStatement(STMTC2N);
          statementC2N.setObject(1,i+3);
          statementC2N.setObject(2,numRencontre);
          statementC2N.executeUpdate();
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
    new InitCavalier(10);
  }

}
