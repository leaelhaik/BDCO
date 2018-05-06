package Controleur;
import java.sql.*;
import java.io.*;

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
    Connection conn;

    /**
     * Permet de faire le lien entre la BDD et l'IG
     * @param Pos coordonnes renvoyées par l'IG sous la forme "H6B6"
     * @param numRencontre numéro de la rencontre
     * @param nomTour le nom du tour
     * @param couleur la couleur du coup
     */

//TODO: attendre que numRencontre soir implementé pour pouvoir finir tout ça

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

    /**
     * envoie à la BD le nouveau coup
     * @return true si ça a marché, false sinon
     */
    public boolean envoyerBD(){
        try{
            Connect co = new Connect();
            this.conn = co.getConnection();
            verificationCoup verifCoup = new verificationCoup(this.newPosY, this.oldPosY, this.newPosX, this.oldPosX,
                    this.numRencontre, this.nomTour, this.couleur, this.conn);
        } catch(SQLException e){
            System.err.println("failed");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        String s = this.oldPosX + this.oldPosY + this.newPosX + this.newPosY + this.numRencontre + this.nomTour +
                this.couleur;
        return s;
    }

}
