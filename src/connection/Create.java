package connection;




public class Create {

    public void CreateAffectationCouleur() {
        Queries.queries.getResult("CREATE TABLE AffectationCouleur(idJoueur integer NOT NULL,nomCouleur character varying(5),nomTour varchar(20) NOT NULL,numRencontre integer not null,primary key(idJoueur,nomTour,numRencontre,nomCouleur),foreign key(nomCouleur) REFERENCES Couleur(nomCouleur),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour),foreign key(idJoueur) REFERENCES Joueur(idJoueur))");
      }
    
    public void CreateCouleur() {
       Queries.queries.getResult("CREATE TABLE Couleur(nomCouleur character varying(5) check(nomCouleur in('blanc','noir')),primary key(nomCouleur))");
      }
    
    public void CreateHistorique() {
        Queries.queries.getResult("CREATE TABLE Historique(idCoup integer not null,nomTour varchar(20) NOT NULL,numRencontre integer not null,posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')), oldY integer check(oldY<9),primary key(idCoup),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))");
      }
    
    public void CreateJoueur() {
      Queries.queries.getResult("CREATE TABLE Joueur(idJoueur integer, nomJoueur character varying(30),prenomJoueur character varying(30),dateNaissance character varying(30),adresseJoueur character varying(30),PRIMARY KEY(idJoueur))");
    }
    
    public void CreatePiece() {
        Queries.queries.getResult("CREATE TABLE Piece(idPiece INTEGER NOT NULL,typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')),oldY integer check(oldY<9),couleur	character varying(5) check(couleur in('blanc','noir')), numRencontre integer not null, nomTour varchar(20) not null, PRIMARY KEY(idPiece), foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))");
      }
    
    public void CreateRencontre() {
      Queries.queries.getResult("CREATE TABLE Rencontre(numRencontre integer not null ,nomTour varchar(20) NOT NULL,idJoueur integer NOT NULL,PRIMARY KEY(numRencontre, nomTour),FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur))");
    }

    public void CreateTour() {
    	Queries.queries.getResult("CREATE TABLE Tour(nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),PRIMARY KEY(nomTour))");
    }

}
