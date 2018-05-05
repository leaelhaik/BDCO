package ig_tournoi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	private final static String TOURNOIEXISTANT = "Tournoi deja existant";
	private final static String NOUVEAUTOURNOI = "Nouveau tournoi";
	
	
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
	    
	    JPanel debut = new JPanel();
	    debut.add(boutonSuivreTournoi);
	    debut.add(boutonCreerTournoi);
	    
	    JPanel creationTournoi = new JPanel();
	    JButton validerJoueurs = new JButton("Validez les joueurs");
	    creationTournoi.add(ins,BorderLayout.CENTER);
	    creationTournoi.add(validerJoueurs, BorderLayout.SOUTH);
	    
	    JPanel suiviTournoi = new JPanel();
	    
	    
	    cards.setLayout(cl);
	    cards.add(debut);
	    cards.add(creationTournoi,NOUVEAUTOURNOI);
	    cards.add(suiviTournoi,TOURNOIEXISTANT);

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
	    

}
