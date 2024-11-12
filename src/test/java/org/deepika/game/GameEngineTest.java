package org.deepika.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.deepika.players.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameEngineTest {
    private Player player1;
    private Player player2;
    private GameEngine gameEngine;

    @BeforeEach
    void setUp() {
        player1 = new Player("Player1", 30, 10, 15);
        player2 = new Player("Player2", 50, 12, 16);

        Dice dice = new Dice(6);

        gameEngine = new GameEngine(player1, player2, dice);
    }

    /**
     * Test the startGame method to ensure it runs the game loop correctly and announces a winner.
     */
    @Test
    void testStartGame() {
        gameEngine.startGame();

        assertTrue(!player1.isAlive() || !player2.isAlive());
    }

    /**
     * Test the handleTurn method to ensure it processes turns correctly.
     * This test indirectly checks handleTurn by running a full game.
     */
    @Test
    void testGameProgress() {
        int initialHealth1 = player1.getHealth();
        int initialHealth2 = player2.getHealth();

        gameEngine.startGame();

        assertTrue(player1.getHealth() < initialHealth1 || player2.getHealth() < initialHealth2);
    }
}
