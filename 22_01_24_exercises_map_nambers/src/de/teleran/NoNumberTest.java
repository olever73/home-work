package de.teleran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoNumberPairTest {

       NoNumberPair single  = new NoNumberPair();


    @Test
    public void testGetSingleNumber_3numbers2different() {
        List<Integer> ints = Arrays.asList(1, 3, 1);
        assertEquals(3, single.singleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_3numbers3different() {
        List<Integer> ints = Arrays.asList(3,3,3);
        assertEquals(3, single.singleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_5numbers() {
        List<Integer> ints = Arrays.asList(-1, -1, 15, -1, -1);
        assertEquals(15, single.singleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_7numbers() {
        List<Integer> ints = Arrays.asList(1, -4, 8,8,-11, -4, 1);
        assertEquals(-11, single.singleNumber(ints));

    }

    @Test
    public void testGetSingleNumber_9numbers() {
        List<Integer> ints = Arrays.asList(1, 8, 8,8,8, 8, 1,2,2);
        assertEquals(8, single.singleNumber(ints));

    }
}