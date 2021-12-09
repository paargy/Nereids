package gr.aueb.dmst.nereids.graphicalInterface;

import javax.swing.JFrame;

public class Restart {
	public static void restart() throws InterruptedException {
		Gameplay.frame.dispose(); //dispose the old frame  
		Gameplay game = new Gameplay(); //start the game from the beginning
		
	}

}
