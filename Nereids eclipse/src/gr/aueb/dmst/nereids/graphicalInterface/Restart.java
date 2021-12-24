package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Window;

import javax.swing.JFrame;

// XXX class not working, not returning to the right place 
public class Restart {
	public static void restart() throws InterruptedException {

		Gameplay.clearScreen();
		Gameplay.frame.dispose();

		// get an array of all opened frames and dispose each of them
		Window[] frames = Window.getWindows();
		for (int i = 0; i < frames.length; i++) {
			frames[i].repaint();
			frames[i].dispose();
		}
		// start again from the first screen with the start button
		FirstScreen fs = new FirstScreen();
	}

}
