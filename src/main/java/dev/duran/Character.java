package dev.duran;

import java.util.HashSet;
import java.util.Set;

public class Character extends Combatant {

    private int level = 1;
    private final int range;
    private final Set<String> factions = new HashSet<>();

    private Character(FighterType fighterType) {
        super(1000);
        this.range = fighterType == FighterType.MELEE ? 2 : 20;
    }

    public static Character createMeleeFighter() {
        return new Character(FighterType.MELEE);
    }

    public static Character createRangedFighter() {
        return new Character(FighterType.RANGED);
    }

    public int getLevel() {
        return level;
    }

    public int getRange() {
        return range;
    }

    public boolean isInFaction(String factionName) {
        return factions.contains(factionName);
    }

    public void joinFaction(String factionName) {
        factions.add(factionName);
    }

    public void leaveFaction(String factionName) {
        factions.remove(factionName);
    }

    public boolean isAllyOf(Character other) {
        for (String faction : this.factions) {
            if (other.factions.contains(faction)) {
                return true;
            }
        }
        return false;
    }

    public void levelUp() {
        level++;
    }

    public void dealDamage(Combatant target, int damage) {
        dealDamage(target, damage, 0);
    }

    public void dealDamage(Combatant target, int damage, int distance) {
        if (this == target) {
            return;
        }

        if (target instanceof Character && this.isAllyOf((Character) target)) {
            return;
        }

        if (distance > this.range) {
            return;
        }

        int actualDamage = damage;
        if (target instanceof Character) {
            Character characterTarget = (Character) target;
            if (characterTarget.level - this.level >= 5) {
                actualDamage = damage / 2;
            } else if (this.level - characterTarget.level >= 5) {
                actualDamage = damage + (damage / 2);
            }
        }

        target.reduceHealth(actualDamage);
    }

    public void heal(Character target, int amount) {
        if (this != target && !this.isAllyOf(target)) {
            return;
        }

        if (!target.isAlive()) {
            return;
        }

        target.increaseHealth(amount, 1000);

    }

}
