package Java.Modele;

/**
 * Created by barred on 05/05/18.
 */
public abstract class FabriqueRencontre {

    public abstract ListeRencontre lesRencontres();

    public abstract void nouvelleRencontre(Joueur blanc, Joueur noir);
}
