package connection;
//verification Joueur



//verification Coup : Selon TypePiece et Etat dynamique


static final String STMT = "select idPiece,couleur as couleur1,posX as posX1,posY as posY1,nomTour as nT1, numRencontre as nR1 from Piece where couleur1<>couleur and (posY1=oldY + 1) and((posX1=oldX+1)or(posX1=oldX-1)) and numRencontre=nR1 and nomTour=nT1;"

Statement stmt = conn.createStatement();
// Execution de la requete
ResultSet rset = stmt.executeQuery(STMT);


if((Math.abs(oldX-posX)+Math.abs(oldY-posY))>0){

 switch(typePiece){
    //verification Tour :
    case "tour" : if((posX==oldX)||(posY==oldY));
    //verification Fou:
    case "fou" : if(Math.abs(oldX-posX)==Math.abs(oldY-posY));
    //verification Roi:
    case "roi" : if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2);
    //verification cavalier:
    case "cavalier" : if((Math.abs(oldX-posX)==2 && Math.abs(oldY-posY)==1)||(Math.abs(oldX-posX)==1 && Math.abs(oldY-posY)==2));
    //verification reine:
    case "reine" : if((Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2)!=(posX==oldX)||(posY==oldY));
    //verification pion
    case "pion" : if(rset.getInt(1)<>null &&(posY1=rset.getInt(4))&&(posX==rset.getInt(3))){
                  }
                  else if(rset.wasNull()&&(posY-oldY==1)&&(posX==oldX))
  }
}
