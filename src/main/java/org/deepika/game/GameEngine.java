package org.deepika.game;

import org.deepika.players.Player;

/**
 * The GameEngine class is responsible for managing the game between two players.
 * It handles the game loop, player turns, and the announcement of the winner.
 */
public class GameEngine {
    private final Player player1;
    private final Player player2;
    private final DiceRoller diceRoller;
    private int round;

    public GameEngine(Player player1, Player player2, DiceRoller diceRoller) {
        this.player1 = player1;
        this.player2 = player2;
        this.diceRoller = diceRoller;
        this.round = 1;
    }

    /**
     * Starts the game between two players, looping through rounds where players take turns.
     * The game continues until one of the players is defeated.
     */
    public void startGame() {
        System.out.println("Starting the game between " + player1.getName() + " and " + player2.getName() + "!\n");

        // Loop until one of the players is defeated
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n========ROUND-" + round + "============");
            System.out.println("Current Health: ");
            System.out.println(player1.getName() + " Health: " + player1.getHealth());
            System.out.println(player2.getName() + " Health: " + player2.getHealth());

            handleTurn(player1, player2); // Player 1's turn
            if (player2.isAlive()) {
                handleTurn(player2, player1); // Player 2's turn
            }

            round++; // Increment the round number after both players have had a turn
        }

        announceWinner(); // Announce the winner when the game ends
    }

    /**
     * Handles a single turn of combat between the attacker and the defender.
     * This method creates a new Battle object and executes the turn.
     *
     * @param attacker The player who is attacking.
     * @param defender The player who is defending.
     */
    private void handleTurn(Player attacker, Player defender) {
        // Create the battle and execute the turn
        Battle battle = new Battle(attacker, defender, diceRoller);
        battle.playTurn();

        // Add a pause between turns for a better user experience
        try {
            Thread.sleep(1500); // Sleep for 1.5 seconds between turns
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Announces the winner of the game when one player is defeated.
     * This method is called when the game ends.
     */
    private void announceWinner() {
        if (!player1.isAlive()) {
            System.out.println("\n" + player1.getName() + " has been defeated. " + player2.getName() + " wins!");
        } else {
            System.out.println("\n" + player2.getName() + " has been defeated. " + player1.getName() + " wins!");
        }
    }
}
