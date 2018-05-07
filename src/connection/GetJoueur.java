package connection;
import java.sql.*;

//permet d'obtenir un joueur en connaissant
//sa couleur
// le numRencontre
// le nom du tour

public class GetJoueur {
	public GetJoueur(String nomTour, int numRencontre, String couleur, Connection conn) {
		try {

			ResultSet rset = Queries.queries.getResult("select prenomJoueur,nomJoueur from joueur,affectationCouleur where joueur.idJoueur=affectationCouleur.idJoueur, affectationCouleur.nomCouleur=\'"+couleur+"\',affectationCouleur.numRencontre="+numRencontre+",affectationCouleur.nomTour=\'"+nomTour + "\'");

			// Fermeture
			rset.close();
		} catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
	}

}
