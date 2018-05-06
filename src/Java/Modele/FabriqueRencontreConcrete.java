package Java.Modele;

import connection.init.InitAffectationCouleur;
import connection.insert.InsertRencontre;

import java.sql.Connection;

/**
 * Created by ensimag on 05/05/18.
 */
public class FabriqueRencontreConcrete extends FabriqueRencontre{

    private int numRencontre;

    public FabriqueRencontreConcrete() {
        numRencontre = 0;
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
        Connect co = new Connect();
        Connection conn = co.getConnection();
        InsertRencontre _ = new InsertRencontre(conn, tour, numRencontre);
        InitAffectationCouleur __ = new InitAffectationCouleur(conn, "blanc", blanc.getId(), tour, numRencontre);
        InitAffectationCouleur ___ = new InitAffectationCouleur(conn, "noir", noir.getId(), tour, numRencontre);
        numRencontre ++;
    }
}
