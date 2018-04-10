//verification Joueur



//verification Coup : Selon TypePiece et Etat dynamique

 Select numRencontre,nomTour,oldX,posX,oldY,posY from Piece where numRencontre="" and nomTour="";
//verification Tour :
if((posX==oldX)||(posY==oldY))
//verification Fou:
if(Math.abs(oldX-posX)==Math.abs(oldY-posY))
//verification Roi:
if(Math.abs(oldX-posX)<2 && Math.abs(oldY-posY)<2)
//verification cavalier:
if((Math.abs(oldX-posX)==2 && Math.abs(oldY-posY)==1)||(Math.abs(oldX-posX)==1 && Math.abs(oldY-posY)==2))
