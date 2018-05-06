package Controleur;
import connection.*;
//permet de trouver dans quelle phase on est et de la renvoyer à l'IG

public class ControlleurPhase {
    String nomTour;

    public ControlleurPhase(){

    }
    //permet d'initialiser un tour
    public void setTour(){

    }
    
    public String getMostAdvanceTour(){
    	Connect co = new Connect();
    	connection.GetMostAdvanceTour req = new connection.GetMostAdvanceTour(co.getConnection());
        if( req.nomTour != "erreur"){
        	return req.nomTour;
        };
    }
}
