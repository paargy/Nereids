package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InstuctionsPanel extends JPanel implements ActionListener{
	public Color SeaBlue = new Color( 6, 45, 98);
	public InstuctionsPanel() {
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		JLabel label = new JLabel("Instructions");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(label, c);
		
		

		JLabel label1 = new JLabel("");
		c.gridx = 1;
		c.gridy = 0;
		pane.add(label1, c);
		
		
		JLabel label2 = new JLabel("");
		label2.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 2;
		c.gridy = 0;
		pane.add(label2, c);
		
		//label.setHorizontalAlignment(JLabel.CENTER);
		//pane.add(label);
		
		InstructionsTextField textField = new InstructionsTextField();
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(textField, c);
		//pane.add(textField);
		
		JButton button = new JButton("Next");
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		//c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		pane.add(button, c);
		button.addActionListener(this); 
		
		pane.setBackground(SeaBlue);
		this.setBackground(SeaBlue);
		this.add(pane);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("should go to player choise frame");
		Gameplay.clearScreen();
		
	}

}
