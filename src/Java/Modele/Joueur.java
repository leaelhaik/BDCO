package Java.Modele;

/**
 * Created by barred on 4/30/18.
 */
public abstract class Joueur {

    private String nom;
    private String prenom;
    private int idUnique; //l'id unique du joueur pour le tour
    private String dateNaissance;
    private String adresse;


    public Joueur(String name) {
        this.nom = name;
    }

    public boolean isValid() {
        return true;
    }

    public void miseAJour() {}

//-------getteurs et setteurs -----------

    private void setTout(String nom, String prenom, int idUnique, String dateNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.idUnique = idUnique;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public int getId() {
        return this.idUnique;
    }


//-------méthodes------------
    @Override
    public String toString(){
        String s = this.nom + " , " + this.prenom + " , " + this.idUnique;
        return s;
    }
}

