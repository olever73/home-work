package de.telran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
/*
есть класс Person с переменными String name and int salary. Написать коллектор, считающий суммарную зарплату
 всех персон. Подсказка: создать также класс Box c переменной value куда эта зарплата будет "собираться"*/

    public static void main(String[] args) {



    }
    //1.используя стримы написать метод, принимающий лист из нескольких дат типа Localdate
//и возвращающий количество дней между самой ранней и самой поздней датами
// long daysInBetween(List<LocalDate> dates)

     public static long daysInBetween(List<LocalDate> dates) {
         dates.stream()
                 .sorted();

         return  ChronoUnit.DAYS.between(dates.get(0), dates.get(1));
     }
//2. используя стримы написать метод, принимающий лист стрингов в формате "03 Jun 2015" и
// возвращающий упорядоченный по возрастанию дат лист стрингов в формате "Wed, 03 Jun 2015".
//метод должен сначала превратить эти строки в обьекты типа LocalDate, затем превратить эти обьекты
// вновь в строки вида  "Wed, 03 Jun 2015"

    public static List<String>listString( List<String>dates){
        return dates.stream()
                .map(x-> LocalDate.parse(x, DateTimeFormatter.ofPattern("dd MMM yyyy")))
                .sorted()
                .map(y-> DateTimeFormatter.ofPattern("EEE,d MMM yyyyy").format(y))
                .collect(Collectors.toList());

    }
    /*
есть класс Person с переменными String name and int salary. Написать коллектор, считающий суммарную зарплату
 всех персон. Подсказка: создать также класс Box c переменной value куда эта зарплата будет "собираться"*/
//https://ru.stackoverflow.com/questions/1055825/%D0%9F%D0%BE%D1%81%D1%87%D0%B8%D1%82%D0%B0%D1%82%D1%8C-%D1%81%D1%83%D0%BC%D0%BC%D0%B0%D1%80%D0%BD%D1%83%D1%8E-%D0%B7%D0%B0%D1%80%D0%BF%D0%BB%D0%B0%D1%82%D1%83-%D1%81%D0%BE%D1%82%D1%80%D1%83%D0%B4%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2-%D0%B2-%D0%BF%D0%BE%D0%B4%D1%80%D0%B0%D0%B7%D0%B4%D0%B5%D0%BB%D0%B5%D0%BD%D0%B8%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8E-stream-api


    }

