package org.deepika;

import org.deepika.players.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create two players based on user input
            Player playerA = createPlayer(scanner, "Player A");
            Player playerB = createPlayer(scanner, "Player B");

        } catch (Exception e) {
            System.err.println("Game error: " + e.getMessage());
        }
    }

    private static Player createPlayer(Scanner scanner, String playerLabel) throws Exception {
        System.out.println("\nEnter details for " + playerLabel + ":");

        String name = getValidInput(scanner, "Name: ");
        int health = getValidIntInput(scanner, "Health: ");
        int strength = getValidIntInput(scanner, "Strength: ");
        int attack = getValidIntInput(scanner, "Attack: ");

        return new Player(name, health, strength, attack);
    }

    private static String getValidInput(Scanner scanner, String prompt) throws Exception {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new Exception("Input cannot be empty.");
        }
        return input;
    }

    private static int getValidIntInput(Scanner scanner, String prompt) throws Exception {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value <= 0) {
                throw new Exception("Value must be positive.");
            }
            return value;
        } else {
            scanner.nextLine();
            throw new Exception("Invalid number entered.");
        }
    }
}
