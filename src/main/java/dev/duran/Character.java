package dev.duran;

public class Character {

    private int health = 1000;
    private int level = 1;
    private boolean alive = true;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void dealDamage(Character target, int damage) {
        if (this == target) {
            return;
        }

        int newHealth = target.health - damage;

        if (newHealth <= 0) {
            target.health = 0;
            target.alive = false;
        } else {
            target.health = newHealth;

        }
    }

    public void heal(Character target, int amount) {
        if (this != target) {
            return;
        }

        if (!target.alive) {
            return;
        }

        int newHealth = target.health + amount;
        target.health = Math.min(newHealth, 1000);

    }

    public void levelUp() {
        level++;
    }

}
