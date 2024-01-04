package com.example.Session;

import org.junit.Test;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Dice.DiceRoll;
import com.example.Session.Session;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

public class SessionTest {
    Session session;

    @Before
    public void setUp() {
        this.session = new Session();
    }

    @After
    public void tearDown() {
        session = null;
    }

    @Test
    public void addDiceRoll() {
        DiceRoll roll = new DiceRoll(2);
        session.addDiceRoll(roll);
        assertEquals(roll, session.getDiceRolls().get(0));
    }

    @Test
    public void addExpPoints() {
        session.addExpPoints(3000);
        assertEquals(3000, session.getCharacterSheet().getExp());
    }

    @Test
    public void getID() {
        assertEquals(session.hashCode(), session.getID());
    }

    @Test
    public void setID() {
        session.setID(1234);
        assertEquals(1234, session.getID());
    }

    @Test
    public void getCharacterSheet() {
        CharacterSheet c = new CharacterSheet();
        Session tempSession = new Session(c);
        assertEquals(c, tempSession.getCharacterSheet());
    }

    @Test
    public void setCharacterSheet() {
        CharacterSheet c = new CharacterSheet();
        session.setCharacterSheet(c);
        assertEquals(c, session.getCharacterSheet());
    }

    @Test
    public void getDiceRolls() {
        DiceRoll roll1 = new DiceRoll(1);
        DiceRoll roll2 = new DiceRoll();
        DiceRoll roll3 = new DiceRoll(1, "Wisdom check");

        session.addDiceRoll(roll1);
        session.addDiceRoll(roll2);
        session.addDiceRoll(roll3);

        ArrayList<DiceRoll> rolls = new ArrayList<DiceRoll>();
        rolls.add(roll1);
        rolls.add(roll2);
        rolls.add(roll3);

        assertArrayEquals(rolls.toArray(), session.getDiceRolls().toArray());
    }

    @Test
    public void setDiceRolls() {
        ArrayList<DiceRoll> rolls = new ArrayList<DiceRoll>();
        rolls.add(new DiceRoll(-1));
        rolls.add(new DiceRoll());
        rolls.add(new DiceRoll(2, "Charisma check"));

        session.setDiceRolls(rolls);

        assertArrayEquals(rolls.toArray(), session.getDiceRolls().toArray());
    }

}
