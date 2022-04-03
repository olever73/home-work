package de.telran;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args) {
    }

    // №1 Есть стрим Stream<Integer>. Посчитать сумму квадратов чисел из него. (Используя коллекторы)
    public int sumSqrt(Stream<Integer> stream) {
        return stream.mapToInt(x -> x * x).sum();      //stream.collect(summingInt(x -> x * x));
    }

    // №2 Есть стрим Stream<Integer>. Посчитать произведение квадратов чисел из него. (Используя коллекторы)
    public int multiplicationSqrt(Stream<Integer> stream) {
        return stream.collect(Collectors.reducing(1, (a, b) -> a * b * b));
    }

    /* №3.Есть лист строк.
       Получить из него Map<Boolean, List<String>>, напротив true в котором будут собраны все палиндромы из листа, а напротив false все остальное
       получить Map<Bolean, Long>, который в качестве значений содержит количества палиндромов и непалинромов.*/
    public static Map<Boolean, List<String>> palindrome( List<String> listOfword ) {
        Map<Boolean, List<String>> res =listOfword.stream()
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(
                        Collectors.partitioningBy(a -> a.equals(new StringBuilder(a).reverse().toString())));
        return res;
    }
    /*4. Есть class Transaction{String uuid; long sum; String accountUuid}.
        Посчитать сумму транзакций для каждого аккаунта.  Map<String, Long> totalTaransactionsByAccount
        */
    public Map<String, Long> totalTransactionsByAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(groupingBy(Transaction::getAccountUuid,
                        summingLong(Transaction::getSum)));


    }

   public static class Transaction {
        String uuid;
        long sum;
        String accountUuid;

        public String getUuid() {
            return uuid;
        }

        public long getSum() {
            return sum;
        }

        public String getAccountUuid() {
            return accountUuid;
        }

        public Transaction(String uuid, long sum, String accountUuid) {
            this.uuid = uuid;
            this.sum = sum;
            this.accountUuid = accountUuid;
        }
    }

}






