package Java.Modele;

/**
 * Created by georgeb on 4/11/18.
 */
public class Rencontre {
    //Stocke l'état de la partie en cours
    boolean enCours;
    // Joueurs concernés. Attention, surement à remplacer par des appels à BD
    Joueur joueurs[] = new Joueur[2];
    int num = 0;

    public Rencontre(int id) {
        this.enCours = getDEtat(id);
    }

    public void Rejouer(boolean enCours) {

    }

    public void attache(Joueur j) {
        if (num < 2) {
            joueurs[num] = j;
            num++;
            informe();
        }
    }

    public void detache(Joueur j) {
        if (joueurs[0] == j) {
            joueurs[0] = joueurs[1];
            joueurs[1] = null;
            num --;
            informe();
        } else if (joueurs[1] == j) {
            joueurs[1] = null;
            num --;
            informe();
        }
    }

    public void informe() {
        for (Joueur j : joueurs) {
            j.miseAJour();
        }
    }

    public boolean getDEtat(int id) {
        /* select idJoueur from Rencontre where numRencontre = id -> var
            return var == null;
         */
        return true;
    }

}
