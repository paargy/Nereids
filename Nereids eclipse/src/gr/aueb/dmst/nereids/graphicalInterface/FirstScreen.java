/**
 * Creates the first Screen in Gameplay.frame.
 * Label with the name of the game, dark blue background
 * and start button at the bottom.
 * 
 * Calls Instructions when the button gets pressed.
 */
package gr.aueb.dmst.nereids.graphicalInterface;

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


public class FirstScreen implements ActionListener {
	public Color SeaBlue = new Color(6, 45, 98);
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	JButton startButton;
	Container con;
	boolean isPressed = false;

	public FirstScreen() {
		Gameplay.frame.setSize(600, 650);

		Gameplay.frame.setLayout(new BorderLayout());

		JLabel label = new JLabel("A DMST student original game 2021", SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Gameplay.frame.add(label, BorderLayout.PAGE_END);

		Gameplay.frame.getContentPane().setBackground(SeaBlue);
		Gameplay.frame.setLayout(null);

		con = Gameplay.frame.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 400, 150);
		titleNamePanel.setBackground(SeaBlue);
		titleNameLabel = new JLabel("NEREIDS");
		titleNameLabel.setForeground(Color.BLACK);
		//titleNamePanel.setForeground(Color.WHITE);
		titleNameLabel.setFont(new Font("Tahoma", Font.BOLD, 60));

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(250, 400, 100, 100);
		startButtonPanel.setBackground(SeaBlue);

		startButton = new JButton("START");
		startButton.setBackground(Color.WHITE); // white background
		startButton.setForeground(Color.black);
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startButton.addActionListener((ActionListener) this);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);

		Gameplay.frame.repaint();
		Gameplay.frame.setMinimumSize(Gameplay.frame.getSize());
		Gameplay.frame.pack();
		Gameplay.frame.setMinimumSize(null);
		Gameplay.frame.setVisible(true);
		Gameplay.frame.setResizable(true);
		
		

	}

	/*
	 * public FirstScreen() {
	 * 
	 * Gameplay.frame.setLayout(new BorderLayout());
	 * 
	 * JLabel label = new JLabel("A DMST student original game 2021",
	 * SwingConstants.RIGHT); label.setFont(new Font("Tahoma", Font.PLAIN, 10));
	 * Gameplay.frame.add(label, BorderLayout.PAGE_END);
	 * 
	 * 
	 * Gameplay.frame.getContentPane().setBackground(SeaBlue);
	 * Gameplay.frame.setLayout(null);
	 * 
	 * con = Gameplay.frame.getContentPane();
	 * 
	 * titleNamePanel = new JPanel(); titleNamePanel.setBounds(100, 100, 400, 150);
	 * titleNamePanel.setBackground(SeaBlue); titleNameLabel = new
	 * JLabel("NEREIDS"); titleNamePanel.setForeground(Color.white);
	 * titleNameLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
	 * 
	 * startButtonPanel = new JPanel(); startButtonPanel.setBounds(250, 400, 100,
	 * 100); startButtonPanel.setBackground(SeaBlue);
	 * 
	 * startButton = new JButton("START"); startButton.setBackground(SeaBlue);
	 * startButton.setForeground(Color.black); startButton.setFont(new
	 * Font("Tahoma", Font.PLAIN, 20));
	 * startButton.addActionListener((ActionListener) this);
	 * 
	 * titleNamePanel.add(titleNameLabel); startButtonPanel.add(startButton);
	 * 
	 * con.add(titleNamePanel); con.add(startButtonPanel);
	 * 
	 * 
	 * Gameplay.frame.setVisible(true); Gameplay.frame.setResizable(true);
	 * 
	 * 
	 * 
	 * }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == startButton) {
			System.out.println("start");
			isPressed = true;
			// System.out.println(isPressed);
			Gameplay.clearScreen();

			// Instruction's Screen
			Instructions ins = new Instructions();

		}

	}

	public boolean getIsPressed() {
		return isPressed;
	}

}