package de.telran;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        List<String>words = List.of("sky", "curtain", "sin", "shy", "way", "club",
                "spy", "silk", "summer", "war", "cup", "cloud", "coin", "small",
                "set", "terse", "tree", "sea", "sip", "snow", "snail", "sly",
                "six", "sod", "see", "sit", "sad", "wry", "why");

        Predicate<String> p1 = e -> e.startsWith("s") || e.startsWith("w");
        Predicate<String> p2 = e -> e.endsWith("y");
        Predicate<String> p3 = e -> e.length() == 3;

        List<Predicate<String >>ppp= List.of(p1, p2, p3);

             List<String>result= words.stream()
                .filter(ppp.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        // пересечение and(объединение or)
    }

    public <T> Predicate<T> union(List<Predicate<T>> predicates) {
        Predicate<T> res = (t) -> false;
        return predicates.stream()
                .reduce(res, Predicate :: or);
    }


    public <T> Predicate<T> intersect(List<Predicate<T>> predicates) {
        if (predicates.size() == 0)
            throw new IllegalArgumentException();

        Predicate<T> res = (t) -> true;
        return predicates.stream()
                .reduce(res, Predicate :: and);
    }

}
