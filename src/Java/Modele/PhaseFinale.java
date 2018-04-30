package Java.Modele;

import Java.Controleur.Joueur;

import static javafx.application.Platform.exit;

/**
 * Created by georgeb on 4/30/18.
 */
public abstract class PhaseFinale {
    private String typeFinale;
    private Joueur j1;
    private Joueur j2;

    public PhaseFinale(Joueur joueur1, Joueur joueur2 , String typeFinale){
        Joueur j1 = new JoueurConcret("");
        Joueur j2 = new JoueurConcret("");
        setJoueurs(joueur1, joueur2);
        setType(typeFinale);
    }

    //accesseurs et mutateurs
    public Joueur getJoueur1(){
        return this.j1;
    }

    public Joueur getJoueur2(){
        return this.j2;
    }

    private void setJoueurs(Joueur j1, Joueur j2){
        if(j1.isValid() && j2.isValid()) {
            this.j1 = j1;
            this.j2 = j2;
        }
        else{
            System.out.println("Les joueurs ne sont pas valides, fermeture du programme");
            exit();
        }
    }

    private void setType(String typeFinale){
        if (!this.typeFinale.equals("quart") && !this.typeFinale.equals("demi") && !this.typeFinale.equals("finale")){
            System.out.println("Le nom de la phase finale n'est pas valide");
            exit();
        }
        else {
            this.typeFinale = typeFinale;
        }
    }

    public String getType(){
        return this.typeFinale;
    }
}
