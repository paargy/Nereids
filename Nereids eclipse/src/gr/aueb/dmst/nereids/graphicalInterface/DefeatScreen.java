/**
 * create the frame for defeat 
 * states: oh no, defeat
 * with a gif of a moving boat
 * not independent frame, affects the Gameplay.frame
 * 
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gr.aueb.dmst.nereids.sound.SoundPlayer;

public class DefeatScreen {

	/**
	 * simple constructor. Make Gameplay.frame a defeat frame
	 */
	public DefeatScreen() {
		/*
		 * Gameplay.clearScreen(); JLabel label = new JLabel();// create a label
		 * label.setText("OH NO, DEFEAT :(");// set text of label
		 * Gameplay.frame.add(label); Gameplay.frame.getContentPane().setBackground(new
		 * Color(6, 45, 98));// change color of background // in new Color(0,0,0) the
		 * 1st is the amount of red (most 225), the 2nd the // amount of green and the
		 * 3rd of blue // or new Color(0x123456)-search from Google ImageIcon image2 =
		 * new ImageIcon("Images/boat.gif"); Gameplay.frame.setVisible(true);
		 * 
		 * label.setIcon(image2); label.setHorizontalTextPosition(JLabel.CENTER);// set
		 * text LEFT, CENTER, RIGHT of imageicon
		 * label.setVerticalTextPosition(JLabel.TOP);// set text TOP,CENTER, OR BOTOOM
		 * of imageicon label.setForeground(new Color(240,128,128));// set color of the
		 * text label.setFont(new Font("Tahoma", Font.BOLD, 20));// set font of text
		 * label.setIconTextGap(100);// set gap of text to image
		 * label.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of
		 * icon+text within label label.setHorizontalAlignment(JLabel.CENTER);// set
		 * horizontal position of icon+text within label label.setBackground(new
		 * Color(6, 45, 98)); label.setOpaque(true); label.setBounds(75, 0, 440, 320);
		 * 
		 */

		// stop any sound playing
	
		Gameplay.simpleSoundPlayer.pause();
		// play sound for defeat
		try {
			Gameplay.simpleSoundPlayer = new SoundPlayer("sound_of_game/negative_beeps-6008.wav");
			Gameplay.simpleSoundPlayer.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

		Gameplay.clearScreen();
		JLabel label = new JLabel();// create a label
		label.setText("OH NO, DEFEAT :(");// set text of label

		Gameplay.frame.setVisible(true); // makes frame visible
		Gameplay.frame.setResizable(false);// prevent frame from being resized

		ImageIcon image = new ImageIcon("Images/logo!.jpg");// crate an image icon
		Gameplay.frame.setIconImage(image.getImage());// change icon of frame
		Gameplay.frame.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google
		ImageIcon image2 = new ImageIcon("Images/boat.gif");
		Gameplay.frame.add(label);
		label.setIcon(image2);
		label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP);// set text TOP,CENTER, OR BOTOOM of imageicon
		label.setForeground(new Color(240, 128, 128));// set color of the text
		label.setFont(new Font("Tahoma", Font.BOLD, 20));// set font of text
		label.setIconTextGap(100);// set gap of text to image
		label.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);// set horizontal position of icon+text within label
		label.setBackground(new Color(6, 45, 98));
		label.setOpaque(true);
		label.setBounds(75, 0, 440, 320);

	}

	/**
	 * constructor for defeat screen. Make any given frame defeat frame
	 * @param fr
	 */
	public DefeatScreen(JFrame fr) {
		// stop any sound playing
		Gameplay.simpleSoundPlayer.pause();
		// play sound for defeat
		try {
			Gameplay.simpleSoundPlayer = new SoundPlayer("sound_of_game/negative_beeps-6008.wav");
			Gameplay.simpleSoundPlayer.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		fr.getContentPane().removeAll();
		JLabel label = new JLabel();// create a label
		label.setText("OH NO, DEFEAT :(");// set text of label

		fr.setVisible(true); // makes frame visible
		Gameplay.frame.setResizable(false);// prevent frame from being resized

		ImageIcon image = new ImageIcon("Images/logo!.jpg");// crate an image icon
		fr.setIconImage(image.getImage());// change icon of frame
		fr.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google
		ImageIcon image2 = new ImageIcon("Images/boat.gif");
		fr.add(label);
		label.setIcon(image2);
		label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP);// set text TOP,CENTER, OR BOTOOM of imageicon
		label.setForeground(new Color(240, 128, 128));// set color of the text
		label.setFont(new Font("Tahoma", Font.BOLD, 20));// set font of text
		label.setIconTextGap(100);// set gap of text to image
		label.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);// set horizontal position of icon+text within label
		label.setBackground(new Color(6, 45, 98));
		label.setOpaque(true);
		label.setBounds(75, 0, 440, 320);

	}
}