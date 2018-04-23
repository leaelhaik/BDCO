package donnees;

import gui.GUISimulator;
import gui.Text;
import gui.Rectangle;
import gui.GraphicalElement;
import gui.ImageElement;
import java.awt.Color;

import gui.Simulable;


public class Simulateur implements Simulable{
		/** L'interface graphique associé*/
		private GUISimulator gui;
		
		/**
		 * Les données associées au simulateur
		 * La carte, le tableau des robots et la liste d'inciendies
		 */
		//private DonneesBD donnees;
		/**
		 * La taille de Cases (en pixels) dessiné
		 */
		private int tailleCases;
		
		/**
		 * La date courante de la simulation
		 * On l'initialise toujours à 0
		 */
		private long dateSimulation=0;
		
	
		public Simulateur(GUISimulator gui){
			this.gui = gui;
			gui.setSimulable(this);
			this.tailleCases = echelle(gui.getPanelHeight(), gui.getPanelWidth());
			draw();
		}
		
		/**
		 * Acceseur pour connaitre la date courant du simulateur
		 * @return long Date la date courant
		 */
		public long getDate(){
			return this.dateSimulation;
		}
		
		
		/**
		 * Dessine la carte sur la fenêtre graphique de taille donné dans la carte	 
		 */
		public void draw(){
			gui.reset();// clear the window
			int taille = this.tailleCases;
			dessineEchiquier(taille);
			dessineLegende(taille);
		}
		
		/**
		 * dessine la carte avec des cases de taille taille
		 * @param taille la taille des cases
		 */
		private void dessineEchiquier(int taille){
			java.awt.image.ImageObserver obs=null;		
			int x = 0;
			int y=0;
			
			for(int i=1; i<=8; i++){
				for(int j=1; j<=8;j++){
					String couleur;
					x =j*taille;
					y= i*taille;
					if ((i%2==0 && j%2!=0 )|| i%2!=0 && j%2==0) {
						couleur = "#88421D";
					} else {
						couleur = "#FEFEE0";
					}
					gui.addGraphicalElement( new Rectangle(x, y, Color.decode(couleur),Color.decode(couleur), taille));
				}
			}
		} //dessiner l'echiquier de base de moi meme
		
		/**
		 * dessine la légende des cases de taille taille
		 * @param taille la taille des cases
		 */
		private void dessineLegende(int taille){
			java.awt.image.ImageObserver obs=null;		
			int x = 0;
			
			int y = 9;
			char legende = 65; // Code ASCII du A
			for (int j = 1; j<= 8; j++) {
				x = j*taille;
				gui.addGraphicalElement( new Text(x, y, Color.WHITE, Character.toString(legende)));
				legende ++;
			}
		
			x = 9;
			legende = 56; // Code ASCII du 0
			for (int i = 1; i<=8; i++) {
				y = i*taille;
				gui.addGraphicalElement( new Text(x, y, Color.WHITE, Character.toString(legende)));
				legende --;
			}
		}
		
	/*	private void dessinePion(int taille) {
			int i,j=1;
			int x,y;
			for (i=1;i<=8;i++) {
				for (j=1;j>=8;j++){
					x =j*taille;
					y= i*taille;
					String piece=donnees.getPiece(i,j);
					String couleur=donnees.getCouleur(i,j);
					if (piece != null) {
						gui.addGraphicalElement( new ImageElement(x,y,"./images/"+piece+"_"+couleur,taille, taille,null));
					}
					
				}
			}
		} */
		
		/**
		 * Calcul la taille en pixels des cases à dessiner dans la fenetre
		 * @param taille la taille réel des cases
		 * @param height le height de la fenetre de dessin
		 * @param width le width de la fenetre de dessin
		 * @param lignes le nb de lignes de la matrices de cases
		 * @param colonnes le nb de lignes de la matrices de cases
		 * @return la taille en pixels des cases à dessiner
		 */
		private int echelle(int height, int width){
			return (Math.min(width/8, height/8));
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void restart() {
			// TODO Auto-generated method stub
			
		}
			
}
