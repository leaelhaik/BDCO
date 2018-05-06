package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class QuartFinal extends PhaseFinale {

    public QuartFinal(ListeJoueurs listeJoueurs){
        super("quart");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);
    }

    @Override
    public void genererRencontre() {
        for (Joueur j : listeJoueurs.getMyJoueurs()) {

        }
    }
}
