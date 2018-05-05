package Java.Modele;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by ensimag on 01/05/18.
 */
public class FabriqueJoueurConcrete extends FabriqueJoueur {

    @java.lang.Override
    public ListeJoueurs lesJoueurs() {
        return null;
    }

    @java.lang.Override
    public void ajouterJoueur(String nom, String prenom, String adresse, Date date) {
        /*
        Ajout d'un joueur dans la BDD
        Nouvelle ligne dans la table Joueur :
        nomJoueur : nom
        prenomJoueur : prenom
        dateJoueur : date
        adresseJoueur : adresse
         */
    }
}
