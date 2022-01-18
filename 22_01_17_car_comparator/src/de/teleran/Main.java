package de.teleran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car(2014,100000),
                new Car(2015, 150000), new Car(2010, 300000));
        Collections.sort(cars);
        Arrays.sort(cars.toArray());
        System.out.println(cars);

//        Collections.sort(cars, );
        List<News> news = Arrays.asList(new News("Java", 0),new News("Hello", 3),
        new News("Hello world", 7) );
        Collections.sort(news);
        Arrays.sort(news.toArray());
        System.out.println(news);
    }
}