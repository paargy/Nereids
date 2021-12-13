package gameplayScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundButtons extends JPanel implements ActionListener{
	public Color SeaBlue = new Color( 6, 45, 98, 50);
	public Color DarkSeaBlue = new Color( 6, 45, 98);
	GridLayout grid = new GridLayout(3,1);
	JButton button1, button2, button3;
	
	public BackgroundButtons() {
		
		
		
		
		button1 = new JButton("DifficultyName1");
		button1.setBackground(SeaBlue);
		button1.setOpaque(true);
		button1.setForeground(DarkSeaBlue);
		button1.setFont(new Font("Tahoma", Font.BOLD, 19));
		button1.addActionListener(this);
		
		
		button2 = new JButton("DifficultyName2");
		button2.setBackground(SeaBlue);
		button2.setOpaque(true);
		button2.setForeground(DarkSeaBlue);
		button2.setFont(new Font("Tahoma", Font.BOLD, 19));
		button2.addActionListener(this);
		
		button3 = new JButton("DifficultyName3");
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
			System.out.println("but1");
		}else if (obj == button2) {
			System.out.println("button 2");
		}else if (obj == button3) {
			System.out.println("but 3");
		}
	
	}

}
