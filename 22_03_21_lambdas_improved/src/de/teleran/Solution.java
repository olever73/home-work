package de.teleran;

import de.teleran.account.Account;
import de.teleran.function.TernaryIntPredicate;
import de.teleran.function.UniqNumbersPredicate;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {

        // 1.Используя замыкание, написать Function<Double, Double>, которая считает ax^2 + bx + c
        int a = 3;
        int b = -1;
        int c = 16;
        Function<Double, Double> f = x -> a * x * x + b * x + c;
        System.out.println(f.apply(5.0));//86

        //2.Есть класс Account, у него есть поля int id, double balance, bool isLocked.
        // Написать два лямбда выражения Function<List<Account>, List<Account>>,
        // 1. отфильтровывает аккаунты таким образом, что остаются только аккаунты с положительным баллансом;
        // 2. все незаблокированные аккаунты с балансом более 100000.
        Predicate<Account> posBalance = account -> account.getBalance() > 0;
        Predicate<Account> majorPredicate = account -> account.getBalance() > 100_000 && !account.isLocked();
        //3.	Написать интерфейс TernaryIntPredicate с методом bool test(int a, int b, int c).
        // Написать лямбда выражение, которое вернет true, если все аргументы различны.
        TernaryIntPredicate explicitUniqNumbersPredicate = new UniqNumbersPredicate();
        System.out.println(explicitUniqNumbersPredicate.test(1, 2, 3));// true
        System.out.println(explicitUniqNumbersPredicate.test(1, 2, 2));// false

        TernaryIntPredicate implicitUniqNumbersPredicate = (x, y, z) -> x != y && y != z && x != z;
        System.out.println(implicitUniqNumbersPredicate.test(1, 2, 3));// true
        System.out.println(implicitUniqNumbersPredicate.test(1, 2, 2));// false

       //4.	Написать функцию, которая считает <2x> и функцию, которая считает <x + 3>.
       // Написать функцию, которая будет композицией первых двух
        Function<Double, Double> fo = x -> 2*x;
        Function<Double, Double> g = x ->  x +3;
        Function<Double, Double> h1 = fo.compose(g);
        Function<Double, Double> anotherH = g.andThen(fo);
        System.out.println(h1.apply(5.0));//16
        System.out.println(anotherH.apply(5.0));//16
      //5.	Написать класс PredicateService и методы в нем intersect и union, которые принимают лист предикатов,
     // а возвращают их пересечение и объединение соответственно. Протестировать.
        PredicateService predicateService = new PredicateService();
        Predicate<Double> pr1 = (x -> x % 2 == 0);
        Predicate<Double> pr2 = (x -> x % 3 == 0);
        Predicate<Double> pr3 = (x -> x < 30);
        Predicate<Double> pr4 = (x -> x > 10);
        List<Predicate<Double>> list = Arrays.asList(pr1, pr2, pr3, pr4);
        System.out.println(predicateService.intersect(list).test(12.0));
        System.out.println(predicateService.intersect(list).test(25.0));
    }
}
