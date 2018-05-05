package ig_echiquier;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class BoutonJouerListener implements ActionListener{
	
	
	
	public BoutonJouerListener(JLabel label1, JLabel label2) {
	 String str = label1.getText();
	 label2.setText("Vous avez écrit "+str);
	 
	}

	@Override
	public void jouerUnCoup(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitterPartie(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejouerPartie(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coupSuivant(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
