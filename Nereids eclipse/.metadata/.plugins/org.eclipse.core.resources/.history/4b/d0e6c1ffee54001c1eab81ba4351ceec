package firstScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FSPanel extends JPanel{
	public Color SeaBlue = new Color( 6, 45, 98);
	public FSPanel() {
		
		//this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		JLabel label = new JLabel("");
		
		/*
		label.setIcon(new ImageIcon("./img/NereidsLogo.png"));
		//label.setIcon(new ImageIcon("../img/NereidsLogo.png"));  */
		
		this.setLayout(new GridLayout(3,1));
		
		ImageIcon imageIcon = new ImageIcon("./img/NereidsLogo.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		label.setIcon(imageIcon);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		
		this.setBackground(SeaBlue);
		
		this.setBackground(SeaBlue);
		this.add(label);
		
		JLabel nlabel = new JLabel("NEREIDS ®");
		nlabel.setForeground(Color.WHITE);
		nlabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		nlabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel butpanel = new JPanel();
		butpanel.setLayout(new GridLayout(1,3));
		
		butpanel.add(new JLabel(""));
		JButton start = new JButton("PLAY");
		butpanel.add(start);
		butpanel.add(new JLabel(""));
		butpanel.setBackground(SeaBlue);
		
		this.add(butpanel);
		
		
		this.add(nlabel);	  
		  
	}
}
