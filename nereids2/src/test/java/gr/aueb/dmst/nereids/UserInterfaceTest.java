package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test User Interface Class. */
public class UserInterfaceTest {
  UserInterface ui;

  @BeforeEach
  void setUp() {
    ui = new UserInterface();
  }

  @Test
  @DisplayName("Test image not being null")
  void testReact() {
    assertNotNull(ui.testImage1, "cannot find image 1");
    assertNotNull(ui.testImage2, "cannot find image 2");
  }
}
