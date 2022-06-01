package de.telran;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static javax.management.Query.value;

public class Work_3 {
    // есть класс Person с переменными String name and int salary. Написать коллектор, считающий суммарную зарплату
    // всех персон. Подсказка: создать также класс Box c переменной value куда эта зарплата будет "собираться"
    //Collector<>collector= Collector.of(
    //supp, accum,comb);

    List<Person> employees = Arrays.asList(
            new Person("Cersei", 250_000),
            new Person("Jamie", 150_000),
            new Person("Tyrion", 1_000),
            new Person("Tywin", 1_000_000),
            new Person("Jon Snow", 75_000),
            new Person("Robb", 120_000),
            new Person("Eddard", 125_000),
            new Person("Sansa", 0),
            new Person("Arya", 1_000));


    public static class Person {
        String name;
        int salary;

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public Person(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

    }

    static class Box {
        int value;

        public Box() {

        }

        public int getValue() {
            return value;
        }

        public Box(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Cersei", 250_000),
                new Person("Jamie", 150_000),
                new Person("Tyrion", 1_000),
                new Person("Tywin", 1_000_000),
                new Person("Jon Snow", 75_000),
                new Person("Robb", 120_000),
                new Person("Eddard", 125_000),
                new Person("Sansa", 0),
                new Person("Arya", 1_000));
        int total = persons.stream().mapToInt(Person::getSalary).sum();
        System.out.println(total);
       }

    public interface Collector<T,A,R> {
        Supplier<A> supplier();
        BiConsumer<A,T> accumulator();
        BinaryOperator<A> combiner();
        Function<A,R> finisher();
        Set<java.util.stream.Collector.Characteristics> characteristics();
    }


}



