package de.teleran;

import java.util.ArrayList;
import java.util.List;
//*/*Вася, Петя и Маша выдают кредиты. Маша тратит на каждый кредит от 100 до 150 милисекунд. Петя тратит на каждый кредит от 150 до 200 милисекунд. Вася в обычном расположении духа тратит на каждый кредит от 150 до 200 милисекунд, но иногда на него снисходит вдохновение, и он тратит на последующие 3 кредита от 50 до 100 милисекунд. Вероятность того, что Вася станет вдохновленным, если он не вдохновлен в данный момент, равняется 20%. Необходимо выдать 20 кредитов. Составить лист результов для работников.
////*
public class Main {

    private static final int CREDITS_NUM = 20;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> workers = new ArrayList<>();
        List<Score> result = new ArrayList<>();

        workers.add(new Thread(new Issuer("Masha", 100, 150, CREDITS_NUM, result)));
        workers.add(new Thread(new Issuer("Petya", 150, 200, CREDITS_NUM, result)));
        workers.add(new Thread(new CreativeIssuer("Vasya", 150, 200, CREDITS_NUM, result,
                50, 100, 3, 20)));

        for (Thread worker : workers)
            worker.start();

        for (Thread worker : workers)
            worker.join();

        for (Score speed : result) {
            System.out.println(speed.getName() + " : " + speed.getResult());
        }
    }
}