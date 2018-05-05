import java.sql.*;

public class InsertPiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTRencontre = "Select numRencontre, nomTour from Rencontre";
  static final String STMTCountNbPiece = "Select COUNT(numRencontre) from Rencontre";
  //static final String STMTCountQualif = "Select COUNT(numRencontre) from Rencontre Where nomTour='qualifications'";

  // static final String STMTDrop = "Drop TABLE Piece";
  // static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL ,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))";

  static final String STMT1 = "Insert into Piece Values(?,'tour','A','1','A','1','blanc',?, ?)";
  static final String STMT2 = "Insert into Piece Values(?,'tour','H','1','H','1','blanc',?, ?)";
  static final String STMT3 = "Insert into Piece Values(?,'cavalier','B','1','B','1','blanc',?, ?)";
  static final String STMT4 = "Insert into Piece Values(?,'cavalier','G','1','G','1','blanc',?, ?)";
  static final String STMT5 = "Insert into Piece Values(?,'fou','C','1','C','1','blanc',?, ?)";
  static final String STMT6 = "Insert into Piece Values(?,'fou','F','1','F','1','blanc',?, ?)";
  static final String STMT7 = "Insert into Piece Values(?,'roi','E','1','E','1','blanc',?, ?)";
  static final String STMT8 = "Insert into Piece Values(?,'reine','D','1','D','1','blanc',?, ?)";
  static final String STMT9 = "Insert into Piece Values(?,'pion','A','2','A','2','blanc',?, ?)";
  static final String STMT10 = "Insert into Piece Values(?,'pion','H','2','H','2','blanc',?, ?)";
  static final String STMT11 = "Insert into Piece Values(?,'pion','B','2','B','2','blanc',?, ?)";
  static final String STMT12 = "Insert into Piece Values(?,'pion','G','2','G','2','blanc',?, ?)";
  static final String STMT13 = "Insert into Piece Values(?,'pion','C','2','C','2','blanc',?, ?)";
  static final String STMT14 = "Insert into Piece Values(?,'pion','F','2','F','2','blanc',?, ?)";
  static final String STMT15 = "Insert into Piece Values(?,'pion','D','2','D','2','blanc',?, ?)";
  static final String STMT16 = "Insert into Piece Values(?,'pion','E','2','E','2','blanc',?, ?)";
  static final String STMT17 = "Insert into Piece Values(?,'tour','A','8','A','8','noir',?, ?)";
  static final String STMT18 = "Insert into Piece Values(?,'tour','H','8','H','8','noir',?, ?)";
  static final String STMT19 = "Insert into Piece Values(?,'cavalier','B','8','B','8','noir',?, ?)";
  static final String STMT20 = "Insert into Piece Values(?,'cavalier','G','8','G','8','noir',?, ?)";
  static final String STMT21 = "Insert into Piece Values(?,'fou','C','8','C','8','noir',?, ?)";
  static final String STMT22 = "Insert into Piece Values(?,'fou','F','8','F','8','noir',?, ?)";
  static final String STMT23 = "Insert into Piece Values(?,'roi','E','8','E','8','noir',?, ?)";
  static final String STMT24 = "Insert into Piece Values(?,'reine','D','8','D','8','noir',?, ?)";
  static final String STMT25 = "Insert into Piece Values(?,'pion','A','7','A','7','noir',?, ?)";
  static final String STMT26 = "Insert into Piece Values(?,'pion','H','7','H','7','noir',?, ?)";
  static final String STMT27 = "Insert into Piece Values(?,'pion','B','7','B','7','noir',?, ?)";
  static final String STMT28 = "Insert into Piece Values(?,'pion','G','7','G','7','noir',?, ?)";
  static final String STMT29 = "Insert into Piece Values(?,'pion','C','7','C','7','noir',?, ?)";
  static final String STMT30 = "Insert into Piece Values(?,'pion','F','7','F','7','noir',?, ?)";
  static final String STMT31 = "Insert into Piece Values(?,'pion','D','7','D','7','noir',?, ?)";
  static final String STMT32 = "Insert into Piece Values(?,'pion','E','7','E','7','noir',?, ?)";

  /*
  On initialise
  */

  public InsertPiece() {

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
        ResultSet rsetCountNbPiece = stmt.executeQuery(STMTCountNbPiece);
        int nbRencontres = 0;

        while(rsetCountNbPiece.next()) {
          nbRencontres= rsetCountNbPiece.getInt(1);
        }

        int nbPieces = nbRencontres * 32;
        // ResultSet rsetCountQualif = stmt.executeQuery(STMTCountQualif);
        // int nbQualifs = 0;
        //
        // while(rsetCountQualif.next()) {
        //   nbQualifs = rsetCountQualif.getInt(1);
        // }

        int numRencontre = 0;
        String nomTour = "";

        ResultSet rsetNbRencontres = stmt.executeQuery(STMTRencontre);
      //
          for(int i=1; i<=nbRencontres * 32; i+=32) {
            rsetNbRencontres.next();
            numRencontre = rsetNbRencontres.getInt(1);
            nomTour = rsetNbRencontres.getString(2);
            System.out.println("nbPieces : ");
            System.out.println(nbPieces);
            System.out.println("nbRencontre : ");
            System.out.println(nbRencontres);
            System.out.println("nomTour : ");
            System.out.println(nomTour);

            PreparedStatement statement = conn.prepareStatement(STMT1);
            System.out.println("i : " );
            System.out.println(i);
            statement.setInt(1,i);
            System.out.println("Num Rencontre : ");
            System.out.println(numRencontre);
            statement.setInt(2,numRencontre);
            System.out.println("Nom Tour : ");
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT2);
            statement.setInt(1,i+1);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT3);
            statement.setInt(1,i+2);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT4);
            statement.setInt(1,i+3);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT5);
            statement.setInt(1,i+4);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT6);
            statement.setInt(1,i+5);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT7);
            statement.setInt(1,i+6);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT8);
            statement.setInt(1,i+7);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT9);
            statement.setInt(1,i+8);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT10);
            statement.setInt(1,i+9);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT11);
            statement.setInt(1,i+10);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT12);
            statement.setInt(1,i+11);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT13);
            statement.setInt(1,i+12);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT14);
            statement.setInt(1,i+13);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT15);
            statement.setInt(1,i+14);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT16);
            statement.setInt(1,i+15);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT17);
            statement.setInt(1,i+16);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT18);
            statement.setInt(1,i+17);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT19);
            statement.setInt(1,i+18);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT20);
            statement.setInt(1,i+19);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT21);
            statement.setInt(1,i+20);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT22);
            statement.setInt(1,i+21);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT23);
            statement.setInt(1,i+22);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT24);
            statement.setInt(1,i+23);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT25);
            statement.setInt(1,i+24);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT26);
            statement.setInt(1,i+25);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT27);
            statement.setInt(1,i+26);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT28);
            statement.setInt(1,i+27);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT29);
            statement.setInt(1,i+28);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT30);
            statement.setInt(1,i+29);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT31);
            statement.setInt(1,i+30);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();

            statement = conn.prepareStatement(STMT32);
            statement.setInt(1,i+31);
            statement.setInt(2,numRencontre);
            statement.setString(3,nomTour);
            statement.executeUpdate();
            statement.close();
          }
      //  }



        // ResultSet rset1 = stmt.executeQuery(STMT1);
        // ResultSet rset2 = stmt.executeQuery(STMT2);
        // ResultSet rset3 = stmt.executeQuery(STMT3);
        // ResultSet rset4 = stmt.executeQuery(STMT4);
        // ResultSet rset5 = stmt.executeQuery(STMT5);
        // ResultSet rset6 = stmt.executeQuery(STMT6);
        // ResultSet rset7 = stmt.executeQuery(STMT7);
        // ResultSet rset8 = stmt.executeQuery(STMT8);
        // ResultSet rset9 = stmt.executeQuery(STMT9);
        // ResultSet rset10 = stmt.executeQuery(STMT10);
        // ResultSet rset11 = stmt.executeQuery(STMT11);
        // ResultSet rset12 = stmt.executeQuery(STMT12);
        // ResultSet rset13 = stmt.executeQuery(STMT13);
        // ResultSet rset14 = stmt.executeQuery(STMT14);
        // ResultSet rset15 = stmt.executeQuery(STMT15);
        // ResultSet rset16 = stmt.executeQuery(STMT16);
        // ResultSet rset17 = stmt.executeQuery(STMT17);
        // ResultSet rset18 = stmt.executeQuery(STMT18);
        // ResultSet rset19 = stmt.executeQuery(STMT19);
        // ResultSet rset20 = stmt.executeQuery(STMT20);
        // ResultSet rset21 = stmt.executeQuery(STMT21);
        // ResultSet rset22 = stmt.executeQuery(STMT22);
        // ResultSet rset23 = stmt.executeQuery(STMT23);
        // ResultSet rset24 = stmt.executeQuery(STMT24);
        // ResultSet rset25 = stmt.executeQuery(STMT25);
        // ResultSet rset26 = stmt.executeQuery(STMT26);
        // ResultSet rset27 = stmt.executeQuery(STMT27);
        // ResultSet rset28 = stmt.executeQuery(STMT28);
        // ResultSet rset29 = stmt.executeQuery(STMT29);
        // ResultSet rset30 = stmt.executeQuery(STMT30);
        // ResultSet rset31 = stmt.executeQuery(STMT31);
        // ResultSet rset32 = stmt.executeQuery(STMT32);

        // Fermeture
        conn.commit();
        rsetCountNbPiece.close();
        // rset1.close();
        // rset2.close();
        // rset3.close();
        // rset4.close();
        // rset5.close();
        // rset6.close();
        // rset7.close();
        // rset8.close();
        // rset9.close();
        // rset10.close();
        // rset11.close();
        // rset12.close();
        // rset13.close();
        // rset14.close();
        // rset15.close();
        // rset16.close();
        // rset17.close();
        // rset18.close();
        // rset19.close();
        // rset20.close();
        // rset21.close();
        // rset22.close();
        // rset23.close();
        // rset24.close();
        // rset25.close();
        // rset26.close();
        // rset27.close();
        // rset28.close();
        // rset29.close();
        // rset30.close();
        // rset31.close();
        // rset32.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public static void main(String args[]) {
    new InsertPiece();
  }

}
