import Controleur.*;
import Java.Modele.Fabrique;
import Java.Modele.FabriqueJoueurConcrete;
import Java.Modele.FabriqueRencontreConcrete;
import connection.GetRandomId;
import connection.MultipleQueries;
import connection.Queries;
import connection.insert.InsertionJoueur;

public class TestGetCouleur {



	public static void main(String args[]){
		Fabrique.joueurs = new FabriqueJoueurConcrete();
		Fabrique.rencontres = new FabriqueRencontreConcrete();
		Queries.queries = new MultipleQueries();

		if (ajouterJoueur()) {

		} else {
			GetRandomId randomId = new GetRandomId();
			GetCouleur guetteurEnBasDesBlocs = new GetCouleur(randomId.iD);
			System.out.println(guetteurEnBasDesBlocs.getCouleur());
		}
		Queries.queries.closeConnection();

	}

	public static boolean ajouterJoueur(){
		NouveauJoueur nj;
		nj = new NouveauJoueur("Fbejfe", "Bjbj", "5 fhufe", "1980-10-24");
		if(nj.envoyerBD()){
			System.err.println("Annulation de l'insertion...");
			return true;
		}
		return false;
	}
}
