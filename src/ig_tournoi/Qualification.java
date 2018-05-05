package ig_tournoi;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Qualification extends JPanel {
	

	public Qualification() {
		JTextArea ta = new JTextArea(getClassement());
		JScrollPane sp = new JScrollPane(ta);
		this.add(sp);
		
	}

	
	public String getClassement() {
		String str = "1er joueur ---- NOM Prenom --- 12 victoires\n";
		str = str + "2eme joueur ---- NOM Prenom --- 10 victoires\n";
		str = str + "3eme joueur ---- NOM Prenom --- 9 victoires\n";
		str = str + "4eme joueur ---- NOM Prenom --- 7 victoires\n";
		str = str + "5eme joueur ---- NOM Prenom --- 6 victoires\n";
		str = str + "6eme joueur ---- NOM Prenom --- 5 victoires\n";
		str = str + "7eme joueur ---- NOM Prenom --- 4 victoires\n";
		str = str + "8eme joueur ---- NOM Prenom --- 4 victoires\n";
		return str;
	}
}
