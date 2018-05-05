package ig_echiquier;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartieEnCours extends JPanel {

	private JButton boutonJouer = new JButton("Jouer un coup");
    private JButton boutonQuitter = new JButton("Quitter la partie");
    private JTextField coup = new JTextField();
    private JLabel label1 = new JLabel("Votre coup");
    private JLabel label2 = new JLabel("Votre tour");
    private Echiquier echiquier = new Echiquier();
    
    
    public PartieEnCours() {
    	
    	this.setLayout(new BorderLayout());
    	this.add(echiquier, BorderLayout.CENTER);
    	
    	boutonJouer.addActionListener(new BoutonJouerListener());
	    boutonQuitter.addActionListener(new BoutonQuitterListener());
	    
	    
	    JPanel south = new JPanel();
	    coup.setPreferredSize(new Dimension(150, 30));
	    south.add(coup);
	    south.add(label1);
	    south.add(boutonJouer);
	    south.add(boutonQuitter);
	   	this.add(south, BorderLayout.SOUTH);
	    
	    this.add(label2, BorderLayout.NORTH);
	    
	    
	   	
    }
    
    
    
    class BoutonJouerListener implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
	    	 String str = coup.getText();
		     label2.setText("Vous avez écrit "+str);
			
		}
		
	}
	
	
	class BoutonQuitterListener implements java.awt.event.ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			label2.setText("Vous avez abandonné la partie");
			
		}
		
		
	}
	
}
