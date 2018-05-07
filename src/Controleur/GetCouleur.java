package Controleur;

import connection.Connect;
//permet d'obtenir la couleur d'un joueur en fonction de l'Id de la partie
public class GetCouleur {

    int iDJoueur;

    public GetCouleur(int iDJoueur){
        this.iDJoueur = iDJoueur;
    }

    public String getCouleur() {
    	connection.GetCouleur req = new connection.GetCouleur(this.iDJoueur);
        return req.getCouleur();
    }
}
