package connection;
import java.sql.*;
import connection.MultipleQueries;

public class GetIdJoueur {
  private id = -1 ;
  public GetIdJoueur(String nom, String prenom) {
    ResultSet rsetId = Queries.queries.getResult("Select idJoueur from Joueur where nomJoueur=\'"+nom+"\', prenomJoueur = \'"+prenom+"\'");
    while(rsetId.next()){
      this.id = rsetId.getInt(1);
    }
  }

  public int getId(){
    return this.id;
  }

}
