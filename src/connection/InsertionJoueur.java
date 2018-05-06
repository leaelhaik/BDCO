package connection;

import connection.verification.verificationTable.verifJoueur;

import java.sql.*;

public class InsertionJoueur {
  static final String STMT = "insert into joueur values(?,?,?,?,?)";
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=? and prenomJoueur=?";
  public int id = 0;
  private MultipleQueries queries;

  public InsertionJoueur() {
    ResultSet rsetSel = queries.getResult("select idJoueur from joueur where idJoueur=max(idJoueur)");
    try {
        id = rsetSel.getInt("idJoueur");
    } catch (SQLException e) {

    }
  }

  public boolean verifInsertion(String nomJoueur, String prenomJoueur) {
      ResultSet rset1 = queries.getResult("select idJoueur from joueur where nomJoueur= " + nomJoueur+"and prenomJoueur="+prenomJoueur+"");
      try {
          if (rset1.next()) {
              return false;
          } else {
              return true;
          }
      } catch (SQLException e){
          System.err.println("Player insertion verification failed");
          e.printStackTrace();
          return false;
      }
  }
/*
  public boolean insereJoueur(String nom, String prenom, String adresse, String date) {
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
        inser.setString(4,date);
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
            System.err.println("Player insertion failed");
            e.printStackTrace(System.err);
            return true;
      }
    }
*/

    public boolean insereJoueur(String nomJoueur, String prenomJoueur, String adresse, Date date) {
        ResultSet rsetInsert = queries.getResult("insert into joueur values("+id+","+nomJoueur+","+prenomJoueur+","+date+","+adresse+")");
        return false;
    }

}
