package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {

	private String nom;
	private int hauteur;
	private int largeur;
	
	private Echiquier echiquier = new Echiquier();
    JButton boutonJouer = new JButton("Jouer un coup");
	
	
	public Fenetre(String nomFenetre, int hauteurFenetre, int largeurFenetre) {
		this.nom=nomFenetre;
		this.hauteur=hauteurFenetre;
		this.largeur=largeurFenetre;
	    this.setTitle(this.nom);
	    this.setSize(this.hauteur, this.largeur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    
	    //Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    //Définition de sa couleur de fond
	    pan.setBackground(Color.BLACK);        
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    
	    //this.setLayout(new BorderLayout());
	    //this.getContentPane().add(boutonJouer, BorderLayout.SOUTH);
	    
	    this.setContentPane(echiquier);               
	    
	    
	    this.setVisible(true);
	  
	    
	    
	}

	
}