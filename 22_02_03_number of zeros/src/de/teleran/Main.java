package de.teleran;

import java.nio.CharBuffer;
import java.util.Scanner;
//*Задача №115. Количество нулей
//Дано натуральное число N. Напишите функцию int NumberOfZeroes(int n) (C/C++/Java), function NumberOfZeroes(n: longint): integer (Pascal), определяющую количество нулей среди всех цифр числа N.
//
//Входные данные
//Задано единственное число N
//
//Выходные данные
//Необходимо вывести количество нулей среди всех цифр числа N.
//*
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите данные: ");
        int k = input.nextInt();

        long count = CharBuffer.wrap(String.valueOf(k).toCharArray())
                .chars()
                .filter(value -> (char) value == '0')
                .count();
        System.out.println(count);
    }
}
