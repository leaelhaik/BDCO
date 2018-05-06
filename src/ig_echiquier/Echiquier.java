package ig_echiquier;


import java.awt.Color;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import connection.MultipleQueries;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import donnees.Piece;
import donnees.Couleur;




public class Echiquier extends JPanel {

	
	public void paintComponent(Graphics g) {
		int taille=echelle(this.getHeight(), this.getWidth());
		taille=taille-taille/8;
		dessineEchiquier(g, taille);
		//dessinePions(g, taille);
		dessineLegende(g, taille);

	}
	private void dessineEchiquier(Graphics g, int taille) {
		int x = 0;
		int y=0;
		
		for(int i=1; i<=8; i++){
			for(int j=1; j<=8;j++){
				int couleurR, couleurG, couleurB;
				x =j*taille;
				y= i*taille;
				if ((i%2==0 && j%2!=0 )|| i%2!=0 && j%2==0) {
					couleurR = 136;
					couleurG = 66;
					couleurB = 29;
				} else {
					couleurR = 254;
					couleurG = 254;
					couleurB = 224; 
				}
				g.drawRect(x, y, taille, taille);
				g.setColor(new Color(couleurR, couleurG, couleurB));
				g.fillRect(x, y, taille, taille);
			}
		}
	}
	
	private void dessinePions(Graphics g, int taille) {
		int coordI = 8;
 		String coordJ;
 		Piece piece;
		int i,j=1;
		int x,y,z;
		z= taille/6;
		for (i=1;i<=8;i++) {
			for (j=1;j<=8;j++){
				x =j*taille;
				y= i*taille;
				coordJ = Character.toString((char)(64+j)); //Renvoi la lettre liée à la position X
				piece = new Piece(coordJ, coordI , 1 ,"finale");
				if (piece.getNomPiece() != null && piece.getCouleur() != null) {
					try {
					 Image img = ImageIO.read(new File("./images/"+piece.getNomPiece()+"_"+piece.getCouleur()+".png"));
					 g.drawImage(img, x+z/2, y+z/2, taille-z, taille-z,null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			coordI--;
		}
	} 
	
	/**
	 * dessine la légende des cases de taille taille
	 * @param taille la taille des cases
	 */
	private void dessineLegende(Graphics g, int taille){
		int x = taille/2;

		int y = taille/2;
		char legende = 65; // Code ASCII du A
		for (int j = 1; j<= 8; j++) {
			x = j*taille+taille/2;
			g.setColor(Color.BLACK);
			g.drawString(Character.toString(legende), x, y);
			legende ++;
		}

		x = taille/2;
		legende = 56; // Code ASCII du 0
		for (int i = 1; i<=8; i++) {
			y = i*taille+taille/2;
			g.setColor(Color.BLACK);
			g.drawString(Character.toString(legende), x, y);
			legende --;
		}
	}
	
	
	private int echelle(int hauteur, int largeur){
		return (Math.min(largeur/9, hauteur/9));
	}
	
}
