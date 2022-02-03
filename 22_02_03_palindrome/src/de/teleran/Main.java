package de.teleran;

import java.util.Scanner;
//*Напишите программу, которая определяет, является ли введённое слово (без пробелов) палиндромом, то есть верно ли, что оно читается одинаково слева направо и справа налево.
//
//Входные данные
//Входная строка содержит слово – последовательность символов без пробелов.
//
//Выходные данные
//Программа должна вывести слово 'YES', если введённое слово – палиндром, и слово 'NO', если оно не является палиндромом.
//*
public class Main {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);

        System.out.print("Введите данные: ");
        String string = input.nextLine();
        boolean notPalindrome = false;


        string = string.replaceAll("[^a-zA-Z]+", "").toLowerCase();

        char[] array = string.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            if (array[i] != array[j]) {
                notPalindrome = true;
                break;
            }
        }
        System.out.println(string + " is palindrome? " + !notPalindrome);
    }

}