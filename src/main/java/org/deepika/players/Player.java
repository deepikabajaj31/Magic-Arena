package org.deepika.players;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Getters and setters for name, health, strength, and attack

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void reduceHealth(int damage) {
        // Ensure health does not drop below 0
        if (damage > 0) {
            health = Math.max(health - damage, 0);  // Reduce health and ensure it doesn't go below 0
        }
    }

    // Method to check if the player is alive (health greater than zero).
    public boolean isAlive() {
        return health > 0;
    }
}
