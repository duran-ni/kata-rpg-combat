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
}
