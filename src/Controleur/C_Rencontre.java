package Controleur;

import Java.Modele.Joueur;
import Java.Modele.Qualification;


/**
 * Created by ensimag on 06/05/18.
 */
public class C_Rencontre {
    int id_blanc;
    int id_noir;
    String tour;

    public C_Rencontre(int idblanc, int idnoir, String tour) {
        id_blanc = idblanc;
        id_noir = idnoir;
        this.tour = tour;
    }

    public boolean genererRencontresQualif() {
        Qualification qualification = new Qualification();
        if (qualification.verifierNb()) {
            qualification.genererRencontre();
            return false;
        } else {
            System.err.println("Il faut au moins 8 joueurs pour débuter un tournoi!");
            return true;
        }
    }

    public boolean envoyerBD() {
        return true;
    }
}
