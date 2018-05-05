package Java.Modele;

import Java.Modele.Joueur;


/**
 * Created by georgeb on 4/30/18.
 * Problème : plus de 2 joueurs dans une phase.
 */
public abstract class PhaseFinale extends Tour{
    private String typeFinale;
    private ListeJoueurs listeJoueurs;


    public PhaseFinale(String typeFinale){
//        ListeJoueurs this.listeJoueurs = new ListeJoueurs();
//        setJoueurs(listeJoueurs); //on set les joueurs
        setType(typeFinale); //on définit le type de finale (c'est un string)
    }

//--------------accesseurs et mutateurs-------------------


    public ListeJoueurs getListeJoueurs(){
        return this.listeJoueurs;
    }



    protected void setJoueurs(ListeJoueurs listeJoueurs){
        //on vérifie si la liste des joueurs est valide
        if(listeJoueurs.isValid()) {
            //si c'est le cas, on vérifie qu'on a bien le bon nombre de joueurs par phase

            if((this.getType().equals("quart") && this.listeJoueurs.getNumberJoueurs() == 8) || (this.getType()
                    .equals("demi") && this.listeJoueurs.getNumberJoueurs() == 4) || (this.getType().equals("finale")
                    && this.listeJoueurs.getNumberJoueurs() == 2)){
                //si c'est le cas, on copie les joueurs dans la liste
                for (int i = 0; i < listeJoueurs.getNumberJoueurs(); i++){
                    this.listeJoueurs.ajoutJoueur(listeJoueurs.getJoueur(i));
                }
            }
            else{
                System.out.println("ERREUR : pour le type de phase " + this.getType() + " il faut imperativement le " +
                        "bon nombre de joueurs dans la liste de joueurs. Or ici il y en a : " + this.listeJoueurs
                        .getNumberJoueurs()" !!");
            }
        }
        else{
            System.out.println("Les joueurs ne sont pas valides, fermeture du programme");

        }
    }


    private void setType(String typeFinale){
        if (!this.typeFinale.equals("quart") && !this.typeFinale.equals("demi") && !this.typeFinale.equals("finale")){
            System.out.println("Le nom de la phase finale n'est pas valide" + this.typeFinale);

        }
        else {
            this.typeFinale = typeFinale;
        }
    }

    public String getType(){
        return this.typeFinale;
    }
}
