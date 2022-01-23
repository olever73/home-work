package de.teleran;

import static java.util.Objects.hash;

/// TODO investigate and complete and test
public class HashMap<K, V> implements Map<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private Pair<K, V>[] source = new Pair[INITIAL_CAPACITY];


    private static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(K key, V value) {
        if (size > LOAD_FACTOR * source.length)
            resize();

        Pair<K, V> pair = findPair(key);

        if (pair == null) {
            int index = findIndex(key);
            pair = new Pair<>(key, value, source[index]);
            source[index] = pair;
            size++;
        } else {
            pair.value = value;
        }
    }

    private void resize() {

        Pair<K, V>[] newSource = new Pair[source.length*2];

        for (Pair<K, V> cell : source) {

            Pair<K, V> currentPair = cell;
            while (currentPair != null) {
                int newIndex = hash(currentPair.key) % source.length;
                Pair<K, V> next = currentPair.next;

                currentPair.next = newSource[newIndex];
                newSource[newIndex] = currentPair;

                currentPair = next;
            }
        }

        source = newSource;
    }




    private int findIndex(K key) {
        return Math.abs(key.hashCode()) % source.length;
    }

    /**
     * retuns the pair with the key or null if there is no pair with such a key
     *
     * @param key
     * @return
     */
    private Pair<K, V> findPair(K key) {
        int index = findIndex(key);

        Pair<K, V> currentPair = source[index];

        while (currentPair != null) {
            if (currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next;
        }

        return null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = findPair(key);
        return pair == null ? null : pair.value;
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        Pair<K, V> current = source[index];

        if (current == null)
            return null;

        if (current.key.equals(key)) {
            source[index] = current.next;
            V res = current.value;

            clearPair(current);

            size--;
            return res;
        }

        while (current.next != null) {
            if (current.next.key.equals(key)) {
                Pair<K, V> pairToRemove = current.next;
                V res = pairToRemove.value;
                current.next = pairToRemove.next;

                clearPair(pairToRemove);

                size--;
                return res;
            }
            current = current.next;
        }

        return null;
    }

    private void clearPair(Pair<K,V> current) {
       
    }

    @Override
    public boolean contains(K key) {
        return findPair(key) != null;
    }

    @Override
    public int size() {
        return size;
    }
}