package ig_tournoi;


import Controleur.NouveauJoueur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.text.DateFormat;
import java.util.ArrayList;

import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InscriptionJoueur extends JPanel {

	private JTextField nom = new JTextField();
	private JTextField prenom = new JTextField();
	private JTextField addr = new JTextField();
	private JTextField JourNaissance = new JTextField();
	private JTextField MoisNaissance = new JTextField();
	private JTextField AnneeNaissance = new JTextField();
	private JButton boutonAjouterJoueur = new JButton("Ajouter un  joueur");
    private JLabel label = new JLabel("");
    private JPanel listeJoueurs = new JPanel();
	private JTextArea inscrits = new JTextArea("Liste des joueurs inscrits : ");
	
	public InscriptionJoueur() {
		
		boutonAjouterJoueur.addActionListener(new BoutonAjouterJoeurListener());
		
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.LINE_AXIS));
		pan1.add(new JLabel("Nom"));
		nom.setPreferredSize(new Dimension(150, 30));
		pan1.add(nom);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
		pan2.add(new JLabel("Prenom"));
		prenom.setPreferredSize(new Dimension(150, 30));
		pan2.add(prenom);
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3, BoxLayout.LINE_AXIS));		
		pan3.add(new JLabel("Adesse Postale"));
		addr.setPreferredSize(new Dimension(150, 30));
		pan3.add(addr);
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BoxLayout(pan4, BoxLayout.LINE_AXIS));		
		pan4.add(new JLabel("Date de naissance (JJ-MM-AAAA)"));
		JourNaissance.setPreferredSize(new Dimension(30, 30));
		pan4.add(JourNaissance);
		MoisNaissance.setPreferredSize(new Dimension(30, 30));
		pan4.add(MoisNaissance);
		AnneeNaissance.setPreferredSize(new Dimension(40, 30));
		pan4.add(AnneeNaissance);
		
		JPanel pan5 = new JPanel();
		pan5.setLayout(new BoxLayout(pan5, BoxLayout.LINE_AXIS));		
		pan5.add(boutonAjouterJoueur);
		
		JPanel pan7 = new JPanel();
		pan7.setLayout(new BoxLayout(pan7, BoxLayout.LINE_AXIS));		
		pan7.add(label);
		
		listeJoueurs.setLayout(new BoxLayout(listeJoueurs, BoxLayout.LINE_AXIS));
		listeJoueurs.add(inscrits);
		
		
		JPanel pan6 = new JPanel();
		pan6.setLayout(new BoxLayout(pan6, BoxLayout.PAGE_AXIS));
		pan6.add(pan1);
		pan6.add(pan2);
		pan6.add(pan3);
		pan6.add(pan4);
		pan6.add(pan5);

		pan6.add(listeJoueurs);
		pan6.add(pan7);
		
		this.add(pan6, BorderLayout.CENTER);
		
		
	}
	
	
	
	
	
	
	
	class BoutonAjouterJoeurListener implements java.awt.event.ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			label.setText("");
			String name = nom.getText();
			String surname = prenom.getText();
			String direction =  addr.getText();
			String day = JourNaissance.getText();
			String month = MoisNaissance.getText();
			String year = AnneeNaissance.getText();
			Calendar c = Calendar.getInstance(); 
			try { 
				c.setLenient(false); 
				c.set( 
						Integer.parseInt(year), 
						Integer.parseInt(month)-1, 
						Integer.parseInt(day)
						); 
				c.getTime(); 
			} 
			catch(Exception iAE) { 
				label.setText("Date de naissance erronée");
				return;
			}
			String birth = year+month+day;
			//Birth est au format attendu par la BD
			
			ajouterJoueur(name, surname, direction, birth);
			
			inscrits.setText(getListeJoueurs().toString());
			
		}

	}
	
	public ArrayList<String> getListeJoueurs() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("Joueurs inscrits :");
		l.add("Joueur1");
		l.add("Joueur2");
		return l;
	}
	
	public boolean ajouterJoueur(String name, String surname, String direction, String birth) {
		//ajouter le joueur à la bd
		/*NouveauJoueur ajout = new NouveauJoueur(name, surname, direction, birth);
		if (ajout.envoyerBD()) {
			//Feedback : le joueur est déjà dans le tournoi!
		} */
		return true;
	}
}
