package dev.duran;

public class Character {

    private int health = 1000;
    private int level = 1;
    private boolean alive = true;
    private final int range;

    private Character(FighterType fighterType) {
        this.range = fighterType == FighterType.MELEE ? 2 : 20;
    }

    public static Character createMeleeFighter() {
        return new Character(FighterType.MELEE);
    }

    public static Character createRangedFighter() {
        return new Character(FighterType.RANGED);
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getRange() {
        return range;
    }

    public void levelUp() {
        level++;
    }

    public void dealDamage(Character target, int damage) {
        dealDamage(target, damage, 0);
    }

    public void dealDamage(Character target, int damage, int distance) {
        if (this == target) {
            return;
        }

        if (distance > this.range) {
            return;
        }

        int actualDamage = damage;
        if (target.level - this.level >=5) {
            actualDamage = damage / 2;
        } else if (this.level - target.level >=5) {
            actualDamage = damage + (damage / 2);
        }

        int newHealth = target.health - actualDamage;

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


}
