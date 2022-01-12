package gr.aueb.dmst.nereids2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * PlayerChoice screen changes the Gameplay.frame to the player choice screen 9
 * nereid buttons on.. the left side and when chosen, the characteristics of the
 * nereid on the right.. side. Button "choose her" at the bottom right side. Can
 * choose 3 nereids. The.. same nereid cannot be chosen twice.
 */

public class PlayerChoice {
	int numOfChoice;
	/** use this to get the total characteristics of the chosen nereids. */
	int[] totalChars;
	/** out of bounds numbers so it operates right the first time. */
	int[] chosenNereidsIndexes = { 99, 99, 99 };
	int[][] chars = { { 2, 0, 2, 0, 0, 0, 0, 3, 1 }, { 0, 2, 0, 2, 2, 0, 3, 0, 0 }, { 0, 1, 2, 0, 0, 0, 0, 2, 1 },
			{ 2, 0, 0, 2, 3, 2, 0, 0, 0 }, { 1, 2, 2, 0, 0, 1, 0, 0, 0 }, { 0, 4, 0, 0, 0, 2, 0, 1, 1 },
			{ 4, 2, 0, 2, 0, 0, 0, 0, 0 }, { 2, 3, 0, 0, 3, 0, 0, 0, 0 }, { 4, 1, 0, 0, 2, 0, 0, 0, 0 } };
	JFrame frame;
	JPanel namePanel;
	JPanel charPanel;
	JPanel conPanel;
	JPanel iconPanel;
	JPanel choicePanel;
	JPanel[] teamPanel = new JPanel[3];
	JLabel nameLabel;
	JLabel picLabel;
	JTextArea nameArea;
	JTextArea charArea;
	JButton playButton;
	JButton[] choiceButton = new JButton[9];
	ImageTool it = new ImageTool();
	ButtonHandler bhandler = new ButtonHandler();
	Font nameFont = new Font("Tahoma", Font.BOLD, 60);
	Font charFont = new Font("Tahoma", Font.BOLD, 18);
	ArrayList<String> nereidNames = new ArrayList<>(
			Arrays.asList("Actaea", "Doris", "Euagore", "Eucrate", "Eupompe", "Thetis", "Thoe", "Menippe", "Ploto"));
	ArrayList<JPanel> nereidPanel = new ArrayList<>();
	ArrayList<JButton> nereidButton = new ArrayList<>();
	ArrayList<ImageIcon> nereidsImages = new ArrayList<>();
	/** HashMap that connects each nereid's name with her characteristics. */
	HashMap<String, int[]> nereidInfo = new HashMap<>();

	/** Constructor. */
	public PlayerChoice(JFrame frame, JButton playButton, int[] totalChars) {
		this.frame = frame;
		this.playButton = playButton;
		this.totalChars = totalChars;
	}

	/** shows the image of the nereid chosen. */
	public void showPlayerChoice() {
		try {
			// sets image as frame background
			Image bg = ImageIO.read(getClass().getResourceAsStream("/backgrounds/background.png"));
			frame.setContentPane(new ImagePanel(bg));
		} catch (IOException e) {
			e.printStackTrace();
		}
		putNereidImage();
		nereidDeclaration();
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(10, 50, 350, 50);
		messagePanel.setOpaque(false);
		JTextArea message = new JTextArea("Choose your nereids");
		message.setOpaque(false);
		message.setForeground(new Color(6, 45, 98));
		message.setFont(new Font("Tahoma", Font.BOLD, 30));
		messagePanel.add(message);
		frame.add(messagePanel);

		int x = 1;
		int y = 3;
		for (int i = 0; i < 9; i++) {
			nereidPanel.add(new JPanel());
			nereidPanel.get(i).setBounds(x * 70, y * 70 - 10, 70, 70);
			nereidPanel.get(i).setOpaque(false);
			Icon nereid = resize(nereidsImages.get(i), 60, 60);
			nereidButton.add(new JButton(nereid));
			nereidButton.get(i).addActionListener(bhandler);
			nereidButton.get(i).setOpaque(false);
			nereidButton.get(i).setBorderPainted(false);
			nereidButton.get(i).setContentAreaFilled(false);
			nereidPanel.get(i).add(nereidButton.get(i));
			frame.add(nereidPanel.get(i));
			// changes x, y in order to create a 3x3 table of nereid buttons
			x = ((i + 1) % 3 == 0 ? 1 : x + 1);
			y = ((i + 1) % 3 == 0 ? y + 1 : y);
		}
		for (int i = 0; i < 3; i++) {
			teamPanel[i] = new JPanel();
			teamPanel[i].setBounds((i + 1) * 70, 420, 70, 70);
			teamPanel[i].setOpaque(false);
			frame.add(teamPanel[i]);
		}
		// needs to be here in order for the frame to appear
		frame.setVisible(true);
	}

	/** loads nereid images. */
	public void putNereidImage() {
		for (int i = 1; i < 10; i++) {
			try {
				Icon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/nereids/nereid" + i + ".png")));
				nereidsImages.add((ImageIcon) icon);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// nereidsImages.add(new ImageIcon("res/nereids/nereid" + i + ".png"));
		}
	}

	/** Declares nereids' games. */
	public void nereidDeclaration() {
		for (int i = 0; i < 9; i++) {
			nereidInfo.put(nereidNames.get(i), chars[i]);
		}
	}

	/** shows characteristics of the chosen nereid. */
	public void nereidChoiceDisplay(String name) {
		// the first time this method is called namePanel would be null
		if (namePanel != null) {
			namePanel.removeAll();
		}

		namePanel = new JPanel();
		namePanel.setBounds(390, 25, 500, 500);
		namePanel.setOpaque(false);
		frame.add(namePanel);
		nameArea = new JTextArea(name);
		nameArea.setEditable(false);
		nameArea.setBounds(390, 25, 500, 500);
		nameArea.setFont(nameFont);
		nameArea.setOpaque(false);
		nameArea.setForeground(new Color(6, 45, 98));
		namePanel.add(nameArea);

		// the first time this method is called iconPanel would be null
		if (iconPanel != null) {
			iconPanel.removeAll();
		}
		iconPanel = new JPanel();
		iconPanel.setBounds(565, 100, 150, 150);
		iconPanel.setOpaque(false);
		int currentIndex = nereidNames.indexOf(name);
		picLabel = new JLabel(resize(nereidsImages.get(currentIndex), 140, 140));
		iconPanel.add(picLabel);
		frame.add(iconPanel);

		// the first time this method is called charPanel would be null
		if (charPanel != null) {
			charPanel.removeAll();
		}
		charPanel = new JPanel();
		charPanel.setBounds(550, 225, 210, 240);
		charPanel.setOpaque(false);
		frame.add(charPanel);
		charArea = new JTextArea("\n" + "  Agility: " + nereidInfo.get(name)[0] + "  " + "\n" + "  Organization: "
				+ nereidInfo.get(name)[1] + "  " + "\n" + "  Wisdom: " + nereidInfo.get(name)[2] + "  " + "\n"
				+ "  Windlessness: " + nereidInfo.get(name)[3] + "  " + "\n" + "  Courage: " + nereidInfo.get(name)[4]
				+ "  " + "\n" + "  Strength: " + nereidInfo.get(name)[5] + "  " + "\n" + "  Animal Friendliness: "
				+ nereidInfo.get(name)[6] + "  " + "\n" + "  Orientation: " + nereidInfo.get(name)[7] + "  " + "\n"
				+ "  Justice: " + nereidInfo.get(name)[8] + "  " + "\n");
		charArea.setEditable(false);
		charArea.setBounds(500, 250, 200, 250);
		charArea.setFont(charFont);
		charArea.setOpaque(false);
		charArea.setForeground(new Color(6, 45, 98));
		charPanel.add(charArea);

		if (choicePanel != null) {
			choicePanel.removeAll();
		}
		choicePanel = new JPanel();
		choicePanel.setBounds(600, 470, 100, 100);
		choicePanel.setOpaque(false);
		frame.add(choicePanel);

		// Use the chosenNereidsIndexes array to check if a certain nereid has already
		// been chosen
		// if not display choose button

		if (currentIndex != chosenNereidsIndexes[0] && currentIndex != chosenNereidsIndexes[1]
				&& currentIndex != chosenNereidsIndexes[2]) {
			choiceButton[currentIndex] = new JButton(" Choose her... ");
			choiceButton[currentIndex].addActionListener(bhandler);
			choicePanel.add(choiceButton[currentIndex]);
		}
		frame.repaint();
		frame.setMinimumSize(frame.getSize());
		frame.pack();
		frame.setMinimumSize(null);
	}

	/** resizes Image. */
	public ImageIcon resize(ImageIcon image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.drawImage(image.getImage(), 0, 0, width, height, null);
		g2d.dispose();
		return new ImageIcon(bi);
	}

	/** displays nereid team that is chosen. */
	public void chooseTeam(int i) {
		// disappears choose button
		choiceButton[i].setVisible(false);
		try {
			chosenNereidsIndexes[numOfChoice] = i;
			JLabel currentPic = new JLabel(picLabel.getIcon());
			teamPanel[numOfChoice].add(currentPic);
			// use it to check when the player has chosen three nereids
			numOfChoice++;
			// Update array with total characteristics of the nereids
			for (int j = 0; j < 9; j++) {
				totalChars[j] += nereidInfo.get(nereidNames.get(i))[j];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ignore");
		}
		if (numOfChoice == 3) {
			System.out.println("You chose your team!!");
			System.out.println(Arrays.toString(getChosenNereids()));
			choicePanel = null;
			try {
				for (int j = 0; i < 9; i++) {
					choiceButton[j].setVisible(false);
				}
			} catch (NullPointerException e) {
				System.out.println("ok move on");
			}

			JPanel txtPanel = new JPanel();
			txtPanel.setBounds(270, 150, 300, 60);
			txtPanel.setOpaque(false);
			JTextArea txt = new JTextArea("READY TO PLAY?");
			txt.setOpaque(false);
			txt.setForeground(new Color(6, 45, 98));
			txt.setFont(new Font("Tahoma", Font.BOLD, 35));
			txtPanel.add(txt);
			JPanel btnPanel = new JPanel();
			btnPanel.setBounds(340, 200, 150, 60);
			btnPanel.setOpaque(false);
			btnPanel.add(playButton);
			frame.add(txtPanel);
			frame.add(btnPanel);
		}
		frame.setMinimumSize(frame.getSize());
		frame.pack();
		frame.setMinimumSize(null);
	}

	/**
	 * returns an int [3] with the numbers of the chosen nereids integers from 0 to.
	 * 8 as in the array
	 */
	public int[] getChosenNereids() {
		return chosenNereidsIndexes;
	}

	/** displays nereid that is chosen to be seen. */
	public class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			for (int i = 0; i < 9; i++) {
				if (obj == nereidButton.get(i)) {
					nereidChoiceDisplay(nereidNames.get(i));
				}
				if (obj == choiceButton[i]) {
					chooseTeam(i);
				}
			}
		}
	}

	/** paints image. */
	@SuppressWarnings("serial")
	public class ImagePanel extends JComponent {
		private Image image;

		public ImagePanel(Image image) {
			this.image = image;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

}
