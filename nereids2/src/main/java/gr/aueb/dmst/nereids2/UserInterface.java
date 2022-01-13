package gr.aueb.dmst.nereids2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * User Interface Class
 * This class informs the user about the total characteristics that he has after
 * facing each obstacle, the user's score, shows encouraging messages and in the
 * end displays a message to inform the user whether they won, or lost.
 */

public class UserInterface {
  GamePanel gp;
  Font titleFont;
  Font tableFont;
  Font messageFont;
  Color rectColor;
  BufferedImage table;
  BufferedImage testImage2 = null; //used for JUnit testing
  BufferedImage bg;
  BufferedImage testImage1 = null; //used for JUnit testing
  BufferedImage introTable;
  JButton startButton;
  Graphics2D g2;
  boolean gameFinished = false;
  boolean lost = false;
  int counter = 300;
  int messageIndex = 0;
  
  /**Constructor.*/
  public UserInterface(GamePanel gp) {
    this.gp = gp;
    tableFont = new Font("Tahoma", Font.BOLD, 10);
    messageFont = new Font("Tahoma", Font.BOLD, 13);
    rectColor = new Color(24, 13, 4, 230);
    try {
      bg = ImageIO.read(getClass().getResourceAsStream("/backgrounds/background.png"));
      bg = new ImageTool().scaleImage(bg, gp.screenWidth, gp.screenHeight);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      table = ImageIO.read(getClass().getResourceAsStream("/ui/table.png"));
      table = new ImageTool().scaleImage(table, gp.tileSize * 5, gp.tileSize * 3);
      introTable = new ImageTool().scaleImage(table, 600, 550);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /** Constructor for testing.*/
  public UserInterface() {
    tableFont = new Font("Tahoma", Font.BOLD, 10);
    messageFont = new Font("Tahoma", Font.BOLD, 13);
    rectColor = new Color(24, 13, 4, 230);
    try {
      bg = ImageIO.read(getClass().getResourceAsStream("/backgrounds/background.png"));
      testImage1 = bg; // to test from UserInterfaceTest
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      table = ImageIO.read(getClass().getResourceAsStream("/ui/table.png"));
      testImage2 = table; // to test from UserInterfaceTest
      introTable = new ImageTool().scaleImage(table, 600, 550);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**draws Win and Defeat Messages. */
  public void draw(Graphics2D g2) {
    this.g2 = g2;
    if (!gameFinished) {
      drawCharTable();
      counter++;
      if (counter > 390) {
        drawMessage();
        messageIndex = (counter == 500 ? messageIndex + 1 : messageIndex);
        counter = (counter == 500 ? 0 : counter);
      }
      drawScore();
    } else {
      if (lost) {
        drawDefeatScreen();
      } else {
        drawWinScreen();
      }
    }
  }

  /** draws table with the characteristics the player has. */
  public void drawCharTable() {
    g2.drawImage(table, 600, 1, null);
    g2.setFont(tableFont);
    g2.setColor(Color.WHITE);
    int y = 17;
    String text = " AGILITY:" + gp.boat.totalChars[0] + "\n "
                + "ORGANIZATION:" + gp.boat.totalChars[1] + "\n "
                + "WISDOM:" + gp.boat.totalChars[2] + "\n "
                + "WINDLESSNESS:" + gp.boat.totalChars[3] + "\n "
                + "COURAGE: " + gp.boat.totalChars[4] + "\n "
                + "STRENGTH: " + gp.boat.totalChars[5] + "\n "
                + "ANIMAL FRIENDLINESS: " + gp.boat.totalChars[6] + "\n "
                + "ORIENTATION: " + gp.boat.totalChars[7] + "\n "
                + "JUSTICE: " + gp.boat.totalChars[8] + "\n";
    for (String line : text.split("\n")) {
      g2.drawString(line, 620, y += g2.getFontMetrics().getHeight());
    }
  }

  /** draws encouraging messages for the player. */
  public void drawMessage() {
    String[] messages = { "BE CAREFUL :(", "YOU CAN DO IT !", "ALMOST THERE..." };
    g2.setColor(rectColor);
    g2.fillRoundRect(650, 450, 150, 50, 35, 35);
    g2.setColor(Color.WHITE);
    g2.setStroke(new BasicStroke(4));
    g2.drawRoundRect(655, 455, 140, 40, 25, 25);
    g2.setFont(messageFont);
    g2.drawString(messages[messageIndex], 670, 480);
  }
  
  /**draws score.*/
  public void drawScore() {
    g2.setColor(Color.white);
    g2.setFont(new Font("Tahoma", Font.BOLD, 30));
    g2.drawString("SCORE : " + gp.score, 70, 80);
  }
  
  /**draws defeat message.*/
  public void drawDefeatScreen() {
    g2.setColor(Color.white);
    g2.setFont(new Font("Tahoma", Font.BOLD, 60));
    g2.drawString("OH NO DEFEAT :(", 160, 100);
  }
  
  /**draws win screen.*/
  public void drawWinScreen() {
    g2.setColor(Color.white); 
    g2.setFont(new Font("Tahoma", Font.BOLD, 60));
    g2.drawString("YOU WON !!", 230, 200);
    g2.drawString("SCORE : " + gp.score, 265, 250);
  }
}

