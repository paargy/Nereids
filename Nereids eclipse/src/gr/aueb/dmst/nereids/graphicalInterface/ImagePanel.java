package em;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class ImagePanel extends JComponent {
    private Image image;
   
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}