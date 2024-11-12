package org.deepika.game;

import org.deepika.players.Player;

public class Battle {
    private final Player attacker;
    private final Player defender;
    private final DiceRoller diceRoller;

    public Battle(Player attacker, Player defender, DiceRoller diceRoller) {
        this.attacker = attacker;
        this.defender = defender;
        this.diceRoller = diceRoller;
    }

    /**
     * Simulates a turn in the battle. Rolls the dice for both the attacker and defender,
     * calculates the net damage dealt to the defender, and updates the defender's health.
     */
    public void playTurn() {
        // Roll the dice for attacker and defender
        int attackRoll = diceRoller.roll();
        int defenseRoll = diceRoller.roll();

        // Calculate attack and defense damage
        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseDamage = defender.getStrength() * defenseRoll;

        // Calculate the net damage to the defender
        int damageToDefender = Math.max(attackDamage - defenseDamage, 0);

        // Reduce the health of the defender
        defender.reduceHealth(damageToDefender);

        // Print the details of the attack
        System.out.println(attacker.getName() + " attacks " + defender.getName() +
                " with total attack damage " + attackDamage + " (Attack roll: " + attackRoll + ")");
        System.out.println(defender.getName() + " defends with total defense damage " + defenseDamage +
                " (Defense roll: " + defenseRoll + ")");
        System.out.println(defender.getName() + "'s remaining health: " + defender.getHealth());
    }
}
