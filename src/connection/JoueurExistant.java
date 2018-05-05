package connection;
import java.sql.*;
import java.util.Date;

public class JoueurExistant {

  private boolean valid = true ;
  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=?, prenomJoueur=? ";

  public JoueurExistant(String nom, String prenom){
    try {
    // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      Statement stmt = conn.createStatement();

      PreparedStatement verif = conn.prepareStatement(STMTVerif);
      verif.setString(1,nom);
      verif.setString(2,prenom);
      verif.executeUpdate();

      ResultSet rset = stmt.executeQuery(STMTVerif);
      rset.last();
      if(rset.getRow()!=0){
          valid = false ;
      }
      // Fermeture
      rset.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }
    public static void main(String args[]) {
      Date date=new Date(1996,2,18);
      new InsertionJoueur("Donia","Dhouib",date,"Chez Toto");
      JoueurExistant a = new JoueurExistant("Dhouib","Donia");
      System.out.println(a.valid);
    }
  }
