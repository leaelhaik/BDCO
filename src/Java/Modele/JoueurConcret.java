package Java.Modele;

import Java.Modele.Joueur;

import java.sql.Date;

/**
 * Created by barred on 4/30/18.
 */
class JoueurConcret extends Joueur {
    JoueurConcret(String name) {
        super(name);
    }

    public JoueurConcret(String nom, String prenom, int id, String date, String adresse) {
        super(nom, prenom, id, date, adresse);
    }
}
