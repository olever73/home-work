package de.teleran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    /**
     * The method must return true if there are 2 numbers from the numbers array, whose multiplication is the product
     * {2, 5, 18, 50}, 36 -> true
     * {2, 5, 18, 50}, 40 -> false
     * @param numbers array of sorted numbers
     * @param product some number
     * @return
     */
    // Эффективо (O(n)) задача может быть решена с помощью ArrayDeque
    public boolean solve(List<Integer> numbers, int product ) {
        Deque<Integer> deque = new ArrayDeque<>(numbers);

     while (deque.size() >= 2) {
           int multiplication = deque.getFirst() * deque.getLast();
           if (multiplication > product) {
                deque.removeLast();
         } else if (multiplication < product) {
                deque.removeFirst();
           } else {
                return true;
            }
        }
        return false;
    }


        // str - состоит только из маленьких букв.
    // "aaaabbccccd"->"4a2b4cd"

    public static String encode(String str) {
        // stores output string
        String encoding = "";

        // base case
        if (str == null) {
            return encoding;
        }

        int count;

        for (int i = 0; i < str.length(); i++) {
            // count occurrences of character at index `i`
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // append current character and its count to the result
            encoding += String.valueOf(count) + str.charAt(i);
        }

        return encoding;
    }
    // str - состоит только из маленьких букв.
    // "4a2b4cd" -> "aaaabbccccd"
    
    }


