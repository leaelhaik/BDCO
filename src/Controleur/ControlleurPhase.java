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
    public String getMostAdvanceTour(){
    	Connect co = new Connect();
    	connection.GetMostAdvanceTour req = new connection.GetMostAdvanceTour(co.getConnection());
        if( req.getNomTour() != "erreur"){
        	return req.getNomTour();
        }
        return "erreur au niveau du contrôleur de phases";
    }

    public boolean nextPhase() {
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
        }
        return false;
    }

    public void recuperer(ListeJoueurs joueurs, int[] tab_indices) {
        for (int i = 0; i < tab_indices.length; i++) {
            joueurs.ajoutJoueur(joueurs.getJoueur(tab_indices[i]));
        }
    }
}
