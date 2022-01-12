package gr.aueb.dmst.nereids2;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * constructs Frame in accordance to our game's requirements.
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	/** Constructor. */
	public Frame() {
		// make the frame
		this.setTitle("NEREIDS");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(864, 626);
		this.setVisible(true);
		this.setResizable(false);
		// put the logo image as frame icon
		Icon icon;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/logo/logo.png")));
			this.setIconImage(((ImageIcon) icon).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLocationRelativeTo(null);
	}

	// code for asking if sure to close the window
	/*
	 * 
	 * public void windowClosing(WindowEvent e) { int a =
	 * JOptionPane.showConfirmDialog(this, "Are you sure?"); if (a ==
	 * JOptionPane.YES_OPTION) {
	 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } }
	 */
}
