package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Makes a menu bar
 * 
 * MenuBar creates a menu bar on top of the frame
 * with the menu items: exit: terminate, restart.
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener {
	JMenu m, n;
	JMenuItem m1, m2, menuItem;
	JFileChooser jf;
	ScreenHandler sh;
	
	public MenuBar(ScreenHandler sh){ 
		this.sh = sh;
		m = new JMenu("Settings");
		m.setMnemonic(KeyEvent.VK_R);
		this.add(m);
		m1 = new JMenuItem("Terminate game");
		m1.addActionListener(this);
		m.add(m1);
		m2=new JMenuItem("Restart");
		m2.addActionListener(this);
		m.add(m2);  
	}

	public void restart() {
		if (sh.gamePanel != null) {
			sh.gamePanel.stopMusic();
		}
		sh.createPlayerChoiceScreen();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == m1) {
			System.out.println("Terminate game");
			System.exit(0);
		}else if (obj == m2) {
			restart();
		}
	}
}
