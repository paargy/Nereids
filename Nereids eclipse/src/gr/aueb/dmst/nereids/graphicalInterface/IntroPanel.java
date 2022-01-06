package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * displays a frame with a huge logo
 */

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {
	public IntroPanel() {
		JLabel creditLabel = new JLabel("A DMST student original game 2021  ", SwingConstants.RIGHT);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		Gameplay.frame.add(creditLabel, BorderLayout.PAGE_END);
		JLabel logoLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon("res/logo/logo.png");
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(530, 530, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		logoLabel.setIcon(imageIcon);
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(logoLabel);
		this.setBackground(new Color(6, 45, 98));
	}
}
