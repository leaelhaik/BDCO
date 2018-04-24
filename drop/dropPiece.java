import java.sql.*;

public class CreatePiece{

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTDrop = "Drop TABLE Piece";
  static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL ,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')),PRIMARY KEY(idPiece))";

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
        conn.commit();
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
    new CreatePiece();
  }

}
