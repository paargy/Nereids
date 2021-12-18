package gr.aueb.dmst.nereids.commandLine;

import java.util.LinkedHashMap;
public class TotalCharacteristics {
  public static LinkedHashMap<String,Integer> charMap = new LinkedHashMap<>();

  public static void totalChars(Nereids n1, Nereids n2, Nereids n3){
	      charMap.put("Agility", n1.getAgility() + n2.getAgility() + n3.getAgility());
		  charMap.put("Organization", n1.getOrganization() + n2.getOrganization() + n3.getOrganization());
		  charMap.put("Wisdom", n1.getWisdom() + n2.getWisdom() + n3.getWisdom());
		  charMap.put("Windlessness", n1.getWindlessness() + n2.getWindlessness() + n3.getWindlessness());
		  charMap.put("Courage", n1.getCourage() + n2.getCourage() + n3.getCourage());
		  charMap.put("Strength", n1.getStrength() + n2.getStrength() + n3.getStrength());
		  charMap.put("Animal friendly", n1.getAnimalF() + n2.getAnimalF() + n3.getAnimalF());
		  charMap.put("Orientation", n1.getOrientation() + n2.getOrientation() + n3.getOrientation());
		  charMap.put("Justice", n1.getJustice() + n2.getJustice() + n3.getJustice());
  }
  
  public void showTotalChars() {
	  System.out.println(charMap);
  }
  

  public void setAgility (int x) {
	charMap.put("Agility",charMap.get("Agility")+x);
  }

  public void setOrganization (int x) {
	charMap.put("Organization",charMap.get("Organization")+x);
  }

	public void setWisdom (int x) {
		charMap.put("Wisdom",charMap.get("Wisdom")+x);
	}

	public void setWindlessness (int x) {
		charMap.put("Windlessness",charMap.get("Windlessness")+ x);
	}

	public void setCourage (int x) {
		charMap.put("Courage",charMap.get("Courage")+x);
	}

	public void setStrength (int x) {
		charMap.put("Strength",charMap.get("Strength")+x);
	}

	public void setAnimalF (int x) {
		charMap.put("Animal friendly",charMap.get("Animal friendly")+x);
	}

	public void setOrientation (int x) {
		charMap.put("Orientation",charMap.get("Orientation")+x);
	}

	public void setJustice (int x) {
		charMap.put("Justice",charMap.get("Justice")+x);
	}

	public static int getTotalAgility() {
		return charMap.get("Agility");
	}

	public static int getTotalOrganization() {
		return charMap.get("Organization");
	}

	public static int getTotalWisdom() {
		return charMap.get("Wisdom");
	}

	public static int getTotalWindlessness() {
		return charMap.get("Windlessness");
	}

	public static int getTotalCourage() {
		return charMap.get("Courage");
	}

	public static int getTotalStrength() {
		return charMap.get("Strength");
	}

	public static int getTotalAnimalF() {
		return charMap.get("Animal friendly");
	}

	public static int getTotalOrientation() {
		return charMap.get("Orientation");
	}

	public static int getTotalJustice() {
		return charMap.get("Justice");
	}
}