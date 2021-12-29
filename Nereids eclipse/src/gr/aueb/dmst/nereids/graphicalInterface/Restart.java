/**
 * class used to restart the game. Disposes every frame and 
 * creates a FirstScreen object. Returns the control of the programm
 * at the FirstScreen.
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

//import gr.aueb.dmst.nereids.graphicalInterface.PlayerChoice.ImagePanel;

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
		/*
		 * set a blue image as background 
		 * in order to cover the PlayerChoice Background
		 */
	
		try {
			Image back = ImageIO.read(new File("Images/blueBackground.png"));
			Gameplay.frame.setContentPane(new ImagePanel(back));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// start again from the first screen with the start button
		FirstScreen fs = new FirstScreen();
	}
	static class ImagePanel extends JComponent {
		private Image image;

		public ImagePanel(Image image) {
			this.image = image;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

}



