package Controleur;

import Java.Modele.Joueur;
import Java.Modele.Qualification;
import java.sql.*;
import java.util.ArrayList;
import connection.Connect;

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

    public static boolean genererRencontresQualif() {
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

    /**
     * Permet de renvoyer toutes les rencontres effectuées par un jour dans le tournoi en cours
     * @param iDJoueur
     * @return une ArrayList d'Integers (et non pas d'int) contenant la liste des rencontres
     */
    public ArrayList<Integer> getAllRencontres(int iDJoueur, String nomTour){
        ArrayList<Integer> listeRencontres = new ArrayList<Integer>();
        connection.GetAllRencontres req = new connection.GetAllRencontres(iDJoueur, nomTour);
        return req.getListeRencontres();

    }
}
