package Controleur;

import connection.*;
import connection.drop.Drop;

/**
 * Created by ensimag on 06/05/18.
 */
public class MasterOfBDD {

    public MasterOfBDD() {

    }

    public static void supprimerBD() {
       Drop d = new Drop();
       d.dropHistorique();
       d.dropPiece();
       d.dropAffectationCouleur();
       d.dropRencontre();
       d.dropTour();
       d.dropJoueur();
       d.dropCouleur();
    }

    public static void creerBD() {
        Create d = new Create();
        d.CreateJoueur();
        d.CreateTour();
        d.CreateRencontre();
        d.CreateCouleur();
        d.CreateHistorique();
        d.CreatePiece();
        d.CreateAffectationCouleur();
    }

    public static void effacerBD() {
        Delete d = new Delete();
        d.DeleteAffectationCouleur();
        d.DeleteCouleur();
        d.DeleteHistorique();
        d.DeleteJoueur();
        d.DeletePiece();
        d.DeleteRencontre();
        d.DeleteTour();
    }

}
