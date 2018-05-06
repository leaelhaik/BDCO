package connection.insert;
import java.sql.*;

public class InsertRencontre {

  static final String STMT = "Insert into Rencontre(numRencontre, nomTour, idJoueur) Values(?, ?, ?)";

  // static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  // static final String USER = "dhouibd"; // A remplacer pour votre compte
  // static final String PASSWD = "dhouibd";
  //static final String STMTCount = "Select COUNT(idJoueur) from Joueur";

  public InsertRencontre(Connection conn,String nomTour,int numRenconre)
  // String nom, String prenom, String adresse, Date date)
  {
    try {
    // Enregistrement du driver Oracle
      // System.out.print("Loading Oracle driver... ");
      // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      // System.out.println("loaded");
      // // Etablissement de la connection
      // System.out.print("Connecting to the database... ");
      // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      // System.out.println("connected");
      //conn.setAutoCommit(false);
      // Creation de la requete
      //Statement stmt = conn.createStatement();
      //ResultSet rset = stmt.executeQuery(STMTCount);
      // Execution de la requete

      //int nbJoueurs = 0;

      // while(rset.next()) {
      //    nbJoueurs = rset.getInt(1);
      // }

      //System.out.println(nbJoueurs);
      //System.out.println(factorielle());

      // int i=1;
      // if(nbJoueurs<8) {
      //   System.out.println("Impossible de commencer le tournoi, il faut 8 joueurs.");
      // }
      // else {
      //   for(i=1; i<=somme(nbJoueurs)-1; i++) {
      PreparedStatement statement = conn.prepareStatement(STMT);
      statement.setInt(1,numRenconre);
      statement.setString(2,nomTour);
      statement.setNull(3, 0);
      statement.executeUpdate();
      ResultSet rset = statement.executeQuery(STMT);
      statement.close();
      //System.out.println(i);
      //   }
      // }



      conn.commit();
      rset.close();
      statement.close();
      //stmt.close();
      //conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }

    // private int somme(int n) {
    //   int S=1;
    //   for(int i=1;i<=n;i++){
    //     S=S+i;
    //   }
    //   return S;
    // }
/*
    public static void main(String args[]) {
      new InsertRencontre(conn,"qualifications",1);
    }*/
  }