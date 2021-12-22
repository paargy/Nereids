package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BoatFrame extends JFrame {
	public Color SeaBlue = new Color(6, 45, 98, 50);

	public BoatFrame() {
		// JFrame frame = new JFrame("Nereids");

		BoatPanel bpanel = new BoatPanel();
		// panel.setBorder(BorderFactory.createEmptyBorder(550, 0, 0, 0));

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(bpanel);
		this.getContentPane().add(bpanel, BorderLayout.WEST);

		/*
		 * BackgroundPanel backPanel = new BackgroundPanel(); frame.add(backPanel);
		 */

		this.setSize(600, 600);

		BackgroundButtons butPanel = new BackgroundButtons();

		this.add(butPanel, 0);

		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);

		ProgressBar prBar = new ProgressBar(); // make the progress bar
		System.out.println(Status.getLevel());
		// prog --> the completed levels from 1 to 8 as a percentage (int)
		int prog = Math.round((Status.getLevel() * 100) / 8);
		prBar.setProgressBar(prog); // set the progress bar to the progress we want
		this.add(prBar, BorderLayout.PAGE_END);

		SideStatusPanel ssp = new SideStatusPanel();
		this.add(ssp, BorderLayout.AFTER_LINE_ENDS);
		this.setVisible(true);
		this.setResizable(true);
		// frame.pack();

	}

}
