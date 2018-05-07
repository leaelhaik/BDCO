package Controleur;

import java.util.ArrayList;

import connection.Connect;
public class GetAllRencontres {

    String nomTour;
    int idJoueur;

    public  GetAllRencontres(int idJoueur, String nomTour){
        this.idJoueur = idJoueur;
        this.nomTour = nomTour;
    }

    public ArrayList<Integer> getAllRencontres() {
    	connection.GetAllRencontres req = new connection.GetAllRencontres(this.idJoueur, this.nomTour);
        return req.getListeRencontres();
    }
}
