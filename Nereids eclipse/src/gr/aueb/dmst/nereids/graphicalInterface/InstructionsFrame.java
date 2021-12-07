package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class InstructionsFrame {
	public InstructionsFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(600, 600);
		frame.setVisible(true);
	    frame.setResizable(true);
	    
	    JLabel label = new JLabel("A DMST student original game 2021", SwingConstants.RIGHT);
	    label.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    frame.add(label, BorderLayout.PAGE_END);
	    
	    InstuctionsPanel panel = new InstuctionsPanel();
	    frame.add(panel);
	    
	    //frame.pack();
	    frame.setVisible(true);
	}

}
