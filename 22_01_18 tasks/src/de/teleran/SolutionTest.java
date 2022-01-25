package de.teleran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void testSolutionOne() {
        List<Integer> list = Arrays.asList(5, 1);

        assertTrue(solution.solve(list, 5));

    }
    @Test
    public void testSolutionTwo() {
        List<Integer> list = Arrays.asList(1, 5);

        assertFalse(solution.solve(list, 55));
    }


    @Test
    public void testSolutionThree() {
        List<Integer> list = Arrays.asList(74, 19);

        assertFalse(solution.solve(list, 10));
    }

    @Test
    public void testSolutionFour() {
        List<Integer> list = Arrays.asList(58, 7);

        assertFalse(solution.solve(list, 7));
        assertFalse(solution.solve(list, 58));
    }

    @Test
    public void testSolutionFive() {
        List<Integer> list = Arrays.asList(2,8,12,14,25,45,50);

        assertTrue(solution.solve(list, 100));
        assertTrue(solution.solve(list, 200));
        assertTrue(solution.solve(list, 90));
        assertTrue(solution.solve(list, 168));

        assertTrue(solution.solve(list, 600));
        assertTrue(solution.solve(list, 1125));
        assertTrue(solution.solve(list, 16));

        assertFalse(solution.solve(list, 420));
        assertFalse(solution.solve(list, 80));
    }

    Solution solution1 = new Solution();
    @Test
    public void testSolutionEncode() {
        String str = "aaaabbccccd";
        assertEquals("4a2b4c1d",solution1.encode("aaaabbccccd"));
    }


}

