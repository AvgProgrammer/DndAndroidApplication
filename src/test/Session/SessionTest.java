package Session;

import org.junit.jupiter.api.Test;

import Dice.DiceRoll;
import Session.Session;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class SessionTest {
    Session session;

    @BeforeEach
    void setUp() {
        this.session = new Session();
    }

    @AfterEach
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

}
