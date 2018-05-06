package Controleur;

import Java.Modele.Fabrique;
import connection.InsertionJoueur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ensimag on 05/05/18.
 */
public class NouveauJoueur {

    String nom;
    String prenom;
    String adresse;
    String date;

    public NouveauJoueur(String nom, String prenom, String adresse, String date) {
        this.nom = nom;
        this.adresse = adresse;
        this.prenom = prenom;
        this.date = date;
    }

    public boolean envoyerBD() {
        InsertionJoueur nouv = new InsertionJoueur();
        if (nouv.verifInsertion(nom, prenom)) {
            Fabrique.joueurs.ajouterJoueur(nom, prenom, adresse, date, nouv);
            nouv.closeConnection();
            return false;
        } else {
            nouv.closeConnection();
            return true;
        }
    }
}
