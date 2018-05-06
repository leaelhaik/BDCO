//package connection.create;
import java.sql.*;

public class CreatePiece {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

  static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
   posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5)
   check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)),   constraint mouvment CHECK(if(typePiece='roi')then check(((oldY<>posY)or(posX<>oldX)) and(posY between oldY-2 and oldY+2)and (ascii(posX) between ascii(oldX)-2 and ascii(oldX)+2))
                                else if(typePiece='reine')then check((oldY<>posY or oldX<>posX) and(((ascii(posX)-ascii(oldX))=(posY-oldY))or((ascii(posX)-ascii(oldX))=(oldY-posY))))
                                else if(typePiece='tour') then check(((oldX=posX)<>(oldY=posY)))
                                else if(typePiece='fou') then check((((ascii(posX)-ascii(oldX))=(posY-oldY))or((ascii(posX)-ascii(oldX))=(oldY-posY))or(oldX=posX)<>(oldY=posY)) and (oldY<>posY or oldX<>posX))
                                else if(typePiece='cavalier') then check((posX<>oldX)and (oldY<>posY)and((ascii(posX)=ascii(oldX)+1 and posY=oldY+2)or(ascii(posX)=ascii(oldX)-1 and posY=oldY+2)or(ascii(posX)=ascii(oldX)+2 and posY=oldY+1)or(ascii(posX)=ascii(oldX)-2 and posY=oldY+1)))
                                else check(((ascii(posX)=ascii(oldX)or(ascii(posX)=ascii(oldX)-1)or(ascii(posX)=ascii(oldX)+1))))) ";


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
        Statement stmt = conn.createStatement();
        ResultSet rsetCreate = stmt.executeQuery(STMTCreate);

        // Fermeture
        conn.commit();
        rsetCreate.close();
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
