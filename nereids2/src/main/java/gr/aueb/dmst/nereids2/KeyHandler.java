package gr.aueb.dmst.nereids2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles the keys the player presses.
 */

public class KeyHandler implements KeyListener {

  boolean upPressed;
  boolean downPressed;
  boolean  rightPressed;
  boolean leftPressed;

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_RIGHT) {
      rightPressed = true;
    }
    if (code == KeyEvent.VK_LEFT) {
      leftPressed = true;
    }
    if (code == KeyEvent.VK_UP) {
      upPressed = true;
    }
    if (code == KeyEvent.VK_DOWN) {
      downPressed = true;
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_RIGHT) {
      rightPressed = false;
    }
    if (code == KeyEvent.VK_LEFT) {
      leftPressed = false;
    }
    if (code == KeyEvent.VK_UP) {
      upPressed = false;
    }
    if (code == KeyEvent.VK_DOWN) {
      downPressed = false;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

}
