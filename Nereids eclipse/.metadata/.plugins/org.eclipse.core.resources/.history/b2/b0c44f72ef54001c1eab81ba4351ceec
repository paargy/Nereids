package gameplayScreen;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BoatFrame {
	public Color SeaBlue = new Color( 6, 45, 98, 50);
	
	public BoatFrame() {
		JFrame frame = new JFrame("Nereids");
		
		
		BoatPanel bpanel = new BoatPanel();
		//panel.setBorder(BorderFactory.createEmptyBorder(550, 0, 0, 0));
		
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    
	    frame.add(bpanel);
	    frame.getContentPane().add(bpanel, BorderLayout.WEST);
	    
	    /*BackgroundPanel backPanel = new BackgroundPanel();
	    frame.add(backPanel);*/
	   
	    frame.setSize(600, 600);
	    
	    BackgroundButtons butPanel = new BackgroundButtons();
	    
	    frame.add(butPanel, 0);
	    
	    MenuBar menu = new MenuBar();
	    frame.setJMenuBar(menu);
	    
	    ProgressBar prBar = new ProgressBar(20); //the progress we want
	    frame.add(prBar, BorderLayout.PAGE_END);
	    
	    SideStatusPanel ssp = new SideStatusPanel();
	    frame.add(ssp, BorderLayout.AFTER_LINE_ENDS);
	    frame.setVisible(true);
	    frame.setResizable(true);
	    //frame.pack();      

	}
		
}

