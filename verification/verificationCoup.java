import java.sql.*;
boolean blanc = true ;

public class verificationCoup {

  static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
  static final String USER = "dhouibd"; // A remplacer pour votre compte
  static final String PASSWD = "dhouibd";

//verification Joueur, cad que le joueur bouge bien la bonne couleur
if((blanc && couleur=="blanc") || (!blanc && couleur=="noir"){
  isValid=true;
}


//l'état echec à définir

//verification Coup : Selon TypePiece et Etat dynamique

// Sélectionne la case en diagonale du pion pour savoir s'il peut la manger ou non
static final String STMT = "select idPiece,couleur as couleur1,posX as posX1,posY as posY1,
nomTour as nT1, numRencontre as nR1 from Piece where couleur1<>couleur ,(posY1=oldY + 1)
,((posX1=oldX+1)or(posX1=oldX-1)),numRencontre=nR1,nomTour=nT1;";

Statement stmt = conn.createStatement();
// Execution de la requete
ResultSet rset = stmt.executeQuery(STMT);

boolean isValid = false ;

boolean enEchec = false ;

if((Math.abs(oldX-posX)+Math.abs(oldY-posY))>0){

 switch(typePiece){
    //verification Tour :
    case "tour" : verifTour();
    /* if((posX==oldX)||(posY==oldY)){
      isValid = true;
      static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and (px between oldX and posX or py between oldY and posY) ";
    }*/
    //verification Fou:
    case "fou" : verifFou();
    /*if(Math.abs(oldX-posX)==Math.abs(oldY-posY)){
      isValid = true;
      static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and px between oldX and posX and py between oldY and posY and py-oldY=px-oldX ";
    }*/
    //verification Roi:
    case "roi" : verifRoi();
    /* if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2){
      isValid = true;
      static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and px between oldX and posX and py between oldY and posY ";
    }*/
    //verification cavalier:
    case "cavalier" : verifCavalier();
    /*if((Math.abs(oldX-posX)==2 && Math.abs(oldY-posY)==1)||(Math.abs(oldX-posX)==1 && Math.abs(oldY-posY)==2)){
      isValid = true;
      if(Math.abs(oldY-posY)==1)
        static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and px between oldX and posX";
      else
        static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and py between oldY and posY ";

    }*/
    //verification reine:
    case "reine" : verifReine();
    /*if((Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2)!=(posX==oldX)||(posY==oldY)){
      isValid = true;
      static final String STMT = "select idPiece,couleur as coul,numRencontre as nr, nomTour as nt, posX as px,posY as py from piece where numRencontre=nr and nomTour=nt and coul<>couleur and px between oldX and posX and py between oldY and posY ";
    }*/
    //verification pion
    case "pion" : verifPion();
    /*if(rset.getInt(1)<>null &&(posY1=rset.getInt(4))&&(posX==rset.getInt(3))){
                    isValid = true;
                  }
                  else if(rset.wasNull()&&(posY-oldY==1)&&(posX==oldX)){
                    isValid = true;
                  }
  }*/
}

//Si le coup est vérifié, insertion dans l'historique + mise à jour de la position de la pièce
static final String STMT = "Insert into historique(nomTour,numRencontre,posY,posX,oldY,oldX) VALUES();";

static final String STMT = "update Piece SET oldX=posX, oldY=posY ;";
