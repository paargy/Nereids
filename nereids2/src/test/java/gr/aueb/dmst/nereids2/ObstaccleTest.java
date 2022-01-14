package gr.aueb.dmst.nereids2;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/** Test Obstacle class.*/
public class ObstaccleTest {
  Obstacle obs;
  
  @BeforeEach
  void setUp() {
    obs = new Obstacle("conflict");
  }
  
  @Test
  @DisplayName("test if a test obstacle image can be found. Here: conflict")
  void testReact() {
    assertNotNull(obs.image, "cannot find obstacle image");
  }
  
}
