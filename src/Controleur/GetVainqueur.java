package Controleur;

import connection.Connect;
//permet d'obtenir la couleur d'un joueur en fonction de l'Id de la partie
public class GetVainqueur {

    String nomTour;
    int numRencontre;

    public GetVainqueur(int numRencontre, String nomTour){
        this.numRencontre = numRencontre;
        this.nomTour = nomTour;
    }

    public String getNomVainqueur() {
    	connection.GetVainqueur req = new connection.GetVainqueur(this.nomTour, this.numRencontre);
        return req.getNom();
    }
    
    public String getPrenomVainqueur() {
    	connection.GetVainqueur req = new connection.GetVainqueur(this.nomTour, this.numRencontre);
        return req.getPrenom();
    }
}
