package Java.Controleur;

/**
 * Created by barred on 4/30/18.
 */
public abstract class Joueur {

    String nom;

    public Joueur(String name) {
        this.nom = name;
    }

    public boolean isValid() {
        return true;
    }
}