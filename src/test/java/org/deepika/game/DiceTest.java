package org.deepika.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    /**
     * Test rolling the dice to ensure the result is within valid bounds.
     */
    @Test
    void testRollValidRange() {
        int sides = 6;
        Dice dice = new Dice(sides);

        for (int i = 0; i < 100; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= sides, "Dice roll result should be between 1 and " + sides);
        }
    }

    /**
     * Test that constructing a die with invalid sides throws an exception.
     */
    @Test
    void testInvalidDiceSides() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Dice(0));
        assertEquals("Number of sides must be greater than 0", exception.getMessage());
    }

    /**
     * Test rolling a die with a large number of sides to ensure no exceptions occur.
     */
    @Test
    void testRollWithLargeNumberOfSides() {
        int sides = 100;
        Dice dice = new Dice(sides);

        int result = dice.roll();
        assertTrue(result >= 1 && result <= sides, "Dice roll result should be between 1 and " + sides);
    }
}
