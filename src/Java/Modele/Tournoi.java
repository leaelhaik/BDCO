package Java.Modele;

import java.util.ArrayList;

/**
 * Created by benoitg on 05/05/18.
 */
public class Tournoi{
    private int nbJoueurs;
    private ListeJoueurs nomJoueurs;
    private ArrayList<Rencontre> rencontres;

    public Tournoi(){
        ListeJoueurs nomJoueurs = new ListeJoueurs();
        ArrayList<Rencontre> rencontres = new ArrayList<Rencontre>();
    }

    
}
