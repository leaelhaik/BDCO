import gui.GUISimulator;
import donnees.*;
import java.awt.Color;
import java.sql.*;

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
