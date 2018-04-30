CREATE TABLE Tour(
	nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),
	PRIMARY KEY(nomTour));

CREATE TABLE Joueur(
  idJoueur integer NOT NULL auto_increment,
  nomJoueur character varying(30),
  prenomJoueur character varying(30),
  dateNaissance DATE,
  adresseJoueur character varying(30),
  PRIMARY KEY(idJoueur));

CREATE TABLE Piece(
	idPiece INTEGER NOT NULL ,
	typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posY in ('A','B','C','D','E','F','G','H')),
	posY integer check(0<posX<9),
	oldX character check(oldY in ('A','B','C','D','E','F','G','H')),
	oldY integer check(0<oldX<9),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	--numRencontre integer not null,
	--nomTour varchar(20) NOT NULL,
	PRIMARY KEY(idPiece)
	--foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Rencontre(
	numRencontre integer not null check(numRencontre>0),
	nomTour varchar(20) NOT NULL,
	idJoueur integer NOT NULL,
	PRIMARY KEY(numRencontre),
	FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),
	FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur));

CREATE TABLE Couleur(
	nomCouleur character varying(5) check(nomCouleur in('blanc','noir'),
	primary key(nomCouleur));

CREATE TABLE Historique(
	idCoup integer not null auto_increment,
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	posX character check(posX in ('A','B','C','D','E','F','G','H'),
	posY integer check(0<posY<9),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H'),
	oldY integer check(0<oldY<9),
	primary key(idCoup),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour));

CREATE TABLE AffectationCouleur(
	idJoueur integer NOT NULL,
	nomCouleur character varying(5),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	primary key(idJoueur,nomTour,numRencontre,nomCouleur),
	foreign key(nomCouleur) REFERENCES Couleur(nomCouleur),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour),
	foreign key(idJoueur) REFERENCES Joueur(idJoueur));
