package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class QuartFinal extends PhaseFinale{
    private ListeJoueurs listeJoueurs;
    public QuartFinal(ListeJoueurs listeJoueurs){
        super("quart");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);
    }
}
