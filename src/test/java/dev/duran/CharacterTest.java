package dev.duran;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CharacterTest {
    @Test
    void newCharacterStartsWithFullHealth() {
        Character hero = Character.createMeleeFighter();

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void newCharacterStartsAtLevelOne() {
        Character hero = Character.createMeleeFighter();

        assertThat(hero.getLevel(), is(1));
    }

    @Test
    void newCharacterStartsAlive() {
        Character hero = Character.createMeleeFighter();

        assertThat(hero.isAlive(), is(true));
    }

    @Test
    void dealingDamageReducesTargetHealth() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();

        attacker.dealDamage(target, 100);

        assertThat(target.getHealth(), is(900));

    }

    @Test
    void damageExceedingHealthKillsTarget() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();

        attacker.dealDamage(target, 1500);

        assertThat(target.getHealth(), is(0));
        assertThat(target.isAlive(), is(false));
    }

    @Test
    void healingIncreasesTargetHealth() {
        Character attacker = Character.createMeleeFighter();
        Character hero = Character.createMeleeFighter();
        attacker.dealDamage(hero, 300);

        hero.heal(hero, 100);

        assertThat(hero.getHealth(), is(800));
    }

    @Test
    void healingCannotExceedMaxHealth() {
        Character attacker = Character.createMeleeFighter();
        Character hero = Character.createMeleeFighter();
        attacker.dealDamage(hero, 50);

        hero.heal(hero, 200);

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void deadCharacterCannotBeHealed() {
        Character attacker = Character.createMeleeFighter();
        Character hero = Character.createMeleeFighter();
        attacker.dealDamage(hero, 1500);

        hero.heal(hero, 100);

        assertThat(hero.getHealth(), is(0));
        assertThat(hero.isAlive(), is(false));
    }

    @Test
    void characterCannotDealDamageToItself() {
        Character hero = Character.createMeleeFighter();

        hero.dealDamage(hero, 100);

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void characterCanOnlyHealItself() {
        Character healer = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();
        healer.dealDamage(target, 300);

        healer.heal(target, 100);

        assertThat(target.getHealth(), is(700));

    }

    @Test
    void levelUpIncreasesCharacterLevel() {
        Character hero = Character.createMeleeFighter();

        hero.levelUp();

        assertThat(hero.getLevel(), is(2));
    }

    @Test
    void damageIsReducedWhenTargetIsFiveOrMoreLevelsAbove() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();
        for (int i = 0; i < 5; i++) {
            target.levelUp();
        }

        attacker.dealDamage(target, 100);

        assertThat(target.getHealth(), is(950));
    }

    @Test
    void damageIsIncreasedWhenTargetIsFiveOrMoreLevelsBelow() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();
        for (int i = 0; i < 5; i++) {
            attacker.levelUp();
        }

        attacker.dealDamage(target, 100);

        assertThat(target.getHealth(), is(850));
    }

    @Test
    void meleeFighterHasARangeOfTwoMeters() {
        Character hero = Character.createMeleeFighter();

        assertThat(hero.getRange(), is(2));

    }

    @Test
    void rangedFighterHasARangeOfTwentyMeters() {
        Character archer = Character.createRangedFighter();

        assertThat(archer.getRange(), is(20));
    }

    @Test
    void dealingDamageWithinRangeAppliesDamage() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();

        attacker.dealDamage(target, 100, 2);

        assertThat(target.getHealth(), is(900));
    }

    @Test
    void dealingDamageOutOfRangeHasNoEffect() {
        Character attacker = Character.createMeleeFighter();
        Character target = Character.createMeleeFighter();

        attacker.dealDamage(target, 100, 5);

        assertThat(target.getHealth(), is(1000));
    }

    @Test
    void dealingDamageAtExactMaxRangeAppliesDamage() {
        Character attacker = Character.createRangedFighter();
        Character target = Character.createRangedFighter();

        attacker.dealDamage(target, 100, 20);

        assertThat(target.getHealth(), is(900));
    }

    @Test
    void newCharacterBelongsToNoFaction() {
        Character hero = Character.createMeleeFighter();

        assertThat(hero.isInFaction("Vikings"), is(false));
    }

    @Test
    void characterCanJoinAFaction() {
        Character hero = Character.createMeleeFighter();

        hero.joinFaction("Vikings");

        assertThat(hero.isInFaction("Vikings"), is(true));
    }

}
