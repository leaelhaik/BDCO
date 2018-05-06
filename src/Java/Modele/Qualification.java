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
        Connect co = new Connect();
        Connection conn = co.getConnection();
        participants.getAllJoueurs(conn);
        this.participants = participants;
    }

    public void genererRencontre() {
        for (int i =0; i < participants.getNumberJoueurs() - 1; i++) {
            for (int j = i + 1; j < participants.getNumberJoueurs(); j++) {
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
