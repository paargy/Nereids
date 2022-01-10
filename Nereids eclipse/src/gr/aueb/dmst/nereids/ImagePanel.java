package gr.aueb.dmst.nereids;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ImagePanel extends JComponent {

	int width;
	int height;
	Image image;

	public ImagePanel(Image image, int width, int height) {
		this.image = image;
		this.width = width;
		this.height = height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, width, height, this);
	}
}