package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Creates the first Screen in Gameplay.frame.
 * Displays name of the game, start button at the bottom.
 * Calls Instructions when the button gets pressed.
 * Displays Instructions with a next button at the bottom.
 * Goes to player's choice screen when its pressed and
 * after the player is done choosing goes to main game.
 */

public class ScreenHandler implements ActionListener {
	JPanel startButtonPanel;
	JButton startButton;
	JButton nextButton;
	JButton playButton;
	static GamePanel gamePanel;
	MenuBar menu = new MenuBar(this);
	int[] totalChars = new int[9];

	public ScreenHandler() {
		/* puts image as frame background*/
		try {
			Image bg = ImageIO.read(new File("res/backgrounds/titleScreen.png"));
			Gameplay.frame.setContentPane(new ImagePanel(bg, 864, 576));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gameplay.frame.setLayout(null);
		/* creates start button to use in the first screen */
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(360, 330, 127, 77);
		startButtonPanel.setOpaque(false);
		startButton = new JButton((Icon)(new ImageIcon("res/ui/button.png")));
		startButton.setOpaque(false);
		startButton.addActionListener((ActionListener) this);
		startButtonPanel.add(startButton);
		/* standard fuctions */
		Gameplay.frame.getContentPane().add(startButtonPanel);
		Gameplay.frame.repaint();
		Gameplay.frame.setMinimumSize(Gameplay.frame.getSize());
		Gameplay.frame.pack();
		Gameplay.frame.setMinimumSize(null);
		Gameplay.frame.setVisible(true);
		/* creates play button to use in the player choice screen */
		playButton = new JButton("YES");
		playButton.setPreferredSize(new Dimension(150, 50));
		playButton.setFont(new Font("Tahoma", Font.BOLD, 35));
		playButton.setForeground(Color.white);
		playButton.setBackground(new Color(6, 45, 98));
		playButton.addActionListener((ActionListener) this);
	}
	public static void interruptGameThread() {
		gamePanel.interruptGameThread();
			
	}
	
	public void createInstructionScreen() {
		Gameplay.clearScreen();
		Gameplay.frame.setLayout(new BorderLayout());
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		InstuctionsPanel panel = new InstuctionsPanel(nextButton);
		Gameplay.frame.add(panel);
		Gameplay.frame.setVisible(true);
	}
	
	public void createPlayerChoiceScreen() {
		Gameplay.clearScreen();
		//Gameplay.frame.setJMenuBar(menu);
		PlayerChoice pc = new PlayerChoice(playButton, totalChars);
		pc.showPlayerChoice();
	}
	
	public void setGameScreen() {
		Gameplay.stopMusic();
		Gameplay.clearScreen();
		Gameplay.frame.dispose();
		Gameplay.frame = new Frame();
		Gameplay.frame.setJMenuBar(menu); // adds menubar on frame
		gamePanel = new GamePanel(totalChars);
		Gameplay.frame.add(gamePanel);
		Gameplay.frame.setVisible(true);
		gamePanel.setupGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == startButton) {
			createInstructionScreen();
		}
		if (obj == nextButton) {
			createPlayerChoiceScreen();
		}
		if (obj == playButton) {
			setGameScreen();
		}
	}
}
