package ig_echiquier;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartieTerminee extends JPanel {

	private JButton boutonSuivant = new JButton("Coup suivant");
    private JButton boutonRevoir = new JButton("Revoir la partie");
    private JLabel label2 = new JLabel("Votre tour");
    private Echiquier echiquier = new Echiquier();
    
    public PartieTerminee() {
    	
    	
    	this.setLayout(new BorderLayout());
    	this.add(echiquier, BorderLayout.CENTER);
    	
    	boutonSuivant.addActionListener(new BoutonSuivantListener());
	    boutonRevoir.addActionListener(new BoutonRevoirListener());
	    
	    
	    JPanel south = new JPanel();
	    south.add(boutonSuivant);
	    south.add(boutonRevoir);
	   	this.add(south, BorderLayout.SOUTH);
	    
	    this.add(label2, BorderLayout.NORTH);
	    
	    
	   	
    }
    
    
    
    class BoutonSuivantListener implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		     label2.setText("Vous avez cliqué sur suivant");
			
		}
		
	}
	
	
	class BoutonRevoirListener implements java.awt.event.ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			label2.setText("Remise à zéro");			
		}
		
		
	}
	
	
	
}
