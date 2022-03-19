package de.teleran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

//Написать лямбду, которая принимает лист строк,
// а возвращает лист неповторяющихся строк (Использовать интерфейс Function<List<String>, List<String>> )

public class Solution {

        public static void main(String[] args) {
            Function<List<String>, List<String>> unique = (list)
                    -> new ArrayList<>(new HashSet<>(list));
            List<String> list = Arrays.asList("Vasya", "Petya", "Masha", "Petya", "Violeta", "Masha");
            System.out.println(unique.apply(list));
        }
}




