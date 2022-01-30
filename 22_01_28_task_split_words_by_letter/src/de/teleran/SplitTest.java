package de.teleran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitTest {

        Split split = new Split();

        List<String> stringInput = new ArrayList<>();


        @Test
        public void test_Dictionary1() {
            Collections.addAll(stringInput, "рамма","ягода","яма", "ранг","расчёт", "яблоко","ринг",  "росток","риск"  );
            List<List<String>> output = split.splitWords(stringInput);
            List<List<String>> exp = new ArrayList();


            exp.add(Arrays.asList("рамма","ранг","расчёт", "ринг","риск",  "росток"));
            exp.add(Arrays.asList("яблоко", "ягода", "яма"));
            assertEquals(exp, output);
        }

        @Test
        public void test_Dictionary2() {
            Collections.addAll(stringInput, "ягода","задача","алмаз","банан","глина","ария", "артика", "глаз", "крот");
            List<List<String>> output = split.splitWords(stringInput);
            List<List<String>> exp = new ArrayList();
            exp.add(Arrays.asList("алмаз","ария","артика"));
            exp.add(Arrays.asList("банан"));
            exp.add(Arrays.asList("глаз","глина"));
            exp.add(Arrays.asList("задача"));
            exp.add(Arrays.asList("крот"));
            exp.add(Arrays.asList("ягода"));
            assertEquals(exp, output);
        }


    }

