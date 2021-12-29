/**
 * starts a gameplay first by showing the Intro logo screen
 * and after 4 seconds change to the FistScreen with the start button 
 * constructs the frame used int he game 
 * has a clearScreen() method, with is used throughout the
 * game to clear the frame, in order to prepare it for a change 
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Gameplay {
	private boolean win = false;
	private boolean loose = false;
	static Frame frame = new Frame();

	public Gameplay() throws InterruptedException {

		// was code for making the frame, now class Frame is used
		/*
		 * // make the frame frame = new JFrame("Nereids");
		 * frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 * frame.setLayout(new BorderLayout()); frame.setSize(600, 600);
		 * frame.setVisible(true); frame.setResizable(true); // put the logo image as
		 * frame icon ImageIcon image = new ImageIcon("Images/New updated Logo.png");
		 * frame.setIconImage(image.getImage());
		 */
		clearScreen();
		// intro logo for 4 secs
		Thread intro = new Intro("Intro Screen");
		intro.start();
		intro.join();
		intro.sleep(4000); // time waiting in the logo screen in milliseconds
		clearScreen();

		// First Screen with start button
		FirstScreen fs = new FirstScreen();

		/*
		 * 
		 * while (!fs.getIsPressed()) { assert true; // just do something until the
		 * button is pressed // tried to find a different way to do it but i couldn't //
		 * XXX find a different way to make it wait, // bc this way it gets overloaded
		 * System.out.println("not pressed"); } clearScreen();
		 * System.out.println("pressed");
		 * 
		 * // instructions Instructions ins = new Instructions(); // XXX restart on the
		 * menu bar must get fixed!!!
		 * 
		 * // code for win - defeat frame if (win) { // XXX win not connected to rest of
		 * the game // XXX 78 to be replaced with the real score Win wf = new Win(78); }
		 * else if (loose) { // XXX DefeatScreen not connected to rest of the game
		 * DefeatScreen ds = new DefeatScreen(); } /* DefeatScreen ds = new
		 * DefeatScreen(); Win wf = new Win(78);
		 */

	}

	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();

	}

}
