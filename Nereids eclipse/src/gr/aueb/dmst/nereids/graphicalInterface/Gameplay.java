package gr.aueb.dmst.nereids.graphicalInterface;

/**
 * starts by showing the Intro logo screen
 * and after 4 seconds change to the FistScreen 
 * with the start button constructs the frame used in the game 
 * has a clearScreen() method, with is used throughout the
 * game to clear the frame, in order to prepare it for a change 
 */

public class Gameplay implements Runnable {
	static Frame frame = new Frame();
	static Sound mainMusic = new Sound();
	
	public Gameplay() {
		playMusic(9);
		createLogoScreen();
		new ScreenHandler();
	}
	
	public void createLogoScreen() {
		Thread intro = new Thread(this);
		intro.start();
		try {
			intro.join();
			Thread.sleep(4000); // time waiting in the logo screen in milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clearScreen();
	}

	public static void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	
	public void playMusic(int i) {
		mainMusic.setFile(i);
		mainMusic.play();
		mainMusic.loop();
	}
	
	public static void stopMusic() {
		mainMusic.stop();
	}

	@Override
	public void run() {
		IntroPanel iPanel = new IntroPanel();
		Gameplay.frame.add(iPanel);
		Gameplay.frame.pack();
		Gameplay.frame.setVisible(true);
		Gameplay.frame.setSize(864, 576);
	}
}
