package ig_tournoi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quart extends JPanel {
	
	public Quart() {
		
		JPanel rencontre1 = new JPanel();
		//Rencontre r1 = new Rencontre(1);
		rencontre1.setLayout(new BoxLayout(rencontre1, BoxLayout.LINE_AXIS));
		rencontre1.add(new JLabel("Rencontre1 : " )); //+ r1.getJoueur("blanc") + " vs " + r1.getJoueur("noir") + "\n"));
		//if (r1.getVainqueur()==null) {
		rencontre1.add(new JLabel(" -- en cours")); 
		//} else {
		//	rencontre1.add(new JLabel("Vainqueur : " + r1.getVainqueur));
		//}

		JPanel rencontre2 = new JPanel();
		//Rencontre r2 = new Rencontre(2);
		rencontre2.setLayout(new BoxLayout(rencontre2, BoxLayout.LINE_AXIS));
		rencontre2.add(new JLabel("Rencontre2 : " )); //+ r2.getJoueur("blanc") + " vs " + r2.getJoueur("noir") ));
		//if (r2.getVainqueur()==null) {
		rencontre2.add(new JLabel(" -- en cours")); 
		//} else {
		//	rencontre2.add(new JLabel("Vainqueur : " + r2.getVainqueur));
		//}
		
		JPanel rencontre3 = new JPanel();
		//Rencontre r3 = new Rencontre(3);
		rencontre3.setLayout(new BoxLayout(rencontre3, BoxLayout.LINE_AXIS));
		rencontre3.add(new JLabel("Rencontre3 : " )); //+ r3.getJoueur("blanc") + " vs " + r3.getJoueur("noir") ));
		//if (r3.getVainqueur()==null) {
		rencontre3.add(new JLabel(" -- en cours")); 
		//} else {
		//	rencontre3.add(new JLabel("Vainqueur : " + r3.getVainqueur));
		//}

		JPanel rencontre4 = new JPanel();
		//Rencontre r4 = new Rencontre(4);
		rencontre4.setLayout(new BoxLayout(rencontre4, BoxLayout.LINE_AXIS));
		rencontre4.add(new JLabel("Rencontre4 : " )); //+ r4.getJoueur("blanc")+ " vs " + r4.getJoueur("noir")) ));
		//if (r4.getVainqueur()==null) {
		rencontre4.add(new JLabel(" -- en cours")); 
		//} else {
		//	rencontre4.add(new JLabel("Vainqueur : " + r4.getVainqueur));
		//}
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(rencontre1);
		p.add(rencontre2);
		p.add(rencontre3);
		p.add(rencontre4);
		
		this.add(p,BorderLayout.CENTER);
		
	}
	
}
