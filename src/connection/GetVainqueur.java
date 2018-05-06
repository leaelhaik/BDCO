package connection;
import java.sql.*;
import connection.MultipleQueries;

public class GetVainqueur {
  private MultipleQueries queries;
  private String prenom ="";
  private String nom="";

  public GetVainqueur(String nomTour, int numRencontre) {
    ResultSet rsetCreateCouleur = Queries.queries.getResult("select prenomJoueur,nomJoueur from joueur,rencontre where joueur.idJoueur=rencontre.idJoueur,rencontre.numRencontre="+numRencontre+",rencontre.nomTour="+nomTour+"");
    while(rsetCreateCouleur.next()){
      this.prenom=rsetCreateCouleur.getString("prenomJoueur");
      this.nom = rsetCreateCouleur.getString("nomJoueur");
    }
  }

  public String getNom(){
    return this.nom;
  }

  public String getPrenom(){
    return this.prenom;
  }
}
