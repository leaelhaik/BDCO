package Java.Modele;

import connection.Connect;
import connection.MultipleQueries;
import connection.Queries;
import connection.init.InitAffectationCouleur;
import connection.insert.InsertPiece;
import connection.insert.InsertRencontre;

import java.sql.Connection;

/**
 * Created by ensimag on 05/05/18.
 */
public class FabriqueRencontreConcrete extends FabriqueRencontre{

    private int numRencontre;

    public FabriqueRencontreConcrete() {
        numRencontre = 1;
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
        Queries.queries.closeConnection();
        Queries.queries = new MultipleQueries();
        new InsertRencontre(tour, numRencontre);
        new InitAffectationCouleur(Queries.queries, "blanc", blanc.getId(), tour, numRencontre);
        new InitAffectationCouleur(Queries.queries, "noir", noir.getId(), tour, numRencontre);
        new InsertPiece(numRencontre, tour);

        numRencontre ++;
    }

    @Override
    public void reset() {
        numRencontre = 1;
    }
}
