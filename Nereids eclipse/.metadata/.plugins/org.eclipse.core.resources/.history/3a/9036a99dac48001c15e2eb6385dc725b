package gameplayScreen;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	public Color Sea_Blue = new Color( 6, 45, 98);
	Color Transp_Sea_Blue = new Color( 6, 45, 98, 50);
	
	public BackgroundPanel() {
		this.setBackground(Transp_Sea_Blue);
	}
	
	 protected void paintComponent(Graphics g) {
		    super.paintComponent(g); 
		    g.setColor(Sea_Blue); 
		    g.drawRect(5,200,1000,2); //first line  
		    g.fillRect(5,200,1000,2);  
		    
		    g.drawRect(5,400,1000,2); //second line  
		    g.fillRect(5,400,1000,2);
		    
		   
		  }

	 public Dimension getPreferredSize() {
	    return new Dimension(600, 600); // appropriate constants
	  }

}
