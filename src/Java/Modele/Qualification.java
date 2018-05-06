package Java.Modele;

/**
 * Created by ensimag on 05/05/18.
 */
public class Qualification extends Tour{

    public void genererRencontre() {
        ListeJoueurs participants = getJoueurs();
        for (int i =0; i < participants.getNumberJoueurs() - 1; i++) {
            for (int j = i + 1; j < participants.getNumberJoueurs(); j++) {
                if (Math.random() > 0.5) {
                    Fabrique.rencontres.nouvelleRencontre(participants.getJoueur(i), participants.getJoueur(j), "qualification");
                } else {
                    Fabrique.rencontres.nouvelleRencontre(participants.getJoueur(j), participants.getJoueur(i), "qualification");
                }
            }
        }
    }

    public ListeJoueurs getJoueurs() {
        ListeJoueurs participants = new ListeJoueurs();
        participants.getAllJoueurs();
        return participants;
    }
}
