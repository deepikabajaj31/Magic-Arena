package org.deepika.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.deepika.players.Player;

import static org.junit.jupiter.api.Assertions.*;


class BattleTest {
    private Player defender;
    private Battle battle;

    @BeforeEach
    void setUp() {
        Player attacker = new Player("Attacker", 100, 5, 10);
        defender = new Player("Defender", 100, 3, 8);

        DiceRoller diceRoller = new Dice(6);

        battle = new Battle(attacker, defender, diceRoller);
    }

    /**
     * Test the playTurn method to ensure that it calculates and updates health correctly.
     */
    @Test
    void testPlayTurn() {
        int initialHealth = defender.getHealth();

        battle.playTurn();

        assertTrue(defender.getHealth() <= initialHealth, "Defender's health should decrease or stay the same.");
    }

    /**
     * Test the playTurn method to ensure that it doesn't reduce the defender's health below zero.
     */
    @Test
    void testHealthNotNegative() {
        while (defender.getHealth() > 0) {
            battle.playTurn();
        }

        assertEquals(0, defender.getHealth(), "Defender's health should not be negative.");
    }
}
