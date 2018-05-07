package connection;
import java.sql.*;

import connection.MultipleQueries;

public class GetIdJoueur {

  private int id = -1 ;

  public GetIdJoueur(String nom, String prenom) {
    ResultSet rsetId = Queries.queries.getResult("Select idJoueur from Joueur where nomJoueur=\'"+nom+"\', prenomJoueur = \'"+prenom+"\'");
    try {
      while (rsetId.next()) {
        this.id = rsetId.getInt(1);
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public int getId(){
    return this.id;
  }

}
