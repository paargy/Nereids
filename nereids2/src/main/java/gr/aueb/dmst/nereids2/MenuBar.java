package gr.aueb.dmst.nereids2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Makes a menu bar
 * MenuBar creates a menu bar on top of the frame with the menu items: exit:
 * terminate, restart.
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener {
  JMenu menu1;
  JMenu n1;
  JMenuItem m1;
  JMenuItem m2;
  JMenuItem menuItem;
  JFileChooser jf;
  ScreenHandler sh;
  Gameplay gp;
  
  /**Constructor.*/
  public MenuBar(ScreenHandler sh) {
    this.sh = sh;
    menu1 = new JMenu("Options");
    menu1.setMnemonic(KeyEvent.VK_R);
    this.add(menu1);
    m1 = new JMenuItem("Terminate game");
    m1.addActionListener(this);
    menu1.add(m1);
    m2 = new JMenuItem("Restart");
    m2.addActionListener(this);
    menu1.add(m2);
  }
    
  /**Constructor no2.*/
  public MenuBar(Gameplay gameplay) {
    this.gp = gameplay;
    menu1 = new JMenu("Options");
    menu1.setMnemonic(KeyEvent.VK_R);
    this.add(menu1);
    m1 = new JMenuItem("Terminate game");   
    m1.addActionListener(this);
    menu1.add(m1);
    m2 = new JMenuItem("Restart"); 
    m2.addActionListener(this);
    menu1.add(m2);
  }

  /** use to restart the game.*/
  public void restart() {
    if (gp == null) {
      sh.gplay.frame.dispose();
      Gameplay.mainMusic.stop();
      sh.gplay.restartGameplay();
    } else if (sh == null) {
      gp.frame.dispose();
      Gameplay.mainMusic.stop();
      gp.restartGameplay();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == m1) {
      System.out.println("Terminate game");
      System.exit(0);
    } else if (obj == m2) {
      restart();
    }
  }
}
