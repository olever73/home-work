package de.teleran;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NaiveMaxStack implements MaxStack {

    private final Deque<Integer> source = new ArrayDeque<>();

    // O(1)
    @Override
    public void add(int elt) {
        source.addLast(elt);
    }

    // O(1)
    @Override
    public int get() {
        return source.getLast();
    }

    // O(1)
    @Override
    public int remove() {
        return source.removeLast();
    }

    // O(1)
    @Override
    public int size() {
        return source.size();
    }


    @Override
    public int getMax() {
        int currentMax = source.getFirst();

        for (int elt : source) {
            if (elt > currentMax)
                currentMax = elt;
        }
        return currentMax;
    }
}