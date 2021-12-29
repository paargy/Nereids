/**
 * constructs Frame in accordance to our game's 
 * requirements
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame{
	public Frame() {
		// make the frame 
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(true);
		// put the logo image as frame icon 
		ImageIcon image = new ImageIcon("Images/New updated Logo.png");
		this.setIconImage(image.getImage());
			   
		}

}
