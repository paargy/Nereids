package gr.aueb.dmst.nereids2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * displays a frame with a huge logo.
 */

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {

	/** Constructor. */
	public IntroPanel(JFrame frame) {
		JLabel creditLabel = new JLabel("A DMST student original game 2021  ", SwingConstants.RIGHT);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.add(creditLabel, BorderLayout.PAGE_END);
		JLabel logoLabel = new JLabel();

		Image image;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/logo/logo.png"));
			Image newimg = image.getScaledInstance(530, 530, java.awt.Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(newimg); // transform it back
			logoLabel.setIcon(imageIcon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(logoLabel);
		this.setBackground(new Color(6, 45, 98));
	}
}
