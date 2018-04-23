import java.sql.*;

public class DebutPartie{

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTDrop = "Drop TABLE Piece";
  static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL ,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX integer check(posX<9),posY character check(posY in ('A','B','C','D','E','F','G','H')),oldX integer check(oldX<9),oldY character check(oldY in ('A','B','C','D','E','F','G','H')),couleur	character varying(5) check(couleur in('blanc','noir')),PRIMARY KEY(idPiece))";

  static final String STMT1 = "Insert into Piece Values('1','tour','1','A','1','A','blanc',?,?)";
  static final String STMT2 = "Insert into Piece Values('2','tour','1','H','1','H','blanc',?,?)";
  static final String STMT3 = "Insert into Piece Values('3','cavalier','1','B','1','B','blanc',?,?)";
  static final String STMT4 = "Insert into Piece Values('4','cavalier','1','G','1','G','blanc',?,?)";
  static final String STMT5 = "Insert into Piece Values('5','fou','1','C','1','C','blanc',?,?)";
  static final String STMT6 = "Insert into Piece Values('6','fou','1','F','1','F','blanc',?,?)";
  static final String STMT7 = "Insert into Piece Values('7','reine','1','D','1','D','blanc',?,?)";
  static final String STMT8 = "Insert into Piece Values('8','roi','1','E','1','E','blanc',?,?)";
  static final String STMT9 = "Insert into Piece Values('9','pion','2','A','1','A','blanc',?,?)";
  static final String STMT10 = "Insert into Piece Values('10','pion','2','H','1','H','blanc',?,?)";
  static final String STMT11 = "Insert into Piece Values('11','pion','2','B','1','B','blanc',?,?)";
  static final String STMT12 = "Insert into Piece Values('12','pion','2','G','1','G','blanc',?,?)";
  static final String STMT13 = "Insert into Piece Values('13','pion','2','C','1','C','blanc',?,?)";
  static final String STMT14 = "Insert into Piece Values('14','pion','2','F','1','F','blanc',?,?)";
  static final String STMT15 = "Insert into Piece Values('15','pion','2','D','1','D','blanc',?,?)";
  static final String STMT16 = "Insert into Piece Values('16','pion','2','E','1','E','blanc',?,?)";
  static final String STMT17 = "Insert into Piece Values('17','tour','8','A','1','A','noir',?,?)";
  static final String STMT18 = "Insert into Piece Values('18','tour','8','H','1','H','noir',?,?)";
  static final String STMT19 = "Insert into Piece Values('19','cavalier','8','B','1','B','noir',?,?)";
  static final String STMT20 = "Insert into Piece Values('20','cavalier','8','G','1','G','noir',?,?)";
  static final String STMT21 = "Insert into Piece Values('21','fou','8','C','1','C','noir',?,?)";
  static final String STMT22 = "Insert into Piece Values('22','fou','8','F','1','F','noir',?,?)";
  static final String STMT23 = "Insert into Piece Values('23','reine','8','E','1','D','noir',?,?)";
  static final String STMT24 = "Insert into Piece Values('24','roi','8','D','1','E','noir',?,?)";
  static final String STMT25 = "Insert into Piece Values('25','pion','7','A','1','A','noir',?,?)";
  static final String STMT26 = "Insert into Piece Values('26','pion','7','H','1','H','noir',?,?)";
  static final String STMT27 = "Insert into Piece Values('27','pion','7','B','1','B','noir',?,?)";
  static final String STMT28 = "Insert into Piece Values('28','pion','7','G','1','G','noir',?,?)";
  static final String STMT29 = "Insert into Piece Values('29','pion','7','C','1','C','noir',?,?)";
  static final String STMT30 = "Insert into Piece Values('30','pion','7','F','1','F','noir',?,?)";
  static final String STMT31 = "Insert into Piece Values('31','pion','7','D','1','D','noir',?,?)";
  static final String STMT32 = "Insert into Piece Values('32','pion','7','E','1','E','noir',?,?)";


  public DebutPartie() {

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
        //Statement stmt = conn.createStatement();
        //ResultSet rset = stmt.executeQuery(STMTCreate);

        //Statement stmt1 = conn.createStatement();
        //ResultSet rset1 = stmt1.executeQuery(STMT1);
        Statement stmt = conn.createStatement();
        ResultSet rsetDrop = stmt.executeQuery(STMTDrop);
        ResultSet rsetCreate = stmt.executeQuery(STMTCreate);

        ResultSet rset2 = stmt.executeQuery(STMT2);
        ResultSet rset3 = stmt.executeQuery(STMT3);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT4);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT5);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT6);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT7);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT8);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT9);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT10);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT11);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT12);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT13);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT14);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT15);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT16);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT17);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT18);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT19);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT20);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT21);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT22);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT23);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT24);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT25);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT26);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT27);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT28);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT29);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT30);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT31);
        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery(STMT32);

        // Fermeture
        //rset1.close();
        //stmt1.close();
        // rset.close();
        // stmt.close();
        rsetDrop.close();
        rsetCreate.close();
        rset2.close();
        rset3.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public static void main(String args[]) {
    new DebutPartie();
  }

}
