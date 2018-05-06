package Controleur;

import connection.verification.verificationCoup;
import java.text.ParseException;

public class NouveauCoup {


//numRencontre est

    Character newPosX; //character representant la nouvelle position X
    Character oldPosX; //character representant l'ancienne position X
    int newPosY;
    int oldPosY;
    int numRencontre;
    String nomTour;
    String couleur;


    /**
     * Permet de faire le lien entre la BDD et l'IG
     * @param Pos coordonnes renvoyées par l'IG sous la forme "H6B6"
     * @param numRencontre numéro de la rencontre
     * @param nomTour le nom du tour
     * @param couleur la couleur du coup
     */
    public NouveauCoup(String Pos, int numRencontre, String nomTour, String
            couleur){

        this.oldPosX = Character.toUpperCase(Pos.charAt(0));
        this.oldPosY = Character.getNumericValue(Pos.charAt(1));
        this.newPosX = Character.toUpperCase(Pos.charAt(2));
        this.newPosY = Character.getNumericValue(Pos.charAt(3));
        this.numRencontre = numRencontre;
        this.nomTour = nomTour;
        this.couleur = couleur;

    }
//TODO : attendre que verificationCoup soit modifié pour pouvoir le finir
    public boolean envoyerBD(){
        verificationCoup verifCoup = new verificationCoup();

    }
}
