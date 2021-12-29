/**
 *  PlayerChoice screen. 
 * changes the Gameplay.frame to the player choice screen 
 * 9 nereid buttons on the left side and 
 * when chosen, the characteristics of the nereid on the 
 * right side. 
 * Button "chose her" at the bottom right side.
 * Can choose 3 nereids.
 * The same nereid cannot be chosen twice.
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerChoice {
	static JFrame frame;
	JPanel namePanel, charPanel, iconPanel, choicePanel;
	JPanel[] teamPanel = new JPanel[3];
	JButton[] choiceButton = new JButton[9];
	int numOfChoice;
	// These values will make it not cause an error on the first time the array is
	// used
	static int[] chosenNereidsIndexes = { 99, 99, 99 };

	ArrayList<JPanel> nereidPanel = new ArrayList<>();
	JLabel nameLabel;
	JTextArea nameArea, charArea;
	Font nameFont = new Font("Tahoma", Font.BOLD, 60);
	Font charFont = new Font("Tahoma", Font.BOLD, 15);
	ArrayList<JButton> nereidButton = new ArrayList<>();
	JLabel picLabel;
	ArrayList<ImageIcon> nereidsImages = new ArrayList<>();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ArrayList<String> nereidNames = new ArrayList<>(
			Arrays.asList("Actaea", "Doris", "Euagore", "Eucrate", "Eupompe", "Thetis", "Thoe", "Menippe", "Ploto"));
	int[] totalChars = new int[9]; // Use this to get the total characteristics of the chosen nereids

	// Create a HashMap that connects each nereid with her characteristics
	HashMap<String, int[]> nereidInfo = new HashMap<>();

	int[][] chars = { { 2, 0, 2, 0, 0, 0, 0, 3, 1 }, { 0, 2, 0, 2, 2, 0, 3, 0, 0 }, { 0, 1, 2, 0, 0, 0, 0, 2, 1 },
			{ 2, 0, 0, 2, 3, 2, 0, 0, 0 }, { 1, 2, 2, 0, 0, 1, 0, 0, 0 }, { 0, 4, 0, 0, 0, 2, 0, 1, 1 },
			{ 4, 2, 0, 2, 0, 0, 0, 0, 0 }, { 2, 3, 0, 0, 3, 0, 0, 0, 0 }, { 4, 1, 0, 0, 2, 0, 0, 0, 0 } };

	public void putNereidImage() {
		for (int i = 0; i < 9; i++) {
			nereidsImages.add(new ImageIcon("Images/nereid" + 1 + ".png")); // Change 1 to i + 1 once we have the nereid
																			// images ready
		}
	}

	public void nereidDeclaration() {
		for (int i = 0; i < 9; i++) {
			nereidInfo.put(nereidNames.get(i), chars[i]);
		}
	}
	/*
	public static void main(String[] args) {

		// Make the frame with the logo and the background image
		frame = new JFrame();
		frame.setTitle("N E R E I D S");
		ImageIcon logo = new ImageIcon("Images/logo.png");
		frame.setIconImage(logo.getImage());
		frame.setSize(new Dimension(600, 600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);

		new PlayerChoiceFrame(frame);
	}
	*/

	public PlayerChoice() {

		try {
			Image bg = ImageIO.read(new File("Images/mainbg.png"));
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
			nereidPanel.get(i).setBounds(x * 70, y * 70, 70, 70);
			nereidPanel.get(i).setOpaque(false);

			nereidButton.add(new JButton(nereid));
			nereidButton.get(i).addActionListener(tsHandler);
			
			nereidButton.get(i).setOpaque(false);
			nereidButton.get(i).setBorderPainted(false);
			nereidButton.get(i).setContentAreaFilled(false);
			

			nereidPanel.get(i).add(nereidButton.get(i));
			Gameplay.frame.add(nereidPanel.get(i));

			// Change x, y in order to create a 3x3 table of nereid buttons
			x = ((i + 1) % 3 == 0 ? 1 : x + 1);
			y = ((i + 1) % 3 == 0 ? y + 1 : y);
		}

		for (int i = 0; i < 3; i++) {
			teamPanel[i] = new JPanel();
			teamPanel[i].setBounds((i + 1) * 70, 480, 70, 70);
			teamPanel[i].setOpaque(false);
			Gameplay.frame.add(teamPanel[i]);
		}

		// Need to be here in order for the frame to appear
		Gameplay.frame.setVisible(true);

	}

	public void nereidChoiceDisplay(String name) {
		if (namePanel != null) {
			namePanel.removeAll();
		}

		namePanel = new JPanel();
		namePanel.setBounds(200, 50, 500, 500);
		namePanel.setOpaque(false);
		Gameplay.frame.add(namePanel);

		nameArea = new JTextArea(name);
		nameArea.setEditable(false);
		nameArea.setBounds(200, 50, 500, 500);
		nameArea.setFont(nameFont);
		nameArea.setOpaque(false);
		nameArea.setForeground(Color.black);
		namePanel.add(nameArea);

		if (iconPanel != null) {
			iconPanel.removeAll();
		}
		iconPanel = new JPanel();
		iconPanel.setBounds(325, 180, 250, 250);
		iconPanel.setOpaque(false);

		int currentIndex = nereidNames.indexOf(name);

		picLabel = new JLabel(nereidsImages.get(currentIndex));
		iconPanel.add(picLabel);
		Gameplay.frame.add(iconPanel);

		if (charPanel != null) {
			charPanel.removeAll();
		}
		charPanel = new JPanel();
		charPanel.setBounds(350, 275, 200, 250);
		charPanel.setOpaque(false);
		Gameplay.frame.add(charPanel);

		charArea = new JTextArea("\n" + "  Agility: " + nereidInfo.get(name)[0] + "  " + "\n" + "  Organization: "
				+ nereidInfo.get(name)[1] + "  " + "\n" + "  Wisdom: " + nereidInfo.get(name)[2] + "  " + "\n"
				+ "  Windlessness: " + nereidInfo.get(name)[3] + "  " + "\n" + "  Courage: " + nereidInfo.get(name)[4]
				+ "  " + "\n" + "  Strength: " + nereidInfo.get(name)[5] + "  " + "\n" + "  Animal Friendliness: "
				+ nereidInfo.get(name)[6] + "  " + "\n" + "  Orientation: " + nereidInfo.get(name)[7] + "  " + "\n"
				+ "  Justice: " + nereidInfo.get(name)[8] + "  " + "\n");
		charArea.setEditable(false);
		charArea.setBounds(350, 275, 200, 250);
		charArea.setFont(charFont);
		charArea.setBackground(new Color(6, 45, 98));
		charArea.setForeground(Color.black);
		charPanel.add(charArea);

		if (choicePanel != null) {
			choicePanel.removeAll();
		}
		choicePanel = new JPanel();
		choicePanel.setBounds(400, 500, 100, 100);
		choicePanel.setOpaque(false);
		Gameplay.frame.add(choicePanel);

		// Use the chosenNereidsIndexes array to check whether or not a certain nereid
		// has already been chosen
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

		// choicePanel.getRootPane().remove(choiceButton[i]);
		choiceButton[i].setVisible(false);
		chosenNereidsIndexes[numOfChoice] = i;

		JLabel currentPic = new JLabel(picLabel.getIcon());
		teamPanel[numOfChoice].add(currentPic);

		// Use it to check when the player has chosen three nereids
		numOfChoice++;

		// Update array with total characteristics of the nereids
		for (int j = 0; j < 9; j++) {
			totalChars[j] += nereidInfo.get(nereidNames.get(i))[j];
		}

		Gameplay.frame.setMinimumSize(Gameplay.frame.getSize());
		Gameplay.frame.pack();
		Gameplay.frame.setMinimumSize(null);

		if (numOfChoice == 3) {
			System.out.println("You chose your team!!");
			System.out.println(Arrays.toString(getChosenNereids()));
			Gameplay.frame.dispose();
			StartGame game = new StartGame( getChosenNereids()[0], getChosenNereids()[1], getChosenNereids()[2]);
			// StartGame(); //den katalava me poia methodo ksekinaei to main paixnidi
			// //diegrapse auta ta comments meta!
		}
	}

	/*
	 * returns an int [3] with the numbers of the chosen nereids integers from 0 to
	 * 8 as in the array
	 */
	public static int[] getChosenNereids() {
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
