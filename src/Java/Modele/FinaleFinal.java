package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class FinaleFinal extends PhaseFinale{

    public FinaleFinal(ListeJoueurs listeJoueurs){
        super("finale");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);

    }

    @Override
    public void genererRencontre() {
        Fabrique.rencontres.nouvelleRencontre(listeJoueurs.getJoueur(0), listeJoueurs.getJoueur(1), "finale");
    }
}
