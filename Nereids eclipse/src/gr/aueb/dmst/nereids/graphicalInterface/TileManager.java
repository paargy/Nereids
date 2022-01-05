package gr.aueb.dmst.nereids.graphicalInterface;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/** 
 * Creates and manages tiles
 * 
 * Creates all the tiles that will be used throughout
 * main game and draws them efficiently.
 */

public class TileManager {
	GamePanel gp;
	/** contains the different tile objects (one time each) that will be used */
	Tile[] tile;
	/** contains all the tiles that will be used to create the map (as many times as needed) */
	int mapTileNum[][];
	ImageTool iTool = new ImageTool();

	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[17];
		mapTileNum = new int[gp.maxMapRow][gp.maxMapCol];
		getTileImage();
		loadMap("/maps/mediterraneanmap.txt");
	}

	public void getTileImage() {
		setup(0, "water1", false);
		setup(1, "water2", false);
		setup(2, "water3", false);
		setup(3, "sand1", true);
		setup(4, "sand2", true);
		setup(5, "sand3", true);
		setup(6, "sand5", true);
		setup(7, "rocks1", true);
		setup(8, "rocks2", true);
		setup(9, "sand6", true);
		setup(10, "sand7", true);
		setup(11, "sand8", true);
		setup(12, "sand10", true);
		setup(13, "grass1", true);
		setup(14, "grass2", true);
		setup(15, "grass3", true);
		setup(16, "grass4", true);
	}

	public void setup(int index, String path, boolean collision) {
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + path + ".png"));
			tile[index].image = iTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String map) {
		try {
			InputStream is = getClass().getResourceAsStream(map);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			String[] numbers;
			int num;
			for (int row = 0; row < gp.maxMapRow; row++) {
				line = br.readLine();
				for (int col = 0; col < gp.maxMapCol; col++) {
					numbers = line.split(" ");
					num = Integer.parseInt(numbers[col]);
					mapTileNum[row][col] = num;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		int x, y;
		int screenX, screenY;
		int tileNum;
		for (int mapRow = 0; mapRow < gp.maxMapRow; mapRow++) {
			for (int mapCol = 0; mapCol < gp.maxMapCol; mapCol++) {
				tileNum = mapTileNum[mapRow][mapCol];
				x = mapCol * gp.tileSize;
				y = mapRow * gp.tileSize;
				screenX = x - gp.boat.mapX + gp.boat.screenX;
				screenY = y;
				/** improves efficiency because it draws only the tiles that are/will soon be on the screen */
				if (x + gp.tileSize > gp.boat.mapX - gp.boat.screenX && x - gp.tileSize < gp.boat.mapX + gp.boat.screenX * 8) {
					g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				}
			}
		}	
	}
}
