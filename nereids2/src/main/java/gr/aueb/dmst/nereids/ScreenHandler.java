package gr.aueb.dmst.nereids;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

  int[] totalChars = new int[9];
  JPanel startButtonPanel;
  JButton startButton;
  JButton nextButton;
  JButton playButton;
  Gameplay gplay;
  GamePanel gamePanel;
  MenuBar menu = new MenuBar(this);
  Image image;
  Icon icon;
  
  /**Constructor.*/
  public ScreenHandler(Gameplay gplay) {
    this.gplay = gplay;
    // puts image as frame background
    try {
      image = ImageIO.read(getClass().getResourceAsStream("/backgrounds/titleScreen.png"));
      gplay.frame.setContentPane(new ImagePanel(image, 864, 576));
    } catch (IOException e) {
      e.printStackTrace();
    }
    gplay.frame.setLayout(null);
    // creates start button to use in the first screen
    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(360, 330, 127, 90);
    startButtonPanel.setOpaque(false);

    try {
      icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/ui/button.png")));
      startButton = new JButton(icon);
      startButton.setContentAreaFilled(false);
      startButton.addActionListener((ActionListener) this);
      startButtonPanel.add(startButton);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // standard functions
    gplay.frame.getContentPane().add(startButtonPanel);
    gplay.frame.repaint();
    gplay.frame.setMinimumSize(gplay.frame.getSize());
    gplay.frame.pack();
    gplay.frame.setMinimumSize(null);
    gplay.frame.setVisible(true);
    // creates play button to use in the player choice screen
    playButton = new JButton("YES");
    playButton.setPreferredSize(new Dimension(150, 50));
    playButton.setFont(new Font("Tahoma", Font.BOLD, 35));
    playButton.setForeground(Color.white);
    playButton.setBackground(new Color(6, 45, 98));
    playButton.addActionListener((ActionListener) this);
  }
  
  /**Constructor used by JUnit testing.*/
  public ScreenHandler() {
    try {
      image = ImageIO.read(getClass().getResourceAsStream("/backgrounds/titleScreen.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/ui/button.png")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  /**displays instructions.*/
  public void createInstructionScreen() {
    gplay.clearScreen();
    gplay.frame.setLayout(new BorderLayout());
    nextButton = new JButton("Next");
    nextButton.addActionListener(this);
    InstructionsPanel panel = new InstructionsPanel(nextButton);
    gplay.frame.add(panel);
    gplay.frame.setVisible(true);
  }
  
  /**creates player choice screen.*/
  public void createPlayerChoiceScreen() {
    gplay.clearScreen();
    PlayerChoice pc = new PlayerChoice(gplay.frame, playButton, totalChars);
    pc.showPlayerChoice();
  }
  
  /**sets game screen.*/
  public void setGameScreen() {
    Gameplay.stopMusic();
    gplay.clearScreen();
    // disposes frame to create a new one because the paint component
    // used to draw background on frame appears on top of everything
    gplay.frame.dispose(); 
    gplay.frame = new Frame();
    gplay.frame.setJMenuBar(menu); // adds menu bar on frame
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

