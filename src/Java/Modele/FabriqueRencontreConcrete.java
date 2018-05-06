package Java.Modele;

import connection.init.InitAffectationCouleur;
import connection.insert.InsertRencontre;

/**
 * Created by ensimag on 05/05/18.
 */
public class FabriqueRencontreConcrete extends FabriqueRencontre{

    public FabriqueRencontreConcrete() {

    }

    @Override
    public ListeRencontre lesRencontres() {
        String STMT = "select * from rencontres";
        return null;
    }

    @Override
    public void nouvelleRencontre(Joueur blanc, Joueur noir, String tour) {
        /*
        Cette fonction créé et envoie la requête qui permet d'ajouter une nouvelle rencontre dans la BD.
        id = dernière id utilisée dans la table Rencontre + 1
        Ajout d'une ligne dans rencontre :
        numRencontre : id
        idJoueur : null
        nomTour : tour

        Ajout de deux lignes dans AffectationCouleur
        idJoueur : blanc.id | noir.id
        nomTour :  tour     | tour
        numRencontre : id   | id
        nomCouleur : blanc  | noir
         */
        InsertRencontre _ = new InsertRencontre();
        InitAffectationCouleur __ = new InitAffectationCouleur();
    }
}
