package gr.aueb.dmst.nereids;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Test Image Tool Class.*/
public class ImageToolTest {

  ImageTool it;
  BufferedImage bi;

  @BeforeEach
  void setUp() {
    it = new ImageTool();
    try {
      bi = ImageIO.read(getClass().getResourceAsStream("/logo/logo.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  @DisplayName("Test scaling is done correctly")
  void testScaling() {
    BufferedImage newImage = it.scaleImage(bi, 500, 700);
    assertEquals(newImage.getWidth(), 500);
    assertEquals(newImage.getHeight(), 700);
  }
}
