package connection.init;
import java.sql.*;
import java.lang.Math.*;
public class CreateAffectationCouleur {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "select idJoueur from Joueur";
  String STMT1 = "insert into AffectationCouleur values(?,'qualifications',?,?)";


  public InitAffectationCouleur()
  // String nom, String prenom, String adresse, Date date)
  {
    try {
    // Enregistrement du driver Oracle
      int i=1;
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
      ResultSet rset = stmt.executeQuery(STMT);
      While(rset.next()){
          int j = 1;
          ResultSet rset2 = rset.next();
          while(rset2.next()){
            if(Math.rand()){
              couleur1 = "blanc";
              couleur2="noir";
            }
            else{
              couleur1="noir";
              couleur2="blanc";
            }

            PreparedStatement sel = conn.prepareStatement(STMT1);
            sel.setInt(1,rset.getInt(1));
            sel.setInt(2,i);
            sel.setString(3,couleur1);
            sel.executeUpdate();

            sel.setInt(1,rset2.getInt(j));
            sel.setInt(2,i);
            sel.setString(3,couleur2);
            sel.executeUpdate();
            j=j+1;
            i=i+1;
          }
      }
      // Execution de la requete
      conn.commit();
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
      new InitAffectationCouleur();
    }
  }
