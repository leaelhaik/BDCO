package Controleur;


//permet d'obtenir la couleur d'un joueur en fonction de l'Id de la partie
public class GetCouleur {

    String couleur;
    int numRencontre
    int iDJoueur;

    public GetCouleur(int iDJoueur, int numRencontre){
        this.numRencontre = numRencontre;
        this.iDJoueur = iDJoueur;
    }

    public String getCouleur() {
        return couleur;
    }
}
