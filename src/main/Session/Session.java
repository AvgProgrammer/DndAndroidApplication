package Session;

import Dice.DiceRoll;
import CharacterSheet.CharacterSheet;

import java.util.ArrayList;

public class Session {
    private int id;
    private CharacterSheet characterSheet;
    private ArrayList<DiceRoll> diceRolls;

    public Session(CharacterSheet characterSheet) {
        this.id = this.hashCode();
        this.characterSheet = characterSheet;
        this.diceRolls = new ArrayList<DiceRoll>();
    }

    public Session() {
        this.id = -1;
        this.characterSheet = null;
        this.diceRolls = null;
    }

    public void addDiceRoll(DiceRoll diceRoll){
        this.diceRolls.add(diceRoll);
    }

    public void addExpPoints(int expPoints) {
        this.characterSheet.addExp(expPoints);
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public CharacterSheet getCharacterSheet() {
        return this.characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    public ArrayList<DiceRoll> getDiceRolls() {
        return this.diceRolls;
    }

    public void setDiceRolls(ArrayList<DiceRoll> diceRolls) {
        this.diceRolls = diceRolls;
    }
}
