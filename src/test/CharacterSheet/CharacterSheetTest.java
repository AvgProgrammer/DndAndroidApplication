package CharacterSheet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import CharacterSheet.CharacterSheet;

public class CharacterSheetTest {

    private CharacterSheet characterSheet;

    @BeforeEach
    public void setUp() {
        characterSheet = new CharacterSheet("", 0, null, "", null, null, 0, 0, 0, 0, 0, 0,0);
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
        characterSheet.setRace(Race.Human);
        Assertions.assertEquals(Race.Human, characterSheet.getRace());
    }

    @Test
    public void testSetDndClass() {
        characterSheet.setdndClass(DnDClass.Wizard);
        Assertions.assertEquals(DnDClass.Wizard, characterSheet.getdndClass());
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
    public void testGetStrengthModifier() {
        characterSheet.setStrength(12);
        Assertions.assertEquals(1, characterSheet.getStrengthModifier());
    }

    @Test
    public void testGetDexterityModifier() {
        characterSheet.setDexterity(17);
        Assertions.assertEquals(3, characterSheet.getDexterityModifier());
    }

    @Test
    public void testGetConstitutionModifier() {
        characterSheet.setConstitution(9);
        Assertions.assertEquals(-1, characterSheet.getConsitutionModifier());
    }

    @Test
    public void testGetIntelligenceModifier() {
        characterSheet.setIntelligence(15);
        Assertions.assertEquals(2, characterSheet.getIntelligenceModifier());
    }

    @Test
    public void testGetWisdomModifier() {
        characterSheet.setWisdom(5);
        Assertions.assertEquals(-3, characterSheet.getWisdomModifier());
    }

    @Test
    public void testGetCharismaModifier() {
        characterSheet.setCharisma(9);
        Assertions.assertEquals(-1, characterSheet.getCharismaModifier());
    }

    @Test
    public void testaddExp(){
        characterSheet.addExp(2001);
        Assertions.assertEquals(3, characterSheet.getlevel());
    }
}
