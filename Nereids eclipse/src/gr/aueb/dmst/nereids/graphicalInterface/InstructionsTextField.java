/**
 * panel for instructions
 * blue background
 * text area with instructions
 * button for next
 * */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InstructionsTextField extends JTextArea{
	public InstructionsTextField() {
		// XXX instructions: to be changed
		this.setText("This is a strategy game, but luck is also a factor to your winning. In the game you will \n"
				+ "form a team of 3 nereids, whose goal is to reach their destination by boat. You will \n"
				+ "choose from 9 different Nereids, all of which have different skills and stats. For example, \n"
				+ "some are better at navigation while others are wiser or stronger. During your trip you will \n"
				+ "come across some challenges, you will have to decide where to direct your ship to and \n"
				+ "chose what difficulty you will have to face. \n"
				+ "\n"
				+ "The game starts with you at the beginning of your trip. On the right side of the screen is the sea, \n"
				+ "which is divided by three paths and each path has its own challenge. Click on the path which involves \n"
				+ "the challenge you want to face. During your journey you will have to overcome 8 challenges, survive \n"
				+ "and reach your father’s home in Sicilia. \n"
				+ "Good Luck, stay safe!");
		this.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.setEditable(false);

	}

}
