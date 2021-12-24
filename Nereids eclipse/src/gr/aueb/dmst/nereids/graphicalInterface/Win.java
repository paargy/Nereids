/* 
 * clear the Gameplay.frame and display the win screen 
 * use when the game ends up with a win 
 * is not an independent frame
 * two constructors: displaying and not displaying the score 
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Win {
	private static JFrame win_frame;
	int s = 0;

	// constructor with no score changing the gameplay.frame
	public Win() {
		Gameplay.clearScreen();
		JLabel label = new JLabel();// create a label
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();

		// ImageIcon image = new ImageIcon("Images/logo!.jpg");// crate an image icon
		// win_frame.setIconImage(image.getImage());// change icon of frame
		Gameplay.frame.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google

		ImageIcon image2 = new ImageIcon("Images/congrats!!.png");
		ImageIcon image3 = new ImageIcon("Images/confetti!!.gif");
		ImageIcon image4 = new ImageIcon("Images/conf.gif");

		Gameplay.frame.add(label);
		label.setIcon(image2);
		label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.BOTTOM);// set text TOP,CENTER, OR BOTOOM of imageicon
		label.setForeground(new Color(145, 255, 230));// set color of the text
		label.setFont(new Font("Tahoma", Font.BOLD, 30));// set font of text
		label.setIconTextGap(-33);// set gap of text to image
		label.setVerticalAlignment(JLabel.TOP);// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);// set horizontal position of icon+text within label
		label.setBackground(new Color(6, 45, 98));
		label.setOpaque(true);
		label.setBounds(75, 0, 440, 320);

		Gameplay.frame.add(label2);
		Gameplay.frame.setLayout(null);
		label2.setIcon(image3);
		label2.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label2.setHorizontalAlignment(JLabel.RIGHT);// set horizontal position of icon+text within label
		label2.setBackground(new Color(6, 45, 98));
		label2.setOpaque(true);
		label2.setBounds(20, 263, 300, 300);

		Gameplay.frame.add(label3);
		Gameplay.frame.setLayout(null);
		label3.setIcon(image4);
		label3.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label3.setHorizontalAlignment(JLabel.LEFT);// set horizontal position of icon+text within label
		label3.setBackground(new Color(6, 45, 98));
		label3.setOpaque(true);
		label3.setBounds(270, 263, 300, 300);

	}

	// constuctor to display the score as well, changing the Gameplay.frame
	public Win(int score) {
		s = score;
		Gameplay.clearScreen();

		JLabel label = new JLabel();// create a label
		label.setText("SCORE: " + s);// set text of label
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();

		// ImageIcon image = new ImageIcon("Images/logo!.jpg");// crate an image icon
		// win_frame.setIconImage(image.getImage());// change icon of frame
		Gameplay.frame.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google

		ImageIcon image2 = new ImageIcon("Images/congrats!!.png");
		ImageIcon image3 = new ImageIcon("Images/confetti!!.gif");
		ImageIcon image4 = new ImageIcon("Images/conf.gif");

		Gameplay.frame.add(label);
		label.setIcon(image2);
		label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.BOTTOM);// set text TOP,CENTER, OR BOTOOM of imageicon
		label.setForeground(new Color(145, 255, 230));// set color of the text
		label.setFont(new Font("Tahoma", Font.BOLD, 30));// set font of text
		label.setIconTextGap(-33);// set gap of text to image
		label.setVerticalAlignment(JLabel.TOP);// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);// set horizontal position of icon+text within label
		label.setBackground(new Color(6, 45, 98));
		label.setOpaque(true);
		label.setBounds(75, 0, 440, 320);

		Gameplay.frame.add(label2);
		Gameplay.frame.setLayout(null);
		label2.setIcon(image3);
		label2.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label2.setHorizontalAlignment(JLabel.RIGHT);// set horizontal position of icon+text within label
		label2.setBackground(new Color(6, 45, 98));
		label2.setOpaque(true);
		label2.setBounds(20, 263, 300, 300);

		Gameplay.frame.add(label3);
		Gameplay.frame.setLayout(null);
		label3.setIcon(image4);
		label3.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label3.setHorizontalAlignment(JLabel.LEFT);// set horizontal position of icon+text within label
		label3.setBackground(new Color(6, 45, 98));
		label3.setOpaque(true);
		label3.setBounds(270, 263, 300, 300);
	}

	/*
	 * constructor for win screen changing any given in the parameters frame
	 * displaying the score
	 */
	public Win(JFrame fr) {
		s = Status.getScore();
		fr.getContentPane().removeAll();

		JLabel label = new JLabel();// create a label
		label.setText("SCORE: " + s);// set text of label
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();

		// ImageIcon image = new ImageIcon("Images/logo!.jpg");// crate an image icon
		// win_frame.setIconImage(image.getImage());// change icon of frame
		fr.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google

		ImageIcon image2 = new ImageIcon("Images/congrats!!.png");
		ImageIcon image3 = new ImageIcon("Images/confetti!!.gif");
		ImageIcon image4 = new ImageIcon("Images/conf.gif");

		fr.add(label);
		label.setIcon(image2);
		label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.BOTTOM);// set text TOP,CENTER, OR BOTOOM of imageicon
		label.setForeground(new Color(145, 255, 230));// set color of the text
		label.setFont(new Font("Tahoma", Font.BOLD, 30));// set font of text
		label.setIconTextGap(-33);// set gap of text to image
		label.setVerticalAlignment(JLabel.TOP);// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);// set horizontal position of icon+text within label
		label.setBackground(new Color(6, 45, 98));
		label.setOpaque(true);
		label.setBounds(75, 0, 440, 320);

		fr.add(label2);
		fr.setLayout(null);
		label2.setIcon(image3);
		label2.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label2.setHorizontalAlignment(JLabel.RIGHT);// set horizontal position of icon+text within label
		label2.setBackground(new Color(6, 45, 98));
		label2.setOpaque(true);
		label2.setBounds(20, 263, 300, 300);

		fr.add(label3);
		fr.setLayout(null);
		label3.setIcon(image4);
		label3.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label3.setHorizontalAlignment(JLabel.LEFT);// set horizontal position of icon+text within label
		label3.setBackground(new Color(6, 45, 98));
		label3.setOpaque(true);
		label3.setBounds(270, 263, 300, 300);

	}

}
