package de.telran.stream;

import java.util.List;
import java.util.function.Predicate;

public class PredicateMethodReference {

    public static void main(String[] args) {

        var words = List.of("sky", "", "club", "spy", "silk", "summer",
                "war", "cup", "cloud", "coin", "small", "terse", "",
                "snow", "snail", "see");

        Predicate<String> pred = String::isEmpty;

        var res = words.stream().anyMatch(pred);

        if (res) {
            System.out.println("There is an empty string");
        } else {
            System.out.println("There is no empty string");
        }
    }
}