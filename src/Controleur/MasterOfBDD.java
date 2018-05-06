package Controleur;

import connection.drop.*;

/**
 * Created by ensimag on 06/05/18.
 */
public class MasterOfBDD {

    public MasterOfBDD() {

    }

    public static void effacerBD() {
        new DropMain();
    }

}
