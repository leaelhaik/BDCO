package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.BoxLayout;
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
	final static String OUVERTURE = "Ouverture";
	final static String MENU = "Menu";
	final static String PARTIEENCOURS = "Partie en cours";
	final static String PARTIETERMINEE = "Partie terminée - Revisionnage";
	private JPanel ouverture = new JPanel();
	private Menu menu = new Menu(9);
    private PartieEnCours partieEnCours = new PartieEnCours();
    private PartieTerminee partieTerminee = new PartieTerminee();
    private JButton boutonQuitter = new JButton("Quitter la partie");
	private JTextField nomJoueur = new JTextField("");
	private JTextField prenomJoueur = new JTextField("");
    
	public ExecutablePartie(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		
		//creation fenetre 
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     

	    JPanel ouv = new JPanel();
	    JPanel b1 = new JPanel();
	    b1.setLayout(new BoxLayout(b1,BoxLayout.LINE_AXIS));
	    b1.add(new JLabel("Nom"));
	    nomJoueur.setPreferredSize(new Dimension(150,30));
	    b1.add(nomJoueur);
	    JPanel b2 = new JPanel();
	    b2.setLayout(new BoxLayout(b2,BoxLayout.LINE_AXIS));
	    b2.add(new JLabel("Prenom"));
	    prenomJoueur.setPreferredSize(new Dimension(150,30));
	    b2.add(prenomJoueur);
	    JButton boutonOK = new JButton("OK");
	    boutonOK.addActionListener(new BoutonVerifJoueurListener());
	    ouv.setLayout(new BoxLayout(ouv, BoxLayout.PAGE_AXIS));
	    ouv.add(b1);
	    ouv.add(b2);
	    ouv.add(boutonOK);
	    ouverture.add(ouv, BorderLayout.CENTER);
	    
	    
	    JPanel men = new JPanel();
	    
		JPanel south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));
		JButton boutonChoix = new JButton("Choisir cette rencontre");
		boutonChoix.addActionListener(new BoutonChoixListener());
		JButton boutonRetour = new JButton("Retour");
		boutonRetour.addActionListener(new BoutonRetourListener());
		south.add(boutonRetour);
		south.add(boutonChoix);
		
		men.add(south,BorderLayout.SOUTH);
		men.add(menu, BorderLayout.CENTER);
	    
	    
	    JPanel partie = new JPanel();
	    
	    partie.setLayout(new BorderLayout());
	    partie.add(partieEnCours);
	    
	    boutonQuitter.addActionListener(new BoutonQuitterListener());
	    
	    partie.add(boutonQuitter, BorderLayout.NORTH);
	    
	    cards.setLayout(cl);
	    cards.add(ouverture,OUVERTURE);
	    cards.add(men,MENU);
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
	
	class BoutonVerifJoueurListener implements java.awt.event.ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			//verifJoueur
			cl.show(cards,MENU);
			
		}
		
	}
	
	class BoutonChoixListener implements java.awt.event.ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			//if (getVainqueur() != null ) {
			//	cl.show(cards, PARTIETERMINEE);
			//} else {
				cl.show(cards, PARTIEENCOURS);
			//}
			
		}
		
	}
	
	class BoutonRetourListener implements java.awt.event.ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cl.previous(cards);
			
		}
		
	}



	
}