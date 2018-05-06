package Controleur;
import Java.Modele.ListeJoueurs;
import Java.Modele.QuartFinal;
import Java.Modele.Tour;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseTraversers;
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
        ListeJoueurs joueurs;
        switch (phase) {
            case "qualification":
                DebutQuart dq = new DebutQuart();
                dq.getClassement();
                suivant = new QuartFinal();
                break;
        }
        return false;
    }
}
