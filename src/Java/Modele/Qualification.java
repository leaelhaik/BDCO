package Java.Modele;

import connection.Connect;

import java.sql.Connection;

/**
 * Created by ensimag on 05/05/18.
 */
public class Qualification extends Tour {

    ListeJoueurs participants;

    public Qualification() {
        ListeJoueurs participants = new ListeJoueurs();
        participants.getAllJoueurs();
        System.out.println(participants.toString());
        this.participants = participants;
    }

    public void genererRencontre() {
        for (int i = 1; i < participants.getNumberJoueurs(); i++) {
            for (int j = i + 1; j < participants.getNumberJoueurs() + 1; j++) {
                if (Math.random() > 0.5) {
                    Fabrique.rencontres.nouvelleRencontre(participants.getJoueur(i), participants.getJoueur(j), "qualifications");
                } else {
                    Fabrique.rencontres.nouvelleRencontre(participants.getJoueur(j), participants.getJoueur(i), "qualifications");
                }
            }
        }
    }

    public boolean verifierNb() {
        return this.participants.getNumberJoueurs() >= 8;
    }
}
