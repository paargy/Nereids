package gr.aueb.dmst.nereids;

/**
 * starts by showing the Intro logo screen and after 4 seconds change to the
 * FistScreen with the start button constructs the frame used in the game has a
 * clearScreen() method, with is used throughout the game to clear the frame, in
 * order to prepare it for a change
 */

public class Gameplay implements Runnable {

	static Sound mainMusic = new Sound();
	Frame frame = new Frame();
	MenuBar menu = new MenuBar(this);

	public Gameplay() {
		frame.setTitle("NEREIDS");
		playMusic(9);
		createLogoScreen();
		frame.setJMenuBar(menu); // adds menubar on frame
		new ScreenHandler(this);
	}

	/** shows game logo on the screen for 4 seconds */
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

	public void clearScreen() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}

	public static void playMusic(int i) {
		mainMusic.setFile(i);
		mainMusic.play();
		mainMusic.loop();
	}

	public static void stopMusic() {
		mainMusic.stop();
	}
	
	public void restartGameplay() {
		stopMusic();
		mainMusic.stop();
		frame.setTitle("NEREIDS");
		playMusic(9);
		new ScreenHandler(this); //check if it works correctly
	}

	@Override
	public void run() {
		IntroPanel iPanel = new IntroPanel(frame);
		frame.add(iPanel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(864, 596);
	}
}
