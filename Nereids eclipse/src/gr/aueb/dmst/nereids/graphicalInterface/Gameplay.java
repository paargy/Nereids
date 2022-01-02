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
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

import gr.aueb.dmst.nereids.sound.Sound;
import gr.aueb.dmst.nereids.sound.SoundPlayer;

public class Gameplay {
	private boolean win = false;
	private boolean loose = false;
	static Frame frame = new Frame();
	public static SoundPlayer simpleSoundPlayer;

	public Gameplay() throws InterruptedException {

		// set up the the music
		try {
			simpleSoundPlayer = new SoundPlayer("sound_of_game/CHIPTUNE_Minstrel_Dance.wav");
			simpleSoundPlayer.play();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

		// sound = new Sound(); // sound object to use sound
		clearScreen();
		// intro logo for 4 secs
		Thread intro = new Intro("Intro Screen");
		intro.start();
		intro.join();
		intro.sleep(4000); // time waiting in the logo screen in milliseconds
		clearScreen();

		// sound.setFile(0);
		// playMusic(0); // play start music

		// First Screen with start button
		FirstScreen fs = new FirstScreen();

	}

	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();

	}
}
