package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExecutablePartie extends JFrame implements ActionListener {

	private String nom;
	private int hauteur;
	private int largeur;
	
	private Echiquier echiquier = new Echiquier();
    private JButton boutonJouer = new JButton("Jouer un coup");
    private JButton boutonQuitter = new JButton("Quitter la partie");
    private JTextField coup = new JTextField();
    private JLabel label1 = new JLabel("Votre coup");
    private JLabel label2 = new JLabel("Votre tour");
	
	public ExecutablePartie(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    
	    this.setContentPane(echiquier);  
	    
	  
	    this.setLayout(new BorderLayout());
	    JPanel pan = new JPanel();
	    coup.setPreferredSize(new Dimension(150, 30));
	    pan.add(label1);
	    pan.add(coup);
	    this.add(pan, BorderLayout.SOUTH);
	    
	    pan.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    pan.add(boutonJouer);
	    pan.add(boutonQuitter);
	    this.add(pan,BorderLayout.SOUTH);
	    
	    boutonJouer.addActionListener(null);

	    label2.setHorizontalAlignment(JLabel.CENTER);
	    this.add(label2, BorderLayout.NORTH);
	    
	    this.setVisible(true);
	  
	    
	    
	}


	@Override
	public void jouerUnCoup(int PosxDep, int PosyDep, int PostxFin, int PosyFin) {
		// trucs graphiques associés pour recojnnaitre l'appui sur le bouton
		//controleur.verifierCoup(int PosxDep, int PosyDep, int PostxFin, int PosyFin);
		//afficher_coup();
		 String str = this.label1.getText();
		 label2.setText("Vous avez écrit "+str);
	}


	@Override
	public void quitterPartie() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void rejouerPartie() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void coupSuivant() {
		// TODO Auto-generated method stub
		
	}

	
	
	private void afficher_coup() {
		// TODO Peut etre voir pour associer un controleur...
		// en fonction des resultats de la verif, on affiche le nouvel echequier et/ou on affiche un texte
	}
	
}