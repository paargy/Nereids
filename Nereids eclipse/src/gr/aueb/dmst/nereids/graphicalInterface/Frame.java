/**
 * constructs Frame in accordance to our game's 
 * requirements
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Frame extends JFrame {
	public Frame() {
		// make the frame

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(true);
		// put the logo image as frame icon
		ImageIcon image = new ImageIcon("Images/New updated Logo.png");
		this.setIconImage(image.getImage());
	}
	
	// code for asking if sure to close the window
	/*
	 * 
	 * public void windowClosing(WindowEvent e) { int a =
	 * JOptionPane.showConfirmDialog(this, "Are you sure?"); if (a ==
	 * JOptionPane.YES_OPTION) {
	 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } }
	 * 
	 */

}
