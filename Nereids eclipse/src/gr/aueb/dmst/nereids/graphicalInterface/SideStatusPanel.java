/*
 * the JPanel used at the screen of the game. 
 * From top to bottom: "Your stats: ", 9 buttons with the amount of each 
 * characteristic, "Your Nereids: " & the names of the chosen nereids.
 * Contains method that changes the background of the button to red.
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.dmst.nereids.commandLine.Score;

public class SideStatusPanel extends JPanel {
	JButton but1, but2, but3, but4, but5, but6, but7, but8, but9;
	public static final Color SeaBlue = new Color(6, 45, 98, 50);

	public SideStatusPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel btnPanel = new JPanel(new GridLayout(15, 1, 10, 6));

		JLabel label = new JLabel("Your Stats: ");
		btnPanel.add(label);
		btnPanel.add(but1 = new JButton("Agility: " + Status.getAgility())); // get name of characteristic: get number
																				// // of the characteristic left
		but1.setForeground(Color.BLACK); // set the color of the button
		btnPanel.add(but2 = new JButton("Organisation: " + Status.getOrganisation()));
		but2.setForeground(Color.BLACK);
		btnPanel.add(but3 = new JButton("Wisdom: " + Status.getWisdom()));
		but3.setForeground(Color.BLACK);
		btnPanel.add(but4 = new JButton("Windlessness " + Status.getWindlessness()));
		but4.setForeground(Color.BLACK);
		btnPanel.add(but5 = new JButton("Wisdom: " + Status.getWisdom()));
		but5.setForeground(Color.BLACK);
		btnPanel.add(but6 = new JButton("Courage: " + Status.getCourage()));
		but6.setForeground(Color.BLACK);
		btnPanel.add(but7 = new JButton("Animal Friendly: " + Status.getAnimalFriendly()));
		but7.setForeground(Color.BLACK);
		btnPanel.add(but8 = new JButton("Orientation: " + Status.getOrientation()));
		but8.setForeground(Color.BLACK);
		btnPanel.add(but9 = new JButton("Justice: " + Status.getJustice()));
		but9.setForeground(Color.BLACK);

		JLabel label2 = new JLabel("Your Nereids: ");
		btnPanel.add(label2);
		btnPanel.add(new JButton(Status.n1.getName()));
		btnPanel.add(new JButton(Status.n2.getName()));
		btnPanel.add(new JButton(Status.n3.getName()));

		JLabel label3 = new JLabel("Score: " + Status.getScore(), SwingConstants.RIGHT); // Score: get Score
		label3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel.add(label3);

		this.add(btnPanel);

	}

	// changes the color of the button to red
	public void changeToRed(int i) {
		assert i > 0 && i < 10; // i should be between 1 and 10

		// set color of button to red
		switch (i) {
		case 1:
			but1.setForeground(Color.RED);
			break;
		case 2:
			but2.setForeground(Color.RED);
			break;
		case 3:
			but3.setForeground(Color.RED);
			break;
		case 4:
			but4.setForeground(Color.RED);
			break;
		case 5:
			but5.setForeground(Color.RED);
			break;
		case 6:
			but6.setForeground(Color.RED);
			break;
		case 7:
			but7.setForeground(Color.RED);
			break;
		case 8:
			but8.setForeground(Color.RED);
			break;
		case 9:
			but9.setForeground(Color.RED);
			break;
		}

	}

}
