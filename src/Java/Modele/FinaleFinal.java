package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class FinaleFinal extends PhaseFinale{
    private ListeJoueurs listeJoueurs;

    public FinaleFinal(ListeJoueurs listeJoueurs){
        super("finale");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);

    }
}
