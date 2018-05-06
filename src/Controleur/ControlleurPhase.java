package Controleur;
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
}
