package Java.Modele;
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
    public Joueur getJoueur(int i){
        if (i<0 || i >= this.nbJoueurs){
            throw new IllegalArgumentException("Indice incorrect : nombre de joueurs = " + this.getNumberJoueurs() + "   indice i = " + i);
        }
        return this.myJoueurs.get(i);
    }

    public void removeJoueur(int i){
        if(this.nbJoueurs > 0){
            this.myJoueurs.remove(i);
            this.nbJoueurs--;
        }
        else{
            throw new IllegalArgumentException("Il n'y a plus de joueurs");
        }
    }
    /*
    //TODO : A FINIR
    public void setNewJoueur(String A_COMPLETER_QUAND_JOUEUR_IMPLEMENTER){
        this.myJoueurs.add(new Joueur(A_COMPLETER_QUAND_JOUEUR_IMPLEMENTER));
        this.nbJoueurs++;
    }*/

    public int getNumberJoueurs() { return this.nbJoueurs;}


}
