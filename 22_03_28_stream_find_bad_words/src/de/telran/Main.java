package de.telran;


import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    //1.	Задачи на пересечение/объединение предикатов решить с помощью стримов (reduce())
    public static void main(String[] args) {




        List<Integer> nums = List.of(1,2,3);

        IntStream.rangeClosed(5, 7).reduce((x, y) -> x + y)
                .ifPresent(s -> System.out.println(s));
        IntStream.range(1, 6).reduce(Integer::sum)
                .ifPresent(s -> System.out.println(s));
        IntStream.range(1, 10).reduce(MyUtil::add2Ints)
                .ifPresent(s -> System.out.println(s));

    }

    public class MyUtil {

        public static int add2Ints(int num1, int num2) {
            return num1 + num2;
        }
    }


}
