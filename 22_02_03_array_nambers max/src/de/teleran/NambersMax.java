package de.teleran;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//*Задача №68. Количество элементов больших обоих соседей
//Числа следует выводить через пробел. Все числа целые, по модулю не больше 231-1. Количество элементов массива не превышает 10000.
//Дан массив, состоящий из целых чисел. Напишите программу, которая в данном массиве определит количество элементов, у которых два соседних и, при этом, оба соседних элемента меньше данного.
//
//Входные данные
//Сначала задано число N — количество элементов в массиве (1≤N≤100). Далее через пробел записаны N чисел — элементы массива. Массив состоит из целых чисел.
//
//Выходные данные
//Необходимо вывести количество элементов массива, у которых два соседа и которые при этом строго больше обоих своих соседей.
//*

public class NambersMax {

        static int extrema(int a[], int size)
        {
            int count = 0;

            for (int i = 1; i < size - 1; i++)
            {

                if(a[i - 1] < a[i]&& a[i]> a[i + 1])
                    count ++;
            }

            return count;
        }


        public static void main(String args[])
                throws IOException
        {

            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Input Array Size : ");
                int size = sc.nextInt();

                int[] a = new int[size];
                System.out.println("Insert "+size+" Elements of the Array");
                for (int i = 0; i < size; i++) {
                    System.out.print("Element "+i+" : ");
                    a[i] = sc.nextInt();
                }

                System.out.println(size + "\n" +extrema(a, size));
            } finally {
                sc.close();
            }
        }
    }







