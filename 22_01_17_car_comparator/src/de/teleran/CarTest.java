package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testCompareTo_1() {
        Car car1 = new Car(2010, 300000);
        Car car2 = new Car(2015, 150000);

        assertTrue(car1.compareTo(car2) > 0);
    }
    @Test
    public void testCompareTo_2() {
        Car car1 = new Car(2015, 200999);
        Car car2 = new Car(2015, 200555);

        assertTrue(car1.compareTo(car2) > 0);
    }
    @Test
    public void testCompareEquality() {
        Car car1 = new Car(2015, 200000);
        Car car2 = new Car(2015, 200000);

        assertTrue(car1.compareTo(car2) == 0);
    }
}