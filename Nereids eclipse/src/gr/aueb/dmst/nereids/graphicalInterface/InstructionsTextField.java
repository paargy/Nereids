/*
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
				+ "The game starts with you at the beginning of your trip. You use your pointer keys from \n"
				+ "your keyboard to go up and down. In front of you is the sea, which is divided by three \n"
				+ "paths and each path has its own challenge. During you journey you will have to overcome \n"
				+ "8 challenges, survive and reach your father’s home in Sicilia.\n"
				+ "You use the  pointer key on your keyboard to make your boat move to the higher path. ");
		this.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.setEditable(false);
		
	}

}