package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.dmst.nereids.commandLine.Score;

public class SideStatusPanel extends JPanel{
	public SideStatusPanel() {
	      this.setBorder(new EmptyBorder(5, 5, 5, 5));
	      JPanel btnPanel = new JPanel(new GridLayout(14, 1, 10, 8));

	      JLabel label = new JLabel("Your Stats: ");
	      btnPanel.add(label);
	      btnPanel.add(new JButton("Agility: " + Status.getAgility())); //get name of characteristic: get number of left 
	      btnPanel.add(new JButton("Organisation: " + Status.getOrganisation()));
	      btnPanel.add(new JButton("Wisdom: " + Status.getWisdom()));
	      btnPanel.add(new JButton("Windlessness " + Status.getWindlessness()));
	      btnPanel.add(new JButton("Wisdom: " + Status.getWisdom()));
	      btnPanel.add(new JButton("Courage: " + Status.getCourage()));
	      btnPanel.add(new JButton("Animal Friendly: " + Status.getAnimalFriendly()));
	      btnPanel.add(new JButton("Justice: " + Status.getJustice()));
	      
	      JLabel label2 = new JLabel("Your Nereids: ");
	      btnPanel.add(label2);
	      btnPanel.add(new JButton(Status.n1.getName()));
	      btnPanel.add(new JButton(Status.n2.getName()));
	      btnPanel.add(new JButton(Status.n3.getName()));
	      
	      JLabel label3 = new JLabel("Score: "+ Status.getScore(), SwingConstants.RIGHT); //Score: get Score
	      label3.setFont(new Font("Tahoma", Font.BOLD, 15));
	      btnPanel.add(label3);
	      
	      this.add(btnPanel);	
		
	}

}
