/*
 * stores the status of the game 
 * chosen nereids, difficulties, score and all characteristics
 */
package gr.aueb.dmst.nereids.graphicalInterface;

import java.util.Random;

import gr.aueb.dmst.nereids.commandLine.*;

public class Status {
	// XXX command line gameplay: createNereids, createDifficulties
	static Difficulty d1; // the difficulties of the level
	static Difficulty d2;
	static Difficulty d3;
	static Nereids n1; // the chosen nereids
	static Nereids n2;
	static Nereids n3;
	static int difChoice;
	static int score;
	static int agility;
	static int organisation;
	static int wisdom;
	static int windlessness;
	static int courage;
	static int strength;
	static int animalFriendly;
	static int orientation;
	static int justice;
	static int level;

	/*
	 * Initialise with the default values Mainly to be used when restarting the game
	 */
	public static void Status() {
		score = 0;
		n1 = null;
		n2 = null;
		n3 = null;
		d1 = null;
		d2 = null;
		d3 = null;
		difChoice = 0;
		score = 0;
		agility = 0;
		organisation = 0;
		wisdom = 0;
		windlessness = 0;
		courage = 0;
		strength = 0;
		animalFriendly = 0;
		orientation = 0;
		justice = 0;
		level = 0;

	}

	/*
	 * constructor taking the Nereids objects Bring 3 random difficulties Refresh
	 * the Total Characteristics
	 */
	public static void Status(Nereids a, Nereids b, Nereids c) {
		// n1, n2, n3: the 3 chosen nereids

		n1 = a;
		n2 = b;
		n3 = c;

		// random choice 3 out of the 9 difficulties
		Random rand = new Random();
		int dif1 = rand.nextInt(8);
		int dif2 = rand.nextInt(8);
		while (dif1 == dif2) {
			dif2 = rand.nextInt(8);
		}
		int dif3 = rand.nextInt(8);
		// check if it is the same difficulty
		while (dif3 == dif1 || dif3 == dif2) {
			dif3 = rand.nextInt(8);
		}

		// turn it to Difficulty object
		d1 = CommandLineGameplay.dif[dif1];
		d2 = CommandLineGameplay.dif[dif2];
		d3 = CommandLineGameplay.dif[dif3];

		// set the total characteristics
		TotalCharacteristics.totalChars(n1, n2, n3);

		agility = TotalCharacteristics.getTotalAgility();
		organisation = TotalCharacteristics.getTotalOrganization();
		wisdom = TotalCharacteristics.getTotalWisdom();
		windlessness = TotalCharacteristics.getTotalWindlessness();
		courage = TotalCharacteristics.getTotalCourage();
		strength = TotalCharacteristics.getTotalStrength();
		animalFriendly = TotalCharacteristics.getTotalAnimalF();
		orientation = TotalCharacteristics.getTotalOrientation();
		justice = TotalCharacteristics.getTotalJustice();

	}

	/*
	 * The same as the above, but take the int numbers of the nereids
	 */
	public static void Status(int a, int b, int c) {

		// n1, n2, n3: the 3 chosen nereids
		assert a > 0 && a < 10;
		assert b > 0 && b < 10;
		assert c > 0 && c < 10;

		n1 = CommandLineGameplay.nereids[a];
		n2 = CommandLineGameplay.nereids[b];
		n3 = CommandLineGameplay.nereids[c];

		// random choice 3 out of the 9 difficulties
		Random rand = new Random();
		int dif1 = rand.nextInt(8);
		int dif2 = rand.nextInt(8);
		while (dif1 == dif2) {
			dif2 = rand.nextInt(8);
		}
		int dif3 = rand.nextInt(8);
		// check if it is the same difficulty
		while (dif3 == dif1 || dif3 == dif2) {
			dif3 = rand.nextInt(8);
		}

		// turn it to Difficulty object
		d1 = CommandLineGameplay.dif[dif1];
		d2 = CommandLineGameplay.dif[dif2];
		d3 = CommandLineGameplay.dif[dif3];

		// set the total characteristics
		TotalCharacteristics.totalChars(n1, n2, n3);

		agility = TotalCharacteristics.getTotalAgility();
		organisation = TotalCharacteristics.getTotalOrganization();
		wisdom = TotalCharacteristics.getTotalWisdom();
		windlessness = TotalCharacteristics.getTotalWindlessness();
		courage = TotalCharacteristics.getTotalCourage();
		strength = TotalCharacteristics.getTotalStrength();
		animalFriendly = TotalCharacteristics.getTotalAnimalF();
		orientation = TotalCharacteristics.getTotalOrientation();
		justice = TotalCharacteristics.getTotalJustice();
		;

	}

	public static int getAgility() {
		return agility;
	}

	public static void setAgility(int a) {
		agility = a;
	}

	public static int getOrganisation() {
		return organisation;
	}

	public static void setOrganisation(int o) {
		organisation = o;
	}

	public static int getWisdom() {
		return wisdom;
	}

	public static void setWisdom(int w) {
		wisdom = w;
	}

	public static int getWindlessness() {
		return windlessness;
	}

	public static void setWindlessness(int w) {
		windlessness = w;
	}

	public static int getCourage() {
		return courage;
	}

	public static void setCourage(int c) {
		courage = c;
	}

	public static int getStrength() {
		return strength;
	}

	public static void setStrength(int s) {
		strength = s;
	}

	public static int getAnimalFriendly() {
		return animalFriendly;
	}

	public static void setAnimalFriendly(int a) {
		animalFriendly = a;
	}

	public static int getOrientation() {
		return orientation;
	}

	public static void setOrientation(int o) {
		orientation = o;
	}

	public static int getJustice() {
		return justice;
	}

	public static void setJustice(int j) {
		justice = j;
	}

	public static Difficulty getD1() {
		return d1;
	}

	public static void setD1(Difficulty d) {
		d1 = d;
	}

	public static Difficulty getD2() {
		return d2;
	}

	public static void setD2(Difficulty d) {
		d2 = d;
	}

	public static Difficulty getD3() {
		return d3;
	}

	public static void setD3(Difficulty d) {
		d = d3;
	}

	public static Nereids getN1() {
		return n1;
	}

	public static void setN1(Nereids n) {
		n = n1;
	}

	public static Nereids getN2() {
		return n2;
	}

	public static void setN2(Nereids n) {
		n = n2;
	}

	public static Nereids getN3() {
		return n3;
	}

	public static void setN3(Nereids n) {
		n = n3;
	}

	public static int getDifChoice() {
		return difChoice;
	}

	public static void setDifChoice(int d) {
		d = difChoice;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int s) {
		s = score;
	}

}
