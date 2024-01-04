package com.example.CharacterSheet;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;

import com.example.CharacterSheet.CharacterSheet;

public class CharacterSheetTest {

    private CharacterSheet characterSheet;

    @Before
    public void setUp() {
        characterSheet = new CharacterSheet("", 0, null, "", null, null, 0, 0, 0, 0, 0, 0,0);
    }

    @After
    public void tearDown() {
        characterSheet = null;
    }

    @Test
    public void testSetName() {
        characterSheet.setName("John");
        Assert.assertEquals("John", characterSheet.getName());
    }

    @Test
    public void testSetID() {
        characterSheet.setID(123);
        Assert.assertEquals(123, characterSheet.getID());
    }

    @Test
    public void testSetGender() {
        characterSheet.setGender("Male");
        Assert.assertEquals("Male", characterSheet.getGender());
    }

    @Test
    public void testSetDescription() {
        characterSheet.setDescription("Test Description");
        Assert.assertEquals("Test Description", characterSheet.getDescription());
    }

    @Test
    public void testSetRace() {
        characterSheet.setRace(Race.Human);
        Assert.assertEquals(Race.Human, characterSheet.getRace());
    }

    @Test
    public void testSetDndClass() {
        characterSheet.setdndClass(DnDClass.Wizard);
        Assert.assertEquals(DnDClass.Wizard, characterSheet.getdndClass());
    }

    @Test
    public void testSetStrength() {
        characterSheet.setStrength(18);
        Assert.assertEquals(18, characterSheet.getStrength());
    }

    @Test
    public void testSetDexterity() {
        characterSheet.setDexterity(16);
        Assert.assertEquals(16, characterSheet.getDexterity());
    }

    @Test
    public void testSetConstitution() {
        characterSheet.setConstitution(14);
        Assert.assertEquals(14, characterSheet.getConsitution());
    }

    @Test
    public void testSetIntelligence() {
        characterSheet.setIntelligence(12);
        Assert.assertEquals(12, characterSheet.getIntelligence());
    }

    @Test
    public void testSetWisdom() {
        characterSheet.setWisdom(10);
        Assert.assertEquals(10, characterSheet.getWisdom());
    }

    @Test
    public void testSetCharisma() {
        characterSheet.setCharisma(8);
        Assert.assertEquals(8, characterSheet.getCharisma());
    }
    @Test
    public void testGetStrengthModifier() {
        characterSheet.setStrength(12);
        Assert.assertEquals(1, characterSheet.getStrengthModifier());
    }

    @Test
    public void testGetDexterityModifier() {
        characterSheet.setDexterity(17);
        Assert.assertEquals(3, characterSheet.getDexterityModifier());
    }

    @Test
    public void testGetConstitutionModifier() {
        characterSheet.setConstitution(9);
        Assert.assertEquals(-1, characterSheet.getConsitutionModifier());
    }

    @Test
    public void testGetIntelligenceModifier() {
        characterSheet.setIntelligence(15);
        Assert.assertEquals(2, characterSheet.getIntelligenceModifier());
    }

    @Test
    public void testGetWisdomModifier() {
        characterSheet.setWisdom(5);
        Assert.assertEquals(-3, characterSheet.getWisdomModifier());
    }

    @Test
    public void testGetCharismaModifier() {
        characterSheet.setCharisma(9);
        Assert.assertEquals(-1, characterSheet.getCharismaModifier());
    }

    @Test
    public void testaddExp(){
        characterSheet.addExp(2001);
        Assert.assertEquals(3, characterSheet.getlevel());
    }
}
