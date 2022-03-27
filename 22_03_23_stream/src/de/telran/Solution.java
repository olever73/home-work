package de.telran;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

       int[] nums = {1,2,3,4,5};
        Stream.of(nums).forEach(n -> System.out.println(Arrays.toString(n)));
        Arrays.stream(nums).forEach(n -> System.out.println(n));

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(32);
        stack.push(1024);
        stack.push(8);
        stack.push(127);
        stack.stream().sorted().forEach(n -> System.out.print(n + ", "));

        System.out.println();

        for (int i : stack) {
            System.out.println(i + ", ");
        }
        Stream.of("Ene", "mene", "muh", "und", "raus", "bist", "du").limit(3).forEach(System.out::println);

        System.out.println("");

        Integer[] y = new Integer[100];
        for(int num = 0; num < y.length; num++){
         y[num] = new Random().nextInt(100);
        }

        int ergebnis = Stream.of(y).mapToInt(k -> k.intValue()).filter(k -> k%3==0).limit(10).sum();
        System.out.println(ergebnis);

        Stream.of(1, 68, 9, 104, 15).filter(i -> {
            System.out.println("filter 1: " + i);
            return i > 10;
        }).filter(i -> {
            System.out.println("filter 2: " + i);
            return i % 3 == 0;
        }).forEach(i -> System.out.println("forEach: " + i));

        //Stream.of(96, 168, 9, 104, 15).takeWhile(i->i%3==0).forEach(System.out::println);
        Stream.of(96, 168, 9, 104, 15).dropWhile(i->i%3==0).forEach(System.out::println);

       // Stream.iterate(0,i->i+1).forEach(System.out::println);
        Stream.iterate(0,i->i+1).limit(10).forEach(System.out::println);
        Stream.iterate(5, i->i<10, i->i+1).forEach(System.out::println);

    }
}
