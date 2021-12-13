/*************************
 * makes a blue frame with a start button and 
 * a label nereids on top
 */


package firstScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import gameplayScreen.BoatPanel;

public class FSFrame implements ActionListener{
public Color SeaBlue = new Color( 6, 45, 98);
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	JButton startButton;
	Container con;
	JFrame frame;

	public FSFrame() {
		frame = new JFrame("Nereids");
		
		//FSPanel fspanel = new FSPanel();
		//panel.setBorder(BorderFactory.createEmptyBorder(550, 0, 0, 0));
		
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    
	    //frame.add(fspanel);
	    
	    JLabel label = new JLabel("A DMST student original game 2021", SwingConstants.RIGHT);
	    label.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    frame.add(label, BorderLayout.PAGE_END);
	    
	   

	    /*BackgroundPanel backPanel = new BackgroundPanel();
	    frame.add(backPanel);*/
	    frame.setSize(600, 600);
	    frame.getContentPane().setBackground(SeaBlue);
	    frame.setLayout(null);
	    
	    con = frame.getContentPane();
	    
	    titleNamePanel = new JPanel();
	    titleNamePanel.setBounds(100, 100, 400, 150);
	    titleNamePanel.setBackground(SeaBlue);
	    titleNameLabel = new JLabel("NEREIDS");
	    titleNamePanel.setForeground(Color.white);
	    titleNameLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
	    
	    startButtonPanel = new JPanel();
	    startButtonPanel.setBounds(250, 400, 100, 100);
	    startButtonPanel.setBackground(SeaBlue);
	    
	    startButton = new JButton("START");
	    startButton.setBackground(SeaBlue);
	    startButton.setForeground(Color.black);
	    startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    startButton.addActionListener(this);
	    
	    titleNamePanel.add(titleNameLabel);
	    startButtonPanel.add(startButton);
	    
	    con.add(titleNamePanel);
	    con.add(startButtonPanel);
	    
	    
	    frame.setVisible(true);
	    frame.setResizable(true);
	    //frame.pack();
	    
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == startButton) {
			System.out.println("start");
		}
		
	} 

}
