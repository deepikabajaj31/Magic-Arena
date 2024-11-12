package org.deepika;

import org.junit.jupiter.api.Test;
import org.deepika.exceptions.InvalidGameInputException;
import org.deepika.players.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * Test valid player creation with correct input.
     */
    @Test
    void testCreatePlayerValid() {
        String input = "Deepika\n50\n5\n10\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("createPlayer", Scanner.class, String.class);
            method.setAccessible(true);

            Player player = (Player) method.invoke(null, scanner, "Player A");
            assertNotNull(player);
            assertEquals("Deepika", player.getName());
            assertEquals(50, player.getHealth());
            assertEquals(5, player.getStrength());
            assertEquals(10, player.getAttack());
        } catch (Exception e) {
            fail("Exception should not be thrown for valid input");
        }
    }

    /**
     * Test invalid player creation when health is zero.
     */
    @Test
    void testCreatePlayerInvalidHealth() {
        String input = "Deepika\n0\n5\n10\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("createPlayer", Scanner.class, String.class);
            method.setAccessible(true);

            InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
                method.invoke(null, scanner, "Player A");
            });

            assertTrue(exception.getCause() instanceof InvalidGameInputException);
            assertEquals("Value must be positive.", exception.getCause().getMessage());

        } catch (Exception e) {
            fail("Exception should not be thrown for valid input");
        }
    }


    /**
     * Test valid integer input.
     */
    @Test
    void testGetValidIntInputValid() {
        String input = "50\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("getValidIntInput", Scanner.class, String.class);
            method.setAccessible(true);

            int result = (int) method.invoke(null, scanner, "Health: ");
            assertEquals(50, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid input");
        }
    }

    /**
     * Test invalid integer input (non-numeric).
     */
    @Test
    void testGetValidIntInputInvalid() {
        String input = "abc\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("getValidIntInput", Scanner.class, String.class);
            method.setAccessible(true);

            InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
                method.invoke(null, scanner, "Health: ");
            });

            assertTrue(exception.getCause() instanceof InvalidGameInputException);
            assertEquals("Invalid number entered.", exception.getCause().getMessage());

        } catch (Exception e) {
            fail("Exception should not be thrown for invalid input");
        }
    }


    /**
     * Test valid string input.
     */
    @Test
    void testGetValidInputValid() {
        String input = "Deepika\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("getValidInput", Scanner.class, String.class);
            method.setAccessible(true);

            String result = (String) method.invoke(null, scanner, "Name: ");
            assertEquals("Deepika", result);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid input");
        }
    }

    /**
     * Test invalid string input (empty input).
     */
    @Test
    void testGetValidInputInvalid() {
        String input = "\n";
        Scanner scanner = new Scanner(input);

        try {
            Method method = Main.class.getDeclaredMethod("getValidInput", Scanner.class, String.class);
            method.setAccessible(true);

            InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
                method.invoke(null, scanner, "Name: ");
            });

            assertTrue(exception.getCause() instanceof InvalidGameInputException);
            assertEquals("Input cannot be empty.", exception.getCause().getMessage());

        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
