package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.ControlleurPhase;

public class Menu extends JPanel {
	private JComboBox<String> choixRencontre = new JComboBox<String>();
	private JLabel label = new JLabel("Selectionnez vote rencontre");
	private JPanel rencontre = new JPanel();
	private JPanel page = new JPanel();
	private int idRencontre;
	private JLabel labelRencontre = new JLabel("Rencontre n°1 - Machin contre truc");
	private JLabel labelStatut = new JLabel(" --- en cours");
	private String nomTour;
	
	
	public Menu(int n) {
		
		
		idRencontre=1;
		//premiere rencontre de l aliste idRencontre=listRencontres.first();
		ControlleurPhase cp = new ControlleurPhase();
		
		nomTour=cp.getMostAdvanceTour();
		
		JPanel top = new JPanel();
		top.add(label);
		for (int i=1; i<=n; i++) {
			choixRencontre.addItem(""+i);
		}
		
		ChoixRencontreListener ch = new ChoixRencontreListener();
		choixRencontre.addActionListener(ch);
		top.add(choixRencontre);
		
		
		rencontre.setLayout(new BoxLayout(rencontre, BoxLayout.LINE_AXIS));
		rencontre.add(labelRencontre);
		rencontre.add(labelStatut);

		
		
		page.setLayout(new BoxLayout(page,BoxLayout.PAGE_AXIS));

		page.add(top);
		

		page.add(rencontre);
		this.add(page, BorderLayout.CENTER);
		

	}
	
	class ChoixRencontreListener implements java.awt.event.ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			int i = Integer.parseInt(choixRencontre.getSelectedItem().toString());
			setIdRencontre(i);
			labelRencontre.setText("Rencontre n°"+getIdRencontre() +" - Machin contre Truc");
			//if (r1.getVainqueur()==null) {
			labelStatut.setText(" -- en cours"); 
			//} else {
			//	rencontre.add(new JLabel("Vainqueur : " + r.getVainqueur));
			//}
		}
		
	}
	
	
	public int getIdRencontre() {
		return this.idRencontre;
	}
	
	public void setIdRencontre(int i) {
		this.idRencontre = i;
	}
	
	
	

	
	
}
