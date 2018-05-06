import Controleur.C_Rencontre;
import Controleur.MasterOfBDD;
import Controleur.NouveauJoueur;
import Java.Modele.ListeJoueurs;

import java.sql.Connection;
import java.sql.Date;

/**
 * Created by ensimag on 06/05/18.
 */
public class TestControleTournoi {
    public static void main(String[] args) {
        MasterOfBDD fearme = new MasterOfBDD();
        fearme.effacerBD();
        ajouterJoueur();
        qualifications();
    }

    public static void ajouterJoueur() {
        NouveauJoueur nj;
        nj = new NouveauJoueur("De la Bruyere", "Claude", "3 rue des Gentianes, 33120 Arcachon", "19801221");
        nj.envoyerBD();
        nj = new NouveauJoueur("J", "M", "Quelquepart", "12345678");
        nj.envoyerBD();
        nj = new NouveauJoueur("Raptor", "Jesus", "Dans nos coeurs", "00000101");
        nj.envoyerBD();
        for (int i = 0; i<4; i++) {
            nj = new NouveauJoueur(""+i,""+i, ""+i, "20000101");
            nj.envoyerBD();
        }
    }

    public static void qualifications() {
        C_Rencontre.genererRencontresQualif();
    }

    public static void affiche() {
        ListeJoueurs lj = new ListeJoueurs();
        //Connect co = new Connect();
        //Connection connection = co.getConnection();
        //lj.getAllJoueurs(connection);
        System.out.println(lj.toString());
    }
}