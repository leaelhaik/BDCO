package connection;
import java.sql.*;

public class GetVainqueur {

  public GetVainqueur(String nomTour, int numRencontre, Connection conn) {
    Queries.queries.getResult("select prenomJoueur,nomJoueur from joueur,rencontre where joueur.idJoueur=rencontre.idJoueur,rencontre.numRencontre="+numRencontre+",rencontre.nomTour="+nomTour+"");
  }
}
