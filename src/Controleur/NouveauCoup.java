package Controleur;

import java.text.ParseException;

public class NouveauCoup {




    Character newPosX; //character representant la nouvelle position X
    Character oldPosX; //character representant l'ancienne position X
    int newPosY;
    int oldPosY;
    int numRencontre;
    String nomTour;
    String couleur;


    /**
     * Permet de faire le lien entre l'interface graphique et la base de donnée
     */
    public NouveauCoup(String Pos, int numRenconre, String nomTour, String
            couleur){

        this.oldPosX = Character.toUpperCase(Pos.charAt(0));
        this.oldPosY = Character.getNumericValue(Pos.charAt(1));
        this.newPosX = Character.toUpperCase(Pos.charAt(2));
        this.newPosY = Character.getNumericValue(Pos.charAt(3));


       try {
           VerificationCoup(this.newPosY, this.oldPosY, this.newPosX, this.oldPosX, numRenconre,
           nomTour, couleur);
       } catch (ParseException e){
           e.printStackTrace();
       }

    }
}
