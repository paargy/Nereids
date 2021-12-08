package em;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

public class PlayerChoice {
	JFrame window;
	JPanel namePanel, charPanel, teamPanel;
	JPanel[] nereidPanel = new JPanel[9];
	JLabel nameLabel;
	JTextArea charArea;
	Font nameFont = new Font("MS Gothic", Font.BOLD, 60);
	Font charFont = new Font("Stgotic", Font.PLAIN, 30);
	JButton[] nereidButton = new JButton[9];
	int tileSize = 48;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	
	public static void main(String[] args) {
		new PlayerChoice();
	}
	
	public PlayerChoice() {
		
		BufferedImage bg;
		window = new JFrame();
		window.setTitle("E R E I D S");
		
		ImageIcon logo = new ImageIcon("res/logo/logo.png");
		window.setIconImage(logo.getImage());
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/backgrounds/mainbg.png"));
			window.setContentPane(new ImagePanel(bg));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		window.setSize(new Dimension(1200, 700));
		//window.setContentPane(new JLabel(new ImageIcon(bg)));
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.blue);
		window.setLayout(null);
		
		//
		//myJFrame.setContentPane(new ImagePanel(myImage));
		/*
		namePanel = new JPanel();
		namePanel.setBounds(90, 100, 1000, 100);
		namePanel.setBackground(Color.blue);
		
		nameLabel = new JLabel("Doris");
		nameLabel.setForeground(Color.black);
		nameLabel.setFont(nameFont);
		
		namePanel.add(nameLabel);
		
		//window.add(namePanel);*/
		
		int x = 1, y = 2, i = 0;
		Icon nereid;
		
		while (i < 9) {
			nereid = new ImageIcon("res/nereids/nereid" + 1 + ".png");
			
			nereidPanel[i] = new JPanel();
			nereidPanel[i].setBounds(x*100, y*100, 100, 100);
			//nereidPanel[i].setBackground(Color.blue);
			nereidPanel[i].setOpaque(false);
			
			
			nereidButton[i] = new JButton(nereid);
			//nereidButton[i].setBackground(Color.blue);
			nereidButton[i].setFont(nameFont);
			nereidButton[i].addActionListener(tsHandler);
			
			//nereidButton[i].setOpaque(false);
			nereidButton[i].setContentAreaFilled(false);
			//nereidButton[i].setBorderPainted(false);
			
			nereidPanel[i].add(nereidButton[i]);
			window.add(nereidPanel[i]);
			
			x = ((i + 1) % 3 == 0 ? 1 : x+1);
			y = ((i + 1) % 3 == 0 ? y+1 : y);
			i++;
		}
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	public void createGameScreen() {
		charPanel = new JPanel();
		charPanel.setBounds(800, 50, 200, 200);
		charPanel.setOpaque(false);
		window.add(charPanel);
		
		charArea = new JTextArea("DORIS");
		charArea.setBounds(800, 50, 200, 200);
		charArea.setBackground(Color.red);
		charArea.setForeground(Color.white);
		charPanel.add(charArea);
		window.repaint();
		
		window.setMinimumSize(window.getSize());
		window.pack();
		window.setMinimumSize(null);
	}
	
	public class TitleScreenHandler implements ActionListener {	
		@Override
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			if (obj == nereidButton[0]) {
				System.out.println("it works!!");
				createGameScreen();
			} else if (obj == nereidButton[1]) {
				createGameScreen();
			} else if (obj == nereidButton[2]) {
				createGameScreen();
			} else if (obj == nereidButton[3]) {
				createGameScreen();
			} else if (obj == nereidButton[4]) {
				createGameScreen();
			} else if (obj == nereidButton[5]) {
				createGameScreen();
			} else if (obj == nereidButton[6]) {
				createGameScreen();
			} else if (obj == nereidButton[7]) {
				createGameScreen();
			} else if (obj == nereidButton[8]) {
				createGameScreen();
			}
		}
	}
	
}

