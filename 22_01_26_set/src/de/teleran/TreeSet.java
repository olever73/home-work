package de.teleran;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeSet<T> implements Set{

    TreeMap<T,Object> source = new TreeMap<>();
   Comparator<T>comparator;
   private final Object o = new Object();

    public TreeSet(Comparator<T>comparator){
        this.comparator=comparator;
        TreeMap<T,Object> source = new TreeMap<>(comparator);
    }


    @Override
    public boolean add(Object elt) {
        return source.put((T) elt, o) == null;
    }

    @Override
    public boolean remove(Object elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(Object elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public void addAll(Set another) {
        for (Object newElt:another){
            this.add(newElt);
        }
    }

    @Override
    public void removeAll(Set another) {
        for (Object newElt:another){
            this.remove(newElt);
        }
    }

    @Override
    public void retainAll(Set another) {
        Set<T> temp = new TreeSet<>();

        for (T elt : this) {
            if (!another.contains(elt))
                temp.add(elt);
        }

        this.removeAll(temp);
    }

    @Override
    public Iterator iterator() {
        return source.keySet().iterator();
    }
}
