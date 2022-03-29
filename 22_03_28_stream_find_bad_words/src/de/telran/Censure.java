package de.telran;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Censure {
    //2.	Есть словарь плохих слов (Set<String>) и текст. Написать метод, который принимает словарь плохих слов и           текст, а возвращает список (лист) плохих слов, найденных в тексте в алфавитном порядке (не повторяясь).            List<String> function(Set<String> badWords, String text);
    //

        private Set<String> badWords;

    public Censure(Collection<String> badWords) {
        this.badWords = badWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<String> findBadWords(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}