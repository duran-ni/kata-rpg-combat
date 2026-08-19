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
}
