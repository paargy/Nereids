package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Intro extends Thread {
	private Thread t;
	private String threadName;
	public Intro(String name) {
		threadName = name;
		System.out.println("Creating " +  threadName );
	}
	public void run() {
		JLabel label = new JLabel("A DMST student original game 2021", SwingConstants.RIGHT);
	    label.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    Gameplay.frame.add(label, BorderLayout.PAGE_END);
	  
	    
	    IntroPanel panel = new IntroPanel();
	    Gameplay.frame.add(panel);
	    Gameplay.frame.pack();
	    Gameplay.frame.setVisible(true);
	    Gameplay.frame.setSize(600, 650);
	}
	public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
	        t = new Thread (this, threadName);
	        t.start ();
      }
    }

}