
import connection.MultipleQueries;
import connection.Queries;
import Java.Modele.Fabrique;
import Java.Modele.FabriqueJoueurConcrete;
import Java.Modele.FabriqueRencontreConcrete;
import ig_tournoi.*;

public class TestIGTournoi {


	private static ExecutableTournoi exe;

	public static void main(String args[]) {
		Queries.queries= new MultipleQueries();
		Fabrique.joueurs = new FabriqueJoueurConcrete();
		Fabrique.rencontres = new FabriqueRencontreConcrete();
		exe = new ExecutableTournoi("Tournoi", 700, 700);
		//Queries.queries.closeConnection();

	}
}
