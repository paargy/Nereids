package gr.aueb.dmst.nereids.graphicalInterface;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * constructs Frame in accordance to our game's requirements
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame() {
		// make the frame
		this.setTitle("NEREIDS");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(864, 576);
		this.setVisible(true);
		this.setResizable(false);
		// put the logo image as frame icon
		ImageIcon image = new ImageIcon("res/logo/logo.png");
		this.setIconImage(image.getImage());
		this.setLocationRelativeTo(null);
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
