package gr.aueb.dmst.nereids.graphicalInterface;

/**
 * Contains 2 methods One to check for tile collision (the boat cannot move on
 * the sand tiles) and another to check which obstacle the boat collided with
 */

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	/** checks if the boat collides with tiles that it shouldn't */
	public void checkTile(Boat boat) {
		// boat checkbox
		int leftX = boat.mapX + gp.tileSize;
		int topY = boat.mapY + gp.tileSize;
		int bottomY = boat.mapY + gp.tileSize + boat.solidArea.height;
		int leftCol = leftX / gp.tileSize;
		int topRow = (topY - boat.SPEED) / gp.tileSize;
		int bottomRow = ((bottomY - boat.SPEED) / gp.tileSize) + 2;
		int tileNum;
		switch (boat.direction) {
		case "up":
			tileNum = gp.tileM.mapTileNum[topRow][leftCol];
			if (gp.tileM.tile[tileNum].collision == true) {
				boat.collisionOn = true;
				System.out.println(boat.collisionOn);
				System.out.println("Collides up");
			}
			break;
		case "down":
			if (bottomRow >= 12) { // boat can move up to the 11th row
				boat.collisionOn = true;
				System.out.println("Collides down");
			}
			break;
		}
		int rightCol = (boat.mapX + 3 * gp.tileSize - boat.SPEED) / gp.tileSize;
		// the game finishes at the 163rd column of the map
		if (rightCol == 163) {
			boat.collisionOn = true;
			gp.stopMusic();
			gp.playSE(8); //play sound effect for winning
			gp.gameThread = null; //stop game
		}
	}
	
	/** checks if the boat collides with an obstacle */
	public int checkObstacle(Boat boat) {
		for (int i = 0; i < gp.screenObs.length; i++) {
			if (boat.solidArea.intersects(gp.screenObs[i].solidArea)) {
				System.out.println("collides with object number: " + i);
				boat.collisionOn = true;
				return i;
			}
		}
		// returns -1 if it doesn't collide
		return -1;
	}
}
