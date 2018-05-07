package Controleur;
import Java.Modele.*;
import connection.*;
//permet de trouver dans quelle phase on est et de la renvoyer à l'IG

public class ControlleurPhase {
    String nomTour;
    int idTournoi;
    public ControlleurPhase(){

    }
    //permet d'initialiser un tour
    public void setTour(){

    }
    //TODO : corriger ce truc
    public static String getMostAdvanceTour(){
    	Connect co = new Connect();
    	connection.GetMostAdvanceTour req = new connection.GetMostAdvanceTour();
        if( req.getNomTour() != "erreur"){
        	return req.getNomTour();
        }
        return "erreur";
    }

    public static boolean nextPhase() {
        String phase = getMostAdvanceTour();
        Tour suivant;
        ListeJoueurs joueurs = new ListeJoueurs();
        switch (phase) {
            case "qualifications":
                DebutQuart dq = new DebutQuart();
                recuperer(joueurs, dq.getClassement());
                Fabrique.rencontres.reset();
                suivant = new QuartFinal(joueurs);
                break;
            case "quartFinale":
                DebutDemi dd = new DebutDemi();
                recuperer(joueurs, dd.getClassement());
                Fabrique.rencontres.reset();
                suivant = new DemiFinal(joueurs);
                break;
            case "demiFinale":
                DebutFinale df = new DebutFinale();
                recuperer(joueurs, df.getClassement());
                Fabrique.rencontres.reset();
                suivant = new FinaleFinal(joueurs);
                break;
            case "finale":
                break;
            case "erreur":
                System.err.println("Erreur au niveau du controleur de phase");
                return true;
        }
        return false;
    }

    public static void recuperer(ListeJoueurs joueurs, int[] tab_indices) {
        for (int i = 0; i < tab_indices.length; i++) {
            joueurs.ajoutJoueur(joueurs.recupJoueur(tab_indices[i]));
        }
    }
}
