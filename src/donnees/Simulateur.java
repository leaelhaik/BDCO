package donnees;

import gui.GUISimulator;
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
		private DonneesBD donnees;
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
			this.tailleCases = echelle(gui.getPanelHeight(), gui.getWidth());
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
		}
		
		/**
		 * dessine la carte avec des cases de taille taille
		 * @param taille la taille des cases
		 */
		private void dessineEchiquier(int taille){
			int p = 8;
			int n = 8;
			java.awt.image.ImageObserver obs=null;		
			Case cas;
			int x = 0;
			int y=0;
			
			for(int i=0; i<n; i++){
				for(int j=0; j<p;j++){
					String couleur;
					x =j*taille;
					y= i*taille;
					cas=this.donnees.getMap().getCase(i,j);
					switch(cas.getCouleur()){
					case BLANCHE:
						couleur = "#FEFEE0";
						break;
					case NOIRE:
						couleur = "#88421D";
						break;
					default:
						break;
					}
					gui.addGraphicalElement( new Rectangle(x, y, Color.decode(couleur),Color.decode(couleur), taille));
				}
			}
		}
		
		private void dessinePion(int taille) {
			
		}
		
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
