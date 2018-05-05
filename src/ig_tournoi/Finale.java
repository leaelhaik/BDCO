package ig_tournoi;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Finale extends JPanel{

	
	public Finale() {

		JPanel rencontre1 = new JPanel();
		//Rencontre r1 = new Rencontre(1);
		rencontre1.setLayout(new BoxLayout(rencontre1, BoxLayout.LINE_AXIS));
		rencontre1.add(new JLabel("Rencontre1 : " )); //+ r1.getJoueur("blanc") + " vs " + r1.getJoueur("noir") + "\n"));
		//if (r1.getVainqueur()==null) {
		rencontre1.add(new JLabel(" -- en cours")); 
		//} else {
		//	rencontre1.add(new JLabel("Vainqueur : " + r1.getVainqueur));
		//}
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(rencontre1);
		
		this.add(p,BorderLayout.CENTER);
	}
}
