package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinFrame {
	private static JFrame win_frame;

	public WinFrame() {

		JLabel label = new JLabel();// create a label
		label.setText("SCORE :");// set text of label

		JLabel label2 = new JLabel();

		JLabel label3 = new JLabel();

		win_frame = new JFrame(); // creates a frame of win
		win_frame.setTitle("Nereids");// sets title of win frame
		win_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exits out of application
		win_frame.setSize(600, 600); // sets the x-dimension, and y-dimension
		win_frame.setVisible(true); // makes frame visible
		win_frame.setResizable(false);// prevent frame from being resized

		ImageIcon image = new ImageIcon("logo!.jpg");// crate an image icon
		win_frame.setIconImage(image.getImage());// change icon of frame
		win_frame.getContentPane().setBackground(new Color(6, 45, 98));// change color of background
		// in new Color(0,0,0) the 1st is the amount of red (most 225), the 2nd the
		// amount of green and the 3rd of blue
		// or new Color(0x123456)-search from Google

		ImageIcon image2 = new ImageIcon("congrats!!.png");
		ImageIcon image3 = new ImageIcon("confetti!!.gif");
		ImageIcon image4 = new ImageIcon("conf.gif");

		win_frame.add(label);
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

		win_frame.add(label2);
		win_frame.setLayout(null);
		label2.setIcon(image3);
		label2.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label2.setHorizontalAlignment(JLabel.RIGHT);// set horizontal position of icon+text within label
		label2.setBackground(new Color(6, 45, 98));
		label2.setOpaque(true);
		label2.setBounds(20, 263, 300, 300);

		win_frame.add(label3);
		win_frame.setLayout(null);
		label3.setIcon(image4);
		label3.setVerticalAlignment(JLabel.BOTTOM);// set vertical position of icon+text within label
		label3.setHorizontalAlignment(JLabel.LEFT);// set horizontal position of icon+text within label
		label3.setBackground(new Color(6, 45, 98));
		label3.setOpaque(true);
		label3.setBounds(270, 263, 300, 300);

	}
}
