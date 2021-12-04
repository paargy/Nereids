/*
 * displays a frame with a huge logo
 */

package introScreen;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroPanel extends JPanel{
	public Color SeaBlue = new Color( 6, 45, 98);
	public IntroPanel() {
		JLabel label = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("./img/NereidsLogo.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(580, 580,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		label.setIcon(imageIcon);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
		this.setBackground(SeaBlue);
	}

}
