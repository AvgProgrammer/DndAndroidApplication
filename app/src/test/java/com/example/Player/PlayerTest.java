package com.example.Player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import com.example.Session.Session;
import com.example.CharacterSheet.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("John Doe", "john@example.com", "password123");
    }

    @After
    public void tearDown() {
        player = null;
    }

    @Test
    public void testSetName() {
        player.setName("Alice");
        Assert.assertEquals("Alice", player.GetName());
    }

    @Test
    public void testSetPassword() {
        player.setPassword("newpassword");
        Assert.assertEquals("newpassword", player.GetPassword());
    }

    @Test
    public void testSetEmail() {
        player.setEmail("alice@example.com");
        Assert.assertEquals("alice@example.com", player.GetEmail());
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
        Assert.assertTrue(player.getSessions().contains(session));
    }
}
