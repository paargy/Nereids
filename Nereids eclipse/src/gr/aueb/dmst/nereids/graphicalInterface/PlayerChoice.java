package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

/**
 * PlayerChoice screen
 * 
 * changes the Gameplay.frame to the player choice screen 9 nereid buttons on
 * the left side and when chosen, the characteristics of the nereid on the right
 * side. Button "choose her" at the bottom right side. Can choose 3 nereids. The
 * same nereid cannot be chosen twice.
 */

public class PlayerChoice {
	JPanel namePanel, charPanel, iconPanel, choicePanel;
	JPanel[] teamPanel = new JPanel[3];
	JButton[] choiceButton = new JButton[9];
	JButton playButton;
	ImageTool it = new ImageTool();
	int numOfChoice;
	/** out of bounds numbers so it operates right the first time */
	int[] chosenNereidsIndexes = { 99, 99, 99 };
	ArrayList<JPanel> nereidPanel = new ArrayList<>();
	JLabel nameLabel;
	JTextArea nameArea, charArea;
	Font nameFont = new Font("Tahoma", Font.BOLD, 60);
	Font charFont = new Font("Tahoma", Font.BOLD, 18);
	ArrayList<JButton> nereidButton = new ArrayList<>();
	JLabel picLabel;
	ArrayList<ImageIcon> nereidsImages = new ArrayList<>();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ArrayList<String> nereidNames = new ArrayList<>(
			Arrays.asList("Actaea", "Doris", "Euagore", "Eucrate", "Eupompe", "Thetis", "Thoe", "Menippe", "Ploto"));
	/** HashMap that connects each nereid's name with her characteristics */
	HashMap<String, int[]> nereidInfo = new HashMap<>();
	int[][] chars = { { 2, 0, 2, 0, 0, 0, 0, 3, 1 }, 
					  { 0, 2, 0, 2, 2, 0, 3, 0, 0 }, 
					  { 0, 1, 2, 0, 0, 0, 0, 2, 1 },
					  { 2, 0, 0, 2, 3, 2, 0, 0, 0 }, 
					  { 1, 2, 2, 0, 0, 1, 0, 0, 0 }, 
					  { 0, 4, 0, 0, 0, 2, 0, 1, 1 },
					  { 4, 2, 0, 2, 0, 0, 0, 0, 0 }, 
					  { 2, 3, 0, 0, 3, 0, 0, 0, 0 }, 
					  { 4, 1, 0, 0, 2, 0, 0, 0, 0 } };
	/** use this to get the total characteristics of the chosen nereids */
	int[] totalChars;

	public PlayerChoice(JButton playButton, int[] totalChars) {
		this.playButton = playButton;
		this.totalChars = totalChars;
	}

	public void putNereidImage() {
		for (int i = 1; i < 10; i++) {
			nereidsImages.add(resize(new ImageIcon("res/nereids/nereid" + i + ".png"), 60, 60));
		}
	}

	public static ImageIcon resize(ImageIcon image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.drawImage(image.getImage(), 0, 0, width, height, null);
		g2d.dispose();
		return new ImageIcon(bi);
	}

	public void nereidDeclaration() {
		for (int i = 0; i < 9; i++) {
			nereidInfo.put(nereidNames.get(i), chars[i]);
		}
	}

	public void showPlayerChoice() {
		try {
			/** sets image as frame background */
			Image bg = ImageIO.read(new File("res/backgrounds/background.png"));
			Gameplay.frame.setContentPane(new ImagePanel(bg));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x = 1, y = 3;
		putNereidImage();
		nereidDeclaration();
		for (int i = 0; i < 9; i++) {
			Icon nereid = nereidsImages.get(i);
			nereidPanel.add(new JPanel());
			nereidPanel.get(i).setBounds(x * 70, y * 70 - 10, 70, 70);
			nereidPanel.get(i).setOpaque(false);
			nereidButton.add(new JButton(nereid));
			nereidButton.get(i).addActionListener(tsHandler);
			nereidButton.get(i).setOpaque(false);
			nereidButton.get(i).setBorderPainted(false);
			nereidButton.get(i).setContentAreaFilled(false);
			nereidPanel.get(i).add(nereidButton.get(i));
			Gameplay.frame.add(nereidPanel.get(i));
			/** changes x, y in order to create a 3x3 table of nereid buttons */
			x = ((i + 1) % 3 == 0 ? 1 : x + 1);
			y = ((i + 1) % 3 == 0 ? y + 1 : y);
		}
		for (int i = 0; i < 3; i++) {
			teamPanel[i] = new JPanel();
			teamPanel[i].setBounds((i + 1) * 70, 420, 70, 70);
			teamPanel[i].setOpaque(false);
			Gameplay.frame.add(teamPanel[i]);
		}
		/** needs to be here in order for the frame to appear */
		Gameplay.frame.setVisible(true);
	}

	public void nereidChoiceDisplay(String name) {
		if (namePanel != null) {
			namePanel.removeAll();
		}

		namePanel = new JPanel();
		namePanel.setBounds(400, 30, 500, 500);
		namePanel.setOpaque(false);
		Gameplay.frame.add(namePanel);

		nameArea = new JTextArea(name);
		nameArea.setEditable(false);
		nameArea.setBounds(400, 30, 500, 500);
		nameArea.setFont(nameFont);
		nameArea.setOpaque(false);
		nameArea.setForeground(new Color(6, 45, 98));
		namePanel.add(nameArea);

		if (iconPanel != null) {
			iconPanel.removeAll();
		}
		iconPanel = new JPanel();
		iconPanel.setBounds(525, 115, 250, 250);
		iconPanel.setOpaque(false);

		int currentIndex = nereidNames.indexOf(name);
		picLabel = new JLabel(resize(nereidsImages.get(currentIndex), 100, 100));
		iconPanel.add(picLabel);
		Gameplay.frame.add(iconPanel);

		if (charPanel != null) {
			charPanel.removeAll();
		}
		charPanel = new JPanel();
		charPanel.setBounds(550, 225, 210, 240);
		charPanel.setOpaque(false);
		Gameplay.frame.add(charPanel);

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
		choicePanel.setBounds(600, 450, 100, 100);
		choicePanel.setOpaque(false);
		Gameplay.frame.add(choicePanel);

		/**
		 * Use the chosenNereidsIndexes array to check whether or not a certain nereid
		 * has already been chosen
		 */
		if (currentIndex != chosenNereidsIndexes[0] && currentIndex != chosenNereidsIndexes[1]
				&& currentIndex != chosenNereidsIndexes[2]) {
			choiceButton[currentIndex] = new JButton(" Choose her... ");
			choiceButton[currentIndex].addActionListener(tsHandler);
			choicePanel.add(choiceButton[currentIndex]);
		}
		Gameplay.frame.repaint();
		Gameplay.frame.setMinimumSize(Gameplay.frame.getSize());
		Gameplay.frame.pack();
		Gameplay.frame.setMinimumSize(null);
	}

	public void chooseTeam(int i) {

		choiceButton[i].setVisible(false);
		try {
			chosenNereidsIndexes[numOfChoice] = i;
			JLabel currentPic = new JLabel(picLabel.getIcon());
			teamPanel[numOfChoice].add(currentPic);
			/** use it to check when the player has chosen three nereids */
			numOfChoice++;
			/** Update array with total characteristics of the nereids */
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
			txtPanel.setBounds(275, 150, 300, 60);
			txtPanel.setOpaque(false);
			JTextArea txt = new JTextArea("READY TO PLAY?");
			txt.setOpaque(false);
			txt.setForeground(new Color(6, 45, 98));
			txt.setFont(new Font("Tahoma", Font.BOLD, 35));
			txtPanel.add(txt);
			JPanel btnPanel = new JPanel();
			btnPanel.setBounds(340, 200, 150, 50);
			btnPanel.setOpaque(false);
			btnPanel.add(playButton);
			Gameplay.frame.add(txtPanel);
			Gameplay.frame.add(btnPanel);

		}

		Gameplay.frame.setMinimumSize(Gameplay.frame.getSize());
		Gameplay.frame.pack();
		Gameplay.frame.setMinimumSize(null);
	}

	/**
	 * returns an int [3] with the numbers of the chosen nereids integers from 0 to
	 * 8 as in the array
	 */
	public int[] getChosenNereids() {
		return chosenNereidsIndexes;
	}

	public class TitleScreenHandler implements ActionListener {
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
