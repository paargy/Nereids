package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Gameplay {
	public static JFrame frame;
	public Gameplay() throws InterruptedException {
	
		// make the frame 
		frame = new JFrame("Nereids");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(600, 600);
		frame.setVisible(true);
	    frame.setResizable(true);
	  
	    //intro logo for 3 secs
	    Thread intro = new Intro( "Intro Screen");
	    intro.start();
	    intro.join();
	    intro.sleep(3000); // time waiting in the logo screen in milliseconds
	    clearScreen();
	    
	 
	    //First Screen with start button 
	    FirstScreen fs = new FirstScreen();
	    //System.out.println("come on");
	    while (!fs.getIsPressed()) {
	    	assert true;
	    	System.out.println("not pressed");
	    }
	    clearScreen();
	    System.out.println("pressed");
	  
	    //instructions
	    Instructions ins = new Instructions(); 
	    // !!restart on the menu bar must get fixed!!!
	   
	  
	}
	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();
		
	}


}
