package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test Boat Class. */
public class BoatTest {
  GamePanel gp;

  @BeforeEach
  void setUp() {
    gp = new GamePanel(null);
  }

  @Test
  @DisplayName("Test image not being null")
  void testBoatImage() {
    assertNotNull(gp.boat.testImage1, "cannot find image up");
    assertNotNull(gp.boat.testImage2, "cannot find image down");
  }
}
