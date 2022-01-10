package gr.aueb.dmst.nereids;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Creates obstacles
 * 
 * These are the obstacles that the player will encounter throughout the game.
 */

public class Obstacle {
	int mapX, mapY;
	int screenX, screenY;
	int[] traits;
	boolean collision;
	String name;
	BufferedImage image;
	/** use this rectangle to check for boat to obstacle collision */
	Rectangle solidArea;
	GamePanel gp;

	public Obstacle(String name, GamePanel gp, int[] traits, int size) {
		this.name = name;
		this.gp = gp;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/obstacles/" + name + ".png"));
			image = new ImageTool().scaleImage(image, size, size);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * will be used to check if collision is happening on this certain obstacle area
		 */
		solidArea = new Rectangle(screenX, screenY, gp.tileSize * 3, gp.tileSize * 3);
		/** the boat collides with every obstacle */
		collision = true;
		this.traits = traits;
	}

	public void draw(Graphics2D g2) {
		screenX = mapX - gp.boat.mapX + gp.boat.screenX;
		screenY = mapY;
		g2.drawImage(image, screenX, screenY, null);
		solidArea.x = screenX;
		solidArea.y = screenY;
		//g2.setColor(Color.red); //use to check for collision
		//g2.draw(solidArea); //use to check for collision
	}
}
