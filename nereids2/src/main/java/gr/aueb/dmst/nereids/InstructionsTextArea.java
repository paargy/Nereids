package gr.aueb.dmst.nereids;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * text field for instructions with blue background and white letters.
 */

@SuppressWarnings("serial")
public class InstructionsTextArea extends JTextArea {

  /** Constructor. */
  public InstructionsTextArea() {
    this.setText(
        "\n\n" + "This is a strategy game, but luck is also a factor to your winning." 
        + " In the game you will\n"
        + "form a team of 3 nereids, whose goal is to reach their destination by boat.\n"
        + "∙  9 different Nereids are given. Each of them, has different amount of"
        + " characteristics.\n"
        + "Choose wisely 3 of them. \n\n" + "The game starts:\n"
        + "∙  Use the pointer keys to navigate the ship up ↑ and down ↓ \n"
        + "∙  Choose 1 of the 3 difficulties that show up in each of the 8 levels\n"
        + "Each difficulty requires certain amount of the nereids' characteristics." 
        + " Should you have\n"
        + "the characteristics needed,  your score increases,  otherwise it decreases." 
        + "  Having that\n"
        + "the score is not 0, after 8 sets of challenges you reach your father's home in Sicily.\n"
        + "\n" + "Good luck, stay safe!");
    this.setBackground(new Color(6, 45, 98));
    this.setFont(new Font("Tahoma", Font.PLAIN, 18));
    this.setForeground(Color.white);
    this.setEditable(false);
  }
}
