package ig_tournoi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExecutableTournoi extends JFrame {
	
	private String nom;
	private int hauteur;
	private int largeur;
	
	private CardLayout cl = new CardLayout();
	private JPanel cards = new JPanel();
	private InscriptionJoueur ins = new InscriptionJoueur();
	private JButton boutonSuivreTournoi= new JButton("Suivre un tournoi");
	private JButton boutonCreerTournoi = new JButton("Creer un nouveau tournoi");
	private JButton boutonRetour = new JButton("Retour");
	private final static String TOURNOIEXISTANT = "Tournoi deja existant";
	private final static String NOUVEAUTOURNOI = "Nouveau tournoi";
	private final static String QUALIFS = "Phase de qualification";
	private Qualification qualif = new Qualification();
	private JLabel tournoi = new JLabel("Tournoi n°54165");
	private JLabel phase = new JLabel("");
	
public ExecutableTournoi(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		

	
		//creation fenetre 
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    boutonSuivreTournoi.addActionListener(new BoutonSuivreTournoiListener());
	    boutonCreerTournoi.addActionListener(new BoutonCreerTournoiListener());
	    boutonRetour.addActionListener(new BoutonRetourListener());
	    
	    JPanel debut = new JPanel();
	    debut.add(boutonSuivreTournoi);
	    debut.add(boutonCreerTournoi);
	    
	    JPanel creationTournoi = new JPanel();
	    JButton boutonValiderJoueurs = new JButton("Validez les joueurs");
	    boutonValiderJoueurs.addActionListener(new BoutonValiderJoueursListener());
	    //Ici, mettre dans le label tournoi le numero du tournoi avec tournoi.setText("Tournoi n°"+getIdTournoi())
	    //creationTournoi.add(tournoi, BorderLayout.NORTH);
	    creationTournoi.add(ins,BorderLayout.CENTER);
	    creationTournoi.add(boutonValiderJoueurs, BorderLayout.SOUTH);
	    creationTournoi.add(boutonRetour, BorderLayout.NORTH);
	    
	    
	    JPanel suiviTournoi = new JPanel();
	    //creationTournoi.add(boutonRetour, BorderLayout.NORTH);
	    
	    JPanel tourQualif = new JPanel();
	    tourQualif.add(qualif);
	    //Ici, mettre dans le label tournoi le numero du tournoi avec tournoi.setText("Tournoi n°"+getIdTournoi())
	    tourQualif.add(tournoi, BorderLayout.NORTH);
	    tourQualif.add(boutonRetour, BorderLayout.NORTH);
	    
	    cards.setLayout(cl);
	    cards.add(debut);
	    cards.add(creationTournoi,NOUVEAUTOURNOI);
	    cards.add(suiviTournoi,TOURNOIEXISTANT);
	    cards.add(tourQualif,QUALIFS);

	    //JPanel tournoi = new JPanel();
	    this.setContentPane(cards);
	    this.setVisible(true);
}

class BoutonSuivreTournoiListener implements java.awt.event.ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		cl.show(cards, TOURNOIEXISTANT);
		
	}
	
}
	    
class BoutonCreerTournoiListener implements java.awt.event.ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		cl.show(cards, NOUVEAUTOURNOI);
		
	}
}
	 

class BoutonValiderJoueursListener implements java.awt.event.ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		//tester le nombre de joueurs
		cl.show(cards, QUALIFS);
		
	}
	
}

class BoutonRetourListener implements java.awt.event.ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		cl.previous(cards);
		
	}
}

}
