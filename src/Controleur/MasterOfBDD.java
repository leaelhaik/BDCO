package Controleur;

import connection.delete.*;
import connection.create.*;
import connection.drop.*;

/**
 * Created by ensimag on 06/05/18.
 */
public class MasterOfBDD {

    public MasterOfBDD() {

    }

    public static void supprimerBD() {
        new DropHistorique();
        new DropPiece();
        new DropAffectationCouleur();
        new DropRencontre();
        new DropTour();
        new DropJoueur();
        new DropCouleur();
    }

    public static void creerBD() {
        new CreateJoueur();
        new CreateTour();
        new CreateRencontre();
        new CreateCouleur();
        new CreateHistorique();
        new CreatePiece();
        new CreateAffectationCouleur();
    }

    public static void effacerBD() {
        new DeleteAffectationCouleur();
        new DeleteCouleur();
        new DeleteHistorique();
        new DeleteJoueur();
        new DeletePiece();
        new DeleteRencontre();
        new DeleteTour();
    }

}
