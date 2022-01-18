package de.teleran;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNaiveMaxStack {
    final Deque<Integer> source = new ArrayDeque<>();
    @Test
    public void testRemoveLast_empty_Stack_throwsIOOBE() {
        assertThrows(NoSuchElementException.class, () -> source.getLast());
    }

    @Test
    public void testAddLast() {
        source.addLast(0);
        assertEquals(0, source.getLast());

        source.addLast(-1);
        assertEquals(-1, source.getLast());

        source.addLast(10);
        assertEquals(10, source.getLast());
    }

    @Test
    public void testGetLast_not_empty_Stack() {
        source.addLast(0);
        assertEquals(0, source.getLast());

        source.addLast(-1);
        assertEquals(-1, source.getLast());

        source.addLast(1);
        assertEquals(1, source.getLast());
    }

    @Test
    public void testSize_empty_Stack() {
        assertEquals(0, source.size());
    }

    @Test
    public void testSize_not_empty_Stack() {
        source.addLast(1);
        assertEquals(1, source.size());

        source.addLast(1);
        assertEquals(2, source.size());

        source.addLast(1);
        assertEquals(3, source.size());
    }




}


