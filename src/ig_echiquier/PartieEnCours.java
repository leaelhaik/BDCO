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
    private JTextField coup = new JTextField();
    private JLabel label1 = new JLabel("Votre coup");
    private JLabel label2 = new JLabel("Votre tour");
    private Echiquier echiquier = new Echiquier();
    
    
    public PartieEnCours() {
    	
    	this.setLayout(new BorderLayout());
    	this.add(echiquier, BorderLayout.CENTER);
    	
    	boutonJouer.addActionListener(new BoutonJouerListener());
	    
	    
	    JPanel south = new JPanel();
	    coup.setPreferredSize(new Dimension(150, 30));
	    south.add(label1);
	    south.add(coup);
	    south.add(boutonJouer);
	   	this.add(south, BorderLayout.SOUTH);
	    
	    this.add(label2, BorderLayout.NORTH);
	    
	    
	   	
    }
    
    
    
    class BoutonJouerListener implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

		    String str = coup.getText().toUpperCase().replaceAll(" ", "");
		    /*Vérification textuelle du coup*/
		    if(str.length() != 4){
				 //La longueur doit être de 4 charctères
				 label2.setText("Coup incorrect.");
				 return;
		    }
			char coordOldX = str.substring(0,1).charAt(0);
			if(coordOldX < 65 || coordOldX > 72){
				 //Doit être compris entre A et H
				 label2.setText("Coup incorrect.");
				 return;
			 }
			char coordOldY = str.substring(1,2).charAt(0);
			if(coordOldY < 48 || coordOldY > 56){
				 //Doit être compris entre 1 et 8
				 label2.setText("Coup incorrect.");
				 return;
			 }
			char coordNewX = str.substring(2,3).charAt(0);
			if(coordNewX < 65 || coordNewX > 72){
				 //Doit être compris entre A et H
				 label2.setText("Coup incorrect.");
				 return;
			 }
			char coordNewY = str.substring(3,4).charAt(0);
			if(coordNewY < 49 || coordNewY > 56){
				 //Doit être compris entre 1 et 8
				 label2.setText("Coup incorrect.");
				 return;
			 }
		    /*Fin de la vérification textuelle du coup*/
			
		    label2.setText("Vous avez joué "+ str);
		    
		}
	}	
}
