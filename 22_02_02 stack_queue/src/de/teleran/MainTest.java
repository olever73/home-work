package de.teleran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Main m;

    @BeforeEach
    public void init(){m=new Main();}


    @Test
    public void  balancedBrackets_test_two_round_two_square_two_more(){
        String str="([{}]))";

        assertFalse(m.balancedBrackets(str));
    }
    @Test
    public void  balancedBrackets_test_two_wrong(){
        String str="(([{])";

        assertFalse(m.balancedBrackets(str));
    }
    @Test
    public void  balancedBrackets_test_with_letters(){
        String str="([{b}drft]r)i";

        assertTrue(m.balancedBrackets(str));
    }
    @Test
    public void  balancedBrackets_test_one_bracket(){
        String str="([{}])";

        assertTrue(m.balancedBrackets(str));
    }


}
