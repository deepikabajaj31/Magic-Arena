package org.deepika;

import org.deepika.exceptions.InvalidGameInputException;
import org.deepika.game.Dice;
import org.deepika.game.GameEngine;
import org.deepika.players.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("                ███╗   ███╗ █████╗  ██████╗ ██╗ ██████╗     █████╗ ██████╗ ███████╗███╗   ██╗ █████╗");
        System.out.println("                ████╗ ████║██╔══██╗██╔════╝ ██║██╔════╝    ██╔══██╗██╔══██╗██╔════╝████╗  ██║██╔══██╗");
        System.out.println("                ██╔████╔██║███████║██║  ███╗██║██║         ███████║██████╔╝█████╗  ██╔██╗ ██║███████║");
        System.out.println("                ██║╚██╔╝██║██╔══██║██║   ██║██║██║         ██╔══██║██╔══██╗██╔══╝  ██║╚██╗██║██╔══██║");
        System.out.println("                ██║ ╚═╝ ██║██║  ██║╚██████╔╝██║╚██████╗    ██║  ██║██║  ██║███████╗██║ ╚████║██║  ██║");
        System.out.println("                ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝ ╚═════╝    ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝");
        try (Scanner scanner = new Scanner(System.in)) {
            // Create two players based on user input
            Player playerA = createPlayer(scanner, "Player A");
            Player playerB = createPlayer(scanner, "Player B");

            // Create a GameEngine with a 6-sided dice
            GameEngine gameEngine = new GameEngine(playerA, playerB, new Dice(6));
            gameEngine.startGame();

        } catch (InvalidGameInputException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Game error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user for details to create a player.
     *
     * @param scanner The scanner object to read user input.
     * @param playerLabel The label for the player (e.g., "Player A").
     * @return The created Player object.
     * @throws InvalidGameInputException If invalid input is provided.
     */
    private static Player createPlayer(Scanner scanner, String playerLabel) throws InvalidGameInputException {
        System.out.println("\nEnter details for " + playerLabel + ":");

        // Get player details from input
        String name = getValidInput(scanner, "Name: ");
        int health = getValidIntInput(scanner, "Health: ");
        int strength = getValidIntInput(scanner, "Strength: ");
        int attack = getValidIntInput(scanner, "Attack: ");

        return new Player(name, health, strength, attack);
    }

    // Helper method to get a valid non-empty string input from the user.
    private static String getValidInput(Scanner scanner, String prompt) throws InvalidGameInputException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new InvalidGameInputException("Input cannot be empty.");
        }
        return input;
    }

    // Helper method to get a valid positive integer input from the user.
    private static int getValidIntInput(Scanner scanner, String prompt) throws InvalidGameInputException {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value <= 0) {
                throw new InvalidGameInputException("Value must be positive.");
            }
            return value;
        } else {
            scanner.nextLine();
            throw new InvalidGameInputException("Invalid number entered.");
        }
    }
}
