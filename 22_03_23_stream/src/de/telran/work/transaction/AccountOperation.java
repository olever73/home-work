package de.telran.work.transaction;

import java.util.List;

public class AccountOperation {


    public long getSumAllCancelledTransactions(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())

                .filter(transaction -> transaction.getState().equals(State.CANCELLED))
                .reduce(0L, (result, transaction) -> result + transaction.getSum(), Long::sum);




    }
}
