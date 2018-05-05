package ig_tournoi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
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
	private final static String DEBUT = "Menu principal";
	private final static String TOURNOIEXISTANT = "Tournoi deja existant";
	private final static String NOUVEAUTOURNOI = "Nouveau tournoi";
	private final static String QUALIFS = "Phase de qualification";
	private final static String QUARTS = "Phase de quarts de finale";
	private final static String DEMIS = "Phase de demis finales";
	private final static String FINALE = "Finale";
	private Qualification qualif = new Qualification();
	private Quart quart = new Quart();
	private Demi demi = new Demi();
	private Finale finale = new Finale();
	
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
	    //boutonRetour.addActionListener(new BoutonRetourListener());
	    
	    JPanel debut = new JPanel();
	    debut.add(boutonSuivreTournoi);
	    debut.add(boutonCreerTournoi);
	    
	    JPanel creationTournoi = new JPanel();
	    creationTournoi.setLayout(new BorderLayout());
	    JButton boutonValiderJoueurs = new JButton("Validez les joueurs");
	    boutonValiderJoueurs.addActionListener(new BoutonSuivantListener());
	    
	    creationTournoi.add(new JLabel("Tournoi " + getIDTournoi()), BorderLayout.NORTH);
	    creationTournoi.add(ins,BorderLayout.CENTER);
	    JPanel south = new JPanel();
	    south.add(boutonValiderJoueurs, BorderLayout.SOUTH);
	    JButton boutonRetour1 = new JButton("Retour");
	    boutonRetour1.addActionListener(new BoutonRetourListener());
	    south.add(boutonRetour1);
	    creationTournoi.add(south, BorderLayout.SOUTH);
	    

	    
	    
	    JPanel tourQualif = new JPanel();
	    tourQualif.setLayout(new BorderLayout());
	    tourQualif.add(qualif);
	    JPanel north2 = new JPanel();
	    north2.add(new JLabel("Tournoi n°" + getIDTournoi()));
	    north2.add(new JLabel(" - Qualifications"));
	    tourQualif.add(north2,BorderLayout.NORTH);
	    JButton boutonRetour2 = new JButton("Retour");
	    boutonRetour2.addActionListener(new BoutonRetourListener());
	    JPanel south2 = new JPanel();
	    JButton boutonSuivant2 = new JButton("Phase suivante");
	    boutonSuivant2.addActionListener(new BoutonSuivantListener());
	    south2.add(boutonRetour2);
	    south2.add(boutonSuivant2);
	    tourQualif.add(south2, BorderLayout.SOUTH);
	    

	    
	    JPanel tourQuarts = new JPanel();
	    tourQuarts.setLayout(new BorderLayout());
	    tourQuarts.add(quart);
	    JPanel north3 = new JPanel();
	    north3.add(new JLabel("Tournoi n°" + getIDTournoi()));
	    north3.add(new JLabel(" - Quarts de finales"));
	    tourQuarts.add(north3,BorderLayout.NORTH);
	    JButton boutonRetour3 = new JButton("Retour");
	    boutonRetour3.addActionListener(new BoutonRetourListener());
	    JPanel south3 = new JPanel();
	    JButton boutonSuivant3 = new JButton("Phase suivante");
	    boutonSuivant3.addActionListener(new BoutonSuivantListener());
	    south3.add(boutonRetour3);
	    south3.add(boutonSuivant3);
	    tourQuarts.add(south3, BorderLayout.SOUTH);	    
	    
	    
	    JPanel tourDemis = new JPanel();
	    tourDemis.setLayout(new BorderLayout());
	    tourDemis.add(demi);
	    JPanel north4 = new JPanel();
	    north4.add(new JLabel("Tournoi n°" + getIDTournoi()));
	    north4.add(new JLabel(" - Demis finales"));
	    tourDemis.add(north4,BorderLayout.NORTH);
	    JButton boutonRetour4 = new JButton("Retour");
	    boutonRetour4.addActionListener(new BoutonRetourListener());
	    JPanel south4 = new JPanel();
	    JButton boutonSuivant4 = new JButton("Phase suivante");
	    boutonSuivant4.addActionListener(new BoutonSuivantListener());
	    south4.add(boutonRetour4);
	    south4.add(boutonSuivant4);
	    tourDemis.add(south4, BorderLayout.SOUTH);
	    
	    
	    JPanel tourFinale = new JPanel();
	    tourFinale.setLayout(new BorderLayout());
	    tourFinale.add(finale);
	    JPanel north5 = new JPanel();
	    north5.add(new JLabel("Tournoi n°" + getIDTournoi()));
	    north5.add(new JLabel(" - Finale"));
	    tourFinale.add(north5,BorderLayout.NORTH);
	    JButton boutonRetour5 = new JButton("Retour");
	    boutonRetour5.addActionListener(new BoutonRetourListener());
	    JPanel south5 = new JPanel();
	    south5.add(boutonRetour5);    
	    tourFinale.add(south5, BorderLayout.SOUTH);
	    
	    
	    
	    JPanel suiviTournoi = new JPanel();
	    suiviTournoi.setLayout(new BorderLayout());
	    suiviTournoi.add(new JLabel("Tournoi en cours : Tournoi n°" + getIDTournoi()),BorderLayout.NORTH);
	    JButton boutonSuivi = new JButton("Voir le tournoi");
	    boutonSuivi.addActionListener(new BoutonSuiviListener());
	    suiviTournoi.add(boutonSuivi, BorderLayout.SOUTH);

	    

	    cards.setLayout(cl);
	    cards.add(debut, DEBUT);
	    cards.add(creationTournoi,NOUVEAUTOURNOI);
	    cards.add(suiviTournoi,TOURNOIEXISTANT);
	    cards.add(tourQualif,QUALIFS);
	    cards.add(tourQuarts, QUARTS);
	    cards.add(tourDemis, DEMIS);
	    cards.add(tourFinale, FINALE);
	    

	    //JPanel tournoi = new JPanel();
	    this.setContentPane(cards);
	    this.setVisible(true);
}

private int getPhase() {
	// TODO retourner 0,1,2 ou 3 en fonction de la phase, autre chose si tournoi non commencé
	return 2;
}

private int getIDTournoi() {
	return 5646;
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
	 

class BoutonSuivantListener implements java.awt.event.ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		//tester le nombre de joueurs
		cl.next(cards);
		
	}
	
}

class BoutonRetourListener implements java.awt.event.ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		cl.previous(cards);
		
	}
}

class BoutonSuiviListener implements java.awt.event.ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		switch(getPhase()) {
		case 0 :
			cl.show(cards,QUALIFS);
			break;
		case 1: 
			cl.show(cards, QUARTS);
			break;
		case 2: 
			cl.show(cards, DEMIS);
			break;
		case 3: 
			cl.show(cards, FINALE);
			break;
		default:
			cl.show(cards, NOUVEAUTOURNOI);
			break;
		}
	}
}

}
