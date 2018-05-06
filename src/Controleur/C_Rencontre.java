package Controleur;

import Java.Modele.Joueur;
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

    public void genererRencontresQualif() {

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
