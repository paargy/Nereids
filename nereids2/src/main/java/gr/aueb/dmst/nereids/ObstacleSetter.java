package gr.aueb.dmst.nereids;

import java.util.Random;

/**
 * Sets obstacles on screen
 * ObstacleSetter creates 9 different Obstacle objects ands puts them on the map..
 * so that the player encounters them.
 */

public class ObstacleSetter {
  /** indicates the number of times the player overcame an obstacle. */
  int level = 1;
  GamePanel gp;
  /**
  * contains the different obstacle objects (one time each) that will be used on.
  *the game
   */
  Obstacle[] obs = new Obstacle[8];
  /** contains the traits that are used to overcome each obstacle. */
  int[][] traits = { { 2, 1, 0, 0, 0, 0, 0, 0, 0 }, 
    { 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
    { 1, 1, 0, 0, 1, 0, 0, 0, 0 },
    { 1, 1, 0, 0, 0, 1, 0, 0, 0 }, 
    { 1, 0, 0, 0, 1, 0, 1, 0, 0 }, 
    { 0, 0, 0, 1, 1, 0, 0, 1, 0 },
    { 0, 1, 1, 0, 0, 0, 0, 0, 1 }, 
    { 0, 0, 1, 0, 0, 0, 0, 2, 0 } };

  /**Constructor.*/
  public ObstacleSetter(GamePanel gp) {
    this.gp = gp;
    obs[0] = new Obstacle("conflict", gp, traits[0], gp.tileSize * 2);
    obs[1] = new Obstacle("disorientation", gp, traits[1], gp.tileSize * 2);
    obs[2] = new Obstacle("pirates", gp, traits[2], gp.tileSize * 3);
    obs[3] = new Obstacle("rocks", gp, traits[3], gp.tileSize * 2);
    obs[4] = new Obstacle("storm", gp, traits[4], gp.tileSize * 2);
    obs[5] = new Obstacle("swell", gp, traits[5], gp.tileSize * 2);
    obs[6] = new Obstacle("wind", gp, traits[6], gp.tileSize * 2);
    obs[7] = new Obstacle("seaanimals", gp, traits[7], gp.tileSize * 2);
  }

  /** takes three different obstacles randomly and puts them on the map.*/
  public void setObstacle() {
    if (level == 9) {
      gp.ui.gameFinished = true;
    } else {
      Random rand = new Random();
      // use these indexes to check that there won't be 2 or more same obstacles at the same time
      int index0;
      int index1;
      int index2;
      index0 = rand.nextInt(obs.length);
      do {
        index1 = rand.nextInt(obs.length);
      } while (index1 == index0);

      do {
        index2 = rand.nextInt(obs.length);
      } while (index2 == index0 || index2 == index1);
      gp.screenObs[0] = obs[index0];
      gp.screenObs[0].mapX = level * 19 * gp.tileSize; 
      // * 19 because every level appears every 19 columns
      gp.screenObs[0].mapY = 3 * gp.tileSize; // high height
      gp.screenObs[1] = obs[index1];
      gp.screenObs[1].mapX = (level * 19 - 1) * gp.tileSize; 
      // * 18 because every level appears every 19 columns
      // but this appears sooner
      gp.screenObs[1].mapY = 6 * gp.tileSize; // medium height
      gp.screenObs[2] = obs[index2];
      gp.screenObs[2].mapX = level * 19 * gp.tileSize; 
      // * 19 because every level appears every 19 columns
      gp.screenObs[2].mapY = 9 * gp.tileSize; // low height
      System.out.println("LEVEL: " + level);
      // upgrade level 
      level++;
    }
  }
}
