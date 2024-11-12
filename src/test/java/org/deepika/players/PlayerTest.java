package org.deepika.players;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**
     * Test the creation of a player and the getters.
     */
    @Test
    void testPlayerCreation() {
        Player player = new Player("John", 100, 15, 10);

        assertEquals("John", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(15, player.getStrength());
        assertEquals(10, player.getAttack());
    }

    /**
     * Test reducing the player's health.
     */
    @Test
    void testReduceHealth() {
        Player player = new Player("John", 100, 15, 10);

        player.reduceHealth(30);
        assertEquals(70, player.getHealth());

        player.reduceHealth(80); // Health should not go below zero
        assertEquals(0, player.getHealth());
    }

    /**
     * Test the isAlive method.
     */
    @Test
    void testIsAlive() {
        Player player = new Player("John", 100, 15, 10);

        assertTrue(player.isAlive());

        player.reduceHealth(100);
        assertFalse(player.isAlive());
    }

    /**
     * Test setting new values for attributes.
     */
    @Test
    void testGetterAndSetters() {
        Player player = new Player("John", 100, 15, 10);

        player.setName("Doe");
        player.setHealth(120);
        player.setStrength(20);
        player.setAttack(12);

        assertEquals("Doe", player.getName());
        assertEquals(120, player.getHealth());
        assertEquals(20, player.getStrength());
        assertEquals(12, player.getAttack());
    }
}
