package gameplayScreen;

import java.awt.Color;

import javax.swing.JProgressBar;

public class ProgressBar extends JProgressBar{
	public Color SeaBlue = new Color( 6, 45, 98);
	public ProgressBar() {
		this.setBounds(40, 550, 160, 30);
		this.setValue(0);
		this.setStringPainted(true);
		
		}
	public ProgressBar(int i) { // sets value of the Progress Bar to i (from 0 to 100)
		if ((i >= 0) && (i <= 100)) {
			this.setValue(i);
		}
	}
	public ProgressBar( int a, int b) { //from a, b tasks completed
		double prog = ((a - b) / b ) * 100;
		int i = (int) prog;
		if ((i >= 0) && (i <= 100)) {
			this.setValue(i);
		}
	}

	
}
