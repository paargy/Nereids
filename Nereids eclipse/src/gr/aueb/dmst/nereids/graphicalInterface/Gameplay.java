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
import java.awt.event.WindowEvent;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Gameplay {
	private boolean win = false;
	private boolean loose = false;
	static Frame frame = new Frame();

	public Gameplay() throws InterruptedException {            
	    clearScreen();
		// intro logo for 4 secs
		Thread intro = new Intro("Intro Screen");
		intro.start();
		intro.join();
		intro.sleep(4000); // time waiting in the logo screen in milliseconds
		clearScreen();

		// First Screen with start button
		FirstScreen fs = new FirstScreen();


	}

	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();

	}

}
