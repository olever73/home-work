package de.teleran;

import java.util.*;
//*3.	Написать метод, принимающий лист слов, а возвращающий TreeMap, ключами которого являются буквы,
  //      в значениями - листы слов, начинающихся с данной буквы и расположенных в лексикографическом порядке
//                 ({hello, world, hell} -> {h: [hell, hello], w: [world]})

public class Split {

    public List<List<String>> splitWords(List<String> words) {
        List<String> temp = new ArrayList<>(words);

        Collections.sort(temp);

        Map<String, List<String>> wordsByFirstLetter = new TreeMap<>();

        for (String word : temp) {
            String firstLetter = word.substring(0, 1);

            List<String> wordsOfLetter = wordsByFirstLetter.get(firstLetter);

            if (wordsOfLetter == null) {
                wordsOfLetter = new ArrayList<>();
                wordsByFirstLetter.put(firstLetter, wordsOfLetter);
            }
            wordsOfLetter.add(word);
        }
        return new ArrayList<>(wordsByFirstLetter.values());
    }
}



