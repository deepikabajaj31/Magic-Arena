package org.deepika.game;

import java.util.Random;

public class Dice implements DiceRoller {
    private final Random random; // Random number generator for rolling the dice
    private final int sides;  // Number of sides on the dice

    public Dice(int sides) {
        if (sides <= 0) {
            throw new IllegalArgumentException("Number of sides must be greater than 0");
        }
        this.random = new Random();
        this.sides = sides;
    }

    @Override
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
