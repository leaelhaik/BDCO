package Java.Modele;

import connection.InsertionJoueur;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by ensimag on 01/05/18.
 */
public class FabriqueJoueurConcrete extends FabriqueJoueur {

    public FabriqueJoueurConcrete() {

    }

    @java.lang.Override
    public ListeJoueurs lesJoueurs() {
        return null;
    }

    @java.lang.Override
    public void ajouterJoueur(String nom, String prenom, String adresse, Date date, InsertionJoueur nouv) {
        /*
        Ajout d'un joueur dans la BDD
        Nouvelle ligne dans la table Joueur :
        nomJoueur : nom
        prenomJoueur : prenom
        dateJoueur : date
        adresseJoueur : adresse
         */
        nouv.insereJoueur(nom, prenom, adresse, date);
    }
}
