package connection;
import java.sql.*;

public class GetVainqueur {

  private String prenom ="";
  private String nom="";

  public GetVainqueur(String nomTour, int numRencontre) {
    ResultSet rsetCreateCouleur = Queries.queries.getResult("select prenomJoueur,nomJoueur, idJoueur from joueur,rencontre where joueur.idJoueur=rencontre.idJoueur,rencontre.numRencontre=" + numRencontre + ",rencontre.nomTour=" + nomTour + "");
    try {
      while (rsetCreateCouleur.next()) {
        this.prenom = rsetCreateCouleur.getString("prenomJoueur");
        this.nom = rsetCreateCouleur.getString("nomJoueur");
      }
    } catch (SQLException e) {
      System.err.println("failed au niveau de GetVainqueur");
      e.printStackTrace(System.err);
    }
  }

  public String getNom(){
    return this.nom;
  }

  public String getPrenom(){
    return this.prenom;
  }
}
