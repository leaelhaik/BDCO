package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class DemiFinal extends PhaseFinale{

    public DemiFinal(ListeJoueurs listeJoueurs){
        super("demi");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);
    }

    @Override
    public void genererRencontre() {
        for (int i = 0; i < 2; i+=2) {
            Fabrique.rencontres.nouvelleRencontre(listeJoueurs.getJoueur(i), listeJoueurs.getJoueur(i+1), "demiFinale");
        }
    }
}
