package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test the class Screen Handler.*/
public class ScreenHandlerTest {
  ScreenHandler sh;
  
  @BeforeEach
  void setUp() {
    sh = new ScreenHandler();
  }

  @Test
  @DisplayName("Test if the two images needed are null")
  void testReact() {
    assertNotNull(sh.icon, "cannot find button icon");
    assertNotNull(sh.image, "cannot find background titleScreen");
  }

}
