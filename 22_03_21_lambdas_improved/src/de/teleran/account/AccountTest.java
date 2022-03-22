package de.teleran.account;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Predicate<Account> posBalance = account -> account.getBalance() > 0;
    Predicate<Account> majorPredicate = account -> account.getBalance() > 100_000 && !account.isLocked();
    AccountFilter filter = new AccountFilter();

    Account A = new Account(10, 0.0, false);
    Account B = new Account(12, 0.0, true);
    Account C = new Account(13, 1.0, false);
    Account D = new Account(14, 1.0, true);
    Account F = new Account(15, 100000.0, false);
    Account E = new Account(16, 100000.0, true);
    Account K = new Account(17, 99999.0, false);
    Account L = new Account(18, 99999.0, true);
    Account M = new Account(19, 100001.0, false);
    Account N = new Account(20, 100001.0, true);
    List<Account> test = Arrays.asList(A,B,C,D,F,E,K,L,M,N);

    @Test
    public void test_emptyList() {
        List<Account> list = new ArrayList<>();
        assertTrue(filter.filter(list, posBalance).isEmpty());
        assertTrue(filter.filter(list, majorPredicate).isEmpty());
    }

    @Test
    public void test_positiveBalance() {
        List<Account> expected = Arrays.asList(C,D, F, E, K, L, M, N);
        assertEquals(expected, filter.filter(test, posBalance));
    }

    @Test
    public void test_majorPredicate() {
        List<Account> expected = Collections.singletonList(M);
        assertEquals(expected, filter.filter(test, majorPredicate));
    }
}