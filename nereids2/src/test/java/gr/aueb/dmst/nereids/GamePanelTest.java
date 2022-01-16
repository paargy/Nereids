package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test GamePanel Class. */
public class GamePanelTest {
  GamePanel gp;

  @BeforeEach
  void setUp() {
    gp = new GamePanel(null);
    gp.startGameThread();
  }

  @Test
  @DisplayName("Test thread not being null")
  void testGameThread() {
    assertNotNull(gp.gameThread, "doesn't start Thread");
  }
}
