package gr.aueb.dmst.nereids2;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/** Tests Tilemanager class. */
public class TileManagerTest {
  TileManager tm;
  
  @BeforeEach
  void setUp() {
    tm = new TileManager();
  }
  
  @Test
  @DisplayName("Test images not being null")
  void testReact() {
    assertNotNull(tm.is, "cannot load map");
    assertNotNull(tm.testTile, "cannot load test tile");
  }

}
