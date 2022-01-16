package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Sound class. 
 */
public class SoundTest {
  Sound sound;
  
  @BeforeEach
  void setUp() {
    sound = new Sound();
    sound.setFile(0);
  }
  
  @Test
  @DisplayName("Test if test clip is null")
  void testReact() {
    assertNotNull(sound.clipTest, "cannot find file");
  }

}
