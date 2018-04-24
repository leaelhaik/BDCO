import gui.GUISimulator;
import donnees.Simulateur;
import java.awt.Color;

public class TestSimulateur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
        Simulateur sim = new Simulateur(gui);
       	String coup;
       	coup = sim.lecture();
       	System.out.println("vous avez effectué"+coup);
       	sim.next();
        }

}
