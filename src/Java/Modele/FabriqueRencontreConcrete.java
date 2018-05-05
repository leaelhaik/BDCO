package Java.Modele;

/**
 * Created by ensimag on 05/05/18.
 */
public class FabriqueRencontreConcrete extends FabriqueRencontre{

    @Override
    public ListeRencontre lesRencontres() {
        String STMT = "select * from rencontres";
        return null;
    }

    @Override
    public void nouvelleRencontre(Joueur blanc, Joueur noir) {
        /*
        Cette fonction créé et envoie la requête qui permet d'ajouter une nouvelle rencontre dans la BD.
        Valeurs :
        etat : en cours
        Joueur blanc : blanc
        Joueur noir : noir
        id : last_id +1
        ...
         */
    }
}
