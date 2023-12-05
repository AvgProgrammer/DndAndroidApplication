package CharacterSheet;

public class CharacterSheet {

	private String name, gender, description;
	private int ID, level, expPoints;
	private int strength, dexterity, constitution, intelligence, wisdom, charisma;
	private DnDClass dndClass;
	private Race race;

	public CharacterSheet() {
		this.name = "";
		this.ID = this.hashCode();
		this.strength = this.dexterity = this.constitution = this.intelligence = this.wisdom = this.charisma = this.level = this.expPoints = 0;
		this.gender = "Unknown";
		this.description = "";
		this.dndClass = null;
		this.race = null;
	}

	public CharacterSheet(String name, int ID, String gender, String description, DnDClass dndClass, Race race,
			int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int expPoints) {
		this.name = name;
		this.ID = ID;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.expPoints = expPoints;
		this.level = getlevel();
		this.gender = gender;
		this.description = description;
		this.dndClass = dndClass;
		this.race = race;
	}

	public void addExp(int exp) {
		this.expPoints = expPoints + exp;
		if (this.expPoints >= 1000 * level)
			this.level = ((this.expPoints) / 1000) + 1;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.ID;
	}

	public String getGender() {
		return this.gender;
	}

	public String getDescription() {
		return this.description;
	}

	public DnDClass getdndClass() {
		return this.dndClass;
	}

	public Race getRace() {
		return this.race;
	}

	public int getStrength() {
		return this.strength;
	}

	public int getDexterity() {
		return this.dexterity;
	}

	public int getConsitution() {
		return this.constitution;
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	public int getWisdom() {
		return this.wisdom;
	}

	public int getCharisma() {
		return this.charisma;
	}

	public int getStrengthModifier() {
		return getModifier(this.strength);
	}

	public int getDexterityModifier() {
		return getModifier(this.dexterity);
	}

	public int getConsitutionModifier() {
		return getModifier(this.constitution);
	}

	public int getIntelligenceModifier() {
		return getModifier(this.intelligence);
	}

	public int getWisdomModifier() {
		return getModifier(this.wisdom);
	}

	public int getCharismaModifier() {
		return getModifier(this.charisma);
	}

	private int getModifier(int ability) {
		if (ability % 2 != 0) {
			return getModifier(ability - 1);
		}
		return (ability - 10) / 2;
	}

	public int getlevel() {
		this.level = ((this.expPoints) / 1000) + 1;
		return level;
	}

	public int getExp(){
		return this.expPoints;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setdndClass(DnDClass dndClass) {
		this.dndClass = dndClass;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public void setExpPoints(int exp) {
		this.expPoints = exp;
	}

}
