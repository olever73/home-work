package de.teleran;

public class Main {



    public static void main(String[] args) {
        functionPrintCreditNumber(30);

    }
//Если номер кредита делится на 13, то его никто не выдает. Если он делится на 3, то его выдает Маша.
// Если номер кредита имеет остаток 1 от деления на 3, то Петя, если 2 - то Вася.
// Написать функцию, которая принимает номер последнего выданного кредита и распечатывает в консоль информацию о том,
// кто выдал какой кредит и еще количество выданных кредитов после этого. static void function(int creditId)

    static void functionPrintCreditNumber(int lastCreditNumber) {
        if (lastCreditNumber % 13 == 0) {
            System.out.println(" Номер кредита" + lastCreditNumber + " нникто не выдает");
            return;
        }

        int numberGivenCredits = 0;
        for (int i = 1; i <= lastCreditNumber; i++) {
            if (i % 13 == 0) {
                continue;
            }

            int remainderFrom3 = i % 3;
            if (remainderFrom3 == 0) {
                System.out.println("Номер кредита " + i + " выдает Маша");
            } else if (remainderFrom3 == 1) {
                System.out.println("Номер кредита " + i + " выдает Петя");
            } else {
                System.out.println("Номер кредита " + i + "  выдает Вася ");
            }
            numberGivenCredits++;
        }
        System.out.println("Количество всех предоставленных кредитов " + numberGivenCredits);
    }
}