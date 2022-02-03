package de.teleran;

import java.util.InputMismatchException;
import java.util.Scanner;

//*Задача №116. Минимальная и максимальная цифры
//Дано натуральное число N. Напишите функцию int MinDigit (int n) (C/C++), function MinDigit (n:longint):integer (Pascal) и int MaxDigit (int n) (C/C++), function MaxDigit (n:longint):integer (Pascal), определяющую наименьшую и наибольшую цифры данного числа.
//
//Входные данные
//Задано единственное число N
//
//Выходные данные
//Необходимо вывести наименьшую и наибольшую цифры данного числа через пробел.
//*
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a Value: ");
        int val = s.nextInt();



        int number=val;
        int value1 = 0;
        int value2 = 0;
        for (    value1 = value2 = number % 10; number > 0; number = number / 10)
        {
            if (value1 > number % 10)
            {
                value1 = number % 10;
            }
            if (value2 < number % 10)
            {
                value2 = number % 10;
            }
        }
        System.out.print(  value1 + "   " + value2);
    }
}

