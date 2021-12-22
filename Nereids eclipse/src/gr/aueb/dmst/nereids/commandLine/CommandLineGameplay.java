package gr.aueb.dmst.nereids.commandLine;

import java.util.Scanner;
import java.util.Random;

public class CommandLineGameplay {

	static Scanner s = new Scanner(System.in);
	public static Nereids[] nereids = new Nereids[9];
	public static Difficulty[] dif = new Difficulty[8];
	// static TotalCharacteristics t = new TotalCharacteristics();

	public static void createNereids() {
		nereids[0] = new Nereids(Nereids.names[0], 2, 0, 2, 0, 0, 0, 0, 3, 1);
		nereids[1] = new Nereids(Nereids.names[1], 0, 2, 0, 2, 2, 0, 3, 0, 0);
		nereids[2] = new Nereids(Nereids.names[2], 0, 1, 2, 0, 0, 0, 0, 2, 1);
		nereids[3] = new Nereids(Nereids.names[3], 2, 0, 0, 2, 3, 2, 0, 0, 0);
		nereids[4] = new Nereids(Nereids.names[4], 1, 2, 2, 0, 0, 1, 0, 0, 0);
		nereids[5] = new Nereids(Nereids.names[5], 0, 4, 0, 0, 0, 2, 0, 1, 1);
		nereids[6] = new Nereids(Nereids.names[6], 4, 2, 0, 2, 0, 0, 0, 0, 0);
		nereids[7] = new Nereids(Nereids.names[7], 2, 3, 0, 0, 3, 0, 0, 0, 0);
		nereids[8] = new Nereids(Nereids.names[8], 4, 1, 0, 0, 2, 0, 0, 0, 0);
	}

	public static void createDifficulties() {
		dif[0] = new Difficulty(Difficulty.dif[0], 2, 1, 0, 0, 0, 0, 0, 0, 0);
		dif[1] = new Difficulty(Difficulty.dif[1], 0, 0, 0, 1, 1, 1, 0, 0, 0);
		dif[2] = new Difficulty(Difficulty.dif[2], 1, 1, 0, 0, 1, 0, 0, 0, 0);
		dif[3] = new Difficulty(Difficulty.dif[3], 1, 1, 0, 0, 0, 1, 0, 0, 0);
		dif[4] = new Difficulty(Difficulty.dif[4], 1, 0, 0, 0, 1, 0, 1, 0, 0);
		dif[5] = new Difficulty(Difficulty.dif[5], 0, 0, 0, 1, 1, 0, 0, 1, 0);
		dif[6] = new Difficulty(Difficulty.dif[6], 0, 1, 1, 0, 0, 0, 0, 0, 1);
		dif[7] = new Difficulty(Difficulty.dif[7], 0, 0, 1, 0, 0, 0, 0, 2, 0);
	}

	public int[] createTeam() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("These are the names of the Nereids that will help you in your journey");
		int nereid;
		do {
			for (int i = 0; i < 9; i++) {
				System.out.println(i + 1 + ". " + " " + Nereids.names[i]);
			}
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(
					"Choose the number of the Nereid you want to see (if you don't want to see another Nereid choose 0)");
			nereid = s.nextInt();
			if (nereid != 0) {
				System.out.println(Nereids.names[nereid - 1] + "'s characteristics are:");
				System.out.println(nereids[nereid - 1].Characteristics());
			}
		} while (nereid != 0);
		System.out.println("Now it is time to choose your team. Pick the numbers of the three Nereids you want");
		int first = s.nextInt();
		System.out.println("You chose " + Nereids.names[first - 1]);
		int second = s.nextInt();
		while (first == second) {
			System.out.println("You already chose her. Please choose another one..");
			second = s.nextInt();
		}
		System.out.println("You chose " + Nereids.names[second - 1]);
		int third = s.nextInt();
		while (third == first || third == second) {
			System.out.println("You already chose her. Please choose another one..");
			third = s.nextInt();
		}
		System.out.println("You chose " + Nereids.names[third - 1]);
		TotalCharacteristics.totalChars(nereids[first - 1], nereids[second - 1], nereids[third - 1]);
		int[] tc = { TotalCharacteristics.getTotalAgility(), TotalCharacteristics.getTotalOrganization(),
				TotalCharacteristics.getTotalWisdom(), TotalCharacteristics.getTotalWindlessness(),
				TotalCharacteristics.getTotalCourage(), TotalCharacteristics.getTotalStrength(),
				TotalCharacteristics.getTotalAnimalF(), TotalCharacteristics.getTotalOrientation(),
				TotalCharacteristics.getTotalJustice() };
		TotalCharacteristics.showTotalChars();
		return tc;
	}

	public Difficulty level() {
		Random rand = new Random();
		System.out.println("Choose which challenge you think you can win...");
		int d1 = rand.nextInt(8);
		int d2 = rand.nextInt(8);
		while (d1 == d2) {
			d2 = rand.nextInt(8);
		}
		int d3 = rand.nextInt(8);
		while (d3 == d1 || d3 == d2) {
			d3 = rand.nextInt(8);
		}
		System.out.println(
				"1. " + Difficulty.dif[d1] + "\n" + "2. " + Difficulty.dif[d2] + "\n" + "3. " + Difficulty.dif[d3]);
		int a;
		int choice = s.nextInt();

		return dif[choice];
	}

	public static void checkCharacteristics(Difficulty d, int[] tc) {
		int[] dc = { d.getAgility(), d.getOrganization(), d.getWisdom(), d.getWindlessness(), d.getCourage(),
				d.getStrength(), d.getAnimalF(), d.getOrientation(), d.getJustice() };
		int count = 0;
		for (int j = 0; j < 9; j++) {
			if (tc[j] < dc[j]) {
				for (int i = 0; i < (dc[j] - tc[j]); i++) {
					Score.minusOne();
					if (Score.score == 0) {
						System.out.println("GAME OVER");
						System.exit(0);
					}
				}
				System.out.println("Oh no you were defeated! Your score now is: " + Score.score);
				if (tc[j] != 0) {
					updateChar(j, dc[j]);
				}
				tc[j] = 0;
				count++;
			} else {
				tc[j] = tc[j] - dc[j];
				updateChar(j, dc[j]);
			}

		}
		if (count == 0) {
			Score.DificultyOvercome();
			System.out.println("Congrats! Your score now is: " + Score.score);

		}
	}

	public static void updateChar(int i, int dc) {
		if (i == 0) {
			TotalCharacteristics.setAgility(TotalCharacteristics.getTotalAgility() - dc);
		} else if (i == 1) {
			TotalCharacteristics.setOrganization(TotalCharacteristics.getTotalOrganization() - dc);
		} else if (i == 2) {
			TotalCharacteristics.setWisdom(TotalCharacteristics.getTotalWisdom() - dc);
		} else if (i == 3) {
			TotalCharacteristics.setWindlessness(TotalCharacteristics.getTotalWindlessness() - dc);
		} else if (i == 4) {
			TotalCharacteristics.setCourage(TotalCharacteristics.getTotalCourage() - dc);
		} else if (i == 5) {
			TotalCharacteristics.setStrength(TotalCharacteristics.getTotalStrength() - dc);
		} else if (i == 6) {
			TotalCharacteristics.setAnimalF(TotalCharacteristics.getTotalAnimalF() - dc);
		} else if (i == 7) {
			TotalCharacteristics.setOrientation(TotalCharacteristics.getTotalOrientation() - dc);
		} else {
			TotalCharacteristics.setJustice(TotalCharacteristics.getTotalJustice() - dc);
		}
	}

	public void gameplay() {
		createNereids();
		createDifficulties();
		int[] team = createTeam();
		for (int i = 0; i < 8; i++) {
			Difficulty d = level();
			checkCharacteristics(d, team); // int [3] team
		}
		Score.showScore();
	}

	/*
	 * return the whole nereid table
	 */
	public static Nereids[] getNereids() {
		return nereids;
	}

	/*
	 * return the whole difficulty table
	 */
	public static Difficulty[] getDif() {
		return dif;
	}

}