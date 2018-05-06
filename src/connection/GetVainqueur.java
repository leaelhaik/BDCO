package connection;
import java.sql.*;

public class GetVainqueur {
  private MultipleQueries queries;

  public GetVainqueur(String nomTour, int numRencontre, Connection conn) {
    ResultSet rsetCreateCouleur = queries.getResult("select prenomJoueur,nomJoueur from joueur,rencontre where joueur.idJoueur=rencontre.idJoueur,rencontre.numRencontre="+numRencontre+",rencontre.nomTour="+nomTour+"");
  }
}
