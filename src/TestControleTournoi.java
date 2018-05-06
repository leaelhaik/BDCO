import Controleur.C_Rencontre;
import Controleur.MasterOfBDD;
import Controleur.NouveauJoueur;
import Java.Modele.Fabrique;
import Java.Modele.FabriqueJoueurConcrete;
import Java.Modele.FabriqueRencontreConcrete;
import Java.Modele.ListeJoueurs;
import connection.Connect;

import java.sql.Connection;
import java.sql.Date;

/**
 * Created by ensimag on 06/05/18.
 */
public class TestControleTournoi {
    public static void main(String[] args) {
        MasterOfBDD fearme = new MasterOfBDD();
        Fabrique.joueurs = new FabriqueJoueurConcrete();
        Fabrique.rencontres = new FabriqueRencontreConcrete();
        //fearme.supprimerBD();
        //fearme.creerBD();
        fearme.effacerBD();
        if (ajouterJoueur()) {

        } else {
            qualifications();
        }
    }

    public static boolean ajouterJoueur() {
        NouveauJoueur nj;
        nj = new NouveauJoueur("De la Bruyere", "Claude", "3 rue des Gentianes, 33120", "1980-12-21");
        if (nj.envoyerBD()) {
            System.err.println("Annulation de l'insertion...");
            return true;
        }
        nj = new NouveauJoueur("J", "M", "Quelquepart", "1234-10-10");
        if (nj.envoyerBD()) {
            System.err.println("Annulation de l'insertion...");
            return true;
        }
        nj = new NouveauJoueur("Raptor", "Jesus", "Dans nos coeurs", "0000-01-01");
        if (nj.envoyerBD()) {
            System.err.println("Annulation de l'insertion...");
            return true;
        }
        for (int i = 0; i<4; i++) {
            nj = new NouveauJoueur(""+i,""+i, ""+i, "2000-01-01");
            if (nj.envoyerBD()) {
                System.err.println("Annulation de l'insertion...");
                return true;
            }
        }
        return false;
    }

    public static void qualifications() {
        C_Rencontre.genererRencontresQualif();
    }

    public static void affiche() {
        ListeJoueurs lj = new ListeJoueurs();
        Connect co = new Connect();
        Connection connection = co.getConnection();
        lj.getAllJoueurs(connection);
        System.out.println(lj.toString());
    }
}