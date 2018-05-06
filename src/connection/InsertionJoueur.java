package connection;
import java.sql.*;

public class InsertionJoueur {

  private static int nbJoueur=0;
  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";
  static final String STMT = "insert into joueur values(?,?,?,?,?)";
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=?, prenomJoueur=? ";
  Connection conn;

  public InsertionJoueur() {
      try {
          // Enregistrement du driver Oracle
          System.out.print("Loading Oracle driver... ");
          DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          System.out.println("loaded");
          // Etablissement de la connection
          System.out.print("Connecting to the database... ");
          conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
          System.out.println("connected");
      } catch (SQLException e) {
          System.err.println("Connection failed");
          e.printStackTrace();
      }
  }

  public boolean verifInsertion(String nom, String prenom) {
      try {
          // Création de la requête
          PreparedStatement verif = conn.prepareStatement(STMTVerif);
          verif.setString(1, nom);
          verif.setSTMT(2, prenom);
          verif.executeUpdate();

          ResultSet rset2 = verif.executeQuery(STMTVerif);
          rset2.close();
          verif.close();
      } catch (SQLException e) {
          System.err.println("Player insertion verification failed");
          e.printStackTrace(System.err);
          return false;
      }
      return true;
  }

  public boolean insereJoueur(String nom, String prenom, String adresse, Date date) {
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
        ResultSet rset = inser.executeQuery(STMT);

        // Fermeture
        rset.close();
        inser.close();
        return false;
        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
            return true;
      }
    }

    public void closeConnection() {
      try {
          // Fermeture
          conn.close();
      } catch (SQLException e) {
          System.err.println("Connection closing failed");
          e.printStackTrace();
      }
    }
  }
