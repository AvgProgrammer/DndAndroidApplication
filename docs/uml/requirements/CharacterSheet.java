public class CharacterSheet{
		
		private String name, gender, description, Class, race;
		private int ID, strength, dexterity, constitution, intelligence, wisdom, charisma;
		
		public CharacterSheet(String name, int ID, String gender, String description, String Class, String race, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
			
			name = "";
			ID = strength = dexterity = constitution = intelligence = wisdom = charisma = 0;
			gender = null;
			description = "";
			Class = null;
			race = null;
			
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
		
		public void setRace(String race) {
			this.race = race;
		}
		
		public void setClass(String Class) {
			this.Class = Class;
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
		
		public String getRace() {
			return this.race;
		}
		
		public String getClass() {
			return this.Class;
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
		
		public String printSheet() {
			return getName();
		}
		
	}