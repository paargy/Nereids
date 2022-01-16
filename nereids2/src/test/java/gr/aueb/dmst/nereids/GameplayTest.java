package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test Gameplay Class. */
public class GameplayTest {
  Gameplay gplay;

  @BeforeEach
  void setUp() {
    gplay = new Gameplay(true);
    gplay.createLogoScreen();
  }

  @Test
  @DisplayName("Test thread not being null")
  void testGameThread() {
    assertNotNull(gplay.intro, "doesn't start Thread");
  }
}
