package de.teleran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class NoNumberPair {


    public int singleNumber(List<Integer> ints) {
        Map<Integer, Integer> qtyByNumber = new HashMap<>();

        for (int num : ints) {
            if (!qtyByNumber.containsKey(num)) {
                qtyByNumber.put(num, 1);
            } else {

                qtyByNumber.put(num, qtyByNumber.get(num) + 1);
            }
        }

        for (int num : qtyByNumber.keySet()) {
            if (qtyByNumber.get(num) % 2 == 1)
                return num;
        }
        return 0;
    }

}

