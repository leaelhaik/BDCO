package connection.init;
import java.sql.*;
//import java.lang.Math.*;
public class InitAffectationCouleur {

  // static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  // static final String USER = "dhouibd"; // A remplacer pour votre compte
  // static final String PASSWD = "dhouibd";
  static final String STMT = "insert into AffectationCouleur values(?,?,?,?)";


  public InitAffectationCouleur(Connection conn,String couleur,int idJoueur,String nomTour,int numRenconre)
  // String nom, String prenom, String adresse, Date date)
  {
    try {
    // Enregistrement du driver Oracle
      // int i=1;
      // System.out.print("Loading Oracle driver... ");
      // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      // System.out.println("loaded");
      // // Etablissement de la connection
      // System.out.print("Connecting to the database... ");
      // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      // System.out.println("connected");
      conn.setAutoCommit(false);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      PreparedStatement sel = conn.prepareStatement(STMT);
      sel.setInt(1,idJoueur);
      sel.setString(2,couleur);
      sel.setString(3,nomTour);
      sel.setInt(4,numRenconre);
      sel.executeUpdate();
      ResultSet rset = sel.executeQuery(STMT);
      //ResultSet rset = stmt.executeQuery(STMT);
      // while(rset.next()){
      //     int j = 1;
      //     ResultSet rset2 = stmt.executeQuery(STMT);
      //     rset2.next();
      //     while(rset2.next()){
      //       String couleur1="noir";
      //       String couleur2="blanc";
      //       if(Math.random()==1){
      //         couleur1 = "blanc";
      //         couleur2="noir";
      //       }
      //
      //       PreparedStatement sel = conn.prepareStatement(STMT1);
      //       sel.setInt(1,rset.getInt(1));
      //       sel.setInt(2,i);
      //       sel.setString(3,couleur1);
      //       sel.executeUpdate();
      //
      //       sel.setInt(1,rset2.getInt(j));
      //       sel.setInt(2,i);
      //       sel.setString(3,couleur2);
      //       sel.executeUpdate();
      //       j=j+1;
      //       i=i+1;
      //     }
      //     rset2.close();
      // }
      // Execution de la requete
      conn.commit();
      rset.close();

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
      stmt.close();
      // conn.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
    }

    public static void main(String args[]) {
    //  new InitAffectationCouleur();
    }
  }
