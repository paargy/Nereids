package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoatPanel extends JPanel {
	public Color SeaBlue = new Color( 6, 45, 98, 50);
	public BoatPanel() {

		
		//this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		JLabel label = new JLabel("");
		
		//label.setIcon(new ImageIcon("/Users/paraskeviarg/Documents/DMST/3ο εξάμηνο /Prog 2/Nereids eclipse/img/sailboatGraphic.png"));
		///Users/paraskeviarg/git/myTestRepo/Nereids eclipse/img/sailboatGraphic.png
		///Users/paraskeviarg/git/myTestRepo/Nereids eclipse/src/gr/aueb/dmst/nereids/graphicalInterface/gameplayScreenMain.java
		label.setIcon(new ImageIcon("Images/sailboatGraphic.png"));
		//System.out.println(new java.io.File("Images/sailboatGraphic.png").exists()); //checks if file exists
		//label.setIcon(new ImageIcon("/Users/paraskeviarg/git/myTestRepo/Nereids eclipse/img/sailboatGraphic.png")); //local pathname
		  
		this.setLayout(new GridBagLayout());
		this.setBackground(SeaBlue);
		this.add(label);
		  
		
	
	}

}

