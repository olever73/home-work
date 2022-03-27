package de.telran;

import java.util.Arrays;

public class SolutionStream {
    public static void main(String[] args) {
            //2.1 Math operations.
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55

        int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
        int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
        int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);   // 0

          //2.2 Max and Min

        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);  // 10
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10

        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);  // 0
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);            // 0

        //2.3 Join String.

        String[] strings = {"a", "b", "c", "d", "e"};

        // |a|b|c|d|e , the initial | join is not what we want
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);

        // a|b|c|d|e, filter the initial "" empty string
        String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });

        // a|b|c|d|e , better uses the Java 8 String.join :)
        String join = String.join("|", strings);


    }
}
