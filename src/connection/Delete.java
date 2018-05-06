package connection;

import java.sql.ResultSet;

public class Delete {

	  public void DeleteAffectationCouleur() {
		    Queries.queries.getResult("Delete from AffectationCouleur");
		  }
	  
	  public void DeleteCouleur() {
		    Queries.queries.getResult("Delete from Couleur");
		  }

	  public void DeleteHistorique() {
		    Queries.queries.getResult("Delete from Historique");
		  }
	  
	  public void DeleteJoueur() {
		    Queries.queries.getResult("Delete from Joueur");
		  }
	  
	  public void DeletePiece() {
		    Queries.queries.getResult("Delete from Piece");
		  }
	  
	  public void DeleteRencontre() {
		    Queries.queries.getResult("Delete from Rencontre");
		  }
	  
	  public void  DeleteTour() {
	   Queries.queries.getResult("Delete from Tour");
	  }
}
