package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private JComboBox<String> choixRencontre = new JComboBox<String>();
	private JLabel label = new JLabel("Selectionnez vote rencontre");
	private JPanel rencontre = new JPanel();

	public Menu(int n) {
		
		JPanel top = new JPanel();
		top.add(label);
		for (int i=1; i<=n; i++) {
			choixRencontre.addItem("Rencontre "+i);
		}
		choixRencontre.addActionListener(new ChoixRencontreListener());
		top.add(choixRencontre);
		this.add(top, BorderLayout.NORTH);
		this.add(rencontre,BorderLayout.CENTER);
		

	}
	
	class ChoixRencontreListener implements java.awt.event.ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			//Rencontre r = new Rencontre(idRencontre);
			rencontre.setLayout(new BoxLayout(rencontre, BoxLayout.LINE_AXIS));
			rencontre.add(new JLabel("Rencontre : " )); //+ r.getJoueur("blanc") + " vs " + r.getJoueur("noir") + "\n"));
			//if (r1.getVainqueur()==null) {
			rencontre.add(new JLabel(" -- en cours")); 
			//} else {
			//	rencontre.add(new JLabel("Vainqueur : " + r.getVainqueur));
			//}
			
		}
		
	}
	

	
	
}
