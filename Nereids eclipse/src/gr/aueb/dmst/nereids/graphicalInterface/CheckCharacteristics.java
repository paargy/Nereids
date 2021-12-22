/*
 * class NOT USED
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import gr.aueb.dmst.nereids.commandLine.CommandLineGameplay;
import gr.aueb.dmst.nereids.commandLine.Difficulty;
import gr.aueb.dmst.nereids.commandLine.Nereids;
import gr.aueb.dmst.nereids.commandLine.Score;

public class CheckCharacteristics {
	public static void checkCharacteristics() {
		int choice = Status.getDifChoice();
		Difficulty d = CommandLineGameplay.getDif()[ choice ];
		// dc --> difficulty characteristics: characteristics needed to overcome the difficulty
		int[] dc = { d.getAgility(), d.getOrganization(), d.getWisdom(), d.getWindlessness(), d.getCourage(),
				d.getStrength(), d.getAnimalF(), d.getOrientation(), d.getJustice() };
		int count  = 0;
		// tc --> total characteristics 
		int [] tc = Status.getTotalChars();
		for (int j = 0; j < 9; j++) {
			if (tc[j] < dc[j]) {
				for (int i = 0; i < (dc[j] - tc[j]); i++) {
					Status.setScore(Status.getScore() - 1);
					if (Status.score == 0) {
						System.out.println("GAME OVER");
						System.exit(0);
					}
				}
				System.out.println("Oh no you were defeated! Your score now is: " + Status.score);
				if (tc[j] != 0) {
					Status.update();; //XXX method changed
				}
				tc[j] = 0;
			} else {
				tc[j] = tc[j] - dc[j];
				Status.update(); // XXX method changed
			}

		}

	}

}
