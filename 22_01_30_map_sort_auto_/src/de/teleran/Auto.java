package de.teleran;

//2.(*)Есть класс автомобиль, в котором есть два три поля: Марка, Модель, Цена.
// Написать функцию, которая принимает лист автомобилей, а возвращает TreeMap,
// ключами которого являются марки автомобилей, а значениями будут TreeSet автомобилей,
// в котором автомобили расположены в лексикографическом порядке относительно модели,
// причем дешевые вперед (необходимо написать правильный компаратор,
// который будет складывать автомобили в TreeSet в правильном порядке


import java.util.Objects;

public class Auto {
    private String make;
    private String model;
    private long price;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public long getPrice() {
        return price;
    }

    public Auto(String make, String model, long price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return price == auto.price && Objects.equals(make, auto.make) && Objects.equals(model, auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, price);
    }
}