package Controleur;

import connection.Connect;
public class DeleteAll {


    public void deleteAll() {
    	connection.Delete req = new connection.Delete();
        req.DeleteAffectationCouleur();
        req.DeleteCouleur();
        req.DeleteHistorique();
        req.DeleteJoueur();
        req.DeletePiece();
        req.DeleteRencontre();
        req.DeleteTour();
    }
}
