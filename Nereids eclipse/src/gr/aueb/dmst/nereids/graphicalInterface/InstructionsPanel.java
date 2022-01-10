package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Extends JPanel an constructs the panel used from Instructions dark blue
 * background, label "Instructions" on top, text box with instructions, button
 * "next"
 */

@SuppressWarnings("serial")
public class InstructionsPanel extends JPanel {
	public Color SeaBlue = new Color(6, 45, 98);
	JButton nextButton;

	public InstructionsPanel(JButton nextButton) {
		this.nextButton = nextButton;
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel label = new JLabel("INSTRUCTIONS");
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setForeground(Color.WHITE); // set color to white
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(label, c);

		JLabel label1 = new JLabel();
		c.gridx = 1;
		c.gridy = 0;
		pane.add(label1, c);

		JLabel label2 = new JLabel();
		label2.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 2;
		c.gridy = 0;
		pane.add(label2, c);

		InstructionsTextArea iField = new InstructionsTextArea();
		c.ipady = 110; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(iField, c);

		c.ipady = 0; // reset to default
		c.weighty = 0.5; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 2; // third row
		pane.add(nextButton, c);

		pane.setBackground(SeaBlue);
		this.setBackground(SeaBlue);
		this.add(pane);
	}
}
