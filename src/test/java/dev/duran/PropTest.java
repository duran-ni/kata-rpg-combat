package dev.duran;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PropTest {

    @Test
    void propStartsWithGivenHealth() {
        Prop tree = new Prop(2000);

        assertThat(tree.getHealth(), is(2000));
        assertThat(tree.isAlive(), is(true));
    }

    @Test
    void propCanBeDamagedByCharacter() {
        Character attacker = Character.createMeleeFighter();
        Prop tree = new Prop(2000);

        attacker.dealDamage(tree, 500, 2);

        assertThat(tree.getHealth(), is(1500));
    }

    @Test
    void propIsDestroyedWhenHealthReachesZero() {
        Character attacker = Character.createMeleeFighter();
        Prop tree = new Prop(2000);

        attacker.dealDamage(tree, 2500, 2);

        assertThat(tree.getHealth(), is(0));
        assertThat(tree.isAlive(), is(false));
    }

}
