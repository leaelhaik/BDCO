package Controleur;

import connection.Connect;
public class GetIdJoueur {

    String nom;
    String prenom;

    public GetIdJoueur(String prenom, String nom){
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getIdJoueur() {
    	connection.GetIdJoueur req = new connection.GetIdJoueur(this.nom, this.prenom);
        return req.getId();
    }
}
