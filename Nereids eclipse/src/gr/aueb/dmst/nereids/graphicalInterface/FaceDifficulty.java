/**
 * contains static method FAceDifficulty (Difficulty d)
 * used to face difficulty 
 * calls methods to check if the characteristics are enough
 * increases / decreases score
 * updated the total Characteristics
 *
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.util.Arrays;

import gr.aueb.dmst.nereids.commandLine.Difficulty;

public class FaceDifficulty {
	public static void faceDifficulty(Difficulty d) {
		int[] difChars = { d.getAgility(), d.getOrganization(), d.getWisdom(), d.getWindlessness(), d.getCourage(),
				d.getStrength(), d.getAnimalF(), d.getOrientation(), d.getJustice() };
		int[] totalChars = Status.getTotalChars();
		System.out.println("chars for the difficulty: " + Arrays.toString(difChars));
		System.out.println(Arrays.toString(totalChars));
		/*
		 * for (int j = 0; j < 9; j++ ) { if (totalChars[j] < difChars[j]) {
		 * Status.setScore(Status.getScore() - (difChars[j] - totalChars[j]) ); if
		 * (Status.getScore() == 0 ) { System.out.println("GAME OVER"); } else {
		 * System.out.println("You were defeated. Score decreased by: " + (difChars[j] -
		 * totalChars[j])); } if (totalChars[j] != 0) { Status.update(j, difChars[j]); }
		 * totalChars[j] = 0; } else if (totalChars[j] >= difChars[j]) { totalChars[j] =
		 * totalChars[j] - difChars[j]; Status.update(j, difChars[j]); }
		 * System.out.println(Arrays.toString(totalChars));
		 * 
		 * }
		 */
		System.out.println("the total stats now are: " + Arrays.toString(totalChars));
		boolean notFaced = false;
		// XXX not completed
		String [] lostCharNames = { null, null, null, null, null, null, null, null, null};
		int [] lostCharAmount = { 0, 0, 0, 0, 0, 0, 0, 0, 0};
		// 9 repetitions bc 9 characteristics to check
		for (int j = 0; j < 9; j++) {
			if (totalChars[j] < difChars[j] && difChars[j] > 0) {
				notFaced = true;

				Status.setScore(Status.getScore() - (difChars[j] - totalChars[j]));
				if (Status.getScore() <= 0) {
					Status.setScore(0);
					System.out.println("GAME OVER");
				}
				System.out.println("You were defeated. Score decreased by: " + (difChars[j] - totalChars[j]));

				totalChars[j] = 0;
			} else if (totalChars[j] >= difChars[j] && difChars[j] > 0) {
				// Status.setScore(Status.getScore() + 2);
				totalChars[j] = totalChars[j] - difChars[j];
				
			// XXX change button color not working
				/*
				// change the button color to red to show the decrease
				BoatFrame.ssp.changeToRed(j);

				
				// sleep for half a second for the color change to be shown
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				System.out.println("You did it " + j);
			}
			Status.setTotalChars(totalChars);

		}
		// if difficulty if faced increase score by 2
		if (notFaced == false) {
			System.out.println("Score increased by 2");
			Status.increaseScoreByTwo();
		}
		System.out.println("You now have: " + Arrays.toString(totalChars));
		System.out.println("Score: " + Status.getScore());
		System.out.println(".......");
		Status.update(); // new difficulties

	}
}
