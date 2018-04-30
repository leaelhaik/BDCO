CREATE TABLE Tour(nomTour varchar(20) NOT NULL CHECK(nomTour in ('finale','demiFinale','quartFinale','qualifications')),PRIMARY KEY(nomTour));

CREATE TABLE Joueur(idJoueur integer NOT NULL ,
	nomJoueur character varying(30),
	prenomJoueur character varying(30),
	dateNaissance DATE,
	adresseJoueur character varying(30),PRIMARY KEY(idJoueur));

CREATE TABLE Piece(
	idPiece INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H')),
	oldY integer check((0<oldY) and (oldY<9)),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPiece),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Pion(
	idPiecePion INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H') and((posX=oldX)or(posX=oldX-1)or(posX=oldX+1))),
	oldY integer check((0<oldY) and (oldY<9)and (posY=oldY+1)),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPiecePion),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Tour(
	idPieceTour INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H') ),
	oldY integer check((0<oldY) and (oldY<9) and ((oldX=posX)<>(oldY=posY))),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPieceTour),
	foreign key(idPieceTour) REFERENCES Piece(idPiece),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Roi(
	idPieceRoi INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H') and (posX between oldX-2 and oldX+2)),
	oldY integer check((0<oldY) and (oldY<9) and ((oldY<>posY)or(posX<>oldX)) and(posY between oldY-2 and oldY+2)),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPieceRoi),
	foreign key(idPieceRoi) REFERENCES Piece(idPiece),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Reine(
	idPieceReine INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H')),
	oldY integer check((0<oldY) and (oldY<9) and (oldY<>posY or oldX<>posX) and(((posX-oldX)=(posY-oldY))or((posX-oldX)=(oldY-posY)))),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPieceReine),
	foreign key(idPieceReine) REFERENCES Piece(idPiece),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Fou(
	idPieceFou INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H') and (posX<>oldX)),
	oldY integer check((0<oldY) and (oldY<9) and(((posX-oldX)=(posY-oldY))or((posX-oldX)=(oldY-posY))or(oldX=posX)<>(oldY=posY)) and (oldY<>posY or oldX<>posX)),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPieceFou),
	foreign key(idPieceFou) REFERENCES Piece(idPiece),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Cavalier(
	idPieceCavalier INTEGER NOT NULL ,
	-- typePiece varchar(20) NOT NULL CHECK(typePiece in('roi','reine','tour','fou','cavalier','pion')),
	posX character check(posX in ('A','B','C','D','E','F','G','H')),
	posY integer check((0<posY) and (posY<9)),
	oldX character check(oldX in ('A','B','C','D','E','F','G','H') and (posX<>oldX)),
	oldY integer check((0<oldY) and (oldY<9)and (oldY<>posY)and((posX=oldX+1 and posY=oldY+2)or(posX=oldX-1 and posY=oldY+2)or(posX=oldX+2 and posY=oldY+1)or(posX=oldX-2 and posY=oldY+1))),
	couleur	character varying(5) check(couleur in('blanc','noir')),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	PRIMARY KEY(idPieceCavalier),
	foreign key(idPieceCavalier) REFERENCES Piece(idPiece),
	foreign key(numRenconre,nomTour) REFERENCES Rencontre(numRencontre,nomTour)
);

CREATE TABLE Rencontre(
	numRencontre integer not null check(numRencontre>0),
	nomTour varchar(20) NOT NULL,
	idJoueur integer,
	PRIMARY KEY(numRencontre,nomTour),
	FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),
	FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur));

CREATE TABLE Couleur(
	nomCouleur character varying(5) check(nomCouleur in('blanc','noir')),
	primary key(nomCouleur));

CREATE TABLE Historique(idCoup integer not null,nomTour varchar(20) NOT NULL,numRencontre integer not null,posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')), oldY integer check(oldY<9),primary key(idCoup),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour));

CREATE TABLE AffectationCouleur(
	idJoueur integer NOT NULL,
	nomCouleur character varying(5),
	nomTour varchar(20) NOT NULL,
	numRencontre integer not null,
	primary key(idJoueur,nomTour,numRencontre,nomCouleur),
	foreign key(nomCouleur) REFERENCES Couleur(nomCouleur),
	foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour),
	foreign key(idJoueur) REFERENCES Joueur(idJoueur));
