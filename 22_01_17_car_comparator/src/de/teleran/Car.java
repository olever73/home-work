package de.teleran;

//TODO create a comparator, which compares two cars. The car must be of a higher priority, if it has newer year
// km and then it has less km.
public class Car implements Comparable<Car> {
    int km;
    int year;

    public int getKm() {
        return km;
    }

    public int getYear() {
        return year;
    }

    public Car( int year, int km) {
        this.km = km;
        this.year = year;
    }

    public int compareTo(Car o) {
        int res =o.year - this.year;
        if (res != 0)
            return res;
        return this.km-o.km;
    }

    public String toString() {
        return "Car{" + "year='" + year + '\'' + ", km=" + km + '}';

    }
}
