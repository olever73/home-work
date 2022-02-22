package de.teleran;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Main m;

    @BeforeEach
    public void init() {
        m = new Main();
    }


    @Test
    public void balancedBrackets_test_two_round_two_square_two_more() {
        char[] ch = {'(', '[', '{', '}', ']', ')', ')'};

        assertTrue(m.areBracketsCorrect(ch));
    }

    @Test
    public void balancedBrackets_test_two_wrong() {
        char[] ch = {'(', '[', '{', '}', ']', ')'};

        assertFalse(m.areBracketsCorrect(ch));
    }
}
