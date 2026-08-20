package dev.duran;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CharacterTest {
    @Test
    void newCharacterStartsWithFullHealth() {
        Character hero = new Character();

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void newCharacterStartsAtLevelOne() {
        Character hero = new Character();

        assertThat(hero.getLevel(), is(1));
    }

    @Test
    void newCharacterStartsAlive() {
        Character hero = new Character();

        assertThat(hero.isAlive(), is(true));
    }

    @Test
    void dealingDamageReducesTargetHealth() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 100);

        assertThat(target.getHealth(), is(900));

    }

    @Test
    void damageExceedingHealthKillsTarget() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 1500);

        assertThat(target.getHealth(), is(0));
        assertThat(target.isAlive(), is(false));
    }

    @Test
    void healingIncreasesTargetHealth() {
        Character attacker = new Character();
        Character hero = new Character();
        attacker.dealDamage(hero, 300);

        hero.heal(hero, 100);

        assertThat(hero.getHealth(), is(800));
    }

    @Test
    void healingCannotExceedMaxHealth() {
        Character attacker = new Character();
        Character hero = new Character();
        attacker.dealDamage(hero, 50);

        hero.heal(hero, 200);

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void deadCharacterCannotBeHealed() {
        Character attacker = new Character();
        Character hero = new Character();
        attacker.dealDamage(hero, 1500);

        hero.heal(hero, 100);

        assertThat(hero.getHealth(), is(0));
        assertThat(hero.isAlive(), is(false));
    }

    @Test
    void characterCannotDealDamageToItself() {
        Character hero = new Character();

        hero.dealDamage(hero, 100);

        assertThat(hero.getHealth(), is(1000));
    }

    @Test
    void characterCanOnlyHealItself() {
        Character healer = new Character();
        Character target = new Character();
        healer.dealDamage(target, 300);

        healer.heal(target, 100);

        assertThat(target.getHealth(), is(700));

    }

    @Test
    void levelUpIncreasesCharacterLevel() {
        Character hero = new Character();

        hero.levelUp();

        assertThat(hero.getLevel(), is(2));
    }

}
