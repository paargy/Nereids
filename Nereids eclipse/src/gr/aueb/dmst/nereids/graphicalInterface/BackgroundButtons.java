package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundButtons extends JPanel implements ActionListener{
	public Color SeaBlue = new Color( 6, 45, 98, 50);
	public Color DarkSeaBlue = new Color( 6, 45, 98);
	GridLayout grid = new GridLayout(3,1);
	JButton button1, button2, button3;
	
	public BackgroundButtons() {
		button1 = new JButton(Status.d1.getName());
		button1.setBackground(SeaBlue);
		button1.setOpaque(true);
		button1.setForeground(DarkSeaBlue);
		button1.setFont(new Font("Tahoma", Font.BOLD, 19));
		button1.addActionListener(this);
		
		
		button2 = new JButton(Status.d2.getName());
		button2.setBackground(SeaBlue);
		button2.setOpaque(true);
		button2.setForeground(DarkSeaBlue);
		button2.setFont(new Font("Tahoma", Font.BOLD, 19));
		button2.addActionListener(this);
		
		button3 = new JButton(Status.d3.getName());
		button3.setBackground(SeaBlue);
		button3.setOpaque(true);
		button3.setForeground(DarkSeaBlue);
		button3.setFont(new Font("Tahoma", Font.BOLD, 19));
		button3.addActionListener(this);
		
		this.add(button3);
		this.add(button2);
		this.add(button1);
		this.setSize(300, 300);    
		this.setVisible(true);  
		this.setLayout(grid);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == button1) {
			Status.setDifChoice(1);
			System.out.println("Level No: " + Status.getLevel() + ". You chose " + Status.d1.getName());
			FaceDifficulty.faceDifficulty(Status.d1);
			// choose the 1st difficulty 
			
		}else if (obj == button2) {
			// choose the 2nd difficulty
			System.out.println("Level No: " + Status.getLevel() + ". You chose " + Status.d2.getName());
			Status.setDifChoice(2);
			FaceDifficulty.faceDifficulty(Status.d2);
		}else if (obj == button3) {
			// choose the 3rd difficulty 
			System.out.println("Level No: " + Status.getLevel() + ". You chose " +Status.d3.getName());
			Status.setDifChoice(3);
			FaceDifficulty.faceDifficulty(Status.d3);
		}
		
		if (Status.getLevel() < 8) {
			Status.setLevel(Status.getLevel() + 1);
			//CheckCharacteristics.checkCharacteristics();
			// XXX 
			//Status.Status(3, 4, 5);
			BoatFrame fr = new BoatFrame();
		} else {
			// XXX code for win or defeat
		}
	
	}

}
