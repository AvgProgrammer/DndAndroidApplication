package Dice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class DiceRollTest {
    DiceRoll roll;
    Dice.IDiceRNG rng = new DiceRNGStub();

    @BeforeEach
    void setUp() {
        roll=new DiceRoll();
        roll.setDiceRNG(rng);
    }

    @AfterEach
    public void tearDown() {
        roll = null;
    }

    @Test
    public void getResult(){
        roll.roll();
        assertEquals(15, roll.getResult());
    }

    @Test
    public void getResultWithModifier(){
        DiceRoll testRoll=new DiceRoll(1);
        testRoll.setDiceRNG(rng);
        testRoll.roll();
        assertEquals(16, testRoll.getResult());
    }

    @Test
    public void setResult(){
        roll.setResult(5);
        assertEquals(5, roll.getResult());
    }

    @Test
    public void getModifier(){
        DiceRoll testRoll=new DiceRoll(4);
        testRoll.setDiceRNG(rng);
        assertEquals(4,testRoll.getModifier());
    }

    @Test
    public void setModifier(){
        roll.setModifier(2);
        assertEquals(2, roll.getModifier());
    }

    @Test
    public void getDescription(){
        assertEquals("D20",roll.getDescription());
    }

    @Test
    public void getDescriptionWithModifier(){
        DiceRoll testRoll=new DiceRoll(2);
        testRoll.setDiceRNG(rng);
        assertEquals("D20 + 2",testRoll.getDescription());
    }

    @Test
    public void getDescriptionWithArgument(){
        DiceRoll testRoll=new DiceRoll(3, "Charisma check");
        testRoll.setDiceRNG(rng);
        assertEquals("Charisma check",testRoll.getDescription());
    }

    @Test
    public void setDescription(){
        roll.setDescription("Athletics check");
        assertEquals("Athletics check", roll.getDescription());
    }

    @Test
    public void checkResultRange(){
        Dice.IDiceRNG testRNG = new Dice.DiceRNGImpl();
        roll.setDiceRNG(testRNG);
        roll.roll();
        int result=roll.getResult();
        assertTrue((1 <= result && 20 >= result));
    }


}
