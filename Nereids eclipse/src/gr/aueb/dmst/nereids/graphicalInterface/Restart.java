package gr.aueb.dmst.nereids.graphicalInterface;

import javax.swing.JFrame;
// XXX class not working, not returning to the right place 
public class Restart {
	public static void restart() throws InterruptedException {
		Gameplay.frame.dispose(); //dispose the old frame  
		Gameplay game = new Gameplay(); //start the game from the beginning
		
	}

}
