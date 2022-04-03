package de.telran;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution s=new Solution();

    @Test
    public void test_sumSqrt() {
        Stream<Integer> numbers1= Stream.of(7, 8, 9, 10,11);
        assertEquals(415, s.sumSqrt(numbers1));
    }

    @Test
    public void test_multiplySqrt() {
        Stream<Integer>  numbers2= Stream.of(3,4,5,6,7);
        assertEquals(6350400, s.multiplicationSqrt(numbers2));
    }

    @Test
    void verify() {
        List<String> list = Arrays.asList("ehe", "aha", "ufo", "sort");
        Map<Boolean, List<String>> res = s.palindrome(list);
        List<String> listTrue = Arrays.asList("ehe", "aha");
        List<String> listFalse = Arrays.asList("ufo", "sort");
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }

    @Test
    void verify_onlyTrue() {
        List<String> list = Arrays.asList("Madam", "Semes");
        Map<Boolean, List<String>> res = s.palindrome(list);
        List<String> listTrue = Arrays.asList("madam", "semes");
        List<String> listFalse = Collections.emptyList();
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }

    @Test
    public void palindromFilter_test1() {
        List<String> list = Arrays.asList("sos", "hello", "mif", "level", "madam", "op",
                "noon", "twenty");
        Map<Boolean, List<String>> res = new HashMap<>();
        res.put(false, Arrays.asList("hello", "mif", "op", "twenty"));
        res.put(true, Arrays.asList("sos", "level", "madam", "noon"));

        assertEquals(res, s.palindrome(list));
    }
    @Test
    public void sumTransactions_test() {
    List<Solution.Transaction> transactions = Arrays.asList(
            new Solution.Transaction("001",12L, "AN"),
            new Solution.Transaction("003",15L, "AN"),
            new Solution.Transaction("002",16L, "BA"),
            new Solution.Transaction("004",20L, "BA"),
            new Solution.Transaction("005",10L, "AN"),
            new Solution.Transaction("007",50L, "BA"),
            new Solution.Transaction("009",10L, "OO"),
            new Solution.Transaction("010",50L, "OO"));

        Map<String, Long> result = s.totalTransactionsByAccount(transactions);

        assertEquals(37L, result.get("AN"));
        assertEquals(86L, result.get("BA"));
        assertEquals(60L, result.get("OO"));
    }

}
