package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import gr.aueb.dmst.nereids.graphicalInterface.ScreenHandler;

/**
 * Makes a menu bar
 * 
 * MenuBar creates a menu bar on top of the frame with the menu items: exit:
 * terminate, restart.
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener {
	JMenu m, n;
	JMenuItem m1, m2, menuItem;
	JFileChooser jf;
	ScreenHandler sh;
	Gameplay gp;

	public MenuBar(ScreenHandler sh) {
		this.sh = sh;
		m = new JMenu("Exit");
		m.setMnemonic(KeyEvent.VK_R);
		this.add(m);
		m1 = new JMenuItem("Terminate game");
		m1.addActionListener(this);
		m.add(m1);
		m2 = new JMenuItem("Restart");
		m2.addActionListener(this);
		m.add(m2);
	}

	public MenuBar(Gameplay gameplay) {
		this.gp = gameplay;
		m = new JMenu("Exit");
		m.setMnemonic(KeyEvent.VK_R);
		this.add(m);
		m1 = new JMenuItem("Terminate game");
		m1.addActionListener(this);
		m.add(m1);
		m2 = new JMenuItem("Restart");
		m2.addActionListener(this);
		m.add(m2);
	}

	// use to restart the game
	public void restart() {
		if (ScreenHandler.gamePanel != null) {
			ScreenHandler.interruptGameThread();
		}
		Gameplay.frame.dispose();
		Gameplay.mainMusic.stop();
		Gameplay.restartGameplay();
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
