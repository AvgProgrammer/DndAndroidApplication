package Player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import Session.Session;
import CharacterSheet.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("John Doe", "john@example.com", "password123");
    }

    @AfterEach
    public void tearDown() {
        player = null;
    }

    @Test
    public void testSetName() {
        player.setName("Alice");
        Assertions.assertEquals("Alice", player.GetName());
    }

    @Test
    public void testSetPassword() {
        player.setPassword("newpassword");
        Assertions.assertEquals("newpassword", player.GetPassword());
    }

    @Test
    public void testSetEmail() {
        player.setEmail("alice@example.com");
        Assertions.assertEquals("alice@example.com", player.GetEmail());
    }

    @Test
    public void testAddCharacter() {
        Player player = new Player("John Doe", "john@example.com", "password123");
        CharacterSheet character = new CharacterSheet("Character1", 1, "Male", "Description", DnDClass.Wizard, Race.Human, 10, 10, 10, 10, 10, 10,0);

        player.AddCharacter(character);

        assertFalse(player.getCharacters().isEmpty());
        assertTrue(player.getCharacters().contains(character));
    }

    @Test
    public void testAddSession() {
        Session session = new Session();
        player.AddSession(session);
        Assertions.assertTrue(player.getSessions().contains(session));
    }
}
