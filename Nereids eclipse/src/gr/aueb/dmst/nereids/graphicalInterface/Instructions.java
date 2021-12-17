package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Instructions {
	public Instructions() {
		Gameplay.frame.setLayout(new BorderLayout());
		Gameplay.frame.setVisible(true);
	    Gameplay.frame.setResizable(true);
	    
	    JLabel label = new JLabel("A DMST student original game 2021", SwingConstants.RIGHT);
	    label.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    Gameplay.frame.add(label, BorderLayout.PAGE_END);
	    
	    InstuctionsPanel panel = new InstuctionsPanel();
	    Gameplay.frame.add(panel);
	    
	    MenuBar menu = new MenuBar();
	    Gameplay.frame.setJMenuBar(menu);
	    
	    //frame.pack();
	    Gameplay.frame.setVisible(true);
	}
	
	
}