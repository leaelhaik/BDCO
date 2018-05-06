package Java.Modele;
import Java.Modele.Joueur;

import java.util.*;
/**
 * Created by georgeb on 4/30/18.
 */
public class ListeJoueurs {
    private ArrayList<Joueur> myJoueurs;
    private int nbJoueurs;

    public ListeJoueurs(){
        this.myJoueurs = new ArrayList<Joueur>();
        this.nbJoueurs = 0;
    }

//----------------Accesseurs et Mutateurs----------------------

    /**
     * Getteur servant à obtenir un joueur correspondant à l'Id i
     * @param Id : Id unique du joueur
     * @return le joueur ayant l'IdUnique i dans le tableau de liste des joueurs
     */
    public Joueur getJoueur(int Id){
        for(int i = 0; i < this.nbJoueurs; i++){
            if (this.myJoueurs.get(i).getId() == Id){
                return this.myJoueurs.get(i);
            }
        }
        System.out.println("Aucune idée ne correspondant à ce joueur dans la listeDeJoueurs : " + Id);
        return null;
    }

    /**
     * Methode servant à supprimer un joueur. Normalement, on en a pas besoin
     * @param i : l'indice du joueur à supprimer
     */
    public void removeJoueur(int i){
        if(this.nbJoueurs > 0){
            this.myJoueurs.remove(i);
            this.nbJoueurs--;
        }
        else{
            throw new IllegalArgumentException("Il n'y a plus de joueurs");
        }
    }
    //pour ajouter un joueur dans la liste

    /**
     *Methode servant à ajouter un joueur
     * @param j le joueur à ajouter
     */
    public void ajoutJoueur(Joueur j){
        this.myJoueurs.add(j);
        this.nbJoueurs++;
    }
    /*
    //TODO : A FINIR
    public void setNewJoueur(String A_COMPLETER_QUAND_JOUEUR_IMPLEMENTER){
        this.myJoueurs.add(new Joueur(A_COMPLETER_QUAND_JOUEUR_IMPLEMENTER));
        this.nbJoueurs++;
    }*/

    public int getNumberJoueurs() { return this.nbJoueurs;}

    public boolean isValid(){
        for(int i = 0; i < nbJoueurs; i++){
            if (!this.getJoueur(i).isValid()){
                return false;
            }
        }
        return true;
    }

}