package de.telran.work;

public class Main {
    public static void main(String[] args) {
        // №1 Написать функцию, которая определяет, является ли число простым (bolean isPrime(int number)). Простое число, это такое целое число, большее 1, которое делится только на себя и 1. Например, 2, 3, 5, 7, 11, 13, 17... Использовать стримы (подсказка: метод IntStream.range)

        //Есть 2 IntStream. Сделать третий стрим, который содержит числа из обоих стримов, делящиеся на 3 и на 5. Стрим должен быть отсортирован, и два первых числа должны быть пропущены

        //Посчитать факториал (функция, которая принимает число и возвращает число). Решить с помощью стримов (метод reduce)
        //Посчитать сумму нечетных числе от a до b
        //Есть class Transaction {String uuid, String state ("Cancelled", "Finished", "Processing"), long sum, long date}. И есть class Account{String uuid, long balance, List<Transaction> transactions}. Посчитать сумму денег всех отмененных транзакций для всех аккаунтов с балансом выше нуля. Сигнатура ф-ии: long function(List<Account> accounts)
        //Есть class Employee{String name, long Salary}, class Department{String name, String code, List<Employee> employees}. Посчитать общее число работников, чья зарплата >= определенного порога для всех департаментов, чей code начинается с "111-". int function(List<Department> accounts, long threshold)
        //Eсть class Account{String uuid, long sum, bool isLocked}. Необходимо заблокировать аккунты со слишком большой суммой денег. void function(List<Account> accounts, long threshold)

    }
}
