package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;

import javax.swing.JProgressBar;

public class ProgressBar extends JProgressBar {
	public Color SeaBlue = new Color(6, 45, 98);

	/*
	 * constructor of the progress bar
	 */
	public ProgressBar() {
		this.setBounds(40, 550, 160, 30);
		this.setValue(0);
		this.setStringPainted(true);

	}

	public void setProgressBar(int i) {
		/*
		 * set the progress to i out of 100
		 */
		if ((i >= 0) && (i <= 100)) {
			this.setValue(i);
		}
	}
	
	// not working
	public void setProgressBar(int a, int b) {
		/*
		 * from a, b tasks completed
		 */

		double prog = ((a - b) / b) * 100;
		int i = (int) prog;
		if ((i >= 0) && (i <= 100)) {
			this.setValue(i);
		}
	}

}