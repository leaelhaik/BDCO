package Java.Modele;

import java.sql.Date;

/**
 * Created by barred on 4/30/18.
 */
public abstract class Joueur {

    private String nom;
    private String prenom;
    private int idUnique; //l'id unique du joueur pour le tour
    private Date dateNaissance;
    private String adresse;
    private int nbVictoires;


    public Joueur(String name) {
        this.nom = name;
    }

    public Joueur(String nom, String prenom, int id, Date date, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.idUnique = id;
        this.dateNaissance = date;
        this.adresse = adresse;
        nbVictoires = 0;
    }

    public boolean isValid() {
        return true;
    }

    public void miseAJour() {}

//-------getteurs et setteurs -----------

    private void setTout(String nom, String prenom, int idUnique, Date dateNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.idUnique = idUnique;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public int getId() {
        return this.idUnique;
    }

    public int getNbVictoires() {
        return nbVictoires;
    }

    //-------méthodes------------
    @Override
    public String toString(){
        String s = this.nom + " , " + this.prenom + " , " + this.idUnique;
        return s;
    }
}


