package Java.Modele;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by barred on 4/30/18.
 */
public abstract class FabriqueJoueur {

    public abstract ListeJoueurs lesJoueurs();

    public abstract void ajouterJoueur(String nom, String prenom, String adresse, Date date);

}