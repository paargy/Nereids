/**
 * A JOption Pane informing about the level,
 * the difficulty chosen, the characteristics needed 
 * for the difficulty to be faced, the existing characteristics
 * and the score.
 * 
 * Level: ...
 * You chose: ...
 * Score increased/decreased by 1/2
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gr.aueb.dmst.nereids.commandLine.Difficulty;

public class OptionPane {
	public OptionPane(int level, Difficulty dif) {
		String s;
		ImageIcon icon = null;
		// choose the right image
		if (dif.getName() == "rocks") {
			icon = new ImageIcon("Images/rocks.png");
		} else if (dif.getName() == "swell") {
			icon = new ImageIcon("Images/swell.png");
		} else if (dif.getName() == "pirates") {
			icon = new ImageIcon("Images/pirates.png");
		} else if (dif.getName() == "wind") {
			icon = new ImageIcon("Images/wind.png");
		} else if (dif.getName() == "sea_animals") {
			icon = new ImageIcon("Images/sea_animals.png");
		} else if (dif.getName() == "storm") {
			icon = new ImageIcon("Images/storm.png");
		} else if (dif.getName() == "conflict") {
			icon = new ImageIcon("Images/conflict.png");
		} else if (dif.getName() == "disorientation") {
			icon = new ImageIcon("Images/disorientation.png");
		}
		
		// resize it to 180 x 150
		icon = resize(icon, 180, 150);
		JLabel label = new JLabel(icon);
		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(label);
		JPanel textPanel = new JPanel(new GridLayout(3, 1));
		
		textPanel.setFont(new Font("Tahoma", Font.BOLD, 19));
		textPanel.add(new JLabel("LEVEL " + level + " "));
		textPanel.add(new JLabel("You chose: " + dif.getName() + " "));
		textPanel.add(new JLabel( "SCORE: " + Status.getScore() + " "));
		
					
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(textPanel);
		panel2.add(panel, BorderLayout.EAST);
		JOptionPane.showMessageDialog(null, panel2, "Face Difficulty", JOptionPane.DEFAULT_OPTION);


	}
	/**
	 * returns the given image with the specific ordered size 
	 * taken from: 
	 * http://www.java2s.com/example/java-utility-method/imageicon-resize/resize-imageicon-image-int-width-int-height-5ce1d.html
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	public static ImageIcon resize(ImageIcon image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(//  ww  w  . jav  a2 s. c o m
                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }

}
