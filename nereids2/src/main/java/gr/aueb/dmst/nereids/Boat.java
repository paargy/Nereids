package gr.aueb.dmst.nereids;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Creates the boat the player will control with the arrow keys in order to.
 * reach Sicily.
 */

public class Boat {

  final int speed = 5;
  int mapX;
  int mapY;
  int screenX;
  int screenY;
  int spriteCounter = 0;
  int spriteNum = 1;
  int size;
  int[] totalChars;
  boolean collisionOn = false;
  GamePanel gp;
  KeyHandler keyH;
  BufferedImage up;
  BufferedImage testImage1; // used for JUnit testing
  BufferedImage down;
  BufferedImage testImage2; // used for JUnit testing
  String direction;
  Rectangle solidArea;
  
  /**Constructor used for Test Class.*/
  public Boat(GamePanel gp) {
    this.gp = gp;
  }
  
  /**Constructor.*/
  public Boat(GamePanel gp, KeyHandler keyH, int[] totalChars) {
    this.gp = gp;
    this.keyH = keyH;
    this.totalChars = totalChars;
    screenX = 100;
    screenY = 230;
    /* sets the size of the boat image */
    size = gp.tileSize * 3;
    /* will be used to check if collision is happening on this certain boat area */
    solidArea = new Rectangle(screenX, screenY + gp.tileSize * 2, gp.tileSize * 3, gp.tileSize);
    setDefaultValues();
    getBoatImage();
  }
  
  /**sets default values for mapX, mapY, direction.*/
  public void setDefaultValues() {
    mapX = screenX;
    mapY = screenY;
    direction = "up";
  }

  /**loads boat images.*/
  public void getBoatImage() {
    ImageTool itool = new ImageTool();
    try {
      up = ImageIO.read(getClass().getResourceAsStream("/boat/boat1.png"));
      up = itool.scaleImage(up, size, size);
      testImage1 = up; // use from BoatTest
      down = ImageIO.read(getClass().getResourceAsStream("/boat/boat2.png"));
      down = itool.scaleImage(down, size, size);
      testImage2 = down; // use from BoatTest
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** updates the boats coordinates while checking for collision. */
  public void update() {
    /* check whether or not tile collision is happening */
    collisionOn = false;
    gp.checker.checkTile(this);
    if (keyH.upPressed == true) {
      direction = "up";
      /* if there's not tile collision and player presses up arrow, boat can move */
      if (collisionOn == false) {
        mapY -= speed;
      }
    }
    if (keyH.downPressed == true) {
      direction = "down";
      /*
   * if there's not tile collision and player presses down arrow, boat can move
   */
      if (collisionOn == false) {
        mapY += speed;
      }
    }
    /* check whether or not obstacle collision is happening */
    collisionOn = false;
    /* if it's not happening the checkObstacle method returns -1 */
    int i = gp.checker.checkObstacle(this);
    if (collisionOn == true && !gp.ui.gameFinished) {
      react(gp.screenObs[i]);
      int numOfTraits = 0;
      for (int j = 0; j < 9; j++) {
        if (totalChars[j] >= gp.screenObs[i].traits[j]) {
          totalChars[j] -= gp.screenObs[i].traits[j];
          numOfTraits++;
        } else {
          gp.score -= (gp.screenObs[i].traits[j] - totalChars[j]);
          totalChars[j] = 0;
        }
      }
      /* if the player has all the needed traits, score goes up */
      if (numOfTraits == 9) {
        gp.score += 1;
      }
      /*
   * the 9th time the setObstacle method is called the gameFinished variable will
   * become true
    */
      gp.obsSetter.setObstacle();
    } else if (gp.ui.gameFinished) {
      gp.screenObs[0].image = null;
      gp.screenObs[1].image = null;
      gp.screenObs[2].image = null;
      System.out.println("GAME END");
    }
    if (gp.score <= 0) {
      gp.gameThread = null;
      gp.ui.lost = true;
      gp.ui.gameFinished = true;
      gp.stopMusic();
      gp.playSe(11);
    }
    screenY = mapY;
    /*
    * the map is always moving to the right no matter what the player does with the
    * boat (the boat stays on the same position on the x axis on the screen)
    */
    mapX += speed;
    
    /*update solid areas coordinates as boat moves*/
    solidArea.x = screenX;
    solidArea.y = screenY + gp.tileSize * 2;
    /*
  * every 13th time this method is called the boat's sprite will change to
  * implement movement
  */
    spriteCounter++;
    if (spriteCounter == 13) {
      spriteNum = (spriteNum == 1 ? 2 : 1);
      spriteCounter = 0;
    }
  }

  /** play sound effect based on the obstacle the boat collided with. */
  public void react(Obstacle obs) {
    switch (obs.name) {
      case "conflict":
        gp.playSe(1);
        break;
      case "rocks":
        gp.playSe(2);
        break;
      case "seaanimals":
        gp.playSe(3);
        break;
      case "storm":
        gp.playSe(4);
        break;
      case "swell":
        gp.playSe(5);
        break;
      case "wind":
        gp.playSe(6);
        break;
      case "disorientation":
        gp.playSe(7);
        break;
      case "pirates":
        gp.playSe(10);
        break;
      default:
        break;
    }
  }
  
  /**draws Image.*/
  public void draw(Graphics2D g2) {
    BufferedImage image = (spriteNum == 1 ? up : down);
    g2.drawImage(image, screenX, screenY, null);
    // g2.setColor(Color.red); //use to check for collision
    // g2.draw(solidArea); //use to check for collision
  }
  
}
