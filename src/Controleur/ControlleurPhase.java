package Controleur;

//permet de trouver dans quelle phase on est et de la renvoyer à l'IG

public class ControlleurPhase {
    String nomPhase;

    public ControlleurPhase(){

    }
    //permet d'initialiser un tour
    public setTour(){

    }
    
    public String getMostAdvanceTour(){
    	Connect co = new Connect;
    	connection.GetMostAdvanceTour req = new connection.GetMostAdvanceTour(co.getConnection());
        if( req.nomTour != "erreur"){
        	return req.nomTour;
        };
    }
}
