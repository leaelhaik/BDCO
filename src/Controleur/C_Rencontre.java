package Controleur;

import Java.Modele.Joueur;

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

    public boolean envoyerBD() {
        return true;
    }
}
