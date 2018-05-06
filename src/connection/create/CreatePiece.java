package connection.create;
import java.sql.*;
 import connection.MultipleQueries;

 public class CreatePiece {


   public CreatePiece(MultipleQueries queries) {
     ResultSet rsetCreatePiece = queries.getResult("CREATE TABLE Piece(idPiece INTEGER NOT NULL,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))");
   }




 /* // MA VERSION
  static final String STMTCreate = "CREATE TABLE Piece(idPiece INTEGER NOT NULL,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
   posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5)
   check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)), `
      constraint mouvment CHECK(if(typePiece = 'roi') then check ((posY between oldY-1 and oldY+1)and (ascii(posX) between ascii(oldX)-1 and ascii(oldX)+1))
                                else if(typePiece = 'reine') then check ((abs(ascii(posX) - ascii(oldX)) = abs(posY - oldY)) or (ascii(posX) = ascii(oldX)) or (posY = oldY))
                                else if(typePiece = 'tour') then check ((ascii(posX) = ascii(oldX)) or (posY = oldY))
                                else if(typePiece = 'fou') then check (abs(ascii(posX) - ascii(oldX)) = abs(posY - oldY))
                                else if(typePiece = 'cavalier') then check (((ascii(posX) = (ascii(oldX) + 1)) and (posY = (oldY + 2))) or ((ascii(posX) = (ascii(oldX) + 1)) and (posY = (oldY - 2))) or ((ascii(posX) = (ascii(oldX) - 1)) and (posY = (oldY + 2))) or ((ascii(posX) = (ascii(oldX) - 1)) and (posY = (oldY - 2))) or ((ascii(posX) = (ascii(oldX) + 2)) and (posY = (oldY + 1))) or ((ascii(posX) = (ascii(oldX) + 2)) and (posY = (oldY - 1))) or ((ascii(posX) = (ascii(oldX) - 2)) and (posY = (oldY + 1))) or ((ascii(posX) = (ascii(oldX) - 2)) and (posY = (oldY - 1))))";
*/


}
