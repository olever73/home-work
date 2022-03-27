package de.telran.work.account;

import java.util.List;

public class AccountOperation {


    public void blockingAccountThreshold(List<Account> accounts, long threshold) {
        accounts.stream()
                .filter(account -> account.getSum() > threshold)
                .forEach(account -> account.setLocked(true));


    }

    public long sumBlockingAccounts( List<Account> accounts ){
        return accounts.stream()
                .filter(account -> account.isLocked())
                .mapToLong(account->account.getSum())
                .sum();

    }
}
