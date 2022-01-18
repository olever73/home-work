package de.teleran;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO (*) implement
public class SuperImprovedMaxStack implements MaxStack{

    Deque<Integer> source = new ArrayDeque<>();
    Deque<Integer> currentMaxStack = new ArrayDeque<>();

    @Override
    public void add(int elt) {
        if (source.size() == 0)
            currentMaxStack.add(elt);
        else {
            currentMaxStack.add(Math.max(currentMaxStack.getLast(),elt));
        }
        source.addLast(elt);
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        if (currentMaxStack.removeLast()==source.removeLast())
        return currentMaxStack.removeLast();
        else {  return source.removeLast();
        }
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public int getMax() {
        return currentMaxStack.getLast();
    }
}