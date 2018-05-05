package ig_tournoi;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demi extends JPanel {

	public Demi() {
	JPanel rencontre1 = new JPanel();
	//Rencontre r1 = new Rencontre(1);
	rencontre1.setLayout(new BoxLayout(rencontre1, BoxLayout.LINE_AXIS));
	rencontre1.add(new JLabel("Rencontre1 : " )); //+ r1.getJoueurBlanc() + " vs " + r1.getJoeurNoir() + "\n"));
	//if (r1.getVainqueur()==null) {
	rencontre1.add(new JLabel(" -- en cours")); 
	//} else {
	//	rencontre1.add(new JLabel("Vainqueur : " + r1.getVainqueur));
	//}

	JPanel rencontre2 = new JPanel();
	//Rencontre r2 = new Rencontre(2);
	rencontre2.setLayout(new BoxLayout(rencontre2, BoxLayout.LINE_AXIS));
	rencontre2.add(new JLabel("Rencontre2 : " )); //+ r2.getJoueurBlanc() + " vs " + r2.getJoeurNoir() ));
	//if (r2.getVainqueur()==null) {
	rencontre2.add(new JLabel(" -- en cours")); 
	//} else {
	//	rencontre2.add(new JLabel("Vainqueur : " + r2.getVainqueur));
	//}
	
	
	JPanel p = new JPanel();
	p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
	p.add(rencontre1);
	p.add(rencontre2);
	
	this.add(p,BorderLayout.CENTER);
	
	}
	
	
}
