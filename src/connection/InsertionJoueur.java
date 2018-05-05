package connection;
import java.sql.*;

public class InsertionJoueur {

  private static int nbJoueur=0;
  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "insert into joueur values(?,?,?,?,?)";

  public InsertionJoueur(String nom, String prenom, Date date,String adresse){
    try {
    // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");
      // Creation de la requete
      Statement stmt = conn.createStatement();
      PreparedStatement inser = conn.prepareStatement(STMT);
      nbJoueur ++;
      inser.setInt(1,nbJoueur);
      inser.setString(2,nom);
      inser.setString(3,prenom);
      inser.setDate(4,date);
      inser.setString(5,adresse);
      inser.executeUpdate();
      //commit
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);

      // Fermeture
      rset.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }

  }
