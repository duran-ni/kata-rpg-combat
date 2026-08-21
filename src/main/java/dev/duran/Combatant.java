package dev.duran;

public abstract class Combatant {

    private int health;
    private boolean alive = true;

    protected Combatant(int startingHealth) {
        this.health = startingHealth;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    protected void reduceHealth(int amount) {
        int newHealth = health - amount;

        if (newHealth <= 0) {
            health = 0;
            alive = false;
        } else {
            health = newHealth;
        }
    }

    protected void increaseHealth(int amount, int maxHealth) {
        health = Math.min(health + amount, maxHealth);
    }
}
