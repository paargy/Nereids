package gr.aueb.dmst.nereids2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;

/**
 * paints images with specific size.
 */

@SuppressWarnings("serial")
public class ImagePanel extends JComponent {

	int width;
	int height;
	Image image;

	/** Constructor. */
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
