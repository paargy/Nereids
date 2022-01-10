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
	Gameplay gplay;
	GamePanel gamePanel;
	MenuBar menu = new MenuBar(this);
	int[] totalChars = new int[9];

	public ScreenHandler(Gameplay gplay) {
		this.gplay = gplay;
		/* puts image as frame background*/
		try {
			Image bg = ImageIO.read(new File("res/backgrounds/titleScreen.png"));
			gplay.frame.setContentPane(new ImagePanel(bg, 864, 576));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gplay.frame.setLayout(null);
		/* creates start button to use in the first screen */
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(360, 330, 127, 80);
		startButtonPanel.setOpaque(false);
		startButton = new JButton((Icon)(new ImageIcon("res/ui/button.png")));
		startButton.setContentAreaFilled(false);
		startButton.addActionListener((ActionListener) this);
		startButtonPanel.add(startButton);
		/* standard functions */
		gplay.frame.getContentPane().add(startButtonPanel);
		gplay.frame.repaint();
		gplay.frame.setMinimumSize(gplay.frame.getSize());
		gplay.frame.pack();
		gplay.frame.setMinimumSize(null);
		gplay.frame.setVisible(true);
		/* creates play button to use in the player choice screen */
		playButton = new JButton("YES");
		playButton.setPreferredSize(new Dimension(150, 50));
		playButton.setFont(new Font("Tahoma", Font.BOLD, 35));
		playButton.setForeground(Color.white);
		playButton.setBackground(new Color(6, 45, 98));
		playButton.addActionListener((ActionListener) this);
	}
	
	public void createInstructionScreen() {
		gplay.clearScreen();
		gplay.frame.setLayout(new BorderLayout());
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		InstructionsPanel panel = new InstructionsPanel(nextButton);
		gplay.frame.add(panel);
		gplay.frame.setVisible(true);
	}
	
	public void createPlayerChoiceScreen() {
		gplay.clearScreen();
		PlayerChoice pc = new PlayerChoice(gplay.frame, playButton, totalChars);
		pc.showPlayerChoice();
	}
	
	public void setGameScreen() {
		Gameplay.stopMusic();
		gplay.clearScreen();
		gplay.frame.dispose();
		gplay.frame = new Frame();
		gplay.frame.setJMenuBar(menu); // adds menubar on frame
		gamePanel = new GamePanel(totalChars);
		gplay.frame.add(gamePanel);
		gplay.frame.setVisible(true);
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
