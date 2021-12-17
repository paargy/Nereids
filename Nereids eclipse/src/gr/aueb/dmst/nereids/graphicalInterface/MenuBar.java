
/*
 * make a menu bar on top of the screen
 * menu items: exit: terminate, restart
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MenuBar extends JMenuBar implements ActionListener{
  JMenu m,n;
  JMenuItem m1,m2, menuItem;
  JFileChooser jf;
  MenuBar(){ 
	  m = new JMenu("Exit");
	  
	  m.setMnemonic(KeyEvent.VK_R);
	  this.add(m);
	 
	  
	  m1 = new JMenuItem("Terminate game");
	  m1.addActionListener(this);
	  m.add(m1);
	  m2=new JMenuItem("Restart");
	  m2.addActionListener(this);
	  m.add(m2); 
	  
  }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object obj = e.getSource();
	if (obj == m1) {
		System.out.println("Terminate game");
		System.exit(0); //terminate the programm
	}else if (obj == m2) {
		System.out.println("Restart");
		try {
			Restart.restart();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			System.out.println(i + " " + stackTraceElements[i].getClassName());
			System.out.println(stackTraceElements[i].getMethodName());
		}
		
		*/
	}
	
}

}