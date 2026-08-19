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
}
