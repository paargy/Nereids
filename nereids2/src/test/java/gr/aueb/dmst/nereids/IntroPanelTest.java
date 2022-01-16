package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test Intro Panel Class.*/
public class IntroPanelTest {
  IntroPanel ip;

  @BeforeEach
  void setUp() {
    ip = new IntroPanel();
  }

  @Test
  @DisplayName("Test image not being null")
  void testLogoImage() {
    assertNotNull(ip.testImage, "cannot find image up");
  }
}
