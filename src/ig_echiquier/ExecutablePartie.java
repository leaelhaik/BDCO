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
	
	private CardLayout cl = new CardLayout();
	private JPanel cards = new JPanel();
	final static String PARTIEENCOURS = "Partie en cours";
	final static String PARTIETERMINEE = "Partie terminée - Revisionnage";
    private PartieEnCours partieEnCours = new PartieEnCours();
    private PartieTerminee partieTerminee = new PartieTerminee();
    private JButton boutonQuitter = new JButton("Quitter la partie");
	
	public ExecutablePartie(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		
		//creation fenetre 
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     

	    JPanel partie = new JPanel();
	    
	    partie.setLayout(new BorderLayout());
	    partie.add(partieEnCours);
	    
	    boutonQuitter.addActionListener(new BoutonQuitterListener());
	    
	    partie.add(boutonQuitter, BorderLayout.NORTH);
	    
	    cards.setLayout(cl);
	    cards.add(partie,PARTIEENCOURS);
	    cards.add(partieTerminee,PARTIETERMINEE);
	   
	    this.setContentPane(cards);	  
	    
	    this.setVisible(true);
	  
	    
	    
	}


	class BoutonQuitterListener implements java.awt.event.ActionListener {

		
		public void actionPerformed(ActionEvent arg0) {
			cl.show(cards, PARTIETERMINEE);
		}
		
		
	}



	
}