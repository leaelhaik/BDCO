package Controleur;


//permet d'obtenir la couleur d'un joueur en fonction de l'Id de la partie
public class GetCouleur {

    int iDJoueur;

    public GetCouleur(int iDJoueur){
        this.iDJoueur = iDJoueur;
    }

    public String getCouleur() {
    	Connect co = new Connect;
    	connection.GetCouleur req = new connection.GetCouleur(this.iDJoueur,co.getConnection());
        return req.couleur;
    }
}
