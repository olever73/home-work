package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO complete tests
class NewsTest {
    @Test
    public void testCompareTo_1() {
        News news1 = new News("Hello world", 7);
        News news2 = new News("Hello", 7);

        assertTrue(news1.compareTo(news2) < 0);
    }
    @Test
    public void testCompareToEquality_() {
        News news1 = new News("Hello world", 7);
        News news2 = new News("Hello world", 7);

        assertTrue(news1.compareTo(news2) == 0);
    }
    @Test
    public void testCompare_2() {
        News news1 = new News("Hello", 7);
        News news2 = new News("Hello", 8);

        assertTrue(news1.compareTo(news2) > 0);
    }
    @Test
    public void testCompareTo3_() {
        News news1 = new News("Hello world", 10);
        News news2 = new News("Hello ", 7);

        assertTrue(news1.compareTo(news2) < 0);
    }
}