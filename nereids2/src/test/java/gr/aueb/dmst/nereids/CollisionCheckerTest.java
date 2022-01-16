package gr.aueb.dmst.nereids;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test Collision Checker Class. */
public class CollisionCheckerTest {
  GamePanel gp;

  @BeforeEach
  void setup() {
    gp = new GamePanel(null);
    gp.boat.direction = "up";
  }

  @Test
  @DisplayName("Test collisionOn changes based on tile")
  void testCheckTile() {
    gp.boat.mapX = 200;
    gp.boat.mapY = 130;   
    gp.checker.checkTile(gp.boat);
    assertFalse("doesn't check tile collision", gp.boat.collisionOn);
    gp.boat.mapX = 200;
    gp.boat.mapY = 90;
    gp.checker.checkTile(gp.boat);
    assertTrue("doesn't check tile collision", gp.boat.collisionOn);
  }
  
  @Test
  @DisplayName("Test collisionOn becomes true when it touches an obstacle")
  void testCheckObstacle() {
    gp.obsSetter.setObstacle();
    gp.boat.solidArea.x = 600;
    gp.boat.solidArea.y = 150;
    gp.screenObs[0].solidArea.x = gp.screenObs[0].mapX;
    gp.screenObs[0].solidArea.y = gp.screenObs[0].mapY;
    gp.checker.checkObstacle(gp.boat);
    assertFalse("doesn't check obstacle collision", gp.boat.collisionOn);
    gp.boat.solidArea.x = 910;
    gp.boat.solidArea.y = 150;
    gp.screenObs[0].solidArea.x = gp.screenObs[0].mapX;
    gp.screenObs[0].solidArea.y = gp.screenObs[0].mapY;
    gp.checker.checkObstacle(gp.boat);
    assertTrue("doesn't check obstacle collision", gp.boat.collisionOn);
  }
}
