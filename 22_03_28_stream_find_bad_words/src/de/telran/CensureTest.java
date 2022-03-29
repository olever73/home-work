package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensureTest {

    Collection<String> badWords = Arrays.asList("violence", "sTOP", "spam");
    Censure censure = new Censure(badWords);

   @Test
   void _test_findbad_words_1() {
       String text = "Every new killing was excused  sPam on the grounds that we were building" +
               " a remarkable «new» world in which there would be no more violence";
       List<String> result = Arrays.asList("spam","violence" );

       assertEquals(result, censure.findBadWords(text));

   }
    @Test
    void _test_findbad_words_2() {
        String text = "STOP Every new killing was excused   on the grounds that we were building" +
                " a remarkable  «new» world in which there would be no more violence";
        List<String> result = Arrays.asList("stop","violence" );

        assertEquals(result, censure.findBadWords(text));

    }

    @Test
    void _test_findbad_words_3() {
        String text = "Every new killing was excused   on the grounds that we were building" +
                " a remarkable  «new» world in which there would be no more ";
        List<String> result = Arrays.asList();

        assertEquals(result, censure.findBadWords(text));

    }

   }

