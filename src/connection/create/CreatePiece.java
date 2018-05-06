package connection.create;
import java.sql.*;
 import connection.MultipleQueries;

 public class CreatePiece{
   private MultipleQueries queries;

   public CreatePiece() {
     ResultSet rsetCreatePiece = queries.getResult("CREATE TABLE Piece(idPiece INTEGER NOT NULL,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
        posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5)
        check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)))");
   }

   public static void main(String args[]) {
     new CreatePiece();
   }

 }
