package Player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

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
        player.SetName("Alice");
        Assertions.assertEquals("Alice", player.GetName());
    }

    @Test
    public void testSetPassword() {
        player.SetPassword("newpassword");
        Assertions.assertEquals("newpassword", player.GetPassword());
    }

    @Test
    public void testSetEmail() {
        player.SetEmail("alice@example.com");
        Assertions.assertEquals("alice@example.com", player.GetEmail());
    }

    @Test
    public void testAddCharacter() {
        Player player = new Player("John Doe", "john@example.com", "password123");
        CharacterSheet character = new CharacterSheet("Character1", 1, "Male", "Description", "Class1", "Race1", 10, 10, 10, 10, 10, 10);

        player.AddCharacter(character);

        assertFalse(player.Characters.isEmpty());
        assertTrue(player.Characters.contains(character));
    }

    @Test
    public void testAddSession() {
        SessionScheduler session = new SessionScheduler();
        player.AddSession(session);
        Assertions.assertTrue(player.Sessions.contains(session));
    }
}