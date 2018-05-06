package Controleur;

import Java.Modele.Joueur;
import Java.Modele.Qualification;
import java.sql.*;
import java.util.ArrayList;

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

    public boolean genererRencontresQualif() {
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
     * @return
     */
    public List<int> getAllRencontres(int iDJoueur, int iDTournoi){
        List<int> listeRencontres = new ArrayList<>();
        Connect co = new Connect;
        connection.GetAllRencontres req = new connection.GetAllRencontres(iDJoueur, iDTournoi, co.getConnection());
        return req.listeRencontres;

    }
}
