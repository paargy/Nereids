package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
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
	    // put the logo image as frame icon 
	    ImageIcon image = new ImageIcon("Images/logo!.jpg");
	    frame.setIconImage(image.getImage());
	    
	  
	    // intro logo for 3 secs
	    Thread intro = new Intro( "Intro Screen");
	    intro.start();
	    intro.join();
	    intro.sleep(4000); // time waiting in the logo screen in milliseconds
	    clearScreen();
	    
	 
	    // First Screen with start button 
	    FirstScreen fs = new FirstScreen();
	   
	   
	    while (!fs.getIsPressed()) {
	    	assert true;
	    	 // just do something until the button is pressed
	    	System.out.println("not pressed");
	    }
	    clearScreen();
	    System.out.println("pressed");
	  
	    // instructions
	    Instructions ins = new Instructions(); 
	    // XXX restart on the menu bar must get fixed!!!
	    
	    // XXX win not connected to rest of the game 
	    // XXX 78 to be replaced with the real score 
	    Win wf = new Win(78); 
	    // XXX DefeatScreen not connected to rest of the game 
	    DefeatScreen ds = new DefeatScreen();
	   
	  
	}
	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();
		
	}


}
