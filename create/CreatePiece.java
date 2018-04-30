import java.sql.*;

public class CreatePiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  // static final String STMTDrop = "Drop TABLE Piece";
  static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL ,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))";

  static final String STMT1 = "Insert into Piece Values('1','tour','A','1','A','1','blanc','finale', '1')";
  static final String STMT2 = "Insert into Piece Values('2','tour','H','1','H','1','blanc','finale', '1')";
  static final String STMT3 = "Insert into Piece Values('3','cavalier','B','1','B','1','blanc','finale', '1')";
  static final String STMT4 = "Insert into Piece Values('4','cavalier','G','1','G','1','blanc','finale', '1')";
  static final String STMT5 = "Insert into Piece Values('5','fou','C','1','C','1','blanc','finale', '1')";
  static final String STMT6 = "Insert into Piece Values('6','fou','F','1','F','1','blanc',?,?)";
  static final String STMT7 = "Insert into Piece Values('7','reine','D','1','D','1','blanc',?,?)";
  static final String STMT8 = "Insert into Piece Values('8','roi','E','1','E','1','blanc',?,?)";
  static final String STMT9 = "Insert into Piece Values('9','pion','A','1','A','1','blanc',?,?)";
  static final String STMT10 = "Insert into Piece Values('10','pion','H','2','H','2','blanc',?,?)";
  static final String STMT11 = "Insert into Piece Values('11','pion','B','2','B','2','blanc',?,?)";
  static final String STMT12 = "Insert into Piece Values('12','pion','G','2','G','2','blanc',?,?)";
  static final String STMT13 = "Insert into Piece Values('13','pion','C','2','C','2','blanc',?,?)";
  static final String STMT14 = "Insert into Piece Values('14','pion','F','2','F','2','blanc',?,?)";
  static final String STMT15 = "Insert into Piece Values('15','pion','D','2','D','2','blanc',?,?)";
  static final String STMT16 = "Insert into Piece Values('16','pion','E','2','E','2','blanc',?,?)";
  static final String STMT17 = "Insert into Piece Values('17','tour','A','8','A','8','noir',?,?)";
  static final String STMT18 = "Insert into Piece Values('18','tour','H','8','H','8','noir',?,?)";
  static final String STMT19 = "Insert into Piece Values('19','cavalier','B','8','B','8','noir',?,?)";
  static final String STMT20 = "Insert into Piece Values('20','cavalier','G','8','G','8','noir',?,?)";
  static final String STMT21 = "Insert into Piece Values('21','fou','C','8','C','8','noir',?,?)";
  static final String STMT22 = "Insert into Piece Values('22','fou','F','8','F','8','noir',?,?)";
  static final String STMT23 = "Insert into Piece Values('23','reine','E','8','E','8','noir',?,?)";
  static final String STMT24 = "Insert into Piece Values('24','roi','D','8','D','8','noir',?,?)";
  static final String STMT25 = "Insert into Piece Values('25','pion','A','7','A','7','noir',?,?)";
  static final String STMT26 = "Insert into Piece Values('26','pion','H','7','H','7','noir',?,?)";
  static final String STMT27 = "Insert into Piece Values('27','pion','B','7','B','7','noir',?,?)";
  static final String STMT28 = "Insert into Piece Values('28','pion','G','7','G','7','noir',?,?)";
  static final String STMT29 = "Insert into Piece Values('29','pion','C','7','C','7','noir',?,?)";
  static final String STMT30 = "Insert into Piece Values('30','pion','F','7','F','7','noir',?,?)";
  static final String STMT31 = "Insert into Piece Values('31','pion','D','7','D','7','noir',?,?)";
  static final String STMT32 = "Insert into Piece Values('32','pion','E','7','E','7','noir',?,?)";


  public CreatePiece() {

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
        //Statement stmt = conn.createStatement();
        //ResultSet rset = stmt.executeQuery(STMTCreate);

        //Statement stmt1 = conn.createStatement();
        //ResultSet rset1 = stmt1.executeQuery(STMT1);
        Statement stmt = conn.createStatement();
        // ResultSet rsetDrop = stmt.executeQuery(STMTDrop);
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
        conn.commit();
        // rsetDrop.close();
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
    new CreatePiece();
  }

}
