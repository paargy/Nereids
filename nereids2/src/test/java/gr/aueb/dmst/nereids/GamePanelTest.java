package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test GamePanel Class. */
public class GamePanelTest {
  GamePanel gp;
  Obstacle o1;
  Obstacle o2;
  Obstacle o3;

  @BeforeEach
  void setUp() {
    // the characteristics of the first nereid for example
    int [] totalChars = { 2, 0, 2, 0, 0, 0, 0, 3, 1 };
    gp = new GamePanel(totalChars);
    o1 = new Obstacle("conflict");
    o2 = new Obstacle("pirates");
    o3 = new Obstacle("storm");
    gp.setScreenObs(o1, o2, o3);
    gp.startGameThread();
    
  }

  @Test
  @DisplayName("Test thread not being null")
  void testGameThread() {
    assertNotNull(gp.gameThread, "doesn't start Thread");
  }
}
