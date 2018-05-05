package Java.Modele;

import static javafx.application.Platform.exit;

/**
 * Created by georgeb on 4/30/18.
 * Problème : plus de 2 joueurs dans une phase.
 */
public abstract class PhaseFinale extends Tour{
    private String typeFinale;
    private ListeJoueurs listeJoueurs;


    public PhaseFinale(ListeJoueurs listeJoueurs, String typeFinale){
        listeJoueurs = new ListeJoueurs();
        setJoueurs(listeJoueurs); //on set les joueurs
        setType(typeFinale); //on définit le type de finale (c'est un string)
    }

//--------------accesseurs et mutateurs-------------------


    public ListeJoueurs getListeJoueurs(){
        return this.listeJoueurs;
    }



    private void setJoueurs(ListeJoueurs listeJoueurs){
        //on vérifie si la liste des joueurs est valide
        if(listeJoueurs.isValid()) {
            //si c'est le cas, on copie les joueurs dans la liste des joueurs
            for (int i = 0; i < listeJoueurs.getNumberJoueurs(); i++){
                this.listeJoueurs.ajoutJoueur(listeJoueurs.getJoueur(i));
            }
        }
        else{
            System.out.println("Les joueurs ne sont pas valides, fermeture du programme");
            exit();
        }
    }


    private void setType(String typeFinale){
        if (!this.typeFinale.equals("quart") && !this.typeFinale.equals("demi") && !this.typeFinale.equals("finale")){
            System.out.println("Le nom de la phase finale n'est pas valide" + this.typeFinale);
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
