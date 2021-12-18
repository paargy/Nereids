package gr.aueb.dmst.nereids.commandLine;

import java.util.LinkedHashMap;

public class Nereids {
	private LinkedHashMap<String, Integer> ch = new LinkedHashMap<String, Integer>();
	static String[] names = { "Actaea", "Doris", "Euagore", "Eucrate", "Eupompe", "Thetis", "Thoe", "Menippe",
			"Ploto" };
	private String name; // Nereid's name
	private int agility, organization, wisdom, windlessness, courage, strength, animalfriendly, orientation, justice; // Nereid's

	public Nereids(String name, int agility, int organization, int wisdom, int windlessness, int courage, int strength,
			int animalfriendly, int orientation, int justice) { // constructor
		this.name = name;
		this.agility = agility;
		this.organization = organization;
		this.wisdom = wisdom;
		this.windlessness = windlessness;
		this.courage = courage;
		this.strength = strength;
		this.animalfriendly = animalfriendly;
		this.orientation = orientation;
		this.justice = justice;
		this.Characteristics();
	}

	public String getName() { // returns Nereid's name
		return name;
	}

	public LinkedHashMap<String, Integer> Characteristics() {// returns the characteristic of the Nereid and the degree
																// of the characteristic

		ch.put("AGILITY", agility);
		ch.put("ORGANIZATION", organization);
		ch.put("WISDOM", wisdom);
		ch.put("WINDLESSNESS", windlessness);
		ch.put("COURAGE", courage);
		ch.put("STRENGTH", strength);
		ch.put("ANIMALFRIENDLY", animalfriendly);
		ch.put("ORIENTATION", orientation);
		ch.put("JUSTICE", justice);
		return ch;

	}

	public int getAgility() {
		return agility;
	}

	public int getOrganization() {
		return organization;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getWindlessness() {
		return windlessness;
	}

	public int getCourage() {
		return courage;
	}

	public int getStrength() {
		return strength;
	}

	public int getAnimalF() {
		return animalfriendly;
	}

	public int getOrientation() {
		return orientation;
	}

	public int getJustice() {
		return justice;
	}

}