package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Tests Player Choice class. */
public class PlayerChoiceTest {
  PlayerChoice pc;
  
  @BeforeEach
  void setUp() {
    pc = new PlayerChoice();
  }
  
  @Test
  @DisplayName("test if chosen image to display exists. "
      + "chosen image 1 e.g.")
  void testImage() {
    assertNotNull(pc.putNereidImage(1), "nereid image 1 cannot be found");
  }
  
  @Test
  @DisplayName("test resize method resizing the icon to 10 x 10")
  void testResize() {
    Icon icon = pc.putNereidImage(1);
    
    icon = pc.resize((ImageIcon) icon, 10, 10);
    assertEquals(10, icon.getIconHeight(), "icon height is not 10");
    assertEquals(10, icon.getIconWidth(), "icon width is not 10");
    
  }
  

}
