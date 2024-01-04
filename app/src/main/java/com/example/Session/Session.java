package com.example.Session;

import com.example.Dice.DiceRoll;
import com.example.CharacterSheet.CharacterSheet;

import java.io.Serializable;
import java.util.ArrayList;

public class Session  implements Serializable {
    private int id;
    private CharacterSheet characterSheet;
    private ArrayList<DiceRoll> diceRolls;

    public Session(CharacterSheet characterSheet) {
        this.id = this.hashCode();
        this.characterSheet = characterSheet;
        this.diceRolls = new ArrayList<DiceRoll>();
    }

    public Session() {
        this.id = this.hashCode();
        this.characterSheet = new CharacterSheet();
        this.diceRolls = new ArrayList<DiceRoll>();
    }

    public void addDiceRoll(DiceRoll diceRoll) {
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
