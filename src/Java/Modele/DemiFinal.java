package Java.Modele;

import Java.Modele.Joueur;

/**
 * Created by georgeb on 4/23/18.
 */
public class DemiFinal extends PhaseFinale{
    private ListeJoueurs listeJoueurs;

    public DemiFinal(ListeJoueurs listeJoueurs){
        super("demi");
        this.listeJoueurs = new ListeJoueurs();
        super.setJoueurs(listeJoueurs);
    }
}
