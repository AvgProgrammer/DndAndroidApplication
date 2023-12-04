package CharacterSheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.general.CharacterSheet;

public class CharacterSheetTest {

    private CharacterSheet characterSheet;

    @BeforeEach
    public void setUp() {
        characterSheet = new CharacterSheet("", 0, null, "", null, null, 0, 0, 0, 0, 0, 0);
    }

    @AfterEach
    public void tearDown() {
        characterSheet = null;
    }

    @Test
    public void testSetName() {
        characterSheet.setName("John");
        Assertions.assertEquals("John", characterSheet.getName());
    }

    @Test
    public void testSetID() {
        characterSheet.setID(123);
        Assertions.assertEquals(123, characterSheet.getID());
    }

    @Test
    public void testSetGender() {
        characterSheet.setGender("Male");
        Assertions.assertEquals("Male", characterSheet.getGender());
    }

    @Test
    public void testSetDescription() {
        characterSheet.setDescription("Test Description");
        Assertions.assertEquals("Test Description", characterSheet.getDescription());
    }

    @Test
    public void testSetRace() {
        characterSheet.setRace("Human");
        Assertions.assertEquals("Human", characterSheet.getRace());
    }

    @Test
    public void testSetDndClass() {
        characterSheet.setdndClass("Warrior");
        Assertions.assertEquals("Warrior", characterSheet.getdndClass());
    }

    @Test
    public void testSetStrength() {
        characterSheet.setStrength(18);
        Assertions.assertEquals(18, characterSheet.getStrength());
    }

    @Test
    public void testSetDexterity() {
        characterSheet.setDexterity(16);
        Assertions.assertEquals(16, characterSheet.getDexterity());
    }

    @Test
    public void testSetConstitution() {
        characterSheet.setConstitution(14);
        Assertions.assertEquals(14, characterSheet.getConsitution());
    }

    @Test
    public void testSetIntelligence() {
        characterSheet.setIntelligence(12);
        Assertions.assertEquals(12, characterSheet.getIntelligence());
    }

    @Test
    public void testSetWisdom() {
        characterSheet.setWisdom(10);
        Assertions.assertEquals(10, characterSheet.getWisdom());
    }

    @Test
    public void testSetCharisma() {
        characterSheet.setCharisma(8);
        Assertions.assertEquals(8, characterSheet.getCharisma());
    }

    @Test
    public void testPrintSheet() {
        characterSheet.setName("Alice");
        characterSheet.setID(456);
        characterSheet.setGender("Female");
        characterSheet.setDescription("A wise mage");
        characterSheet.setRace("Elf");
        characterSheet.setdndClass("Wizard");
        characterSheet.setStrength(10);
        characterSheet.setDexterity(12);
        characterSheet.setConstitution(14);
        characterSheet.setIntelligence(18);
        characterSheet.setWisdom(16);
        characterSheet.setCharisma(8);

        String expectedOutput = "Name: Alice\nID: 456\nGender: Female\nDescription: A wise mage\nRace: Elf\nClass: Wizard\nStrength: 10\nDexterity: 12\nConstitution: 14\nIntelligence: 18\nWisdom: 16\nCharisma: 8";

        Assertions.assertEquals(expectedOutput, characterSheet.printSheet());
    }
    @Test
    public void testaddExp(){
        characterSheet.addExp(2000);
        Assertions.assertEquals(2, characterSheet.getlevel());
    }
}
