
import Java.Modele.Fabrique;
import Java.Modele.FabriqueJoueurConcrete;
import Java.Modele.FabriqueRencontreConcrete;
import ig_tournoi.*;

public class TestIGTournoi {


	private static ExecutableTournoi exe;

	public static void main(String args[]) {
		Fabrique.joueurs = new FabriqueJoueurConcrete();
		Fabrique.rencontres = new FabriqueRencontreConcrete();
		exe = new ExecutableTournoi("Tournoi", 700, 700);

	}
}
