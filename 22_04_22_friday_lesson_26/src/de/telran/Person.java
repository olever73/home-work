package de.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

class Person {
    int salary;
    String name;
    Person() {}

    public Person(int i) {
        this.salary = i;
    }

    Person addSalary(Person p) {
        return new Person(this.salary = this.salary + p.salary);
    }

}

class PersonCollector implements Collector < Person, Person, Person > {
    @Override
    public Supplier < Person > supplier() {
        return Person::new;
    }

    @Override
    public BiConsumer < Person,
            Person > accumulator() {
        return Person::addSalary;
    }

    @Override
    public BinaryOperator < Person > combiner() {
        return Person::addSalary;
    }

    @Override
    public Function < Person,
            Person > finisher() {
        return Function.identity();
    }

    @Override
    public Set < Characteristics > characteristics() {
        return EnumSet.of(IDENTITY_FINISH);
    }
}
class Example {
    public static void main(String[] args) {
        Stream < Person > personStream = Stream.of(new Person(3000), new Person(4000), new Person(5000), new Person(8000));
        System.out.println(personStream.collect(new PersonCollector()).salary);

    }
}