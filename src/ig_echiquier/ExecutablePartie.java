package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExecutablePartie extends JFrame {

	private String nom;
	private int hauteur;
	private int largeur;
	
	private JPanel cards;
	final static String PARTIEENCOURS = "Partie en cours";
	final static String PARTIETERMINEE = "Partie terminée - Revisionnage";
    private PartieEnCours partieEnCours = new PartieEnCours();
    private PartieTerminee partieTerminee = new PartieTerminee();
	
	public ExecutablePartie(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		
		//creation fenetre 
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     

	    //JPanel partie = new JPanel();
	    
	    
	    cards = new JPanel(new CardLayout());
	    cards.add(partieEnCours,PARTIEENCOURS);
	    cards.add(partieTerminee,PARTIETERMINEE);
	   
	    this.setContentPane(cards);
	    
	  /*  this.setContentPane(echiquier); 
	    partieEnCours.setLayout(new BorderLayout());
	    partieEnCours.add(echiquier, BorderLayout.CENTER);
	    
	    boutonJouer.addActionListener(new BoutonJouerListener());
	    boutonQuitter.addActionListener(new BoutonQuitterListener());
	    
	    
	    JPanel south = new JPanel();
	    coup.setPreferredSize(new Dimension(150, 30));
	    south.add(coup);
	    south.add(label1);
	    south.add(boutonJouer);
	    south.add(boutonQuitter);
	    partieEnCours.add(south, BorderLayout.SOUTH);
	    
	    partieEnCours.add(label2, BorderLayout.NORTH);
	    
	    this.setContentPane(partieEnCours); */
	    
	    
	  
	    
	    this.setVisible(true);
	  
	    
	    
	}


	

/*	@Override
	public void jouerUnCoup(ActionEvent arg0) {
		// trucs graphiques associés pour recojnnaitre l'appui sur le bouton
		//controleur.verifierCoup(int PosxDep, int PosyDep, int PostxFin, int PosyFin);
		//afficher_coup();
		 String str = this.label1.getText();
		 label2.setText("Vous avez écrit "+str);
	}


	@Override
	public void quitterPartie(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void rejouerPartie(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void coupSuivant(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} */

	
	
	private void afficher_coup() {
		// TODO Peut etre voir pour associer un controleur...
		// en fonction des resultats de la verif, on affiche le nouvel echequier et/ou on affiche un texte
	}



	
}