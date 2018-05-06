package connection;
import java.sql.*;

public class Abandon {

	static final String STMT0 = "select posX,posY from Historique where idCoup=max(idCoup),nomTour=?,numRencontre=?";
	static final String STMT3 = "select couleur from piece where numRencontre=?,nomTour=?,posX=?,posY=?";
	static final String STMT = "select idJoueur from affectationCouleur where numRencontre=?,nomTour=?,idJoueur<>?";
	static final String STMT2 = "update Rencontre set idJoueur=? where numRencontre=?,nomTour=?";


	public Abandon(String nomTour, int numRencontre, int idJoueur) {
		try {

			// Execution de la requete
			ResultSet rset = Queries.queries.getResult("select idJoueur from affectationCouleur where numRencontre=" + numRencontre + ",nomTour= \' " +nomTour + "\',idJoueur<>" + idJoueur+"");
			int n = rset.getInt(1);

			Queries.queries.getResult("update Rencontre set idJoueur="+idJoueur+" where numRencontre="+numRencontre+",nomTour=\'"+nomTour+"\'");

			// Affichage du resultat

			// Fermeture
			rset.close();
		} catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
	}

}
